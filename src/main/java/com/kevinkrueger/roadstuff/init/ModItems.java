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
            () -> new SteelIngot(CreateProps().maxStackSize(10).isImmuneToFire()));

    public static final RegistryObject<Item> BARRIER_TAPE = register("barriertape",
            () -> new BarrierTape(CreateProps().defaultMaxDamage(100)));

    public static final RegistryObject<Item> CARDBOARDTUBE = register("cardboardtube",
            () -> new Item(CreateProps().maxStackSize(5)));

    public static final RegistryObject<Item> STEEL_PLATE = register("steel_plate",
            () -> new Item(CreateProps().maxStackSize(10)));


    public static final RegistryObject<Item> LIGHTBULB = register("lightbulb",
            () -> new Item(CreateProps()));


    // For init
    public static void register() { }

    private static RegistryObject<Item> register(String name, Supplier<Item> sup)
    {
        LOGGER.log("Register(Item): " + name);
        return Registration.ITEMS.register(name, sup);
    }

    /*
    *   Helper Method for Default-Properties
    */
    private static Properties CreateProps()
    {
        return new Properties().group(RoadStuff.ROAD_STUFF_TAB);
    }
}