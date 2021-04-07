package com.kevinkrueger.roadstuff.init;

import com.kevinkrueger.roadstuff.RoadStuff;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RoadStuff.MOD_ID);
    public static final DeferredRegister<Item>   ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,  RoadStuff.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, RoadStuff.MOD_ID);
    public static final DeferredRegister<ContainerType<?>> CONATINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, RoadStuff.MOD_ID);

    public static void init()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        TILE_ENTITY_TYPE.register(eventBus);
        CONATINERS.register(eventBus);
    }
}
