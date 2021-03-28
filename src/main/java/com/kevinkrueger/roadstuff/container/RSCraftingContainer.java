package com.kevinkrueger.roadstuff.container;

import com.kevinkrueger.roadstuff.util.ModBlocks;
import com.kevinkrueger.roadstuff.util.ModContainers;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class RSCraftingContainer extends Container {

    private TileEntity tileEntity;
    private  PlayerEntity playerEntity;
    private IItemHandler playerInventory;

    public RSCraftingContainer(int windoId, World worldId, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player)
    {
        super(ModContainers.RSCRAFTING_CONTAINER.get(), windoId);
        this.tileEntity = worldId.getTileEntity(pos);
        this.playerEntity = player;
        this.playerInventory = new InvWrapper(playerInventory);

        if(tileEntity != null)
        {
            tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
                addSlot(new SlotItemHandler(handler, 0,  30, 75));
            });

        }

        layoutPlayerInventorySlots(8, 84);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(IWorldPosCallable.of(tileEntity.getWorld(),
                tileEntity.getPos()), playerEntity, ModBlocks.RSCRAFTINGTABLE.get());
    }

    /*@Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if(slot != null && slot.getHasStack())
        {
            ItemStack stack = slot.getStack();
            itemStack = stack.copy();
            if (index == 0) {
                if(!this.mergeItemStack(stack, 1, 37,true))
                {
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(stack, itemStack);
            }else{
                if(stack.getStack())
            }
        }

    }*/

    private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx)
    {
        for (int i = 0; i < amount; i++)
        {
            addSlot(new SlotItemHandler(handler, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmnount, int dx,int verticalAmount, int dy)
    {
        for(int j = 0; j < verticalAmount; j++)
        {
            index = addSlotRange(handler, index, x, y, horAmnount, dx);
            y += dy;

        }
        return index;
    }

    private void layoutPlayerInventorySlots(int leftCol, int topRow)
    {
        addSlotBox(playerInventory, 9, leftCol, topRow, 9, 10, 3, 10);
        topRow += 58;

        addSlotRange(playerInventory, 0, leftCol, topRow, 9, 10);
    }
}
