package com.turts.oceanics.item;

import com.turts.oceanics.Oceanicplus;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item NAUTILUS_CHESTPLATE = registerItem("nautilus_chestplate");
    public static final Item FROG_HIDE = registerItem("frog_hide");
    public static final Item FROG_BOOTS = registerItem("frog_boots");
    public static final Item FROG_LEGGINGS = registerItem("frog_leggings");

    private static Item registerItem(String name) {
        Identifier id = Identifier.of(Oceanicplus.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = new Item.Settings().registryKey(key);

        return Registry.register(Registries.ITEM, key , new Item(settings));
    }

    public static void registerModItems() {
        Oceanicplus.LOGGER.info("Registering Mod Items for " + Oceanicplus.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(entries -> {
            entries.add(NAUTILUS_CHESTPLATE);
            entries.add(FROG_HIDE);
            entries.add(FROG_BOOTS);
            entries.add(FROG_LEGGINGS);
        });
    }
}