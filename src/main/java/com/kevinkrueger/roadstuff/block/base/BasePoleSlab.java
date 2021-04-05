package com.kevinkrueger.roadstuff.block.base;

import com.kevinkrueger.roadstuff.base.BlockBase;
import com.kevinkrueger.roadstuff.base.CalculateShape;
import com.kevinkrueger.roadstuff.util.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.stream.Stream;

public class BasePoleSlab extends BlockBase
{

    public static final BooleanProperty HAS_POLE = BooleanProperty.create("has_pole");
    CalculateShape calc = new CalculateShape();
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 8, 7),
            Block.makeCuboidShape(0, 0, 9, 16, 8, 16),
            Block.makeCuboidShape(0, 0, 7, 7, 8, 9),
            Block.makeCuboidShape(9, 0, 7, 16, 8, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public BasePoleSlab(Properties properties)
    {
        super(properties);
        setDefaultState(getDefaultState().with(HAS_POLE, false));
        calc.runCalculation(SHAPE_N);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return calc.SHAPES.get(state.get(FACING));
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
            if(player.getHeldItemMainhand().getItem() == ModBlocks.STEELPOLE_LIGHTS.get().asItem()) {
                // Blockstate ändern

                if(!worldIn.getBlockState(pos).get(HAS_POLE))
                {
                    worldIn.setBlockState(pos, state.with(HAS_POLE, true));
                    player.getHeldItemMainhand().shrink(1);
                }
            }
        return ActionResultType.SUCCESS;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(HAS_POLE);
        super.fillStateContainer(builder);
    }
}
