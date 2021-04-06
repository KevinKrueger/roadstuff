package com.kevinkrueger.roadstuff.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;

/**
 * Used to represent an Extended Crafting Table recipe for the recipe type
 */
public interface ITableRecipe extends IRecipe<IInventory> {
    int getTier();
    boolean hasRequiredTier();
}
