package me.czssj_.meme_expansion.setup;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.czssj_.meme_expansion.Expansion.Items.MobItemBan;
import me.czssj_.meme_expansion.Expansion.Items.MobItemLoot;


public class Meme_Expansion_item
{       
    //recipes
    public static final SlimefunItemStack VILLAGER_DROP = new SlimefunItemStack(
        "EXPANSION_VILLAGER_DROP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDVmNzI5NzM2OTk2YTM4ZTE4NmZlOWZlN2Y1YTA0YjM4N2VkMDNmMzg3MWVjYzgyZmE3OGQ4YTJiZGQzMTEwOSJ9fX0=",
        "§a§lVILLAGER",
        "§f有 §a30% §f的概率掉落"
    );

    public static final SlimefunItemStack ORPVPBOSS_DROP = new SlimefunItemStack(
        "EXPANSION_ORPVPBOSS_DROP",
        Material.ZOMBIE_HEAD,
        "§4§l击杀PVP大佬掉落"
    );

    public static final SlimefunItemStack NETHERSTAR_REACTOR_GET = new SlimefunItemStack(
        "EXPANSION_NETHERSTAR_REACTOR_GET",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTdiZjU3NzMyOGE4YTE4ZTU0Nzg0NGQxNDQ4NWMwN2JmYjg2YTAyODczZTk5MDc4NDMxNjQ0NTBjYTg4OGYwYiJ9fX0=",
        "§f通过 §6下界之星反应堆 §f- §4EX §f获得"
    );

    //arrow
    public static final SlimefunItemStack MENU_ARROW_LEFT = new SlimefunItemStack(
        "EXPANSION_MENUARROW_LEFT",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWQ3M2NmNjZkMzFiODNjZDhiODY0NGMxNTk1OGMxYjczYzhkOTczMjNiODAxMTcwYzFkODg2NGJiNmE4NDZkIn19fQ==",
        "§f上一个选项"
    );

    public static final SlimefunItemStack MENU_ARROW_RIGHT = new SlimefunItemStack(
        "EXPANSION_MENUARROW_RIGHT",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzg2MTg1YjFkNTE5YWRlNTg1ZjE4NGMzNGYzZjNlMjBiYjY0MWRlYjg3OWU4MTM3OGU0ZWFmMjA5Mjg3In19fQ==",
        "§f下一个选项"
    );

    //materials
    public static final SlimefunItemStack CONCENTRATED_MAGIC_LUMP = new SlimefunItemStack(
        "EXPANSION_CONCENTRATED_MAGIC_LUMP",
        Material.GOLD_INGOT,
        "§e压缩魔法结晶"
    );

    public static final SlimefunItemStack CONCENTRATED_ICE = new SlimefunItemStack(
        "EXPANSION_CONCENTRATED_ICE",
        Material.BLUE_ICE,
        "§b压缩冰",
        "",
        "我超，冰！！！！",
        ""
    );

    public static final SlimefunItemStack VILLAGER_SOUL = new SlimefunItemStack(
        "EXPANSION_VILLAGER_SOUL",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzc0OTJhYjc4NDI0NDNjNTMzMTVmOTBmMGU3MTQ0MGUxZTdlMTM2ZjU2ODkyYTc2MTU2NTA4MjU0NDExYWY0MiJ9fX0=",
        "§4村民的亡魂",
        "",
        "§1§k1§r§4§l奸商的毁灭§1§k1",
        ""
    );

    public static final SlimefunItemStack HELICOPTER_ENGINE = new SlimefunItemStack(
        "EXPANSION_HELICOPTER_ENGINE",
        SlimefunItems.ELECTRIC_MOTOR,
        "§3直升机引擎" ,
        "",
        "§f直升机零件",
        ""
    );

    public static final SlimefunItemStack HELICOPTER_GLASS = new SlimefunItemStack(
        "EXPANSION_HELICOPTER_GLASS",
        Material.PURPLE_STAINED_GLASS_PANE,
        "§9挡风玻璃" ,
        "",
        "§f直升机零件",
        ""
    );

    public static final SlimefunItemStack HELICOPTER_PROPELLER = new SlimefunItemStack(
        "EXPANSION_HELICOPTER_PROPELLER",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjM0OWZhODAyYjdkOWY2MmYzM2ExNjJhZTM1MTVhODRmYzhlNzY4ZjcwY2FkZTk3OTA3MzgyOWI5NjcyZDgyMyJ9fX0=",
        "§3直升机螺旋桨",
        "",
        "§f直升机零件",
        ""
    );

