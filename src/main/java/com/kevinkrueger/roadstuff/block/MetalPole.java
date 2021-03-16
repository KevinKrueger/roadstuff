package com.kevinkrueger.roadstuff.block;

import com.kevinkrueger.roadstuff.BlockBase;
import com.kevinkrueger.roadstuff.IItemBlock;
import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.util.Registration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.RegistryObject;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;
import java.util.stream.Stream;


public class MetalPole extends BlockBase
{

    private static final VoxelShape SHAPE_N = Block.makeCuboidShape(7, 0, 8, 9, 16, 10);

    private static final VoxelShape SHAPE_W = Block.makeCuboidShape(8, 0, 7, 10, 16, 9);

    private static final VoxelShape SHAPE_O = Block.makeCuboidShape(6, 0, 7, 8, 16, 9);

    private static final VoxelShape SHAPE_S = Block.makeCuboidShape(7, 0, 6, 9, 16, 8);

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public MetalPole(Properties properties)
    {
        super(properties);
    }



    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING))
        {
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_O;
            default:
                return SHAPE_N;
        }
    }
}
