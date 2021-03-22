package com.kevinkrueger.roadstuff.data;

import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.util.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider
{
    public ModBlockTagsProvider(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, RoadStuff.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags()
    {
        getOrCreateBuilder(Tags.Blocks.STONE).add(ModBlocks.BUSSTOPSIGN.get());

        super.registerTags();
    }
}
