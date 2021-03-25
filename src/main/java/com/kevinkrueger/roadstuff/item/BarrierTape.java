package com.kevinkrueger.roadstuff.item;

import com.kevinkrueger.roadstuff.base.ItemBase;
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
        return DamageItem(1, itemStack);
    }
}


