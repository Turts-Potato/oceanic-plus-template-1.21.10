package com.turts.oceanics.item.custom;

import com.turts.oceanics.item.ModItems;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

public class ModArmorAttributes {

    private static final Identifier FROG_BOOTS_ID = Identifier.of("oceanic-plus", "frog_boots_water_speed");
    private static final Identifier FROG_LEGGINGS_ID = Identifier.of("oceanic-plus", "frog_leggings_sneak_speed");
    private static final Identifier NAUTILUS_CHESTPLATE_ID = Identifier.of("oceanic-plus", "nautilus_chestplate_oxygen_bonus");
    private static final Identifier TURTLE_HELMET_ID = Identifier.of("minecraft", "turtle_helmet_submerged_mining_speed");

    private static final Identifier AWAKENED_FROG_BOOTS_ID = Identifier.of("oceanic-plus", "awakened_frog_boots_water_speed");
    private static final Identifier AWAKENED_FROG_LEGGINGS_ID = Identifier.of("oceanic-plus", "awakened_frog_leggings_sneak_speed");
    private static final Identifier AWAKENED_NAUTILUS_CHESTPLATE_ID = Identifier.of("oceanic-plus", "awakened_nautilus_chestplate_oxygen_bonus");
    private static final Identifier AWAKENED_TURTLE_HELMET_ID = Identifier.of("minecraft", "awakened_turtle_helmet_submerged_mining_speed");

    public static void registerArmorAttributes() {
        //Note to self: run Server before playtesting when this is edited
        ServerTickEvents.END_WORLD_TICK.register(ModArmorAttributes::onWorldTick);
    }

    private static void onWorldTick(ServerWorld world) {
        for (PlayerEntity player : world.getPlayers()) {
            applyPseudoStrider(player);
            applyPseudoSneak(player);
            applyPseudoRespiration(player);
            applyPseudoAffinity(player);
        }
    }

    private static void applyPseudoStrider(PlayerEntity player) {
        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);

        EntityAttributeInstance inst = player.getAttributeInstance(EntityAttributes.WATER_MOVEMENT_EFFICIENCY);
        if (inst == null) return;

        inst.removeModifier(FROG_BOOTS_ID);
        inst.removeModifier(AWAKENED_FROG_BOOTS_ID);

        if (boots.getItem().equals(ModItems.FROG_BOOTS)) {
            inst.addTemporaryModifier(new EntityAttributeModifier(
                    FROG_BOOTS_ID,
                    0.33333334F,// +0.33333334 water movement efficiency, similar to depth strider 1
                    EntityAttributeModifier.Operation.ADD_VALUE
            ));
        } else if(boots.getItem().equals(ModItems.AWAKENED_FROG_BOOTS)) {
            inst.addTemporaryModifier(new EntityAttributeModifier(
                    AWAKENED_FROG_BOOTS_ID,
                    1.0F,// +1.0 like depth strider 3
                    EntityAttributeModifier.Operation.ADD_VALUE
            ));
        }
    }

    private static void applyPseudoSneak(PlayerEntity player) {
        ItemStack pants = player.getEquippedStack(EquipmentSlot.LEGS);

        EntityAttributeInstance inst = player.getAttributeInstance(EntityAttributes.SNEAKING_SPEED);
        if (inst == null) return;

        inst.removeModifier(FROG_LEGGINGS_ID);
        inst.removeModifier(AWAKENED_FROG_LEGGINGS_ID);

        if (pants.getItem().equals(ModItems.FROG_LEGGINGS)) {
            inst.addTemporaryModifier(new EntityAttributeModifier(
                    FROG_LEGGINGS_ID,
                    0.1F,// +0.1 sneak speed, a bit less than swift sneak 1
                    EntityAttributeModifier.Operation.ADD_VALUE
            ));
        }else if (pants.getItem().equals(ModItems.AWAKENED_FROG_LEGGINGS)) {
            inst.addTemporaryModifier(new EntityAttributeModifier(
                    AWAKENED_FROG_LEGGINGS_ID,
                    0.2F,
                    EntityAttributeModifier.Operation.ADD_VALUE
            ));
        }
    }

    private static void applyPseudoRespiration(PlayerEntity player) {
        ItemStack shirt = player.getEquippedStack(EquipmentSlot.CHEST);

        EntityAttributeInstance inst = player.getAttributeInstance(EntityAttributes.OXYGEN_BONUS);
        if (inst == null) return;

        inst.removeModifier(NAUTILUS_CHESTPLATE_ID);
        inst.removeModifier(AWAKENED_NAUTILUS_CHESTPLATE_ID);

        if (shirt.getItem().equals(ModItems.NAUTILUS_CHESTPLATE)) {
            inst.addTemporaryModifier(new EntityAttributeModifier(
                    NAUTILUS_CHESTPLATE_ID,
                    1.0F,// +1.0 oxygen, similar to respiration 1
                    EntityAttributeModifier.Operation.ADD_VALUE
            ));
        }else if(shirt.getItem().equals(ModItems.AWAKENED_NAUTILUS_CHESTPLATE)) {
            inst.addTemporaryModifier(new EntityAttributeModifier(
                    AWAKENED_NAUTILUS_CHESTPLATE_ID,
                    2.0F,
                    EntityAttributeModifier.Operation.ADD_VALUE
            ));
        }
    }

    private static void applyPseudoAffinity(PlayerEntity player) {
        ItemStack hat = player.getEquippedStack(EquipmentSlot.HEAD);

        EntityAttributeInstance inst = player.getAttributeInstance(EntityAttributes.SUBMERGED_MINING_SPEED);
        if (inst == null) return;

        inst.removeModifier(TURTLE_HELMET_ID);
        inst.removeModifier(AWAKENED_TURTLE_HELMET_ID);

        if (hat.getItem().equals(Items.TURTLE_HELMET)) {
            inst.addTemporaryModifier(new EntityAttributeModifier(
                    TURTLE_HELMET_ID,
                    2.0F,// +2.0 submerged mining speed, similar to aqua affinity
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
            ));
        }else if (hat.getItem().equals(ModItems.AWAKENED_TURTLE_HELMET)) {
            inst.addTemporaryModifier(new EntityAttributeModifier(
                    AWAKENED_TURTLE_HELMET_ID,
                    4.0F,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
            ));
        }
    }
}