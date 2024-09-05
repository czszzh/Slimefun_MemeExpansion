package me.czssj_.sj_expansion.Expansion.Items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.czssj_.sj_expansion.sj_Expansion;
import me.czssj_.sj_expansion.setup.sj_Expansion_item;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Nonnull;

public class Basketball extends SlimefunItem implements NotPlaceable, Listener, RecipeDisplayItem
{
    private Random random = new Random();
    private Map<UUID, Long> lastShotTime = new HashMap<>();
    private static final long COOLDOWN_MILLIS = 500;

    public Basketball(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
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
        Player p = event.getPlayer();
        ItemStack helmet = p.getInventory().getHelmet();
        long currentTime = System.currentTimeMillis();
        if (lastShotTime.containsKey(p.getUniqueId()) && currentTime - lastShotTime.get(p.getUniqueId()) < COOLDOWN_MILLIS) 
        {
            event.cancel();
            return;
        }
        lastShotTime.put(p.getUniqueId(), currentTime);
        if(helmet != null)
        {
            SlimefunItem sfItem = SlimefunItem.getByItem(helmet);
            if (sfItem != null && sfItem.getId().equals("EXPANSION_IKUN_PRIME"))
            {
                launchProjectile(p, Egg.class);
            }
            else
            {
                launchProjectile(p, Snowball.class);
            }
        }
        else
        {
            launchProjectile(p, Snowball.class);
        }
        p.playSound(p.getLocation(), Sound.ENTITY_EGG_THROW, SoundCategory.MASTER, 1.0f, 1.0f);
        event.cancel();
    }

    private void launchProjectile(Player player, Class<? extends Projectile> projectileClass) 
    {
        Projectile projectile = player.launchProjectile(projectileClass);
        projectile.setShooter(player);
    }

    @EventHandler
    public void onBallHit(ProjectileHitEvent event) 
    {
        if (event.getEntity() instanceof Snowball || event.getEntity() instanceof Egg) 
        {
            if (event.getHitEntity() instanceof LivingEntity && !(event.getHitEntity() instanceof Player))
            {
                LivingEntity hitEntity = (LivingEntity) event.getHitEntity();
                hitEntity.damage(2.5);
                if (random.nextDouble() < 0.075)
                {
                    hitEntity.getWorld().spawnEntity(hitEntity.getLocation(), EntityType.CHICKEN);
                    hitEntity.remove();
                }
            }
        }
    }

    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() 
    {
        List<ItemStack> displayRecipes = new ArrayList<>();
        displayRecipes.add(new CustomItemStack(sj_Expansion_item.IKUN_PRIME, "§bikun精华", "§f在头顶佩戴"));
        displayRecipes.add(new CustomItemStack(Material.EGG, "§f投掷鸡蛋"));
        return displayRecipes;
    }
}