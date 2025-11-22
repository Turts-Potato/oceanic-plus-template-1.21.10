package com.turts.oceanics;

import com.turts.oceanics.block.ModBlocks;
import com.turts.oceanics.config.OceanicsConfig;
import com.turts.oceanics.item.custom.ModArmorAttributes;
import com.turts.oceanics.item.ModItemGroups;
import com.turts.oceanics.item.ModItems;
import com.turts.oceanics.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.potion.Potions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

public class Oceanicplus implements ModInitializer {
	public static final String MOD_ID = "oceanic-plus";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

 @Override
 public void onInitialize() {
     // Register config
     AutoConfig.register(OceanicsConfig.class, GsonConfigSerializer::new);

     ModItemGroups.registerItemGroups();
     ModBlocks.registerModBlocks();
     ModItems.registerModItems();
     ModArmorAttributes.registerArmorAttributes();
     ModLootTableModifiers.modifyLootTables();

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, ModItems.FROG_BOOTS, Potions.LEAPING);
            builder.registerPotionRecipe(Potions.AWKWARD, ModItems.FROG_LEGGINGS, Potions.LEAPING);
        });
	}
}