    public static final SlimefunItemStack EXPANSION_CORE = new SlimefunItemStack(
        "EXPANSION_CORE",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzAzMDIxMzkwZWY3NGI5NTg5ZWNlNTRkZmNkYjBhNDY0NGYxZGMwODMzY2Q2ZDg2MmM1OTAyMTBiYTVhM2E4ZiJ9fX0=",
        "§r拓展核心",
        "",
        "§r§k1§r§x§0§0§f§f§a§3梦§x§1§b§f§1§a§6开§x§3§6§e§3§a§9始§x§5§2§d§5§a§d的§x§6§d§c§7§b§0地§x§8§8§b§9§b§3方§r§k1",
        ""
    );

    public static final SlimefunItemStack MAGMA_BLOCK_MACHINECORE = new SlimefunItemStack(
        "EXPANSION_MAGMA_BLOCK_MACHINECORE",
        Material.PAPER,
        "岩浆块核心",
        "",
        "§3某个机器的合成替代物....",
        ""
     );

    public static final SlimefunItemStack OR_PARKOUR_GOD_UNIT = new SlimefunItemStack(
        "EXPANSION_OR_PARKOUR_GOD_UNIT",
        Material.STONE_BRICKS,
        "§f无论你是跑酷大神",
        "",
        "§3怎么还掉下去一次呢",
        ""
    );

    public static final SlimefunItemStack OR_SURVIVAL_MASTER_UNIT = new SlimefunItemStack(
        "EXPANSION_OR_SURVIVAL_MASTER_UNIT",
        Material.DIAMOND,
        "§f生存大师",
        "",
        "§3喂!少挖了一个钻石矿!",
        ""
    );

    public static final SlimefunItemStack OR_PVP_BOSS_UNIT = new SlimefunItemStack(
        "EXPANSION_OR_PVP_BOSS_UNIT",
        Material.DISPENSER,
        "§f还是PVP大佬",
        "",
        "§3僵尸也算player?",
        "§3埋下伏笔",
        ""
    );

    public static final SlimefunItemStack OR_BEDWAR_PRO_UNIT = new SlimefunItemStack(
        "EXPANSION_OR_BEDWAR_PRO_UNIT",
        Material.RED_BED,
        "§f又或是起床大佬",
        "",
        "§3红队来守家了",
        ""
    );

    public static final SlimefunItemStack OR_BUILDING_PRO_UNIT = new SlimefunItemStack(
        "EXPANSION_OR_BUILDING_PRO_UNIT",
        Material.OAK_DOOR,
        "§f又或是建筑大佬",
        "",
        "§3绝世唐门",
        ""
    );

    public static final SlimefunItemStack OR_REDSTONE_PRO_UNIT = new SlimefunItemStack(
        "EXPANSION_OR_REDSTONE_PRO_UNIT",
        Material.REDSTONE_BLOCK,
        "§f又或是红石大佬",
        "",
        "§3奇怪的小装置",
        ""
    );

    public static final SlimefunItemStack OR_A_NOOB_UNIT = new SlimefunItemStack(
        "EXPANSION_OR_A_NOOB_UNIT",
        Material.OAK_SAPLING,
        "§f还是什么都不知道的小白",
        "",
        "§3仰望天空",
        ""
    );

    public static final SlimefunItemStack ORPVPBOSS_STAR = new SlimefunItemStack(
        "EXPANSION_ORPVPBOSS_STAR",
        Material.NETHER_STAR,
        "§fPVP大佬之星",
        "",
        "§3这是什么 能吃吗？",
        ""
    );

    public static final SlimefunItemStack ZOMBIE_STICK = new SlimefunItemStack(
        "EXPANSION_ZOMBIE_STICK",
        Material.STICK,
        "§f僵尸棍",
        "",
        "§3用僵尸的头制作,有腐烂的气息...",
        "§3好像没什么用",
        ""
    );

    public static final SlimefunItemStack NETHERSTAR_DEBRIS = new SlimefunItemStack(
        "EXPANSION_NETHERSTAR_DEBRIS",
        Material.GUNPOWDER,
        "§3下界之星灰烬",
        "",
        "§7燃烧下界之星残留的灰烬...",
        ""
    );

