package me.czssj_.sj_expansion.Expansion.Items;

import java.util.Random;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.czssj_.sj_expansion.setup.sj_Expansion_item;

public class Villager_Soul extends SlimefunItem implements NotPlaceable, Listener
{
    private static final Random random = new Random();

    public Villager_Soul(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    public void preRegister()
    {
        JavaPlugin plugin = JavaPlugin.getProvidingPlugin(Villager_Soul.class);
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        addItemHandler((ItemUseHandler) PlayerRightClickEvent::cancel);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) 
    {
        if (event.getEntity().getType() == EntityType.VILLAGER) 
        {
            if(random.nextDouble() < 0.3)
            {
                event.getDrops().add(sj_Expansion_item.VILLAGER_SOUL);
            }
        }
    }
}
