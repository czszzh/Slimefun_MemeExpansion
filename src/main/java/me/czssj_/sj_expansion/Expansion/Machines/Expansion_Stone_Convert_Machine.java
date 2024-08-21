package me.czssj_.sj_expansion.Expansion.Machines;

import java.util.Random;

import javax.annotation.Nullable;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotHopperable;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;

public class Expansion_Stone_Convert_Machine extends AContainer implements NotHopperable
{
    private Random random = new Random();
    private int s;

    public Expansion_Stone_Convert_Machine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int speed)
    {
        super(itemGroup, item, recipeType, recipe);
        s = speed;
    }

    private static final Material[] stones = {
        Material.COBBLED_DEEPSLATE,
        Material.BLACKSTONE,
        Material.GRANITE,
        Material.DIORITE,
        Material.ANDESITE,
        Material.DEEPSLATE,
        Material.TUFF,
        Material.BASALT,
        Material.NETHERRACK,
        Material.MOSSY_COBBLESTONE
    };

    @Override
    public String getMachineIdentifier() 
    {
        return "EXPANSION_STONE_CONVERT_MACHINE";
    }

    @Override
    public ItemStack getProgressBar() 
    {
        return new ItemStack(Material.ENCHANTING_TABLE);
    }

    @Override
    public int getEnergyConsumption() 
    {
        return 10;
    }

    @Override
    public int getSpeed()
    {
        return s;
    }

    @Override
    public int getCapacity() 
    {
        return 100;
    }
    /* 
    @Override
    protected void registerDefaultRecipes() 
    {
        Material outputMaterial = stones[random.nextInt(stones.length)];
        new MachineRecipe(4, new ItemStack[] {new ItemStack(Material.STONE,2)},new ItemStack[]{new ItemStack(outputMaterial)});
    }
    */
    @Override
    protected @Nullable MachineRecipe findNextRecipe(BlockMenu menu)
    {
        Random random = new Random();
        ItemStack input1 = menu.getItemInSlot(getInputSlots()[0]);
        ItemStack input2 = menu.getItemInSlot(getInputSlots()[1]);
        ItemStack output1 = menu.getItemInSlot(getOutputSlots()[0]);
        ItemStack output2 = menu.getItemInSlot(getOutputSlots()[1]);

        if(output1 != null && output2 != null)
        {
            return null;   
        }

        if (input1 == null && input2 == null)
        {
            return null;
        }

        if (input1 != null && input1.getType() == Material.STONE)
        {
            menu.consumeItem(getInputSlots()[0],2);
            return new MachineRecipe(4/s, new ItemStack[]{new ItemStack(Material.STONE,2)}, new ItemStack[]{new ItemStack(stones[random.nextInt(stones.length)])});
        }
        if (input2.getType() == Material.STONE && input1 == null)
        {
            menu.consumeItem(getInputSlots()[1],2);
            return new MachineRecipe(4/s, new ItemStack[]{new ItemStack(Material.STONE,2)}, new ItemStack[]{new ItemStack(stones[random.nextInt(stones.length)])});
        }
        return null;
    }
    
} 