package com.turts.oceanics.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "oceanic-plus")
public class OceanicsConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    public boolean requireCrouchForJumpBoost = false;

    @ConfigEntry.Gui.Tooltip
    public boolean frogBootsUseVanillaStepSounds = true;
}
