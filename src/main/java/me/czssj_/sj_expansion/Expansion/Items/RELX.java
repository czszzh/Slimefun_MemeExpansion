package me.czssj_.sj_expansion.Expansion.Items;

import java.util.List;
import java.util.Random;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;

public class RELX extends SlimefunItem implements NotPlaceable,Rechargeable
{
    private final float capacity;
    private static final float COST = 0.5F;
    private Random random = new Random();

    public RELX(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, float capacity)
    {
        super(itemGroup, item, recipeType, recipe);
        this.capacity = capacity;
    }

    @Override
    public void preRegister() 
    {
        ItemUseHandler itemUseHandler = this::itemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void itemRightClick(PlayerRightClickEvent event)
    {
        Player p = event.getPlayer();
        if (removeItemCharge(event.getItem(), COST))
        {
            p.spawnParticle(Particle.CLOUD, p.getEyeLocation(), 100, 0.5, 0.5, 0.5, 0.2);
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_BREATH, SoundCategory.MASTER, 1.0f, 1.0f);
            if(random.nextDouble() < 0.3)
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200,1));
            }
            List<Entity> nearbyEntities = p.getNearbyEntities(1.5, 1.5, 1.5);
            for (Entity entity : nearbyEntities) 
            {
                if (entity instanceof LivingEntity) 
                {
                    //p.sendMessage("Found LivingEntity: " + entity.getType().name());
                    if(random.nextDouble() < 0.3)
                    {   
                        ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 1));
                    }
                }
            }
        }
        event.cancel();
    }

    @Override
    public float getMaxItemCharge(ItemStack item) 
    {
        return capacity;
    }
}
