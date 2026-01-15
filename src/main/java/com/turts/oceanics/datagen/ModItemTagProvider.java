package com.turts.oceanics.datagen;

import com.turts.oceanics.item.ModItems;
import com.turts.oceanics.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.AWAKENED_ITEMS)
                .add(ModItems.AWAKENED_FROG_BOOTS)
                .add(ModItems.AWAKENED_FROG_LEGGINGS)
                .add(ModItems.AWAKENED_NAUTILUS_CHESTPLATE)
                .add(ModItems.AWAKENED_TURTLE_HELMET);

        valueLookupBuilder(ModTags.Items.FROG_HIDE_REPAIR)
                .add(ModItems.FROG_HIDE);

        valueLookupBuilder(ModTags.Items.NAUTILUS_SHELL_REPAIR)
                .add(Items.NAUTILUS_SHELL);

        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.AWAKENED_TURTLE_HELMET);

        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.NAUTILUS_CHESTPLATE)
                .add(ModItems.AWAKENED_NAUTILUS_CHESTPLATE);

        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.FROG_LEGGINGS)
                .add(ModItems.AWAKENED_FROG_LEGGINGS);

        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.FROG_BOOTS)
                .add(ModItems.AWAKENED_FROG_BOOTS);

        valueLookupBuilder(ItemTags.FREEZE_IMMUNE_WEARABLES)
                .add(ModItems.FROG_BOOTS)
                .add(ModItems.AWAKENED_FROG_BOOTS)
                .add(ModItems.FROG_LEGGINGS)
                .add(ModItems.AWAKENED_FROG_LEGGINGS);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.FROG_HAT)
                .add(ModItems.FROG_CHESTPLATE);

        valueLookupBuilder(ItemTags.MEAT)
                .add(ModItems.BURNT_FROG);

        valueLookupBuilder(ItemTags.WOLF_FOOD)
                .add(ModItems.BURNT_FROG);

        valueLookupBuilder(ItemTags.CAT_FOOD)
                .add(ModItems.BURNT_FROG);
    }
}
