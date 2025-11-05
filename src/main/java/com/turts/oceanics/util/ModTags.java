package com.turts.oceanics.util;

import com.turts.oceanics.Oceanicplus;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Oceanicplus.MOD_ID, name));
        }
    }

        public static class Items {

            public static final TagKey<Item> AWAKENABLE_ITEMS = createTag("awakenable_items");
            public static final TagKey<Item> FROG_HIDE_REPAIR = createTag("frog_hide_repair");
            public static final TagKey<Item> NAUTILUS_SHELL_REPAIR = createTag("nautilus_shell_repair");

            private static TagKey<Item> createTag(String name) {
                return TagKey.of(RegistryKeys.ITEM, Identifier.of(Oceanicplus.MOD_ID, name));



        }
    }

}
