package com.turts.oceanics.datagen;

import com.turts.oceanics.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {

                createShaped(RecipeCategory.COMBAT, ModItems.FROG_BOOTS, 1)
                        .pattern("X X")
                        .pattern("X X")
                        .input('X', ModItems.FROG_HIDE)
                        .criterion(hasItem(ModItems.FROG_BOOTS), conditionsFromItem(ModItems.FROG_BOOTS))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.FROG_LEGGINGS, 1)
                        .pattern("XXX")
                        .pattern("X X")
                        .pattern("X X")
                        .input('X', ModItems.FROG_HIDE)
                        .criterion(hasItem(ModItems.FROG_LEGGINGS), conditionsFromItem(ModItems.FROG_LEGGINGS))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.NAUTILUS_CHESTPLATE, 1)
                        .pattern("X X")
                        .pattern("XXX")
                        .pattern("XXX")
                        .input('X', Items.NAUTILUS_SHELL)
                        .criterion(hasItem(ModItems.NAUTILUS_CHESTPLATE), conditionsFromItem(ModItems.NAUTILUS_CHESTPLATE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.FROG_CHESTPLATE, 1)
                        .pattern("X X")
                        .pattern("XXX")
                        .pattern("XXX")
                        .input('X', ModItems.FROG_HIDE)
                        .criterion(hasItem(ModItems.FROG_CHESTPLATE), conditionsFromItem(ModItems.FROG_CHESTPLATE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.FROG_HAT, 1)
                        .pattern("XXX")
                        .pattern("X X")
                        .input('X', ModItems.FROG_HIDE)
                        .criterion(hasItem(ModItems.FROG_HAT), conditionsFromItem(ModItems.FROG_HAT))
                        .offerTo(exporter);

                /*MAKE FROG HIDE ALTS CRAFT DIFFERENT FROGLIGHTS

                createShaped(RecipeCategory.DECORATIONS, Items.PEARLESCENT_FROGLIGHT, 1)
                        .pattern("XXX")
                        .pattern("X#X")
                        .pattern("XXX")
                        .input('X', ModItems.FROG_HIDE)
                        .input('#', Items.GLOWSTONE)
                        .criterion(hasItem(Items.PEARLESCENT_FROGLIGHT), conditionsFromItem(Items.PEARLESCENT_FROGLIGHT))
                        .offerTo(exporter);
                */
            }
        };
    }

    @Override
    public String getName() {
        return "Oceanic Recipes";
    }
}
