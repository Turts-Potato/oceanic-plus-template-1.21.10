package com.turts.oceanics.mixin;

import net.minecraft.block.TurtleEggBlock;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(net.minecraft.block.TurtleEggBlock.class)
public abstract class TurtleEggHatchTimeMixin {
    @Redirect(
            method = "randomTick(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/random/Random;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/random/Random;nextFloat()F"),
            require = 0
    )
    private float oceanicPlus$adjustHatchFloat(Random random) {
        // Make hatching more likely by returning a smaller float
        return random.nextFloat() * 0.2F; // 5x more likely
    }
}