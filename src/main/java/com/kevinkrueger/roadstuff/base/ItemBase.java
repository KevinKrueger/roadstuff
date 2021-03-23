package com.kevinkrueger.roadstuff.base;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;

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
}
