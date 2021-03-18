package com.kevinkrueger.roadstuff.base;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

/////////////////////////
// Simplyfied ItemGroup
/////////////////////////
public class BasicTab extends ItemGroup
{
    private final Supplier<ItemStack> blockOrItem;

    /**
    * @param name Your MOD_ID
    * @param blockOrItem A Block or an Item of your choice to create the Tab-Icon
    **/
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
