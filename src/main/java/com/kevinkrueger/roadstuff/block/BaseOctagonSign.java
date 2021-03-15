package com.kevinkrueger.roadstuff.block;

import com.kevinkrueger.roadstuff.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
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

public class BaseOctagonSign extends BlockBase {


    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 0, 9, 9, 12, 10),
            Block.makeCuboidShape(0.25, 4.5, 7, 0.5, 11.5, 9),
            Block.makeCuboidShape(15.5, 4.5, 7, 15.75, 11.5, 9),
            Block.makeCuboidShape(0.5, 4.25, 7, 0.75, 11.75, 9),
            Block.makeCuboidShape(15.25, 4.25, 7, 15.5, 11.75, 9),
            Block.makeCuboidShape(0.75, 4, 7, 1, 12, 9),
            Block.makeCuboidShape(15, 4, 7, 15.25, 12, 9),
            Block.makeCuboidShape(1, 3.75, 7, 1.25, 12.25, 9),
            Block.makeCuboidShape(14.75, 3.75, 7, 15, 12.25, 9),
            Block.makeCuboidShape(1.25, 3.5, 7, 1.5, 12.5, 9),
            Block.makeCuboidShape(14.5, 3.5, 7, 14.75, 12.5, 9),
            Block.makeCuboidShape(1.5, 3.25, 7, 1.75, 12.75, 9),
            Block.makeCuboidShape(14.25, 3.25, 7, 14.5, 12.75, 9),
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
            Block.makeCuboidShape(3, 1.75, 7, 3.25, 14.25, 9),
            Block.makeCuboidShape(12.75, 1.75, 7, 13, 14.25, 9),
            Block.makeCuboidShape(3.25, 1.5, 7, 3.5, 14.5, 9),
            Block.makeCuboidShape(12.5, 1.5, 7, 12.75, 14.5, 9),
            Block.makeCuboidShape(3.5, 1.25, 7, 3.75, 14.75, 9),
            Block.makeCuboidShape(12.25, 1.25, 7, 12.5, 14.75, 9),
            Block.makeCuboidShape(3.75, 1, 7, 4, 15, 9),
            Block.makeCuboidShape(12, 1, 7, 12.25, 15, 9),
            Block.makeCuboidShape(4, 0.75, 7, 4.25, 15.25, 9),
            Block.makeCuboidShape(11.75, 0.75, 7, 12, 15.25, 9),
            Block.makeCuboidShape(4.25, 0.5, 7, 4.5, 15.5, 9),
            Block.makeCuboidShape(11.5, 0.5, 7, 11.75, 15.5, 9),
            Block.makeCuboidShape(4.5, 0.25, 7, 11.5, 15.75, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(8.958333333333334, 0, 7.041666666666666, 9.958333333333334, 12, 9.041666666666666),
            Block.makeCuboidShape(6.958333333333334, 4.5, 15.541666666666666, 8.958333333333334, 11.5, 15.791666666666666),
            Block.makeCuboidShape(6.958333333333334, 4.5, 0.2916666666666661, 8.958333333333334, 11.5, 0.5416666666666661),
            Block.makeCuboidShape(6.958333333333334, 4.25, 15.291666666666666, 8.958333333333334, 11.75, 15.541666666666666),
            Block.makeCuboidShape(6.958333333333334, 4.25, 0.5416666666666661, 8.958333333333334, 11.75, 0.7916666666666661),
            Block.makeCuboidShape(6.958333333333334, 4, 15.041666666666666, 8.958333333333334, 12, 15.291666666666666),
            Block.makeCuboidShape(6.958333333333334, 4, 0.7916666666666661, 8.958333333333334, 12, 1.041666666666666),
            Block.makeCuboidShape(6.958333333333334, 3.75, 14.791666666666666, 8.958333333333334, 12.25, 15.041666666666666),
            Block.makeCuboidShape(6.958333333333334, 3.75, 1.041666666666666, 8.958333333333334, 12.25, 1.291666666666666),
            Block.makeCuboidShape(6.958333333333334, 3.5, 14.541666666666666, 8.958333333333334, 12.5, 14.791666666666666),
            Block.makeCuboidShape(6.958333333333334, 3.5, 1.291666666666666, 8.958333333333334, 12.5, 1.541666666666666),
            Block.makeCuboidShape(6.958333333333334, 3.25, 14.291666666666666, 8.958333333333334, 12.75, 14.541666666666666),
            Block.makeCuboidShape(6.958333333333334, 3.25, 1.541666666666666, 8.958333333333334, 12.75, 1.791666666666666),
            Block.makeCuboidShape(6.958333333333334, 3, 14.041666666666666, 8.958333333333334, 13, 14.291666666666666),
            Block.makeCuboidShape(6.958333333333334, 3, 1.791666666666666, 8.958333333333334, 13, 2.041666666666666),
            Block.makeCuboidShape(6.958333333333334, 2.75, 13.791666666666666, 8.958333333333334, 13.25, 14.041666666666666),
            Block.makeCuboidShape(6.958333333333334, 2.75, 2.041666666666666, 8.958333333333334, 13.25, 2.291666666666666),
            Block.makeCuboidShape(6.958333333333334, 2.5, 13.541666666666666, 8.958333333333334, 13.5, 13.791666666666666),
            Block.makeCuboidShape(6.958333333333334, 2.5, 2.291666666666666, 8.958333333333334, 13.5, 2.541666666666666),
            Block.makeCuboidShape(6.958333333333334, 2.25, 13.291666666666666, 8.958333333333334, 13.75, 13.541666666666666),
            Block.makeCuboidShape(6.958333333333334, 2.25, 2.541666666666666, 8.958333333333334, 13.75, 2.791666666666666),
            Block.makeCuboidShape(6.958333333333334, 2, 13.041666666666666, 8.958333333333334, 14, 13.291666666666666),
            Block.makeCuboidShape(6.958333333333334, 2, 2.791666666666666, 8.958333333333334, 14, 3.041666666666666),
            Block.makeCuboidShape(6.958333333333334, 1.75, 12.791666666666666, 8.958333333333334, 14.25, 13.041666666666666),
            Block.makeCuboidShape(6.958333333333334, 1.75, 3.041666666666666, 8.958333333333334, 14.25, 3.291666666666666),
            Block.makeCuboidShape(6.958333333333334, 1.5, 12.541666666666666, 8.958333333333334, 14.5, 12.791666666666666),
            Block.makeCuboidShape(6.958333333333334, 1.5, 3.291666666666666, 8.958333333333334, 14.5, 3.541666666666666),
            Block.makeCuboidShape(6.958333333333334, 1.25, 12.291666666666666, 8.958333333333334, 14.75, 12.541666666666666),
            Block.makeCuboidShape(6.958333333333334, 1.25, 3.541666666666666, 8.958333333333334, 14.75, 3.791666666666666),
            Block.makeCuboidShape(6.958333333333334, 1, 12.041666666666666, 8.958333333333334, 15, 12.291666666666666),
            Block.makeCuboidShape(6.958333333333334, 1, 3.791666666666666, 8.958333333333334, 15, 4.041666666666666),
            Block.makeCuboidShape(6.958333333333334, 0.75, 11.791666666666666, 8.958333333333334, 15.25, 12.041666666666666),
            Block.makeCuboidShape(6.958333333333334, 0.75, 4.041666666666666, 8.958333333333334, 15.25, 4.291666666666666),
            Block.makeCuboidShape(6.958333333333334, 0.5, 11.541666666666666, 8.958333333333334, 15.5, 11.791666666666666),
            Block.makeCuboidShape(6.958333333333334, 0.5, 4.291666666666666, 8.958333333333334, 15.5, 4.541666666666666),
            Block.makeCuboidShape(6.958333333333334, 0.25, 4.541666666666666, 8.958333333333334, 15.75, 11.541666666666666)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_O = Stream.of(
            Block.makeCuboidShape(6.041666666666666, 0, 7.041666666666666, 7.041666666666666, 12, 9.041666666666666),
            Block.makeCuboidShape(7.041666666666666, 4.5, 0.2916666666666661, 9.041666666666666, 11.5, 0.5416666666666661),
            Block.makeCuboidShape(7.041666666666666, 4.5, 15.541666666666666, 9.041666666666666, 11.5, 15.791666666666666),
            Block.makeCuboidShape(7.041666666666666, 4.25, 0.5416666666666661, 9.041666666666666, 11.75, 0.7916666666666661),
            Block.makeCuboidShape(7.041666666666666, 4.25, 15.291666666666666, 9.041666666666666, 11.75, 15.541666666666666),
            Block.makeCuboidShape(7.041666666666666, 4, 0.7916666666666661, 9.041666666666666, 12, 1.041666666666666),
            Block.makeCuboidShape(7.041666666666666, 4, 15.041666666666666, 9.041666666666666, 12, 15.291666666666666),
            Block.makeCuboidShape(7.041666666666666, 3.75, 1.041666666666666, 9.041666666666666, 12.25, 1.291666666666666),
            Block.makeCuboidShape(7.041666666666666, 3.75, 14.791666666666666, 9.041666666666666, 12.25, 15.041666666666666),
            Block.makeCuboidShape(7.041666666666666, 3.5, 1.291666666666666, 9.041666666666666, 12.5, 1.541666666666666),
            Block.makeCuboidShape(7.041666666666666, 3.5, 14.541666666666666, 9.041666666666666, 12.5, 14.791666666666666),
            Block.makeCuboidShape(7.041666666666666, 3.25, 1.541666666666666, 9.041666666666666, 12.75, 1.791666666666666),
            Block.makeCuboidShape(7.041666666666666, 3.25, 14.291666666666666, 9.041666666666666, 12.75, 14.541666666666666),
            Block.makeCuboidShape(7.041666666666666, 3, 1.791666666666666, 9.041666666666666, 13, 2.041666666666666),
            Block.makeCuboidShape(7.041666666666666, 3, 14.041666666666666, 9.041666666666666, 13, 14.291666666666666),
            Block.makeCuboidShape(7.041666666666666, 2.75, 2.041666666666666, 9.041666666666666, 13.25, 2.291666666666666),
            Block.makeCuboidShape(7.041666666666666, 2.75, 13.791666666666666, 9.041666666666666, 13.25, 14.041666666666666),
            Block.makeCuboidShape(7.041666666666666, 2.5, 2.291666666666666, 9.041666666666666, 13.5, 2.541666666666666),
            Block.makeCuboidShape(7.041666666666666, 2.5, 13.541666666666666, 9.041666666666666, 13.5, 13.791666666666666),
            Block.makeCuboidShape(7.041666666666666, 2.25, 2.541666666666666, 9.041666666666666, 13.75, 2.791666666666666),
            Block.makeCuboidShape(7.041666666666666, 2.25, 13.291666666666666, 9.041666666666666, 13.75, 13.541666666666666),
            Block.makeCuboidShape(7.041666666666666, 2, 2.791666666666666, 9.041666666666666, 14, 3.041666666666666),
            Block.makeCuboidShape(7.041666666666666, 2, 13.041666666666666, 9.041666666666666, 14, 13.291666666666666),
            Block.makeCuboidShape(7.041666666666666, 1.75, 3.041666666666666, 9.041666666666666, 14.25, 3.291666666666666),
            Block.makeCuboidShape(7.041666666666666, 1.75, 12.791666666666666, 9.041666666666666, 14.25, 13.041666666666666),
            Block.makeCuboidShape(7.041666666666666, 1.5, 3.291666666666666, 9.041666666666666, 14.5, 3.541666666666666),
            Block.makeCuboidShape(7.041666666666666, 1.5, 12.541666666666666, 9.041666666666666, 14.5, 12.791666666666666),
            Block.makeCuboidShape(7.041666666666666, 1.25, 3.541666666666666, 9.041666666666666, 14.75, 3.791666666666666),
            Block.makeCuboidShape(7.041666666666666, 1.25, 12.291666666666666, 9.041666666666666, 14.75, 12.541666666666666),
            Block.makeCuboidShape(7.041666666666666, 1, 3.791666666666666, 9.041666666666666, 15, 4.041666666666666),
            Block.makeCuboidShape(7.041666666666666, 1, 12.041666666666666, 9.041666666666666, 15, 12.291666666666666),
            Block.makeCuboidShape(7.041666666666666, 0.75, 4.041666666666666, 9.041666666666666, 15.25, 4.291666666666666),
            Block.makeCuboidShape(7.041666666666666, 0.75, 11.791666666666666, 9.041666666666666, 15.25, 12.041666666666666),
            Block.makeCuboidShape(7.041666666666666, 0.5, 4.291666666666666, 9.041666666666666, 15.5, 4.541666666666666),
            Block.makeCuboidShape(7.041666666666666, 0.5, 11.541666666666666, 9.041666666666666, 15.5, 11.791666666666666),
            Block.makeCuboidShape(7.041666666666666, 0.25, 4.541666666666666, 9.041666666666666, 15.75, 11.541666666666666)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7, 0, 6.083333333333332, 9, 12, 7.083333333333332),
            Block.makeCuboidShape(15.5, 4.5, 7.083333333333332, 15.75, 11.5, 9.083333333333332),
            Block.makeCuboidShape(0.25, 4.5, 7.083333333333332, 0.5, 11.5, 9.083333333333332),
            Block.makeCuboidShape(15.25, 4.25, 7.083333333333332, 15.5, 11.75, 9.083333333333332),
            Block.makeCuboidShape(0.5, 4.25, 7.083333333333332, 0.75, 11.75, 9.083333333333332),
            Block.makeCuboidShape(15, 4, 7.083333333333332, 15.25, 12, 9.083333333333332),
            Block.makeCuboidShape(0.75, 4, 7.083333333333332, 1, 12, 9.083333333333332),
            Block.makeCuboidShape(14.75, 3.75, 7.083333333333332, 15, 12.25, 9.083333333333332),
            Block.makeCuboidShape(1, 3.75, 7.083333333333332, 1.25, 12.25, 9.083333333333332),
            Block.makeCuboidShape(14.5, 3.5, 7.083333333333332, 14.75, 12.5, 9.083333333333332),
            Block.makeCuboidShape(1.25, 3.5, 7.083333333333332, 1.5, 12.5, 9.083333333333332),
            Block.makeCuboidShape(14.25, 3.25, 7.083333333333332, 14.5, 12.75, 9.083333333333332),
            Block.makeCuboidShape(1.5, 3.25, 7.083333333333332, 1.75, 12.75, 9.083333333333332),
            Block.makeCuboidShape(14, 3, 7.083333333333332, 14.25, 13, 9.083333333333332),
            Block.makeCuboidShape(1.75, 3, 7.083333333333332, 2, 13, 9.083333333333332),
            Block.makeCuboidShape(13.75, 2.75, 7.083333333333332, 14, 13.25, 9.083333333333332),
            Block.makeCuboidShape(2, 2.75, 7.083333333333332, 2.25, 13.25, 9.083333333333332),
            Block.makeCuboidShape(13.5, 2.5, 7.083333333333332, 13.75, 13.5, 9.083333333333332),
            Block.makeCuboidShape(2.25, 2.5, 7.083333333333332, 2.5, 13.5, 9.083333333333332),
            Block.makeCuboidShape(13.25, 2.25, 7.083333333333332, 13.5, 13.75, 9.083333333333332),
            Block.makeCuboidShape(2.5, 2.25, 7.083333333333332, 2.75, 13.75, 9.083333333333332),
            Block.makeCuboidShape(13, 2, 7.083333333333332, 13.25, 14, 9.083333333333332),
            Block.makeCuboidShape(2.75, 2, 7.083333333333332, 3, 14, 9.083333333333332),
            Block.makeCuboidShape(12.75, 1.75, 7.083333333333332, 13, 14.25, 9.083333333333332),
            Block.makeCuboidShape(3, 1.75, 7.083333333333332, 3.25, 14.25, 9.083333333333332),
            Block.makeCuboidShape(12.5, 1.5, 7.083333333333332, 12.75, 14.5, 9.083333333333332),
            Block.makeCuboidShape(3.25, 1.5, 7.083333333333332, 3.5, 14.5, 9.083333333333332),
            Block.makeCuboidShape(12.25, 1.25, 7.083333333333332, 12.5, 14.75, 9.083333333333332),
            Block.makeCuboidShape(3.5, 1.25, 7.083333333333332, 3.75, 14.75, 9.083333333333332),
            Block.makeCuboidShape(12, 1, 7.083333333333332, 12.25, 15, 9.083333333333332),
            Block.makeCuboidShape(3.75, 1, 7.083333333333332, 4, 15, 9.083333333333332),
            Block.makeCuboidShape(11.75, 0.75, 7.083333333333332, 12, 15.25, 9.083333333333332),
            Block.makeCuboidShape(4, 0.75, 7.083333333333332, 4.25, 15.25, 9.083333333333332),
            Block.makeCuboidShape(11.5, 0.5, 7.083333333333332, 11.75, 15.5, 9.083333333333332),
            Block.makeCuboidShape(4.25, 0.5, 7.083333333333332, 4.5, 15.5, 9.083333333333332),
            Block.makeCuboidShape(4.5, 0.25, 7.083333333333332, 11.5, 15.75, 9.083333333333332)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public BaseOctagonSign(Properties properties) {
        super(properties);
    }
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
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
