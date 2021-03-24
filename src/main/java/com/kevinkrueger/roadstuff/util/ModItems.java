package com.kevinkrueger.roadstuff.util;

import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.base.ItemBase;
import com.kevinkrueger.roadstuff.block.individual.MetalPole;
import com.kevinkrueger.roadstuff.item.SteelIngot;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.EnderEyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.rmi.registry.Registry;
import java.util.function.Supplier;

public class ModItems {
    public static final RegistryObject<Item> STEEL_INGOT = register("steel_ingot",
            () -> new SteelIngot(new Item.Properties().maxStackSize(10).isImmuneToFire()));

    public static final RegistryObject<Item> BARRIER_TAPE = register("barriertape",
            () -> new Item(new Item.Properties().maxStackSize(2)));

    public static final RegistryObject<Item> CARDBOARDTUBE = register("cardboardtube",
            () -> new Item(new Item.Properties().maxStackSize(5)));

    // For init
    public static void register() { }

    private static RegistryObject<Item> register(String name, Supplier<Item> sup)
    {
        return Registration.ITEMS.register(name, () -> new Item(new Item.Properties().group(RoadStuff.ROAD_STUFF_TAB)));
    }
}