package me.czssj_.sj_expansion.setup;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class sj_Expansion_item
{
    public static final SlimefunItemStack INFO = new SlimefunItemStack(
            "EXPANSION_INFO",
            Material.PAPER,
            "&f-附属信息-",
            "",
            "本附属来源于作者在游玩slimefun时的一些想法",
            "加入了一些有趣的物品 &m梗addon",
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

    public static final SlimefunItemStack CONCENTRATED_MAGIC_LUMP = new SlimefunItemStack(
            "CONCENTRATED_MAGIC_LUMP",
            Material.GOLD_INGOT,
            "&e浓缩魔法结晶"
    );

    public static final SlimefunItemStack KOBE = new SlimefunItemStack(
            "KOBE",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzM5ZTg4MDBiMzMwYjYwODI4YTZjZGY1ZTAzY2ExMDViZTQwMjFjOWRmOGNlNTlmNTBjNjE4YjRlYjJjNGQ3MiJ9fX0=",
            "&9&oKobe",
            "",
            "&e&lMAN!&r&eWhat can I say!?",
            ""
    );

    public static final SlimefunItemStack HELICOPTER = new SlimefunItemStack(
            "HELICOPTER",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2UxYjQ2ODI0MmEzYzNhYTQ1NDRmNTM4OWExMmJiNGY4Njc1ZjBiMTRlZjdmM2EyN2ZlMTk0Mjg0ODAyMDQ2YiJ9fX0=",
            "&b&l直升机",
            "",
            "&9坚固又可靠,出行的&f⌈&a&l不二之选&r&f⌋",
            "&a&l右键 &r&f使自己飘浮",
            ""
    );

    public static final SlimefunItemStack BASKETBALL = new SlimefunItemStack(
            "BASKETBALL",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2NlYmZmOTBiNWM5YzU5Y2EzNTQyZmQyNTUxZWUzOTk5ZjhlOGJmZmVmMTA4NWJjYzg3YmYyZGNkNjE3ZmU0MSJ9fX0=",
            "&c篮球",
            "", "&8故人的身影......",
            "&a&l右键 &r&f投掷",
            "有1%概率让命中的生物变成鸡",
            ""
    );

    public static final SlimefunItemStack EXPANSION_BREWING_STAND = new SlimefunItemStack(
            "EXPANSION_BREWING_STAND",
            Material.BREWING_STAND,
            "&e自动酿造机 &f- &4EX",
            "", 
            "&3药水类别更多了(?",
            "待完善",
            "",
            "&4终极 机器",
            "&8⇨ &3速度: 6x",
            "&8⇨ &e⚡&7 400 J 可存储",
            "&8⇨ &e⚡&7 80 J/s"
    );

    private static final ItemStack potion = new ItemStack(Material.POTION);
    private static final PotionMeta meta = (PotionMeta) potion.getItemMeta();
    static
    {
        meta.addCustomEffect(new PotionEffect(PotionEffectType.BAD_OMEN, 3600, 0), true);
        potion.setItemMeta(meta);
    }
    public static final SlimefunItemStack BAD_OMEN_POTION = new SlimefunItemStack(
            "BAD_OMEN_POTION",
            potion,
            "&4不祥之兆药水",
            "",
            "&3村民最害怕的一集",
            ""
    );
}