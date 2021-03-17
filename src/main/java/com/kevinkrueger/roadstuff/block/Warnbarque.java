package com.kevinkrueger.roadstuff.block;

import com.kevinkrueger.roadstuff.BlockBase;
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

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(7, 1, 7, 9, 2, 9),
            Block.makeCuboidShape(8, 13, 7, 8, 15, 9),
            Block.makeCuboidShape(7, 13, 6, 9, 15, 7),
            Block.makeCuboidShape(7, 13, 9, 9, 15, 10),
            Block.makeCuboidShape(7, 15, 6, 9, 16, 10),
            Block.makeCuboidShape(4, 0, 4, 12, 1, 12),
            Block.makeCuboidShape(8, 2, 5.9, 9.1, 13, 6),
            Block.makeCuboidShape(6.9, 2, 5.9, 8, 13, 6),
            Block.makeCuboidShape(8, 2, 10, 9.1, 13, 10.1),
            Block.makeCuboidShape(6.9, 2, 10, 8, 13, 10.1),
            Block.makeCuboidShape(7, 2, 6, 9, 13, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7, 1, 7, 9, 2, 9),
            Block.makeCuboidShape(7, 13, 8, 9, 15, 8),
            Block.makeCuboidShape(6, 13, 7, 7, 15, 9),
            Block.makeCuboidShape(9, 13, 7, 10, 15, 9),
            Block.makeCuboidShape(6, 15, 7, 10, 16, 9),
            Block.makeCuboidShape(4, 0, 4, 12, 1, 12),
            Block.makeCuboidShape(5.9, 2, 6.9, 6, 13, 8),
            Block.makeCuboidShape(5.9, 2, 8, 6, 13, 9.1),
            Block.makeCuboidShape(10, 2, 6.9, 10.1, 13, 8),
            Block.makeCuboidShape(10, 2, 8, 10.1, 13, 9.1),
            Block.makeCuboidShape(6, 2, 7, 10, 13, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_O = Stream.of(
            Block.makeCuboidShape(7, 1, 7, 9, 2, 9),
            Block.makeCuboidShape(8, 13, 7, 8, 15, 9),
            Block.makeCuboidShape(7, 13, 9, 9, 15, 10),
            Block.makeCuboidShape(7, 13, 6, 9, 15, 7),
            Block.makeCuboidShape(7, 15, 6, 9, 16, 10),
            Block.makeCuboidShape(4, 0, 4, 12, 1, 12),
            Block.makeCuboidShape(6.9, 2, 10, 8, 13, 10.1),
            Block.makeCuboidShape(8, 2, 10, 9.1, 13, 10.1),
            Block.makeCuboidShape(6.9, 2, 5.9, 8, 13, 6),
            Block.makeCuboidShape(8, 2, 5.9, 9.1, 13, 6),
            Block.makeCuboidShape(7, 2, 6, 9, 13, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();


    public Warnbarque(Properties properties) {
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
