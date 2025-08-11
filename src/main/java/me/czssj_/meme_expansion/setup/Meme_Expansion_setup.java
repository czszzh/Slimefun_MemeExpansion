package me.czssj_.meme_expansion.setup;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.czssj_.meme_expansion.Expansion.Armor.LanSeYaoJi;
import me.czssj_.meme_expansion.Expansion.Boss.Or_PVP_Boss;
import me.czssj_.meme_expansion.Expansion.Generators.Iron_Generator;
import me.czssj_.meme_expansion.Expansion.Generators.Magma_Block_Machine;
import me.czssj_.meme_expansion.Expansion.Generators.NetherStar_Reactor;
import me.czssj_.meme_expansion.Expansion.Generators.Nuclear_Reactor;
import me.czssj_.meme_expansion.Expansion.Items.Amulet.AttackSpeedUPAmulet;
import me.czssj_.meme_expansion.Expansion.Items.Amulet.DamageReductionAmulet;
import me.czssj_.meme_expansion.Expansion.Items.Amulet.Effect_Amulets;
import me.czssj_.meme_expansion.Expansion.Items.AmuletBackpack;
import me.czssj_.meme_expansion.Expansion.Items.Basketball;
import me.czssj_.meme_expansion.Expansion.Items.Experience_Block;
import me.czssj_.meme_expansion.Expansion.Items.Helicopter;
import me.czssj_.meme_expansion.Expansion.Items.HumanSaddle;
import me.czssj_.meme_expansion.Expansion.Items.JinKeLa;
import me.czssj_.meme_expansion.Expansion.Items.MobItemBan;
import me.czssj_.meme_expansion.Expansion.Items.MobItemLoot;
import me.czssj_.meme_expansion.Expansion.Items.RELX;
import me.czssj_.meme_expansion.Expansion.Machines.Auto_Harvester;
import me.czssj_.meme_expansion.Expansion.Machines.Brewing_Stand;
import me.czssj_.meme_expansion.Expansion.Machines.Directional_Dust_Extractor;
import me.czssj_.meme_expansion.Expansion.Machines.Dis_Enchanting_Table;
import me.czssj_.meme_expansion.Expansion.Machines.Raid_Simulator;
import me.czssj_.meme_expansion.Expansion.Machines.Respawn_Machine;
import me.czssj_.meme_expansion.Expansion.Machines.Stone_Convert_Machine;
import me.czssj_.meme_expansion.Expansion.Material.Material_Final;
import me.czssj_.meme_expansion.Expansion.Material.OrPVPBoss_Star;
import me.czssj_.meme_expansion.Expansion.Material.Villager_Soul;
import me.czssj_.meme_expansion.Expansion.Utils.NotPlaceableItem;
import me.czssj_.meme_expansion.Expansion.Weapon.Frost_Touch;
import me.czssj_.meme_expansion.Expansion.Weapon.Grenade;
import me.czssj_.meme_expansion.Expansion.Weapon.One_Hit_Axe;
import me.czssj_.meme_expansion.Expansion.Weapon.ShenYIng_Stick;
import me.czssj_.meme_expansion.Expansion.Weapon.StackEnchantment_Sword;
import me.czssj_.meme_expansion.Expansion.Weapon.Sword_of_PVPBoss;
import me.czssj_.meme_expansion.Meme_Expansion;

public final class Meme_Expansion_setup
{
    public static final NestedItemGroup Main = new NestedItemGroup(
        new NamespacedKey(Meme_Expansion.getInstance(), "meme_expansion"),
        new CustomItemStack(Material.REDSTONE, "&e&1粘&5液&9科&2技&6梗&e拓&c展", "§4梗拓展的物品怎么能不全是梗呢(╯▔皿▔)╯", "&a> Click to open")
    );

    public static final SubItemGroup Materials = new SubItemGroup(
        new NamespacedKey(Meme_Expansion.getInstance(), "meme_expansion_Materials"),
        Main,
        new CustomItemStack(Material.IRON_INGOT, "&e梗拓展 &f- &9零件&材料", "", "")
    );

    public static final SubItemGroup Items = new SubItemGroup(
        new NamespacedKey(Meme_Expansion.getInstance(), "Meme_Expansion_items"),
        Main,
        new CustomItemStack(Material.STICK, "&e梗拓展 &f- &9物品", "", "")
    );

    public static final SubItemGroup Machines = new SubItemGroup(
        new NamespacedKey(Meme_Expansion.getInstance(), "meme_expansion_Machines"),
        Main,
        new CustomItemStack(Material.STONE, "&e梗拓展 &f- &9机器", "", "")
    );

    public static final SubItemGroup Generators = new SubItemGroup(
        new NamespacedKey(Meme_Expansion.getInstance(), "meme_expansion_Generators"),
        Main,
        new CustomItemStack(Material.GLASS, "&e梗拓展 &f- &9发电机", "", "")
    );

    public static final SubItemGroup Weapons = new SubItemGroup(
        new NamespacedKey(Meme_Expansion.getInstance(), "meme_expansion_Weapons"),
        Main,
        new CustomItemStack(Material.DIAMOND_SWORD, "&e梗拓展 &f- &9武器", "", "")
    );

    public static final SubItemGroup Armors = new SubItemGroup(
        new NamespacedKey(Meme_Expansion.getInstance(), "meme_expansion_Armors"),
        Main,
        new CustomItemStack(Material.DIAMOND_CHESTPLATE, "&e梗拓展 &f- &9盔甲", "", "")
    );

    public static final SubItemGroup Amulet = new SubItemGroup(
        new NamespacedKey(Meme_Expansion.getInstance(), "meme_expansion_Amulet"),
        Main,
        new CustomItemStack(Material.TOTEM_OF_UNDYING, "&e梗拓展 &f- &3护符", "", "")
    );

    public static final SubItemGroup Boss = new SubItemGroup(
        new NamespacedKey(Meme_Expansion.getInstance(), "meme_expansion_Boss"),
        Main,
        new CustomItemStack(Material.ZOMBIE_HEAD, "&e梗拓展 &f- &9BOSS", "", "")
    );

    public static final SubItemGroup Test = new SubItemGroup(
        new NamespacedKey(Meme_Expansion.getInstance(), "meme_expansion_Test"),
        Main,
        new CustomItemStack(Material.BARRIER, "&e梗拓展 &f- &9测试物品", "", "")
    );

    @SuppressWarnings("null")
    public static void Material_setup(Meme_Expansion plugin)
    {
        /*配方类型*/
        RecipeType NetherStarReactorEX_Recipe = new RecipeType(Meme_Expansion_item.NETHERSTAR_REACTOR_GET, "EXPANSION_NETHERSTAR_REACTOR");

        new NotPlaceableItem(Materials, Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
        RecipeType.COMPRESSOR, new ItemStack[]{
            new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3,16),null,null,
            null,null,null,
            null,null,null
        }).register(plugin);

        new NotPlaceableItem(Materials, Meme_Expansion_item.CONCENTRATED_ICE, 
        RecipeType.COMPRESSOR, new ItemStack[]{
            new ItemStack(Material.ICE, 64),new ItemStack(Material.ICE, 64),new ItemStack(Material.ICE, 64),
            new ItemStack(Material.ICE, 64),new ItemStack(Material.ICE, 64),new ItemStack(Material.ICE, 64),
            new ItemStack(Material.ICE, 64),new ItemStack(Material.ICE, 64),null
        }).register(plugin);

