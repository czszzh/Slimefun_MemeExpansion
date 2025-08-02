package me.czssj_.meme_expansion.Expansion.Machines;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinitylib.machines.AbstractMachineBlock;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.czssj_.meme_expansion.setup.Meme_Expansion_item;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

public class Raid_Simulator extends AbstractMachineBlock implements RecipeDisplayItem
{
    int level;
    private static final int STATUS_SLOT = 18;
    private static final int BASE_WAVE_DURATION = 1200;
    private static final String LAST_WAVE_TIME_KEY = "lastWaveTime";
    private static final int[] INPUT_SLOT = {4};
    private static final int[] OUTPUT_SLOT = {37,38,39,40,41,42,43,46,47,48,49,50,51,52};
    int wave = 1;
    
    //[掠夺者, 卫道士, 唤魔者, 女巫]
    private static final int[][] WAVE_MOBS = {
        {4, 0, 0, 0},   // 波1
        {3, 2, 0, 0},   // 波2
        {3, 0, 0, 0},   // 波3
        {4, 1, 0, 3},   // 波4
        {4, 4, 1, 0},   // 波5
        {4, 2, 1, 0},   // 波6
        {2, 5, 2, 1}    // 波7
    };

    public Raid_Simulator(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int level)
    {
        super(itemGroup, item, recipeType, recipe);
        this.level = level;
    }

