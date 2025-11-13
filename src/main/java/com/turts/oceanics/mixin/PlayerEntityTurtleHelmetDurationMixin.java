package com.turts.oceanics.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityTurtleHelmetDurationMixin {

    @ModifyConstant(method = "updateTurtleHelmet()V", constant = @Constant(intValue = 200))
    private int oceanicPlus$changeTurtleHelmetDuration(int original) {
        // Increase from ~10.5s to 20s
        return 400; // 20 seconds in ticks
    }
}
