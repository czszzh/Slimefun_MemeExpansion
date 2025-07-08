package me.czssj_.meme_expansion.Expansion.Items;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.czssj_.meme_expansion.Meme_Expansion;
import me.czssj_.meme_expansion.setup.Meme_Expansion_item;

public class Villager_Soul extends SlimefunItem implements NotPlaceable, Listener
{
    private static final Random random = new Random();

    public Villager_Soul(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister()
    {
        Bukkit.getPluginManager().registerEvents(this, Meme_Expansion.getInstance());
        addItemHandler((ItemUseHandler) PlayerRightClickEvent::cancel);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) 
    {
        if (event.getEntity().getType() == EntityType.VILLAGER) 
        {
            if(random.nextDouble() < 0.3)
            {
                event.getDrops().add(Meme_Expansion_item.VILLAGER_SOUL);
            }
        }
    }
}
