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

public class Warnbarque extends BlockBase
{
    CalculateShape calc =new CalculateShape();
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 1, 7, 9, 2, 9),
            Block.makeCuboidShape(7, 13, 8, 9, 15, 8),
            Block.makeCuboidShape(9, 13, 7, 10, 15, 9),
            Block.makeCuboidShape(6, 13, 7, 7, 15, 9),
            Block.makeCuboidShape(6, 15, 7, 10, 16, 9),
            Block.makeCuboidShape(4, 0, 4, 12, 1, 12),
            Block.makeCuboidShape(10, 2, 8, 10.1, 13, 9.1),
            Block.makeCuboidShape(10, 2, 6.9, 10.1, 13, 8),
            Block.makeCuboidShape(5.9, 2, 8, 6, 13, 9.1),
            Block.makeCuboidShape(5.9, 2, 6.9, 6, 13, 8),
            Block.makeCuboidShape(6, 2, 7, 10, 13, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();



    public Warnbarque(String RegistryName, Properties properties)
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
