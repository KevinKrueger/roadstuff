package com.kevinkrueger.roadstuff.base;

import com.kevinkrueger.roadstuff.tileentity.TileEntityHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class BaseTileEntity extends TileEntity {
    public BaseTileEntity(TileEntityType<?> type) {
        super(type);
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(this.getPos(), -1, this.getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager manager, SUpdateTileEntityPacket packet) {
        this.read(this.getBlockState(), packet.getNbtCompound());
    }

    @Override
    public final CompoundNBT getUpdateTag() {
        return this.write(new CompoundNBT());
    }

    public void markDirtyAndDispatch() {
        super.markDirty();
        TileEntityHelper.dispatchToNearbyPlayers(this);
    }
}
