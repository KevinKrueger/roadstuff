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

public class CrashProtectionBollard extends BlockBase
{
    public CrashProtectionBollard(Properties properties)
    {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return Stream.of(
                Block.makeCuboidShape(3, 0, 3, 13, 1, 13),
                Block.makeCuboidShape(6, 1, 6, 10, 2, 10),
                Block.makeCuboidShape(7, 2, 7, 9, 4, 9),
                Block.makeCuboidShape(7, 4, 7, 9, 7, 9),
                Block.makeCuboidShape(7, 7, 7, 9, 10, 9),
                Block.makeCuboidShape(7, 10, 7, 9, 13, 9),
                Block.makeCuboidShape(7, 13, 7, 9, 16, 9)
        ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    }
}
