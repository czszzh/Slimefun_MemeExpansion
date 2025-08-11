package me.czssj_.meme_expansion.Expansion.Machines;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.mooy1.infinitylib.machines.AbstractMachineBlock;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.czssj_.meme_expansion.Expansion.Utils.AbstractAmulet;
import me.czssj_.meme_expansion.setup.Meme_Expansion_item;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

//管它有多屎，你就说能不能跑吧
public class Respawn_Machine extends AbstractMachineBlock
{
    private static final int STATUS_SLOT = 40;
    private static final int[] INPUT_SLOT = {19};
    private static final int[] OUTPUT_SLOT = {25};
    private static final int DISPLAY_SLOT = 22;
    private static final int[] INPUTorDISPLAY_BORDER = {12,13,14,21,23,30,31,32};

    private static final SlimefunItemStack KOBE = Meme_Expansion_item.KOBE;
    private static final SlimefunItemStack ZOBAYAN = Meme_Expansion_item.ZOBAYAN;
    private static final SlimefunItemStack DRAGEN_HEAD = new SlimefunItemStack("ENDER_DRAGON_HEAD", new ItemStack(Material.DRAGON_HEAD));
    private static final SlimefunItemStack ZOMBIE_HEAD = new SlimefunItemStack("ZOMBIE_HEAD", new ItemStack(Material.ZOMBIE_HEAD));
    private static final SlimefunItemStack SKELETON_SKULL = new SlimefunItemStack("SKELETON_SKULL", new ItemStack(Material.SKELETON_SKULL));
    private static final SlimefunItemStack CREEPER_HEAD = new SlimefunItemStack("CREEPER_HEAD", new ItemStack(Material.CREEPER_HEAD));

    private static final SlimefunItemStack[] RANDOM_ITEMS = {KOBE, ZOBAYAN, DRAGEN_HEAD, ZOMBIE_HEAD, SKELETON_SKULL, CREEPER_HEAD};
    private static final int[] outputNeed = {24,10,10,5,5,5};

    private static final String CURRENT_DISPLAY_KEY = "current_display";
    private static final String NUM_KEY = "num";
    private static final String MODE_KEY = "respawn-mode";

    private final Random random = new Random();

