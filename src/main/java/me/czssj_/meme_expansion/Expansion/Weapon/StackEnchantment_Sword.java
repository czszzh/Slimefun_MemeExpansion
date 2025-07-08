package me.czssj_.meme_expansion.Expansion.Weapon;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.core.handlers.WeaponUseHandler;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.czssj_.meme_expansion.Meme_Expansion;

public class StackEnchantment_Sword extends SlimefunItem implements WeaponUseHandler, RecipeDisplayItem, Listener
{
    public StackEnchantment_Sword(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister()
    {
        WeaponUseHandler weaponUseHandler = this::onHit;
        addItemHandler(weaponUseHandler);
        Bukkit.getPluginManager().registerEvents(this, Meme_Expansion.getInstance());
    }

    @Override
    public void onHit(@Nonnull EntityDamageByEntityEvent e, @Nonnull Player p, @Nonnull ItemStack item) 
    {
        if (e.getEntity() instanceof LivingEntity) 
        {
            double enchantmentLevelSum = 0;
            for (Enchantment enchantment : item.getEnchantments().keySet()) 
            {
                enchantmentLevelSum += item.getEnchantmentLevel(enchantment);
            }
            double damage = enchantmentLevelSum + 4;
            e.setDamage(damage);
            updateLore(item);
        }
    }

    private void updateLore(ItemStack item) 
    {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) 
        {
            List<String> lore = meta.getLore() != null ? meta.getLore() : new ArrayList<>();
            
            lore.removeIf(line -> line.contains("§7当前伤害: §e"));
            
            double enchantmentLevelSum = 0;
            for (Enchantment enchantment : item.getEnchantments().keySet()) {
                enchantmentLevelSum += item.getEnchantmentLevel(enchantment);
            }
            double damage = enchantmentLevelSum + 4;
            lore.add("§7当前伤害: §e" + damage);
            
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
    }

    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() 
    {
        List<ItemStack> displayRecipes = new ArrayList<>();
        displayRecipes.add(new CustomItemStack(Material.ENCHANTED_BOOK, "§3每次攻击后更新介绍中的当前伤害"));
        return displayRecipes;
    }
}
