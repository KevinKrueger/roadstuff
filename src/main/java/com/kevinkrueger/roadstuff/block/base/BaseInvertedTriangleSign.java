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

public class BaseInvertedTriangleSign extends BlockBase
{
    CalculateShape calc = new CalculateShape();
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 0, 9, 9, 12, 10),
            Block.makeCuboidShape(7.75, 1.5, 7, 8.25, 1.75, 9),
            Block.makeCuboidShape(7.5, 1.75, 7, 8.5, 2, 9),
            Block.makeCuboidShape(7.25, 2, 7, 8.75, 2.25, 9),
            Block.makeCuboidShape(7, 2.5, 7, 7.25, 2.75, 9),
            Block.makeCuboidShape(7.25, 2.25, 7, 9, 2.75, 9),
            Block.makeCuboidShape(6.75, 2.75, 7, 9.25, 3.25, 9),
            Block.makeCuboidShape(6.5, 3.25, 7, 9.5, 3.75, 9),
            Block.makeCuboidShape(6.25, 3.75, 7, 9.75, 4, 9),
            Block.makeCuboidShape(6, 4, 7, 10, 4.5, 9),
            Block.makeCuboidShape(5.75, 4.5, 7, 10.25, 5, 9),
            Block.makeCuboidShape(5.5, 5, 7, 10.5, 5.25, 9),
            Block.makeCuboidShape(5.25, 5.5, 7, 5.5, 5.75, 9),
            Block.makeCuboidShape(5.5, 5.25, 7, 10.75, 5.75, 9),
            Block.makeCuboidShape(5, 5.75, 7, 11, 6.25, 9),
            Block.makeCuboidShape(4.75, 6.25, 7, 11.25, 6.75, 9),
            Block.makeCuboidShape(4.5, 6.75, 7, 11.5, 7, 9),
            Block.makeCuboidShape(4.25, 7.25, 7, 4.5, 7.5, 9),
            Block.makeCuboidShape(4.5, 7, 7, 11.75, 7.5, 9),
            Block.makeCuboidShape(4, 7.5, 7, 12, 8, 9),
            Block.makeCuboidShape(3.75, 8, 7, 12.25, 8.5, 9),
            Block.makeCuboidShape(3.5, 8.5, 7, 12.5, 8.75, 9),
            Block.makeCuboidShape(3.25, 8.75, 7, 12.75, 9.25, 9),
            Block.makeCuboidShape(3, 9.25, 7, 13, 9.75, 9),
            Block.makeCuboidShape(2.75, 9.75, 7, 13.25, 10, 9),
            Block.makeCuboidShape(2.5, 10.25, 7, 2.75, 10.5, 9),
            Block.makeCuboidShape(2.75, 10, 7, 13.5, 10.5, 9),
            Block.makeCuboidShape(2.25, 10.5, 7, 13.75, 11, 9),
            Block.makeCuboidShape(2, 11, 7, 14, 11.5, 9),
            Block.makeCuboidShape(1.75, 11.5, 7, 14.25, 11.75, 9),
            Block.makeCuboidShape(1.5, 12, 7, 1.75, 12.25, 9),
            Block.makeCuboidShape(1.75, 11.75, 7, 14.5, 12.25, 9),
            Block.makeCuboidShape(1.25, 12.25, 7, 14.75, 12.75, 9),
            Block.makeCuboidShape(15.25, 13.5, 7, 15.5, 14, 9),
            Block.makeCuboidShape(0.75, 13.25, 7, 1, 14.25, 9),
            Block.makeCuboidShape(15, 13.25, 7, 15.25, 14.25, 9),
            Block.makeCuboidShape(1, 12.75, 7, 15, 14.5, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public BaseInvertedTriangleSign(String RegistryName, Properties properties)
    {
        super(RegistryName, properties);
        calc.runCalculation(this.getClass(),RegistryName, SHAPE_N);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return calc.SHAPES.get(state.get(FACING));
    }
}
