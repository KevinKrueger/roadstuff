package com.kevinkrueger.roadstuff.block.individual;

import com.kevinkrueger.roadstuff.base.BlockBase;
import com.kevinkrueger.roadstuff.tileentity.RSCraftingTileEntity;
import com.kevinkrueger.roadstuff.init.ModTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class RSCraftingTable extends BlockBase {
    public RSCraftingTable(String RegistryName, Properties properties) {
        super(RegistryName, properties);
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
        if (!world.isRemote()) {
            TileEntity tile = world.getTileEntity(pos);

            if (tile instanceof RSCraftingTileEntity)
                player.openContainer((RSCraftingTileEntity) tile);
        }

        return ActionResultType.SUCCESS;
    }
}
