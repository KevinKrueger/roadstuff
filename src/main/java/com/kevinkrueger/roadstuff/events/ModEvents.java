package com.kevinkrueger.roadstuff.events;

import com.kevinkrueger.roadstuff.util.ModItems;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashSet;
import java.util.Set;

public class ModEvents
{
    @Deprecated
    @SubscribeEvent
    public void OnSteel(TickEvent.PlayerTickEvent event)
    {

        PlayerInventory inv = event.player.inventory;
        int steelCount =  ModItems.STEEL_INGOT.get().getMaxStackSize();

        Set<Item> test = new HashSet<>();
        test.add(ModItems.STEEL_INGOT.get());

        if(inv.hasAny(test) && inv.count(ModItems.STEEL_INGOT.get()) > steelCount)
        {
            // TODO: Drop the Item ....

            System.out.println("Das ist zu Schwer");
        }
    }
}
