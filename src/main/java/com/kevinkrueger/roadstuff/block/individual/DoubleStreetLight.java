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

public class DoubleStreetLight extends BlockBase {

    CalculateShape calc = new CalculateShape();

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 0, 7, 9, 16, 9),
            Block.makeCuboidShape(7, 13, 3, 9, 15, 7),
            Block.makeCuboidShape(7, 13, 9, 9, 15, 13),
            Block.makeCuboidShape(6, 13, 0, 10, 15, 1),
            Block.makeCuboidShape(6, 13, 12, 10, 15, 13),
            Block.makeCuboidShape(6, 13, 3, 10, 15, 4),
            Block.makeCuboidShape(6, 13, 15, 10, 15, 16),
            Block.makeCuboidShape(6, 13, 1, 7, 15, 3),
            Block.makeCuboidShape(9, 13, 13, 10, 15, 15),
            Block.makeCuboidShape(9, 13, 1, 10, 15, 3),
            Block.makeCuboidShape(6, 13, 13, 7, 15, 15),
            Block.makeCuboidShape(6, 15, 0, 10, 16, 4),
            Block.makeCuboidShape(6, 15, 12, 10, 16, 16),
            Block.makeCuboidShape(7, 14, 1, 9, 15, 3),
            Block.makeCuboidShape(7, 14, 13, 9, 15, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public DoubleStreetLight(String RegistryName, Properties properties)
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
