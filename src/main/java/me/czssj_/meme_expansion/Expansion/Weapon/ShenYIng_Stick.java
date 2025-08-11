package me.czssj_.meme_expansion.Expansion.Weapon;

import java.util.Random;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.WeaponUseHandler;
import me.czssj_.meme_expansion.Expansion.Utils.msgUtils;
import me.czssj_.meme_expansion.Meme_Expansion;

public class ShenYIng_Stick extends SlimefunItem implements WeaponUseHandler
{
    private long lastUsedTime1 = 0;
    private long lastUsedTime2 = 0;
    Random random = new Random();

    private static final String[] MESSAGES1 = {
        ": 装逼,我让你飞起来!",
        ": 小b崽子! 你是真没见过黑社会呀! 敢不敢比划什么叫黑手?", 
        ": 你mb是不是给你脸给多了?",
        ": 你是个嘚儿, 我指你脑门子啊, 再嘚瑟就大嘴巴子㨃死你。听懂了吗?",
        ": 你们怎么这么自私? 我呸! 呸!"
    };

    private static final String[] MESSAGES2 = {
        "飞起来!",
        "略有失重感"
    };

    public ShenYIng_Stick(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister()
    {
        WeaponUseHandler weaponUseHandler = this::onHit;
        addItemHandler(weaponUseHandler);
        ItemUseHandler itemUseHandler = this::itemRightClick;
        addItemHandler(itemUseHandler);
    }

    @Override
    public void onHit(@Nonnull EntityDamageByEntityEvent e, @Nonnull Player player, @Nonnull ItemStack item) 
    {
            long currentTime = System.currentTimeMillis();
            
            if (random.nextDouble() < 0.25 && currentTime - lastUsedTime1 > 5000) 
            {
                lastUsedTime1 = currentTime;
                String message = MESSAGES1[random.nextInt(MESSAGES1.length)];
                Bukkit.broadcastMessage(player.getName() + message);

                Entity target = e.getEntity();
                boolean originalGravity = target.hasGravity();
                target.setGravity(false);
                target.setVelocity(new org.bukkit.util.Vector(0, 0.75, 0));
            
            Bukkit.getScheduler().runTaskLater(Meme_Expansion.getInstance(), () -> {
                if (target.isValid()) target.setGravity(originalGravity);
            }, 40L);
        }
    }

    private void itemRightClick(PlayerRightClickEvent event)
    {
        Player p = event.getPlayer();
        boolean hasGravity = p.hasGravity();

        long currentTime = System.currentTimeMillis();
        if (currentTime - lastUsedTime2 < 5000) 
        {
            msgUtils.sendActionBar(p, "§c冷却中: " + (5 - (currentTime - lastUsedTime2)/1000) + "秒");
            return;
        }

        p.setGravity(false);
        String message = MESSAGES2[random.nextInt(MESSAGES2.length)];
        msgUtils.sendActionBar(p, message);
        p.setVelocity(new org.bukkit.util.Vector(0, 0.75, 0));
        lastUsedTime2 = currentTime;
        Bukkit.getScheduler().runTaskLater(Meme_Expansion.getInstance(), () -> {
            p.setGravity(hasGravity);
        }, 40L);
    }
}
