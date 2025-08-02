package me.czssj_.meme_expansion.Expansion.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitTask;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.czssj_.meme_expansion.Meme_Expansion;

public abstract class AbstractAmulet extends SlimefunItem 
{
    private boolean enabled = false;
    private boolean infiniteDurability = false;
    private BukkitTask durabilityTask;

    public AbstractAmulet(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) 
    {
        super(itemGroup, item, recipeType, recipe);
        ItemUseHandler itemUseHandler = this::itemRightClick;
        addItemHandler(itemUseHandler);
        
        // 初始化Lore
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.hasLore() ? new ArrayList<>(meta.getLore()) : new ArrayList<>();
        lore.add(infiniteDurability ? "§3耐久:无限" : "§3耐久:120/120");
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    public AbstractAmulet setInfinite(boolean infinite) {
        this.infiniteDurability = infinite;
        return this;
    }

    private void itemRightClick(PlayerRightClickEvent e)
    {
        Player player = e.getPlayer();
        ItemStack amulet = e.getItem();
        toggleEnabled(player, amulet);
        e.cancel();
    }

    public void toggleEnabled(Player player, ItemStack item) 
    {
        enabled = !enabled;
        ItemMeta meta = item.getItemMeta();
        
        if (enabled) 
        {
            if (meta != null) 
            {
                meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                meta.addItemFlags(org.bukkit.inventory.ItemFlag.HIDE_ENCHANTS);
                item.setItemMeta(meta);

                applyEffect(player);
                startDurabilityTask(player, item);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0f, 1.0f);
            }
        } 
        else 
        {
            if (meta != null) 
            {
                meta.removeEnchant(Enchantment.ARROW_DAMAGE);
                item.setItemMeta(meta);

                removeEffect(player);
                stopDurabilityTask();
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0f, 1.0f);
            }
        }
    }

    private void startDurabilityTask(Player player, ItemStack item) 
    {
        if (durabilityTask != null) 
        {
            durabilityTask.cancel();
        }
        
        durabilityTask = Bukkit.getScheduler().runTaskTimer(Meme_Expansion.getInstance(), () -> {
            if (!player.isOnline()) 
            {
                stopDurabilityTask();
                return;
            }
            
            if (isEnabled()) 
            {
                applyEffect(player);
                updateDurability(player, item);
            }
        }, 20L, 20L);
    }

    private void stopDurabilityTask() 
    {
        if (durabilityTask != null) 
        {
            durabilityTask.cancel();
            durabilityTask = null;
        }
    }

    public void updateDurability(Player player, ItemStack item) 
    {
        if (item == null || !(item.getItemMeta() instanceof Damageable)) return;
        
        ItemMeta meta = item.getItemMeta();
        if (isInfinite(meta)) return;
        
        Damageable damageable = (Damageable)meta;
        int currentDamage = damageable.getDamage();
        int remainingDurability = 120 - currentDamage;
        
        if (currentDamage >= 120) 
        {
            removeEffect(player);
            player.getInventory().removeItem(item);
            return;
        }
        
        List<String> lore = meta.hasLore() ? new ArrayList<>(meta.getLore()) : new ArrayList<>();
        lore.removeIf(line -> line.startsWith("§3耐久:"));
        lore.add("§3耐久:" + remainingDurability + "/120");
        
        meta.setLore(lore);
        damageable.setDamage(currentDamage + 1);
        item.setItemMeta(meta);
    }

    private boolean isInfinite(ItemMeta meta) 
    {
        if (!meta.hasLore()) return false;
        return meta.getLore().stream().anyMatch(line -> line.contains("§3耐久: 无限"));
    }

    public abstract void applyEffect(Player player);
    public abstract void removeEffect(Player player);

    public boolean isEnabled() 
    {
        return enabled;
    }
}
