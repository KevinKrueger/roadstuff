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

public class BaseRoundSign extends BlockBase
{
    CalculateShape calc = new CalculateShape();
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 0, 9, 9, 12, 10),
            Block.makeCuboidShape(7.75, 0, 7, 8.25, 0.25, 9),
            Block.makeCuboidShape(0.25, 6, 7, 0.5, 10, 9),
            Block.makeCuboidShape(15.5, 6, 7, 15.75, 10, 9),
            Block.makeCuboidShape(0.5, 5.25, 7, 0.75, 10.75, 9),
            Block.makeCuboidShape(15.25, 5.25, 7, 15.5, 10.75, 9),
            Block.makeCuboidShape(0.75, 4.75, 7, 1, 11.25, 9),
            Block.makeCuboidShape(15, 4.75, 7, 15.25, 11.25, 9),
            Block.makeCuboidShape(1, 4.25, 7, 1.25, 11.75, 9),
            Block.makeCuboidShape(14.75, 4.25, 7, 15, 11.75, 9),
            Block.makeCuboidShape(1.25, 3.75, 7, 1.5, 12.25, 9),
            Block.makeCuboidShape(14.5, 3.75, 7, 14.75, 12.25, 9),
            Block.makeCuboidShape(1.5, 3.5, 7, 1.75, 12.5, 9),
            Block.makeCuboidShape(14.25, 3.5, 7, 14.5, 12.5, 9),
            Block.makeCuboidShape(1.75, 3, 7, 2, 13, 9),
            Block.makeCuboidShape(14, 3, 7, 14.25, 13, 9),
            Block.makeCuboidShape(2, 2.75, 7, 2.25, 13.25, 9),
            Block.makeCuboidShape(13.75, 2.75, 7, 14, 13.25, 9),
            Block.makeCuboidShape(2.25, 2.5, 7, 2.5, 13.5, 9),
            Block.makeCuboidShape(13.5, 2.5, 7, 13.75, 13.5, 9),
            Block.makeCuboidShape(2.5, 2.25, 7, 2.75, 13.75, 9),
            Block.makeCuboidShape(13.25, 2.25, 7, 13.5, 13.75, 9),
            Block.makeCuboidShape(2.75, 2, 7, 3, 14, 9),
            Block.makeCuboidShape(13, 2, 7, 13.25, 14, 9),
            Block.makeCuboidShape(3, 1.75, 7, 3.5, 14.25, 9),
            Block.makeCuboidShape(12.5, 1.75, 7, 13, 14.25, 9),
            Block.makeCuboidShape(3.5, 1.5, 7, 3.75, 14.5, 9),
            Block.makeCuboidShape(12.25, 1.5, 7, 12.5, 14.5, 9),
            Block.makeCuboidShape(3.75, 1.25, 7, 4.25, 14.75, 9),
            Block.makeCuboidShape(11.75, 1.25, 7, 12.25, 14.75, 9),
            Block.makeCuboidShape(4.25, 1, 7, 4.75, 15, 9),
            Block.makeCuboidShape(11.25, 1, 7, 11.75, 15, 9),
            Block.makeCuboidShape(4.75, 0.75, 7, 5.25, 15.25, 9),
            Block.makeCuboidShape(10.75, 0.75, 7, 11.25, 15.25, 9),
            Block.makeCuboidShape(5.25, 0.5, 7, 6, 15.5, 9),
            Block.makeCuboidShape(10, 0.5, 7, 10.75, 15.5, 9),
            Block.makeCuboidShape(6, 0.25, 7, 10, 15.75, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public BaseRoundSign(String RegistryName, Properties properties) {
        super(RegistryName, properties);
        calc.runCalculation(this.getClass(),RegistryName, SHAPE_N);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return calc.SHAPES.get(state.get(FACING));
    }
}
