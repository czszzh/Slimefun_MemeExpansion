package me.czssj_.meme_expansion.Expansion.Machines;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinitylib.machines.AbstractMachineBlock;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.czssj_.meme_expansion.setup.Meme_Expansion_item;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

public class Directional_Dust_Extractor extends AbstractMachineBlock
{
    private static final int[] INPUT_SLOT = {20};
    private static final int[] OUTPUT_SLOT = {24};
    private static final int STATUS_SLOT = 22;
    private static final int DISPLAY_SLOT = 4;
    private static final int LEFT_ARROW_SLOT = 3;
    private static final int RIGHT_ARROW_SLOT = 5;
    
    private static final String CURRENT_SELECTION_KEY = "current_selection";
    
    private final int level;
    private final List<ItemStack> dusts;
    private final Random random = new Random();

    public Directional_Dust_Extractor(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int level)
    {
        super(itemGroup, item, recipeType, recipe);
        this.level = level;
        
        this.dusts = new ArrayList<>();
        dusts.add(SlimefunItems.COPPER_DUST);
        dusts.add(SlimefunItems.IRON_DUST);
        dusts.add(SlimefunItems.GOLD_DUST);
        dusts.add(SlimefunItems.TIN_DUST);
        dusts.add(SlimefunItems.SILVER_DUST);
        dusts.add(SlimefunItems.LEAD_DUST);
        dusts.add(SlimefunItems.ALUMINUM_DUST);
        dusts.add(SlimefunItems.ZINC_DUST);
        dusts.add(SlimefunItems.MAGNESIUM_DUST);
        dusts.add(new CustomItemStack(Material.NETHER_STAR, "§6随机输出", "§r我保留了随机输出", "§r这样你才知道你用的是磨粉机"));
    }

    @Override
    protected void setup(@Nonnull BlockMenuPreset preset) 
    {
        preset.drawBackground(new int[]{0,1,2,4,6,7,8, 9,13,17,18,26,27,31,35, 36,37,38,39,40,41,42,43,44});
        preset.drawBackground(new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE, "§a输入"), new int[]{10,11,12,19,21,28,29,30});
        preset.drawBackground(new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE, "§a输出"), new int[]{14,15,16,23,25,32,33,34});
        preset.drawBackground(new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "§a空闲"), new int[]{22});
        preset.drawBackground(Meme_Expansion_item.MENU_ARROW_LEFT, new int[]{LEFT_ARROW_SLOT});
        preset.drawBackground(Meme_Expansion_item.MENU_ARROW_RIGHT, new int[]{RIGHT_ARROW_SLOT});
    }

    @Override
    public void onNewInstance(@Nonnull BlockMenu menu, @Nonnull Block block) 
    {
        menu.addMenuClickHandler(LEFT_ARROW_SLOT, (p, slot, item, action) -> {
            int current = Integer.parseInt(BlockStorage.getLocationInfo(block.getLocation(), CURRENT_SELECTION_KEY));
            int newSelection = (current - 1 + dusts.size()) % dusts.size();
            BlockStorage.addBlockInfo(block, CURRENT_SELECTION_KEY, String.valueOf(newSelection));
            updateDisplay(menu, block);
            return false;
        }); 
        
        menu.addMenuClickHandler(RIGHT_ARROW_SLOT, (p, slot, item, action) -> {
            int current = Integer.parseInt(BlockStorage.getLocationInfo(block.getLocation(), CURRENT_SELECTION_KEY));
            int newSelection = (current + 1) % dusts.size();
            BlockStorage.addBlockInfo(block, CURRENT_SELECTION_KEY, String.valueOf(newSelection));
            updateDisplay(menu, block);
            return false;
        });

        if (BlockStorage.getLocationInfo(block.getLocation(), CURRENT_SELECTION_KEY) == null) BlockStorage.addBlockInfo(block, CURRENT_SELECTION_KEY, String.valueOf(dusts.size() - 1));
        updateDisplay(menu, block);
    }
    
    private void updateDisplay(BlockMenu menu, Block block) 
    {
        int current = Integer.parseInt(BlockStorage.getLocationInfo(block.getLocation(), CURRENT_SELECTION_KEY));
        menu.replaceExistingItem(DISPLAY_SLOT, new CustomItemStack(dusts.get(current), "§f当前输出:", dusts.get(current).getItemMeta().getDisplayName()));
    }

    @Override
    protected boolean process(Block b, BlockMenu menu) 
    {
        ItemStack input = menu.getItemInSlot(INPUT_SLOT[0]);
        if (input == null || input.getType() != Material.COBBLESTONE) 
        {
            menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "§a空闲"));
            return false;
        }

        int required = level == 1 ? 4 : 64;
        if (input.getAmount() < required)
        {
            menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "§a空闲"));
            return false;
        }

        int current = Integer.parseInt(BlockStorage.getLocationInfo(b.getLocation(), CURRENT_SELECTION_KEY));
        boolean isRandomMode = current == dusts.size() - 1;
        ItemStack output;
        int outputAmount = level == 1 ? 2 : 64;
        
        if (isRandomMode) output = dusts.get(random.nextInt(dusts.size() - 1)).clone();
        else 
        {
            output = dusts.get(current).clone();

            ItemStack existingOutput = menu.getItemInSlot(OUTPUT_SLOT[0]);
            if (existingOutput != null) 
            {
                if (!existingOutput.getType().equals(output.getType())) 
                {
                    menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "§c输出栏空间不足"));
                    return false;
                }

                if (existingOutput.getAmount() + outputAmount > existingOutput.getMaxStackSize()) 
                {
                    menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "§c输出栏空间不足"));
                    return false;
                }
            }
        }

        ItemStack finalOutput = output.clone();
        finalOutput.setAmount(outputAmount);
        if (!menu.fits(finalOutput, OUTPUT_SLOT)) 
        {
            menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "§c输出栏空间不足"));
            return false;
        }

        input.setAmount(input.getAmount() - required);
        menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "§a工作中"));
        
        menu.pushItem(finalOutput, OUTPUT_SLOT);
        return true;
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
    
}
