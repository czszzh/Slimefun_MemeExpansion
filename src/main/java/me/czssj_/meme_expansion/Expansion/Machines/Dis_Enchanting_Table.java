package me.czssj_.meme_expansion.Expansion.Machines;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.mooy1.infinitylib.machines.MenuBlock;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.czssj_.meme_expansion.Meme_Expansion;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

public class Dis_Enchanting_Table extends MenuBlock implements Listener
{
    private static final int[] INPUT_SLOT = {19,21};
    private static final int[] OUTPUT_SLOT = {25};
    private final Map<UUID, BlockMenu> openMenus = new HashMap<>();

    public Dis_Enchanting_Table(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
        Bukkit.getPluginManager().registerEvents(this, Meme_Expansion.getInstance());
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
    protected void setup(@Nonnull BlockMenuPreset blockMenuPreset) 
    {
        blockMenuPreset.drawBackground(new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE, "§a输入"), new int[]{9,10,11,12,13,18,20,22,27,28,29,30,31});
        blockMenuPreset.drawBackground(new int[]{0,2,3,4,5,6,7,8,14,23,32,36,37,38,39,40,41,42,43,44});
        blockMenuPreset.drawBackground(new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE, "§a输出"), new int[]{15,16,17,24,26,33,34,35});
        blockMenuPreset.drawBackground(new CustomItemStack(Material.ENCHANTED_GOLDEN_APPLE,"§a含有附魔的物品"), new int[]{1});
        blockMenuPreset.drawBackground(new CustomItemStack(Material.BOOK,"§f书"), new int[]{3});
    }

    @Override
    protected void onNewInstance(@Nonnull BlockMenu menu, @Nonnull Block b) 
    {
        menu.addMenuOpeningHandler(p -> Dis_Enchanting_Table.this.openMenus.put(p.getUniqueId(), menu));
        menu.addMenuCloseHandler(p -> Dis_Enchanting_Table.this.openMenus.remove(p.getUniqueId()));
        menu.addPlayerInventoryClickHandler((p, slot, item, action) -> {
            if (action.isShiftClicked()) 
            {
                refreshOutput(menu, p);
            }
            return true;
        });
        for (int i : INPUT_SLOT) 
        {
            menu.addMenuClickHandler(i, (p, slot, item, action) -> {
                refreshOutput(menu, p);
                return true;
            });
        }
        menu.addMenuClickHandler(25, (p, slot, item, action) -> {
            return true;
        });
    }

    private void disenchant(Player p, BlockMenu menu) 
    {
        ItemStack enchantedItem = menu.getItemInSlot(INPUT_SLOT[0]);
        ItemStack normalBook = menu.getItemInSlot(INPUT_SLOT[1]);

        if (enchantedItem == null || normalBook == null || !normalBook.getType().equals(Material.BOOK)) 
        {
            return;
        }

        if (!enchantedItem.hasItemMeta() || !enchantedItem.getItemMeta().hasEnchants())
        {
            return;
        }

        ItemMeta enchantedMeta = enchantedItem.getItemMeta();
        String enchants = enchantedMeta.getEnchants().keySet().iterator().next().getKey().getKey();
        int level = enchantedMeta.getEnchants().values().iterator().next();

        ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta enchantedBookMeta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
        enchantedBookMeta.addStoredEnchant(org.bukkit.enchantments.Enchantment.getByKey(NamespacedKey.minecraft(enchants)), level, true);

        enchantedBook.setItemMeta(enchantedBookMeta);
        enchantedMeta.removeEnchant(org.bukkit.enchantments.Enchantment.getByKey(NamespacedKey.minecraft(enchants)));
        enchantedItem.setItemMeta(enchantedMeta);

        menu.replaceExistingItem(25, enchantedBook);
        menu.consumeItem(INPUT_SLOT[1], 1, true);
        menu.replaceExistingItem(INPUT_SLOT[0], enchantedItem);
        refreshOutput(menu, p);
    }

    private void refreshOutput(@Nonnull BlockMenu menu, Player p) 
    {
        new BukkitRunnable() 
        {
            @Override
            public void run() 
            {
                ItemStack enchantedItem = menu.getItemInSlot(INPUT_SLOT[0]);
                ItemStack normalBook = menu.getItemInSlot(INPUT_SLOT[1]);

                if (enchantedItem == null || normalBook == null || !normalBook.getType().equals(Material.BOOK)) 
                {
                    menu.replaceExistingItem(25, new ItemStack(Material.AIR));
                    return;
                }

                if (!enchantedItem.hasItemMeta() || !enchantedItem.getItemMeta().hasEnchants()) 
                {
                    menu.replaceExistingItem(25, new ItemStack(Material.AIR));
                    return;
                }

                ItemMeta enchantedMeta = enchantedItem.getItemMeta();
                String enchants = enchantedMeta.getEnchants().keySet().iterator().next().getKey().getKey();
                int level = enchantedMeta.getEnchants().values().iterator().next();

                ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
                EnchantmentStorageMeta enchantedBookMeta = (EnchantmentStorageMeta) enchantedBook.getItemMeta();
                enchantedBookMeta.addStoredEnchant(org.bukkit.enchantments.Enchantment.getByKey(NamespacedKey.minecraft(enchants)), level, true);
                enchantedBook.setItemMeta(enchantedBookMeta);

                menu.replaceExistingItem(25, enchantedBook);
            }
        }.runTaskLater(Meme_Expansion.getInstance(), 10);
    }

    @EventHandler
    public void onDrag(@Nonnull InventoryDragEvent e) 
    {
        BlockMenu menu = this.openMenus.get(e.getWhoClicked().getUniqueId());
        if (menu != null) 
        {
            refreshOutput(menu, (Player) e.getWhoClicked());
        }
    }

    @EventHandler
    public void onInventoryClick(@Nonnull InventoryClickEvent e) 
    {
        BlockMenu menu = this.openMenus.get(e.getWhoClicked().getUniqueId());
        if (menu != null && e.getSlot() == 25) 
        {
            disenchant((Player) e.getWhoClicked(), menu);
        }
    }

    @Override
    public void onBreak(@Nonnull BlockBreakEvent e, @Nonnull BlockMenu menu)
    {
        if (menu.getItemInSlot(25) != null)
        {
            menu.replaceExistingItem(25, new ItemStack(Material.AIR));
        }
        super.onBreak(e, menu);
    }
}
