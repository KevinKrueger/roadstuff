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
            Block.makeCuboidShape(15.75, 7.75, 7, 16, 8.25, 9),
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
            Block.makeCuboidShape(6, 0.25, 7, 7.75, 15.75, 9),
            Block.makeCuboidShape(8.25, 0.25, 7, 10, 15.75, 9),
            Block.makeCuboidShape(7.75, 0.25, 7, 8.25, 16, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(9, 0, 7, 10, 12, 9),
            Block.makeCuboidShape(7, 7.75, 0, 9, 8.25, 0.25),
            Block.makeCuboidShape(7, 6, 15.5, 9, 10, 15.75),
            Block.makeCuboidShape(7, 6, 0.25, 9, 10, 0.5),
            Block.makeCuboidShape(7, 5.25, 15.25, 9, 10.75, 15.5),
            Block.makeCuboidShape(7, 5.25, 0.5, 9, 10.75, 0.75),
            Block.makeCuboidShape(7, 4.75, 15, 9, 11.25, 15.25),
            Block.makeCuboidShape(7, 4.75, 0.75, 9, 11.25, 1),
            Block.makeCuboidShape(7, 4.25, 14.75, 9, 11.75, 15),
            Block.makeCuboidShape(7, 4.25, 1, 9, 11.75, 1.25),
            Block.makeCuboidShape(7, 3.75, 14.5, 9, 12.25, 14.75),
            Block.makeCuboidShape(7, 3.75, 1.25, 9, 12.25, 1.5),
            Block.makeCuboidShape(7, 3.5, 14.25, 9, 12.5, 14.5),
            Block.makeCuboidShape(7, 3.5, 1.5, 9, 12.5, 1.75),
            Block.makeCuboidShape(7, 3, 14, 9, 13, 14.25),
            Block.makeCuboidShape(7, 3, 1.75, 9, 13, 2),
            Block.makeCuboidShape(7, 2.75, 13.75, 9, 13.25, 14),
            Block.makeCuboidShape(7, 2.75, 2, 9, 13.25, 2.25),
            Block.makeCuboidShape(7, 2.5, 13.5, 9, 13.5, 13.75),
            Block.makeCuboidShape(7, 2.5, 2.25, 9, 13.5, 2.5),
            Block.makeCuboidShape(7, 2.25, 13.25, 9, 13.75, 13.5),
            Block.makeCuboidShape(7, 2.25, 2.5, 9, 13.75, 2.75),
            Block.makeCuboidShape(7, 2, 13, 9, 14, 13.25),
            Block.makeCuboidShape(7, 2, 2.75, 9, 14, 3),
            Block.makeCuboidShape(7, 1.75, 12.5, 9, 14.25, 13),
            Block.makeCuboidShape(7, 1.75, 3, 9, 14.25, 3.5),
            Block.makeCuboidShape(7, 1.5, 12.25, 9, 14.5, 12.5),
            Block.makeCuboidShape(7, 1.5, 3.5, 9, 14.5, 3.75),
            Block.makeCuboidShape(7, 1.25, 11.75, 9, 14.75, 12.25),
            Block.makeCuboidShape(7, 1.25, 3.75, 9, 14.75, 4.25),
            Block.makeCuboidShape(7, 1, 11.25, 9, 15, 11.75),
            Block.makeCuboidShape(7, 1, 4.25, 9, 15, 4.75),
            Block.makeCuboidShape(7, 0.75, 10.75, 9, 15.25, 11.25),
            Block.makeCuboidShape(7, 0.75, 4.75, 9, 15.25, 5.25),
            Block.makeCuboidShape(7, 0.5, 10, 9, 15.5, 10.75),
            Block.makeCuboidShape(7, 0.5, 5.25, 9, 15.5, 6),
            Block.makeCuboidShape(7, 0.25, 8.25, 9, 15.75, 10),
            Block.makeCuboidShape(7, 0.25, 6, 9, 15.75, 7.75),
            Block.makeCuboidShape(7, 0.25, 7.75, 9, 16, 8.25)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_O = Stream.of(
            Block.makeCuboidShape(6, 0, 7, 7, 12, 9),
            Block.makeCuboidShape(7, 7.75, 15.75, 9, 8.25, 16),
            Block.makeCuboidShape(7, 6, 0.25, 9, 10, 0.5),
            Block.makeCuboidShape(7, 6, 15.5, 9, 10, 15.75),
            Block.makeCuboidShape(7, 5.25, 0.5, 9, 10.75, 0.75),
            Block.makeCuboidShape(7, 5.25, 15.25, 9, 10.75, 15.5),
            Block.makeCuboidShape(7, 4.75, 0.75, 9, 11.25, 1),
            Block.makeCuboidShape(7, 4.75, 15, 9, 11.25, 15.25),
            Block.makeCuboidShape(7, 4.25, 1, 9, 11.75, 1.25),
            Block.makeCuboidShape(7, 4.25, 14.75, 9, 11.75, 15),
            Block.makeCuboidShape(7, 3.75, 1.25, 9, 12.25, 1.5),
            Block.makeCuboidShape(7, 3.75, 14.5, 9, 12.25, 14.75),
            Block.makeCuboidShape(7, 3.5, 1.5, 9, 12.5, 1.75),
            Block.makeCuboidShape(7, 3.5, 14.25, 9, 12.5, 14.5),
            Block.makeCuboidShape(7, 3, 1.75, 9, 13, 2),
            Block.makeCuboidShape(7, 3, 14, 9, 13, 14.25),
            Block.makeCuboidShape(7, 2.75, 2, 9, 13.25, 2.25),
            Block.makeCuboidShape(7, 2.75, 13.75, 9, 13.25, 14),
            Block.makeCuboidShape(7, 2.5, 2.25, 9, 13.5, 2.5),
            Block.makeCuboidShape(7, 2.5, 13.5, 9, 13.5, 13.75),
            Block.makeCuboidShape(7, 2.25, 2.5, 9, 13.75, 2.75),
            Block.makeCuboidShape(7, 2.25, 13.25, 9, 13.75, 13.5),
            Block.makeCuboidShape(7, 2, 2.75, 9, 14, 3),
            Block.makeCuboidShape(7, 2, 13, 9, 14, 13.25),
            Block.makeCuboidShape(7, 1.75, 3, 9, 14.25, 3.5),
            Block.makeCuboidShape(7, 1.75, 12.5, 9, 14.25, 13),
            Block.makeCuboidShape(7, 1.5, 3.5, 9, 14.5, 3.75),
            Block.makeCuboidShape(7, 1.5, 12.25, 9, 14.5, 12.5),
            Block.makeCuboidShape(7, 1.25, 3.75, 9, 14.75, 4.25),
            Block.makeCuboidShape(7, 1.25, 11.75, 9, 14.75, 12.25),
            Block.makeCuboidShape(7, 1, 4.25, 9, 15, 4.75),
            Block.makeCuboidShape(7, 1, 11.25, 9, 15, 11.75),
            Block.makeCuboidShape(7, 0.75, 4.75, 9, 15.25, 5.25),
            Block.makeCuboidShape(7, 0.75, 10.75, 9, 15.25, 11.25),
            Block.makeCuboidShape(7, 0.5, 5.25, 9, 15.5, 6),
            Block.makeCuboidShape(7, 0.5, 10, 9, 15.5, 10.75),
            Block.makeCuboidShape(7, 0.25, 6, 9, 15.75, 7.75),
            Block.makeCuboidShape(7, 0.25, 8.25, 9, 15.75, 10),
            Block.makeCuboidShape(7, 0.25, 7.75, 9, 16, 8.25)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7, 0, 6, 9, 12, 7),
            Block.makeCuboidShape(0, 7.75, 7, 0.25, 8.25, 9),
            Block.makeCuboidShape(15.5, 6, 7, 15.75, 10, 9),
            Block.makeCuboidShape(0.25, 6, 7, 0.5, 10, 9),
            Block.makeCuboidShape(15.25, 5.25, 7, 15.5, 10.75, 9),
            Block.makeCuboidShape(0.5, 5.25, 7, 0.75, 10.75, 9),
            Block.makeCuboidShape(15, 4.75, 7, 15.25, 11.25, 9),
            Block.makeCuboidShape(0.75, 4.75, 7, 1, 11.25, 9),
            Block.makeCuboidShape(14.75, 4.25, 7, 15, 11.75, 9),
            Block.makeCuboidShape(1, 4.25, 7, 1.25, 11.75, 9),
            Block.makeCuboidShape(14.5, 3.75, 7, 14.75, 12.25, 9),
            Block.makeCuboidShape(1.25, 3.75, 7, 1.5, 12.25, 9),
            Block.makeCuboidShape(14.25, 3.5, 7, 14.5, 12.5, 9),
            Block.makeCuboidShape(1.5, 3.5, 7, 1.75, 12.5, 9),
            Block.makeCuboidShape(14, 3, 7, 14.25, 13, 9),
            Block.makeCuboidShape(1.75, 3, 7, 2, 13, 9),
            Block.makeCuboidShape(13.75, 2.75, 7, 14, 13.25, 9),
            Block.makeCuboidShape(2, 2.75, 7, 2.25, 13.25, 9),
            Block.makeCuboidShape(13.5, 2.5, 7, 13.75, 13.5, 9),
            Block.makeCuboidShape(2.25, 2.5, 7, 2.5, 13.5, 9),
            Block.makeCuboidShape(13.25, 2.25, 7, 13.5, 13.75, 9),
            Block.makeCuboidShape(2.5, 2.25, 7, 2.75, 13.75, 9),
            Block.makeCuboidShape(13, 2, 7, 13.25, 14, 9),
            Block.makeCuboidShape(2.75, 2, 7, 3, 14, 9),
            Block.makeCuboidShape(12.5, 1.75, 7, 13, 14.25, 9),
            Block.makeCuboidShape(3, 1.75, 7, 3.5, 14.25, 9),
            Block.makeCuboidShape(12.25, 1.5, 7, 12.5, 14.5, 9),
            Block.makeCuboidShape(3.5, 1.5, 7, 3.75, 14.5, 9),
            Block.makeCuboidShape(11.75, 1.25, 7, 12.25, 14.75, 9),
            Block.makeCuboidShape(3.75, 1.25, 7, 4.25, 14.75, 9),
            Block.makeCuboidShape(11.25, 1, 7, 11.75, 15, 9),
            Block.makeCuboidShape(4.25, 1, 7, 4.75, 15, 9),
            Block.makeCuboidShape(10.75, 0.75, 7, 11.25, 15.25, 9),
            Block.makeCuboidShape(4.75, 0.75, 7, 5.25, 15.25, 9),
            Block.makeCuboidShape(10, 0.5, 7, 10.75, 15.5, 9),
            Block.makeCuboidShape(5.25, 0.5, 7, 6, 15.5, 9),
            Block.makeCuboidShape(8.25, 0.25, 7, 10, 15.75, 9),
            Block.makeCuboidShape(6, 0.25, 7, 7.75, 15.75, 9),
            Block.makeCuboidShape(7.75, 0.25, 7, 8.25, 16, 9)
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