    public static final SlimefunItemStack MATERIAL_FINAL = new SlimefunItemStack(
        "EXPANSION_MATERIAL_FINAL",
        Material.BUCKET,
        "§a成就 §f- §b为什么会变成这样呢?",
        "",
        "§4§k1§r§x§5§f§3§7§f§f想§x§6§4§4§9§f§9必§x§6§8§5§b§f§3这§x§6§d§6§d§e§d就§x§7§1§7§f§e§8是§x§7§6§9§1§e§2终§x§7§a§a§3§d§c点§x§7§e§b§5§d§6了§x§8§3§c§7§d§0?§r§4§k1",
        "§4§k1§r§x§3§7§f§f§9§f故§x§5§f§f§1§7§f事§x§8§7§e§3§5§f还§x§a§f§d§4§4§0未§x§d§7§c§6§2§0结§x§f§f§b§8§0§0束§r§4§k1",
        ""
    );

    //special items
    public static final SlimefunItemStack ZOBAYAN = new SlimefunItemStack(
        "EXPANSION_ZOBAYAN",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjIyMzI2MGE5ZTg3MWVlY2Q2OTFiNjBhNjczZDI3OTBiZTg3YjhiYTA1ODgyNWZlNTJjMjI5MjlhM2I4MDRiNiJ9fX0=",
        "§f§l佐巴扬",
        "",
        "§b致敬传奇机长",
        ""
    );

    public static final SlimefunItemStack KOBE = new SlimefunItemStack(
        "EXPANSION_KOBE",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzM5ZTg4MDBiMzMwYjYwODI4YTZjZGY1ZTAzY2ExMDViZTQwMjFjOWRmOGNlNTlmNTBjNjE4YjRlYjJjNGQ3MiJ9fX0=",
        "§9Kobe",
        "",
        "§lMAN!§r§e§oWhat can I say?",
        ""
    );

    public static final SlimefunItemStack MAMBA_SPIRIT = new SlimefunItemStack(
        "EXPANSION_MAMBA_SPIRIT",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjczZWZmNDRhZjU3NjMzMTc4ZTI5N2I3NDU0ZTNkNWI0ODRhMzliMjYyNzAyNjcxODc4NDUyZTI5MWNmYTc1MCJ9fX0=",
        "§b曼巴精神",
        "",
        "§lMAMBA OUT!",
        ""
    );

    public static final SlimefunItemStack IKUN_PRIME = new SlimefunItemStack(
        "EXPANSION_IKUN_PRIME",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTM3ODk4OTIyMjNjYjc2ZWExYWVmNTY4OWJlOTM4NmU1YjQyZjAxODFkYWM1YTUzYzU3YWUxZDM1NzhkMmYzMyJ9fX0=",
        "§bikun精华",
        "",
        "§f你干嘛~~哈哈哎呦",
        ""
    );

    //machines
    public static final SlimefunItemStack EXPANSION_BREWING_STAND = new SlimefunItemStack(
        "EXPANSION_BREWING_STAND",
        Material.BREWING_STAND,
        "§e自动酿造机 §f- §4EX",
        "", 
        "§3药水类别更多了(?",
        "",
        "§4终极 机器",
        LoreBuilder.speed(6),
        "§8⇨ §e⚡§7 400 J 可存储",
        LoreBuilder.powerPerSecond(80)
    );

    public static final SlimefunItemStack EXPANSION_STONE_CONVERT_MACHINE = new SlimefunItemStack(
        "EXPANSION_STONE_CONVERT_MACHINE",
        Material.LODESTONE,
        "§e石头转化机",
        "",
        "§3可将石头随机转化为",
        "§3各种其他类型的石头",
        "§0怎么做到的,有点神奇了",
        "§a基础 机器",
        LoreBuilder.speed(1),
        "§8⇨ §e⚡§7 100 J 可存储",
        LoreBuilder.powerPerSecond(20)
    );

    public static final SlimefunItemStack EXPANSION_STONE_CONVERT_MACHINE_2 = new SlimefunItemStack(
        "EXPANSION_STONE_CONVERT_MACHINE_2",
        Material.LODESTONE,
        "§e石头转化机 §f- §eII",
        "",
        "§3可将石头随机转化为",
        "§3各种其他类型的石头",
        "§0怎么做到的,有点神奇了",
        "§6高级 机器",
        LoreBuilder.speed(4),
        "§8⇨ §e⚡§7 400 J 可存储",
        LoreBuilder.powerPerSecond(80)
    );

    public static final SlimefunItemStack EXPANSION_RESPAWN_MACHINE = new SlimefunItemStack(
        "EXPANSION_RESPAWN_MACHINE",
        Material.RESPAWN_ANCHOR,
        "§e多功能复活赛模拟器",
        "",
        "§l孩子们,我回来了",
        "",
        "§7获取一些头颅(?",
        "§7无限耐久护符升级器",
        "",
        "§4终极 机器",
        LoreBuilder.powerPerSecond(1919)
    );
    
