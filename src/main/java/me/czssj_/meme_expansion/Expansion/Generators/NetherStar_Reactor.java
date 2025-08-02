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
import me.czssj_.meme_expansion.setup.Meme_Expansion_item;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;

public class NetherStar_Reactor extends abstract1SlotGenerator implements NotHopperable
{
    public NetherStar_Reactor(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) 
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Nonnull
    @Override
    public ItemStack getProgressBar() 
    {
        return SlimefunItems.LAVA_CRYSTAL;
    }

    @Override
    public int getCapacity() 
    {
        return 32768;
    }

    @Override
    public int getEnergyProduction() 
    {
        return 2048;
    }

    @Override
    protected void registerDefaultFuelTypes()
    {
        registerFuel(new MachineFuel(450,new ItemStack(Material.NETHER_STAR), Meme_Expansion_item.NETHERSTAR_DEBRIS));
    }

    @Override
    public void extraTick(@Nonnull Location l) {}
}
