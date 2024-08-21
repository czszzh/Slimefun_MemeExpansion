package me.czssj_.sj_expansion.Expansion.Items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class Basketball extends SlimefunItem implements NotPlaceable, Listener
{
    private Random random = new Random();

    public Basketball(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() 
    {
        addItemHandler((ItemUseHandler) PlayerRightClickEvent::cancel);
        ItemUseHandler itemUseHandler = this::itemRightClick;
        addItemHandler(itemUseHandler);
        JavaPlugin plugin = JavaPlugin.getProvidingPlugin(Basketball.class);
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    private void itemRightClick(PlayerRightClickEvent event)
    {
        Player p = event.getPlayer();
        p.launchProjectile(Snowball.class);
        p.playSound(p.getLocation(), Sound.ENTITY_EGG_THROW, SoundCategory.MASTER, 1.0f, 1.0f);
        event.cancel();
    }

    @EventHandler
    public void onSnowballHit(ProjectileHitEvent event) 
    {
        if (event.getEntity() instanceof Snowball) 
        {
            if (event.getHitEntity() instanceof LivingEntity && !(event.getHitEntity() instanceof Player)) {
                LivingEntity hitEntity = (LivingEntity) event.getHitEntity();
                hitEntity.damage(0.25);
                if (random.nextDouble() < 0.025)
                {
                    hitEntity.getWorld().spawnEntity(hitEntity.getLocation(), EntityType.CHICKEN);
                    hitEntity.remove();
                }
            }
        }
    }
}