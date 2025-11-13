package com.turts.oceanics;

import com.turts.oceanics.block.ModBlocks;
import com.turts.oceanics.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

public class OceanicplusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
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

            if (itemStack.isOf(ModItems.FROG_BOOTS.asItem())){
                list.add(Text.translatable("tooltip.oceanic-plus.frog_boots"));
            }

            if (itemStack.isOf(ModItems.FROG_LEGGINGS.asItem())){
                list.add(Text.translatable("tooltip.oceanic-plus.frog_leggings"));
            }

            if (itemStack.isOf(ModItems.NAUTILUS_CHESTPLATE.asItem())){
                list.add(Text.translatable("tooltip.oceanic-plus.nautilus_chestplate"));
            }

            if (itemStack.isOf(Items.TURTLE_HELMET.asItem())){
                list.add(Text.translatable("tooltip.minecraft.turtle_helmet"));
            }
        });
    }
}
