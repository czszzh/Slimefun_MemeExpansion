package me.czssj_.sj_expansion.Expansion.Generators;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotHopperable;
import me.czssj_.sj_expansion.Expansion.abstracts.abstract1SlotGenerator;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class Expansion_Magma_Block_Machine extends abstract1SlotGenerator implements NotHopperable
{
    public Expansion_Magma_Block_Machine(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Nonnull
    @Override
    public ItemStack getProgressBar()
    {
        return new ItemStack(Material.WOODEN_PICKAXE);
    }

    @Override
    public int getCapacity()
    {
        return 400;
    }

    @Override
    public int getEnergyProduction()
    {
        return 20;
    }

    @Override
    protected void registerDefaultFuelTypes()
    {
        registerFuel(new MachineFuel(3,new ItemStack(Material.COBBLESTONE,8), new ItemStack(Material.MAGMA_BLOCK,3)));
    }

    @Override
    public void extraTick(@NotNull Location l) {}
}
