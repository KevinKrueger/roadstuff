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

public class WarningTriangle extends BlockBase
{
    CalculateShape calc =new CalculateShape();
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7.14583, 15.75694, 7, 8.64583, 15.00694, 9),
            Block.makeCuboidShape(6.89583, 15.50694, 7, 8.89583, 15.75694, 9),
            Block.makeCuboidShape(7.15, 15.75, 7, 8.65, 16, 9),
            Block.makeCuboidShape(7.4, 16, 7, 8.4, 16.25, 9),
            Block.makeCuboidShape(6.64583, 15.25694, 7, 9.14583, 15.50694, 9),
            Block.makeCuboidShape(8.14583, 14.75694, 7, 9.39583, 15.00694, 9),
            Block.makeCuboidShape(6.39583, 14.75694, 7, 9.14583, 15.25694, 9),
            Block.makeCuboidShape(6.14583, 14.25694, 7, 9.64583, 14.75694, 9),
            Block.makeCuboidShape(5.89583, 13.75694, 7, 9.89583, 14.25694, 9),
            Block.makeCuboidShape(5.64583, 13.50694, 7, 10.14583, 13.75694, 9),
            Block.makeCuboidShape(5.39583, 13.00694, 7, 10.39583, 13.50694, 9),
            Block.makeCuboidShape(5.14583, 12.50694, 7, 10.64583, 13.00694, 9),
            Block.makeCuboidShape(4.89583, 12.25694, 7, 10.89583, 12.50694, 9),
            Block.makeCuboidShape(9.89583, 11.75694, 7, 11.14583, 12.00694, 9),
            Block.makeCuboidShape(4.64583, 11.75694, 7, 10.89583, 12.25694, 9),
            Block.makeCuboidShape(4.39583, 11.25694, 7, 11.39583, 11.75694, 9),
            Block.makeCuboidShape(4.14583, 10.75694, 7, 11.64583, 11.25694, 9),
            Block.makeCuboidShape(3.89583, 10.50694, 7, 11.89583, 10.75694, 9),
            Block.makeCuboidShape(10.89583, 10.00694, 7, 12.14583, 10.25694, 9),
            Block.makeCuboidShape(3.64583, 10.00694, 7, 11.89583, 10.50694, 9),
            Block.makeCuboidShape(3.39583, 9.50694, 7, 12.39583, 10.00694, 9),
            Block.makeCuboidShape(3.14583, 9.00694, 7, 12.64583, 9.50694, 9),
            Block.makeCuboidShape(2.89583, 8.75694, 7, 12.89583, 9.00694, 9),
            Block.makeCuboidShape(2.64583, 8.25694, 7, 13.14583, 8.75694, 9),
            Block.makeCuboidShape(2.39583, 7.75694, 7, 13.39583, 8.25694, 9),
            Block.makeCuboidShape(2.14583, 7.50694, 7, 13.64583, 7.75694, 9),
            Block.makeCuboidShape(12.64583, 7.00694, 7, 13.89583, 7.25694, 9),
            Block.makeCuboidShape(7, 0, 1, 9, 2, 2),
            Block.makeCuboidShape(15, 0, 7, 16, 2, 9),
            Block.makeCuboidShape(0, 0, 7, 1, 2, 9),
            Block.makeCuboidShape(7, 0, 14, 9, 2, 15),
            Block.makeCuboidShape(7, 1, 2, 9, 2, 14),
            Block.makeCuboidShape(1, 1, 7, 15, 2, 9),
            Block.makeCuboidShape(7, 2, 7, 9, 3, 9),
            Block.makeCuboidShape(1.8958300000000001, 7.00694, 7, 13.64583, 7.50694, 9),
            Block.makeCuboidShape(1.6458300000000001, 6.50694, 7, 14.14583, 7.00694, 9),
            Block.makeCuboidShape(1.3958300000000001, 6.00694, 7, 14.39583, 6.50694, 9),
            Block.makeCuboidShape(1.1458300000000001, 5.75694, 7, 14.64583, 6.00694, 9),
            Block.makeCuboidShape(13.64583, 5.25694, 7, 14.89583, 5.50694, 9),
            Block.makeCuboidShape(0.8958300000000001, 5.25694, 7, 14.64583, 5.75694, 9),
            Block.makeCuboidShape(0.6458300000000001, 4.75694, 7, 15.14583, 5.25694, 9),
            Block.makeCuboidShape(14.65, 3.50694, 7, 15.9, 4.00694, 9),
            Block.makeCuboidShape(14.39583, 3.25694, 7, 15.64583, 4.25694, 9),
            Block.makeCuboidShape(0.14583000000000013, 3.25694, 7, 1.3958300000000001, 4.25694, 9),
            Block.makeCuboidShape(0.3958300000000001, 3.00694, 7, 15.39583, 4.75694, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();


    public WarningTriangle(String RegistryName, Properties properties)
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
