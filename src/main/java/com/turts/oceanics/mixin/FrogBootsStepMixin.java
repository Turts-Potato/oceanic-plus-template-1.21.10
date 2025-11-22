package com.turts.oceanics.mixin;

import com.turts.oceanics.config.OceanicsConfigManager;
import com.turts.oceanics.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class FrogBootsStepMixin {

    @Inject(method = "playStepSound", at = @At("HEAD"), cancellable = true)
    private void oceanicPlus$slimeSteps(BlockPos pos, BlockState state, CallbackInfo ci) {
        Entity self = (Entity) (Object) this;

        if (!(self instanceof PlayerEntity player)) return;
        if (player.isTouchingWater() || player.isClimbing()) return; // let vanilla handle it

        var feet = player.getEquippedStack(EquipmentSlot.FEET);

        if (!feet.isEmpty() && (feet.isOf(ModItems.FROG_BOOTS) || feet.isOf(ModItems.AWAKENED_FROG_BOOTS))) {
            // If user prefers vanilla step sounds, let vanilla handle it
            boolean useVanilla = OceanicsConfigManager.frogBootsUseVanillaStepSounds();
            if (useVanilla) return;
            // Volume/pitch roughly match vanilla step sounds
            player.playSound(SoundEvents.BLOCK_SLIME_BLOCK_BREAK, 0.15F, 1.0F);
            ci.cancel(); // stop vanilla from playing the original step sound
        }
    }
}