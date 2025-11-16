package com.turts.oceanics.datagen;

import com.turts.oceanics.block.ModBlocks;
import com.turts.oceanics.item.ModArmorMaterials;
import com.turts.oceanics.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.item.equipment.EquipmentAsset;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLACEHOLDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLACEHOLDERSPEC);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FROG_HIDE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BURNT_FROG, Models.GENERATED);
        itemModelGenerator.register(ModItems.AWAKENING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AWAKENED_TURTLE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.AWAKENED_NAUTILUS_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AWAKENED_FROG_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.AWAKENED_FROG_BOOTS, Models.GENERATED);

        itemModelGenerator.registerArmor(ModItems.FROG_LEGGINGS, ModArmorMaterials.FROG_HIDE_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.FROG_BOOTS, ModArmorMaterials.FROG_HIDE_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.NAUTILUS_CHESTPLATE, ModArmorMaterials.NAUTILUS_SHELL_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.FROG_CHESTPLATE, ModArmorMaterials.FROG_HIDE_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.FROG_HAT, ModArmorMaterials.FROG_HIDE_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
    }
}
