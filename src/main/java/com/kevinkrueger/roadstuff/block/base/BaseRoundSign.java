package com.kevinkrueger.roadstuff.block.base;

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

public class BaseRoundSign extends BlockBase {
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

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(8.95945945945946, 0, 7.04054054054054, 9.95945945945946, 12, 9.04054054054054),
            Block.makeCuboidShape(6.95945945945946, 0, 7.79054054054054, 8.95945945945946, 0.25, 8.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 6, 15.54054054054054, 8.95945945945946, 10, 15.79054054054054),
            Block.makeCuboidShape(6.95945945945946, 6, 0.29054054054054035, 8.95945945945946, 10, 0.5405405405405403),
            Block.makeCuboidShape(6.95945945945946, 5.25, 15.29054054054054, 8.95945945945946, 10.75, 15.54054054054054),
            Block.makeCuboidShape(6.95945945945946, 5.25, 0.5405405405405403, 8.95945945945946, 10.75, 0.7905405405405403),
            Block.makeCuboidShape(6.95945945945946, 4.75, 15.04054054054054, 8.95945945945946, 11.25, 15.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 4.75, 0.7905405405405403, 8.95945945945946, 11.25, 1.0405405405405403),
            Block.makeCuboidShape(6.95945945945946, 4.25, 14.79054054054054, 8.95945945945946, 11.75, 15.04054054054054),
            Block.makeCuboidShape(6.95945945945946, 4.25, 1.0405405405405403, 8.95945945945946, 11.75, 1.2905405405405403),
            Block.makeCuboidShape(6.95945945945946, 3.75, 14.54054054054054, 8.95945945945946, 12.25, 14.79054054054054),
            Block.makeCuboidShape(6.95945945945946, 3.75, 1.2905405405405403, 8.95945945945946, 12.25, 1.5405405405405403),
            Block.makeCuboidShape(6.95945945945946, 3.5, 14.29054054054054, 8.95945945945946, 12.5, 14.54054054054054),
            Block.makeCuboidShape(6.95945945945946, 3.5, 1.5405405405405403, 8.95945945945946, 12.5, 1.7905405405405403),
            Block.makeCuboidShape(6.95945945945946, 3, 14.04054054054054, 8.95945945945946, 13, 14.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 3, 1.7905405405405403, 8.95945945945946, 13, 2.0405405405405403),
            Block.makeCuboidShape(6.95945945945946, 2.75, 13.79054054054054, 8.95945945945946, 13.25, 14.04054054054054),
            Block.makeCuboidShape(6.95945945945946, 2.75, 2.0405405405405403, 8.95945945945946, 13.25, 2.2905405405405403),
            Block.makeCuboidShape(6.95945945945946, 2.5, 13.54054054054054, 8.95945945945946, 13.5, 13.79054054054054),
            Block.makeCuboidShape(6.95945945945946, 2.5, 2.2905405405405403, 8.95945945945946, 13.5, 2.5405405405405403),
            Block.makeCuboidShape(6.95945945945946, 2.25, 13.29054054054054, 8.95945945945946, 13.75, 13.54054054054054),
            Block.makeCuboidShape(6.95945945945946, 2.25, 2.5405405405405403, 8.95945945945946, 13.75, 2.7905405405405403),
            Block.makeCuboidShape(6.95945945945946, 2, 13.04054054054054, 8.95945945945946, 14, 13.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 2, 2.7905405405405403, 8.95945945945946, 14, 3.0405405405405403),
            Block.makeCuboidShape(6.95945945945946, 1.75, 12.54054054054054, 8.95945945945946, 14.25, 13.04054054054054),
            Block.makeCuboidShape(6.95945945945946, 1.75, 3.0405405405405403, 8.95945945945946, 14.25, 3.5405405405405403),
            Block.makeCuboidShape(6.95945945945946, 1.5, 12.29054054054054, 8.95945945945946, 14.5, 12.54054054054054),
            Block.makeCuboidShape(6.95945945945946, 1.5, 3.5405405405405403, 8.95945945945946, 14.5, 3.7905405405405403),
            Block.makeCuboidShape(6.95945945945946, 1.25, 11.79054054054054, 8.95945945945946, 14.75, 12.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 1.25, 3.7905405405405403, 8.95945945945946, 14.75, 4.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 1, 11.29054054054054, 8.95945945945946, 15, 11.79054054054054),
            Block.makeCuboidShape(6.95945945945946, 1, 4.29054054054054, 8.95945945945946, 15, 4.79054054054054),
            Block.makeCuboidShape(6.95945945945946, 0.75, 10.79054054054054, 8.95945945945946, 15.25, 11.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 0.75, 4.79054054054054, 8.95945945945946, 15.25, 5.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 0.5, 10.04054054054054, 8.95945945945946, 15.5, 10.79054054054054),
            Block.makeCuboidShape(6.95945945945946, 0.5, 5.29054054054054, 8.95945945945946, 15.5, 6.04054054054054),
            Block.makeCuboidShape(6.95945945945946, 0.25, 6.04054054054054, 8.95945945945946, 15.75, 10.04054054054054)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_O = Stream.of(
            Block.makeCuboidShape(6.04054054054054, 0, 7.04054054054054, 7.04054054054054, 12, 9.04054054054054),
            Block.makeCuboidShape(7.04054054054054, 0, 7.79054054054054, 9.04054054054054, 0.25, 8.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 6, 0.29054054054054035, 9.04054054054054, 10, 0.5405405405405403),
            Block.makeCuboidShape(7.04054054054054, 6, 15.54054054054054, 9.04054054054054, 10, 15.79054054054054),
            Block.makeCuboidShape(7.04054054054054, 5.25, 0.5405405405405403, 9.04054054054054, 10.75, 0.7905405405405403),
            Block.makeCuboidShape(7.04054054054054, 5.25, 15.29054054054054, 9.04054054054054, 10.75, 15.54054054054054),
            Block.makeCuboidShape(7.04054054054054, 4.75, 0.7905405405405403, 9.04054054054054, 11.25, 1.0405405405405403),
            Block.makeCuboidShape(7.04054054054054, 4.75, 15.04054054054054, 9.04054054054054, 11.25, 15.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 4.25, 1.0405405405405403, 9.04054054054054, 11.75, 1.2905405405405403),
            Block.makeCuboidShape(7.04054054054054, 4.25, 14.79054054054054, 9.04054054054054, 11.75, 15.04054054054054),
            Block.makeCuboidShape(7.04054054054054, 3.75, 1.2905405405405403, 9.04054054054054, 12.25, 1.5405405405405403),
            Block.makeCuboidShape(7.04054054054054, 3.75, 14.54054054054054, 9.04054054054054, 12.25, 14.79054054054054),
            Block.makeCuboidShape(7.04054054054054, 3.5, 1.5405405405405403, 9.04054054054054, 12.5, 1.7905405405405403),
            Block.makeCuboidShape(7.04054054054054, 3.5, 14.29054054054054, 9.04054054054054, 12.5, 14.54054054054054),
            Block.makeCuboidShape(7.04054054054054, 3, 1.7905405405405403, 9.04054054054054, 13, 2.0405405405405403),
            Block.makeCuboidShape(7.04054054054054, 3, 14.04054054054054, 9.04054054054054, 13, 14.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 2.75, 2.0405405405405403, 9.04054054054054, 13.25, 2.2905405405405403),
            Block.makeCuboidShape(7.04054054054054, 2.75, 13.79054054054054, 9.04054054054054, 13.25, 14.04054054054054),
            Block.makeCuboidShape(7.04054054054054, 2.5, 2.2905405405405403, 9.04054054054054, 13.5, 2.5405405405405403),
            Block.makeCuboidShape(7.04054054054054, 2.5, 13.54054054054054, 9.04054054054054, 13.5, 13.79054054054054),
            Block.makeCuboidShape(7.04054054054054, 2.25, 2.5405405405405403, 9.04054054054054, 13.75, 2.7905405405405403),
            Block.makeCuboidShape(7.04054054054054, 2.25, 13.29054054054054, 9.04054054054054, 13.75, 13.54054054054054),
            Block.makeCuboidShape(7.04054054054054, 2, 2.7905405405405403, 9.04054054054054, 14, 3.0405405405405403),
            Block.makeCuboidShape(7.04054054054054, 2, 13.04054054054054, 9.04054054054054, 14, 13.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 1.75, 3.0405405405405403, 9.04054054054054, 14.25, 3.5405405405405403),
            Block.makeCuboidShape(7.04054054054054, 1.75, 12.54054054054054, 9.04054054054054, 14.25, 13.04054054054054),
            Block.makeCuboidShape(7.04054054054054, 1.5, 3.5405405405405403, 9.04054054054054, 14.5, 3.7905405405405403),
            Block.makeCuboidShape(7.04054054054054, 1.5, 12.29054054054054, 9.04054054054054, 14.5, 12.54054054054054),
            Block.makeCuboidShape(7.04054054054054, 1.25, 3.7905405405405403, 9.04054054054054, 14.75, 4.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 1.25, 11.79054054054054, 9.04054054054054, 14.75, 12.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 1, 4.29054054054054, 9.04054054054054, 15, 4.79054054054054),
            Block.makeCuboidShape(7.04054054054054, 1, 11.29054054054054, 9.04054054054054, 15, 11.79054054054054),
            Block.makeCuboidShape(7.04054054054054, 0.75, 4.79054054054054, 9.04054054054054, 15.25, 5.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 0.75, 10.79054054054054, 9.04054054054054, 15.25, 11.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 0.5, 5.29054054054054, 9.04054054054054, 15.5, 6.04054054054054),
            Block.makeCuboidShape(7.04054054054054, 0.5, 10.04054054054054, 9.04054054054054, 15.5, 10.79054054054054),
            Block.makeCuboidShape(7.04054054054054, 0.25, 6.04054054054054, 9.04054054054054, 15.75, 10.04054054054054)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7, 0, 6.081081081081081, 9, 12, 7.081081081081081),
            Block.makeCuboidShape(7.75, 0, 7.081081081081081, 8.25, 0.25, 9.08108108108108),
            Block.makeCuboidShape(15.5, 6, 7.081081081081081, 15.75, 10, 9.08108108108108),
            Block.makeCuboidShape(0.25, 6, 7.081081081081081, 0.5, 10, 9.08108108108108),
            Block.makeCuboidShape(15.25, 5.25, 7.081081081081081, 15.5, 10.75, 9.08108108108108),
            Block.makeCuboidShape(0.5, 5.25, 7.081081081081081, 0.75, 10.75, 9.08108108108108),
            Block.makeCuboidShape(15, 4.75, 7.081081081081081, 15.25, 11.25, 9.08108108108108),
            Block.makeCuboidShape(0.75, 4.75, 7.081081081081081, 1, 11.25, 9.08108108108108),
            Block.makeCuboidShape(14.75, 4.25, 7.081081081081081, 15, 11.75, 9.08108108108108),
            Block.makeCuboidShape(1, 4.25, 7.081081081081081, 1.25, 11.75, 9.08108108108108),
            Block.makeCuboidShape(14.5, 3.75, 7.081081081081081, 14.75, 12.25, 9.08108108108108),
            Block.makeCuboidShape(1.25, 3.75, 7.081081081081081, 1.5, 12.25, 9.08108108108108),
            Block.makeCuboidShape(14.25, 3.5, 7.081081081081081, 14.5, 12.5, 9.08108108108108),
            Block.makeCuboidShape(1.5, 3.5, 7.081081081081081, 1.75, 12.5, 9.08108108108108),
            Block.makeCuboidShape(14, 3, 7.081081081081081, 14.25, 13, 9.08108108108108),
            Block.makeCuboidShape(1.75, 3, 7.081081081081081, 2, 13, 9.08108108108108),
            Block.makeCuboidShape(13.75, 2.75, 7.081081081081081, 14, 13.25, 9.08108108108108),
            Block.makeCuboidShape(2, 2.75, 7.081081081081081, 2.25, 13.25, 9.08108108108108),
            Block.makeCuboidShape(13.5, 2.5, 7.081081081081081, 13.75, 13.5, 9.08108108108108),
            Block.makeCuboidShape(2.25, 2.5, 7.081081081081081, 2.5, 13.5, 9.08108108108108),
            Block.makeCuboidShape(13.25, 2.25, 7.081081081081081, 13.5, 13.75, 9.08108108108108),
            Block.makeCuboidShape(2.5, 2.25, 7.081081081081081, 2.75, 13.75, 9.08108108108108),
            Block.makeCuboidShape(13, 2, 7.081081081081081, 13.25, 14, 9.08108108108108),
            Block.makeCuboidShape(2.75, 2, 7.081081081081081, 3, 14, 9.08108108108108),
            Block.makeCuboidShape(12.5, 1.75, 7.081081081081081, 13, 14.25, 9.08108108108108),
            Block.makeCuboidShape(3, 1.75, 7.081081081081081, 3.5, 14.25, 9.08108108108108),
            Block.makeCuboidShape(12.25, 1.5, 7.081081081081081, 12.5, 14.5, 9.08108108108108),
            Block.makeCuboidShape(3.5, 1.5, 7.081081081081081, 3.75, 14.5, 9.08108108108108),
            Block.makeCuboidShape(11.75, 1.25, 7.081081081081081, 12.25, 14.75, 9.08108108108108),
            Block.makeCuboidShape(3.75, 1.25, 7.081081081081081, 4.25, 14.75, 9.08108108108108),
            Block.makeCuboidShape(11.25, 1, 7.081081081081081, 11.75, 15, 9.08108108108108),
            Block.makeCuboidShape(4.25, 1, 7.081081081081081, 4.75, 15, 9.08108108108108),
            Block.makeCuboidShape(10.75, 0.75, 7.081081081081081, 11.25, 15.25, 9.08108108108108),
            Block.makeCuboidShape(4.75, 0.75, 7.081081081081081, 5.25, 15.25, 9.08108108108108),
            Block.makeCuboidShape(10, 0.5, 7.081081081081081, 10.75, 15.5, 9.08108108108108),
            Block.makeCuboidShape(5.25, 0.5, 7.081081081081081, 6, 15.5, 9.08108108108108),
            Block.makeCuboidShape(6, 0.25, 7.081081081081081, 10, 15.75, 9.08108108108108)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public BaseRoundSign(Properties properties) {
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