    public static final SlimefunItemStack DIS_ENCHANTING_TABLE = new SlimefunItemStack(
        "EXPANSION_DIS_ENCHANTING_TABLE",
        Material.ENCHANTING_TABLE,
        "§e祛魔台",
        "",
        "§3转移物品附魔至书上",
        ""
    );

    public static final SlimefunItemStack AUTO_HARVESTER_1 = new SlimefunItemStack(
        "EXPANSION_AUTO_HARVESTER_1",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2E1ZDUxYzNiNzkxZDY5YWU3MDRjN2UzNWI2YTc3ZTExY2JiNzg2MDcwOTNkMDY4NGVkMzdkN2Y3OWJmNjJmMSJ9fX0=",
        "§e农作物自动收割机 §f- §eI",
        "",
        "可自动收割以机器为中心3*3的特定农作物",
        "",
        "§a基础 机器",
        "§3§o电力模式下:",
        "§8⇨ §e⚡§7 100 J 可存储",
        LoreBuilder.powerPerSecond(50)
    );
    
    public static final SlimefunItemStack AUTO_HARVESTER_2 = new SlimefunItemStack(
        "EXPANSION_AUTO_HARVESTER_2",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2E1ZDUxYzNiNzkxZDY5YWU3MDRjN2UzNWI2YTc3ZTExY2JiNzg2MDcwOTNkMDY4NGVkMzdkN2Y3OWJmNjJmMSJ9fX0=",
        "§e农作物自动收割机 §f- §eII",
        "",
        "可自动收割以机器为中心5*5的特定农作物",
        "",
        "§6高级 机器",
        "§3§o电力模式下:",
        "§8⇨ §e⚡§7 200 J 可存储",
        LoreBuilder.powerPerSecond(100)
    );

    public static final SlimefunItemStack AUTO_HARVESTER_EX = new SlimefunItemStack(
        "EXPANSION_AUTO_HARVESTER_EX",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2E1ZDUxYzNiNzkxZDY5YWU3MDRjN2UzNWI2YTc3ZTExY2JiNzg2MDcwOTNkMDY4NGVkMzdkN2Y3OWJmNjJmMSJ9fX0=",
        "§e农作物自动收割机 §f- §4EX",
        "",
        "可自动收割以机器为中心9*9的特定农作物",
        "",
        "§4终极 机器",
        "§3§o电力模式下:",
        "§8⇨ §e⚡§7 500 J 可存储",
        LoreBuilder.powerPerSecond(250)
    );

    public static final SlimefunItemStack RAID_SIMULATOR_1 = new SlimefunItemStack(
        "EXPANSION_RAID_SIMULATOR_1",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTk0Yzc5ZjAzZTE5MWI5MzQ3N2Y3YzE5NTU3NDA4ZjdhZjRmOTY2MGU1ZGZiMDY4N2UzYjhlYjkyZmJkM2FlMSJ9fX0=",
        "§5袭击模拟器 §f- §eI",
        "",
        "§7消耗不祥之兆药水生成袭击战利品",
        "妈妈再也不用担心我到处找袭击生成的地方了",
        "",
        "§6高级 机器",
        LoreBuilder.speed(1),
        "§8⇨ §e⚡§7 500 J 可存储",
        LoreBuilder.powerPerSecond(250)
    );

    public static final SlimefunItemStack RAID_SIMULATOR_2 = new SlimefunItemStack(
        "EXPANSION_RAID_SIMULATOR_2",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTk0Yzc5ZjAzZTE5MWI5MzQ3N2Y3YzE5NTU3NDA4ZjdhZjRmOTY2MGU1ZGZiMDY4N2UzYjhlYjkyZmJkM2FlMSJ9fX0=",
        "§5袭击模拟器 §f- §eII",
        "",
        "§7消耗不祥之兆药水生成袭击战利品",
        "妈妈再也不用担心我到处找袭击生成的地方了",
        "",
        "§4终极 机器",
        LoreBuilder.speed(4),
        "§8⇨ §e⚡§7 2000 J 可存储",
        LoreBuilder.powerPerSecond(1000)
    );

    public static final SlimefunItemStack DIRECTIONAL_DUST_EXTRACTOR_1 = new SlimefunItemStack(
        "EXPANSION_DIRECTIONAL_DUST_EXTRACTOR_1",
        Material.GRINDSTONE,
        "§e定向磨粉机",
        "",
        "§7将圆石变为特定矿粉",
        "是魔法!他用了魔法！",
        "",
        "§6高级 机器",
        LoreBuilder.speed(1),
        "§8⇨ §e⚡§7 1000 J 可存储",
        LoreBuilder.powerPerSecond(500)
    );