        new Villager_Soul(Materials, Meme_Expansion_item.VILLAGER_SOUL,
        RecipeType.MOB_DROP, new ItemStack[]{
            null,null,null,
            null,Meme_Expansion_item.VILLAGER_DROP,null,
            null,null,null
        }).register(plugin);

        new NotPlaceableItem(Materials, Meme_Expansion_item.HELICOPTER_ENGINE,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.REINFORCED_ALLOY_INGOT,SlimefunItems.REINFORCED_ALLOY_INGOT,SlimefunItems.REINFORCED_ALLOY_INGOT,
            new ItemStack(Material.PISTON),SlimefunItem.getById("HELICOPTER_HAT").getItem(),new ItemStack(Material.PISTON),
            SlimefunItem.getById("MACHINE_CORE").getItem(),SlimefunItems.STEEL_THRUSTER,SlimefunItem.getById("MACHINE_CORE").getItem()
        }).register(plugin);

        new NotPlaceableItem(Materials, Meme_Expansion_item.HELICOPTER_GLASS,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            new ItemStack(Material.GLASS_PANE),new ItemStack(Material.GLASS_PANE),new ItemStack(Material.GLASS_PANE),
            new ItemStack(Material.GLASS_PANE),new ItemStack(Material.GLASS_PANE),new ItemStack(Material.GLASS_PANE),
            SlimefunItems.REINFORCED_PLATE,SlimefunItems.WITHER_PROOF_GLASS,SlimefunItems.REINFORCED_PLATE
        }).register(plugin);

        new NotPlaceableItem(Materials, Meme_Expansion_item.HELICOPTER_PROPELLER,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            null,SlimefunItems.STEEL_THRUSTER,null,
            SlimefunItems.STEEL_THRUSTER,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.STEEL_THRUSTER,
            null,SlimefunItems.STEEL_THRUSTER,null
        }).register(plugin);

        if(SlimefunItem.getById("HAIMAN_MAGMA_BLOCK_MACHINE") == null)
        {
            new NotPlaceableItem(Materials, Meme_Expansion_item.MAGMA_BLOCK_MACHINECORE,
            RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                SlimefunItems.DAMASCUS_STEEL_INGOT,SlimefunItems.ADVANCED_CIRCUIT_BOARD,SlimefunItems.DAMASCUS_STEEL_INGOT,
                new ItemStack(Material.LAVA_BUCKET),SlimefunItems.ELECTRIC_MOTOR,new ItemStack(Material.LAVA_BUCKET),
                SlimefunItems.ALUMINUM_BRONZE_INGOT,SlimefunItems.ELECTRIC_MOTOR,SlimefunItems.ALUMINUM_BRONZE_INGOT
            }).register(plugin);
        }

        new NotPlaceableItem(Materials, Meme_Expansion_item.EXPANSION_CORE,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Meme_Expansion_item.CONCENTRATED_ICE,Meme_Expansion_item.NETHERSTAR_DEBRIS,Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            null,new ItemStack(Material.BEACON),null,
            Meme_Expansion_item.IKUN_PRIME,null,Meme_Expansion_item.VILLAGER_SOUL
        }).register(plugin);

        new NotPlaceableItem(Materials, Meme_Expansion_item.OR_PARKOUR_GOD_UNIT, 
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            new ItemStack(Material.STONE_BRICKS),new ItemStack(Material.STONE_BRICKS),new ItemStack(Material.STONE_BRICKS),
            null,Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,null,
            null,new ItemStack(Material.STONE_BRICKS),null
        }).register(plugin);

        new NotPlaceableItem(Materials, Meme_Expansion_item.OR_SURVIVAL_MASTER_UNIT,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            new ItemStack(Material.DIAMOND_ORE),new ItemStack(Material.STONE),new ItemStack(Material.DIAMOND),
            new ItemStack(Material.DIAMOND_PICKAXE),new ItemStack(Material.DIAMOND),new ItemStack(Material.DIAMOND),
            new ItemStack(Material.DIAMOND),new ItemStack(Material.DIAMOND),new ItemStack(Material.DIAMOND)
        }).register(plugin);

        new NotPlaceableItem(Materials, Meme_Expansion_item.OR_PVP_BOSS_UNIT,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            new ItemStack(Material.OAK_FENCE),new ItemStack(Material.OAK_FENCE),new ItemStack(Material.OAK_FENCE),
            new ItemStack(Material.OAK_FENCE),new ItemStack(Material.DISPENSER),new ItemStack(Material.OAK_FENCE_GATE),
            new ItemStack(Material.OAK_FENCE),new ItemStack(Material.OAK_PRESSURE_PLATE),new ItemStack(Material.OAK_FENCE)
        }).register(plugin);

        new NotPlaceableItem(Materials, Meme_Expansion_item.OR_BEDWAR_PRO_UNIT,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,new ItemStack(Material.RED_WOOL),null,
            new ItemStack(Material.RED_WOOL),new ItemStack(Material.RED_BED),new ItemStack(Material.RED_WOOL),
            null,new ItemStack(Material.RED_WOOL),new ItemStack(Material.NETHERITE_SWORD)
        }).register(plugin);

        new NotPlaceableItem(Materials, Meme_Expansion_item.OR_BUILDING_PRO_UNIT,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            new ItemStack(Material.STONE),new ItemStack(Material.STONE),new ItemStack(Material.STONE),
            new ItemStack(Material.STONE),Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,new ItemStack(Material.STONE),
            new ItemStack(Material.BARREL),new ItemStack(Material.OAK_DOOR),null
        }).register(plugin);

        new NotPlaceableItem(Materials, Meme_Expansion_item.OR_REDSTONE_PRO_UNIT,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            new ItemStack(Material.END_ROD),new ItemStack(Material.STICKY_PISTON),null,
            new ItemStack(Material.REDSTONE),new ItemStack(Material.REDSTONE_BLOCK),new ItemStack(Material.REDSTONE),
            new ItemStack(Material.REDSTONE),new ItemStack(Material.PISTON),new ItemStack(Material.REDSTONE)
        }).register(plugin);

        new NotPlaceableItem(Materials, Meme_Expansion_item.OR_A_NOOB_UNIT,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            null,new ItemStack(Material.OAK_LEAVES),null,
            new ItemStack(Material.OAK_LEAVES),new ItemStack(Material.OAK_LOG),new ItemStack(Material.OAK_LEAVES),
            new ItemStack(Material.ARMOR_STAND),new ItemStack(Material.OAK_LOG),null
        }).register(plugin);

        new OrPVPBoss_Star(Materials, Meme_Expansion_item.ORPVPBOSS_STAR,
        RecipeType.NULL, new ItemStack[]{
            null,null,null,
            null,Meme_Expansion_item.ORPVPBOSS_DROP,null,
            null,null,null
        }).register(plugin);

        new OrPVPBoss_Star(Materials, Meme_Expansion_item.ZOMBIE_STICK,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            null,new ItemStack(Material.ZOMBIE_HEAD),null,
            null,new ItemStack(Material.ZOMBIE_HEAD),null,
            null,new ItemStack(Material.ZOMBIE_HEAD),null
        }).register(plugin);

        new NotPlaceableItem(Materials, Meme_Expansion_item.NETHERSTAR_DEBRIS,
        NetherStarReactorEX_Recipe, new ItemStack[]{
            null,null,null,
            null,new ItemStack(Material.NETHER_STAR),null,
            null,null,null
        }).register(plugin);

        new Material_Final(Materials, Meme_Expansion_item.MATERIAL_FINAL,
        RecipeType.NULL, new ItemStack[]{
            null,null,null,
            null,null,null,
            null,null,null
        }).register(plugin);
    }

    @SuppressWarnings("null")
    public static void Item_setup(Meme_Expansion plugin)
    {
        /*配方类型*/
        RecipeType EX_BrewingStand_RecipeType = new RecipeType(Meme_Expansion_item.EXPANSION_BREWING_STAND, "EXPANSION_BREWING_STAND"); 

        /*粗制的药水*/
        ItemStack awkwardPotion = new ItemStack(Material.POTION);
        PotionMeta awkwardPotionMeta = (PotionMeta) awkwardPotion.getItemMeta();
        awkwardPotionMeta.setBasePotionData(new PotionData(PotionType.AWKWARD));
        awkwardPotion.setItemMeta(awkwardPotionMeta);


        new Basketball(Items, Meme_Expansion_item.BASKETBALL,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            SlimefunItems.REINFORCED_CLOTH,SlimefunItems.CLOTH,new ItemStack(Material.SLIME_BLOCK),
            SlimefunItems.CLOTH,Meme_Expansion_item.IKUN_PRIME,SlimefunItems.CLOTH,
            new ItemStack(Material.SLIME_BLOCK),SlimefunItems.CLOTH,SlimefunItems.REINFORCED_CLOTH
        }).register(plugin);

        RecipeType RespawnMachine_RecipeType = new RecipeType(Meme_Expansion_item.EXPANSION_RESPAWN_MACHINE, "EXPANSION_RESPAWN_MACHINE"); 
        new NotPlaceableItem(Items, Meme_Expansion_item.KOBE,
        RespawnMachine_RecipeType, new ItemStack[]{
            null,null,null,
            null,new CustomItemStack(Material.TOTEM_OF_UNDYING, "§a不死图腾", "§f24个"),null,
            null,null,null
        }).register(plugin);

        RecipeType Helicopter_Crash = new RecipeType(new CustomItemStack(Meme_Expansion_item.HELICOPTER, "§4坠机事件", " "), "HELICOPTER"); 
        new NotPlaceableItem(Items, Meme_Expansion_item.MAMBA_SPIRIT,
        Helicopter_Crash, new ItemStack[]{
            null,null,null,
            null,new CustomItemStack(Meme_Expansion_item.KOBE, "§9Kobe", "§f佩戴在头上"),null,
            null,null,null
        }).register(plugin);

        new NotPlaceableItem(Items, Meme_Expansion_item.ZOBAYAN,
        RespawnMachine_RecipeType, new ItemStack[]{
            null,null,null,
            null,new CustomItemStack(Material.TOTEM_OF_UNDYING, "§a不死图腾", "§f10个"),null,
            null,null,null
        }).register(plugin);

        new NotPlaceableItem(Items,Meme_Expansion_item.IKUN_PRIME,
        RecipeType.COMPRESSOR, new ItemStack[]{
            new ItemStack(Material.EGG, 16),new ItemStack(Material.EGG, 16),new ItemStack(Material.EGG, 16),
            new ItemStack(Material.EGG, 16),new ItemStack(Material.EGG, 16),new ItemStack(Material.EGG, 16),
            new ItemStack(Material.EGG, 16),new ItemStack(Material.EGG, 16),new ItemStack(Material.EGG, 16)
        }).register(plugin);

        new Helicopter(Items, Meme_Expansion_item.HELICOPTER,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            null,Meme_Expansion_item.HELICOPTER_PROPELLER,null,
            Meme_Expansion_item.HELICOPTER_GLASS,Meme_Expansion_item.ZOBAYAN,SlimefunItems.STEEL_THRUSTER,
            Meme_Expansion_item.HELICOPTER_ENGINE,SlimefunItems.REINFORCED_PLATE,null
        }).register(plugin);

        new SlimefunItem(Items, Meme_Expansion_item.BAD_OMEN_POTION,
        EX_BrewingStand_RecipeType, new ItemStack[]{
            null,null,null,
            awkwardPotion,null,Meme_Expansion_item.VILLAGER_SOUL,
            null,null,null
        }).register(plugin);

        new RELX(Items, Meme_Expansion_item.RELX_V,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.DURALUMIN_INGOT,SlimefunItems.HEATING_COIL,SlimefunItems.DURALUMIN_INGOT,
            SlimefunItems.DURALUMIN_INGOT,SlimefunItems.BASIC_CIRCUIT_BOARD,SlimefunItems.DURALUMIN_INGOT,
            SlimefunItems.DURALUMIN_INGOT,SlimefunItems.BATTERY,SlimefunItems.DURALUMIN_INGOT
        }, 100).register(plugin);

        new MobItemBan(Items, Meme_Expansion_item.MOB_ITEM_BAN,
        RecipeType.ANCIENT_ALTAR, new ItemStack[]{
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,new ItemStack(Material.STICK),Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            SlimefunItems.ENDER_RUNE,new ItemStack(Material.STICK),SlimefunItems.ENDER_RUNE,
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,new ItemStack(Material.STICK),Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP
        }).register(plugin);

        ItemStack EnchantedBook_lootingIV = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) EnchantedBook_lootingIV.getItemMeta();
        meta.addStoredEnchant(Enchantment.LOOT_BONUS_MOBS, 4, true);
        EnchantedBook_lootingIV.setItemMeta(meta);
        new MobItemLoot(Items, Meme_Expansion_item.MOB_ITEM_LOOT, 
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            null,Meme_Expansion_item.MOB_ITEM_BAN,null,
            EnchantedBook_lootingIV,Meme_Expansion_item.EXPANSION_CORE,EnchantedBook_lootingIV,
            null,Meme_Expansion_item.MOB_ITEM_BAN,null
        }).register(plugin);

        new HumanSaddle(Items, Meme_Expansion_item.HUMANSADDLE, 
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.LEAD),new ItemStack(Material.LEAD),new ItemStack(Material.LEAD),
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,new ItemStack(Material.SADDLE),Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            null,Meme_Expansion_item.EXPANSION_CORE,null
        }).register(plugin);

        new JinKeLa(Items, Meme_Expansion_item.JINKELA,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            new ItemStack(Material.BONE_MEAL),null,new ItemStack(Material.BONE_MEAL),
            null,SlimefunItems.INFERNAL_BONEMEAL,null,
            new ItemStack(Material.BONE_MEAL),null,new ItemStack(Material.BONE_MEAL)
        }).register(plugin);

        new Experience_Block(Items, Meme_Expansion_item.EXPERIENCE_BLOCK,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.EXPERIENCE_BOTTLE),new ItemStack(Material.EXPERIENCE_BOTTLE),new ItemStack(Material.EXPERIENCE_BOTTLE),
            new ItemStack(Material.EXPERIENCE_BOTTLE),null,new ItemStack(Material.EXPERIENCE_BOTTLE),
            new ItemStack(Material.EXPERIENCE_BOTTLE),new ItemStack(Material.EXPERIENCE_BOTTLE),new ItemStack(Material.EXPERIENCE_BOTTLE)
        }).register(plugin);

        new AmuletBackpack(9, Items, Meme_Expansion_item.AMULET_BACKPACK,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            new ItemStack(Material.BLAZE_POWDER),Meme_Expansion_item.EXPANSION_CORE,new ItemStack(Material.BLAZE_POWDER),
            SlimefunItem.getById("MYTHRIL").getItem(),SlimefunItems.RADIANT_BACKPACK,SlimefunItem.getById("ADAMANTITE").getItem(),
            SlimefunItems.REINFORCED_CLOTH,SlimefunItems.COMMON_TALISMAN,SlimefunItems.REINFORCED_CLOTH
        }).register(plugin);
    }

    @SuppressWarnings("null")
    public static void Machine_setup(Meme_Expansion plugin)
    {
        new Brewing_Stand(Machines, Meme_Expansion_item.EXPANSION_BREWING_STAND,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.REINFORCED_PLATE,SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.REINFORCED_PLATE,
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,SlimefunItems.AUTO_BREWER,Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            SlimefunItem.getById("MACHINE_CORE").getItem(),Meme_Expansion_item.EXPANSION_CORE,SlimefunItem.getById("MACHINE_CORE").getItem()
        }).register(plugin);

        new Stone_Convert_Machine(Machines, Meme_Expansion_item.EXPANSION_STONE_CONVERT_MACHINE,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            new ItemStack(Material.STONECUTTER),SlimefunItems.BASIC_CIRCUIT_BOARD,new ItemStack(Material.STONECUTTER),
            SlimefunItems.MAGIC_LUMP_3,SlimefunItems.VANILLA_AUTO_CRAFTER,SlimefunItems.MAGIC_LUMP_3,
            SlimefunItems.CRAFTING_MOTOR,SlimefunItems.SMALL_CAPACITOR,SlimefunItems.CRAFTING_MOTOR
        }, 1).register(plugin);

        new Stone_Convert_Machine(Machines, Meme_Expansion_item.EXPANSION_STONE_CONVERT_MACHINE_2,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.REINFORCED_PLATE,SlimefunItems.ADVANCED_CIRCUIT_BOARD,SlimefunItems.REINFORCED_PLATE,
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,Meme_Expansion_item.EXPANSION_STONE_CONVERT_MACHINE,Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.HEATING_COIL,SlimefunItems.BLISTERING_INGOT_3
        }, 4).setCapacity(400).setEnergyConsumption(40).register(plugin);

        new Respawn_Machine(Machines, Meme_Expansion_item.EXPANSION_RESPAWN_MACHINE, 
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.MAGICAL_GLASS,SlimefunItems.ADVANCED_CIRCUIT_BOARD,SlimefunItem.getById("COMPRESSED_COBBLESTONE_3").getItem(),
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,new ItemStack(Material.RESPAWN_ANCHOR),Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            SlimefunItem.getById("MACHINE_CORE").getItem(),Meme_Expansion_item.EXPANSION_CORE,SlimefunItem.getById("MACHINE_CIRCUIT").getItem()
        }).energyPerTick(960).register(plugin);

        new Dis_Enchanting_Table(Machines, Meme_Expansion_item.DIS_ENCHANTING_TABLE,
        RecipeType.ANCIENT_ALTAR, new ItemStack[]{
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,Meme_Expansion_item.EXPANSION_CORE,Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            Meme_Expansion_item.EXPERIENCE_BLOCK,new ItemStack(Material.ENCHANTING_TABLE),Meme_Expansion_item.EXPERIENCE_BLOCK,
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,SlimefunItems.ENCHANTMENT_RUNE,Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP
        }).register(plugin);

        new Auto_Harvester(Machines, Meme_Expansion_item.AUTO_HARVESTER_1,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.MAGIC_LUMP_1,SlimefunItems.BASIC_CIRCUIT_BOARD,SlimefunItems.MAGIC_LUMP_1,
            new ItemStack(Material.IRON_HOE),SlimefunItems.PROGRAMMABLE_ANDROID_FARMER,new ItemStack(Material.IRON_HOE),
            new ItemStack(Material.HAY_BLOCK),SlimefunItems.SMALL_CAPACITOR,new ItemStack(Material.HAY_BLOCK)
        }, 1).energyCapacity(100).energyPerTick(25).register(plugin);

        new Auto_Harvester(Machines, Meme_Expansion_item.AUTO_HARVESTER_2,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            new ItemStack(Material.HAY_BLOCK),SlimefunItems.BASIC_CIRCUIT_BOARD,new ItemStack(Material.HAY_BLOCK),
            new ItemStack(Material.DIAMOND_HOE),Meme_Expansion_item.AUTO_HARVESTER_1,new ItemStack(Material.DIAMOND_HOE),
            SlimefunItems.MAGIC_LUMP_3,SlimefunItems.MEDIUM_CAPACITOR,SlimefunItems.MAGIC_LUMP_3
        }, 2).energyCapacity(200).energyPerTick(50).register(plugin);

        new Auto_Harvester(Machines, Meme_Expansion_item.AUTO_HARVESTER_EX,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.BLISTERING_INGOT_3,SlimefunItems.ADVANCED_CIRCUIT_BOARD,SlimefunItems.BLISTERING_INGOT_3,
            new ItemStack(Material.HAY_BLOCK),Meme_Expansion_item.AUTO_HARVESTER_2,new ItemStack(Material.HAY_BLOCK),
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,SlimefunItem.getById("MACHINE_CORE").getItem(),Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP
        }, 3).energyCapacity(500).energyPerTick(125).register(plugin);

        new Raid_Simulator(Machines, Meme_Expansion_item.RAID_SIMULATOR_1,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Meme_Expansion_item.VILLAGER_SOUL,new ItemStack(Material.COMPOSTER),new ItemStack(Material.WHITE_BED),
            new ItemStack(Material.NETHERITE_SWORD),SlimefunItem.getById("MOB_SIMULATION_CHAMBER").getItem(),new ItemStack(Material.LAVA_BUCKET),
            SlimefunItems.REINFORCED_ALLOY_INGOT,SlimefunItem.getById("MACHINE_CORE").getItem(),SlimefunItems.REINFORCED_ALLOY_INGOT
        }, 1).energyCapacity(500).energyPerTick(125).register(plugin);

        new Raid_Simulator(Machines, Meme_Expansion_item.RAID_SIMULATOR_2,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.BLISTERING_INGOT_3,SlimefunItem.getById("VILLAGER_DATA_CARD").getItem(),SlimefunItems.BLISTERING_INGOT_3,
            SlimefunItems.ADVANCED_CIRCUIT_BOARD,Meme_Expansion_item.RAID_SIMULATOR_1,SlimefunItems.HEATING_COIL,
            SlimefunItem.getById("COMPRESSED_COBBLESTONE_2").getItem(),SlimefunItems.PROGRAMMABLE_ANDROID_3_BUTCHER,SlimefunItem.getById("COMPRESSED_COBBLESTONE_2").getItem()
        }, 2).energyCapacity(2000).energyPerTick(500).register(plugin);

        new Directional_Dust_Extractor(Machines, Meme_Expansion_item.DIRECTIONAL_DUST_EXTRACTOR_1,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.REINFORCED_PLATE,SlimefunItem.getById("MACHINE_CIRCUIT").getItem(),SlimefunItems.REINFORCED_PLATE,
            SlimefunItems.MAGICAL_GLASS,SlimefunItem.getById("DUST_EXTRACTOR").getItem(),SlimefunItems.MAGICAL_GLASS,
            SlimefunItems.MAGIC_LUMP_3,SlimefunItem.getById("MACHINE_CORE").getItem(),SlimefunItems.MAGIC_LUMP_3
        }, 1).energyCapacity(1000).energyPerTick(250).register(plugin);

        new Directional_Dust_Extractor(Machines, Meme_Expansion_item.DIRECTIONAL_DUST_EXTRACTOR_2,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItem.getById("INFINITE_INGOT").getItem(),Meme_Expansion_item.DIRECTIONAL_DUST_EXTRACTOR_1,SlimefunItem.getById("INFINITE_INGOT").getItem(),
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,SlimefunItem.getById("INFINITY_DUST_EXTRACTOR").getItem(),Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            SlimefunItem.getById("INFINITE_INGOT").getItem(),Meme_Expansion_item.EXPANSION_CORE,SlimefunItem.getById("INFINITE_INGOT").getItem()
        }, 2).energyCapacity(40000).energyPerTick(10000).register(plugin);
    }

    @SuppressWarnings("null")
    public static void Generator_setup(Meme_Expansion plugin)
    {
        new Iron_Generator(Generators, Meme_Expansion_item.IRON_GENERATOR,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            new ItemStack(Material.IRON_INGOT),new ItemStack(Material.FURNACE),new ItemStack(Material.IRON_INGOT),
            SlimefunItems.ELECTRIC_MOTOR,new ItemStack(Material.REDSTONE),SlimefunItems.ELECTRIC_MOTOR,
            new ItemStack(Material.IRON_PICKAXE),SlimefunItems.BASIC_CIRCUIT_BOARD,new ItemStack(Material.IRON_PICKAXE)
        }).register(plugin);

        if(SlimefunItem.getById("HAIMAN_MAGMA_BLOCK_MACHINE") != null)
        {
            new Magma_Block_Machine(Generators, Meme_Expansion_item.MAGMA_BLOCK_MACHINE,
            RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                SlimefunItems.DAMASCUS_STEEL_INGOT,SlimefunItems.BIG_CAPACITOR,SlimefunItems.DAMASCUS_STEEL_INGOT,
                new ItemStack(Material.LAVA_BUCKET),SlimefunItem.getById("HAIMAN_MAGMA_BLOCK_MACHINE").getItem(),new ItemStack(Material.LAVA_BUCKET),
                SlimefunItems.REINFORCED_ALLOY_INGOT,SlimefunItems.ADVANCED_CIRCUIT_BOARD ,SlimefunItems.REINFORCED_ALLOY_INGOT
            }).register(plugin);
        }
        else
        {
            new Magma_Block_Machine(Generators, Meme_Expansion_item.MAGMA_BLOCK_MACHINE,
            RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                SlimefunItems.DAMASCUS_STEEL_INGOT,SlimefunItems.BIG_CAPACITOR,SlimefunItems.DAMASCUS_STEEL_INGOT,
                new ItemStack(Material.LAVA_BUCKET),Meme_Expansion_item.MAGMA_BLOCK_MACHINECORE,new ItemStack(Material.LAVA_BUCKET),
                SlimefunItems.REINFORCED_ALLOY_INGOT,SlimefunItems.ADVANCED_CIRCUIT_BOARD,SlimefunItems.REINFORCED_ALLOY_INGOT
            }).register(plugin);
        }

        new Nuclear_Reactor(Generators, Meme_Expansion_item.NUCLEAR_REACTOR,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.REINFORCED_ALLOY_INGOT,SlimefunItems.REACTOR_ACCESS_PORT,SlimefunItems.REINFORCED_ALLOY_INGOT,
            new ItemStack(Material.WATER_BUCKET),SlimefunItems.NUCLEAR_REACTOR,new ItemStack(Material.WATER_BUCKET),
            Meme_Expansion_item.CONCENTRATED_ICE,SlimefunItem.getById("EXTREME_FREEZER").getItem(),Meme_Expansion_item.CONCENTRATED_ICE
        }).register(plugin);

        new NetherStar_Reactor(Generators, Meme_Expansion_item.NETHERSTAR_REACTOR,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Meme_Expansion_item.CONCENTRATED_ICE,SlimefunItems.REACTOR_ACCESS_PORT,SlimefunItems.NETHER_ICE_COOLANT_CELL,
            SlimefunItems.WITHER_PROOF_GLASS,SlimefunItems.NETHER_STAR_REACTOR,SlimefunItems.WITHER_PROOF_GLASS,
            SlimefunItems.REINFORCED_PLATE,SlimefunItem.getById("EXTREME_FREEZER").getItem(),SlimefunItems.REINFORCED_PLATE
        }).register(plugin);
    }

    @SuppressWarnings("null")
    public static void Armor_setup(Meme_Expansion plugin)
    {
        /*迅捷药水*/
        ItemStack swiftnessPotion = new ItemStack(Material.POTION);
        PotionMeta swiftnessPotionMeta = (PotionMeta) swiftnessPotion.getItemMeta();
        swiftnessPotionMeta.setBasePotionData(new PotionData(PotionType.SPEED));
        swiftnessPotion.setItemMeta(swiftnessPotionMeta);

        
        new LanSeYaoJi(Armors, Meme_Expansion_item.BLUE_SUIT,
        RecipeType.ARMOR_FORGE, new ItemStack[]{
            new ItemStack(Material.BLUE_WOOL),null,new ItemStack(Material.BLUE_WOOL),
            new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.LEATHER_CHESTPLATE),new ItemStack(Material.BLUE_WOOL),
            new ItemStack(Material.BLUE_WOOL),swiftnessPotion,new ItemStack(Material.BLUE_WOOL)
        }).register(plugin);

        new LanSeYaoJi(Armors, Meme_Expansion_item.BLUE_PANTS,
        RecipeType.ARMOR_FORGE, new ItemStack[]{
            new ItemStack(Material.BLUE_WOOL),new ItemStack(Material.LEATHER_LEGGINGS),new ItemStack(Material.BLUE_WOOL),
            new ItemStack(Material.BLUE_WOOL),swiftnessPotion,new ItemStack(Material.BLUE_WOOL),
            new ItemStack(Material.BLUE_WOOL),null,new ItemStack(Material.BLUE_WOOL)
        }).register(plugin);

        new LanSeYaoJi(Armors, Meme_Expansion_item.QIE_ER_XI,
        RecipeType.ARMOR_FORGE, new ItemStack[]{
            SlimefunItems.GOLD_24K,null,SlimefunItems.GOLD_24K,
            SlimefunItems.GOLD_24K,null,SlimefunItems.GOLD_24K,
            swiftnessPotion,null,swiftnessPotion
        }).register(plugin);
    }

    @SuppressWarnings("null")
    public static void Weapon_setup(Meme_Expansion plugin)
    {
        new Frost_Touch(Weapons, Meme_Expansion_item.FROST_TOUCH,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,new ItemStack(Material.DIAMOND),Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            Meme_Expansion_item.CONCENTRATED_ICE,new ItemStack(Material.DIAMOND),Meme_Expansion_item.CONCENTRATED_ICE,
            null,new ItemStack(Material.BLAZE_ROD),null
        }).register(plugin);

        new One_Hit_Axe(Weapons, Meme_Expansion_item.ONE_HIT_AXE, 
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            null,Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,SlimefunItems.REINFORCED_PLATE,
            null,new ItemStack(Material.NETHERITE_AXE),SlimefunItems.REINFORCED_PLATE,
            null,Meme_Expansion_item.EXPANSION_CORE,null
        }).register(plugin);

        new Grenade(Weapons, Meme_Expansion_item.GRENADE, 
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            null,new ItemStack(Material.FLINT_AND_STEEL),null,
            SlimefunItems.DAMASCUS_STEEL_INGOT,new ItemStack(Material.GUNPOWDER),SlimefunItems.DAMASCUS_STEEL_INGOT,
            null,SlimefunItems.DAMASCUS_STEEL_INGOT,null
        }).register(plugin);

        new StackEnchantment_Sword(Weapons, Meme_Expansion_item.STACKENCHANTMENT_SWORD,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,SlimefunItems.REINFORCED_PLATE,Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,Meme_Expansion_item.EXPANSION_CORE,Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            null,new ItemStack(Material.BLAZE_ROD),null
        }).register(plugin);

        new Sword_of_PVPBoss(Weapons, Meme_Expansion_item.SWORD_OF_PVPBOSS,
        RecipeType.NULL, new ItemStack[]{
            null,null,null,
            Meme_Expansion_item.ZOMBIE_STICK,null,Meme_Expansion_item.ORPVPBOSS_STAR,
            null,null,null
        }).register(plugin);

        new ShenYIng_Stick(Weapons, Meme_Expansion_item.SHENYING_STICK,
        RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            null,null,new ItemStack(Material.DIAMOND),
            null,SlimefunItems.STAFF_WIND,null,
            new ItemStack(Material.BLAZE_ROD),null,null
        }).register(plugin);
    }

    @SuppressWarnings("null")
    public static void Amulet_setup(Meme_Expansion plugin)
    {
        /*迅捷药水*/
        ItemStack swiftnessPotion = new ItemStack(Material.POTION);
        PotionMeta swiftnessPotionMeta = (PotionMeta) swiftnessPotion.getItemMeta();
        swiftnessPotionMeta.setBasePotionData(new PotionData(PotionType.SPEED));
        swiftnessPotion.setItemMeta(swiftnessPotionMeta);

        /*跳跃提升药水*/
        ItemStack jumpboostPotion = new ItemStack(Material.POTION);
        PotionMeta jumpboostPotionMeta = (PotionMeta) jumpboostPotion.getItemMeta();
        jumpboostPotionMeta.setBasePotionData(new PotionData(PotionType.JUMP));
        jumpboostPotion.setItemMeta(jumpboostPotionMeta);

        /*水下呼吸药水*/
        ItemStack waterBreathingPotion = new ItemStack(Material.POTION);
        PotionMeta waterBreathingPotionMeta = (PotionMeta) waterBreathingPotion.getItemMeta();
        waterBreathingPotionMeta.setBasePotionData(new PotionData(PotionType.WATER_BREATHING));
        waterBreathingPotion.setItemMeta(waterBreathingPotionMeta);

        /*抗火药水*/
        ItemStack fireResistancePotion = new ItemStack(Material.POTION);
        PotionMeta fireResistancePotionMeta = (PotionMeta) fireResistancePotion.getItemMeta();
        fireResistancePotionMeta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE));
        fireResistancePotion.setItemMeta(fireResistancePotionMeta);

        /*夜视药水*/
        ItemStack nightVisionPotion = new ItemStack(Material.POTION);
        PotionMeta nightVisionPotionMeta = (PotionMeta) nightVisionPotion.getItemMeta();
        nightVisionPotionMeta.setBasePotionData(new PotionData(PotionType.NIGHT_VISION));
        nightVisionPotion.setItemMeta(nightVisionPotionMeta);

        /*力量药水*/
        ItemStack strengthPotion = new ItemStack(Material.POTION);
        PotionMeta strengthPotionMeta = (PotionMeta) strengthPotion.getItemMeta();
        strengthPotionMeta.setBasePotionData(new PotionData(PotionType.STRENGTH));
        strengthPotion.setItemMeta(strengthPotionMeta);

        /*生命恢复药水*/
        ItemStack regenerationPotion = new ItemStack(Material.POTION);
        PotionMeta regenerationPotionMeta = (PotionMeta) regenerationPotion.getItemMeta();
        regenerationPotionMeta.setBasePotionData(new PotionData(PotionType.REGEN));
        regenerationPotion.setItemMeta(regenerationPotionMeta);

        /*缓降药水*/
        ItemStack slowFallingPotion = new ItemStack(Material.POTION);
        PotionMeta slowFallingPotionMeta = (PotionMeta) slowFallingPotion.getItemMeta();
        slowFallingPotionMeta.setBasePotionData(new PotionData(PotionType.SLOW_FALLING));
        slowFallingPotion.setItemMeta(slowFallingPotionMeta);

        /*隐身药水*/
        ItemStack invisibilityPotion = new ItemStack(Material.POTION);
        PotionMeta invisibilityPotionMeta = (PotionMeta) invisibilityPotion.getItemMeta();
        invisibilityPotionMeta.setBasePotionData(new PotionData(PotionType.INVISIBILITY));
        invisibilityPotion.setItemMeta(invisibilityPotionMeta);

        
        /*抗性提升护符*/
        new Effect_Amulets(Amulet, Meme_Expansion_item.RESISTANCE_AMULET_1, 
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            SlimefunItems.REINFORCED_PLATE,SlimefunItems.COMMON_TALISMAN,SlimefunItems.REINFORCED_PLATE,
            SlimefunItems.MAGIC_LUMP_2,new ItemStack(Material.NETHER_STAR),SlimefunItems.MAGIC_LUMP_2,
            SlimefunItems.REINFORCED_PLATE,new ItemStack(Material.BLAZE_POWDER),SlimefunItems.REINFORCED_PLATE
        },
        PotionEffectType.DAMAGE_RESISTANCE, 1).register(plugin);

        new Effect_Amulets(Amulet, Meme_Expansion_item.RESISTANCE_AMULET_2, 
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            SlimefunItems.MAGIC_LUMP_3,new ItemStack(Material.DIAMOND_BLOCK),SlimefunItems.MAGIC_LUMP_3,
            Meme_Expansion_item.RESISTANCE_AMULET_1,new ItemStack(Material.GOLDEN_APPLE),Meme_Expansion_item.RESISTANCE_AMULET_1,
            SlimefunItems.MAGIC_LUMP_3,null,SlimefunItems.MAGIC_LUMP_3
        },
        PotionEffectType.DAMAGE_RESISTANCE, 2).register(plugin);

        new Effect_Amulets(Amulet, Meme_Expansion_item.RESISTANCE_AMULET_4, 
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            Meme_Expansion_item.RESISTANCE_AMULET_2,new ItemStack(Material.ENCHANTED_GOLDEN_APPLE),Meme_Expansion_item.RESISTANCE_AMULET_2,
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,Meme_Expansion_item.EXPANSION_CORE,Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            Meme_Expansion_item.RESISTANCE_AMULET_2,null,Meme_Expansion_item.RESISTANCE_AMULET_2
        },
        PotionEffectType.DAMAGE_RESISTANCE, 4).register(plugin);

        /*迅捷护符*/
        new Effect_Amulets(Amulet, Meme_Expansion_item.SPEED_AMULET_1, 
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.BLAZE_POWDER),SlimefunItems.COMMON_TALISMAN,new ItemStack(Material.BLAZE_POWDER),
            swiftnessPotion,swiftnessPotion,swiftnessPotion,
            new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER)
        },
        PotionEffectType.SPEED, 1).register(plugin);

        new Effect_Amulets(Amulet, Meme_Expansion_item.SPEED_AMULET_2, 
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            SlimefunItems.MAGIC_LUMP_3,new ItemStack(Material.BEACON),SlimefunItems.MAGIC_LUMP_3,
            Meme_Expansion_item.SPEED_AMULET_1,swiftnessPotion,Meme_Expansion_item.SPEED_AMULET_1,
            SlimefunItems.MAGIC_LUMP_3,null,SlimefunItems.MAGIC_LUMP_3
        },
        PotionEffectType.SPEED, 2).register(plugin);

        /*急迫护符*/
        new Effect_Amulets(Amulet, Meme_Expansion_item.HASTE_AMULET_1,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.BLAZE_POWDER),SlimefunItems.COMMON_TALISMAN,new ItemStack(Material.BLAZE_POWDER),
            SlimefunItems.MAGIC_LUMP_2,new ItemStack(Material.BEACON),SlimefunItems.MAGIC_LUMP_2,
            new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER)
        },
        PotionEffectType.FAST_DIGGING, 1).register(plugin);

        new Effect_Amulets(Amulet, Meme_Expansion_item.HASTE_AMULET_2,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            SlimefunItems.MAGIC_LUMP_3,new ItemStack(Material.DIAMOND_BLOCK),SlimefunItems.MAGIC_LUMP_3,
            Meme_Expansion_item.HASTE_AMULET_1,new ItemStack(Material.NETHERITE_PICKAXE),Meme_Expansion_item.HASTE_AMULET_1,
            SlimefunItems.MAGIC_LUMP_3,null,SlimefunItems.MAGIC_LUMP_3
        },
        PotionEffectType.FAST_DIGGING, 2).register(plugin);

        /*力量护符*/
        new Effect_Amulets(Amulet, Meme_Expansion_item.STRENGTH_AMULET_1,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.BLAZE_POWDER),SlimefunItems.COMMON_TALISMAN,new ItemStack(Material.BLAZE_POWDER),
            strengthPotion,strengthPotion,strengthPotion,
            new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER)
        },
        PotionEffectType.INCREASE_DAMAGE, 1).register(plugin);

        new Effect_Amulets(Amulet, Meme_Expansion_item.STRENGTH_AMULET_2,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            SlimefunItems.MAGIC_LUMP_3,new ItemStack(Material.BEACON),SlimefunItems.MAGIC_LUMP_3,
            Meme_Expansion_item.STRENGTH_AMULET_1,strengthPotion,Meme_Expansion_item.STRENGTH_AMULET_1,
            SlimefunItems.MAGIC_LUMP_3,null,SlimefunItems.MAGIC_LUMP_3
        },
        PotionEffectType.INCREASE_DAMAGE, 2).register(plugin);

        /*跳跃提升护符*/
        new Effect_Amulets(Amulet, Meme_Expansion_item.JUMPBOOST_AMULET_1,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.BLAZE_POWDER),SlimefunItems.COMMON_TALISMAN,new ItemStack(Material.BLAZE_POWDER),
            jumpboostPotion,jumpboostPotion,jumpboostPotion,
            new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER)
        },
        PotionEffectType.JUMP, 1).register(plugin);

        new Effect_Amulets(Amulet, Meme_Expansion_item.JUMPBOOST_AMULET_2,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            SlimefunItems.MAGIC_LUMP_3,new ItemStack(Material.BEACON),SlimefunItems.MAGIC_LUMP_3,
            Meme_Expansion_item.JUMPBOOST_AMULET_1,jumpboostPotion,Meme_Expansion_item.JUMPBOOST_AMULET_1,
            SlimefunItems.MAGIC_LUMP_3,null,SlimefunItems.MAGIC_LUMP_3
        },
        PotionEffectType.JUMP, 2).register(plugin);

        /*生命恢复护符*/
        new Effect_Amulets(Amulet, Meme_Expansion_item.REGENERATION_AMULET_1,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.BLAZE_POWDER),SlimefunItems.COMMON_TALISMAN,new ItemStack(Material.BLAZE_POWDER),
            regenerationPotion,regenerationPotion,regenerationPotion,
            new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER)
        },
        PotionEffectType.REGENERATION, 1).register(plugin);

        new Effect_Amulets(Amulet, Meme_Expansion_item.REGENERATION_AMULET_2,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            SlimefunItems.MAGIC_LUMP_3,new ItemStack(Material.BEACON),SlimefunItems.MAGIC_LUMP_3,
            Meme_Expansion_item.REGENERATION_AMULET_1,regenerationPotion,Meme_Expansion_item.REGENERATION_AMULET_1,
            SlimefunItems.MAGIC_LUMP_3,null,SlimefunItems.MAGIC_LUMP_3
        },
        PotionEffectType.REGENERATION, 2).register(plugin);

        /*抗火护符*/
        new Effect_Amulets(Amulet, Meme_Expansion_item.FIRE_RESISTANCE_AMULET,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.BLAZE_POWDER),SlimefunItems.COMMON_TALISMAN,new ItemStack(Material.BLAZE_POWDER),
            fireResistancePotion,fireResistancePotion,fireResistancePotion,
            new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER)
        },
        PotionEffectType.FIRE_RESISTANCE, 1).register(plugin);

        /*水下呼吸护符*/
        new Effect_Amulets(Amulet, Meme_Expansion_item.WATER_BREATHING_AMULET,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.BLAZE_POWDER),SlimefunItems.COMMON_TALISMAN,new ItemStack(Material.BLAZE_POWDER),
            waterBreathingPotion,waterBreathingPotion,waterBreathingPotion,
            new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER)
        },
        PotionEffectType.WATER_BREATHING, 1).register(plugin);

        /*隐身护符*/
        new Effect_Amulets(Amulet, Meme_Expansion_item.INVISIBILITY_AMULET,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.BLAZE_POWDER),SlimefunItems.COMMON_TALISMAN,new ItemStack(Material.BLAZE_POWDER),
            invisibilityPotion,invisibilityPotion,invisibilityPotion,
            new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER)
        },
        PotionEffectType.INVISIBILITY, 1).register(plugin);

        /*夜视护符*/
        new Effect_Amulets(Amulet, Meme_Expansion_item.NIGHT_VISION_AMULET,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.BLAZE_POWDER),SlimefunItems.COMMON_TALISMAN,new ItemStack(Material.BLAZE_POWDER),
            nightVisionPotion,nightVisionPotion,nightVisionPotion,
            new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER)
        },
        PotionEffectType.NIGHT_VISION, 1).register(plugin);

        /*伤害吸收护符*/
        new Effect_Amulets(Amulet, Meme_Expansion_item.ABSORPTION_AMULET_1,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.BLAZE_POWDER),SlimefunItems.COMMON_TALISMAN,new ItemStack(Material.BLAZE_POWDER),
            SlimefunItems.MAGIC_LUMP_2,new ItemStack(Material.GOLDEN_APPLE),SlimefunItems.MAGIC_LUMP_2,
            new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER)
        },
        PotionEffectType.ABSORPTION, 1).register(plugin);

        new Effect_Amulets(Amulet, Meme_Expansion_item.ABSORPTION_AMULET_2,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            SlimefunItems.MAGIC_LUMP_3,new ItemStack(Material.BEACON),SlimefunItems.MAGIC_LUMP_3,
            Meme_Expansion_item.ABSORPTION_AMULET_1,new ItemStack(Material.TOTEM_OF_UNDYING),Meme_Expansion_item.ABSORPTION_AMULET_1,
            SlimefunItems.MAGIC_LUMP_3,null,SlimefunItems.MAGIC_LUMP_3
        },
        PotionEffectType.ABSORPTION, 2).register(plugin);

        new Effect_Amulets(Amulet, Meme_Expansion_item.ABSORPTION_AMULET_4,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            Meme_Expansion_item.ABSORPTION_AMULET_2,new ItemStack(Material.ENCHANTED_GOLDEN_APPLE),Meme_Expansion_item.ABSORPTION_AMULET_2,
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,Meme_Expansion_item.EXPANSION_CORE,Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            Meme_Expansion_item.ABSORPTION_AMULET_2,null,Meme_Expansion_item.ABSORPTION_AMULET_2
        },
        PotionEffectType.ABSORPTION, 4).register(plugin);

        /*饱和护符*/
        new Effect_Amulets(Amulet, Meme_Expansion_item.SATURATION_AMULET,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.RABBIT_STEW),new ItemStack(Material.CAKE),new ItemStack(Material.SUSPICIOUS_STEW),
            Meme_Expansion_item.EXPANSION_CORE,new ItemStack(Material.GOLDEN_CARROT),Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            new ItemStack(Material.BEETROOT_SOUP),new ItemStack(Material.HONEY_BOTTLE),new ItemStack(Material.PUMPKIN_PIE)
        },
        PotionEffectType.SATURATION, 1).register(plugin);

        /*缓降护符*/
        new Effect_Amulets(Amulet, Meme_Expansion_item.SLOW_FALLING_AMULET,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.BLAZE_POWDER),SlimefunItems.COMMON_TALISMAN,new ItemStack(Material.BLAZE_POWDER),
            slowFallingPotion,slowFallingPotion,slowFallingPotion,
            new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER)
        },
        PotionEffectType.SLOW_FALLING, 1).register(plugin);

        /*潮涌能量护符*/
        new Effect_Amulets(Amulet, Meme_Expansion_item.CONDIUT_POWER_AMULET,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BEACON),new ItemStack(Material.BLAZE_POWDER),
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,new ItemStack(Material.CONDUIT),Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            new ItemStack(Material.BLAZE_POWDER),SlimefunItems.COMMON_TALISMAN,new ItemStack(Material.BLAZE_POWDER)
        },
        PotionEffectType.CONDUIT_POWER, 1).register(plugin);

        /*村庄英雄护符*/
        new Effect_Amulets(Amulet, Meme_Expansion_item.VILLAGE_HERO_AMULET_1,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.BLAZE_POWDER),SlimefunItems.COMMON_TALISMAN,new ItemStack(Material.BLAZE_POWDER),
            new ItemStack(Material.EMERALD),Meme_Expansion_item.VILLAGER_SOUL,new ItemStack(Material.EMERALD),
            new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER),new ItemStack(Material.BLAZE_POWDER)
        },
        PotionEffectType.HERO_OF_THE_VILLAGE, 1).register(plugin);

        new Effect_Amulets(Amulet, Meme_Expansion_item.VILLAGE_HERO_AMULET_2,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            SlimefunItems.MAGIC_LUMP_2,new ItemStack(Material.EMERALD_BLOCK),SlimefunItems.MAGIC_LUMP_2,
            Meme_Expansion_item.VILLAGE_HERO_AMULET_1,Meme_Expansion_item.VILLAGER_SOUL,Meme_Expansion_item.VILLAGE_HERO_AMULET_1,
            SlimefunItems.MAGIC_LUMP_2,new ItemStack(Material.EMERALD_BLOCK),SlimefunItems.MAGIC_LUMP_2
        },
        PotionEffectType.HERO_OF_THE_VILLAGE, 2).register(plugin);

        new Effect_Amulets(Amulet, Meme_Expansion_item.VILLAGE_HERO_AMULET_3,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            SlimefunItems.MAGIC_LUMP_3,new ItemStack(Material.BEACON),SlimefunItems.MAGIC_LUMP_3,
            Meme_Expansion_item.VILLAGE_HERO_AMULET_2,Meme_Expansion_item.VILLAGER_SOUL,Meme_Expansion_item.VILLAGE_HERO_AMULET_2,
            SlimefunItems.MAGIC_LUMP_3,new ItemStack(Material.EMERALD_BLOCK),SlimefunItems.MAGIC_LUMP_3
        },
        PotionEffectType.HERO_OF_THE_VILLAGE, 3).register(plugin);

        new Effect_Amulets(Amulet, Meme_Expansion_item.VILLAGE_HERO_AMULET_4,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            new ItemStack(Material.TOTEM_OF_UNDYING),Meme_Expansion_item.VILLAGE_HERO_AMULET_3,new ItemStack(Material.TOTEM_OF_UNDYING),
            SlimefunItems.SYNTHETIC_EMERALD,Meme_Expansion_item.VILLAGER_SOUL,SlimefunItems.SYNTHETIC_EMERALD,
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,Meme_Expansion_item.VILLAGE_HERO_AMULET_3,Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP
        },
        PotionEffectType.HERO_OF_THE_VILLAGE, 4).register(plugin);

        new Effect_Amulets(Amulet, Meme_Expansion_item.VILLAGE_HERO_AMULET_5,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,Meme_Expansion_item.VILLAGER_SOUL,Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            Meme_Expansion_item.VILLAGE_HERO_AMULET_4,Meme_Expansion_item.EXPANSION_CORE,Meme_Expansion_item.VILLAGE_HERO_AMULET_4,
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,new ItemStack(Material.TOTEM_OF_UNDYING),Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP
        },
        PotionEffectType.HERO_OF_THE_VILLAGE, 5).register(plugin);

        /*伤害-1护符*/
        new DamageReductionAmulet(Amulet, Meme_Expansion_item.DAMAGE_REDUCTION_AMULET,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            SlimefunItems.REINFORCED_PLATE,new ItemStack(Material.BLAZE_POWDER),SlimefunItems.REINFORCED_PLATE,
            SlimefunItems.MAGIC_LUMP_3,new ItemStack(Material.SHIELD),SlimefunItems.MAGIC_LUMP_3,
            SlimefunItems.REINFORCED_PLATE,SlimefunItems.COMMON_TALISMAN,SlimefunItems.REINFORCED_PLATE
        }).register(plugin);

        /*攻速提升护符*/
        new AttackSpeedUPAmulet(Amulet, Meme_Expansion_item.ATTACK_SPEEDUP_AMULET,
        RecipeType.MAGIC_WORKBENCH, new ItemStack[]{
            Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,SlimefunItems.COMMON_TALISMAN,Meme_Expansion_item.CONCENTRATED_MAGIC_LUMP,
            SlimefunItems.STAFF_WIND,Meme_Expansion_item.EXPANSION_CORE,SlimefunItems.LIGHTNING_RUNE,       
            SlimefunItems.ESSENCE_OF_AFTERLIFE,new ItemStack(Material.BLAZE_POWDER),SlimefunItems.ESSENCE_OF_AFTERLIFE
        }).register(plugin);
    }

    public static void Boss_setup(Meme_Expansion plugin)
    {
        new Or_PVP_Boss(Boss, Meme_Expansion_item.OR_PVP_BOSS, 
        RecipeType.ANCIENT_ALTAR, new ItemStack[]{
            Meme_Expansion_item.OR_PARKOUR_GOD_UNIT,Meme_Expansion_item.OR_SURVIVAL_MASTER_UNIT,Meme_Expansion_item.OR_PVP_BOSS_UNIT,
            Meme_Expansion_item.OR_BEDWAR_PRO_UNIT,Meme_Expansion_item.OR_PVP_BOSS_UNIT,Meme_Expansion_item.OR_BUILDING_PRO_UNIT,
            Meme_Expansion_item.OR_REDSTONE_PRO_UNIT,Meme_Expansion_item.OR_PVP_BOSS_UNIT,Meme_Expansion_item.OR_A_NOOB_UNIT
        }).register(plugin);
    }
}