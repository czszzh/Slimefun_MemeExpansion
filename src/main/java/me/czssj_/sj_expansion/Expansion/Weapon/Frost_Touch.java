package me.czssj_.sj_expansion.Expansion.Weapon;

import javax.annotation.Nonnull;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.WeaponUseHandler;
import me.czssj_.sj_expansion.sj_Expansion;

public class Frost_Touch extends SlimefunItem implements WeaponUseHandler, Listener
{
    private Random random = new Random();
    private Map<UUID, BukkitRunnable> taskMap = new HashMap<>();

    public Frost_Touch(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister()
    {
        WeaponUseHandler weaponUseHandler = this::onHit;
        addItemHandler(weaponUseHandler);
        Bukkit.getPluginManager().registerEvents(this, sj_Expansion.getInstance());
    }

    @Override
    public void onHit(@Nonnull EntityDamageByEntityEvent e, @Nonnull Player player, @Nonnull ItemStack item) 
    {
        if (e.getEntity() instanceof LivingEntity) 
        {
            LivingEntity target = (LivingEntity) e.getEntity();
            Location targetLocation = target.getLocation();
            Block targetBlock = targetLocation.clone().add(0, 1, 0).getBlock();

            if (random.nextDouble() < 0.1)
            {
                Material originalMaterial = targetBlock.getType();
                targetBlock.setType(Material.POWDER_SNOW);
                target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*3, 10));
                Bukkit.getScheduler().runTaskLater(sj_Expansion.getInstance(), () -> {
                    targetBlock.setType(originalMaterial);
                }, 20*3);
            }
        }
    }

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event)
    {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getInventory().getItem(event.getNewSlot());
        SlimefunItem sfItem = SlimefunItem.getByItem(mainHandItem);

        if (sfItem != null && sfItem.getId().equals("FROST_TOUCH")) 
        {
            startDamageTask(player);
        } 
        else 
        {
            stopDamageTask(player);
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
                    Particle.DustOptions dustOptions = new Particle.DustOptions(Color.BLUE, 2);
                    player.spawnParticle(Particle.REDSTONE, player.getLocation(), 300, 1.5, 0, 1.5, 0.1, dustOptions);
                    for (Entity entity : player.getNearbyEntities(2, 2, 2)) 
                    {
                        if (entity instanceof LivingEntity) 
                        {
                            ((LivingEntity) entity).damage(1);
                        }
                    }
                }
            };
            task.runTaskTimer(sj_Expansion.getInstance(), 0, 20);
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
