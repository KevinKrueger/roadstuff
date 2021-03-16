package com.kevinkrueger.roadstuff.block;

import com.kevinkrueger.roadstuff.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class StreetLight extends BlockBase
{
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 0, 8, 9, 16, 10),
            Block.makeCuboidShape(7, 13, 4, 9, 15, 8),
            Block.makeCuboidShape(6, 13, 0, 10, 15, 1),
            Block.makeCuboidShape(6, 13, 3, 10, 15, 4),
            Block.makeCuboidShape(6, 13, 1, 7, 15, 3),
            Block.makeCuboidShape(9, 13, 1, 10, 15, 3),
            Block.makeCuboidShape(6, 15, 0, 10, 16, 4),
            Block.makeCuboidShape(7, 14, 1, 9, 15, 3)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(8, 0, 7, 10, 16, 9),
            Block.makeCuboidShape(4, 13, 7, 8, 15, 9),
            Block.makeCuboidShape(0, 13, 6, 1, 15, 10),
            Block.makeCuboidShape(3, 13, 6, 4, 15, 10),
            Block.makeCuboidShape(1, 13, 9, 3, 15, 10),
            Block.makeCuboidShape(1, 13, 6, 3, 15, 7),
            Block.makeCuboidShape(0, 15, 6, 4, 16, 10),
            Block.makeCuboidShape(1, 14, 7, 3, 15, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_O = Stream.of(
            Block.makeCuboidShape(6, 0, 7, 8, 16, 9),
            Block.makeCuboidShape(8, 13, 7, 12, 15, 9),
            Block.makeCuboidShape(15, 13, 6, 16, 15, 10),
            Block.makeCuboidShape(12, 13, 6, 13, 15, 10),
            Block.makeCuboidShape(13, 13, 6, 15, 15, 7),
            Block.makeCuboidShape(13, 13, 9, 15, 15, 10),
            Block.makeCuboidShape(12, 15, 6, 16, 16, 10),
            Block.makeCuboidShape(13, 14, 7, 15, 15, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7, 0, 6, 9, 16, 8),
            Block.makeCuboidShape(7, 13, 8, 9, 15, 12),
            Block.makeCuboidShape(6, 13, 15, 10, 15, 16),
            Block.makeCuboidShape(6, 13, 12, 10, 15, 13),
            Block.makeCuboidShape(9, 13, 13, 10, 15, 15),
            Block.makeCuboidShape(6, 13, 13, 7, 15, 15),
            Block.makeCuboidShape(6, 15, 12, 10, 16, 16),
            Block.makeCuboidShape(7, 14, 13, 9, 15, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public StreetLight(Properties properties)
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
