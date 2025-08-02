package me.czssj_.meme_expansion.Expansion.Items.Amulet;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.czssj_.meme_expansion.Expansion.Utils.AbstractAmulet;
import me.czssj_.meme_expansion.Meme_Expansion;

public class DamageReductionAmulet extends AbstractAmulet 
{
    private static final String DAMAGE_REDUCTION_META = "meme_damage_reduction";

    public DamageReductionAmulet(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) 
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void applyEffect(Player player) 
    {
        player.setMetadata(DAMAGE_REDUCTION_META, new FixedMetadataValue(Meme_Expansion.getInstance(), true));
    }

    @Override
    public void removeEffect(Player player) 
    {
        player.removeMetadata(DAMAGE_REDUCTION_META, Meme_Expansion.getInstance());
    }

    public static class DamageListener implements Listener 
    {
        @EventHandler
        public void onDamage(EntityDamageEvent event) 
        {
            if (!(event.getEntity() instanceof Player)) return;
            
            Player player = (Player) event.getEntity();
            if (player.hasMetadata(DAMAGE_REDUCTION_META)) event.setDamage(Math.max(0, event.getDamage() - 1));
        }
    }
}
