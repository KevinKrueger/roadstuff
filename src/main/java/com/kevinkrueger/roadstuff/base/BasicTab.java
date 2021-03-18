package com.kevinkrueger.roadstuff.base;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class BasicTab extends ItemGroup
{
    private final Supplier<ItemStack> blockOrItem;

    public BasicTab(final String name, final Supplier<ItemStack> blockOrItem)
    {
        super(name);
        this.blockOrItem = blockOrItem;
    }

    @Override
    public ItemStack createIcon() {
        return blockOrItem.get();
    }
}
