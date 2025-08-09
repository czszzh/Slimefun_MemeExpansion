package me.czssj_.meme_expansion.Expansion.Material;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemDropHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class OrPVPBoss_Star extends SimpleSlimefunItem<ItemDropHandler> 
{
    public OrPVPBoss_Star(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) 
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    @Nonnull
    public ItemDropHandler getItemHandler() 
    {
        return (e, p, item) -> {
            SlimefunItem sfItem = SlimefunItem.getByItem(item.getItemStack());
            if(isItem(item.getItemStack()))
            {
                if(sfItem != null && (sfItem.getId().equals("EXPANSION_ORPVPBOSS_STAR") || sfItem.getId().equals("EXPANSION_ZOMBIE_STICK")))
                {
                    Slimefun.runSync(() -> activate(p, item), 20L);
                    return true;
                }
            }
            return false;
        };
    }

    private void activate(@Nonnull Player p, @Nonnull Item item1) 
    {
        if(!item1.isValid())
        {
            return ;
        }

        Location loc = item1.getLocation();
        Collection<Entity> entites = loc.getWorld().getNearbyEntities(loc, 1.5, 1.5, 1.5, this::findCompatibleItem);
        Optional<Entity> optional = entites.stream().findFirst();

        if(optional.isPresent())
        {
            Item item2 = (Item) optional.get();
            ItemStack itemStack = item2.getItemStack();
            SlimefunItem sfItem1 = SlimefunItem.getByItem(item1.getItemStack());
            SlimefunItem sfItem2 = SlimefunItem.getByItem(itemStack);
            String id1 = sfItem1 != null? sfItem1.getId() : "";
            String id2 = sfItem2 != null? sfItem2.getId() : "";


            if(itemStack.getAmount() == 1 && (id1.equals("EXPANSION_ORPVPBOSS_STAR") && id2.equals("EXPANSION_ZOMBIE_STICK") || (id1.equals("EXPANSION_ZOMBIE_STICK") && id2.equals("EXPANSION_ORPVPBOSS_STAR"))))
            {
                loc.getWorld().strikeLightningEffect(loc);

                Slimefun.runSync(() -> 
                {
                    if(item1.isValid() && item2.isValid() && itemStack.getAmount() == 1) 
                    {
                        loc.getWorld().createExplosion(loc, 0);

                        item2.remove();
                        item1.remove();

                        loc.getWorld().dropItemNaturally(loc, new CustomItemStack(Material.DIAMOND_SWORD, "§f示例剑"));

                        p.sendMessage("§6物品生成成功!");
                    } 
                    else
                    {
                        p.sendMessage("§c物品生成失败!");
                    }
                },10L);
            }
        }
    }

    private boolean findCompatibleItem(@Nonnull Entity entity) 
    {
        if (entity instanceof Item item) 
        {
            return item.getPickupDelay() <= 0 && !isItem(item.getItemStack());
        }
        return false;
    }
}
