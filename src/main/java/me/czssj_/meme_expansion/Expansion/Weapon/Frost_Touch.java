package me.czssj_.meme_expansion.Expansion.Weapon;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.WeaponUseHandler;
import me.czssj_.meme_expansion.Expansion.Utils.msgUtils;
import me.czssj_.meme_expansion.Meme_Expansion;

public class Frost_Touch extends SlimefunItem implements WeaponUseHandler, Listener
{
    Random random = new Random();
    Map<UUID, BukkitRunnable> taskMap = new HashMap<>();

    public Frost_Touch(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister()
    {
        WeaponUseHandler weaponUseHandler = this::onHit;
        addItemHandler(weaponUseHandler);
        Bukkit.getPluginManager().registerEvents(this, Meme_Expansion.getInstance());
        new BukkitRunnable() 
        {
            @Override
            public void run() 
            {
                for (Player player : Bukkit.getOnlinePlayers()) 
                {
                    ItemStack mainHandItem = player.getInventory().getItemInMainHand();
                    ItemStack offHandItem = player.getInventory().getItemInOffHand();
                    SlimefunItem sfItem1 = SlimefunItem.getByItem(mainHandItem);
                    SlimefunItem sfItem2 = SlimefunItem.getByItem(offHandItem);

                    if ((sfItem1 != null && sfItem1.getId().equals("EXPANSION_FROST_TOUCH")) || (sfItem2 != null && sfItem2.getId().equals("EXPANSION_FROST_TOUCH"))) 
                    {
                        startDamageTask(player);
                    } 
                    else 
                    {
                        stopDamageTask(player);
                    }
                }
            }
        }.runTaskTimer(Meme_Expansion.getInstance(), 0, 20);
    }

    @Override
    public void onHit(@Nonnull EntityDamageByEntityEvent e, @Nonnull Player player, @Nonnull ItemStack item) 
    {
        if (e.getEntity() instanceof LivingEntity target) 
        {
            Location targetLocation = target.getLocation();

            if (random.nextDouble() < 0.2)
            {
                msgUtils.sendActionBar(player, "§9§lFreeze!!");
                if(target instanceof Player)
                {
                    target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*5, 114514));
                    target.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20*5, -114514));
                    target.setFreezeTicks(100);
                    target.getWorld().playEffect(target.getLocation(), Effect.STEP_SOUND, Material.ICE);
                    target.getWorld().playEffect(target.getEyeLocation(), Effect.STEP_SOUND, Material.ICE);

                    /* 
                    for(int y=0;y<=1;y++)
                    {
                        Block targetBlock = targetLocation.clone().add(0,y,0).getBlock();
                        if(targetBlock.getType() == Material.AIR)
                        {
                            targetBlock.setType(Material.POWDER_SNOW);
                        }
                    }
                    
                    Bukkit.getScheduler().runTaskLater(Meme_Expansion.getInstance(), () -> {
                        target.setFreezeTicks(0);
                        for(int y=0;y<=1;y++)
                        {
                            Block targetBlock = targetLocation.clone().add(0,y,0).getBlock();
                            if(targetBlock.getType() == Material.POWDER_SNOW)
                            {
                                targetBlock.setType(Material.AIR);
                            }
                        }
                    }, 20*5);
                    */
                }
                else
                {
                    target.getWorld().playEffect(target.getLocation(), Effect.STEP_SOUND, Material.ICE);
                    target.getWorld().playEffect(target.getEyeLocation(), Effect.STEP_SOUND, Material.ICE);
                    target.setAI(false);
                    /* 
                    Block targetBlock = targetLocation.getBlock();
                    if(targetBlock.getType() == Material.AIR)
                    {
                        targetBlock.setType(Material.POWDER_SNOW);
                    }
                    */
                    Bukkit.getScheduler().runTaskLater(Meme_Expansion.getInstance(), () -> {
                        target.setAI(true);
                        //targetBlock.setType(Material.AIR);
                    }, 20*5);
                    
                }
            }
        }
    }
    
    private void startDamageTask(Player player) 
    {
        UUID playerId = player.getUniqueId();
        if (!taskMap.containsKey(playerId)) 
        {
            BukkitRunnable task = new BukkitRunnable() 
            {
                @Override
                public void run() 
                {
                    Particle.DustOptions dustOptions = new Particle.DustOptions(Color.BLUE, 1);
                    player.spawnParticle(Particle.REDSTONE, player.getLocation(), 150, 1.2, 0, 1.2, 0.1, dustOptions);
                    for (Entity entity : player.getNearbyEntities(2, 2, 2)) 
                    {
                        if (entity instanceof LivingEntity livingEntity) 
                        {
                            livingEntity.damage(1);
                        }
                    }
                }
            };
            task.runTaskTimer(Meme_Expansion.getInstance(), 0, 20);
            taskMap.put(playerId, task);
        }
    }

    private void stopDamageTask(Player player) 
    {
        UUID playerId = player.getUniqueId();
        BukkitRunnable task = taskMap.remove(playerId);
        if (task != null) 
        {
            task.cancel();
        }
    }
}
