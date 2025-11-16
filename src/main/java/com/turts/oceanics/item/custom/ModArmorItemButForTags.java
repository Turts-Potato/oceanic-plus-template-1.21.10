package com.turts.oceanics.item.custom;

import com.google.common.collect.ImmutableMap;
import com.turts.oceanics.util.ModTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

// Extends ModArmorItem so items using this class receive BOTH material-based effects
// and tag-based effects.
public class ModArmorItemButForTags extends ModArmorItem {

    private static final Map<TagKey<Item>, List<StatusEffectInstance>> TAG_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<TagKey<Item>, List<StatusEffectInstance>>())
                    .put(ModTags.Items.AWAKENED_ITEMS,
                            List.of(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 100, 0, true, false, true)))
                    .build();

    private Map<TagKey<Item>, List<StatusEffectInstance>> effectMap;

    public ModArmorItemButForTags(Settings settings, ArmorMaterial material) {
        super(settings, material);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasFullSuitOfArmorOn(player)) {
                    effectMap = TAG_TO_EFFECT_MAP;
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot);
    }

    private void evaluateArmorEffects(PlayerEntity player) {

        for (Map.Entry<TagKey<Item>, List<StatusEffectInstance>> entry : effectMap.entrySet()) {
            TagKey<Item> tag = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();

            if(hasCorrectArmorOn(tag, player)) {
                addStatusEffectForTag(player, mapStatusEffects);
            }
        }
    }

    private void addStatusEffectForTag(PlayerEntity player, List<StatusEffectInstance> mapStatusEffect) {
        for (StatusEffectInstance template : mapStatusEffect) {
            var type = template.getEffectType();
            var current = player.getStatusEffect(type);

            boolean restartTimer = current == null || current.getDuration() <= 100 || current.getAmplifier() != template.getAmplifier();
            if (restartTimer) {
                player.addStatusEffect(new StatusEffectInstance(
                        type,
                        100,
                        template.getAmplifier(),
                        true,
                        false,
                        true
                ));
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {

        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
        ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);

        return !boots.isEmpty() && !leggings.isEmpty()
                && !chestplate.isEmpty() && !helmet.isEmpty();
    }

    private boolean hasCorrectArmorOn(TagKey<Item> tag, PlayerEntity player) {

        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
        ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);

        boolean bootsMatch = !boots.isEmpty() && boots.isIn(tag);
        boolean leggingsMatch = !leggings.isEmpty() && leggings.isIn(tag);
        boolean chestplateMatch = !chestplate.isEmpty() && chestplate.isIn(tag);
        boolean helmetMatch = !helmet.isEmpty() && helmet.isIn(tag);

        return bootsMatch && leggingsMatch && chestplateMatch && helmetMatch;
    }
}