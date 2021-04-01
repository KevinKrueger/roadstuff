package com.kevinkrueger.roadstuff;

import com.kevinkrueger.roadstuff.base.BasicTab;
import com.kevinkrueger.roadstuff.events.ModEvents;
import com.kevinkrueger.roadstuff.proxy.ClientProxy;
import com.kevinkrueger.roadstuff.proxy.IProxy;
import com.kevinkrueger.roadstuff.proxy.ServerProxy;
import com.kevinkrueger.roadstuff.screens.RSCraftingTableScreen;
import com.kevinkrueger.roadstuff.util.*;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
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
    public static IProxy proxy;

    public RoadStuff()
    {
        // Proxy
        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

        // Init
        Registration.init();

        ModBlocks.register();
        ModItems.register();
        ModTileEntity.register();
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
        proxy.init();
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
}
