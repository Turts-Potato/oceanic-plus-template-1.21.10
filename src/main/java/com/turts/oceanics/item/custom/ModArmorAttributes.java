package com.turts.oceanics.item.custom;

import com.turts.oceanics.item.ModItems;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;


import static net.minecraft.entity.attribute.EntityAttributes.SNEAKING_SPEED;
import static net.minecraft.entity.attribute.EntityAttributes.WATER_MOVEMENT_EFFICIENCY;

public class ModArmorAttributes {

    private static boolean wearingB = false;
    private static boolean wearingL = false;

    public static void register() {
        ClientTickEvents.END_WORLD_TICK.register(ModArmorAttributes::onPlayerTick);
    }

    private static void onPlayerTick(ClientWorld world) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) return;
        activatePseudoStrider(player);
        activatePseudoSneak(player);
    }


    private static void activatePseudoStrider(PlayerEntity player) {
        final float speedIncrease = 0.33333334F; // + 0.33333334 speed in water, like depth strider 1
        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
        double currentSpeed = player.getAttributeInstance(WATER_MOVEMENT_EFFICIENCY).getValue();
        //System.out.println(currentSpeed);

        if (boots.getItem().equals(ModItems.FROG_BOOTS)) {
            //Sets player movement speed to the increased value when wearing
            if(!wearingB) {
                player.getAttributeInstance(WATER_MOVEMENT_EFFICIENCY).setBaseValue(currentSpeed + speedIncrease);
                wearingB = true;
            }
        }else {
            // Reset the speed to default when not wearing the boots
            if(wearingB) {
                player.getAttributeInstance(WATER_MOVEMENT_EFFICIENCY).setBaseValue(currentSpeed - speedIncrease);
                wearingB = false;
            }
        }
    }

    private static void activatePseudoSneak(PlayerEntity player) {
        final float speedIncrease = 0.45F; // + 0.15 crouching speed, like swift sneak 1
        ItemStack pants = player.getEquippedStack(EquipmentSlot.LEGS);
        double currentSpeed = player.getAttributeInstance(SNEAKING_SPEED).getValue();
        System.out.println(currentSpeed);

        if (pants.getItem().equals(ModItems.FROG_LEGGINGS)) {
            //Sets player movement speed to the increased value when wearing
            if(!wearingL) {
                player.getAttributeInstance(SNEAKING_SPEED).setBaseValue(currentSpeed + speedIncrease);
                wearingL = true;
            }
        }else {
            // Reset the speed to default when not wearing the leggings
            if(wearingL) {
                player.getAttributeInstance(SNEAKING_SPEED).setBaseValue(currentSpeed - speedIncrease);
                wearingL = false;
            }
        }
    }
}