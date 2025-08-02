package me.czssj_.meme_expansion.Expansion.Machines;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinitylib.machines.AbstractMachineBlock;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.czssj_.meme_expansion.Meme_Expansion;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

public class Auto_Harvester extends AbstractMachineBlock implements RecipeDisplayItem
{

    private final int level;
    private final int[] outputSlots = new int[] {19,20,21,22,23,24,25, 28,29,30,31,32,33,34};
    private static final String MODE_KEY = "harvester-mode";

    public Auto_Harvester(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int level)
    {
        super(itemGroup, item, recipeType, recipe);
        this.level = level;
    }

    @Override
    protected int[] getInputSlots()
    {
        return new int[] {7};
    }

    @Override
    protected int[] getOutputSlots() 
    {
        return outputSlots;
    }

    @Override
    protected void onBreak(@Nonnull BlockBreakEvent e, @Nonnull BlockMenu menu) 
    {
        menu.dropItems(e.getBlock().getLocation(), getInputSlots());
        menu.dropItems(e.getBlock().getLocation(), getOutputSlots());
    }

    private int getHarvestRange() 
    {
        if(level == 1) return 1;
        if(level == 2) return 2;
        if(level == 3) return 4;
        return 0;
    }

    private boolean isExoticGardenCrop(SlimefunItem item) 
    {
        if (item == null) return false;
        return item.getAddon().getName().contains("ExoticGarden");
    }

    private boolean isMatureCrop(Block cropBlock) 
    {
        BlockData data = cropBlock.getBlockData();
        if (data instanceof Ageable ageable) 
        {
            return ageable.getAge() >= ageable.getMaximumAge();
        }
        
        SlimefunItem sfItem = BlockStorage.check(cropBlock);
        if (sfItem != null && isExoticGardenCrop(sfItem)) 
        {
            return !sfItem.getId().endsWith("_PLANT") && !sfItem.getId().endsWith("_BUSH");
        }
        return false;
    }

    private List<ItemStack> getDropFromCrop(Block cropBlock, Material crop) 
    {
        SlimefunItem sfItem = BlockStorage.check(cropBlock);
        if (sfItem != null) 
        {
            List<ItemStack> drops = new ArrayList<>();
            String itemId = sfItem.getId();
            if (itemId.startsWith("GN")) 
            {
                String cropId = itemId.substring(0, itemId.length() - 6);
                SlimefunItem cropItem = SlimefunItem.getById(cropId);
                if (cropItem != null) 
                {
                    drops.add(cropItem.getItem().clone());
                    drops.add(sfItem.getItem().clone());
                } 
                else 
                {
                    drops.add(sfItem.getItem().clone());
                }
            }

            if (itemId.startsWith("WT_SEED_")) 
            {
                String cropId = "WT" + itemId.substring(7, itemId.length());
                SlimefunItem cropItem = SlimefunItem.getById(cropId);
                if (cropItem != null) 
                {
                    drops.add(cropItem.getItem().clone());
                    drops.add(sfItem.getItem().clone());
                } 
                else 
                {
                    drops.add(sfItem.getItem().clone());
                }
            }
            
            if (isExoticGardenCrop(sfItem)) 
            {
                if (!itemId.endsWith("_PLANT") && !itemId.endsWith("_BUSH")) 
                {
                    if(itemId.endsWith("_ESSENCE"))
                    {
                        String plantId = itemId.substring(0,itemId.length() - 8) + "_PLANT";
                        SlimefunItem plant = SlimefunItem.getById(plantId);
                        if (plant != null) 
                        {
                            drops.add(sfItem.getItem().clone());
                        }
                    }
                    else
                    {
                        String plantId = itemId + "_BUSH";
                        SlimefunItem plant = SlimefunItem.getById(plantId);
                        if (plant != null) 
                        {
                            drops.add(sfItem.getItem().clone());
                        }
                    }
                }
            }

            return drops;
            //return new ArrayList<>(sfItem.getDrops());
        }
        
        Random random = new Random();
        switch (crop) 
        {
            case WHEAT -> {
                List<ItemStack> drops = new ArrayList<>();
                drops.add(new ItemStack(Material.WHEAT, random.nextInt(2) + 1));
                drops.add(new ItemStack(Material.WHEAT_SEEDS, random.nextInt(3)));
                return drops;
            }
            case POTATOES -> {
                List<ItemStack> drops = new ArrayList<>();
                drops.add(new ItemStack(Material.POTATO, random.nextInt(3) + 1));
                return drops;
            }
            case CARROTS -> {
                List<ItemStack> drops = new ArrayList<>();
                drops.add(new ItemStack(Material.CARROT, random.nextInt(3) + 1));
                return drops;
            }
            case BEETROOTS -> {
                List<ItemStack> drops = new ArrayList<>();
                drops.add(new ItemStack(Material.BEETROOT, random.nextInt(3) + 1));
                drops.add(new ItemStack(Material.BEETROOT_SEEDS, random.nextInt(3)));
                return drops;
            }
            case NETHER_WART -> {
                List<ItemStack> drops = new ArrayList<>();
                drops.add(new ItemStack(Material.NETHER_WART, random.nextInt(3) + 1));
                return drops;
            }
            case SWEET_BERRY_BUSH -> {
                List<ItemStack> drops = new ArrayList<>();
                drops.add(new ItemStack(Material.SWEET_BERRIES, random.nextInt(3) + 1));
                return drops;
            }
            case COCOA -> {
                List<ItemStack> drops = new ArrayList<>();
                drops.add(new ItemStack(Material.COCOA_BEANS, random.nextInt(3) + 1));
                return drops;
            }
            default -> List.of();
        }
        return null;
    }
    
