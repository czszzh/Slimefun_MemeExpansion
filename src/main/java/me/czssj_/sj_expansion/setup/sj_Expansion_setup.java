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
import me.czssj_.sj_expansion.Expansion.Machines.Expansion_Repawn_Machine;
import me.czssj_.sj_expansion.Expansion.Machines.Expansion_Stone_Convert_Machine;
import me.czssj_.sj_expansion.Expansion.Weapon.Frost_Touch;
import me.czssj_.sj_expansion.sj_Expansion;
import me.czssj_.sj_expansion.Expansion.Generators.Expansion_Iron_Generator;
import me.czssj_.sj_expansion.Expansion.Generators.Expansion_Magma_Block_Machine;
import me.czssj_.sj_expansion.Expansion.Items.Basketball;
import me.czssj_.sj_expansion.Expansion.Items.Helicopter;
import me.czssj_.sj_expansion.Expansion.Items.RELX;
import me.czssj_.sj_expansion.Expansion.Items.Villager_Soul;

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
            new NamespacedKey(sj_Expansion.getInstance(), "sj_Expansion_Generators"),
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

    private static final SubItemGroup Weapons = new SubItemGroup(
            new NamespacedKey(sj_Expansion.getInstance(), "sj_Expansion_Weapons"),
            Main,
            new CustomItemStack(Material.DIAMOND_SWORD, "&e拓展 &f- &9武器", "", "")
    );

    private static final SubItemGroup SpecialItems = new SubItemGroup(
            new NamespacedKey(sj_Expansion.getInstance(), "sj_Expansion_SpecialItems"),
            Main,
            new CustomItemStack(Material.CREEPER_HEAD, "&e拓展 &f- &9特殊物品", "&3memes", "")
    );

    @SuppressWarnings("null")
    public static void setup(sj_Expansion plugin)
    {
        //info
        new SlimefunItem(Info, sj_Expansion_item.INFO, RecipeType.NULL, new ItemStack[]{}).register(plugin);
        new SlimefunItem(Info, sj_Expansion_item.AUTHOR, RecipeType.NULL, new ItemStack[]{}).register(plugin);
        new SlimefunItem(Info, sj_Expansion_item.THANKS, RecipeType.NULL, new ItemStack[]{}).register(plugin);

        //items
        new Basketball(Items, sj_Expansion_item.BASKETBALL,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
                SlimefunItems.REINFORCED_CLOTH,SlimefunItems.CLOTH,new ItemStack(Material.SLIME_BLOCK),
                SlimefunItems.CLOTH,sj_Expansion_item.IKUN_PRIME,SlimefunItems.CLOTH,
                new ItemStack(Material.SLIME_BLOCK),SlimefunItems.CLOTH,SlimefunItems.REINFORCED_CLOTH
        }).register(plugin);

        new Helicopter(Items, sj_Expansion_item.HELICOPTER,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                null,sj_Expansion_item.HELICOPTER_PROPELLER,null,
                sj_Expansion_item.HELICOPTER_GLASS,sj_Expansion_item.ZOBAYAN,SlimefunItems.STEEL_THRUSTER,
                sj_Expansion_item.HELICOPTER_ENGINE,SlimefunItems.REINFORCED_PLATE,null
        }).register(plugin);

        RecipeType EX_BrewingStand_RecipeType = new RecipeType(sj_Expansion_item.EXPANSION_BREWING_STAND, "EXPANSION_BREWING_STAND"); 
        new SlimefunItem(Items, sj_Expansion_item.BAD_OMEN_POTION,
        EX_BrewingStand_RecipeType, new ItemStack[]{
                null,null,null,
                sj_Expansion_item.AWKWARD_POTION,null,sj_Expansion_item.VILLAGER_SOUL,
                null,null,null
        }).register(plugin);

        new RELX(Items, sj_Expansion_item.RELX_V,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                SlimefunItems.DURALUMIN_INGOT,SlimefunItems.HEATING_COIL,SlimefunItems.DURALUMIN_INGOT,
                SlimefunItems.DURALUMIN_INGOT,SlimefunItems.BASIC_CIRCUIT_BOARD,SlimefunItems.DURALUMIN_INGOT,
                SlimefunItems.DURALUMIN_INGOT,SlimefunItems.BATTERY,SlimefunItems.DURALUMIN_INGOT
        }, 100).register(plugin);

        //materials
        new SlimefunItem(Materials, sj_Expansion_item.CONCENTRATED_MAGIC_LUMP,
        RecipeType.COMPRESSOR, new ItemStack[]{
                new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3,16),null,null,
                null,null,null,
                null,null,null
        }).register(plugin);

        new Villager_Soul(Materials, sj_Expansion_item.VILLAGER_SOUL,
        RecipeType.MOB_DROP, new ItemStack[]{
                null,null,null,
                null,sj_Expansion_item.VILLAGER_DROP,null,
                null,null,null
        }).register(plugin);

        new SlimefunItem(Materials, sj_Expansion_item.HELICOPTER_ENGINE,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                SlimefunItems.REINFORCED_ALLOY_INGOT,SlimefunItems.REINFORCED_ALLOY_INGOT,SlimefunItems.REINFORCED_ALLOY_INGOT,
                new ItemStack(Material.PISTON),SlimefunItem.getById("HELICOPTER_HAT").getItem(),new ItemStack(Material.PISTON),
                SlimefunItem.getById("MACHINE_CORE").getItem(),SlimefunItems.STEEL_THRUSTER,SlimefunItem.getById("MACHINE_CORE").getItem()
        }).register(plugin);

        new SlimefunItem(Materials, sj_Expansion_item.HELICOPTER_GLASS,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                new ItemStack(Material.GLASS_PANE),new ItemStack(Material.GLASS_PANE),new ItemStack(Material.GLASS_PANE),
                new ItemStack(Material.GLASS_PANE),new ItemStack(Material.GLASS_PANE),new ItemStack(Material.GLASS_PANE),
                SlimefunItems.REINFORCED_PLATE,SlimefunItems.WITHER_PROOF_GLASS,SlimefunItems.REINFORCED_PLATE
        }).register(plugin);

        new SlimefunItem(Materials, sj_Expansion_item.HELICOPTER_PROPELLER,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                null,SlimefunItems.STEEL_THRUSTER,null,
                SlimefunItems.STEEL_THRUSTER,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.STEEL_THRUSTER,
                null,SlimefunItems.STEEL_THRUSTER,null
        }).register(plugin);

        new SlimefunItem(Materials,sj_Expansion_item.IKUN_PRIME,
        RecipeType.COMPRESSOR, new ItemStack[]{
                new ItemStack(Material.EGG, 16),new ItemStack(Material.EGG, 16),new ItemStack(Material.EGG, 16),
                new ItemStack(Material.EGG, 16),new ItemStack(Material.EGG, 16),new ItemStack(Material.EGG, 16),
                new ItemStack(Material.EGG, 16),new ItemStack(Material.EGG, 16),new ItemStack(Material.EGG, 16)
        }).register(plugin);

        if(SlimefunItem.getById("HAIMAN_MAGMA_BLOCK_MACHINE") == null)
        {
                new SlimefunItem(Materials, sj_Expansion_item.MAGMA_BLOCK_MACHINECORE,
                RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                        SlimefunItems.DAMASCUS_STEEL_INGOT,SlimefunItems.ADVANCED_CIRCUIT_BOARD,SlimefunItems.DAMASCUS_STEEL_INGOT,
                        new ItemStack(Material.LAVA_BUCKET),SlimefunItems.ELECTRIC_MOTOR,new ItemStack(Material.LAVA_BUCKET),
                        SlimefunItems.ALUMINUM_BRONZE_INGOT,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.ALUMINUM_BRONZE_INGOT
                }).register(plugin);
        }

        new SlimefunItem(Materials, sj_Expansion_item.EXPANSION_CORE,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                SlimefunItems.LIGHTNING_RUNE,sj_Expansion_item.VILLAGER_SOUL,SlimefunItems.LIGHTNING_RUNE,
                sj_Expansion_item.CONCENTRATED_MAGIC_LUMP,new ItemStack(Material.BEACON),sj_Expansion_item.CONCENTRATED_MAGIC_LUMP,
                sj_Expansion_item.IKUN_PRIME,sj_Expansion_item.VILLAGER_SOUL,sj_Expansion_item.IKUN_PRIME
        }).register(plugin);

        //special items
        RecipeType RespawnMachine_RecipeType = new RecipeType(sj_Expansion_item.EXPANSION_RESPAWN_MACHINE, "EXPANSION_RESPAWN_MACHINE"); 
        new SlimefunItem(SpecialItems, sj_Expansion_item.KOBE,
        RespawnMachine_RecipeType, new ItemStack[]{
                null,null,null,
                null,new CustomItemStack(Material.TOTEM_OF_UNDYING, "§a不死图腾", "§f24个"),null,
                null,null,null
        }).register(plugin);

        RecipeType Helicopter_Crash = new RecipeType(new CustomItemStack(sj_Expansion_item.HELICOPTER, "§4坠机事件", " "), "HELICOPTER"); 
        new SlimefunItem(SpecialItems, sj_Expansion_item.MAMBA_SPIRIT,
        Helicopter_Crash, new ItemStack[]{
                null,null,null,
                null,new CustomItemStack(sj_Expansion_item.KOBE, "§9Kobe", "§f佩戴在头上"),null,
                null,null,null
        }).register(plugin);

        new SlimefunItem(SpecialItems, sj_Expansion_item.ZOBAYAN,
        RespawnMachine_RecipeType, new ItemStack[]{
                null,null,null,
                null,new CustomItemStack(Material.TOTEM_OF_UNDYING, "§a不死图腾", "§f10个"),null,
                null,null,null
        }).register(plugin);

        //machines
        new Expansion_Brewing_Stand(Machines, sj_Expansion_item.EXPANSION_BREWING_STAND,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                SlimefunItems.REINFORCED_PLATE,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.REINFORCED_PLATE,
                sj_Expansion_item.CONCENTRATED_MAGIC_LUMP,SlimefunItems.AUTO_BREWER,sj_Expansion_item.CONCENTRATED_MAGIC_LUMP,
                SlimefunItem.getById("MACHINE_CORE").getItem(),sj_Expansion_item.EXPANSION_CORE,SlimefunItem.getById("MACHINE_CORE").getItem()
        }).register(plugin);

        new Expansion_Stone_Convert_Machine(Machines, sj_Expansion_item.EXPANSION_STONE_CONVERT_MACHINE,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                new ItemStack(Material.STONECUTTER),SlimefunItems.BASIC_CIRCUIT_BOARD,new ItemStack(Material.STONECUTTER),
                SlimefunItems.MAGIC_LUMP_3,SlimefunItems.VANILLA_AUTO_CRAFTER,SlimefunItems.MAGIC_LUMP_3,
                SlimefunItems.CRAFTING_MOTOR,SlimefunItems.SMALL_CAPACITOR,SlimefunItems.CRAFTING_MOTOR
        }, 1).register(plugin);

        new Expansion_Stone_Convert_Machine(Machines, sj_Expansion_item.EXPANSION_STONE_CONVERT_MACHINE_2,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                SlimefunItems.REINFORCED_PLATE,SlimefunItems.ADVANCED_CIRCUIT_BOARD,SlimefunItems.REINFORCED_PLATE,
                sj_Expansion_item.CONCENTRATED_MAGIC_LUMP,sj_Expansion_item.EXPANSION_STONE_CONVERT_MACHINE,sj_Expansion_item.CONCENTRATED_MAGIC_LUMP,
                SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.HEATING_COIL,SlimefunItems.BLISTERING_INGOT_3
        }, 4).setCapacity(400).setEnergyConsumption(40).register(plugin);

        new Expansion_Repawn_Machine(Machines, sj_Expansion_item.EXPANSION_RESPAWN_MACHINE, 
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                SlimefunItem.getById("MACHINE_CORE").getItem(),SlimefunItems.ADVANCED_CIRCUIT_BOARD,SlimefunItem.getById("MACHINE_CORE").getItem(),
                sj_Expansion_item.EXPANSION_CORE,new ItemStack(Material.RESPAWN_ANCHOR),sj_Expansion_item.EXPANSION_CORE,
                SlimefunItem.getById("MACHINE_CORE").getItem(),sj_Expansion_item.EXPANSION_CORE,SlimefunItem.getById("MACHINE_CORE").getItem()
        }).energyPerTick(1919).register(plugin);

        //generators
        new Expansion_Iron_Generator(Generators, sj_Expansion_item.EXPANSION_IRON_GENERATOR,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                new ItemStack(Material.IRON_INGOT),new ItemStack(Material.FURNACE),new ItemStack(Material.IRON_INGOT),
                SlimefunItems.ELECTRIC_MOTOR,new ItemStack(Material.REDSTONE),SlimefunItems.ELECTRIC_MOTOR,
                new ItemStack(Material.IRON_PICKAXE),SlimefunItems.BASIC_CIRCUIT_BOARD,new ItemStack(Material.IRON_PICKAXE)
        }).register(plugin);

        if(SlimefunItem.getById("HAIMAN_MAGMA_BLOCK_MACHINE") != null)
        {
                new Expansion_Magma_Block_Machine(Generators, sj_Expansion_item.EXPANSION_MAGMA_BLOCK_MACHINE,
                RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                        SlimefunItems.DAMASCUS_STEEL_INGOT,SlimefunItems.BIG_CAPACITOR,SlimefunItems.DAMASCUS_STEEL_INGOT,
                        new ItemStack(Material.LAVA_BUCKET),SlimefunItem.getById("HAIMAN_MAGMA_BLOCK_MACHINE").getItem(),new ItemStack(Material.LAVA_BUCKET),
                        SlimefunItems.REINFORCED_ALLOY_INGOT,sj_Expansion_item.EXPANSION_CORE,SlimefunItems.REINFORCED_ALLOY_INGOT
                }).register(plugin);
        }
        else
        {
                new Expansion_Magma_Block_Machine(Generators, sj_Expansion_item.EXPANSION_MAGMA_BLOCK_MACHINE,
                RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                        SlimefunItems.DAMASCUS_STEEL_INGOT,SlimefunItems.BIG_CAPACITOR,SlimefunItems.DAMASCUS_STEEL_INGOT,
                        new ItemStack(Material.LAVA_BUCKET),sj_Expansion_item.MAGMA_BLOCK_MACHINECORE,new ItemStack(Material.LAVA_BUCKET),
                        SlimefunItems.REINFORCED_ALLOY_INGOT,sj_Expansion_item.EXPANSION_CORE,SlimefunItems.REINFORCED_ALLOY_INGOT
                }).register(plugin);
        }

        //weapons
        new Frost_Touch(Weapons, sj_Expansion_item.FROST_TOUCH,
        RecipeType.NULL, new ItemStack[]{
                null,null,null,
                null,null,null,
                null,null,null
        }).register(plugin);
    }
}