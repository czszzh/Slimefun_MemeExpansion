package me.czssj_.sj_expansion.Expansion.Weapon;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.czssj_.sj_expansion.sj_Expansion;

public class Grenade extends SlimefunItem implements Listener
{
    public Grenade(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister()
    {
        ItemUseHandler itemUseHandler = this::itemRightClick;
        addItemHandler(itemUseHandler);
        Bukkit.getPluginManager().registerEvents(this, sj_Expansion.getInstance());
    }

    private void itemRightClick(PlayerRightClickEvent event)
    {
        Player player = event.getPlayer();
        ItemStack grenade = event.getItem();

        ThrownPotion thrownPotion = player.launchProjectile(ThrownPotion.class);
        thrownPotion.setVelocity(thrownPotion.getVelocity().multiply(1.5));
        
        if (grenade.getAmount() > 1) 
        {
            grenade.setAmount(grenade.getAmount() - 1);
        }
        else 
        {
            player.getInventory().remove(grenade);
        }
        event.cancel();
    }

    @EventHandler
    public void onPotionSplash(PotionSplashEvent event) 
    {
        ThrownPotion thrownPotion = event.getEntity();
        if (thrownPotion.getShooter() instanceof Player) 
        {
            Player player = (Player) thrownPotion.getShooter();
            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            SlimefunItem sfItem = SlimefunItem.getByItem(itemInHand);
            if (sfItem != null && sfItem.getId().equals("GRENADE")) 
            {
                explode(thrownPotion.getLocation(), player);
            }
        }
    }

    private void explode(Location location, Player player) 
    {
        location.getWorld().createExplosion(location, 2.0F, false, false, player);
    }
}