    public Respawn_Machine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    protected void setup(@Nonnull BlockMenuPreset blockMenuPreset) 
    {
        blockMenuPreset.drawBackground(new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE, "§a不死图腾输入槽"), new int[]{9,10,11,18,20,27,28,29});
        blockMenuPreset.drawBackground(new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "§a预计输出物"), INPUTorDISPLAY_BORDER);
        blockMenuPreset.drawBackground(new int[]{0,1,2,3,5,6,7,8,36,37,38,39,40,41,42,43,44});
        blockMenuPreset.drawBackground(new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE, "§a输出"), new int[]{15,16,17,24,26,33,34,35});
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
    public void onNewInstance(@Nonnull BlockMenu menu, @Nonnull Block b) 
    {
        if(!BlockStorage.hasBlockInfo(b) || BlockStorage.getLocationInfo(b.getLocation(), MODE_KEY) == null) 
        {
            BlockStorage.addBlockInfo(b, MODE_KEY, "true");
        }
        
        menu.addMenuClickHandler(DISPLAY_SLOT, (player, slot, item, action) -> {
            boolean currentMode = Boolean.parseBoolean(BlockStorage.getLocationInfo(b.getLocation(), MODE_KEY));
            return !currentMode;
        });

        menu.addMenuClickHandler(4, (player, slot, item, action) -> {
            boolean currentMode = Boolean.parseBoolean(BlockStorage.getLocationInfo(b.getLocation(), MODE_KEY));
            
            if (!currentMode && menu.getItemInSlot(DISPLAY_SLOT) != null) 
            {
                player.sendMessage("§c请先取出护符后再切换模式");
                return false;
            }
            
            BlockStorage.addBlockInfo(b, MODE_KEY, String.valueOf(!currentMode));
            updateInventory(menu, b);
            return false;
        });
        
        updateInventory(menu, b);
    }

    private void updateInventory(@Nonnull BlockMenu menu, @Nonnull Block b) 
    {
        boolean currentMode = Boolean.parseBoolean(BlockStorage.getLocationInfo(b.getLocation(), MODE_KEY));     
        menu.replaceExistingItem(4, new CustomItemStack(Material.REDSTONE_TORCH,"&6工作模式","&e当前模式: " + (currentMode ? "&a复活赛模式" : "&6护符模式"),"&7点击切换模式"));
        if (!currentMode) 
        {
            menu.replaceExistingItem(DISPLAY_SLOT, new ItemStack(Material.AIR));
            menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.DIAMOND_BLOCK, "§a进度", "§b已输入: §f" + getNum(b.getLocation())));
        }
        else menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.DIAMOND_BLOCK, "§a进度", "§b已输入: §f" + getNum(b.getLocation())));
    }

    @Override
    protected boolean process(@Nonnull Block b, @Nonnull BlockMenu menu) 
    {
        Location l = b.getLocation();
        SlimefunItemStack currentDisplay = getCurrentDisplay(l);
        int num = getNum(l);
        boolean currentMode = Boolean.parseBoolean(BlockStorage.getLocationInfo(b.getLocation(), MODE_KEY));
        if (currentMode) 
        {
            int index = findCurrentDisplayIndex(currentDisplay);
            if (currentDisplay == null) selectRandomItem(menu, l);
            else menu.replaceExistingItem(DISPLAY_SLOT, new CustomItemStack(currentDisplay, "§a本次复活赛获胜者", "see you again~"));

            for (int i = 0; i <= 7; i++) menu.replaceExistingItem(INPUTorDISPLAY_BORDER[i], new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "§a预计输出"));

            ItemStack inputStack=menu.getItemInSlot(INPUT_SLOT[0]);
            ItemStack outputStack=menu.getItemInSlot(OUTPUT_SLOT[0]);

            if (outputStack != null) 
            {
                menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.BARRIER, "§f输出槽已经有物品了!"));
                return false;
            } 
            else if (num == 0)
            {
                menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.DIAMOND_BLOCK, "§a进度", "§b已输入: §f" + num + "§a/§f" + outputNeed[index]));
            }

            if (inputStack != null && inputStack.getType() == Material.TOTEM_OF_UNDYING) 
            {
                num++;
                menu.consumeItem(INPUT_SLOT[0], 1);
                menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.DIAMOND_BLOCK, "§a进度", "§b已输入: §f" + num + "§a/§f" + outputNeed[index]));
                if (num >= outputNeed[index])
                {
                    menu.pushItem(currentDisplay.clone(), OUTPUT_SLOT);
                    menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.DIAMOND_BLOCK, "§a进度", "§b已输入: §f" + num + "§a/§f" + outputNeed[index]));
                    selectRandomItem(menu, l);
                    num = 0;
                    setNum(l, num);
                    return true;
                }
            }
            setNum(l, num);
            return false;
        }
        else
        {
            ItemStack totem = menu.getItemInSlot(INPUT_SLOT[0]);
            ItemStack amulet = menu.getItemInSlot(DISPLAY_SLOT);
            ItemStack output = menu.getItemInSlot(OUTPUT_SLOT[0]);

            for (int i = 0; i <= 7; i++) menu.replaceExistingItem(INPUTorDISPLAY_BORDER[i], new CustomItemStack(Material.BLUE_STAINED_GLASS_PANE, "§a护符输入槽"));
            
            if (amulet == null) 
            {
                menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.BARRIER, "§c护符槽为空!"));
                return false;
            }
            
            if (amulet.hasItemMeta()) 
            {
                ItemMeta meta = amulet.getItemMeta();
                if (meta.hasLore()) 
                {
                    for (String line : meta.getLore()) 
                    {
                        if (line.contains("耐久: 无限")) 
                        {
                            menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.BARRIER, "§c该护符已是无限耐久"));
                            return false;
                        }
                    }
                }
            }
            
            menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.DIAMOND_BLOCK, "§a进度", "§b已输入: §f" + num + "§a/§f32"));
            
            if (totem != null && totem.getType() == Material.TOTEM_OF_UNDYING) 
            {
                num++;
                menu.consumeItem(INPUT_SLOT[0], 1);
                menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.DIAMOND_BLOCK, "§a进度", "§b已输入: §f" + num + "§a/§f32"));
                
                if (num >= 32) 
                {
                    ItemStack upgradedAmulet = amulet.clone();
                    if (upgradedAmulet.getItemMeta() != null) 
                    {
                        SlimefunItem sfItem = SlimefunItem.getByItem(upgradedAmulet);
                        if (sfItem instanceof AbstractAmulet abstractAmulet) abstractAmulet.setInfinite(true);
                        
                        ItemMeta meta = upgradedAmulet.getItemMeta();
                        List<String> lore = meta.hasLore() ? new ArrayList<>(meta.getLore()) : new ArrayList<>();
                        lore.removeIf(line -> line.startsWith("§3耐久:"));
                        lore.add("§3耐久: 无限");
                        meta.setLore(lore);
                        upgradedAmulet.setItemMeta(meta);
                    }
                    
                    menu.pushItem(upgradedAmulet, OUTPUT_SLOT[0]);
                    menu.consumeItem(DISPLAY_SLOT, 1);
                    num = 0;
                    menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.DIAMOND_BLOCK, "§a进度", "§b已输入: §f" + num + "§a/§f32"));
                }
                
                setNum(l, num);
                return true;
            }

            if (output != null)
            {
                menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.BARRIER, "§c输出槽已有物品"));
                return false;
            }
            else
            {
                menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.DIAMOND_BLOCK, "§a进度", "§b已输入: §f" + num + "§a/§f32"));
            }
        }

        return false;
    }

    private void selectRandomItem(BlockMenu menu, Location l) 
    {
        int index = random.nextInt(RANDOM_ITEMS.length);
        SlimefunItemStack currentDisplay = RANDOM_ITEMS[index];
        menu.replaceExistingItem(DISPLAY_SLOT, new CustomItemStack(currentDisplay, "§a本次复活赛获胜者", "see you again~"));
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

        boolean currentMode = Boolean.parseBoolean(BlockStorage.getLocationInfo(l, MODE_KEY));
        if (currentMode) 
        {
            ItemStack item = menu.getItemInSlot(INPUT_SLOT[0]);
            if (item != null) e.getBlock().getWorld().dropItemNaturally(l, item);
        } 
        else  
        {
            ItemStack item = menu.getItemInSlot(DISPLAY_SLOT);
            if (item != null) e.getBlock().getWorld().dropItemNaturally(l, item);
            menu.dropItems(e.getBlock().getLocation(), getInputSlots());
        }
        
        menu.dropItems(e.getBlock().getLocation(), getOutputSlots());
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
