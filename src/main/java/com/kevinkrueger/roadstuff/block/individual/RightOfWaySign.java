package com.kevinkrueger.roadstuff.block.individual;

import com.kevinkrueger.roadstuff.base.BlockBase;
import com.kevinkrueger.roadstuff.base.CalculateShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.brain.task.HideFromRaidOnBellRingTask;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class RightOfWaySign extends BlockBase
{
    CalculateShape calc = new CalculateShape();

    private static final VoxelShape shape = VoxelShapes.combineAndSimplify(
                    Block.makeCuboidShape(3.207106781186548, 2.207106781186548, 7, 14.207106781186548, 13.207106781186548, 9),
                    Block.makeCuboidShape(7, 0, 9, 9, 12, 10), IBooleanFunction.OR);

    public RightOfWaySign(Properties properties)
    {
        super(properties);
        calc.runCalculation(shape);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return calc.SHAPES.get(state.get(FACING));
    }
}
