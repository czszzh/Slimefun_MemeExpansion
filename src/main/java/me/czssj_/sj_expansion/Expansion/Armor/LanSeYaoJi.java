package me.czssj_.sj_expansion.Expansion.Armor;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.atomic.AtomicInteger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.slimefun4.api.items.HashedArmorpiece;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;

public class LanSeYaoJi extends SlimefunItem implements Runnable
{
    public LanSeYaoJi(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) 
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void run() 
    {
        for (Player p : Bukkit.getOnlinePlayers()) 
        {
            if (!p.isValid() || p.isDead()) 
            {
                continue;
            }
            //p.sendMessage("player get");
            PlayerProfile.get(p, profile -> {
                ItemStack[] armor = p.getInventory().getArmorContents();
                HashedArmorpiece[] cachedArmor = profile.getArmor();
                handleArmor(p, armor, cachedArmor);
            });
        }
    }

    @ParametersAreNonnullByDefault
    private void handleArmor(Player p, ItemStack[] armor, HashedArmorpiece[] cachedArmor) 
    {
        AtomicInteger count = new AtomicInteger(0);

        for (int slot = 0; slot < 4; slot++) 
        {
            ItemStack item = armor[slot];
            HashedArmorpiece armorpiece = cachedArmor[slot];

            if (armorpiece.hasDiverged(item)) 
            {
                SlimefunItem sfItem = SlimefunItem.getByItem(item);
                if (!(sfItem instanceof LanSeYaoJi)) 
                {
                    sfItem = null;
                }
                armorpiece.update(item, sfItem);
            }

            if (item != null && armorpiece.getItem().isPresent()) 
            {
                Slimefun.runSync(() -> {
                    SlimefunItem sfItem = SlimefunItem.getByItem(item);
                    if (sfItem != null && (sfItem.getId().equals("EXPANSION_BLUE_SUIT") || sfItem.getId().equals("EXPANSION_BLUE_PANTS") || sfItem.getId().equals("EXPANSION_QIE_ER_XI"))) 
                    {
                        count.incrementAndGet();
                        //p.sendMessage("检测数量:"+ count.get());
                    }
                });
                
            }
        }
        //p.sendMessage("总数量:"+ count.get());
        applySpeedEffects(p, count.get());
    }

    private void applySpeedEffects(@Nonnull Player p, int count) 
    {
        p.removePotionEffect(PotionEffectType.SPEED);

        switch (count) 
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
}
