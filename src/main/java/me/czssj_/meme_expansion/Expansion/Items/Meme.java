package me.czssj_.meme_expansion.Expansion.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;

public class Meme extends SlimefunItem implements NotPlaceable 
{
    private final int level;

    public Meme(SubItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int level) {
        super(itemGroup, item, recipeType, recipe);
        this.level = level;
    }

    @Override
    public void preRegister() 
    {
        ItemUseHandler itemUseHandler = this::onRightClick;
        addItemHandler(itemUseHandler);
    }

    private void onRightClick(PlayerRightClickEvent event)
    {
        event.cancel();
        ItemStack item = event.getItem();
        ItemMeta meta = item.getItemMeta();
        
        if (meta == null || !meta.hasLore()) return;

        List<String> lore = meta.getLore();
        
        for (int i = 0; i < lore.size(); i++) 
        {
            if (lore.get(i).equals("§7未激活")) 
            {
                lore.set(i, getActivatedContent());
                break;
            }
        }

        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    private String getActivatedContent() 
    {
        List<String> contents = new ArrayList<>();
        
        switch (level) 
        {
            case 1 -> {
                // 粪
                contents.add("§a梗:§7 giao");
                contents.add("§a梗:§7 家人们谁懂啊");
                contents.add("§a梗:§7 yyds");
                contents.add("§a梗:§7 刚满18岁");
                contents.add("§a梗:§7 尊嘟假嘟");
                contents.add("§a梗:§7 奶龙");
                contents.add("§a梗:§7 懂得都懂");
                contents.add("§a梗:§7 114514 1919810");
                contents.add("§a梗:§7 gogogo出发咯");
                contents.add("§a梗:§7 浇给");
                contents.add("§a梗:§7 爸爸的雷达");
                contents.add("§a梗:§7 退!退!退!");
                contents.add("§a梗:§7 芭比Q");
                contents.add("§a梗:§7 吃个桃桃");
                contents.add("§4梗:§7 原神，启动!");
                contents.add("§4梗:§7 狗头保护");
                contents.add("§a梗:§7 让子弹飞");
            }
                
            case 2 -> {
                // 典
                contents.add("§6梗:§7 鸡你太美");
                contents.add("§6梗:§7 jet 2 holiday");
                contents.add("§6梗:§7 味真足!");
                contents.add("§6梗:§7 闪电五连鞭");
                contents.add("§6梗:§7 +3");
                contents.add("§6梗:§7 典 孝 乐 急 蚌 赢 润 麻 寄 摆 唐");
                contents.add("§6梗:§7 寄汤来咯！");
                contents.add("§6梗:§7 社交的手腕");
                contents.add("§6梗:§7 咕咕嘎嘎");
                contents.add("§6梗:§7 大运");
                contents.add("§6梗:§7 真香");
                contents.add("§6梗:§7 略有失重感");
                contents.add("§6梗:§7 刻意,这也言詹?");
                contents.add("§6梗:§7 阿米诺斯");
                contents.add("§6梗:§7 会赢的");
                contents.add("§6梗:§7 西西弗斯");
                contents.add("§6梗:§7 hi,我是癫佬");
                contents.add("§6梗:§7 ♂");
                contents.add("§6梗:§7 东百往事");
                contents.add("§6梗:§7 金坷垃");
                contents.add("§6梗:§7 蓝蓝路");
                contents.add("§6梗:§7 吴签");
                contents.add("§6梗:§7 ccb");
                contents.add("§6梗:§7 华强");
                contents.add("§6梗:§7 otto");
                contents.add("§6梗:§7 五个字神人");
                contents.add("§6梗:§7 棍母");
                contents.add("§4梗:§7 瑞克五代");
            }
                
            case 3 -> {
                // ？
                contents.add("§4梗:§7 田力");
                contents.add("§4梗:§7 集美");
                contents.add("§4梗:§7 耄耋");
                contents.add("§4梗:§7 绿帽龟");
                contents.add("§4梗:§7 沈河");
                contents.add("§4梗:§7 哈基米");
                contents.add("§4梗:§7 鸭脖");
                contents.add("§4梗:§7 诬汉大穴");
                contents.add("§4梗:§7 冰");
                contents.add("§4梗:§7 曼波");
                contents.add("§4梗:§7 笑传");
                contents.add("§4梗:§7 客中理");
                contents.add("§4梗:§7 女拳");
                contents.add("§4梗:§7 知心大姐姐");
                contents.add("§4梗:§7 小镇做题家");
            }
        }
        
        if (contents.isEmpty()) return "§7err0r";
        
        return contents.get(new Random().nextInt(contents.size()));
    }
}
