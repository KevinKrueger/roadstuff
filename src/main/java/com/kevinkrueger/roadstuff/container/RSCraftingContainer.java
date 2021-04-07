package com.kevinkrueger.roadstuff.container;

import com.kevinkrueger.roadstuff.init.ModContainers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

import java.util.Optional;
import java.util.function.Function;

public class RSCraftingContainer extends Container {


    private final Function<PlayerEntity, Boolean> isUsableByPlayer;
    private final World world;
    private final IItemHandlerModifiable result;

    private RSCraftingContainer(ContainerType<?> type, int id, PlayerInventory playerInventory) {
        this(type, id, playerInventory, p -> false, new BaseItemStackHandler(25));
    }

    private RSCraftingContainer(ContainerType<?> type, int id, PlayerInventory playerInventory, Function<PlayerEntity, Boolean> isUsableByPlayer, BaseItemStackHandler inventory) {
        super(type, id);
        this.isUsableByPlayer = isUsableByPlayer;
        this.world = playerInventory.player.world;
        this.result = new ItemStackHandler();

            IInventory matrix = new ExtendedCraftingInventory(this, inventory);
            addSlot(new TableOutputSlot(this, matrix, result, 0, 142, 53));

            int i, j;
            for (i = 0; i < 5; i++) {
                for (j = 0; j < 5; j++) {
                    this.addSlot(new Slot(matrix, j + i * 5, 14 + j * 18, 18 + i * 18));
                }
            }

            for (i = 0; i < 3; i++) {
                for (j = 0; j < 9; j++) {
                    this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 124 + i * 18));
                }
            }

            for (j = 0; j < 9; j++) {
                this.addSlot(new Slot(playerInventory, j, 8 + j * 18, 182));
            }

            onCraftMatrixChanged(matrix);
    }

    @Override
    public boolean canInteractWith(PlayerEntity player) {
        return this.isUsableByPlayer.apply(player);
    }


    @Override
    public ItemStack transferStackInSlot(PlayerEntity player, int slotNumber) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(slotNumber);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotNumber == 0) {
                if (!this.mergeItemStack(itemstack1, 26, 62, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (slotNumber >= 26 && slotNumber < 62) {
                if (!this.mergeItemStack(itemstack1, 1, 26, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 26, 62, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }


    @Override
    public void onCraftMatrixChanged(IInventory matrix) {
        Optional<ITableRecipe> recipe = this.world.getRecipeManager().getRecipe(RecipeTypes.TABLE, matrix, this.world);
        if (recipe.isPresent()) {
            ItemStack result = recipe.get().getCraftingResult(matrix);
            this.result.setStackInSlot(0, result);
        } else {
            this.result.setStackInSlot(0, ItemStack.EMPTY);
        }

        super.onCraftMatrixChanged(matrix);
    }
    public static RSCraftingContainer create(int windowId, PlayerInventory playerInventory) {
        return new RSCraftingContainer(ModContainers.RSCRAFTINGTABLE_CONTAINER.get(), windowId, playerInventory);
    }

    public static RSCraftingContainer create(int windowId, PlayerInventory playerInventory, Function<PlayerEntity, Boolean> isUsableByPlayer, BaseItemStackHandler inventory) {
        return new RSCraftingContainer(ModContainers.RSCRAFTINGTABLE_CONTAINER.get(), windowId, playerInventory, isUsableByPlayer, inventory);
    }
}
