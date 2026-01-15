package com.turts.oceanics.item;

import com.turts.oceanics.Oceanicplus;
import com.turts.oceanics.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {

    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));

    public static final RegistryKey<EquipmentAsset> FROG_HIDE_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Oceanicplus.MOD_ID, "frog_hide"));
    public static final RegistryKey<EquipmentAsset> AWAKENED_FROG_HIDE_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Oceanicplus.MOD_ID, "awakened_frog_hide"));
    public static final RegistryKey<EquipmentAsset> NAUTILUS_SHELL_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Oceanicplus.MOD_ID, "nautilus_shell"));
    public static final RegistryKey<EquipmentAsset> AWAKENED_NAUTILUS_SHELL_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Oceanicplus.MOD_ID, "awakened_nautilus_shell"));
    public static final RegistryKey<EquipmentAsset> FIX_MOD_ARMOR_ITEM_FOR_ME_THANKS_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Oceanicplus.MOD_ID, "frog_hide"));

    public static final ArmorMaterial FROG_HIDE_ARMOR_MATERIAL = new ArmorMaterial(25, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 1);
        map.put(EquipmentType.LEGGINGS, 4);
        map.put(EquipmentType.CHESTPLATE, 0);
        map.put(EquipmentType.HELMET, 0);
        map.put(EquipmentType.BODY, 4);
    }), 12, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE,0.0F,0.0F, ModTags.Items.FROG_HIDE_REPAIR, FROG_HIDE_KEY);

    public static final ArmorMaterial AWAKENED_FROG_HIDE_ARMOR_MATERIAL = new ArmorMaterial(25, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 1);
        map.put(EquipmentType.LEGGINGS, 4);
        map.put(EquipmentType.CHESTPLATE, 0);
        map.put(EquipmentType.HELMET, 0);
        map.put(EquipmentType.BODY, 4);
    }), 12, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0F, 0.0F, ModTags.Items.FROG_HIDE_REPAIR, AWAKENED_FROG_HIDE_KEY);

    public static final ArmorMaterial NAUTILUS_SHELL_ARMOR_MATERIAL = new ArmorMaterial(43, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 0);
        map.put(EquipmentType.LEGGINGS, 0);
        map.put(EquipmentType.CHESTPLATE, 8);
        map.put(EquipmentType.HELMET, 0);
        map.put(EquipmentType.BODY, 11);
    }), 10, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE,2.0F,0.1F, ModTags.Items.NAUTILUS_SHELL_REPAIR, NAUTILUS_SHELL_KEY);

    public static final ArmorMaterial AWAKENED_NAUTILUS_SHELL_ARMOR_MATERIAL = new ArmorMaterial(43, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 0);
        map.put(EquipmentType.LEGGINGS, 0);
        map.put(EquipmentType.CHESTPLATE, 8);
        map.put(EquipmentType.HELMET, 0);
        map.put(EquipmentType.BODY, 11);
    }), 10, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 2.0F, 0.1F, ModTags.Items.NAUTILUS_SHELL_REPAIR, AWAKENED_NAUTILUS_SHELL_KEY);

    public static final ArmorMaterial FIX_MOD_ARMOR_ITEM_FOR_ME_THANKS_MATERIAL = new ArmorMaterial(43, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 0);
        map.put(EquipmentType.LEGGINGS, 0);
        map.put(EquipmentType.CHESTPLATE, 0);
        map.put(EquipmentType.HELMET, 0);
        map.put(EquipmentType.BODY, 0);
    }), 1, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE,0.0F,0.0F, ModTags.Items.FROG_HIDE_REPAIR, FIX_MOD_ARMOR_ITEM_FOR_ME_THANKS_KEY);

    public static final ArmorMaterial AWAKENED_TURTLE_SCUTE_MATERIAL = new ArmorMaterial(25, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 2);
        map.put(EquipmentType.LEGGINGS, 5);
        map.put(EquipmentType.CHESTPLATE, 6);
        map.put(EquipmentType.HELMET, 2);
        map.put(EquipmentType.BODY, 5);
    }), 9, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE,0.0F,0.0F, ItemTags.REPAIRS_TURTLE_HELMET, AWAKENED_NAUTILUS_SHELL_KEY);
}