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

public class RightOfWaySign extends BlockBase
{
    CalculateShape calc = new CalculateShape();

    private static final VoxelShape SHAPE_N = VoxelShapes.combineAndSimplify(
                    Block.makeCuboidShape(3.207106781186548, 2.207106781186548, 7, 14.207106781186548, 13.207106781186548, 9),
                    Block.makeCuboidShape(7, 0, 9, 9, 12, 10), IBooleanFunction.OR);

    public RightOfWaySign(String RegistryName, Properties properties)
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
