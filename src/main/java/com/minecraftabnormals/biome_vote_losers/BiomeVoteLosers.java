package com.minecraftabnormals.biome_vote_losers;

import com.minecraftabnormals.biome_vote_losers.register.ModBlocks;
import com.minecraftabnormals.biome_vote_losers.register.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.Locale;

@Mod(BiomeVoteLosers.MODID)
public class BiomeVoteLosers {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "biome_vote_losers";

    private static final Logger LOGGER = LogUtils.getLogger();


    public BiomeVoteLosers() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modEventBus);

        ModItems.ITEMS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MODID, name.toLowerCase(Locale.ROOT));
    }

    public static String prefixOnString(String name) {
        return MODID + ":" + name.toLowerCase(Locale.ROOT);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
}
