package com.turts.oceanics.mixin;

import com.turts.oceanics.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityTurtleHelmetDurationMixin {


    // NOTE: Adjust method = "tick()V" to the method that contains the if-guard in your mappings
    @Redirect(
            method = "tick()V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;isEquipped(Lnet/minecraft/item/Item;)Z"
                    // In some mappings the owner is LivingEntity; if so, use:
                    // target = "Lnet/minecraft/entity/LivingEntity;isEquipped(Lnet/minecraft/item/Item;)Z"
            )
            // Optionally: add ordinal = <n> if there are multiple isEquipped calls in the method
    )
    private boolean oceanicPlus$includeAwakenedHelmet(PlayerEntity self, Item item) {
        // Only broaden the check when vanilla code is specifically asking about TURTLE_HELMET
        if (item == Items.TURTLE_HELMET) {
            return isWearingOnHead(self, Items.TURTLE_HELMET) || isWearingOnHead(self, ModItems.AWAKENED_TURTLE_HELMET);
        }
        // Fallback to vanilla behavior for other items — emulate PlayerEntity#isEquipped for head slot
        return isWearingOnHead(self, item);
    }

    private static boolean isWearingOnHead(PlayerEntity self, Item item) {
        return self.getEquippedStack(EquipmentSlot.HEAD).isOf(item);
    }



    @ModifyConstant(method = "updateTurtleHelmet()V", constant = @Constant(intValue = 200))
    private int oceanicPlus$changeTurtleHelmetDuration(int original) {
        // Increase from ~10.5s to 20s
        return 400; // 20 seconds in ticks
    }
}
