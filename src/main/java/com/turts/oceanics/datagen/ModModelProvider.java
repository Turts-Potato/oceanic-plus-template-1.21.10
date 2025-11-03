package com.turts.oceanics.datagen;

import com.turts.oceanics.block.ModBlocks;
import com.turts.oceanics.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

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
        itemModelGenerator.register(ModItems.FROG_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROG_BOOTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROG_HIDE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NAUTILUS_CHESTPLATE, Models.GENERATED);
    }
}
