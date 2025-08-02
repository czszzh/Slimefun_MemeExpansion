package me.czssj_.meme_expansion.Expansion.Items.Amulet;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.czssj_.meme_expansion.Expansion.Utils.AbstractAmulet;

public class AttackSpeedUPAmulet extends AbstractAmulet implements RecipeDisplayItem
{

    private static final String ATTACK_SPEED_MODIFIER = "EXPANSION_ATTACK_SPEED_MODIFIER";
    private final double speedBonus = 0.3;

    public AttackSpeedUPAmulet(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) 
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void applyEffect(Player player) 
    {
        if(getAttackSpeedAttribute() == null) return;

        AttributeModifier modifier = new AttributeModifier(
            ATTACK_SPEED_MODIFIER, 
            speedBonus, 
            AttributeModifier.Operation.ADD_NUMBER
        );
        player.getAttribute(getAttackSpeedAttribute()).addModifier(modifier);
    }

    @Override
    public void removeEffect(Player player) 
    {
        if(getAttackSpeedAttribute() == null) return;

        player.getAttribute(getAttackSpeedAttribute())
            .getModifiers().stream()
            .filter(mod -> mod.getName().equals(ATTACK_SPEED_MODIFIER))
            .forEach(mod -> player.getAttribute(getAttackSpeedAttribute()).removeModifier(mod));
    }

    private Attribute getAttackSpeedAttribute() 
    {
        try 
        {
            return Attribute.valueOf("ATTACK_SPEED");
        } 
        catch (IllegalArgumentException e1) 
        {
            try 
            {
                return Attribute.valueOf("GENERIC_ATTACK_SPEED");
            } 
            catch (IllegalArgumentException e2) 
            {
                return null;
            }
        }
    }

    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() 
    {
        List<ItemStack> displayRecipes = new ArrayList<>();
        displayRecipes.add(new CustomItemStack(Material.PAPER, "§f效果§7: §6攻速提升", "§7使玩家在1s(20游戏刻)内", "§7能进行完整伤害近战攻击的次数+0.3"));
        return displayRecipes;
    }
}
