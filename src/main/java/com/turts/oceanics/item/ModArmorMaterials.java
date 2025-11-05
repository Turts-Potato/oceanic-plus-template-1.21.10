package com.turts.oceanics.item;

import com.turts.oceanics.Oceanicplus;
import com.turts.oceanics.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {

    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));

    public static final RegistryKey<EquipmentAsset> FROG_HIDE_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Oceanicplus.MOD_ID, "frog_hide"));

    public static final ArmorMaterial FROG_HIDE_ARMOR_MATERIAL = new ArmorMaterial(500, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 1);
        map.put(EquipmentType.LEGGINGS, 4);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE,0,0, ModTags.Items.FROG_HIDE_REPAIR, FROG_HIDE_KEY);

    public static final RegistryKey<EquipmentAsset> NAUTILUS_SHELL_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.ofVanilla("nautilus_shell"));

    public static final ArmorMaterial NAUTILUS_SHELL_ARMOR_MATERIAL = new ArmorMaterial(500, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.CHESTPLATE, 8);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE,0,0, ModTags.Items.NAUTILUS_SHELL_REPAIR, NAUTILUS_SHELL_KEY);



}