package com.kevinkrueger.roadstuff.events;

import com.kevinkrueger.roadstuff.util.ModItems;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class ModEvents {

    // @Deprecated
    // int steelCount =  ModItems.STEEL_INGOT.get().getMaxStackSize();
    int steelSlots = 0;
    private static final List<Integer> SteelSlotPosis = new ArrayList<>();

    boolean devMode = false;

    @SubscribeEvent
    public void OnSteel(TickEvent.PlayerTickEvent event) {
        try {
            if(devMode) {
                PlayerInventory inv = event.player.inventory;
                int count = inv.count(ModItems.STEEL_INGOT.get());


                // Hat Item Stack
                if (count > 10) {
                    // Droppen
                    inv.removeStackFromSlot(07);

                    event.player.dropItem(new ItemStack(ModItems.STEEL_INGOT.get(), 10), false, true);
                }
            }
            // Slot auf Steel überprüfen
            //if(inv.getStackInSlot(i).getItem() == stack.getItem())
            //{
            // Wenn ja
            //    steelSlots += 1;
            /// SteelSlotPosis.add(i);

            //     System.out.print("Slot" + i);
            // }


        // Wenn es mehrere Slots gibt
          /*  if(SteelSlotPosis.stream().count() > 1)
            {
                for(int i = 1; i < SteelSlotPosis.stream().count(); i++)
                {
                   /// inv.player.inventory.removeStackFromSlot(i);
                }
            }*/

        }catch( Exception ignored)
        {

        }
    }
}
