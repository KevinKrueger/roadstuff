package com.kevinkrueger.roadstuff.data;

import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.util.ModBlocks;
import com.kevinkrueger.roadstuff.util.Registration;
import net.minecraft.block.Block;
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

        Object[] blocks = Registration.BLOCKS.getEntries().toArray();
        for (Object object : blocks)
        {
            Block block = (Block) object;
            getOrCreateBuilder(Tags.Blocks.STONE).add(block);
        }
        ////getOrCreateBuilder(Tags.Blocks.STONE).add(ModBlocks.BUSSTOPSIGN.get());

        super.registerTags();
    }
}
