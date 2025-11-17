package com.turts.oceanics.item;

import com.turts.oceanics.Oceanicplus;
import com.turts.oceanics.item.custom.ModArmorItem;
import com.turts.oceanics.item.custom.ModArmorItemButForTags;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.text.Text;
import java.util.List;

import java.util.function.Function;

public class ModItems {

    private static final Text AWAKEN_UPGRADE_APPLIES_TO_TEXT =
            Text.translatable("item.oceanic-plus.smithing_template.aquatic_upgrade.applies_to");

    private static final Text AWAKEN_UPGRADE_INGREDIENTS_TEXT =
            Text.translatable("item.oceanic-plus.smithing_template.aquatic_upgrade.ingredients");

    private static final Text AWAKEN_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT =
            Text.translatable("item.oceanic-plus.smithing_template.aquatic_upgrade.base_slot_description");

    private static final Text AWAKEN_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT =
            Text.translatable("item.oceanic-plus.smithing_template.aquatic_upgrade.additions_slot_description");

    private static List<Identifier> getAwakenUpgradeEmptyBaseSlotTextures() {
        return List.of(
                Identifier.ofVanilla("container/slot/helmet"),
                Identifier.ofVanilla("container/slot/chestplate"),
                Identifier.ofVanilla("container/slot/leggings"),
                Identifier.ofVanilla("container/slot/boots")
        );
    }

    private static List<Identifier> getAwakenUpgradeEmptyAdditionsSlotTextures() {
        return List.of(Identifier.of("oceanic-plus", "container/slot/prismarine_shard"));
    }

    public static SmithingTemplateItem createAquaticUpgrade(Item.Settings settings) {
        return new SmithingTemplateItem(
                AWAKEN_UPGRADE_APPLIES_TO_TEXT,
                AWAKEN_UPGRADE_INGREDIENTS_TEXT,
                AWAKEN_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
                AWAKEN_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
                getAwakenUpgradeEmptyBaseSlotTextures(),
                getAwakenUpgradeEmptyAdditionsSlotTextures(),
                settings
        );
    }

    public static final Item FROG_HIDE = registerItem("frog_hide", Item::new);

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

    public static final Item BURNT_FROG = registerItem("burnt_frog",
            settings -> new Item(settings.food(ModFoodComponents.BURNT_FROG, ModConsumableComponents.BURNT_FROG)));

    public static final Item AWAKENING_TEMPLATE = registerItem("awakening_template",
            settings -> createAquaticUpgrade(settings));

    public static final Item AWAKENED_TURTLE_HELMET = registerItem("awakened_turtle_helmet",
            setting -> new ModArmorItemButForTags(setting.armor(ArmorMaterials.TURTLE_SCUTE, EquipmentType.HELMET), ArmorMaterials.TURTLE_SCUTE));

    public static final Item AWAKENED_NAUTILUS_CHESTPLATE = registerItem("awakened_nautilus_chestplate",
            setting -> new ModArmorItemButForTags(setting.armor(ModArmorMaterials.NAUTILUS_SHELL_ARMOR_MATERIAL, EquipmentType.CHESTPLATE), ModArmorMaterials.NAUTILUS_SHELL_ARMOR_MATERIAL));

    public static final Item AWAKENED_FROG_BOOTS = registerItem("awakened_frog_boots",
            setting -> new ModArmorItemButForTags(setting.armor(ModArmorMaterials.FROG_HIDE_ARMOR_MATERIAL, EquipmentType.BOOTS), ModArmorMaterials.FROG_HIDE_ARMOR_MATERIAL));

    public static final Item AWAKENED_FROG_LEGGINGS = registerItem("awakened_frog_leggings",
            setting -> new ModArmorItemButForTags(setting.armor(ModArmorMaterials.FROG_HIDE_ARMOR_MATERIAL, EquipmentType.LEGGINGS), ModArmorMaterials.FROG_HIDE_ARMOR_MATERIAL));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {

        return Registry.register(Registries.ITEM, Identifier.of(Oceanicplus.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Oceanicplus.MOD_ID + ":" + name)))));
    }

    public static void registerModItems() {
        Oceanicplus.LOGGER.info("Registering Mod Items for " + Oceanicplus.MOD_ID);
    }
}