package me.czssj_.meme_expansion.Expansion.Generators;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotHopperable;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.czssj_.meme_expansion.Expansion.Utils.abstract1SlotGenerator;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;

public class Nuclear_Reactor extends abstract1SlotGenerator implements NotHopperable
{
    private static final String MODE = "reactor-mode";

    public Nuclear_Reactor(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) 
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
        return 16384;
    }

    @Override
    public int getEnergyProduction() 
    {
        return 1000;
    }

    @Override
    protected void registerDefaultFuelTypes()
    {
        registerFuel(new MachineFuel(300,SlimefunItems.URANIUM, SlimefunItems.NEPTUNIUM));
        registerFuel(new MachineFuel(150,SlimefunItems.NEPTUNIUM, SlimefunItems.PLUTONIUM)); 
        registerFuel(new MachineFuel(375,SlimefunItems.BOOSTED_URANIUM, null));
    }

    @Override
    public void extraTick(@Nonnull Location l) 
    {
        /* //test
        if (BlockStorage.hasBlockInfo(l) && BlockStorage.getLocationInfo(l, MODE).equals(ReactorMode.PRODUCTION.toString())) 
        {
            FuelOperation operation = getMachineProcessor().getOperation(l);
            if (operation != null) 
            {
                operation.addProgress(1);
            }
        } 
        */
    }
}
