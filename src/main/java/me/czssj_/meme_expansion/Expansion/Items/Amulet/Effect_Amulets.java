package me.czssj_.meme_expansion.Expansion.Items.Amulet;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.czssj_.meme_expansion.Expansion.Utils.AbstractAmulet;

public class Effect_Amulets extends AbstractAmulet
{
    private final int level;
    PotionEffectType effect;

    public Effect_Amulets(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, PotionEffectType effect, int level) 
    {
        super(itemGroup, item, recipeType, recipe);
        this.level = level - 1;
        this.effect = effect;
    }

    @Override
    public void applyEffect(Player player) 
    {
        player.addPotionEffect(new PotionEffect(effect, 40, level, true, true, true));
    }

    @Override
    public void removeEffect(Player player) 
    {
        player.removePotionEffect(effect);
    }
}
