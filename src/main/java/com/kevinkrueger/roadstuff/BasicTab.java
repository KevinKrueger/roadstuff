package com.kevinkrueger.roadstuff;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import org.lwjgl.system.CallbackI;

public class BasicTab extends ItemGroup {

    private IItemProvider blockOrItem;

    /**
     * @param label Name des Tabs
     * @param blockOrItem Holt sich das angegebene Objekt (Block/Item) und zeigt es an
     */
    public BasicTab(String label, IItemProvider blockOrItem)
    {
        super(label);
        this.blockOrItem = blockOrItem;
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(blockOrItem);
    }
}
