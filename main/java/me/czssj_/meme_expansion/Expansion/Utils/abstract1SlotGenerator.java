package me.czssj_.meme_expansion.Expansion.Utils;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineProcessHolder;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.machines.MachineProcessor;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.handlers.SimpleBlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.AbstractEnergyProvider;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.reactors.ReactorMode;
import io.github.thebusybiscuit.slimefun4.implementation.operations.FuelOperation;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;

public abstract class abstract1SlotGenerator extends AbstractEnergyProvider implements MachineProcessHolder<FuelOperation>
{
    private static final String MODE = "reactor-mode";

    private final MachineProcessor<FuelOperation> processor = new MachineProcessor<>(this);

    @ParametersAreNonnullByDefault
    protected abstract1SlotGenerator(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe)
    {
        super(itemGroup, item, recipeType, recipe);

        processor.setProgressBar(getProgressBar());

        new BlockMenuPreset(getId(), getInventoryTitle())
        {
            @Override
            public void init() {
                constructMenu(this);
            }

            @Override
            public void newInstance(BlockMenu menu, Block b)
            {
                if (BlockStorage.getLocationInfo(b.getLocation(), MODE) == null)
                {
                    BlockStorage.addBlockInfo(b, MODE, ReactorMode.GENERATOR.toString());
                }

                updateInventory(menu, b);
            }

            @Override
            public boolean canOpen(Block b, Player p)
            {
                return p.hasPermission("slimefun.inventory.bypass") || Slimefun.getProtectionManager().hasPermission(p, b.getLocation(), Interaction.INTERACT_BLOCK);
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(@Nullable ItemTransportFlow flow)
            {
                return null;
            }
        };

        addItemHandler(onBreak());
        registerDefaultFuelTypes();
    }

    @Override
    @Nonnull
    public MachineProcessor<FuelOperation> getMachineProcessor()
     {
        return processor;
    }

    @Nonnull
    private BlockBreakHandler onBreak()
    {
        return new SimpleBlockBreakHandler() 
        {

            @Override
            public void onBlockBreak(@Nonnull Block b) 
            {
                BlockMenu inv = BlockStorage.getInventory(b);

                if (inv != null)
                {
                    inv.dropItems(b.getLocation(), getFuelSlots());
                    inv.dropItems(b.getLocation(), getOutputSlots());
                }

                processor.endOperation(b);
            }
        };
    }

    protected void updateInventory(@Nonnull BlockMenu menu, @Nonnull Block b)
    {
        ReactorMode mode = getReactorMode(b.getLocation());

        switch (mode)
        {
            case GENERATOR:
                menu.replaceExistingItem(4, new CustomItemStack(Material.LIGHTNING_ROD, "&7模式: &e电力模式", "", "&6此发电机将和普通发电机一样", "&6如果电力系统不缺电", "&6此发电机将不会工作", "", "&7点击来切换至 &e产物模式"));
                menu.addMenuClickHandler(4, (p, slot, item, action) -> {
                    BlockStorage.addBlockInfo(b, MODE, ReactorMode.PRODUCTION.toString());
                    updateInventory(menu, b);
                    return false;
                });
                break;
            case PRODUCTION:
                menu.replaceExistingItem(4, new CustomItemStack(Material.IRON_INGOT, "&7模式: &e产物模式", "", "&6此发电机将会持续产出", "&6如果电力系统不缺电", "&6此发电机仍然会持续工作", "", "&7点击来切换至 &e电力模式"));
                menu.addMenuClickHandler(4, (p, slot, item, action) -> {
                    BlockStorage.addBlockInfo(b, MODE, ReactorMode.GENERATOR.toString());
                    updateInventory(menu, b);
                    return false;
                });
                break;
            default:
                break;
        }
    }

    private void constructMenu(@Nonnull BlockMenuPreset preset)
    {
        preset.drawBackground(new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE, "§a输入"), new int[]{1,2,3,10,12,19,20,21});
        preset.drawBackground(new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, " "), new int[]{0,8,9,17,18,22,26});
        preset.drawBackground(new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE, "§a输出"), new int[]{5,6,7,14,16,23,24,25});
        preset.drawBackground(new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "), new int[]{13});
    }

    @Nonnull
    protected ReactorMode getReactorMode(@Nonnull Location l)
    {
        ReactorMode mode = ReactorMode.GENERATOR;

        if (BlockStorage.hasBlockInfo(l) && BlockStorage.getLocationInfo(l, MODE).equals(ReactorMode.PRODUCTION.toString()))
        {
            mode = ReactorMode.PRODUCTION;
        }

        return mode;
    }

    public abstract void extraTick(@Nonnull Location l);

    @Override
    public int[] getInputSlots()
    {
        return new int[] {11};
    }

    public int[] getFuelSlots()
    {
        return new int[] {11};
    }

    @Override
    public int[] getOutputSlots()
    {
        return new int[] {15};
    }

    @Override
    public int getGeneratedOutput(Location l, Config data)
    {
        BlockMenu inv = BlockStorage.getInventory(l);
        FuelOperation operation = processor.getOperation(l);

        if (operation != null)
        {
            extraTick(l);

            if (!operation.isFinished())
            {
                return generateEnergy(l, data, inv, operation);
            }
            else
            {
                createByproduct(l, inv, operation);
                return 0;
            }
        }
        else
        {
            burnNextFuel(l, inv);
            return 0;
        }
    }

    private int generateEnergy(@Nonnull Location l, @Nonnull Config data, @Nonnull BlockMenu inv, @Nonnull FuelOperation operation)
    {
        int produced = getEnergyProduction();
        String energyData = data.getString("energy-charge");
        int charge = 0;

        if (energyData != null)
        {
            charge = Integer.parseInt(energyData);
        }

        int space = getCapacity() - charge;

        if (space >= produced || getReactorMode(l) != ReactorMode.GENERATOR)
        {
            operation.addProgress(1);
            processor.updateProgressBar(inv, 13, operation);
        }

        if (space >= produced)
        {
            return getEnergyProduction();
        }
        else
        {
            return 0;
        }
    }

    private void createByproduct(@Nonnull Location l, @Nonnull BlockMenu inv, @Nonnull FuelOperation operation)
    {
        inv.replaceExistingItem(13, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "));
        ItemStack result = operation.getResult();

        if (result != null)
        {
            inv.pushItem(result.clone(), getOutputSlots());
        }

        processor.endOperation(l);
    }

    private void burnNextFuel(Location l, BlockMenu inv)
    {
        Map<Integer, Integer> found = new HashMap<>();
        MachineFuel fuel = findFuel(inv, found);

        if (fuel != null) {
            for (Map.Entry<Integer, Integer> entry : found.entrySet())
            {
                inv.consumeItem(entry.getKey(), entry.getValue());
            }

            processor.startOperation(l, new FuelOperation(fuel));
        }
    }

    @Nullable
    @ParametersAreNonnullByDefault
    private MachineFuel findFuel(BlockMenu menu, Map<Integer, Integer> found)
    {
        for (MachineFuel fuel : fuelTypes)
        {
            for (int slot : getInputSlots())
            {
                if (fuel.test(menu.getItemInSlot(slot)))
                {
                    found.put(slot, fuel.getInput().getAmount());
                    return fuel;
                }
            }
        }
        return null;
    }
}