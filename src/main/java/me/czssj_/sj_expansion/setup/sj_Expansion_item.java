package me.czssj_.sj_expansion.setup;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;


public class sj_Expansion_item
{       
    //recipes
    public static final SlimefunItemStack VILLAGER_DROP = new SlimefunItemStack(
            "VILLAGER_DROP",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDVmNzI5NzM2OTk2YTM4ZTE4NmZlOWZlN2Y1YTA0YjM4N2VkMDNmMzg3MWVjYzgyZmE3OGQ4YTJiZGQzMTEwOSJ9fX0=",
            "§a§lVILLAGER",
            "§f有 §a30% §f的概率掉落"
    );

    //info
    public static final SlimefunItemStack INFO = new SlimefunItemStack(
            "EXPANSION_INFO",
            Material.PAPER,
            "§f-附属信息-",
            "",
            "本附属来源于作者在游玩slimefun时的一些想法",
            "加入了一些有趣的物品 §m梗addon",
            "为了让玩家更加快捷方便的游玩(?",
            ""
    );

    public static final SlimefunItemStack AUTHOR = new SlimefunItemStack(
            "EXPANSION_AUTHOR",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2I0ZjA0NzNiMGM0MjNiYTk3MzhhYzhlOGM2MjQ4MWI4NjkyMmIzMGVkYzc1Zjc4MGI4ZjdlODhhMmJhMmIxYyJ9fX0=",
            "czssj_",
            "",
            "附属作者",
            ""
    );

    public static final SlimefunItemStack THANKS = new SlimefunItemStack(
            "EXPANSION_THANKS",
            Material.PLAYER_HEAD,
            "群友们",
            "",
            "一些想法和解惑",
            ""
    );

    //materials
    public static final SlimefunItemStack CONCENTRATED_MAGIC_LUMP = new SlimefunItemStack(
            "CONCENTRATED_MAGIC_LUMP",
            Material.GOLD_INGOT,
            "§e浓缩魔法结晶"
    );

    public static final SlimefunItemStack VILLAGER_SOUL = new SlimefunItemStack(
            "VILLAGER_SOUL",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzc0OTJhYjc4NDI0NDNjNTMzMTVmOTBmMGU3MTQ0MGUxZTdlMTM2ZjU2ODkyYTc2MTU2NTA4MjU0NDExYWY0MiJ9fX0=",
            "§4村民的亡魂",
            "",
            "§1§k1§r§4§l奸商的毁灭§1§k1",
            ""
    );

    public static final SlimefunItemStack HELICOPTER_ENGINE = new SlimefunItemStack(
            "HELICOPTER_ENGINE",
            SlimefunItems.ELECTRIC_MOTOR,
            "§3直升机引擎" ,
            "",
            "§f直升机零件",
            ""
    );

    public static final SlimefunItemStack HELICOPTER_GLASS = new SlimefunItemStack(
            "HELICOPTER_GLASS",
            Material.PURPLE_STAINED_GLASS_PANE,
            "§9挡风玻璃" ,
            "",
            "§f直升机零件",
            ""
    );

    public static final SlimefunItemStack HELICOPTER_PROPELLER = new SlimefunItemStack(
            "HELICOPTER_PROPELLER",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjM0OWZhODAyYjdkOWY2MmYzM2ExNjJhZTM1MTVhODRmYzhlNzY4ZjcwY2FkZTk3OTA3MzgyOWI5NjcyZDgyMyJ9fX0=",
            "§3直升机螺旋桨",
            "",
            "§f直升机零件",
            ""
    );

    public static final SlimefunItemStack IKUN_PRIME = new SlimefunItemStack(
            "IKUN_PRIME",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTM3ODk4OTIyMjNjYjc2ZWExYWVmNTY4OWJlOTM4NmU1YjQyZjAxODFkYWM1YTUzYzU3YWUxZDM1NzhkMmYzMyJ9fX0=",
            "§bikun精华",
            "",
            "§f你干嘛~~哈哈哎呦",
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
            "MAGMA_BLOCK_MACHINECORE",
            Material.PAPER,
            "岩浆块核心",
            "",
            "§3某个机器的合成替代物....",
            ""
     );

    //special items
    public static final SlimefunItemStack ZOBAYAN = new SlimefunItemStack(
            "ZOBAYAN",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjIyMzI2MGE5ZTg3MWVlY2Q2OTFiNjBhNjczZDI3OTBiZTg3YjhiYTA1ODgyNWZlNTJjMjI5MjlhM2I4MDRiNiJ9fX0=",
            "§f§l佐巴扬",
            "",
            "§b致敬传奇机长",
            ""
    );

    public static final SlimefunItemStack KOBE = new SlimefunItemStack(
            "KOBE",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzM5ZTg4MDBiMzMwYjYwODI4YTZjZGY1ZTAzY2ExMDViZTQwMjFjOWRmOGNlNTlmNTBjNjE4YjRlYjJjNGQ3MiJ9fX0=",
            "§9Kobe",
            "",
            "§lMAN!§r§e§oWhat can I say?",
            ""
    );

