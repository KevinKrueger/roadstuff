package com.kevinkrueger.roadstuff.block.base;

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

public class BaseTriangleSign extends BlockBase
{

    CalculateShape calc = new CalculateShape();
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 0, 9, 9, 12, 10),
            Block.makeCuboidShape(0.25, 0.5, 7, 0.5, 1.5, 9),
            Block.makeCuboidShape(15.5, 0.5, 7, 15.75, 1.5, 9),
            Block.makeCuboidShape(0.5, 0.25, 7, 0.75, 2, 9),
            Block.makeCuboidShape(15.25, 0.25, 7, 15.5, 2, 9),
            Block.makeCuboidShape(0.75, 0.25, 7, 1, 2.5, 9),
            Block.makeCuboidShape(15, 0.25, 7, 15.25, 2.5, 9),
            Block.makeCuboidShape(1, 0.25, 7, 1.25, 3, 9),
            Block.makeCuboidShape(14.75, 0.25, 7, 15, 3, 9),
            Block.makeCuboidShape(1.25, 0.25, 7, 1.5, 3.5, 9),
            Block.makeCuboidShape(14.5, 0.25, 7, 14.75, 3.5, 9),
            Block.makeCuboidShape(1.5, 0.25, 7, 1.75, 4, 9),
            Block.makeCuboidShape(14.25, 0.25, 7, 14.5, 4, 9),
            Block.makeCuboidShape(1.75, 0.25, 7, 2, 4.5, 9),
            Block.makeCuboidShape(14, 0.25, 7, 14.25, 4.5, 9),
            Block.makeCuboidShape(2, 0.25, 7, 2.25, 5, 9),
            Block.makeCuboidShape(13.75, 0.25, 7, 14, 5, 9),
            Block.makeCuboidShape(2.25, 0.25, 7, 2.5, 5.5, 9),
            Block.makeCuboidShape(13.5, 0.25, 7, 13.75, 5.5, 9),
            Block.makeCuboidShape(2.5, 0.25, 7, 2.75, 6, 9),
            Block.makeCuboidShape(13.25, 0.25, 7, 13.5, 6, 9),
            Block.makeCuboidShape(2.75, 0.25, 7, 3, 6.5, 9),
            Block.makeCuboidShape(13, 0.25, 7, 13.25, 6.5, 9),
            Block.makeCuboidShape(3, 0.25, 7, 3.25, 7, 9),
            Block.makeCuboidShape(12.75, 0.25, 7, 13, 7, 9),
            Block.makeCuboidShape(3.25, 0.25, 7, 3.5, 7.5, 9),
            Block.makeCuboidShape(12.5, 0.25, 7, 12.75, 7.5, 9),
            Block.makeCuboidShape(3.5, 0.25, 7, 3.75, 8, 9),
            Block.makeCuboidShape(12.25, 0.25, 7, 12.5, 8, 9),
            Block.makeCuboidShape(3.75, 0.25, 7, 4, 8.5, 9),
            Block.makeCuboidShape(12, 0.25, 7, 12.25, 8.5, 9),
            Block.makeCuboidShape(4, 0.25, 7, 4.25, 9, 9),
            Block.makeCuboidShape(11.75, 0.25, 7, 12, 9, 9),
            Block.makeCuboidShape(4.25, 0.25, 7, 4.5, 9.5, 9),
            Block.makeCuboidShape(11.5, 0.25, 7, 11.75, 9.5, 9),
            Block.makeCuboidShape(4.5, 0.25, 7, 4.75, 10, 9),
            Block.makeCuboidShape(11.25, 0.25, 7, 11.5, 10, 9),
            Block.makeCuboidShape(4.75, 0.25, 7, 5, 10.5, 9),
            Block.makeCuboidShape(11, 0.25, 7, 11.25, 10.5, 9),
            Block.makeCuboidShape(5, 0.25, 7, 5.25, 11, 9),
            Block.makeCuboidShape(10.75, 0.25, 7, 11, 11, 9),
            Block.makeCuboidShape(5.25, 0.25, 7, 5.5, 11.5, 9),
            Block.makeCuboidShape(10.5, 0.25, 7, 10.75, 11.5, 9),
            Block.makeCuboidShape(5.5, 0.25, 7, 5.75, 12, 9),
            Block.makeCuboidShape(10.25, 0.25, 7, 10.5, 12, 9),
            Block.makeCuboidShape(5.75, 0.25, 7, 6, 12.5, 9),
            Block.makeCuboidShape(10, 0.25, 7, 10.25, 12.5, 9),
            Block.makeCuboidShape(6, 0.25, 7, 6.25, 12.75, 9),
            Block.makeCuboidShape(9.75, 0.25, 7, 10, 13, 9),
            Block.makeCuboidShape(6.25, 0.25, 7, 6.5, 13.25, 9),
            Block.makeCuboidShape(9.5, 0.25, 7, 9.75, 13.5, 9),
            Block.makeCuboidShape(6.5, 0.25, 7, 6.75, 13.75, 9),
            Block.makeCuboidShape(9.25, 0.25, 7, 9.5, 14, 9),
            Block.makeCuboidShape(6.75, 0.25, 7, 7, 14.25, 9),
            Block.makeCuboidShape(9, 0.25, 7, 9.25, 14.5, 9),
            Block.makeCuboidShape(7, 0.25, 7, 7.25, 14.75, 9),
            Block.makeCuboidShape(8.75, 0.25, 7, 9, 14.75, 9),
            Block.makeCuboidShape(7.25, 0.25, 7, 7.5, 15.25, 9),
            Block.makeCuboidShape(8.5, 0.25, 7, 8.75, 15.25, 9),
            Block.makeCuboidShape(7.5, 0.25, 7, 8.5, 15.75, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();



    public BaseTriangleSign(String RegistryName, Properties properties)
    {
        super(RegistryName, properties);
        calc.runCalculation(this.getClass(), RegistryName, SHAPE_N);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return calc.SHAPES.get(state.get(FACING));
    }
}

