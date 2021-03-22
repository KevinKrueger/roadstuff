package com.kevinkrueger.roadstuff.data;

import com.google.common.eventbus.Subscribe;
import com.kevinkrueger.roadstuff.RoadStuff;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.common.data.ExistingFileHelper;

@Mod.EventBusSubscriber(modid = RoadStuff.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators
{
    private DataGenerators(){}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(new ModBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(new ModItemModelProvider(generator, existingFileHelper));

        ModBlockTagsProvider block_tags = new ModBlockTagsProvider(generator, existingFileHelper);

        generator.addProvider(block_tags);
        generator.addProvider(new ModItemTagsProvider(generator, block_tags, existingFileHelper));
        generator.addProvider(new ModLootTableProvider(generator));
    }
}
