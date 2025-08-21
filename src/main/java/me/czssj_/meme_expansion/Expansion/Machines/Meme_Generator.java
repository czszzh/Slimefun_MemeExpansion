package me.czssj_.meme_expansion.Expansion.Machines;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinitylib.machines.AbstractMachineBlock;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.czssj_.meme_expansion.setup.Meme_Expansion_item;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

public class Meme_Generator extends AbstractMachineBlock implements RecipeDisplayItem
{

    private static final int[] INPUT_SLOT = {10,11,19,20};
    private static final int[] OUTPUT_SLOT = {15,16,24,25};
    private static final int STATUS_SLOT = 13;

    private static final String TOTAL_ITEMS_KEY = "total_items";
    private static final String PIECE1_KEY = "level1_piece";
    private static final String PIECE2_KEY = "level2_piece";
    private static final String UNIQUE_ITEMS_KEY = "unique_items";
    private static final String USE_LEVEL1_KEY = "use_level1";

    boolean firstPieceFound = false;
    
    public Meme_Generator(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    protected void setup(BlockMenuPreset preset) 
    {
        preset.drawBackground(new int[]{4,13,22,31});
        preset.drawBackground(new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE, "§a输入"), new int[]{0,1,2,3, 9,12,18,21, 27,28,29,30});
        preset.drawBackground(new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE, "§a输出"), new int[]{5,6,7,8, 14,17,23,26, 32,33,34,35});
    }

    @Override
    protected boolean process(Block b, BlockMenu menu) 
    {
        if (BlockStorage.getLocationInfo(b.getLocation(), TOTAL_ITEMS_KEY) == null) 
        {
            BlockStorage.addBlockInfo(b.getLocation(), TOTAL_ITEMS_KEY, "0");
            BlockStorage.addBlockInfo(b.getLocation(), PIECE1_KEY, "0");
            BlockStorage.addBlockInfo(b.getLocation(), PIECE2_KEY, "0");
            BlockStorage.addBlockInfo(b.getLocation(), UNIQUE_ITEMS_KEY, "0");
            BlockStorage.addBlockInfo(b.getLocation(), USE_LEVEL1_KEY, "false");
        }        

        int totalItems = Integer.parseInt(BlockStorage.getLocationInfo(b.getLocation(), TOTAL_ITEMS_KEY));
        int piece1 = Integer.parseInt(BlockStorage.getLocationInfo(b.getLocation(), PIECE1_KEY));
        int piece2 = Integer.parseInt(BlockStorage.getLocationInfo(b.getLocation(), PIECE2_KEY));
        int uniqueItems = Integer.parseInt(BlockStorage.getLocationInfo(b.getLocation(), UNIQUE_ITEMS_KEY));
        boolean useLevel1 = Boolean.parseBoolean(BlockStorage.getLocationInfo(b.getLocation(), USE_LEVEL1_KEY));
        
        Set<Material> itemTypes = new HashSet<>();
        
        String storedTypes = BlockStorage.getLocationInfo(b.getLocation(), "item_types");
        if (storedTypes != null) 
        {
            for (String type : storedTypes.split(","))       
            {
                itemTypes.add(Material.valueOf(type));
            }
        }
        
        for (int slot : INPUT_SLOT) 
        {
            ItemStack item = menu.getItemInSlot(slot);
            if (item != null && !item.getType().isAir()) 
            {
                int amount = item.getAmount();
                totalItems += amount;
                
                SlimefunItem sfItem = SlimefunItem.getByItem(item);
                if (sfItem != null) 
                {
                    String id = sfItem.getId();

                    if (id.equals("EXPANSION_MEME_PIECE_3")) 
                    {
                        menu.consumeItem(slot, 1);
                        menu.pushItem(new CustomItemStack(Meme_Expansion_item.MEME_1, 4), OUTPUT_SLOT);
                        return true;
                    }

                    if (id.equals("EXPANSION_MEME_PIECE_1")) 
                    {
                        piece1 += amount;
                        if (!firstPieceFound) 
                        {
                            useLevel1 = true;
                            firstPieceFound = true;
                        }
                    } 
                    else if (id.equals("EXPANSION_MEME_PIECE_2")) 
                    {
                        piece2 += amount;
                        if (!firstPieceFound) 
                        {
                            useLevel1 = false;
                            firstPieceFound = true;
                        }
                    }
                } 
                else itemTypes.add(item.getType());
                
                menu.consumeItem(slot, amount);
            }
        }
        
        uniqueItems = itemTypes.size();
        
        if (!itemTypes.isEmpty()) 
        {
            StringBuilder typesBuilder = new StringBuilder();
            for (Material type : itemTypes) 
            {
                if (typesBuilder.length() > 0) typesBuilder.append(",");
                typesBuilder.append(type.name());
            }
            BlockStorage.addBlockInfo(b.getLocation(), "item_types", typesBuilder.toString());
        }

        BlockStorage.addBlockInfo(b.getLocation(), TOTAL_ITEMS_KEY, String.valueOf(totalItems));
        BlockStorage.addBlockInfo(b.getLocation(), PIECE1_KEY, String.valueOf(piece1));
        BlockStorage.addBlockInfo(b.getLocation(), PIECE2_KEY, String.valueOf(piece2));
        BlockStorage.addBlockInfo(b.getLocation(), UNIQUE_ITEMS_KEY, String.valueOf(uniqueItems));
        BlockStorage.addBlockInfo(b.getLocation(), USE_LEVEL1_KEY, String.valueOf(useLevel1));
        
        SlimefunItemStack output = Meme_Expansion_item.MEME_1;
        if (totalItems >= 80) 
        {
            if (useLevel1 && piece1 >= 9 && uniqueItems == 4) output = Meme_Expansion_item.MEME_2;
            else if (!useLevel1 && piece2 >= 9 && uniqueItems == 4) output = Meme_Expansion_item.MEME_3;
            
            if (output != null) 
            {
                menu.pushItem(output.clone(), OUTPUT_SLOT);
                BlockStorage.addBlockInfo(b.getLocation(), TOTAL_ITEMS_KEY, String.valueOf(totalItems - 80));
                BlockStorage.addBlockInfo(b.getLocation(), PIECE1_KEY, "0");
                BlockStorage.addBlockInfo(b.getLocation(), PIECE2_KEY, "0");
                BlockStorage.addBlockInfo(b.getLocation(), UNIQUE_ITEMS_KEY, "0");
                BlockStorage.addBlockInfo(b.getLocation(), "item_types", null);
            }

            firstPieceFound = false;
        }
        
        if (firstPieceFound) 
        {
            String pieceInfo = useLevel1 ? 
                "§e迷因碎片 §f- §eI§7: " + piece1 + "/9": 
                "§e迷因碎片 §f- §eII§7: " + piece2 + "/9";

            String outputinfo = useLevel1 ? 
                "§f预计输出: §7迷因§f﹝§6典§f﹞" : 
                "§f预计输出: §7迷因§f﹝§4?§f﹞";

            menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(
                Material.YELLOW_STAINED_GLASS_PANE,
                "§a进度",
                "§7输入物品总数: " + totalItems + "/80",
                "§7不同物品类型: " + uniqueItems + "/4",
                pieceInfo,
                outputinfo
            ));
        }
        else
        {
            menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(
                Material.YELLOW_STAINED_GLASS_PANE,
                "§a进度",
                "§7输入物品总数: " + totalItems + "/80",
                "§7不同物品类型: " + uniqueItems + "/4",
                "§7预计输出: §7迷因§f﹝§8粪§f﹞"
            ));
        }
        
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

    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() 
    {
        List<ItemStack> displayRecipes = new ArrayList<>();

        displayRecipes.add(new CustomItemStack(Meme_Expansion_item.MEME_PIECE_1, 9));
        displayRecipes.add(new CustomItemStack(Material.AIR));
        displayRecipes.add(new CustomItemStack(Material.PAPER, "§f4种 §7不同的物品", "§780个"));
        displayRecipes.add(Meme_Expansion_item.MEME_2);

        displayRecipes.add(new CustomItemStack(Material.AIR));
        displayRecipes.add(new CustomItemStack(Material.AIR));

        displayRecipes.add(new CustomItemStack(Meme_Expansion_item.MEME_PIECE_2, 9));
        displayRecipes.add(new CustomItemStack(Material.AIR));
        displayRecipes.add(new CustomItemStack(Material.PAPER, "§f4种 §7不同的物品", "§780个"));
        displayRecipes.add(Meme_Expansion_item.MEME_3);

        displayRecipes.add(new CustomItemStack(Material.AIR));
        displayRecipes.add(new CustomItemStack(Material.AIR));

        displayRecipes.add(new CustomItemStack(Material.PAPER, "§7任意物品", "§780个"));
        displayRecipes.add(Meme_Expansion_item.MEME_1);

        displayRecipes.add(new CustomItemStack(Material.AIR));
        displayRecipes.add(new CustomItemStack(Material.AIR));

        displayRecipes.add(new CustomItemStack(Meme_Expansion_item.MEME_PIECE_3, Meme_Expansion_item.MEME_PIECE_3.getDisplayName(), "§7无视条件直接输出"));
        displayRecipes.add(new CustomItemStack(Meme_Expansion_item.MEME_1, 4));

        return displayRecipes;
    }   
}
