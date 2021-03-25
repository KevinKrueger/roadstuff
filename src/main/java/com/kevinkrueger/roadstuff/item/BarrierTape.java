package com.kevinkrueger.roadstuff.item;

import com.kevinkrueger.roadstuff.base.ItemBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BarrierTape extends ItemBase
{
    public BarrierTape(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
       final ItemStack copy = itemStack.copy();
       if(copy.attemptDamageItem(1,Item.random, null)) {
           copy.shrink(1);
           copy.setDamage(0);
       }
       return copy;
    }
}
