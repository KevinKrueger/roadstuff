package com.kevinkrueger.roadstuff.tileentity;

import com.kevinkrueger.roadstuff.util.ModTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class RSCraftingTileEntity extends TileEntity implements ITickableTileEntity
{



    private int tick = 0;
    private int energyLevel = 0;

    public RSCraftingTileEntity(TileEntityType<?> tileEntityTypeIn)
    {
        super(tileEntityTypeIn);
    }

    public RSCraftingTileEntity()
    {
        this(ModTileEntity.RSCRAFTINGTABLE_ENTITY_TPYE.get());
    }

    @Override
    public void remove() {
        super.remove();
    }

    @OnlyIn(Dist.CLIENT)
    public int getEnergyLevel()
    {
        return energyLevel;
    }



    @Override
    public void read(BlockState state, CompoundNBT tag)
    {
        super.read(state, tag);
    }


    @Override
    public void tick() {

    }
}