package com.turts.oceanics.config;

import me.shedaniel.autoconfig.AutoConfig;

public final class OceanicsConfigManager {
    private OceanicsConfigManager() {}

    public static OceanicsConfig get() {
        return AutoConfig.getConfigHolder(OceanicsConfig.class).getConfig();
    }

    public static boolean requireCrouchForJumpBoost() {
        return get().requireCrouchForJumpBoost;
    }

    public static boolean frogBootsUseVanillaStepSounds() {
        return get().frogBootsUseVanillaStepSounds;
    }
}
