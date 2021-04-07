package com.kevinkrueger.roadstuff.data;

import com.kevinkrueger.roadstuff.init.Registration;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;

public class ModBlockLootTables extends BlockLootTables {

    @Override
    protected void addTables()
    {
        getKnownBlocks().forEach(this::registerDropSelfLootTable);
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return Registration.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
