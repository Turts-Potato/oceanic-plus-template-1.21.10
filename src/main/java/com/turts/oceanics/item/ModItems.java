package com.turts.oceanics.item;

import com.turts.oceanics.Oceanicplus;
import com.turts.oceanics.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {


    public static final Item FROG_HIDE = registerItem("frog_hide", Item::new);
  //  public static final Item ORANGE_FROG_HIDE = registerItem("orange_frog_hide", Item::new);
  //  public static final Item WHITE_FROG_HIDE = registerItem("white_frog_hide", Item::new);



    public static final Item FROG_HAT = registerItem("frog_hat",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.FIX_MOD_ARMOR_ITEM_FOR_ME_THANKS_MATERIAL, EquipmentType.HELMET), ModArmorMaterials.FIX_MOD_ARMOR_ITEM_FOR_ME_THANKS_MATERIAL));

    public static final Item FROG_CHESTPLATE = registerItem("frog_chestplate",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.FIX_MOD_ARMOR_ITEM_FOR_ME_THANKS_MATERIAL, EquipmentType.CHESTPLATE), ModArmorMaterials.FIX_MOD_ARMOR_ITEM_FOR_ME_THANKS_MATERIAL));

    public static final Item NAUTILUS_CHESTPLATE = registerItem("nautilus_chestplate",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.NAUTILUS_SHELL_ARMOR_MATERIAL, EquipmentType.CHESTPLATE), ModArmorMaterials.NAUTILUS_SHELL_ARMOR_MATERIAL));

    public static final Item FROG_BOOTS = registerItem("frog_boots",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.FROG_HIDE_ARMOR_MATERIAL, EquipmentType.BOOTS), ModArmorMaterials.FROG_HIDE_ARMOR_MATERIAL));

    public static final Item FROG_LEGGINGS = registerItem("frog_leggings",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.FROG_HIDE_ARMOR_MATERIAL, EquipmentType.LEGGINGS), ModArmorMaterials.FROG_HIDE_ARMOR_MATERIAL));

    public static final Item BURNT_FROG_LEGS = registerItem("burnt_frog_legs",
            settings -> new Item(settings.food(ModFoodComponents.BURNT_FROG_LEGS, ModConsumableComponents.BURNT_FROG_LEGS)));

    public static final Item BURNT_FROG_FEET = registerItem("burnt_frog_feet",
            settings -> new Item(settings.food(ModFoodComponents.BURNT_FROG_FEET, ModConsumableComponents.BURNT_FROG_FEET)));


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {

        return Registry.register(Registries.ITEM, Identifier.of(Oceanicplus.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Oceanicplus.MOD_ID + ":" + name)))));
    }

    public static void registerModItems() {
        Oceanicplus.LOGGER.info("Registering Mod Items for " + Oceanicplus.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(entries -> {
            entries.add(NAUTILUS_CHESTPLATE);
            entries.add(FROG_HIDE);
            //entries.add(ORANGE_FROG_HIDE);
            //entries.add(WHITE_FROG_HIDE);
            entries.add(FROG_BOOTS);
            entries.add(FROG_LEGGINGS);
            entries.add(FROG_HAT);
            entries.add(FROG_CHESTPLATE);
            entries.add(BURNT_FROG_LEGS);
            entries.add(BURNT_FROG_FEET);
        });
    }
}