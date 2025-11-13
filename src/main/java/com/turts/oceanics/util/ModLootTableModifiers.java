package com.turts.oceanics.util;

import com.turts.oceanics.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier PEARLESCENT_FROGLIGHT_BLOCK_ID
            = Identifier.of("minecraft", "blocks/pearlescent_froglight");

    private static final Identifier OCHRE_FROGLIGHT_BLOCK_ID
            = Identifier.of("minecraft", "blocks/ochre_froglight");

    private static final Identifier VERDANT_FROGLIGHT_BLOCK_ID
            = Identifier.of("minecraft", "blocks/verdant_froglight");

    private static final Identifier FROG_ID
            = Identifier.of("minecraft", "entities/frog");

    private static final Identifier TURTLE_ID
            = Identifier.of("minecraft", "entities/turtle");

    private static final Identifier DROWNED_ID
            = Identifier.of("minecraft", "entities/drowned");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
            if(PEARLESCENT_FROGLIGHT_BLOCK_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.FROG_HIDE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8f, 8f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(OCHRE_FROGLIGHT_BLOCK_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.FROG_HIDE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8f, 8f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(VERDANT_FROGLIGHT_BLOCK_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.FROG_HIDE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8f, 8f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(FROG_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.65f)) // Drops 65% of the time
                        .with(ItemEntry.builder(ModItems.FROG_HIDE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(TURTLE_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.55f)) // Drops 55% of the time
                        .with(ItemEntry.builder(Items.TURTLE_SCUTE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(DROWNED_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // Drops 5% of the time
                        .with(ItemEntry.builder(Items.NAUTILUS_SHELL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}