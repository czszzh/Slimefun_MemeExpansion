package me.czssj_.sj_expansion.setup;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import me.czssj_.sj_expansion.Expansion.Machines.Expansion_Brewing_Stand;
import me.czssj_.sj_expansion.sj_Expansion;
import me.czssj_.sj_expansion.Expansion.Items.Basketball;
import me.czssj_.sj_expansion.Expansion.Items.Helicopter;

import javax.annotation.Nonnull;

public final class sj_Expansion_setup
{
    private static final NestedItemGroup Main = new NestedItemGroup(
            new NamespacedKey(sj_Expansion.getInstance(), "sj_Expansion"),
            new CustomItemStack(Material.REDSTONE, "&e&1s&5j&9の&d粘&2液&6科&a技&e拓&c展", "", "&a> Click to open")
    );

    private static final SubItemGroup Info = new SubItemGroup(
            new NamespacedKey(sj_Expansion.getInstance(), "sj_Expansion_Info"),
            Main,
            new CustomItemStack(Material.PAPER, "&e拓展 &f- &9信息", "", "")
    );

    private static final SubItemGroup Machines = new SubItemGroup(
            new NamespacedKey(sj_Expansion.getInstance(), "sj_Expansion_Machines"),
            Main,
            new CustomItemStack(Material.STONE, "&e拓展 &f- &9机器", "", "")
    );

    private static final SubItemGroup Generators = new SubItemGroup(
            new NamespacedKey(sj_Expansion.getInstance(), "sj_Expansion_Machines"),
            Main,
            new CustomItemStack(Material.GLASS, "&e拓展 &f- &9发电机", "", "")
    );

    private static final SubItemGroup Materials = new SubItemGroup(
            new NamespacedKey(sj_Expansion.getInstance(), "sj_Expansion_Materials"),
            Main,
            new CustomItemStack(Material.IRON_INGOT, "&e拓展 &f- &9零件&材料", "", "")
    );

    private static final SubItemGroup Items = new SubItemGroup(
            new NamespacedKey(sj_Expansion.getInstance(), "sj_Expansion_Items"),
            Main,
            new CustomItemStack(Material.STICK, "&e拓展 &f- &9物品", "", "")
    );

    private static final SubItemGroup SpecialItems = new SubItemGroup(
            new NamespacedKey(sj_Expansion.getInstance(), "sj_Expansion_SpecialItems"),
            Main,
            new CustomItemStack(Material.CREEPER_HEAD, "&e拓展 &f- &9特殊物品", "&3memes", "")
    );

    public static void setup(sj_Expansion plugin)
    {
        //info
        new SlimefunItem(Info, sj_Expansion_item.INFO, RecipeType.NULL, null).register(plugin);
        new SlimefunItem(Info, sj_Expansion_item.AUTHOR, RecipeType.NULL, null).register(plugin);

        //items
        new Basketball(Items, sj_Expansion_item.BASKETBALL,
        RecipeType.NULL, new ItemStack[]{

        }).register(plugin);

        new Helicopter(Items, sj_Expansion_item.HELICOPTER,
        RecipeType.NULL, new ItemStack[]{

        }).register(plugin);

        new SlimefunItem(Items, sj_Expansion_item.BAD_OMEN_POTION,
        RecipeType.NULL, new ItemStack[]{

        }).register(plugin);

        //materials
        new SlimefunItem(Materials, sj_Expansion_item.CONCENTRATED_MAGIC_LUMP,
        RecipeType.COMPRESSOR, new ItemStack[]{
                new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3,16),null,null,
                null,null,null,
                null,null,null
        }).register(plugin);

        //special items
        new SlimefunItem(SpecialItems, sj_Expansion_item.KOBE,
        RecipeType.NULL, new ItemStack[]{

        }).register(plugin);

        //machines
        new Expansion_Brewing_Stand(Machines, sj_Expansion_item.EXPANSION_BREWING_STAND,
        RecipeType.NULL, new ItemStack[]{

        }).register(plugin);

    }
}