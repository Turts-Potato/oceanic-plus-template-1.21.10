package com.turts.oceanics;

import com.turts.oceanics.block.ModBlocks;
import com.turts.oceanics.item.custom.ModAmorAttributes;
import com.turts.oceanics.item.ModItemGroups;
import com.turts.oceanics.item.ModItems;
import com.turts.oceanics.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Oceanicplus implements ModInitializer {
	public static final String MOD_ID = "oceanic-plus";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModAmorAttributes.register();

        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.isOf(ModBlocks.PLACEHOLDERSPEC.asItem())) {
                    list.add(Text.translatable("tooltip.oceanic-plus.placeholder_spec"));
            }

            if (itemStack.isOf(ModItems.FROG_CHESTPLATE.asItem())){
                list.add(Text.translatable("tooltip.oceanic-plus.frog_chestplate"));
            }

            if (itemStack.isOf(ModItems.FROG_HAT.asItem())){
                list.add(Text.translatable("tooltip.oceanic-plus.frog_hat"));
            }
        });

        ModLootTableModifiers.modifyLootTables();

	}
}