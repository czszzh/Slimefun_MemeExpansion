package me.czssj_.meme_expansion.Expansion.Items;

import javax.annotation.Nonnull;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.WeaponUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.LimitedUseItem;
import me.czssj_.meme_expansion.Meme_Expansion;

//为什么要重新写一个文件呢？只加了2行代码
//懒
public class MobItemLoot extends LimitedUseItem implements WeaponUseHandler
{
    public static final int MAX_USES = 5;
    private static final NamespacedKey usageKey = new NamespacedKey(Meme_Expansion.getInstance(), "MobItemLoot_usage");

    public MobItemLoot(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
        setMaxUseCount(MAX_USES);
    }

    @Override
    protected @Nonnull NamespacedKey getStorageKey() 
    {
        return usageKey;
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
        if (e.getEntity() instanceof LivingEntity && !(e.getEntity() instanceof Player)) 
        {
            LivingEntity target = (LivingEntity) e.getEntity();
            EntityEquipment equipment = target.getEquipment();
            ItemStack mainHandItem = equipment.getItemInMainHand();
            if (!equipment.getItemInMainHand().getType().isAir()) 
            {
                player.getInventory().addItem(mainHandItem);
                equipment.setItemInMainHand(null);
                damageItem(player, item);
            }
        }
    }

    //用来防止报错(
    private void itemRightClick(PlayerRightClickEvent event)
    {
        event.cancel();
    }

    @Override 
    public @Nonnull ItemUseHandler getItemHandler() 
    {
        return this::itemRightClick;
    }
}