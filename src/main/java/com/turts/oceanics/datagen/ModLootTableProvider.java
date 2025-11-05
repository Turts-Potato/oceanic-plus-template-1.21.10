package com.turts.oceanics.datagen;

import com.turts.oceanics.block.ModBlocks;
import com.turts.oceanics.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
    addDrop(ModBlocks.PLACEHOLDER);
    addDrop(ModBlocks.PLACEHOLDERSPEC);
    addDrop(Blocks.TURTLE_EGG);
    //addDrop(Blocks.PEARLESCENT_FROGLIGHT, dropsWithShears(Blocks.GLOWSTONE));
    //addDrop(Blocks.PEARLESCENT_FROGLIGHT, dropsWithShears(ModItems.FROG_HIDE));
    //MAKE THE BLOCK DROP 1 GLOWSTONE 8 FROG HIDE ^^^^ ALSO APPLY TO ALL FROGLIGHTS
    }
}
