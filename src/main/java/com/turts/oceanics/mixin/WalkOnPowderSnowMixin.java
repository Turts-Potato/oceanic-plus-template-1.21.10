package com.turts.oceanics.mixin;

import com.turts.oceanics.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.block.EntityShapeContext;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PowderSnowBlock.class)
public class WalkOnPowderSnowMixin {
    @Inject(method = "getCollisionShape", at = @At("HEAD"), cancellable = true)
    private void oceanicplus$walkOnPowderSnow(BlockState state, BlockView world, BlockPos pos, ShapeContext context, CallbackInfoReturnable<VoxelShape> cir) {
        // Only proceed if a living entity is querying the shape
        if (!(context instanceof EntityShapeContext esc)) return;
        var entity = esc.getEntity();
        if (!(entity instanceof LivingEntity living)) return;

        var feet = living.getEquippedStack(EquipmentSlot.FEET);
        if (feet.isEmpty()) return;

        // Vanilla-compatible: stand on powder snow when wearing an item in the freeze-immune tag
        if (feet.isIn(ItemTags.FREEZE_IMMUNE_WEARABLES)) {
            cir.setReturnValue(VoxelShapes.fullCube());
            return;
        }
        // Explicit fallback: accept your boots even if some environment fails to merge the tag
        if (feet.isOf(ModItems.FROG_BOOTS) || feet.isOf(ModItems.AWAKENED_FROG_BOOTS)) {
            cir.setReturnValue(VoxelShapes.fullCube());
        }
    }
}