package com.kevinkrueger.roadstuff.data;

import com.kevinkrueger.roadstuff.block.base.*;
import com.kevinkrueger.roadstuff.block.individual.*;
import com.kevinkrueger.roadstuff.util.ModBlocks;
import com.kevinkrueger.roadstuff.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

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
