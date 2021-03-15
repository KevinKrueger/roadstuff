package com.kevinkrueger.roadstuff.block;

import com.kevinkrueger.roadstuff.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
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

public class BaseInvertedTriangleSign extends BlockBase
{
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 0, 9, 9, 12, 10),
            Block.makeCuboidShape(7.75, 1.5, 7, 8.25, 1.75, 9),
            Block.makeCuboidShape(7.5, 1.75, 7, 8.5, 2, 9),
            Block.makeCuboidShape(7.25, 2, 7, 8.75, 2.25, 9),
            Block.makeCuboidShape(7, 2.5, 7, 7.25, 2.75, 9),
            Block.makeCuboidShape(7.25, 2.25, 7, 9, 2.75, 9),
            Block.makeCuboidShape(6.75, 2.75, 7, 9.25, 3.25, 9),
            Block.makeCuboidShape(6.5, 3.25, 7, 9.5, 3.75, 9),
            Block.makeCuboidShape(6.25, 3.75, 7, 9.75, 4, 9),
            Block.makeCuboidShape(6, 4, 7, 10, 4.5, 9),
            Block.makeCuboidShape(5.75, 4.5, 7, 10.25, 5, 9),
            Block.makeCuboidShape(5.5, 5, 7, 10.5, 5.25, 9),
            Block.makeCuboidShape(5.25, 5.5, 7, 5.5, 5.75, 9),
            Block.makeCuboidShape(5.5, 5.25, 7, 10.75, 5.75, 9),
            Block.makeCuboidShape(5, 5.75, 7, 11, 6.25, 9),
            Block.makeCuboidShape(4.75, 6.25, 7, 11.25, 6.75, 9),
            Block.makeCuboidShape(4.5, 6.75, 7, 11.5, 7, 9),
            Block.makeCuboidShape(4.25, 7.25, 7, 4.5, 7.5, 9),
            Block.makeCuboidShape(4.5, 7, 7, 11.75, 7.5, 9),
            Block.makeCuboidShape(4, 7.5, 7, 12, 8, 9),
            Block.makeCuboidShape(3.75, 8, 7, 12.25, 8.5, 9),
            Block.makeCuboidShape(3.5, 8.5, 7, 12.5, 8.75, 9),
            Block.makeCuboidShape(3.25, 8.75, 7, 12.75, 9.25, 9),
            Block.makeCuboidShape(3, 9.25, 7, 13, 9.75, 9),
            Block.makeCuboidShape(2.75, 9.75, 7, 13.25, 10, 9),
            Block.makeCuboidShape(2.5, 10.25, 7, 2.75, 10.5, 9),
            Block.makeCuboidShape(2.75, 10, 7, 13.5, 10.5, 9),
            Block.makeCuboidShape(2.25, 10.5, 7, 13.75, 11, 9),
            Block.makeCuboidShape(2, 11, 7, 14, 11.5, 9),
            Block.makeCuboidShape(1.75, 11.5, 7, 14.25, 11.75, 9),
            Block.makeCuboidShape(1.5, 12, 7, 1.75, 12.25, 9),
            Block.makeCuboidShape(1.75, 11.75, 7, 14.5, 12.25, 9),
            Block.makeCuboidShape(1.25, 12.25, 7, 14.75, 12.75, 9),
            Block.makeCuboidShape(15.25, 13.5, 7, 15.5, 14, 9),
            Block.makeCuboidShape(0.75, 13.25, 7, 1, 14.25, 9),
            Block.makeCuboidShape(15, 13.25, 7, 15.25, 14.25, 9),
            Block.makeCuboidShape(1, 12.75, 7, 15, 14.5, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(8.95945945945946, 0, 7.04054054054054, 9.95945945945946, 12, 9.04054054054054),
            Block.makeCuboidShape(6.95945945945946, 1.5, 7.79054054054054, 8.95945945945946, 1.75, 8.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 1.75, 7.54054054054054, 8.95945945945946, 2, 8.54054054054054),
            Block.makeCuboidShape(6.95945945945946, 2, 7.29054054054054, 8.95945945945946, 2.25, 8.79054054054054),
            Block.makeCuboidShape(6.95945945945946, 2.5, 8.79054054054054, 8.95945945945946, 2.75, 9.04054054054054),
            Block.makeCuboidShape(6.95945945945946, 2.25, 7.04054054054054, 8.95945945945946, 2.75, 8.79054054054054),
            Block.makeCuboidShape(6.95945945945946, 2.75, 6.79054054054054, 8.95945945945946, 3.25, 9.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 3.25, 6.54054054054054, 8.95945945945946, 3.75, 9.54054054054054),
            Block.makeCuboidShape(6.95945945945946, 3.75, 6.29054054054054, 8.95945945945946, 4, 9.79054054054054),
            Block.makeCuboidShape(6.95945945945946, 4, 6.04054054054054, 8.95945945945946, 4.5, 10.04054054054054),
            Block.makeCuboidShape(6.95945945945946, 4.5, 5.79054054054054, 8.95945945945946, 5, 10.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 5, 5.54054054054054, 8.95945945945946, 5.25, 10.54054054054054),
            Block.makeCuboidShape(6.95945945945946, 5.5, 10.54054054054054, 8.95945945945946, 5.75, 10.79054054054054),
            Block.makeCuboidShape(6.95945945945946, 5.25, 5.29054054054054, 8.95945945945946, 5.75, 10.54054054054054),
            Block.makeCuboidShape(6.95945945945946, 5.75, 5.04054054054054, 8.95945945945946, 6.25, 11.04054054054054),
            Block.makeCuboidShape(6.95945945945946, 6.25, 4.79054054054054, 8.95945945945946, 6.75, 11.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 6.75, 4.54054054054054, 8.95945945945946, 7, 11.54054054054054),
            Block.makeCuboidShape(6.95945945945946, 7.25, 11.54054054054054, 8.95945945945946, 7.5, 11.79054054054054),
            Block.makeCuboidShape(6.95945945945946, 7, 4.29054054054054, 8.95945945945946, 7.5, 11.54054054054054),
            Block.makeCuboidShape(6.95945945945946, 7.5, 4.04054054054054, 8.95945945945946, 8, 12.04054054054054),
            Block.makeCuboidShape(6.95945945945946, 8, 3.7905405405405403, 8.95945945945946, 8.5, 12.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 8.5, 3.5405405405405403, 8.95945945945946, 8.75, 12.54054054054054),
            Block.makeCuboidShape(6.95945945945946, 8.75, 3.2905405405405403, 8.95945945945946, 9.25, 12.79054054054054),
            Block.makeCuboidShape(6.95945945945946, 9.25, 3.0405405405405403, 8.95945945945946, 9.75, 13.04054054054054),
            Block.makeCuboidShape(6.95945945945946, 9.75, 2.7905405405405403, 8.95945945945946, 10, 13.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 10.25, 13.29054054054054, 8.95945945945946, 10.5, 13.54054054054054),
            Block.makeCuboidShape(6.95945945945946, 10, 2.5405405405405403, 8.95945945945946, 10.5, 13.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 10.5, 2.2905405405405403, 8.95945945945946, 11, 13.79054054054054),
            Block.makeCuboidShape(6.95945945945946, 11, 2.0405405405405403, 8.95945945945946, 11.5, 14.04054054054054),
            Block.makeCuboidShape(6.95945945945946, 11.5, 1.7905405405405403, 8.95945945945946, 11.75, 14.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 12, 14.29054054054054, 8.95945945945946, 12.25, 14.54054054054054),
            Block.makeCuboidShape(6.95945945945946, 11.75, 1.5405405405405403, 8.95945945945946, 12.25, 14.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 12.25, 1.2905405405405403, 8.95945945945946, 12.75, 14.79054054054054),
            Block.makeCuboidShape(6.95945945945946, 13.5, 0.5405405405405403, 8.95945945945946, 14, 0.7905405405405403),
            Block.makeCuboidShape(6.95945945945946, 13.25, 15.04054054054054, 8.95945945945946, 14.25, 15.29054054054054),
            Block.makeCuboidShape(6.95945945945946, 13.25, 0.7905405405405403, 8.95945945945946, 14.25, 1.0405405405405403),
            Block.makeCuboidShape(6.95945945945946, 12.75, 1.0405405405405403, 8.95945945945946, 14.5, 15.04054054054054)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_O = Stream.of(
            Block.makeCuboidShape(6.04054054054054, 0, 7.04054054054054, 7.04054054054054, 12, 9.04054054054054),
            Block.makeCuboidShape(7.04054054054054, 1.5, 7.79054054054054, 9.04054054054054, 1.75, 8.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 1.75, 7.54054054054054, 9.04054054054054, 2, 8.54054054054054),
            Block.makeCuboidShape(7.04054054054054, 2, 7.29054054054054, 9.04054054054054, 2.25, 8.79054054054054),
            Block.makeCuboidShape(7.04054054054054, 2.5, 7.04054054054054, 9.04054054054054, 2.75, 7.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 2.25, 7.29054054054054, 9.04054054054054, 2.75, 9.04054054054054),
            Block.makeCuboidShape(7.04054054054054, 2.75, 6.79054054054054, 9.04054054054054, 3.25, 9.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 3.25, 6.54054054054054, 9.04054054054054, 3.75, 9.54054054054054),
            Block.makeCuboidShape(7.04054054054054, 3.75, 6.29054054054054, 9.04054054054054, 4, 9.79054054054054),
            Block.makeCuboidShape(7.04054054054054, 4, 6.04054054054054, 9.04054054054054, 4.5, 10.04054054054054),
            Block.makeCuboidShape(7.04054054054054, 4.5, 5.79054054054054, 9.04054054054054, 5, 10.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 5, 5.54054054054054, 9.04054054054054, 5.25, 10.54054054054054),
            Block.makeCuboidShape(7.04054054054054, 5.5, 5.29054054054054, 9.04054054054054, 5.75, 5.54054054054054),
            Block.makeCuboidShape(7.04054054054054, 5.25, 5.54054054054054, 9.04054054054054, 5.75, 10.79054054054054),
            Block.makeCuboidShape(7.04054054054054, 5.75, 5.04054054054054, 9.04054054054054, 6.25, 11.04054054054054),
            Block.makeCuboidShape(7.04054054054054, 6.25, 4.79054054054054, 9.04054054054054, 6.75, 11.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 6.75, 4.54054054054054, 9.04054054054054, 7, 11.54054054054054),
            Block.makeCuboidShape(7.04054054054054, 7.25, 4.29054054054054, 9.04054054054054, 7.5, 4.54054054054054),
            Block.makeCuboidShape(7.04054054054054, 7, 4.54054054054054, 9.04054054054054, 7.5, 11.79054054054054),
            Block.makeCuboidShape(7.04054054054054, 7.5, 4.04054054054054, 9.04054054054054, 8, 12.04054054054054),
            Block.makeCuboidShape(7.04054054054054, 8, 3.7905405405405403, 9.04054054054054, 8.5, 12.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 8.5, 3.5405405405405403, 9.04054054054054, 8.75, 12.54054054054054),
            Block.makeCuboidShape(7.04054054054054, 8.75, 3.2905405405405403, 9.04054054054054, 9.25, 12.79054054054054),
            Block.makeCuboidShape(7.04054054054054, 9.25, 3.0405405405405403, 9.04054054054054, 9.75, 13.04054054054054),
            Block.makeCuboidShape(7.04054054054054, 9.75, 2.7905405405405403, 9.04054054054054, 10, 13.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 10.25, 2.5405405405405403, 9.04054054054054, 10.5, 2.7905405405405403),
            Block.makeCuboidShape(7.04054054054054, 10, 2.7905405405405403, 9.04054054054054, 10.5, 13.54054054054054),
            Block.makeCuboidShape(7.04054054054054, 10.5, 2.2905405405405403, 9.04054054054054, 11, 13.79054054054054),
            Block.makeCuboidShape(7.04054054054054, 11, 2.0405405405405403, 9.04054054054054, 11.5, 14.04054054054054),
            Block.makeCuboidShape(7.04054054054054, 11.5, 1.7905405405405403, 9.04054054054054, 11.75, 14.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 12, 1.5405405405405403, 9.04054054054054, 12.25, 1.7905405405405403),
            Block.makeCuboidShape(7.04054054054054, 11.75, 1.7905405405405403, 9.04054054054054, 12.25, 14.54054054054054),
            Block.makeCuboidShape(7.04054054054054, 12.25, 1.2905405405405403, 9.04054054054054, 12.75, 14.79054054054054),
            Block.makeCuboidShape(7.04054054054054, 13.5, 15.29054054054054, 9.04054054054054, 14, 15.54054054054054),
            Block.makeCuboidShape(7.04054054054054, 13.25, 0.7905405405405403, 9.04054054054054, 14.25, 1.0405405405405403),
            Block.makeCuboidShape(7.04054054054054, 13.25, 15.04054054054054, 9.04054054054054, 14.25, 15.29054054054054),
            Block.makeCuboidShape(7.04054054054054, 12.75, 1.0405405405405403, 9.04054054054054, 14.5, 15.04054054054054)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7, 0, 6.081081081081081, 9, 12, 7.081081081081081),
            Block.makeCuboidShape(7.75, 1.5, 7.081081081081081, 8.25, 1.75, 9.08108108108108),
            Block.makeCuboidShape(7.5, 1.75, 7.081081081081081, 8.5, 2, 9.08108108108108),
            Block.makeCuboidShape(7.25, 2, 7.081081081081081, 8.75, 2.25, 9.08108108108108),
            Block.makeCuboidShape(8.75, 2.5, 7.081081081081081, 9, 2.75, 9.08108108108108),
            Block.makeCuboidShape(7, 2.25, 7.081081081081081, 8.75, 2.75, 9.08108108108108),
            Block.makeCuboidShape(6.75, 2.75, 7.081081081081081, 9.25, 3.25, 9.08108108108108),
            Block.makeCuboidShape(6.5, 3.25, 7.081081081081081, 9.5, 3.75, 9.08108108108108),
            Block.makeCuboidShape(6.25, 3.75, 7.081081081081081, 9.75, 4, 9.08108108108108),
            Block.makeCuboidShape(6, 4, 7.081081081081081, 10, 4.5, 9.08108108108108),
            Block.makeCuboidShape(5.75, 4.5, 7.081081081081081, 10.25, 5, 9.08108108108108),
            Block.makeCuboidShape(5.5, 5, 7.081081081081081, 10.5, 5.25, 9.08108108108108),
            Block.makeCuboidShape(10.5, 5.5, 7.081081081081081, 10.75, 5.75, 9.08108108108108),
            Block.makeCuboidShape(5.25, 5.25, 7.081081081081081, 10.5, 5.75, 9.08108108108108),
            Block.makeCuboidShape(5, 5.75, 7.081081081081081, 11, 6.25, 9.08108108108108),
            Block.makeCuboidShape(4.75, 6.25, 7.081081081081081, 11.25, 6.75, 9.08108108108108),
            Block.makeCuboidShape(4.5, 6.75, 7.081081081081081, 11.5, 7, 9.08108108108108),
            Block.makeCuboidShape(11.5, 7.25, 7.081081081081081, 11.75, 7.5, 9.08108108108108),
            Block.makeCuboidShape(4.25, 7, 7.081081081081081, 11.5, 7.5, 9.08108108108108),
            Block.makeCuboidShape(4, 7.5, 7.081081081081081, 12, 8, 9.08108108108108),
            Block.makeCuboidShape(3.75, 8, 7.081081081081081, 12.25, 8.5, 9.08108108108108),
            Block.makeCuboidShape(3.5, 8.5, 7.081081081081081, 12.5, 8.75, 9.08108108108108),
            Block.makeCuboidShape(3.25, 8.75, 7.081081081081081, 12.75, 9.25, 9.08108108108108),
            Block.makeCuboidShape(3, 9.25, 7.081081081081081, 13, 9.75, 9.08108108108108),
            Block.makeCuboidShape(2.75, 9.75, 7.081081081081081, 13.25, 10, 9.08108108108108),
            Block.makeCuboidShape(13.25, 10.25, 7.081081081081081, 13.5, 10.5, 9.08108108108108),
            Block.makeCuboidShape(2.5, 10, 7.081081081081081, 13.25, 10.5, 9.08108108108108),
            Block.makeCuboidShape(2.25, 10.5, 7.081081081081081, 13.75, 11, 9.08108108108108),
            Block.makeCuboidShape(2, 11, 7.081081081081081, 14, 11.5, 9.08108108108108),
            Block.makeCuboidShape(1.75, 11.5, 7.081081081081081, 14.25, 11.75, 9.08108108108108),
            Block.makeCuboidShape(14.25, 12, 7.081081081081081, 14.5, 12.25, 9.08108108108108),
            Block.makeCuboidShape(1.5, 11.75, 7.081081081081081, 14.25, 12.25, 9.08108108108108),
            Block.makeCuboidShape(1.25, 12.25, 7.081081081081081, 14.75, 12.75, 9.08108108108108),
            Block.makeCuboidShape(0.5, 13.5, 7.081081081081081, 0.75, 14, 9.08108108108108),
            Block.makeCuboidShape(15, 13.25, 7.081081081081081, 15.25, 14.25, 9.08108108108108),
            Block.makeCuboidShape(0.75, 13.25, 7.081081081081081, 1, 14.25, 9.08108108108108),
            Block.makeCuboidShape(1, 12.75, 7.081081081081081, 15, 14.5, 9.08108108108108)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public BaseInvertedTriangleSign(Properties properties)
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
