package com.turts.oceanics.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.UseAction;
import net.minecraft.sound.SoundEvents;

import java.util.List;

public class ModConsumableComponents extends ConsumableComponents {

    public static final ConsumableComponent BURNT_FROG_LEGS = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 1))
                    )
            )
            .build();

    public static final ConsumableComponent BURNT_FROG_FEET = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 1))
                    )
            )
            .build();
}
