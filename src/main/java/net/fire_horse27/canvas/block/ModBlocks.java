package net.fire_horse27.canvas.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fire_horse27.canvas.Canvas;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    /*public static final Block AZALEA_PRESSURE_PLATE = register("azalea_pressure_plate",
            settings -> new PressurePlateBlock(AZALEA, settings),
            () -> AbstractBlock.Settings.copy(Blocks.CHERRY_PRESSURE_PLATE).mapColor(MapColor.TERRACOTTA_GRAY));*/

    private static Block register(String name, Function<AbstractBlock.Settings, Block> function, Supplier<AbstractBlock.Settings> settingsSupplier, Boolean regItem) {
        AbstractBlock.Settings settings = settingsSupplier.get().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Canvas.MOD_ID, name)));
        Block toRegister = function.apply(settings);
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(Canvas.MOD_ID, name), toRegister);
    }

    private static Block register(String name, Function<AbstractBlock.Settings, Block> function, Supplier<AbstractBlock.Settings> settingsSupplier) {
        return register(name, function, settingsSupplier, true);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Canvas.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Canvas.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        Canvas.LOGGER.debug("Registering ModBlocks for " + Canvas.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            /*entries.add(ModBlocks.NAME);*/
        });
    }
}