    public static final SlimefunItemStack MAMBA_SPIRIT = new SlimefunItemStack(
            "MAMBA_SPIRIT",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjczZWZmNDRhZjU3NjMzMTc4ZTI5N2I3NDU0ZTNkNWI0ODRhMzliMjYyNzAyNjcxODc4NDUyZTI5MWNmYTc1MCJ9fX0=",
            "§b曼巴精神",
            "",
            "§lMAMBA OUT!",
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
            "§dE§9X§5P§1A§cN§8D§4E§3D",
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
            "§e复活赛模拟器",
            "",
            "§l孩子们,我回来了",
            "§0用于获取头颅(?",
            "§a§k1§k1§r §a机器",
            LoreBuilder.powerPerSecond(1919)
    );

    //generators
    public static final SlimefunItemStack EXPANSION_IRON_GENERATOR = new SlimefunItemStack(
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

    public static final SlimefunItemStack EXPANSION_MAGMA_BLOCK_MACHINE = new SlimefunItemStack(
            "EXPANSION_MAGMA_BLOCK_MACHINE",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTlhNWExZTY5YjRmODEwNTYyNTc1MmJjZWUyNTM0MDY2NGIwODlmYTFiMmY1MjdmYTkxNDNkOTA2NmE3YWFkMiJ9fX0=",
            "§4岩浆块转化机 §f- §4EX",
            "",
            "§7在产电的同时",
            "§7将圆石转化为岩浆块",
            "",
            "§6发电机",
            "§dE§9X§5P§1A§cN§8D§4E§3D§f",
            "§8⇨ §e⚡§7 400 J 可存储",
            LoreBuilder.powerPerSecond(40)
    );

    //items
    private static final ItemStack badomen_potion = new ItemStack(Material.POTION);
    private static final ItemStack awkward_potion = new ItemStack(Material.POTION);
    private static final PotionMeta badomen_meta = (PotionMeta) badomen_potion.getItemMeta();
    private static final PotionMeta awkward_meta = (PotionMeta) awkward_potion.getItemMeta();
    static
    {
        badomen_meta.addCustomEffect(new PotionEffect(PotionEffectType.BAD_OMEN, 3600, 0), true);
        badomen_potion.setItemMeta(badomen_meta);
        awkward_meta.setBasePotionData(new org.bukkit.potion.PotionData(PotionType.AWKWARD));
        awkward_potion.setItemMeta(awkward_meta);
    }
    public static final SlimefunItemStack AWKWARD_POTION = new SlimefunItemStack(
            "AWKWARD_POTION",
            awkward_potion,
            "§f粗制的药水"
    );
    public static final SlimefunItemStack BAD_OMEN_POTION = new SlimefunItemStack(
            "BAD_OMEN_POTION",
            badomen_potion,
            "§4不祥之兆药水",
            "",
            "§3村民最害怕的一集",
            ""
    );

    public static final SlimefunItemStack HELICOPTER = new SlimefunItemStack(
        "HELICOPTER",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2UxYjQ2ODI0MmEzYzNhYTQ1NDRmNTM4OWExMmJiNGY4Njc1ZjBiMTRlZjdmM2EyN2ZlMTk0Mjg0ODAyMDQ2YiJ9fX0=",
        "§b§l直升机",
        "",
        "§9坚固又可靠,出行的§f⌈§a§l不二之选§r§f⌋",
        "§a§l右键 §r§f使自己飘浮",
        ""
    );

    public static final SlimefunItemStack BASKETBALL = new SlimefunItemStack(
        "BASKETBALL",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2NlYmZmOTBiNWM5YzU5Y2EzNTQyZmQyNTUxZWUzOTk5ZjhlOGJmZmVmMTA4NWJjYzg3YmYyZGNkNjE3ZmU0MSJ9fX0=",
        "§c篮球",
        "", 
        "§8故人的身影......",
        "§a§l右键 §r§f投掷",
        "",
        "§r每次造成 §f1坤 §r的伤害",
        "§r有 §f3坤% §r的概率将命中的生物变成鸡",
        ""
    );

    public static final SlimefunItemStack RELX_V = new SlimefunItemStack(
        "RELX_V",
        Material.DRIED_KELP,
        "§f§l悦刻五代",
        "",
        "“电子烟，我就爱锐刻”",
        "                 —— 理塘丁真",
        "",
        LoreBuilder.powerCharged(0, 100)
    );

    //weapons
    public static final SlimefunItemStack FROST_TOUCH = new SlimefunItemStack(
        "FROST_TOUCH",
        Material.DIAMOND_SWORD,
        "§b§l寒霜之触",
        "",
        "§b冰封一切!",
        "",
        "§a对周围生物每秒造成1点的伤害",
        "§a概率冰冻对方"
    );
}