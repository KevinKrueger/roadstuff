package com.kevinkrueger.roadstuff.block.individual;

import com.kevinkrueger.roadstuff.base.BlockBase;
import com.kevinkrueger.roadstuff.base.CalculateShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.IBlockReader;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.shapes.VoxelShape;


public class SteelPoleSigns extends BlockBase
{
    CalculateShape calc =new CalculateShape();
    private static final VoxelShape SHAPE_N = Block.makeCuboidShape(7, 0, 8, 9, 16, 10);

    public SteelPoleSigns(Properties properties)
    {
        super(properties);
        calc.runCalculation(SHAPE_N);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return calc.SHAPES.get(state.get(FACING));
    }
}
