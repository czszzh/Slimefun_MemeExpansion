package me.czssj_.meme_expansion.Expansion.Material;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.czssj_.meme_expansion.Meme_Expansion;
import me.czssj_.meme_expansion.setup.Meme_Expansion_item;

public class Material_Final extends SlimefunItem implements Listener, RecipeDisplayItem, NotPlaceable
{
    public Material_Final(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() 
    {
        ItemUseHandler itemUseHandler = this::itemRightClick;
        addItemHandler(itemUseHandler);
        Bukkit.getPluginManager().registerEvents(this, Meme_Expansion.getInstance());
    }

    private void itemRightClick(PlayerRightClickEvent event)
    {
        event.cancel();
    }

    @EventHandler
    public void onPlayerAdvancement(PlayerAdvancementDoneEvent event) 
    {
        Player player = event.getPlayer();
        if (event.getAdvancement().getKey().getKey().contains("nether/all_effects")) 
        {
            player.getInventory().addItem(Meme_Expansion_item.MATERIAL_FINAL);
        }
    }

    @Override
    public List<ItemStack> getDisplayRecipes() 
    {
        List<ItemStack> displayRecipes = new ArrayList<>();
        displayRecipes.add(new CustomItemStack(Meme_Expansion_item.MATERIAL_FINAL, "§a获取方法", "§7完成进度 §f[§e为什么会变成这样呢?§f] §7后获得"));
        return displayRecipes;
    }

    
}
