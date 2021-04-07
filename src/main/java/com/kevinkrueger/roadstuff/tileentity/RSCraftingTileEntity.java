package com.kevinkrueger.roadstuff.tileentity;

import com.kevinkrueger.roadstuff.base.BaseInventoryTileEntity;
import com.kevinkrueger.roadstuff.base.Localizable;
import com.kevinkrueger.roadstuff.base.BaseItemStackHandler;
import com.kevinkrueger.roadstuff.container.RSCraftingContainer;
import com.kevinkrueger.roadstuff.init.ModTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;

public class RSCraftingTileEntity extends BaseInventoryTileEntity implements INamedContainerProvider {
    private final BaseItemStackHandler inventory = new BaseItemStackHandler(25, this::markDirtyAndDispatch);

    public RSCraftingTileEntity() {
        super(ModTileEntity.RSCRAFTINGTABLE_ENTITY_TPYE.get());
    }

    @Override
    public BaseItemStackHandler getInventory() {
        return this.inventory;
    }

    @Override
    public ITextComponent getDisplayName() {
        return Localizable.of("container.roadstuff.rscrafting_table").build();
    }

    @Override
    public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity player) {
        return RSCraftingContainer.create(windowId, playerInventory, this::isUsableByPlayer, this.inventory);
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return !this.removed && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? LazyOptional.empty() : super.getCapability(cap, side);
    }
}