    @Override
    protected void setup(@Nonnull BlockMenuPreset blockMenuPreset) 
    {
        blockMenuPreset.drawBackground(new int[]{1,2,6,7,9,10,11,15,16,17});
        blockMenuPreset.drawBackground(new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE, "§a输入"), new int[]{3,5,12,13,14});
        blockMenuPreset.drawBackground(new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE, "§a输出"), new int[]{27,28,29,30,31,32,33,34,35,36,44,45,53});
        blockMenuPreset.drawBackground(new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "§c进度"), new int[]{19,20,21,22,23,24,25,26});
        blockMenuPreset.drawBackground(new CustomItemStack(Material.BELL, "§a波数"), new int[]{18});

        blockMenuPreset.drawBackground(new CustomItemStack(Material.PAPER, "§f波数对应怪物数量说明", 
        "§f 波次 |掠夺者|卫道士|唤魔者|女巫",
        "§3第1波 |  4  |  0  |  0  |  0  ",
        "§3第2波 |  3  |  2  |  0  |  0  ",
        "§3第3波 |  3  |  0  |  0  |  0  ",
        "§3第4波 |  4  |  1  |  0  |  3  ",
        "§3第5波 |  4  |  4  |  1  |  0  ",
        "§3第6波 |  4  |  2  |  1  |  0  ",
        "§3第7波 |  2  |  5  |  2  |  1  "), new int[]{0});

        blockMenuPreset.drawBackground(new CustomItemStack(Material.EMERALD, "§f输出说明",
        "§3按照java版各生物wiki中的掉落概率(无抢夺附魔)输出物品",
        "§3忽略掉落数量中概率小于1%的数量分布,剩下的分布概率均分",
        "§3已去除对于装备的掉落",
        "§3对于掠夺者,额外增加对于箭与绿宝石的掉落",
        "----------------------------------------",
        "§f1个掠夺者:",
        "§7 -66.6% 掉落0-2个箭",
        "§7 -50%   掉落1个绿宝石",
        "§0byd java版的就掉个弩",
        "§f1个卫道士:",
        "§7 -50%   掉落1个绿宝石",
        "----------------------------------------",
        "§f1个唤魔者:",
        "§7 -100%  掉落1个不死图腾",
        "§7 -50%   掉落1个绿宝石",
        "----------------------------------------",
        "§f1个女巫:",
        "§7 -100%  掉落4-8个红石粉",
        "§3以下的掉落物只有其中一种或没有",
        "§7 -17.9% 掉落0-2个玻璃瓶",
        "§7 -17.9% 掉落0-2个荧石粉",
        "§7 -17.9% 掉落0-2个火药",
        "§7 -17.9% 掉落0-2个蜘蛛眼",
        "§7 -17.9% 掉落0-2个糖",
        "§7 -33.5% 掉落0-4个木棍",
        "----------------------------------------",
        "§4每一波额外掉落一个经验块"), new int[]{8});
    }

    private int getWaveDuration() 
    {
        return level == 2 ? BASE_WAVE_DURATION / 4 : BASE_WAVE_DURATION;
    }

    @Override
    protected boolean process(@Nonnull Block b,@Nonnull BlockMenu menu) 
    {
        String lastWaveTimeStr = BlockStorage.getLocationInfo(b.getLocation(), LAST_WAVE_TIME_KEY);
        long lastWaveTime = lastWaveTimeStr != null ? Long.parseLong(lastWaveTimeStr) : 0;

        if (lastWaveTime == 0) 
        {
            ItemStack input = menu.getItemInSlot(INPUT_SLOT[0]);
            if (input == null) return false;
            
            SlimefunItem sfItem = SlimefunItem.getByItem(input);
            if (sfItem == null || !sfItem.getId().equals("EXPANSION_BAD_OMEN_POTION")) return false;

            lastWaveTime = System.currentTimeMillis();
            BlockStorage.addBlockInfo(b.getLocation(), LAST_WAVE_TIME_KEY, String.valueOf(lastWaveTime));
            input.setAmount(input.getAmount() - 1);
        }
        else 
        {
            ItemStack status = menu.getItemInSlot(STATUS_SLOT);
            if (status != null && status.hasItemMeta() && status.getItemMeta().hasLore()) 
            {
                String lore = status.getItemMeta().getLore().get(0);
                try { wave = Integer.parseInt(lore.replace("§a当前波数: ", "")); } 
                catch (NumberFormatException ignored) {}
            }
        }

        long currentTime = System.currentTimeMillis();
        long elapsedTicks = (currentTime - lastWaveTime) / 50;

        if (elapsedTicks >= getWaveDuration()) 
        {
            if (wave < 7) 
            {
                wave++;
                lastWaveTime = currentTime;

                BlockStorage.addBlockInfo(b.getLocation(), LAST_WAVE_TIME_KEY, String.valueOf(lastWaveTime));
                BlockStorage.addBlockInfo(b.getLocation(), "current_wave", String.valueOf(wave));
                elapsedTicks = 0;
                generateLoot(menu, wave);
            } 
            else 
            {
                BlockStorage.addBlockInfo(b.getLocation(), LAST_WAVE_TIME_KEY, null);
                BlockStorage.addBlockInfo(b.getLocation(), "current_wave", null);
                wave = 1;
                for (int i = 19; i <= 26; i++) menu.replaceExistingItem(i, new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "§f进度"));
                menu.replaceExistingItem(18, new CustomItemStack(Material.BELL, "§a波数"));
                return true;
            }
        }

        menu.replaceExistingItem(STATUS_SLOT, new CustomItemStack(Material.BELL, "§a波数", "§7当前波数: " + wave));
        updateProgressBar(menu, elapsedTicks);

        return true;
    }

    private void generateLoot(BlockMenu menu, int wave) 
    {
        int waveIndex = wave - 1;
        if (waveIndex >= 0 && waveIndex < WAVE_MOBS.length) 
        {
            int raiders = WAVE_MOBS[waveIndex][0];
            int vindicators = WAVE_MOBS[waveIndex][1];
            int evokers = WAVE_MOBS[waveIndex][2];
            int witches = WAVE_MOBS[waveIndex][3];
            
            for (int i = 0; i < raiders; i++) generatePillagerLoot(menu);           
            for (int i = 0; i < vindicators; i++) generateVindicatorLoot(menu);          
            for (int i = 0; i < evokers; i++) generateEvokerLoot(menu);
            for (int i = 0; i < witches; i++) generateWitchLoot(menu);

            menu.pushItem(new CustomItemStack(Meme_Expansion_item.EXPERIENCE_BLOCK, 1), OUTPUT_SLOT);
        }
    }

    private void generatePillagerLoot(BlockMenu menu) 
    {
        Random random = new Random();
        
        if (random.nextDouble() <= 0.5) menu.pushItem(new ItemStack(Material.EMERALD, 1), OUTPUT_SLOT);

        if (random.nextDouble() <= 0.666) 
        {
            int arrows = random.nextInt(3);
            if (arrows > 0) 
            {
                menu.pushItem(new ItemStack(Material.ARROW, arrows), OUTPUT_SLOT);
            }
        }
    }

    private void generateVindicatorLoot(BlockMenu menu)
    {
        Random random = new Random();
        
        if (random.nextDouble() <= 0.5) menu.pushItem(new ItemStack(Material.EMERALD, 1), OUTPUT_SLOT);
    }

    private void generateEvokerLoot(BlockMenu menu) 
    {
        Random random = new Random();
        
        menu.pushItem(new ItemStack(Material.TOTEM_OF_UNDYING, 1), OUTPUT_SLOT);
        if (random.nextDouble() <= 0.5) menu.pushItem(new ItemStack(Material.EMERALD, 1), OUTPUT_SLOT);
    }

    private void generateWitchLoot(BlockMenu menu) 
    {
        Random random = new Random();
        boolean flag = false;
        
        menu.pushItem(new ItemStack(Material.REDSTONE, 4 + random.nextInt(5)), OUTPUT_SLOT);
        
        Material[] otherDrops = {
            Material.GLASS_BOTTLE,
            Material.GLOWSTONE_DUST,
            Material.GUNPOWDER,
            Material.SPIDER_EYE,
            Material.SUGAR,
        };
        
        for (int i = 0; i < 5; i++) 
        {
            if(random.nextDouble() <= 0.179)
            {
                Material drop = otherDrops[random.nextInt(otherDrops.length)];
                int amount = random.nextInt(3);
                if (amount > 0) 
                {
                    menu.pushItem(new ItemStack(drop, amount), OUTPUT_SLOT);
                    flag = true;
                    break;
                }
            }
        }

        if(random.nextDouble() <= 0.335 && flag == false)
        {
            int amount = random.nextInt(5);
            if (amount > 0) menu.pushItem(new ItemStack(Material.STICK, amount), OUTPUT_SLOT);
        }
    }

    private void updateProgressBar(BlockMenu menu, long elapsedTicks) 
    {
        int progress = (int) (8 * elapsedTicks / getWaveDuration());
        int remainingSeconds = (getWaveDuration() - (int)elapsedTicks) / 20;
        
        for (int i = 19; i <= 26; i++) 
        {
            if (i - 19 < progress) menu.replaceExistingItem(i, new CustomItemStack(Material.LIME_STAINED_GLASS_PANE, "§f进度", "§e本波袭击结束倒计时: " + remainingSeconds + "秒"));
            else menu.replaceExistingItem(i, new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "§f进度", "§e本波袭击结束倒计时: " + remainingSeconds + "秒"));
        }
    }

    @Override
    protected int getStatusSlot() 
    {   
        return STATUS_SLOT;
    }

    @Override
    protected int[] getInputSlots() 
    {
        return INPUT_SLOT;
    }

    @Override
    protected int[] getOutputSlots() 
    {
        return OUTPUT_SLOT;
    }

    @Override
    @Nonnull
    public List<ItemStack> getDisplayRecipes() 
    {
        List<ItemStack> displayRecipes = new ArrayList<>();
        displayRecipes.add(new CustomItemStack(Material.PAPER, "§f波数对应怪物数量说明", 
        "§f 波次 |掠夺者|卫道士|唤魔者|女巫",
        "§3第1波 |  4  |  0  |  0  |  0  ",
        "§3第2波 |  3  |  2  |  0  |  0  ",
        "§3第3波 |  3  |  0  |  0  |  0  ",
        "§3第4波 |  4  |  1  |  0  |  3  ",
        "§3第5波 |  4  |  4  |  1  |  0  ",
        "§3第6波 |  4  |  2  |  1  |  0  ",
        "§3第7波 |  2  |  5  |  2  |  1  "));
        displayRecipes.add(new ItemStack(Material.AIR));
        displayRecipes.add(new CustomItemStack(Material.EMERALD, "§f输出说明",
        "§3按照java版各生物wiki中的掉落概率(无抢夺附魔)输出物品",
        "§3忽略掉落数量中概率小于1%的数量分布,剩下的分布概率均分",
        "§3已去除对于装备的掉落",
        "§3对于掠夺者,额外增加对于箭与绿宝石的掉落",
        "----------------------------------------",
        "§f1个掠夺者:",
        "§7 -66.6% 掉落0-2个箭",
        "§7 -50%   掉落1个绿宝石",
        "----------------------------------------",
        "§f1个卫道士:",
        "§7 -50%   掉落1个绿宝石",
        "----------------------------------------",
        "§f1个唤魔者:",
        "§7 -100%  掉落1个不死图腾",
        "§7 -50%   掉落1个绿宝石",
        "----------------------------------------",
        "§f1个女巫:",
        "§7 -100%  掉落4-8个红石粉",
        "§3以下的掉落物只有其中一种或没有",
        "§7 -17.9% 掉落0-2个玻璃瓶",
        "§7 -17.9% 掉落0-2个荧石粉",
        "§7 -17.9% 掉落0-2个火药",
        "§7 -17.9% 掉落0-2个蜘蛛眼",
        "§7 -17.9% 掉落0-2个糖",
        "§7 -33.5% 掉落0-4个木棍",
        "----------------------------------------",
        "§4每一波额外掉落一个经验块"));
        return displayRecipes;
    }
}