    public static final SlimefunItemStack DIRECTIONAL_DUST_EXTRACTOR_2 = new SlimefunItemStack(
        "EXPANSION_DIRECTIONAL_DUST_EXTRACTOR_2",
        Material.GRINDSTONE,
        "§e无尽定向磨粉机",
        "",
        "§7将圆石变为特定矿粉",
        "是魔法!他用了魔法！",
        "",
        "§4终极 机器",
        LoreBuilder.speed(16),
        "§8⇨ §e⚡§7 40000 J 可存储",
        LoreBuilder.powerPerSecond(20000)
    );

    public static final SlimefunItemStack Meme_Generator = new SlimefunItemStack(
        "EXPANSION_MEME_GENERATOR",
        Material.EMERALD_BLOCK,
        "§6迷因发生器",
        "",
        "",
        ""
    );



    //generators
    public static final SlimefunItemStack IRON_GENERATOR = new SlimefunItemStack(
        "EXPANSION_IRON_GENERATOR",
        Material.GRINDSTONE,
        "§e铁锭粉碎发电一体机",
        "",
        "§7造价便宜,能解决前期铁粉稀缺问题",
        "§7还能发电,有这种好事?",
        "",
        "§a发电机",
        "§8⇨ §e⚡§7 114 J 可存储",
        LoreBuilder.powerPerSecond(24)
    );

    public static final SlimefunItemStack MAGMA_BLOCK_MACHINE = new SlimefunItemStack(
        "EXPANSION_MAGMA_BLOCK_MACHINE",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTlhNWExZTY5YjRmODEwNTYyNTc1MmJjZWUyNTM0MDY2NGIwODlmYTFiMmY1MjdmYTkxNDNkOTA2NmE3YWFkMiJ9fX0=",
        "§4岩浆块转化机 §f- §4EX",
        "",
        "§7在产电的同时",
        "§7将圆石转化为岩浆块",
        "",
        "§6发电机",
        "§8⇨ §e⚡§7 400 J 可存储",
        LoreBuilder.powerPerSecond(40)
    );

    public static final SlimefunItemStack NUCLEAR_REACTOR = new SlimefunItemStack(
        "EXPANSION_NUCLEAR_REACTOR",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTdlMTVkZTBkNGI1ZTIwZTZjNmQwMmMwNjQ2NWU4ZDg3ZTJiMGFiYjdmNGVkNThmYzZhNGJiNDllMDA4NmY1YyJ9fX0=",
        "§2核反应堆 §f- §4EX",
        "",
        "§r不需要冷却剂",
        "§8⇨ §f不必被水包围",
        "§8⇨ §f不必使用反应堆冷却剂工作",
        "",
        "§4终极 发电机",
        LoreBuilder.speed(4),
        "§8⇨ §e⚡§7 16384 J 可存储",
        LoreBuilder.powerPerSecond(2000)
    );

    public static final SlimefunItemStack NETHERSTAR_REACTOR = new SlimefunItemStack(
        "EXPANSION_NETHERSTAR_REACTOR",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTdiZjU3NzMyOGE4YTE4ZTU0Nzg0NGQxNDQ4NWMwN2JmYjg2YTAyODczZTk5MDc4NDMxNjQ0NTBjYTg4OGYwYiJ9fX0=",
        "§6下界之星反应堆 §f- §4EX",
        "",
        "§r需要下界之星",
        "§8⇨ §f不必被水包围",
        "§8⇨ §f不必使用下界冰冷却剂工作",
        "",
        "§4终极 发电机",
        LoreBuilder.speed(4),
        "§8⇨ §e⚡§7 32768 J 可存储",
        LoreBuilder.powerPerSecond(4096),
        "§8⇨ §4不会导致附近的生物获得凋零效果"
    );
    
    //items
    private static final ItemStack badomen_potion = new ItemStack(Material.POTION);
    private static final PotionMeta badomen_meta = (PotionMeta) badomen_potion.getItemMeta();
    static
    {
        badomen_meta.addCustomEffect(new PotionEffect(PotionEffectType.BAD_OMEN, 3600, 0), true);
        badomen_potion.setItemMeta(badomen_meta);
    }
    public static final SlimefunItemStack BAD_OMEN_POTION = new SlimefunItemStack(
        "EXPANSION_BAD_OMEN_POTION",
        badomen_potion,
        "§4不祥之兆药水",
        "",
        "§3村民最害怕的一集",
        ""
    );

