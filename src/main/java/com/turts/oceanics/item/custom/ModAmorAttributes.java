package com.turts.oceanics.item.custom;

import com.turts.oceanics.item.ModItems;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import static net.minecraft.entity.attribute.EntityAttributes.WATER_MOVEMENT_EFFICIENCY;

public class ModAmorAttributes {

    private static boolean wear = false;
    public static void register() {
        ClientTickEvents.END_WORLD_TICK.register(ModAmorAttributes::onPlayerTick);
    }

    private static void onPlayerTick(ClientWorld world) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) return;
        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
        double defaultSpeed = player.getAttributeInstance(WATER_MOVEMENT_EFFICIENCY).getValue();
        float speedIncrease = 0.03F; // + 0.03 speed in water

        if (boots.getItem() == ModItems.FROG_BOOTS && player.isTouchingWater()) {
            //Sets player movement speed to the increased value when in water

            wear = true;

            player.getAttributeInstance(WATER_MOVEMENT_EFFICIENCY).setBaseValue(defaultSpeed + speedIncrease);

        }else {
            // Reset the speed to default when not in water or not wearing the boots
            if (wear){
            player.getAttributeInstance(WATER_MOVEMENT_EFFICIENCY).setBaseValue(defaultSpeed - speedIncrease);

            }else{
            player.getAttributeInstance(WATER_MOVEMENT_EFFICIENCY).setBaseValue(defaultSpeed);
            }
        }
    }
}