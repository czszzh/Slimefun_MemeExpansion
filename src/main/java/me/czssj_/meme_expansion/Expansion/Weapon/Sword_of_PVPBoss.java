package me.czssj_.meme_expansion.Expansion.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.core.handlers.WeaponUseHandler;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.czssj_.meme_expansion.Meme_Expansion;

public class Sword_of_PVPBoss extends SlimefunItem implements WeaponUseHandler, Listener, RecipeDisplayItem
{
    Random random = new Random();

    public Sword_of_PVPBoss(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister()
    {        
        WeaponUseHandler weaponUseHandler = this::onHit;
        addItemHandler(weaponUseHandler);
        Bukkit.getPluginManager().registerEvents(this, Meme_Expansion.getInstance());
    }

    @Override
    public void onHit(@Nonnull EntityDamageByEntityEvent e, @Nonnull Player p, @Nonnull ItemStack item) 
    {
        if(e.getEntity() instanceof LivingEntity target && p.getHealth() > 0)
        {
            Location targetloc = target.getLocation();
            double damage = e.getDamage();

            if(target instanceof Zombie) 
            {
                e.setDamage(damage * 2);
                p.setHealth(Math.min(p.getHealth() + damage * 0.5, p.getMaxHealth()));
            }
            else
            {
                target.getWorld().getNearbyEntities(targetloc, 10, 5, 10).stream()
                    .filter(entity -> entity instanceof Zombie)
                    .map(entity -> (Zombie) entity)
                    .filter(zombie -> !zombie.equals(target))
                    .forEach(zombie -> zombie.setTarget(target));
                
                p.setHealth(Math.min(p.getHealth() + damage * 0.1, p.getMaxHealth()));
            }

            if (random.nextDouble() < 0.1)
            {
                Zombie zombie = p.getWorld().spawn(targetloc, Zombie.class);
                zombie.getEquipment().setHelmet(new ItemStack(Material.ROTTEN_FLESH));
            }
        }
    }

    @EventHandler
    public void onEntityTarget(EntityTargetEvent event) 
    {
        if(event.getTarget() instanceof Player player && event.getEntity() instanceof Zombie && event.getReason() != EntityTargetEvent.TargetReason.TARGET_DIED) 
        {
            ItemStack mainHand = player.getInventory().getItemInMainHand();

            if (SlimefunItem.getByItem(mainHand) == this) 
            {
                event.setCancelled(true);
            }
        }
    }

    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() 
    {
        List<ItemStack> displayRecipes = new ArrayList<>();
        displayRecipes.add(new CustomItemStack(Material.PAPER, "§f获取方法", 
                                                               "§3将以上两者丢在一起即可获得", 
                                                               "§3若是物品生成失败就重新丢到地上"));
        displayRecipes.add(new CustomItemStack(Material.AIR));
        displayRecipes.add(new CustomItemStack(Material.ENCHANTED_BOOK, "§f吸血效果", 
                                                                        "§3对僵尸:造成的伤害的50%作为自己的生命恢复量", 
                                                                        "§3对其他生物:造成的伤害的10%作为自己的生命恢复量"));
        displayRecipes.add(new CustomItemStack(Material.AIR));
        displayRecipes.add(new CustomItemStack(Material.ENCHANTED_BOOK, "§f僵尸统领效果",
                                                                        "§3攻击时有10%的几率召唤一个僵尸", 
                                                                        "§3对僵尸的伤害为原本的2倍", 
                                                                        "§3在主手时: 周围的僵尸将不再对你引起仇恨", 
                                                                        "§310格半径内的僵尸将主动攻击你所攻击的非僵尸目标(test)"));
        return displayRecipes;
    }
}
