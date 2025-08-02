package me.czssj_.meme_expansion.Expansion.Weapon;

import javax.annotation.Nonnull;

import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.WeaponUseHandler;

public class One_Hit_Axe extends SlimefunItem implements WeaponUseHandler
{
    public One_Hit_Axe(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister()
    {
        WeaponUseHandler weaponUseHandler = this::onHit;
        addItemHandler(weaponUseHandler);
    }

    @Override
    public void onHit(@Nonnull EntityDamageByEntityEvent e, @Nonnull Player player, @Nonnull ItemStack item) 
    {
        if (e.getEntity() instanceof LivingEntity target) 
        {
            target.setHealth(0);
        } 

        if (player.getInventory().getItemInMainHand().equals(item)) 
        {
            player.getInventory().setItemInMainHand(null);
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
        } 
        else if (player.getInventory().getItemInOffHand().equals(item)) 
        {
            player.getInventory().setItemInOffHand(null);
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
        }
    }
}
