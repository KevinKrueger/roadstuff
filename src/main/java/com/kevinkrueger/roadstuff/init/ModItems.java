package com.kevinkrueger.roadstuff.init;

import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.item.BarrierTape;
import com.kevinkrueger.roadstuff.item.SteelIngot;
import com.kevinkrueger.roadstuff.network.ILogger;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModItems implements ILogger {

    public static final RegistryObject<Item> STEEL_INGOT = register("steel_ingot",
            () -> new SteelIngot(DefaultProps().maxStackSize(10).isImmuneToFire()));

    public static final RegistryObject<Item> BARRIER_TAPE = register("barriertape",
            () -> new BarrierTape(DefaultProps().defaultMaxDamage(100)));

    public static final RegistryObject<Item> CARDBOARDTUBE = register("cardboardtube",
            () -> new Item(DefaultProps().maxStackSize(5)));

    public static final RegistryObject<Item> STEEL_PLATE = register("steel_plate",
            () -> new Item(DefaultProps().maxStackSize(10).isImmuneToFire()));

    public static final RegistryObject<Item> LIGHTBULB = register("lightbulb",
            () -> new Item(DefaultProps()));


    // For init
    public static void register() { }

    private static RegistryObject<Item> register(String name, Supplier<Item> sup)
    {
        RegistryObject<Item> registryObject = null;

        try
        {
            registryObject =  Registration.ITEMS.register(name, sup);
            LOGGER.log(ModItems.class, "Register(Item): " + name);
        }
        catch (Exception exception)
        {
            LOGGER.error(ModItems.class, "Register(Item): " + name, exception);
        }

        return registryObject;
    }

    /*
    *   Helper Method for Default-Properties
    */
    private static Properties DefaultProps()
    {
        return new Properties().group(RoadStuff.ROAD_STUFF_TAB);
    }
}