package me.czssj_.meme_expansion.Expansion.Items;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.czssj_.meme_expansion.Meme_Expansion;

public class JinKeLa extends SlimefunItem implements Listener
{

    public JinKeLa(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() 
    {
        Bukkit.getPluginManager().registerEvents(this, Meme_Expansion.getInstance());
        ItemUseHandler itemUseHandler = this::itemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void itemRightClick(PlayerRightClickEvent event)
    {
        event.cancel();
    }

    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractEvent event) 
    {
        Player p = event.getPlayer();
        ItemStack JKL = event.getItem();
        SlimefunItem sfItem = SlimefunItem.getByItem(JKL);

        if(sfItem != null && sfItem.getId().equals("EXPANSION_JINKELA"))
        {
            Block b = event.getClickedBlock();
            if(b != null)
            {
                BlockData blockData = b.getBlockData();

                if (blockData instanceof Ageable) 
                {
                    final Ageable cropage = (Ageable) b.getBlockData();
                    if (cropage.getAge() < cropage.getMaximumAge()) 
                    {
                        if (JKL.getAmount() > 1) 
                        {
                            JKL.setAmount(JKL.getAmount() - 1);
                        }
                        else 
                        {
                            p.getInventory().remove(JKL);
                        }

                        cropage.setAge(cropage.getMaximumAge());
                        b.setBlockData(cropage);

                        b.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, b.getLocation().add(0.5D, 0.5D, 0.5D),5, 0.1F, 0.1F, 0.1F);
                    }
                }
            }
        }
    }
}
