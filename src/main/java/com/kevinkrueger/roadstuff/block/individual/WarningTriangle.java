package com.kevinkrueger.roadstuff.block.individual;

import com.kevinkrueger.roadstuff.base.BlockBase;
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

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(7, 15.75694, 7.35417, 9, 15.00694, 8.85417),
            Block.makeCuboidShape(7, 15.50694, 7.10417, 9, 15.75694, 9.10417),
            Block.makeCuboidShape(7, 15.75, 7.35, 9, 16, 8.85),
            Block.makeCuboidShape(7, 16, 7.6, 9, 16.25, 8.6),
            Block.makeCuboidShape(7, 15.25694, 6.85417, 9, 15.50694, 9.35417),
            Block.makeCuboidShape(7, 14.75694, 6.60417, 9, 15.00694, 7.85417),
            Block.makeCuboidShape(7, 14.75694, 6.85417, 9, 15.25694, 9.60417),
            Block.makeCuboidShape(7, 14.25694, 6.35417, 9, 14.75694, 9.85417),
            Block.makeCuboidShape(7, 13.75694, 6.10417, 9, 14.25694, 10.10417),
            Block.makeCuboidShape(7, 13.50694, 5.85417, 9, 13.75694, 10.35417),
            Block.makeCuboidShape(7, 13.00694, 5.60417, 9, 13.50694, 10.60417),
            Block.makeCuboidShape(7, 12.50694, 5.35417, 9, 13.00694, 10.85417),
            Block.makeCuboidShape(7, 12.25694, 5.10417, 9, 12.50694, 11.10417),
            Block.makeCuboidShape(7, 11.75694, 4.85417, 9, 12.00694, 6.10417),
            Block.makeCuboidShape(7, 11.75694, 5.10417, 9, 12.25694, 11.35417),
            Block.makeCuboidShape(7, 11.25694, 4.60417, 9, 11.75694, 11.60417),
            Block.makeCuboidShape(7, 10.75694, 4.35417, 9, 11.25694, 11.85417),
            Block.makeCuboidShape(7, 10.50694, 4.10417, 9, 10.75694, 12.10417),
            Block.makeCuboidShape(7, 10.00694, 3.85417, 9, 10.25694, 5.10417),
            Block.makeCuboidShape(7, 10.00694, 4.10417, 9, 10.50694, 12.35417),
            Block.makeCuboidShape(7, 9.50694, 3.60417, 9, 10.00694, 12.60417),
            Block.makeCuboidShape(7, 9.00694, 3.35417, 9, 9.50694, 12.85417),
            Block.makeCuboidShape(7, 8.75694, 3.10417, 9, 9.00694, 13.10417),
            Block.makeCuboidShape(7, 8.25694, 2.85417, 9, 8.75694, 13.35417),
            Block.makeCuboidShape(7, 7.75694, 2.60417, 9, 8.25694, 13.60417),
            Block.makeCuboidShape(7, 7.50694, 2.35417, 9, 7.75694, 13.85417),
            Block.makeCuboidShape(7, 7.00694, 2.10417, 9, 7.25694, 3.35417),
            Block.makeCuboidShape(1, 0, 7, 2, 2, 9),
            Block.makeCuboidShape(7, 0, 0, 9, 2, 1),
            Block.makeCuboidShape(7, 0, 15, 9, 2, 16),
            Block.makeCuboidShape(14, 0, 7, 15, 2, 9),
            Block.makeCuboidShape(2, 1, 7, 14, 2, 9),
            Block.makeCuboidShape(7, 1, 1, 9, 2, 15),
            Block.makeCuboidShape(7, 2, 7, 9, 3, 9),
            Block.makeCuboidShape(7, 7.00694, 2.35417, 9, 7.50694, 14.10417),
            Block.makeCuboidShape(7, 6.50694, 1.8541699999999999, 9, 7.00694, 14.35417),
            Block.makeCuboidShape(7, 6.00694, 1.6041699999999999, 9, 6.50694, 14.60417),
            Block.makeCuboidShape(7, 5.75694, 1.3541699999999999, 9, 6.00694, 14.85417),
            Block.makeCuboidShape(7, 5.25694, 1.1041699999999999, 9, 5.50694, 2.35417),
            Block.makeCuboidShape(7, 5.25694, 1.3541699999999999, 9, 5.75694, 15.10417),
            Block.makeCuboidShape(7, 4.75694, 0.8541699999999999, 9, 5.25694, 15.35417),
            Block.makeCuboidShape(7, 3.50694, 0.09999999999999964, 9, 4.00694, 1.3499999999999996),
            Block.makeCuboidShape(7, 3.25694, 0.3541699999999999, 9, 4.25694, 1.6041699999999999),
            Block.makeCuboidShape(7, 3.25694, 14.60417, 9, 4.25694, 15.85417),
            Block.makeCuboidShape(7, 3.00694, 0.6041699999999999, 9, 4.75694, 15.60417)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_O = Stream.of(
            Block.makeCuboidShape(7, 15.75694, 7.14583, 9, 15.00694, 8.64583),
            Block.makeCuboidShape(7, 15.50694, 6.89583, 9, 15.75694, 8.89583),
            Block.makeCuboidShape(7, 15.75, 7.15, 9, 16, 8.65),
            Block.makeCuboidShape(7, 16, 7.4, 9, 16.25, 8.4),
            Block.makeCuboidShape(7, 15.25694, 6.64583, 9, 15.50694, 9.14583),
            Block.makeCuboidShape(7, 14.75694, 8.14583, 9, 15.00694, 9.39583),
            Block.makeCuboidShape(7, 14.75694, 6.39583, 9, 15.25694, 9.14583),
            Block.makeCuboidShape(7, 14.25694, 6.14583, 9, 14.75694, 9.64583),
            Block.makeCuboidShape(7, 13.75694, 5.89583, 9, 14.25694, 9.89583),
            Block.makeCuboidShape(7, 13.50694, 5.64583, 9, 13.75694, 10.14583),
            Block.makeCuboidShape(7, 13.00694, 5.39583, 9, 13.50694, 10.39583),
            Block.makeCuboidShape(7, 12.50694, 5.14583, 9, 13.00694, 10.64583),
            Block.makeCuboidShape(7, 12.25694, 4.89583, 9, 12.50694, 10.89583),
            Block.makeCuboidShape(7, 11.75694, 9.89583, 9, 12.00694, 11.14583),
            Block.makeCuboidShape(7, 11.75694, 4.64583, 9, 12.25694, 10.89583),
            Block.makeCuboidShape(7, 11.25694, 4.39583, 9, 11.75694, 11.39583),
            Block.makeCuboidShape(7, 10.75694, 4.14583, 9, 11.25694, 11.64583),
            Block.makeCuboidShape(7, 10.50694, 3.89583, 9, 10.75694, 11.89583),
            Block.makeCuboidShape(7, 10.00694, 10.89583, 9, 10.25694, 12.14583),
            Block.makeCuboidShape(7, 10.00694, 3.64583, 9, 10.50694, 11.89583),
            Block.makeCuboidShape(7, 9.50694, 3.39583, 9, 10.00694, 12.39583),
            Block.makeCuboidShape(7, 9.00694, 3.14583, 9, 9.50694, 12.64583),
            Block.makeCuboidShape(7, 8.75694, 2.89583, 9, 9.00694, 12.89583),
            Block.makeCuboidShape(7, 8.25694, 2.64583, 9, 8.75694, 13.14583),
            Block.makeCuboidShape(7, 7.75694, 2.39583, 9, 8.25694, 13.39583),
            Block.makeCuboidShape(7, 7.50694, 2.14583, 9, 7.75694, 13.64583),
            Block.makeCuboidShape(7, 7.00694, 12.64583, 9, 7.25694, 13.89583),
            Block.makeCuboidShape(14, 0, 7, 15, 2, 9),
            Block.makeCuboidShape(7, 0, 15, 9, 2, 16),
            Block.makeCuboidShape(7, 0, 0, 9, 2, 1),
            Block.makeCuboidShape(1, 0, 7, 2, 2, 9),
            Block.makeCuboidShape(2, 1, 7, 14, 2, 9),
            Block.makeCuboidShape(7, 1, 1, 9, 2, 15),
            Block.makeCuboidShape(7, 2, 7, 9, 3, 9),
            Block.makeCuboidShape(7, 7.00694, 1.8958300000000001, 9, 7.50694, 13.64583),
            Block.makeCuboidShape(7, 6.50694, 1.6458300000000001, 9, 7.00694, 14.14583),
            Block.makeCuboidShape(7, 6.00694, 1.3958300000000001, 9, 6.50694, 14.39583),
            Block.makeCuboidShape(7, 5.75694, 1.1458300000000001, 9, 6.00694, 14.64583),
            Block.makeCuboidShape(7, 5.25694, 13.64583, 9, 5.50694, 14.89583),
            Block.makeCuboidShape(7, 5.25694, 0.8958300000000001, 9, 5.75694, 14.64583),
            Block.makeCuboidShape(7, 4.75694, 0.6458300000000001, 9, 5.25694, 15.14583),
            Block.makeCuboidShape(7, 3.50694, 14.65, 9, 4.00694, 15.9),
            Block.makeCuboidShape(7, 3.25694, 14.39583, 9, 4.25694, 15.64583),
            Block.makeCuboidShape(7, 3.25694, 0.14583000000000013, 9, 4.25694, 1.3958300000000001),
            Block.makeCuboidShape(7, 3.00694, 0.3958300000000001, 9, 4.75694, 15.39583)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7.35417, 15.75694, 7, 8.85417, 15.00694, 9),
            Block.makeCuboidShape(7.10417, 15.50694, 7, 9.10417, 15.75694, 9),
            Block.makeCuboidShape(7.35, 15.75, 7, 8.85, 16, 9),
            Block.makeCuboidShape(7.6, 16, 7, 8.6, 16.25, 9),
            Block.makeCuboidShape(6.85417, 15.25694, 7, 9.35417, 15.50694, 9),
            Block.makeCuboidShape(6.60417, 14.75694, 7, 7.85417, 15.00694, 9),
            Block.makeCuboidShape(6.85417, 14.75694, 7, 9.60417, 15.25694, 9),
            Block.makeCuboidShape(6.35417, 14.25694, 7, 9.85417, 14.75694, 9),
            Block.makeCuboidShape(6.10417, 13.75694, 7, 10.10417, 14.25694, 9),
            Block.makeCuboidShape(5.85417, 13.50694, 7, 10.35417, 13.75694, 9),
            Block.makeCuboidShape(5.60417, 13.00694, 7, 10.60417, 13.50694, 9),
            Block.makeCuboidShape(5.35417, 12.50694, 7, 10.85417, 13.00694, 9),
            Block.makeCuboidShape(5.10417, 12.25694, 7, 11.10417, 12.50694, 9),
            Block.makeCuboidShape(4.85417, 11.75694, 7, 6.10417, 12.00694, 9),
            Block.makeCuboidShape(5.10417, 11.75694, 7, 11.35417, 12.25694, 9),
            Block.makeCuboidShape(4.60417, 11.25694, 7, 11.60417, 11.75694, 9),
            Block.makeCuboidShape(4.35417, 10.75694, 7, 11.85417, 11.25694, 9),
            Block.makeCuboidShape(4.10417, 10.50694, 7, 12.10417, 10.75694, 9),
            Block.makeCuboidShape(3.85417, 10.00694, 7, 5.10417, 10.25694, 9),
            Block.makeCuboidShape(4.10417, 10.00694, 7, 12.35417, 10.50694, 9),
            Block.makeCuboidShape(3.60417, 9.50694, 7, 12.60417, 10.00694, 9),
            Block.makeCuboidShape(3.35417, 9.00694, 7, 12.85417, 9.50694, 9),
            Block.makeCuboidShape(3.10417, 8.75694, 7, 13.10417, 9.00694, 9),
            Block.makeCuboidShape(2.85417, 8.25694, 7, 13.35417, 8.75694, 9),
            Block.makeCuboidShape(2.60417, 7.75694, 7, 13.60417, 8.25694, 9),
            Block.makeCuboidShape(2.35417, 7.50694, 7, 13.85417, 7.75694, 9),
            Block.makeCuboidShape(2.10417, 7.00694, 7, 3.35417, 7.25694, 9),
            Block.makeCuboidShape(7, 0, 14, 9, 2, 15),
            Block.makeCuboidShape(0, 0, 7, 1, 2, 9),
            Block.makeCuboidShape(15, 0, 7, 16, 2, 9),
            Block.makeCuboidShape(7, 0, 1, 9, 2, 2),
            Block.makeCuboidShape(7, 1, 2, 9, 2, 14),
            Block.makeCuboidShape(1, 1, 7, 15, 2, 9),
            Block.makeCuboidShape(7, 2, 7, 9, 3, 9),
            Block.makeCuboidShape(2.35417, 7.00694, 7, 14.10417, 7.50694, 9),
            Block.makeCuboidShape(1.8541699999999999, 6.50694, 7, 14.35417, 7.00694, 9),
            Block.makeCuboidShape(1.6041699999999999, 6.00694, 7, 14.60417, 6.50694, 9),
            Block.makeCuboidShape(1.3541699999999999, 5.75694, 7, 14.85417, 6.00694, 9),
            Block.makeCuboidShape(1.1041699999999999, 5.25694, 7, 2.35417, 5.50694, 9),
            Block.makeCuboidShape(1.3541699999999999, 5.25694, 7, 15.10417, 5.75694, 9),
            Block.makeCuboidShape(0.8541699999999999, 4.75694, 7, 15.35417, 5.25694, 9),
            Block.makeCuboidShape(0.09999999999999964, 3.50694, 7, 1.3499999999999996, 4.00694, 9),
            Block.makeCuboidShape(0.3541699999999999, 3.25694, 7, 1.6041699999999999, 4.25694, 9),
            Block.makeCuboidShape(14.60417, 3.25694, 7, 15.85417, 4.25694, 9),
            Block.makeCuboidShape(0.6041699999999999, 3.00694, 7, 15.60417, 4.75694, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public WarningTriangle(Properties properties)
    {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING))
        {
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_O;
            default:
                return SHAPE_N;
        }
    }
}
