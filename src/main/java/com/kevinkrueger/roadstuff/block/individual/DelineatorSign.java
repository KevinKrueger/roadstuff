package com.kevinkrueger.roadstuff.block.individual;

import com.kevinkrueger.roadstuff.base.BlockBase;
import com.kevinkrueger.roadstuff.base.CalculateShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class DelineatorSign extends BlockBase
{
    CalculateShape calc =new CalculateShape();
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7.6875, 0, 7, 7.8125, 15.3125, 9),
            Block.makeCuboidShape(9.0625, 0, 7, 9.125, 14.5, 9),
            Block.makeCuboidShape(9, 0, 7, 9.0625, 14.5625, 9),
            Block.makeCuboidShape(8.875, 0, 7, 9, 14.625, 9),
            Block.makeCuboidShape(8.75, 0, 7, 8.875, 14.6875, 9),
            Block.makeCuboidShape(8.6875, 0, 7, 8.75, 14.75, 9),
            Block.makeCuboidShape(8.5625, 0, 7, 8.6875, 14.8125, 9),
            Block.makeCuboidShape(8.4375, 0, 7, 8.5625, 14.875, 9),
            Block.makeCuboidShape(8.375, 0, 7, 8.4375, 14.9375, 9),
            Block.makeCuboidShape(8.25, 0, 7, 8.375, 15, 9),
            Block.makeCuboidShape(8.125, 0, 7, 8.25, 15.0625, 9),
            Block.makeCuboidShape(8, 0, 7, 8.125, 15.125, 9),
            Block.makeCuboidShape(7.875, 0, 7, 8, 15.1875, 9),
            Block.makeCuboidShape(7.8125, 0, 7, 7.875, 15.25, 9),
            Block.makeCuboidShape(7.5625, 0, 7, 7.6875, 15.375, 9),
            Block.makeCuboidShape(7.4375, 0, 7, 7.5625, 15.4375, 9),
            Block.makeCuboidShape(7.3125, 0, 7, 7.4375, 15.5, 9),
            Block.makeCuboidShape(7.25, 0, 7, 7.3125, 15.5625, 9),
            Block.makeCuboidShape(6.875, 0, 7, 6.9375, 15.625, 9),
            Block.makeCuboidShape(7, 0, 7, 7.0625, 15.625, 9),
            Block.makeCuboidShape(7.125, 0, 7, 7.25, 15.625, 9),
            Block.makeCuboidShape(6.9375, 0, 7, 7, 15.6875, 9),
            Block.makeCuboidShape(7.0625, 0, 7, 7.125, 15.6875, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();


    public DelineatorSign(Properties properties)
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
