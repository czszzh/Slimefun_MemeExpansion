package me.czssj_.meme_expansion.Expansion.Items;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerBackpack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.backpacks.SlimefunBackpack;
import me.czssj_.meme_expansion.Expansion.Utils.AbstractAmulet;
import me.czssj_.meme_expansion.Meme_Expansion;

public class AmuletBackpack extends SlimefunBackpack implements Listener 
{
    private final AmuletBackpack amuletBackpack;

    public AmuletBackpack(int size, ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) 
    {
        super(size, itemGroup, item, recipeType, recipe);
        amuletBackpack = this;
        new BukkitRunnable() 
        {
            @Override
            public void run() 
            {
                for (Player p : Bukkit.getOnlinePlayers()) 
                {
                    if (amuletBackpack == null && amuletBackpack.isDisabled()) return;
                    for (ItemStack item : p.getInventory().getContents())
                    {
                        if (amuletBackpack.isItem(item) || SlimefunItem.getByItem(item) instanceof AmuletBackpack)
                        {
                            if (amuletBackpack.canUse(p, true)) getAmuletFromBackpack(p, item);
                            else return;
                        }
                    }
                }
            }
        }.runTaskTimer(Meme_Expansion.getInstance(), 0, 40);
    }

    private void getAmuletFromBackpack(@Nonnull Player p, @Nonnull ItemStack amuletBackPack) 
    {
        PlayerBackpack.getAsync(amuletBackPack, backpack -> {
            if (backpack != null) activateAmuletsInBackpack(p, amuletBackPack, backpack);
        }, true);
    }

    public static void activateAmuletsInBackpack(@Nonnull Player p, @Nonnull ItemStack picnicBasketItem, @Nonnull PlayerBackpack backpack) 
    {
        Inventory inv = backpack.getInventory();
        for(int i = 0; i < inv.getSize(); i++)
        {
            ItemStack item = inv.getItem(i);
            if (item != null)
            {
                SlimefunItem sfItem = SlimefunItem.getByItem(item);
                if (sfItem instanceof AbstractAmulet amulet && !amulet.isEnabled()) amulet.toggleEnabled(p, item);
            }
        }
    }
}
