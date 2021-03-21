package com.kevinkrueger.roadstuff.base;

import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.TileEntityBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.TrappedChestBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.*;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


import javax.annotation.Nullable;
import java.util.List;

public class BlockBase extends Block
{
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    // ToolTip stuff....
    private String _toolTipText = "";
    private TextFormatting _toolTipColor = TextFormatting.WHITE;
    private final String _toolTipERROR = TextFormatting.RED +  "PLEASE SET THIS TEXT!";

    public BlockBase(Properties properties)
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
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack)
    {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        if (stack.hasDisplayName()) {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof TileEntityBase) {
                ((TileEntityBase) tileentity).setCustomName(stack.getDisplayName());
            }
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

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        if(!_toolTipText.equals(""))
            tooltip.add(new StringTextComponent(_toolTipText));
    }

    private Color setColor(TextFormatting format)
    {
        return Color.fromTextFormatting(format);
    }


    /**
     * @param text Individual customizable text! Bsp: TextFormatting.GRAY + "Hello " + TextFormatting.Orange + "World"
     */
    public BlockBase setTooltip(String text)
    {
        if(text != null)
            this._toolTipText = TextFormatting.GRAY +  text;
        else
            this._toolTipText = _toolTipERROR;
        return this;
    }

    /**
     * @param text Text of the ToolTip
     * @param color Color of the text. : WHITE(Default)
     */
    public BlockBase setTooltip(String text, TextFormatting color)
    {
        //###############
        // Color
        //###############
        if(color != null)
            this._toolTipColor = color;
        else
            this._toolTipColor = TextFormatting.WHITE;

        //##############
        // Text
        //##############
        if(text !=null)
            this._toolTipText = this._toolTipColor + text;
        else
            this._toolTipText = _toolTipERROR;

        return this;
    }
}
