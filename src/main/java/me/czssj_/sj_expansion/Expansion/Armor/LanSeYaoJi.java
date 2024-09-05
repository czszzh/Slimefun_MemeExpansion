package me.czssj_.sj_expansion.Expansion.Armor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.slimefun4.api.items.HashedArmorpiece;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;

public class LanSeYaoJi implements Runnable
{
    private final Set<PotionEffect> customEffects;

    public LanSeYaoJi() 
    {
        Set<PotionEffect> effects = new HashSet<>();
        // 初始化套装效果
        effects.add(new PotionEffect(PotionEffectType.SPEED, 300, 1));
        customEffects = Collections.unmodifiableSet(effects);
    }

    @Override
    public void run() 
    {
        for (Player p : Bukkit.getOnlinePlayers()) 
        {
            if (!p.isValid() || p.isDead()) {
                continue;
            }

            PlayerProfile.get(p, profile -> {
                ItemStack[] armor = p.getInventory().getArmorContents();
                checkForArmor(p, armor);
            });
        }
    }

    @ParametersAreNonnullByDefault
    private void checkForArmor(Player p, ItemStack[] armor) 
    {
        boolean hasBlueSuit = false;
        boolean hasBluePants = false;
        boolean hasQieErXi = false;

        for (ItemStack item : armor) 
        {
            if (item == null) continue;

            SlimefunItem sfItem = SlimefunItem.getByItem(item);
            if (sfItem == null) continue;

            if (sfItem.getId().equals("EXPANSION_BLUE_SUIT")) 
            {
                hasBlueSuit = true;
            } 
            else if (sfItem.getId().equals("EXPANSION_BLUE_PANTS")) 
            {
                hasBluePants = true;
            } 
            else if (sfItem.getId().equals("EXPANSION_QIE_ER_XI")) 
            {
                hasQieErXi = true;
            }
        }

        if (hasBlueSuit && hasBluePants && hasQieErXi) 
        {
            applyCustomEffects(p);
        }
    }

    private void applyCustomEffects(@Nonnull Player p) 
    {
        for (PotionEffect effect : customEffects) 
        {
            p.removePotionEffect(effect.getType());
            p.addPotionEffect(effect);
        }
    }
}
