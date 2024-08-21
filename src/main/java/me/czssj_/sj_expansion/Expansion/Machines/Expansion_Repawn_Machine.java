package me.czssj_.sj_expansion.Expansion.Machines;

import java.util.Random;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinitylib.machines.AbstractMachineBlock;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.czssj_.sj_expansion.setup.sj_Expansion_item;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

public class Expansion_Repawn_Machine extends AbstractMachineBlock
{
    private static final int STATUS_SLOT = 40;
    private static final int[] INPUT_SLOT = {38};
    private static final int[] OUTPUT_SLOT = {42};
    private static final int DISPLAY_SLOT = 13;

    private static final SlimefunItemStack KOBE = sj_Expansion_item.KOBE;
    private static final SlimefunItemStack ZOBAYAN = sj_Expansion_item.ZOBAYAN;
    private static final SlimefunItemStack DRAGEN_HEAD = new SlimefunItemStack("ENDER_DRAGON_HEAD", new ItemStack(Material.DRAGON_HEAD));

    private static final SlimefunItemStack[] RANDOM_ITEMS = {KOBE,ZOBAYAN,DRAGEN_HEAD};
    private static final int[] outputNeed = {24,10,10};

    private static final String CURRENT_DISPLAY_KEY = "current_display";
    private static final String NUM_KEY = "num";

    private Random random = new Random();

    public Expansion_Repawn_Machine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    protected void setup(@Nonnull BlockMenuPreset blockMenuPreset) 
    {
        blockMenuPreset.drawBackground(new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE, "§a输入"), new int[]{28,29,30,37,39,46,47,48});
        blockMenuPreset.drawBackground(new int[]{0,1,2,6,7,8,9,10,11,15,16,17,18,19,20,24,25,26,27,31,35,36,44,45,49,53});
        blockMenuPreset.drawBackground(new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE, "§a输出"), new int[]{32,33,34,41,43,50,51,52});
        blockMenuPreset.drawBackground(new CustomItemStack(Material.YELLOW_STAINED_GLASS_PANE," "), new int[]{3,4,5,12,14,21,23});
        blockMenuPreset.drawBackground(new CustomItemStack(Material.YELLOW_STAINED_GLASS_PANE,"§f↑本次复活赛决胜者↑"), new int[]{22});
        blockMenuPreset.drawBackground(new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE," "),new int[]{13,40});
    }

    @Override
    protected int getStatusSlot() 
    {
        return STATUS_SLOT;
    }

    @Override
    protected int[] getInputSlots() 
    {
        return INPUT_SLOT;
    }

    @Override
    protected int[] getOutputSlots() 
    {
        return OUTPUT_SLOT;
    }

    @Override
    protected boolean process(@Nonnull Block b, @Nonnull BlockMenu menu) 
    {
        Location l = b.getLocation();
        SlimefunItemStack currentDisplay = getCurrentDisplay(l);
        int num = getNum(l);

        if (currentDisplay == null) 
        {
            selectRandomItem(menu, l);
        } 
        else 
        {
            menu.replaceExistingItem(DISPLAY_SLOT, currentDisplay);
        }

        ItemStack inputStack = menu.getItemInSlot(INPUT_SLOT[0]);
        ItemStack outputStack = menu.getItemInSlot(OUTPUT_SLOT[0]);

        if (outputStack != null) 
        {
            menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.BARRIER, "§f输出槽已经有物品了!"));
            return false;
        } 
        else if (num == 0)
        {
            menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "));
        }

        if (inputStack != null && inputStack.getType() == Material.TOTEM_OF_UNDYING) 
        {
            int index = findCurrentDisplayIndex(currentDisplay);
            num++;
            menu.consumeItem(INPUT_SLOT[0], 1);
            menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.DIAMOND_SWORD, "§a打复活赛中", "§b进度: §f" + num + "§a/§f" + outputNeed[index]));
            if (num >= outputNeed[index])
            {
                menu.pushItem(currentDisplay.clone(), OUTPUT_SLOT);
                menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "));
                selectRandomItem(menu, l);
                num = 0;
                setNum(l, num);
                return true;
            }
        }
        setNum(l, num);
        return false;
    }

    private void selectRandomItem(BlockMenu menu, Location l) 
    {
        int index = random.nextInt(RANDOM_ITEMS.length);
        SlimefunItemStack currentDisplay = RANDOM_ITEMS[index];
        menu.replaceExistingItem(DISPLAY_SLOT, currentDisplay);
        setCurrentDisplay(l, currentDisplay);
    }

    private int findCurrentDisplayIndex(SlimefunItemStack currentDisplay) 
    {
        for (int i = 0; i < RANDOM_ITEMS.length; i++) 
        {
            if (RANDOM_ITEMS[i].equals(currentDisplay)) 
            {
                return i;
            }
        }
        return 0;
    }

    @Override
    protected void onBreak(@Nonnull BlockBreakEvent e, @Nonnull BlockMenu menu) 
    {
        super.onBreak(e, menu);
        Location l = menu.getLocation();
        int num = getNum(l);
        if (num != 0) 
        {
            e.getBlock().getWorld().dropItemNaturally(l, new ItemStack(Material.TOTEM_OF_UNDYING, num));
        }
        if (menu.getItemInSlot(OUTPUT_SLOT[0]) != null) 
        {
            e.getBlock().getWorld().dropItemNaturally(l, menu.getItemInSlot(OUTPUT_SLOT[0]));
        }
        if (menu.getItemInSlot(INPUT_SLOT[0]) != null) 
        {
            e.getBlock().getWorld().dropItemNaturally(l, menu.getItemInSlot(INPUT_SLOT[0]));
        }
        setNum(l, 0);
        setCurrentDisplay(l, null);
    }

    private void setCurrentDisplay(Location l, SlimefunItemStack currentDisplay) 
    {
        if (currentDisplay == null) 
        {
            BlockStorage.addBlockInfo(l, CURRENT_DISPLAY_KEY, null);
        } 
        else
        {
            BlockStorage.addBlockInfo(l, CURRENT_DISPLAY_KEY, currentDisplay.getItemId());
        }
    }

    private SlimefunItemStack getCurrentDisplay(Location l) 
    {
        String id = BlockStorage.getLocationInfo(l, CURRENT_DISPLAY_KEY);
        if (id == null) 
        {
            return null;
        }
        for (SlimefunItemStack item : RANDOM_ITEMS) 
        {
            if (item.getItemId().equals(id)) 
            {
                return item;
            }
        }
        return null;
    }

    private void setNum(Location l, int num) 
    {
        BlockStorage.addBlockInfo(l, NUM_KEY, String.valueOf(num));
    }

    private int getNum(Location l) 
    {
        String numStr = BlockStorage.getLocationInfo(l, NUM_KEY);
        if (numStr == null) 
        {
            return 0;
        }
        try 
        {
            return Integer.parseInt(numStr);
        } 
        catch (NumberFormatException e) 
        {
            return 0;
        }
    }

    
}
