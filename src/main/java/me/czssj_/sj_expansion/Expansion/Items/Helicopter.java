package me.czssj_.sj_expansion.Expansion.Items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Random;

public class Helicopter extends SlimefunItem
{
    private Random random = new Random();

    public Helicopter(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister()
    {
        ItemUseHandler itemUseHandler = this::itemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void itemRightClick(PlayerRightClickEvent event)
    {
        ItemStack helmet = event.getPlayer().getInventory().getHelmet();
        if (helmet != null)
        {
            SlimefunItem sfItem = SlimefunItem.getByItem(helmet);
            if (sfItem != null && sfItem.getId().equals("KOBE"))
            {
                if (random.nextDouble() < 0.02)
                {
                    event.getPlayer().removePotionEffect(PotionEffectType.LEVITATION);
                    Vector velocity = event.getPlayer().getVelocity();
                    velocity.setY(-1000);
                    event.getPlayer().setLastDamageCause(new EntityDamageEvent(event.getPlayer(), EntityDamageEvent.DamageCause.ENTITY_EXPLOSION, 1000));
                    event.getPlayer().setHealth(0);
                    event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, SoundCategory.MASTER, 1.0f, 1.0f);
                    Bukkit.broadcastMessage(event.getPlayer().getName() + " 坠机身亡");
                }
                else
                {
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 5, 4));
                }
            }
            else
            {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 5, 4));
            }
        }
        else
        {
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 5, 4));
        }
    }
}