    public static final SlimefunItemStack HELICOPTER = new SlimefunItemStack(
        "EXPANSION_HELICOPTER",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2UxYjQ2ODI0MmEzYzNhYTQ1NDRmNTM4OWExMmJiNGY4Njc1ZjBiMTRlZjdmM2EyN2ZlMTk0Mjg0ODAyMDQ2YiJ9fX0=",
        "§b§l直升机",
        "",
        "§9坚固又可靠,出行的§f⌈§a§l不二之选§r§f⌋",
        "§a§l右键 §r§f使自己飘浮",
        ""
    );

    public static final SlimefunItemStack BASKETBALL = new SlimefunItemStack(
        "EXPANSION_BASKETBALL",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2NlYmZmOTBiNWM5YzU5Y2EzNTQyZmQyNTUxZWUzOTk5ZjhlOGJmZmVmMTA4NWJjYzg3YmYyZGNkNjE3ZmU0MSJ9fX0=",
        "§c篮球",
        "", 
        "§8故人的身影......",
        "§a§l右键 §r§f投掷",
        "",
        "§3在主手时",
        "§r每次造成 §f1坤 §r的伤害",
        "§r有 §f3坤% §r的概率将命中的生物变成鸡",
        ""
    );

    public static final SlimefunItemStack RELX_V = new SlimefunItemStack(
        "EXPANSION_RELX_V",
        Material.DRIED_KELP,
        "§f§l悦刻五代",
        "",
        "“电子烟，我就爱锐刻”",
        "                 —— 理塘丁真",
        "",
        LoreBuilder.powerCharged(0, 100)
    );

    public static final SlimefunItemStack MOB_ITEM_BAN = new SlimefunItemStack(
        "EXPANSION_MOB_ITEM_BAN",
        Material.STICK,
        "§f缴械棒",
        "",
        "§3好像..有点用?",
        "",
        "§a攻击时清除对方手中物品",
        "&4对玩家无效",
        LoreBuilder.usesLeft(MobItemBan.MAX_USES)
    );

    public static final SlimefunItemStack MOB_ITEM_LOOT = new SlimefunItemStack(
        "EXPANSION_MOB_ITEM_LOOT",
        Material.STICK,
        "§f抢夺棒",
        "",
        "§6现在谁才是掠夺者?",
        "",
        "§a攻击时抢夺对方手中物品至自己背包",
        "&4对玩家无效",
        LoreBuilder.usesLeft(MobItemLoot.MAX_USES)
    );

    public static final SlimefunItemStack HUMANSADDLE = new SlimefunItemStack(
        "EXPANSION_HUMANSADDLE",
        Material.SADDLE,
        "§c§l人鞍",
        "",
        "好像哪里不太对",
        ""
    );

    public static final SlimefunItemStack JINKELA = new SlimefunItemStack(
        "EXPANSION_JINKELA",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDgxODgzNDVkYzZhMWJmMDg2NjMzODViOTlmMmJkMTU1MWE0OTI5MmE5M2I4NGUwYTk3YjkxN2I1NjViZjQxYSJ9fX0=",
        "§6金坷垃",
        "",
        "§e§o肥料掺了金坷垃,一袋能顶两袋撒",
        "§0不过好像不止两袋"
    );

    public static final SlimefunItemStack EXPERIENCE_BLOCK = new SlimefunItemStack(
        "EXPANSION_EXPERIENCE_BLOCK",
        Material.YELLOW_CONCRETE,
        "§e经验块",
        "",
        "§3...压缩的附魔之瓶?",
        "",
        "§a§l右键 §r§f获得100经验值",
        ""
    );

    public static final SlimefunItemStack AMULET_BACKPACK = new SlimefunItemStack(
        "EXPANSION_AMULET_BACKPACK",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWQ5MTk1ZmMxZDJiYzZiNTRhZjQ1NTJlNTA0NTM1YWI2YTdmNmY3YzVlMTkxMjg2N2YwODIyNDMxNTJlYWFiOCJ9fX0=",
        "§f护符背包",
        "",
        "§7让放入其中的护符也可以工作",
        ""
    );

    //weapons
    public static final SlimefunItemStack SHENYING_STICK = new SlimefunItemStack(
        "EXPANSION_SHENYING_STICK",
        Material.STICK,
        "§8神鹰黑手の棒",
        "",
        "—— 装B,让你飞起来!",
        "",
        "§a§l攻击时 §r§f有25%概率让目标§4飞起来!",
        "§a§l右键 §r§f让自己§4飞起来!"
    );

