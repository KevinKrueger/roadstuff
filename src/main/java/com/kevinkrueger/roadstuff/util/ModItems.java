package com.kevinkrueger.roadstuff.util;

import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.base.ItemBase;
import com.kevinkrueger.roadstuff.block.individual.MetalPole;
import com.kevinkrueger.roadstuff.item.BarrierTape;
import com.kevinkrueger.roadstuff.item.SteelIngot;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.item.Item.Properties;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.RegistryObject;

import java.rmi.registry.Registry;
import java.util.function.Supplier;

public class ModItems {

    public static final RegistryObject<Item> STEEL_INGOT = register("steel_ingot",
            () -> new SteelIngot(CreateProps().maxStackSize(10).isImmuneToFire()));

    public static final RegistryObject<Item> BARRIER_TAPE = register("barriertape",
            () -> new BarrierTape(CreateProps().defaultMaxDamage(100)));

    public static final RegistryObject<Item> CARDBOARDTUBE = register("cardboardtube",
            () -> new Item(CreateProps().maxStackSize(5)));

    public static final RegistryObject<Item> STEEL_PLATE = register("steel_plate",
            () -> new Item(CreateProps().maxStackSize(10)));

    // For init
    public static void register() { }

    private static RegistryObject<Item> register(String name, Supplier<Item> sup)
    {
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