package com.turts.oceanics.item.custom;

import com.google.common.collect.ImmutableMap;
import com.turts.oceanics.item.ModArmorMaterials;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.Map;

public class ModArmorItem extends Item {
    private final ArmorMaterial material;


    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.FROG_HIDE_ARMOR_MATERIAL,
                            List.of(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1, 0, false, false, true))).build();

    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP_UP =
            (new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.FROG_HIDE_ARMOR_MATERIAL,
                            List.of(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1, 1, false, false, true))).build();

    private Map<ArmorMaterial, List<StatusEffectInstance>> effectMap;

    public ModArmorItem(Settings settings, ArmorMaterial material) {
        super(settings);
        this.material = material;
    }

    public ArmorMaterial getMaterial() {
        return this.material;
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasAnyArmorEquipped(player)) {
                    boolean both = hasFullSuitOfArmorOn(player);
                    effectMap = both ? MATERIAL_TO_EFFECT_MAP_UP : MATERIAL_TO_EFFECT_MAP;
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot);
    }

    private void evaluateArmorEffects(PlayerEntity player) {

        for (Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : effectMap.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffects);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, List<StatusEffectInstance> mapStatusEffect) {
        boolean hasPlayerEffect = mapStatusEffect.stream().allMatch(statusEffectInstance -> player.hasStatusEffect(statusEffectInstance.getEffectType()));

        if(!hasPlayerEffect && player.isSneaking()) {
            for (StatusEffectInstance instance : mapStatusEffect) {
                player.addStatusEffect(new StatusEffectInstance(instance.getEffectType(),
                        instance.getDuration(), instance.getAmplifier(), instance.isAmbient(), instance.shouldShowParticles()));
            }
        }
    }

    private boolean hasAnyArmorEquipped(PlayerEntity player) {
        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
        ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);

        return !boots.isEmpty() || !leggings.isEmpty();
    }


    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {

        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
        ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);

        return !leggings.isEmpty() && !boots.isEmpty() &&
                getArmorMaterial(boots) != null && getArmorMaterial(leggings) != null &&
        getArmorMaterial(boots).equals(getArmorMaterial(leggings));
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {

        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
        ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);

        boolean bootsEquipped = !boots.isEmpty();
        boolean leggingsEquipped = !leggings.isEmpty();

        if (!bootsEquipped && !leggingsEquipped) {
            return false;
        }

        boolean bootsMatch = bootsEquipped && getArmorMaterial(boots) != null && getArmorMaterial(boots).equals(material);
        boolean leggingsMatch = leggingsEquipped && getArmorMaterial(leggings) != null && getArmorMaterial(leggings).equals(material);

        return bootsMatch || leggingsMatch;
    }

    private ArmorMaterial getArmorMaterial(ItemStack stack) {
        if (stack.getItem() instanceof ModArmorItem modArmorItem) {
            return modArmorItem.getMaterial();
        }
        return null;
    }
}