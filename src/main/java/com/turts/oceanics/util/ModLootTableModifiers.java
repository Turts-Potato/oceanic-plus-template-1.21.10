package com.turts.oceanics.util;

import com.turts.oceanics.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.InvertedLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKeys;
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

    private static final Identifier ELDER_GUARDIAN_ID
            = Identifier.of("minecraft", "entities/elder_guardian");



//------------------------------------FROGLIGHTS------------------------------------
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {

            var shearsUsed = MatchToolLootCondition.builder(
                    ItemPredicate.Builder.create().items
                            (registry.getOrThrow(RegistryKeys.ITEM), Items.SHEARS));

            if(PEARLESCENT_FROGLIGHT_BLOCK_ID.equals(key.getValue())) {

                tableBuilder.modifyPools(pool -> {
                    pool.conditionally(InvertedLootCondition.builder(shearsUsed));
                });

                LootPool.Builder hidePool = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1.0F))
                            .conditionally(shearsUsed)
                            .with(ItemEntry.builder(ModItems.FROG_HIDE))
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4F)).build());

                LootPool.Builder glowstonePool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(shearsUsed)
                        .with(ItemEntry.builder(Items.GLOWSTONE))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1F)).build());


                    tableBuilder.pool(hidePool.build());
                    tableBuilder.pool(glowstonePool.build());
            }

            if(OCHRE_FROGLIGHT_BLOCK_ID.equals(key.getValue())) {
                tableBuilder.modifyPools(pool -> {
                    pool.conditionally(InvertedLootCondition.builder(shearsUsed));
                });

                LootPool.Builder hidePool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(shearsUsed)
                        .with(ItemEntry.builder(ModItems.FROG_HIDE))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4F)).build());

                LootPool.Builder glowstonePool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(shearsUsed)
                        .with(ItemEntry.builder(Items.GLOWSTONE))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1F)).build());


                tableBuilder.pool(hidePool.build());
                tableBuilder.pool(glowstonePool.build());
            }

            if(VERDANT_FROGLIGHT_BLOCK_ID.equals(key.getValue())) {
                tableBuilder.modifyPools(pool -> {
                    pool.conditionally(InvertedLootCondition.builder(shearsUsed));
                });

                LootPool.Builder hidePool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(shearsUsed)
                        .with(ItemEntry.builder(ModItems.FROG_HIDE))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4F)).build());

                LootPool.Builder glowstonePool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(shearsUsed)
                        .with(ItemEntry.builder(Items.GLOWSTONE))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1F)).build());


                tableBuilder.pool(hidePool.build());
                tableBuilder.pool(glowstonePool.build());
            }
//------------------------------------MOBS------------------------------------
            if(FROG_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(RandomChanceLootCondition.builder(0.65F)) // Drops 65% of the time
                        .with(ItemEntry.builder(ModItems.FROG_HIDE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(TURTLE_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(RandomChanceLootCondition.builder(0.55F)) // Drops 55% of the time
                        .with(ItemEntry.builder(Items.TURTLE_SCUTE))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(DROWNED_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(RandomChanceLootCondition.builder(0.2F)) // Drops 20% of the time
                        .with(ItemEntry.builder(Items.NAUTILUS_SHELL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(ELDER_GUARDIAN_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(ModItems.AWAKENING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)).build());

                tableBuilder.pool(poolBuilder.build());
            }
    //------------------------------------STRUCTURES------------------------------------
            if(LootTables.SHIPWRECK_SUPPLY_CHEST.equals(key)) {
                tableBuilder.modifyPools(pool -> { pool
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(ModItems.FROG_CHESTPLATE).weight(3))
                        .with(ItemEntry.builder(ModItems.FROG_HAT).weight(3));

                });
            }

            if(LootTables.UNDERWATER_RUIN_SMALL_CHEST.equals(key)) {
                tableBuilder.modifyPools(pool -> { pool
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(ModItems.FROG_CHESTPLATE))
                        .with(ItemEntry.builder(ModItems.FROG_HAT));

                });
            }

            if(LootTables.UNDERWATER_RUIN_BIG_CHEST.equals(key)) {
                tableBuilder.modifyPools(pool -> { pool
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(ModItems.FROG_CHESTPLATE))
                        .with(ItemEntry.builder(ModItems.FROG_HAT));

                });
            }

            if(LootTables.VILLAGE_TANNERY_CHEST.equals(key)) {
                tableBuilder.modifyPools(pool -> { pool
                        .with(ItemEntry.builder(ModItems.FROG_HIDE).weight(1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)).build())
                        .with(ItemEntry.builder(ModItems.FROG_CHESTPLATE).weight(2))
                        .with(ItemEntry.builder(ModItems.FROG_HAT).weight(2));


                });
            }

            if(LootTables.VILLAGE_FISHER_CHEST.equals(key)) {
                tableBuilder.modifyPools(pool -> { pool
                        .with(ItemEntry.builder(ModItems.FROG_HIDE).weight(1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)).build());

                });
            }
//------------------------------------MISC------------------------------------
            if(LootTables.CAT_MORNING_GIFT_GAMEPLAY.equals(key)) {
                tableBuilder.modifyPools(pool -> { pool
                            .with(ItemEntry.builder(ModItems.FROG_HIDE).weight(10));
                });
            }

            if(LootTables.FISHING_JUNK_GAMEPLAY.equals(key)) {
                tableBuilder.modifyPools(pool -> { pool
                        .with(ItemEntry.builder(ModItems.FROG_HIDE).weight(10));
                });
            }
        });
    }
}