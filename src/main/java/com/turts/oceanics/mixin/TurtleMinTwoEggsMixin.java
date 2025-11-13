package com.turts.oceanics.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.TurtleEggBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(targets = "net.minecraft.entity.passive.TurtleEntity$LayEggGoal")
public abstract class TurtleMinTwoEggsMixin {
    @ModifyArg(
            method = "tick()V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z"
            ),
            index = 1
    )
    private BlockState oceanicPlus$ensureMinTwoEggs(BlockState state) {
        if (state.contains(TurtleEggBlock.EGGS)) {
            int current = state.get(TurtleEggBlock.EGGS);
            if (current < 2) {
                return state.with(TurtleEggBlock.EGGS, 2);
            }
        }
        return state;
    }
}