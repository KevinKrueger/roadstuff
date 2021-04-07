package com.kevinkrueger.roadstuff.init;

import com.kevinkrueger.roadstuff.container.RSCraftingContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;

public class ModContainers
{
    public static final RegistryObject<ContainerType<RSCraftingContainer>> RSCRAFTINGTABLE_CONTAINER
            = Registration.CONATINERS.register("rscraftingtable_container",() -> new ContainerType<>(RSCraftingContainer::create));

    public static void register(){}
}
