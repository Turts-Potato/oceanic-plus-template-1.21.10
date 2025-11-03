package com.turts.oceanics.datagen;

import com.turts.oceanics.item.ModItems;
import com.turts.oceanics.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.AWAKENABLE_ITEMS)
                .add(ModItems.NAUTILUS_CHESTPLATE)
                .add(ModItems.FROG_LEGGINGS)
                .add(ModItems.FROG_BOOTS)
                .add(Items.TURTLE_HELMET);

    }
}
