package com.turts.oceanics.datagen;

import com.turts.oceanics.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
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

                List<ItemConvertible> OCEANICS_SMELTABLE_FROG = List.of(ModItems.FROG_BOOTS, ModItems.FROG_LEGGINGS,
                        ModItems.FROG_CHESTPLATE, ModItems.FROG_HAT, ModItems.FROG_HIDE);

                offerSmelting(OCEANICS_SMELTABLE_FROG, RecipeCategory.FOOD, ModItems.BURNT_FROG, 0.25F ,200,"burnt_frog");

                createShapeless(RecipeCategory.MISC, ModItems.FROG_HIDE, 1)
                        .input(Items.RABBIT_HIDE)
                        .input(Items.SLIME_BALL)
                        .criterion(hasItem(ModItems.FROG_HIDE), conditionsFromItem(ModItems.FROG_HIDE))
                        .offerTo(exporter);


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

                createShaped(RecipeCategory.MISC, ModItems.AWAKENING_TEMPLATE, 2)
                        .pattern("X#X")
                        .pattern("X$X")
                        .pattern("XXX")
                        .input('X', Items.DIAMOND)
                        .input('#', ModItems.AWAKENING_TEMPLATE)
                        .input('$', Items.DARK_PRISMARINE)
                        .criterion(hasItem(ModItems.AWAKENING_TEMPLATE), conditionsFromItem(ModItems.AWAKENING_TEMPLATE))
                        .offerTo(exporter);

                SmithingTransformRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.AWAKENING_TEMPLATE),
                                Ingredient.ofItems(Items.TURTLE_HELMET),
                                Ingredient.ofItems(Items.PRISMARINE_SHARD),
                                RecipeCategory.COMBAT,
                                ModItems.AWAKENED_TURTLE_HELMET)
                        .criterion(hasItem(ModItems.AWAKENING_TEMPLATE), conditionsFromItem(ModItems.AWAKENING_TEMPLATE))
                        .offerTo(exporter, "oceanic-plus:turtle_awaken");

                SmithingTransformRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.AWAKENING_TEMPLATE),
                                Ingredient.ofItems(ModItems.NAUTILUS_CHESTPLATE),
                                Ingredient.ofItems(Items.PRISMARINE_SHARD),
                                RecipeCategory.COMBAT,
                                ModItems.AWAKENED_NAUTILUS_CHESTPLATE)
                        .criterion(hasItem(ModItems.AWAKENING_TEMPLATE), conditionsFromItem(ModItems.AWAKENING_TEMPLATE))
                        .offerTo(exporter, "oceanic-plus:nautilus_awaken");

                SmithingTransformRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.AWAKENING_TEMPLATE),
                                Ingredient.ofItems(ModItems.FROG_LEGGINGS),
                                Ingredient.ofItems(Items.PRISMARINE_SHARD),
                                RecipeCategory.COMBAT,
                                ModItems.AWAKENED_FROG_LEGGINGS)
                        .criterion(hasItem(ModItems.AWAKENING_TEMPLATE), conditionsFromItem(ModItems.AWAKENING_TEMPLATE))
                        .offerTo(exporter, "oceanic-plus:frog_leggings_awaken");

                SmithingTransformRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.AWAKENING_TEMPLATE),
                                Ingredient.ofItems(ModItems.FROG_BOOTS),
                                Ingredient.ofItems(Items.PRISMARINE_SHARD),
                                RecipeCategory.COMBAT,
                                ModItems.AWAKENED_FROG_BOOTS)
                        .criterion(hasItem(ModItems.AWAKENING_TEMPLATE), conditionsFromItem(ModItems.AWAKENING_TEMPLATE))
                        .offerTo(exporter, "oceanic-plus:frog_boots_awaken");


                createShaped(RecipeCategory.DECORATIONS, Items.PEARLESCENT_FROGLIGHT, 1)
                        .pattern("$X$")
                        .pattern("X#X")
                        .pattern("$X$")
                        .input('X', ModItems.FROG_HIDE)
                        .input('#', Items.GLOWSTONE)
                        .input('$', Items.PURPLE_DYE)
                        .criterion(hasItem(Items.PEARLESCENT_FROGLIGHT), conditionsFromItem(Items.PEARLESCENT_FROGLIGHT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.DECORATIONS, Items.VERDANT_FROGLIGHT, 1)
                        .pattern("$X$")
                        .pattern("X#X")
                        .pattern("$X$")
                        .input('X', ModItems.FROG_HIDE)
                        .input('#', Items.GLOWSTONE)
                        .input('$', Items.GREEN_DYE)
                        .criterion(hasItem(Items.VERDANT_FROGLIGHT), conditionsFromItem(Items.VERDANT_FROGLIGHT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.DECORATIONS, Items.OCHRE_FROGLIGHT, 1)
                        .pattern("$X$")
                        .pattern("X#X")
                        .pattern("$X$")
                        .input('X', ModItems.FROG_HIDE)
                        .input('#', Items.GLOWSTONE)
                        .input('$', Items.YELLOW_DYE)
                        .criterion(hasItem(Items.OCHRE_FROGLIGHT), conditionsFromItem(Items.OCHRE_FROGLIGHT))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Oceanic Recipes";
    }
}
