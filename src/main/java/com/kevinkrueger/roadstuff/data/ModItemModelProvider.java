package com.kevinkrueger.roadstuff.data;

import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.util.Registration;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, RoadStuff.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {


        Object[] blocks = Registration.BLOCKS.getEntries().toArray();
        for (Object object : blocks)
        {
            Block block = (Block) object;

            withExistingParent(block.getRegistryName().toString(), modLoc("block/"+ block.getRegistryName().toString()));
        }

        /// withExistingParent("busstopsign", modLoc("block/busstopsign"));



        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}