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

public class BaseRectangleSign extends BlockBase
{

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0.5, 0.5, 7, 15.5, 15.75, 9),
            Block.makeCuboidShape(15.5, 0.5, 7, 15.75, 15.5, 9),
            Block.makeCuboidShape(0.25, 0.75, 7, 0.5, 15.25, 9),
            Block.makeCuboidShape(0.75, 0.25, 7, 15.5, 0.5, 9),
            Block.makeCuboidShape(7, 0, 9, 9, 12, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(7, 0.5, 0.5, 9, 15.75, 15.5),
            Block.makeCuboidShape(7, 0.5, 0.25, 9, 15.5, 0.5),
            Block.makeCuboidShape(7, 0.75, 15.5, 9, 15.25, 15.75),
            Block.makeCuboidShape(7, 0.25, 0.5, 9, 0.5, 15.25),
            Block.makeCuboidShape(9, 0, 7, 10, 12, 9)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_O = Stream.of(
            Block.makeCuboidShape(7, 0.5, 0.5, 9, 15.75, 15.5),
            Block.makeCuboidShape(7, 0.5, 15.5, 9, 15.5, 15.75),
            Block.makeCuboidShape(7, 0.75, 0.25, 9, 15.25, 0.5),
            Block.makeCuboidShape(7, 0.25, 0.75, 9, 0.5, 15.5),
            Block.makeCuboidShape(6, 0, 7, 7, 12, 9)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0.5, 0.5, 7, 15.5, 15.75, 9),
            Block.makeCuboidShape(0.25, 0.5, 7, 0.5, 15.5, 9),
            Block.makeCuboidShape(15.5, 0.75, 7, 15.75, 15.25, 9),
            Block.makeCuboidShape(0.5, 0.25, 7, 15.25, 0.5, 9),
            Block.makeCuboidShape(7, 0, 6, 9, 12, 7)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public BaseRectangleSign(Properties properties)
    {
        super(properties);
    }


    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING))
        {
            case NORTH:
                return SHAPE_N;
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
