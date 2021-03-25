package com.kevinkrueger.roadstuff.base;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Extended Base class for items
 **/
public class ItemBase extends Item
{
    private double weight = 0.0;

    public ItemBase(Properties properties)
    {
        super(properties);
    }

    public ItemBase setWeight(double weight)
    {
        this.weight = weight;
        return this;
    }

    public double getWeight()
    {
        return this.weight;
    }


    /**
     * Damages the item
     * @param amount value for damage
     * @param itemStack Item to damage
     **/
    public ItemStack DamageItem(int amount, ItemStack itemStack){
        final ItemStack copy = itemStack.copy();
        if(copy.attemptDamageItem(amount, Item.random, null)) {
            copy.shrink(1);
            copy.setDamage(0);
        }
        return copy;
    }
}
