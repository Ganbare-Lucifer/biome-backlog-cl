package com.camcamcamcamcam.biome_backlog.register;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
	public static final FoodProperties PRICKLY_PEAR = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).fast()
			.effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0), 1.0F).build();
	public static final FoodProperties PRICKLESS_PEAR = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).fast()
			.effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1.0F).build();
	public static final FoodProperties CACTUS_SALAD = new FoodProperties.Builder().nutrition(8).saturationMod(0.1F).build();

	public static final FoodProperties BAOBAB_FRUIT = new FoodProperties.Builder().nutrition(2).saturationMod(1F).build();
	public static final FoodProperties RAW_OSTRICH = new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).build();
	public static final FoodProperties COOKED_OSTRICH = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).build();

	public static final FoodProperties DATE = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties COCONUT_CHUNK = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties DESICCATED_COCONUT = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build();

}