    public static final SlimefunItemStack FROST_TOUCH = new SlimefunItemStack(
        "EXPANSION_FROST_TOUCH",
        Material.DIAMOND_SWORD,
        "§b§l寒霜之触",
        "",
        "§b犯了中二的产物",
        "",
        "§3在手上时",        
        "§a对周围生物每秒造成1点的伤害",
        "§a概率冰冻对方(?"
    );

    public static final SlimefunItemStack ONE_HIT_AXE = new SlimefunItemStack(
        "EXPANSION_ONE_HIT_AXE",
        Material.GOLDEN_AXE,
        "§a§l秒人斧",
        "",
        "§7只能使用一次",
        ""
    );

    public static final SlimefunItemStack GRENADE = new SlimefunItemStack(
        "EXPANSION_GRENADE",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2U1NWM1YWJjZTdhNzkyNjRhNDg5MmQ2ODgwNmVhYWZlMzcwYTBlNGRkMjZmNTYxOTFmN2MxODhmMDFlZDcyNiJ9fX0=",
        "§f手雷",
        "",
        "§a§l右键 §r§f投掷",
        ""
    );

    public static final SlimefunItemStack STACKENCHANTMENT_SWORD = new SlimefunItemStack(
        "EXPANSION_STACKENCHANTMENT_SWORD",
        Material.GOLDEN_SWORD,
        "§5叠咒之刃",
        "",
        "§3每一级附魔等级都会让剑增加1的附加伤害",
        "§3伤害不再受锋利等附魔影响",
        ""
    );

