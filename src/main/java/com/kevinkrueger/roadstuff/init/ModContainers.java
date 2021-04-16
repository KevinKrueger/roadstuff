package com.kevinkrueger.roadstuff.init;

import com.kevinkrueger.roadstuff.container.RSCraftingContainer;
import com.kevinkrueger.roadstuff.network.ILogger;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModContainers implements ILogger
{
    public static final RegistryObject<ContainerType<RSCraftingContainer>> RSCRAFTINGTABLE_CONTAINER
            =  register("rscraftingtable_container",() -> new ContainerType<>(RSCraftingContainer::create));

    public static void register(){}

    private static <T extends ContainerType<?>> RegistryObject<T> register(String name, Supplier<? extends ContainerType> sup)
    {
        RegistryObject<? extends ContainerType> toReturn = null;

        try
        {
            toReturn = Registration.CONTAINERS.register(name, sup);
            LOGGER.log(ModContainers.class, "Register(Container): " + name);
        }catch (Exception exception)
        {
            LOGGER.error(ModContainers.class, "", exception);
        }

        return (RegistryObject<T>) toReturn;
    }
}
