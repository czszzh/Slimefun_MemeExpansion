package me.czssj_.meme_expansion.Expansion.Generators;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotHopperable;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.czssj_.meme_expansion.Expansion.Utils.abstract1SlotGenerator;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import org.jetbrains.annotations.NotNull;

public class Expansion_Iron_Generator extends abstract1SlotGenerator implements NotHopperable
{
    public Expansion_Iron_Generator(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) 
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Nonnull
    @Override
    public ItemStack getProgressBar() 
    {
        return new ItemStack(Material.IRON_PICKAXE);
    }

    @Override
    public int getCapacity() 
    {
        return 114;
    }

    @Override
    public int getEnergyProduction() 
    {
        return 12;
    }

    @Override
    protected void registerDefaultFuelTypes()
    {
        registerFuel(new MachineFuel(6,new ItemStack(Material.IRON_INGOT), SlimefunItems.IRON_DUST));
    }

    @Override
    public void extraTick(@NotNull Location l) {}
}