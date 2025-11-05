package com.turts.oceanics.block;

import com.turts.oceanics.Oceanicplus;
import com.turts.oceanics.block.custom.PlaceholderSpec;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block PLACEHOLDER = registerBlock("placeholder_rn",
            AbstractBlock.Settings.create().strength(2.0F).sounds(BlockSoundGroup.AMETHYST_BLOCK));

    public static final Block PLACEHOLDERSPEC = registerSpecialBlock("placeholder_spec",
          AbstractBlock.Settings.create().strength(2.0F).sounds(BlockSoundGroup.BONE));


    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Oceanicplus.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }


    private static Block registerSpecialBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Oceanicplus.MOD_ID, name));
        Block block = new PlaceholderSpec(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Oceanicplus.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks(){
        Oceanicplus.LOGGER.info("Registering Mod Blocks for " + Oceanicplus.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register(entries -> {
                    entries.add(ModBlocks.PLACEHOLDER);
                    entries.add(ModBlocks.PLACEHOLDERSPEC);
        });
    }
}

