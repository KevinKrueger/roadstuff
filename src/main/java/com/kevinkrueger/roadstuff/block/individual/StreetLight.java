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

public class StreetLight extends BlockBase
{
    CalculateShape calc =new CalculateShape();
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 0, 8, 9, 16, 10),
            Block.makeCuboidShape(7, 13, 4, 9, 15, 8),
            Block.makeCuboidShape(6, 13, 0, 10, 15, 1),
            Block.makeCuboidShape(6, 13, 3, 10, 15, 4),
            Block.makeCuboidShape(6, 13, 1, 7, 15, 3),
            Block.makeCuboidShape(9, 13, 1, 10, 15, 3),
            Block.makeCuboidShape(6, 15, 0, 10, 16, 4),
            Block.makeCuboidShape(7, 14, 1, 9, 15, 3)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();


    public StreetLight(Properties properties)
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
