package com.kevinkrueger.roadstuff.block.individual;

import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.base.BlockBase;
import com.kevinkrueger.roadstuff.container.RSCraftingContainer;
import com.kevinkrueger.roadstuff.tileentity.RSCraftingTileEntity;
import com.kevinkrueger.roadstuff.util.ModTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class RSCraftingTable extends BlockBase {
    public RSCraftingTable(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntity.RSCRAFTINGTABLE_ENTITY_TPYE.get().create();
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos,
                                             PlayerEntity player, Hand hand, BlockRayTraceResult trace) {
        if (!world.isRemote())
        {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity instanceof RSCraftingTileEntity)
            {
                INamedContainerProvider containerProvider = new INamedContainerProvider() {
                    @Override
                    public ITextComponent getDisplayName() {
                        return new TranslationTextComponent("screen."+ RoadStuff.MOD_ID +".rscraftingtable");
                    }

                    @Override
                    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                        return new RSCraftingContainer(i, world, pos, playerInventory, playerEntity);
                    }
                };
                NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider, tileEntity.getPos());
            } else {
                throw new IllegalStateException("Our named container provider is missing!");
            }
        }

        return ActionResultType.SUCCESS;
    }
}