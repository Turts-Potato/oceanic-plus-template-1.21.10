package com.turts.oceanics.datagen;
import com.turts.oceanics.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
public class ModAdvancementProvider extends FabricAdvancementProvider {

    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }


    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry rootAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.FROG_HIDE, // The display icon
                        Text.literal("Oceanics"), // The title
                        Text.literal("The start of your aquatic journey"), // The description
                        //Redirect background to the mod's texture instead of the vanilla one
                        Identifier.of("oceanic-plus", "gui/advancements/backgrounds/oceanics"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("got_frog_hide", InventoryChangedCriterion.Conditions.items(ModItems.FROG_HIDE))
                .build(consumer, "oceanic-plus" + "/root");


        AdvancementEntry gotFrogBoots = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.FROG_BOOTS,
                        Text.literal("Frog Feet"),
                        Text.literal("Acquired a pair of Frog Boots"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1000))
                .criterion("got_frog_boots", InventoryChangedCriterion.Conditions.items(ModItems.FROG_BOOTS))
                .build(consumer, "oceanic-plus" + "/got_frog_boots");


        AdvancementEntry gotFrogLeggings = Advancement.Builder.create().parent(gotFrogBoots)
                .display(
                        ModItems.FROG_LEGGINGS,
                        Text.literal("Frog Legs"),
                        Text.literal("Acquired a pair of Frog Leggings"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_frog_leggings", InventoryChangedCriterion.Conditions.items(ModItems.FROG_LEGGINGS))
                .build(consumer, "oceanic-plus" + "/got_frog_leggings");


        AdvancementEntry gotFrogVpiece = Advancement.Builder.create().parent(gotFrogLeggings)
                .display(
                        ModItems.FROG_CHESTPLATE,
                        Text.literal("Frog Vanity"),
                        Text.literal("Acquired a piece of frog vanity"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR)
                .criterion("got_frog_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.FROG_CHESTPLATE))
                .criterion("got_frog_hat", InventoryChangedCriterion.Conditions.items(ModItems.FROG_HAT))
                .build(consumer, "oceanic-plus" + "/got_frog_vpiece");


        AdvancementEntry gotFullFrogSet = Advancement.Builder.create().parent(gotFrogVpiece)
                .display(
                        ModItems.FROG_HAT,
                        Text.literal("Frog Suit"),
                        Text.literal("Acquired a full Frog set"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion("got_frog_full", InventoryChangedCriterion.Conditions.items
                        (ModItems.FROG_BOOTS, ModItems.FROG_LEGGINGS, ModItems.FROG_CHESTPLATE, ModItems.FROG_HAT))
                .build(consumer, "oceanic-plus" + "/got_frog_full");


        AdvancementEntry gotNautilusChestplate = Advancement.Builder.create().parent(gotFrogLeggings)
                .display(
                        ModItems.NAUTILUS_CHESTPLATE,
                        Text.literal("Nautilus Chestplate"),
                        Text.literal("Acquired a Nautilus Chestplate"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_nautilus_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.NAUTILUS_CHESTPLATE))
                .build(consumer, "oceanic-plus" + "/got_nautilus_chestplate");


        AdvancementEntry gotFullAquatic = Advancement.Builder.create().parent(gotNautilusChestplate)
                .display(
                        Items.TURTLE_HELMET,
                        Text.literal("Aquatic Set"),
                        Text.literal("Acquired a full Aquatic set"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR)
                .criterion("got_aquatic_full", InventoryChangedCriterion.Conditions.items
                        (ModItems.FROG_BOOTS, ModItems.FROG_LEGGINGS, ModItems.NAUTILUS_CHESTPLATE, Items.TURTLE_HELMET))
                .criterion("got_aquatic_awakened_full", InventoryChangedCriterion.Conditions.items
                        (ModItems.AWAKENED_FROG_BOOTS, ModItems.AWAKENED_FROG_LEGGINGS, ModItems.AWAKENED_NAUTILUS_CHESTPLATE, ModItems.AWAKENED_TURTLE_HELMET))
                .build(consumer, "oceanic-plus" + "/got_aquatic_full");


        AdvancementEntry gotFullAquaticAwakened = Advancement.Builder.create().parent(gotFullAquatic)
                .display(
                        ModItems.AWAKENED_TURTLE_HELMET,
                        Text.literal("Awakened Aquatic Set"),
                        Text.literal("Acquired a full Awakened Aquatic set"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion("got_aquatic_awakened_full", InventoryChangedCriterion.Conditions.items
                        (ModItems.AWAKENED_FROG_BOOTS, ModItems.AWAKENED_FROG_LEGGINGS, ModItems.AWAKENED_NAUTILUS_CHESTPLATE, ModItems.AWAKENED_TURTLE_HELMET))
                .build(consumer, "oceanic-plus" + "/got_aquatic_awakened_full");


        AdvancementEntry ateBurntFrog = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.BURNT_FROG,
                        Text.literal("Burn Frog"),
                        Text.literal("You probably shouldn't eat that"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_burn_frog", InventoryChangedCriterion.Conditions.items(ModItems.BURNT_FROG))
                .build(consumer, "oceanic-plus" + "/got_burn_frog");





























    }
    //shoutouts fabric wiki :)
}