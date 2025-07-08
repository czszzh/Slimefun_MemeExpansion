package me.czssj_.meme_expansion.Expansion.Boss;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.NonNull;
import me.czssj_.meme_expansion.Meme_Expansion;
import me.czssj_.meme_expansion.Expansion.Utils.msgUtils;
import me.czssj_.meme_expansion.setup.Meme_Expansion_item;

public class Or_PVP_Boss extends SlimefunItem implements Listener, RecipeDisplayItem
{
    public Or_PVP_Boss(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() 
    {
        ItemUseHandler itemUseHandler = this::itemRightClick;
        addItemHandler(itemUseHandler);
        Bukkit.getPluginManager().registerEvents(this, Meme_Expansion.getInstance());
    }

    private void itemRightClick(PlayerRightClickEvent event)
    {
        @NonNull Optional<Block> block = event.getClickedBlock();
        Location location = block.get().getLocation().add(0.5, 1, 0.5);
        Player p = event.getPlayer();
        if(event.getItem().getAmount() > 1) 
        {
            event.getItem().setAmount(event.getItem().getAmount() - 1);
        }
        else 
        {
            p.getInventory().remove(event.getItem());
        }
        spawnBoss(location, p);
        event.cancel();
    }

    private void spawnBoss(@NonNull Location location, @NonNull Player p)
    {
        Zombie boss = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);
        AttributeInstance maxHealthAttribute = boss.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if(maxHealthAttribute != null) 
        {
            maxHealthAttribute.setBaseValue(1000);
        }
        boss.setHealth(1000);
        boss.setAdult();
        boss.setCanPickupItems(false);
        EntityEquipment equipment = boss.getEquipment();
        equipment.setArmorContents(new ItemStack[] { 
            new ItemStack(Material.NETHERITE_BOOTS), new ItemStack(Material.NETHERITE_LEGGINGS),new ItemStack(Material.NETHERITE_CHESTPLATE), new ItemStack(Material.NETHERITE_HELMET) 
        });
        boss.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(10);
        boss.setCustomName(ChatColor.RED + "PVP大佬");
        boss.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 2));

        BossBar bossBar = Bukkit.createBossBar(boss.getCustomName(), BarColor.RED, BarStyle.SOLID);
        bossBar.setProgress(1.0);
        //bossBar.addPlayer(p);
        updateBossBarForNearbyPlayers(boss, bossBar);

        new BukkitRunnable() 
        {
            @Override
            public void run() 
            {
                if(!boss.isDead()) 
                {
                    bossBar.setProgress(boss.getHealth() / boss.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                    updateBossBarForNearbyPlayers(boss, bossBar);
                } 
                else 
                {
                    bossBar.removeAll();
                    bossBar.setVisible(false);
                    this.cancel();
                }
            }
        }.runTaskTimer(Meme_Expansion.getInstance(), 0, 10);

        new BukkitRunnable() 
        {
            @Override
            public void run() 
            {
                if(!boss.isDead())
                {
                    long redCNT = location.getWorld().getEntitiesByClass(Zombie.class).stream().filter(zombie -> !zombie.equals(boss) && zombie.getLocation().distance(boss.getLocation()) <= 20.0).count();
                    if(redCNT > 0)
                    {
                        boss.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,Integer.MAX_VALUE,114,true,true,true));
                    }
                    else
                    {
                        boss.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                    }

                    ItemStack redLeatherHelmet = new ItemStack(Material.LEATHER_HELMET);
                    LeatherArmorMeta helmetMeta = (LeatherArmorMeta) redLeatherHelmet.getItemMeta();
                    if(helmetMeta != null) 
                    {
                        helmetMeta.setColor(Color.fromRGB(255, 0, 0));
                        redLeatherHelmet.setItemMeta(helmetMeta);
                    }

                    for(int i=0;i<Math.random()*2;i++) 
                    {
                        /*
                        //最初的想法
                        double x = (Math.random()-0.5)*5;
                        double z = (Math.random()-0.5)*5;
                        //Location spawnLocation = boss.getLocation().add(x, 0, z); 
                        */
                        
                        //在boss生成位置上生成普通僵尸(红队)
                        Zombie red = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);
                        EntityEquipment redequipment = red.getEquipment();
                        redequipment.setArmorContents(new ItemStack[] { 
                            null,null,null, redLeatherHelmet 
                        });
                        //red.setCustomName(ChatColor.RED + "红队");
                    }

                    for(Player player : boss.getLocation().getWorld().getPlayers()) 
                    {
                        if(player.getLocation().distance(boss.getLocation()) <= 40.0) 
                        {
                            player.sendTitle(ChatColor.WHITE + "还是PVP大佬", "", 10, 30, 10);
                        } 
                        
                    }
                }
                else
                {
                    this.cancel();
                }
            }
        }.runTaskTimer(Meme_Expansion.getInstance(), 0, 100);
    }

    private void updateBossBarForNearbyPlayers(Zombie boss, BossBar bossBar) 
    {
        for(Player player : boss.getLocation().getWorld().getPlayers()) 
        {
            if(player.getLocation().distance(boss.getLocation()) <= 40.0) 
            {
                bossBar.addPlayer(player);
            } 
            else
            {
                bossBar.removePlayer(player);
            }
        }
    }

    @EventHandler
    public void onBossDeath(EntityDeathEvent event)
    {
        if(event.getEntity() instanceof Zombie zombie)
        {
            //Zombie zombie = (Zombie) event.getEntity();
            if(zombie.getCustomName() != null && zombie.getCustomName().equals(ChatColor.RED + "PVP大佬"))
            {
                event.getDrops().clear();
                event.getDrops().add(Meme_Expansion_item.ORPVPBOSS_STAR);
            }
        }
    }
    
    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent event)
    {
        if(event.getEntity() instanceof Zombie boss && boss.getCustomName() != null && boss.getCustomName().equals(ChatColor.RED + "PVP大佬"))
        {
            if(boss.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE))
            {
                if(event.getDamager() instanceof Player player)
                {
                    //player.sendTitle("", "你必须优先攻击具有嘲讽的随从", 0, 15, 0);
                    msgUtils.sendActionBar(player, "§f你必须优先攻击具有嘲讽的随从");
                }
            }
        }
    }
    
    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() 
    {
        List<ItemStack> displayRecipes = new ArrayList<>();
        displayRecipes.add(new CustomItemStack(Material.PAPER, "§3血厚一点的僵尸"));
        displayRecipes.add(new CustomItemStack(Material.ZOMBIE_HEAD, "§f会召唤僵尸,周围20格内有僵尸时会拥有抗性提升效果","§3不过好像有时候会失效("));
        return displayRecipes;
    }
}
