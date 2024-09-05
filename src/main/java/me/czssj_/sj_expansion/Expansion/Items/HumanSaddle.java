package me.czssj_.sj_expansion.Expansion.Items;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.czssj_.sj_expansion.sj_Expansion;

public class HumanSaddle extends SlimefunItem implements Listener
{
    public HumanSaddle(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() 
    {
        Bukkit.getPluginManager().registerEvents(this, sj_Expansion.getInstance());
    }

    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) 
    {
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        SlimefunItem sfItem = SlimefunItem.getByItem(itemInHand);

        if ((sfItem != null && sfItem.getId().equals("EXPANSION_HUMANSADDLE"))) 
        {
            Player target = event.getRightClicked() instanceof Player ? (Player) event.getRightClicked() : null;

            if (target != null && !target.equals(player) && target.isOnline() && !target.isInsideVehicle()) 
            {
                if (!target.addPassenger(player)) 
                {
                    player.sendMessage("无法骑乘 " + target.getName());
                    return;
                }
                target.sendMessage(player.getName() + " 成功骑乘了你");
            }
        }
    }
}
