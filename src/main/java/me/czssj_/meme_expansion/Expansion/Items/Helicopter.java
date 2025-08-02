package me.czssj_.meme_expansion.Expansion.Items;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.czssj_.meme_expansion.Meme_Expansion;
import me.czssj_.meme_expansion.setup.Meme_Expansion_item;

public class Helicopter extends SlimefunItem implements NotPlaceable
{
    private final Random random = new Random();

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
            if (sfItem != null && sfItem.getId().equals("EXPANSION_KOBE"))
            {
                if (random.nextDouble() < 0.05)
                {
                    event.getPlayer().removePotionEffect(PotionEffectType.LEVITATION);
                    Vector velocity = event.getPlayer().getVelocity();
                    velocity.setY(-1000);
                    Bukkit.getScheduler().runTaskLater(Meme_Expansion.getInstance(), () -> {
                        event.getPlayer().setLastDamageCause(new EntityDamageEvent(event.getPlayer(), EntityDamageEvent.DamageCause.ENTITY_EXPLOSION, 1000));
                        event.getPlayer().setHealth(0);
                        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, SoundCategory.MASTER, 1.0f, 1.0f);
                        Bukkit.broadcastMessage(event.getPlayer().getName() + " 坠机身亡");
                        event.getPlayer().getInventory().setHelmet(Meme_Expansion_item.MAMBA_SPIRIT);
                    }, 20L);
                    
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
        event.cancel();
    }
}