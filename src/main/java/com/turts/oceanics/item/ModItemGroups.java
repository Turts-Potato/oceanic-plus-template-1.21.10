package com.turts.oceanics.item;

import com.turts.oceanics.Oceanicplus;
import com.turts.oceanics.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup OCEANIC_PLUS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Oceanicplus.MOD_ID, "oceanic-plus_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.FROG_HIDE))
                    .displayName(Text.translatable("itemgroup.oceanic-plus.oceanics_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.NAUTILUS_CHESTPLATE);
                        entries.add(ModItems.FROG_LEGGINGS);
                        entries.add(ModItems.FROG_BOOTS);
                        entries.add(ModItems.FROG_HIDE);
                        entries.add(ModItems.FROG_HAT);
                        entries.add(ModItems.FROG_CHESTPLATE);
                        entries.add(ModItems.BURNT_FROG_LEGS);
                        entries.add(ModItems.BURNT_FROG_FEET);
                        entries.add(ModBlocks.PLACEHOLDER);
                        entries.add(ModBlocks.PLACEHOLDERSPEC);
                    }).build());
    public static void registerItemGroups(){
        Oceanicplus.LOGGER.info("Registering Item Groups for " + Oceanicplus.MOD_ID);
    }
}
