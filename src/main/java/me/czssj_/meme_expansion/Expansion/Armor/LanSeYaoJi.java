package me.czssj_.meme_expansion.Expansion.Armor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.czssj_.meme_expansion.Meme_Expansion;

public class LanSeYaoJi extends SlimefunItem implements Listener, RecipeDisplayItem
{
    private Map<UUID, BukkitRunnable> taskMap = new HashMap<>();

    public LanSeYaoJi(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) 
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister()
    {
        Bukkit.getPluginManager().registerEvents(this, Meme_Expansion.getInstance());
        new BukkitRunnable() 
        {
            @Override
            public void run() 
            {
                for (Player p : Bukkit.getOnlinePlayers()) 
                {
                    int num = 0;
                    ItemStack[] armor = p.getInventory().getArmorContents();
                    for (int i=0; i<4; i++)
                    {
                        if(armor[i] != null)
                        {
                            num = num + 1;
                        }
                    }
                    if(num != 0)
                    {
                        applySpeedEffects(p);
                    }
                    else
                    {
                        stopTask(p);
                        num = 0;
                    }
                }
            }
        }.runTaskTimer(Meme_Expansion.getInstance(), 0, 100);
    }

    private void applySpeedEffects(Player p) 
    {
        UUID playerId = p.getUniqueId();
        if (!taskMap.containsKey(playerId))
        {
            BukkitRunnable task = new BukkitRunnable()
            {
                @Override
                public void run() 
                {
                    int num = 0;
                    ItemStack boots = p.getInventory().getBoots();
                    ItemStack chestplate = p.getInventory().getChestplate();
                    ItemStack leggings = p.getInventory().getLeggings();
                    SlimefunItem sfboots = SlimefunItem.getByItem(boots);
                    SlimefunItem sfleggings = SlimefunItem.getByItem(leggings);
                    SlimefunItem sfchestplate = SlimefunItem.getByItem(chestplate);

                    if (sfboots != null && sfboots.getId().equals("EXPANSION_QIE_ER_XI")) 
                    {
                        num = num + 1;
                    } 
                    if (sfleggings != null && sfleggings.getId().equals("EXPANSION_BLUE_PANTS")) 
                    {
                        num = num + 1;
                    }
                    if (sfchestplate != null && sfchestplate.getId().equals("EXPANSION_BLUE_SUIT"))
                    {
                        num = num + 1;
                    }
                    
                    p.removePotionEffect(PotionEffectType.SPEED);
                    switch (num) 
                    {
                        case 1:
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 1));
                            break;
                        case 2:
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 2));
                            break;
                        case 3:
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 4));
                            break;
                    }
                }
            };
            task.runTaskTimer(Meme_Expansion.getInstance(), 0, 100);
            taskMap.put(playerId, task); 
        } 
    }

    private void stopTask(Player p) 
    {
        UUID playerId = p.getUniqueId();
        BukkitRunnable task = taskMap.remove(playerId);
        if (task != null) 
        {
            task.cancel();
        }
    }

    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() 
    {
        List<ItemStack> displayRecipes = new ArrayList<>();
        displayRecipes.add(new CustomItemStack(Material.PAPER, "§b蓝色妖姬套装"));
        displayRecipes.add(new CustomItemStack(Material.EGG, "§f套装效果:","§3穿上一件时: §f获得速度II效果","§3穿上两件时: §f获得速度III效果","§3穿上三件时: §f获得速度V效果"));
        return displayRecipes;
    }
}
