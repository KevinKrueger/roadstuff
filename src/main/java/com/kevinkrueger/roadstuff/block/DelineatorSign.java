package com.kevinkrueger.roadstuff.block;

import com.kevinkrueger.roadstuff.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class DelineatorSign extends BlockBase
{

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7.6875, 0, 7, 7.8125, 15.3125, 9),
            Block.makeCuboidShape(9.0625, 0, 7, 9.125, 14.5, 9),
            Block.makeCuboidShape(9, 0, 7, 9.0625, 14.5625, 9),
            Block.makeCuboidShape(8.875, 0, 7, 9, 14.625, 9),
            Block.makeCuboidShape(8.75, 0, 7, 8.875, 14.6875, 9),
            Block.makeCuboidShape(8.6875, 0, 7, 8.75, 14.75, 9),
            Block.makeCuboidShape(8.5625, 0, 7, 8.6875, 14.8125, 9),
            Block.makeCuboidShape(8.4375, 0, 7, 8.5625, 14.875, 9),
            Block.makeCuboidShape(8.375, 0, 7, 8.4375, 14.9375, 9),
            Block.makeCuboidShape(8.25, 0, 7, 8.375, 15, 9),
            Block.makeCuboidShape(8.125, 0, 7, 8.25, 15.0625, 9),
            Block.makeCuboidShape(8, 0, 7, 8.125, 15.125, 9),
            Block.makeCuboidShape(7.875, 0, 7, 8, 15.1875, 9),
            Block.makeCuboidShape(7.8125, 0, 7, 7.875, 15.25, 9),
            Block.makeCuboidShape(7.5625, 0, 7, 7.6875, 15.375, 9),
            Block.makeCuboidShape(7.4375, 0, 7, 7.5625, 15.4375, 9),
            Block.makeCuboidShape(7.3125, 0, 7, 7.4375, 15.5, 9),
            Block.makeCuboidShape(7.25, 0, 7, 7.3125, 15.5625, 9),
            Block.makeCuboidShape(6.875, 0, 7, 6.9375, 15.625, 9),
            Block.makeCuboidShape(7, 0, 7, 7.0625, 15.625, 9),
            Block.makeCuboidShape(7.125, 0, 7, 7.25, 15.625, 9),
            Block.makeCuboidShape(6.9375, 0, 7, 7, 15.6875, 9),
            Block.makeCuboidShape(7.0625, 0, 7, 7.125, 15.6875, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(7, 0, 8.1875, 9, 15.3125, 8.3125),
            Block.makeCuboidShape(7, 0, 6.875, 9, 14.5, 6.9375),
            Block.makeCuboidShape(7, 0, 6.9375, 9, 14.5625, 7),
            Block.makeCuboidShape(7, 0, 7, 9, 14.625, 7.125),
            Block.makeCuboidShape(7, 0, 7.125, 9, 14.6875, 7.25),
            Block.makeCuboidShape(7, 0, 7.25, 9, 14.75, 7.3125),
            Block.makeCuboidShape(7, 0, 7.3125, 9, 14.8125, 7.4375),
            Block.makeCuboidShape(7, 0, 7.4375, 9, 14.875, 7.5625),
            Block.makeCuboidShape(7, 0, 7.5625, 9, 14.9375, 7.625),
            Block.makeCuboidShape(7, 0, 7.625, 9, 15, 7.75),
            Block.makeCuboidShape(7, 0, 7.75, 9, 15.0625, 7.875),
            Block.makeCuboidShape(7, 0, 7.875, 9, 15.125, 8),
            Block.makeCuboidShape(7, 0, 8, 9, 15.1875, 8.125),
            Block.makeCuboidShape(7, 0, 8.125, 9, 15.25, 8.1875),
            Block.makeCuboidShape(7, 0, 8.3125, 9, 15.375, 8.4375),
            Block.makeCuboidShape(7, 0, 8.4375, 9, 15.4375, 8.5625),
            Block.makeCuboidShape(7, 0, 8.5625, 9, 15.5, 8.6875),
            Block.makeCuboidShape(7, 0, 8.6875, 9, 15.5625, 8.75),
            Block.makeCuboidShape(7, 0, 9.0625, 9, 15.625, 9.125),
            Block.makeCuboidShape(7, 0, 8.9375, 9, 15.625, 9),
            Block.makeCuboidShape(7, 0, 8.75, 9, 15.625, 8.875),
            Block.makeCuboidShape(7, 0, 9, 9, 15.6875, 9.0625),
            Block.makeCuboidShape(7, 0, 8.875, 9, 15.6875, 8.9375)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_O = Stream.of(
            Block.makeCuboidShape(7, 0, 7.6875, 9, 15.3125, 7.8125),
            Block.makeCuboidShape(7, 0, 9.0625, 9, 14.5, 9.125),
            Block.makeCuboidShape(7, 0, 9, 9, 14.5625, 9.0625),
            Block.makeCuboidShape(7, 0, 8.875, 9, 14.625, 9),
            Block.makeCuboidShape(7, 0, 8.75, 9, 14.6875, 8.875),
            Block.makeCuboidShape(7, 0, 8.6875, 9, 14.75, 8.75),
            Block.makeCuboidShape(7, 0, 8.5625, 9, 14.8125, 8.6875),
            Block.makeCuboidShape(7, 0, 8.4375, 9, 14.875, 8.5625),
            Block.makeCuboidShape(7, 0, 8.375, 9, 14.9375, 8.4375),
            Block.makeCuboidShape(7, 0, 8.25, 9, 15, 8.375),
            Block.makeCuboidShape(7, 0, 8.125, 9, 15.0625, 8.25),
            Block.makeCuboidShape(7, 0, 8, 9, 15.125, 8.125),
            Block.makeCuboidShape(7, 0, 7.875, 9, 15.1875, 8),
            Block.makeCuboidShape(7, 0, 7.8125, 9, 15.25, 7.875),
            Block.makeCuboidShape(7, 0, 7.5625, 9, 15.375, 7.6875),
            Block.makeCuboidShape(7, 0, 7.4375, 9, 15.4375, 7.5625),
            Block.makeCuboidShape(7, 0, 7.3125, 9, 15.5, 7.4375),
            Block.makeCuboidShape(7, 0, 7.25, 9, 15.5625, 7.3125),
            Block.makeCuboidShape(7, 0, 6.875, 9, 15.625, 6.9375),
            Block.makeCuboidShape(7, 0, 7, 9, 15.625, 7.0625),
            Block.makeCuboidShape(7, 0, 7.125, 9, 15.625, 7.25),
            Block.makeCuboidShape(7, 0, 6.9375, 9, 15.6875, 7),
            Block.makeCuboidShape(7, 0, 7.0625, 9, 15.6875, 7.125)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(8.1875, 0, 7, 8.3125, 15.3125, 9),
            Block.makeCuboidShape(6.875, 0, 7, 6.9375, 14.5, 9),
            Block.makeCuboidShape(6.9375, 0, 7, 7, 14.5625, 9),
            Block.makeCuboidShape(7, 0, 7, 7.125, 14.625, 9),
            Block.makeCuboidShape(7.125, 0, 7, 7.25, 14.6875, 9),
            Block.makeCuboidShape(7.25, 0, 7, 7.3125, 14.75, 9),
            Block.makeCuboidShape(7.3125, 0, 7, 7.4375, 14.8125, 9),
            Block.makeCuboidShape(7.4375, 0, 7, 7.5625, 14.875, 9),
            Block.makeCuboidShape(7.5625, 0, 7, 7.625, 14.9375, 9),
            Block.makeCuboidShape(7.625, 0, 7, 7.75, 15, 9),
            Block.makeCuboidShape(7.75, 0, 7, 7.875, 15.0625, 9),
            Block.makeCuboidShape(7.875, 0, 7, 8, 15.125, 9),
            Block.makeCuboidShape(8, 0, 7, 8.125, 15.1875, 9),
            Block.makeCuboidShape(8.125, 0, 7, 8.1875, 15.25, 9),
            Block.makeCuboidShape(8.3125, 0, 7, 8.4375, 15.375, 9),
            Block.makeCuboidShape(8.4375, 0, 7, 8.5625, 15.4375, 9),
            Block.makeCuboidShape(8.5625, 0, 7, 8.6875, 15.5, 9),
            Block.makeCuboidShape(8.6875, 0, 7, 8.75, 15.5625, 9),
            Block.makeCuboidShape(9.0625, 0, 7, 9.125, 15.625, 9),
            Block.makeCuboidShape(8.9375, 0, 7, 9, 15.625, 9),
            Block.makeCuboidShape(8.75, 0, 7, 8.875, 15.625, 9),
            Block.makeCuboidShape(9, 0, 7, 9.0625, 15.6875, 9),
            Block.makeCuboidShape(8.875, 0, 7, 8.9375, 15.6875, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();




    public DelineatorSign(Properties properties)
    {
        super(properties);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
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

    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation rot)
    {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn)
    {
        return state.rotate(mirrorIn.toRotation((state.get(FACING))));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }
}
