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

public class Barrier extends BlockBase {

    CalculateShape calc =new CalculateShape();
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 2, 16, 2),
            Block.makeCuboidShape(2, 12, 1, 14, 15, 1),
            Block.makeCuboidShape(14, 0, 0, 16, 16, 2)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();




    public Barrier(Properties properies)
    {
        super(properies);
        calc.runCalculation(SHAPE_N);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return calc.SHAPES.get(state.get(FACING));
    }
}
