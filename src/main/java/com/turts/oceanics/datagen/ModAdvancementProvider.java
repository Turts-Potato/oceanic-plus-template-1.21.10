package com.turts.oceanics.datagen;
import com.turts.oceanics.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import net.minecraft.advancement.criterion.InventoryChangedCriterion;
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
                        Text.literal("Got your first pair of frog boots!"),
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
                        Text.literal("Got your first pair of frog pants!"),
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
                        Text.literal("Got your first pair of frog vanity!"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_frog_vpiece", InventoryChangedCriterion.Conditions.items(ModItems.FROG_CHESTPLATE, ModItems.FROG_HAT))
                .build(consumer, "oceanic-plus" + "/got_frog_vpiece");





        AdvancementEntry equippedFullFrogSet = Advancement.Builder.create().parent(gotFrogVpiece)
                .display(
                        ModItems.FROG_HAT,
                        Text.literal("Frog Suit"),
                        Text.literal("Equipped a full frog set!"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion("got_frog_full", InventoryChangedCriterion.Conditions.items
                        (ModItems.FROG_BOOTS, ModItems.FROG_LEGGINGS, ModItems.FROG_CHESTPLATE, ModItems.FROG_HAT))
                .build(consumer, "oceanic-plus" + "/got_frog_full");
    }
    //shoutouts fabric wiki :)
}