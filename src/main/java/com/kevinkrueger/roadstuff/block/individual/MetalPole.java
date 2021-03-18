package com.kevinkrueger.roadstuff.block.individual;

import com.kevinkrueger.roadstuff.base.BlockBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.IBlockReader;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.shapes.VoxelShape;


public class MetalPole extends BlockBase
{

    private static final VoxelShape SHAPE_N = Block.makeCuboidShape(7, 0, 8, 9, 16, 10);

    private static final VoxelShape SHAPE_W = Block.makeCuboidShape(8, 0, 7, 10, 16, 9);

    private static final VoxelShape SHAPE_O = Block.makeCuboidShape(6, 0, 7, 8, 16, 9);

    private static final VoxelShape SHAPE_S = Block.makeCuboidShape(7, 0, 6, 9, 16, 8);

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