    public static final SlimefunItemStack SWORD_OF_PVPBOSS = new SlimefunItemStack(
        "EXPANSION_SWORD_OF_PVPBOSS",
        Material.NETHERITE_SWORD,
        "§c§lPVP大佬之剑",
        "§3吸血",
        "§3僵尸统领",
        "",
        "§f还是PVP大佬",
        ""
    );
    static 
    {
        SWORD_OF_PVPBOSS.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 10);
    }
    
    
    //armors
    public static final SlimefunItemStack BLUE_SUIT = new SlimefunItemStack(
        "EXPANSION_BLUE_SUIT",
        Material.LEATHER_CHESTPLATE,Color.BLUE,
        "§b蓝色西装",
        "§3速度提升"
    );
    
    public static final SlimefunItemStack BLUE_PANTS = new SlimefunItemStack(
        "EXPANSION_BLUE_PANTS",
        Material.LEATHER_LEGGINGS,Color.BLUE,
        "§b蓝色皮裤",
        "§3速度提升"
    );

    public static final SlimefunItemStack QIE_ER_XI = new SlimefunItemStack(
        "EXPANSION_QIE_ER_XI",
        Material.GOLDEN_BOOTS,
        "§a切尔西",
        "§3速度提升",
        "",
        "英雄可以受委屈",
        "但是你不能踩我的§a§o切尔西",
        ""
    );

    //boss
    public static final SlimefunItemStack OR_PVP_BOSS = new SlimefunItemStack(
        "EXPANSION_OR_PVP_BOSS",
        Material.ZOMBIE_HEAD,
        "§fPVP大佬",
        "",
        "§3以下是全文背诵:",
        "你好，陌生人",
        "你好，陌生人",
        "GRW团队招生了",
        "无论你是跑酷大神",
        "生存大师",
        "还是PVP大佬",
        "还是PVP大佬",
        "又或是起床大佬",
        "还是PVP大佬",
        "还是PVP大佬",
        "又或是起床大佬",
        "又或是建筑大佬",
        "还是PVP大佬",
        "又或是建筑大佬",
        "又或是建筑大佬",
        "还是什么都不知道的小白",
        "还是PVP大佬",
        "又或是建筑大佬",
        "又或是红石大佬",
        "又或是红石大佬",
        "还是PVP大佬",
        "还是什么都不知道的小白",
        "还是PVP大佬",
        "还是PVP大佬",
        ""
    );

    //Amulets
    public static final SlimefunItemStack RESISTANCE_AMULET_1 = new SlimefunItemStack(
        "EXPANSION_RESISTANCE_AMULET_1",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a抗性提升",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack RESISTANCE_AMULET_2 = new SlimefunItemStack(
        "EXPANSION_RESISTANCE_AMULET_2",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a抗性提升II",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack RESISTANCE_AMULET_4 = new SlimefunItemStack(
        "EXPANSION_RESISTANCE_AMULET_4",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a抗性提升IV",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack SPEED_AMULET_1 = new SlimefunItemStack(
        "EXPANSION_SPEED_AMULET_1",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a迅捷I",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack SPEED_AMULET_2 = new SlimefunItemStack(
        "EXPANSION_SPEED_AMULET_2",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a迅捷II",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack HASTE_AMULET_1 = new SlimefunItemStack(
        "EXPANSION_HASTE_AMULET_1",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a急迫I",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack HASTE_AMULET_2 = new SlimefunItemStack(
        "EXPANSION_HASTE_AMULET_2",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a急迫II",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack STRENGTH_AMULET_1 = new SlimefunItemStack(
        "EXPANSION_STRENGTH_AMULET_1",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a力量I",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack STRENGTH_AMULET_2 = new SlimefunItemStack(
        "EXPANSION_STRENGTH_AMULET_2",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a力量II",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack JUMPBOOST_AMULET_1 = new SlimefunItemStack(
        "EXPANSION_JUMPBOOST_AMULET_1",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a跳跃提升I",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack JUMPBOOST_AMULET_2 = new SlimefunItemStack(
        "EXPANSION_JUMPBOOST_AMULET_2",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a跳跃提升II",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack REGENERATION_AMULET_1 = new SlimefunItemStack(
        "EXPANSION_REGENERATION_AMULET_1",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a生命恢复I",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack REGENERATION_AMULET_2 = new SlimefunItemStack(
        "EXPANSION_REGENERATION_AMULET_2",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a生命恢复II",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack FIRE_RESISTANCE_AMULET = new SlimefunItemStack(
        "EXPANSION_FIRE_RESISTANCE_AMULET",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a抗火",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack WATER_BREATHING_AMULET = new SlimefunItemStack(
        "EXPANSION_WATER_BREATHING_AMULET",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a水下呼吸",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack INVISIBILITY_AMULET = new SlimefunItemStack(
        "EXPANSION_INVISIBILITY_AMULET",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a隐身",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack NIGHT_VISION_AMULET = new SlimefunItemStack(
        "EXPANSION_NIGHT_VISION_AMULET",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a夜视",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack ABSORPTION_AMULET_1 = new SlimefunItemStack(
        "EXPANSION_ABSORPTION_AMULET_1",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a伤害吸收I",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack ABSORPTION_AMULET_2 = new SlimefunItemStack(
        "EXPANSION_ABSORPTION_AMULET_2",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a伤害吸收II",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack ABSORPTION_AMULET_4 = new SlimefunItemStack(
        "EXPANSION_ABSORPTION_AMULET_4",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a伤害吸收IV",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack SATURATION_AMULET = new SlimefunItemStack(
        "EXPANSION_SATURATION_AMULET",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a饱和",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack SLOW_FALLING_AMULET = new SlimefunItemStack(
        "EXPANSION_SLOW_FALLING_AMULET",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a缓降",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack CONDIUT_POWER_AMULET = new SlimefunItemStack(
        "EXPANSION_CONDIUT_POWER_AMULET",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a潮涌能量",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack VILLAGE_HERO_AMULET_1 = new SlimefunItemStack(
        "EXPANSION_VILLAGE_HERO_AMULET_1",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a村庄英雄I",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack VILLAGE_HERO_AMULET_2 = new SlimefunItemStack(
        "EXPANSION_VILLAGE_HERO_AMULET_2",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a村庄英雄II",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack VILLAGE_HERO_AMULET_3 = new SlimefunItemStack(
        "EXPANSION_VILLAGE_HERO_AMULET_3",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a村庄英雄III",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack VILLAGE_HERO_AMULET_4 = new SlimefunItemStack(
        "EXPANSION_VILLAGE_HERO_AMULET_4",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a村庄英雄IV",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack VILLAGE_HERO_AMULET_5 = new SlimefunItemStack(
        "EXPANSION_VILLAGE_HERO_AMULET_5",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a村庄英雄V",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack DAMAGE_REDUCTION_AMULET = new SlimefunItemStack(
        "EXPANSION_DAMAGE_REDUCTION_AMULET",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a伤害减免",
        "",
        "§7激活后 所受伤害-1",
        "§a§l右键 §r§f启用/停用",
        ""
    );

    public static final SlimefunItemStack ATTACK_SPEEDUP_AMULET = new SlimefunItemStack(
        "EXPANSION_ATTACK_SPEEDUP_AMULET",
        Material.TOTEM_OF_UNDYING,
        "§3护符 §f- §a攻速提升",
        "",
        "§a§l右键 §r§f启用/停用",
        ""
    );
}