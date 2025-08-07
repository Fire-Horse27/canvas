package net.fire_horse27.canvas.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fire_horse27.canvas.Canvas;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    /*public static final Item NAME = registerItem("name", Item::new);
    public static final Item NAME = registerItem("name",
        settings -> new Item(setting.));*/

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Canvas.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Canvas.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Canvas.LOGGER.info("Registering Mod Items for " + Canvas.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
//            entries.add(NAME);
        });
    }
}