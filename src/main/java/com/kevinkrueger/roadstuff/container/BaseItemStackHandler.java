package com.kevinkrueger.roadstuff.container;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.ItemStackHandler;
import org.apache.commons.lang3.ArrayUtils;

public class BaseItemStackHandler extends ItemStackHandler {
    private final Runnable onContentsChanged;

    private final Map<Integer, Integer> slotSizeMap;

    private BiFunction<Integer, ItemStack, Boolean> slotValidator = null;

    private int maxStackSize = 64;

    private int[] outputSlots = null;

    public BaseItemStackHandler(int size) {
        this(size, (Runnable)null);
    }

    public BaseItemStackHandler(int size, Runnable onContentsChanged) {
        super(size);
        this.onContentsChanged = onContentsChanged;
        this.slotSizeMap = new HashMap<>();
    }

    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        if (this.outputSlots != null && ArrayUtils.contains(this.outputSlots, slot))
            return stack;
        return super.insertItem(slot, stack, simulate);
    }

    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        if (this.outputSlots != null && !ArrayUtils.contains(this.outputSlots, slot))
            return ItemStack.EMPTY;
        return super.extractItem(slot, amount, simulate);
    }

    public int getSlotLimit(int slot) {
        return this.slotSizeMap.containsKey(Integer.valueOf(slot)) ? ((Integer)this.slotSizeMap.get(Integer.valueOf(slot))).intValue() : this.maxStackSize;
    }

    public boolean isItemValid(int slot, ItemStack stack) {
        return (this.slotValidator == null || ((Boolean)this.slotValidator.apply(Integer.valueOf(slot), stack)).booleanValue());
    }

    protected void onContentsChanged(int slot) {
        if (this.onContentsChanged != null)
            this.onContentsChanged.run();
    }

    public ItemStack insertItemSuper(int slot, ItemStack stack, boolean simulate) {
        return super.insertItem(slot, stack, simulate);
    }

    public ItemStack extractItemSuper(int slot, int amount, boolean simulate) {
        return super.extractItem(slot, amount, simulate);
    }

    public NonNullList<ItemStack> getStacks() {
        return this.stacks;
    }

    public int[] getOutputSlots() {
        return this.outputSlots;
    }

    public void setDefaultSlotLimit(int size) {
        this.maxStackSize = size;
    }

    public void addSlotLimit(int slot, int size) {
        this.slotSizeMap.put(Integer.valueOf(slot), Integer.valueOf(size));
    }

    public void setSlotValidator(BiFunction<Integer, ItemStack, Boolean> validator) {
        this.slotValidator = validator;
    }

    public void setOutputSlots(int... slots) {
        this.outputSlots = slots;
    }

    public IInventory toIInventory() {
        return (IInventory)new Inventory((ItemStack[])this.stacks.toArray((Object[])new ItemStack[0]));
    }

    public BaseItemStackHandler copy() {
        BaseItemStackHandler newInventory = new BaseItemStackHandler(getSlots(), this.onContentsChanged);
        newInventory.setDefaultSlotLimit(this.maxStackSize);
        newInventory.setSlotValidator(this.slotValidator);
        newInventory.setOutputSlots(this.outputSlots);
        this.slotSizeMap.forEach(newInventory::addSlotLimit);
        for (int i = 0; i < getSlots(); i++) {
            ItemStack stack = getStackInSlot(i);
            newInventory.setStackInSlot(i, stack.getStack());
        }
        return newInventory;
    }
}
