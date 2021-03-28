package com.kevinkrueger.roadstuff;

import com.kevinkrueger.roadstuff.base.BasicTab;
import com.kevinkrueger.roadstuff.events.ModEvents;
import com.kevinkrueger.roadstuff.util.ModBlocks;
import com.kevinkrueger.roadstuff.util.ModContainers;
import com.kevinkrueger.roadstuff.util.ModItems;
import com.kevinkrueger.roadstuff.util.Registration;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("roadstuff")
public class RoadStuff
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    // Road Stuff ....
    public static final String MOD_ID = "roadstuff";
    public static final String NAME = "Road Stuff";
    public static final String MOD_VER = "1.0.0";
    public static SimpleChannel SIMPLE_CHANNEL;
    public static BasicTab ROAD_STUFF_TAB;

    public RoadStuff()
    {
        // Init
        Registration.init();
        ModBlocks.register();
        ModItems.register();
        ModContainers.register();

        ROAD_STUFF_TAB = new BasicTab(MOD_ID, () -> new ItemStack(ModBlocks.CROSSWALK_SIGN.get()));

        MinecraftForge.EVENT_BUS.register((new ModEvents()));


        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // Nothing to do...
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("RoadStuff is ready!");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
   /*@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }*/
}