    @Override
    protected void setup(@Nonnull BlockMenuPreset preset) 
    {
        preset.drawBackground(new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE,"§f锄头放置处"), new int[]{6,8});
        preset.drawBackground(new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE,"§f输出"), new int[]{18,26,27,35});
        preset.drawBackground(new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE,""), new int[]{0,2});
        preset.drawBackground(new int[]{3,4,5,9,10,11,12,13,14,15,16,17,36,37,38,39,40,41,42,43,44});
    }

    @Override
    public void onNewInstance(@Nonnull BlockMenu menu, @Nonnull Block b) 
    {

        if(!BlockStorage.hasBlockInfo(b) || BlockStorage.getLocationInfo(b.getLocation(), MODE_KEY) == null) 
        {
            BlockStorage.addBlockInfo(b, MODE_KEY, "true");
        }
        
        menu.addMenuClickHandler(1, (player, slot, item, action) -> {
            boolean currentMode = Boolean.parseBoolean(BlockStorage.getLocationInfo(b.getLocation(), MODE_KEY));
            BlockStorage.addBlockInfo(b, MODE_KEY, String.valueOf(!currentMode));
            updateInventory(menu, b);
            return false;
        });
        
        updateInventory(menu, b);
    }

    private void updateInventory(@Nonnull BlockMenu menu, @Nonnull Block b) 
    {
        boolean currentMode = Boolean.parseBoolean(BlockStorage.getLocationInfo(b.getLocation(), MODE_KEY));     
        menu.replaceExistingItem(1, new CustomItemStack(Material.REDSTONE_TORCH,"&6工作模式","&e当前模式: " + (currentMode ? "&a电力模式" : "&6锄头模式"),"&7点击切换模式"));
    }

    private boolean checkOutputFull(BlockMenu menu) 
    {
        for (int slot : outputSlots) 
        {
            ItemStack item = menu.getItemInSlot(slot);
            if (item == null || item.getAmount() < item.getMaxStackSize())
            {
                return false;
            }
        }
        return true;
    }

    @Override
    protected boolean process(@Nonnull Block b,@Nonnull BlockMenu menu) 
    {
        boolean currentMode = Boolean.parseBoolean(BlockStorage.getLocationInfo(b.getLocation(), MODE_KEY));
        
        if(currentMode) 
        {
            int required = level == 1 ? 50 : (level == 2 ? 100 : 250);
            if (getCharge(b.getLocation()) < required) 
            {
                menu.replaceExistingItem(13, new CustomItemStack(Material.BARRIER,"&4电力不足"));
                return false;
            }
            else
            {
                menu.replaceExistingItem(13, new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE,"&a工作中"));
            }
        } 
        else
        {
            ItemStack hoe = menu.getItemInSlot(getInputSlots()[0]);
            
            if (hoe == null || hoe.getType() == Material.AIR)
            {
                menu.replaceExistingItem(13, new CustomItemStack(Material.BARRIER,"&4输入槽中没有锄可使用"));
                return false;
            }
            else if (!isHoe(hoe.getType())) 
            {
                menu.replaceExistingItem(13, new CustomItemStack(Material.BARRIER,"&4输入槽中的物品不是锄"));
                return false;
            }
            else 
            {
                menu.replaceExistingItem(13, new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE,"&a工作中"));
            }
            
            setCharge(b.getLocation(), 0);
        }

        if (checkOutputFull(menu)) 
        {
            menu.replaceExistingItem(13, new CustomItemStack(Material.BARRIER,"&4输出槽已满"));
            return false;
        }

        int range = getHarvestRange();
        boolean harvested = false;

        for(int x = -range; x <= range; x++) 
        {
            for(int z = -range; z <= range; z++) 
            {
                Block cropBlock = b.getRelative(x, 0, z);
                Material type = cropBlock.getType();

                if (isMatureCrop(cropBlock)) 
                {
                    List<ItemStack> crop = getDropFromCrop(cropBlock, type);
                    for(ItemStack item : crop) 
                    {
                        menu.pushItem(item, getOutputSlots());
                    }
                    Block cropBlockFinal = cropBlock;
                    Bukkit.getScheduler().runTask(Meme_Expansion.getInstance(), () -> {
                        SlimefunItem sfItem = BlockStorage.check(cropBlockFinal);
                        if (sfItem != null && isExoticGardenCrop(sfItem))
                        {
                            String id = sfItem.getId();
                            if(id.endsWith("_ESSENCE"))
                            {
                                Block headBlock = cropBlockFinal.getRelative(BlockFace.UP);
                                SlimefunItem HBitem = BlockStorage.check(headBlock);
                                String resetId = id.substring(0,id.length() - 8) + "_PLANT";
                                SlimefunItem resetItem = SlimefunItem.getById(resetId);

                                if (resetItem != null) 
                                {
                                    BlockStorage.clearBlockInfo(cropBlockFinal);
                                    BlockStorage.store(cropBlockFinal, resetId);
                                    cropBlockFinal.setType(resetItem.getItem().getType());
                                }

                                if (HBitem != null) 
                                {
                                    String HBid = HBitem.getId();
                                    if(HBid.equals(id))
                                    {
                                        BlockStorage.clearBlockInfo(headBlock);
                                        headBlock.setType(Material.AIR, false);
                                    }
                                }
                            }
                            else
                            {
                                String resetId = id + "_BUSH";
                                SlimefunItem resetItem = SlimefunItem.getById(resetId);
                                Block headBlock = cropBlockFinal.getRelative(BlockFace.UP);
                                SlimefunItem HBitem = BlockStorage.check(headBlock);

                                if (resetItem != null) 
                                {
                                    BlockStorage.clearBlockInfo(cropBlockFinal);
                                    BlockStorage.store(cropBlockFinal, resetId);
                                    cropBlockFinal.setType(resetItem.getItem().getType());
                                }
                                
                                if (HBitem != null) 
                                {
                                    String HBid = HBitem.getId();
                                    if(HBid.equals(id))
                                    {
                                        BlockStorage.clearBlockInfo(headBlock);
                                        headBlock.setType(Material.AIR, false);
                                    }
                                }
                            }
                        } 
                        else 
                        {
                            BlockData data = cropBlockFinal.getBlockData();
                            if(data instanceof Ageable ageable) 
                            {
                                ageable.setAge(0);
                                cropBlockFinal.setBlockData(data);
                            }
                        }
                    });
                    
                    if (currentMode) 
                    {
                        int consumed = level == 1 ? 50 : (level == 2 ? 100 : 250);
                        removeCharge(b.getLocation(), consumed);
                    } 
                    else 
                    {
                        ItemStack hoe = menu.getItemInSlot(getInputSlots()[0]);
                        if(hoe != null && hoe.getType() != Material.AIR) 
                        {
                            hoe.setDurability((short) (hoe.getDurability() + 1));
                        }
                    }
                    
                    harvested = true;
                }
            }
        }
        
        return harvested;
    }

    private boolean isHoe(Material material) 
    {
        return material == Material.WOODEN_HOE || material == Material.STONE_HOE || material == Material.IRON_HOE || material == Material.GOLDEN_HOE || material == Material.DIAMOND_HOE || material == Material.NETHERITE_HOE;
    }

    @Override
    protected void tick(@Nonnull Block b, @Nonnull BlockMenu menu) 
    {
        if(process(b, menu)) 
        {
            updateInventory(menu, b);
        }
    }

    @Override
    protected int getStatusSlot() 
    {
        return 13;
    }

    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() 
    {
        List<ItemStack> displayRecipes = new ArrayList<>();
        List<SlimefunItem> allItems = Slimefun.getRegistry().getEnabledSlimefunItems();
        
        displayRecipes.add(new CustomItemStack(Material.WHEAT_SEEDS, "&f小麦种子"));
        displayRecipes.add(new CustomItemStack(Material.WHEAT, "&f收获: &e1-2个小麦"));
        displayRecipes.add(new CustomItemStack(Material.AIR));
        displayRecipes.add(new CustomItemStack(Material.WHEAT_SEEDS, "&f附带: &e0-3个种子"));
        
        displayRecipes.add(new CustomItemStack(Material.CARROT, "&f胡萝卜"));
        displayRecipes.add(new CustomItemStack(Material.CARROT, "&f收获: &e1-4个胡萝卜"));
        
        displayRecipes.add(new CustomItemStack(Material.POTATO, "&f马铃薯"));
        displayRecipes.add(new CustomItemStack(Material.POTATO, "&f收获: &e1-4个马铃薯"));

        displayRecipes.add(new CustomItemStack(Material.BEETROOT_SEEDS, "&f甜菜种子"));
        displayRecipes.add(new CustomItemStack(Material.BEETROOT, "&f收获: &e1-3个甜菜根"));
        displayRecipes.add(new CustomItemStack(Material.AIR));
        displayRecipes.add(new CustomItemStack(Material.BEETROOT_SEEDS, "&f附带: &e0-3个种子"));
        
        displayRecipes.add(new CustomItemStack(Material.NETHER_WART, "&f下界疣"));
        displayRecipes.add(new CustomItemStack(Material.NETHER_WART, "&f收获: &e1-4个下界疣"));
        
        displayRecipes.add(new CustomItemStack(Material.SWEET_BERRIES, "&f甜浆果"));
        displayRecipes.add(new CustomItemStack(Material.SWEET_BERRIES, "&f收获: &e1-3个甜浆果"));
        
        displayRecipes.add(new CustomItemStack(Material.COCOA_BEANS, "&f可可豆"));
        displayRecipes.add(new CustomItemStack(Material.COCOA_BEANS, "&f收获: &e1-3个可可豆"));

        //为服务器的卡顿添砖加瓦(确信
        for (SlimefunItem item : allItems) 
        {
            if (isExoticGardenCrop(item)) 
            {
                String itemId = item.getId();

                if(itemId.endsWith("_BUSH") && itemId.length() >= 5)
                {
                    String cropId = itemId.substring(0, itemId.length() - 5);
                    SlimefunItem cropItem = SlimefunItem.getById(cropId);
                    if(cropItem != null)
                    {
                        displayRecipes.add(item.getItem().clone());
                        displayRecipes.add(new CustomItemStack(cropItem.getItem().clone(),cropItem.getItemName(), "&f收获: &e1个"));
                    } 
                }

                if(itemId.endsWith("_PLANT") && itemId.length() >= 6)
                {
                    String cropId = itemId.substring(0, itemId.length() - 6) + "_ESSENCE";
                    SlimefunItem cropItem = SlimefunItem.getById(cropId);
                    if(cropItem != null)
                    {
                        displayRecipes.add(item.getItem().clone());
                        displayRecipes.add(new CustomItemStack(cropItem.getItem().clone(),cropItem.getItemName(), "&f收获: &e1个"));
                    }   
                }
            }

            String itemId = item.getId();
            if (itemId.startsWith("WT_SEED_")) 
            {
                String cropId = "WT" + itemId.substring(7, itemId.length());
                SlimefunItem cropItem = SlimefunItem.getById(cropId);
                if (cropItem != null) 
                {
                    displayRecipes.add(item.getItem().clone());
                    displayRecipes.add(new CustomItemStack(cropItem.getItem().clone(),cropItem.getItemName(), "&f收获: &e1个"));
                    displayRecipes.add(new CustomItemStack(Material.AIR));
                    displayRecipes.add(new CustomItemStack(item.getItem().clone(),item.getItemName(), "&f附带: &e1个"));
                } 
                else 
                {
                    displayRecipes.add(item.getItem().clone());
                    displayRecipes.add(new CustomItemStack(item.getItem().clone(),item.getItemName(), "&f收获: &e1个"));
                }
            }

            if (itemId.startsWith("GN") && itemId.endsWith("_SEEDS") && itemId.length() >= 6) 
                {
                    String cropId = itemId.substring(0, itemId.length() - 6);
                    SlimefunItem cropItem = SlimefunItem.getById(cropId);
                    if (cropItem != null) 
                    {
                        displayRecipes.add(item.getItem().clone());
                        displayRecipes.add(new CustomItemStack(cropItem.getItem().clone(),cropItem.getItemName(), "&f收获: &e1个"));
                        displayRecipes.add(new CustomItemStack(Material.AIR));
                        displayRecipes.add(new CustomItemStack(item.getItem().clone(),item.getItemName(), "&f附带: &e1个"));
                    } 
                    else 
                    {
                        displayRecipes.add(item.getItem().clone());
                        displayRecipes.add(new CustomItemStack(item.getItem().clone(),item.getItemName(), "&f收获: &e1个"));
                    }
                }
        }
        
        return displayRecipes;
    }
    
}
