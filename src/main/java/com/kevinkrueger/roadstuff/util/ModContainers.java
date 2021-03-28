package com.kevinkrueger.roadstuff.util;

import com.kevinkrueger.roadstuff.container.RSCraftingContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;

public class ModContainers
{

    public static final RegistryObject<ContainerType<RSCraftingContainer>> RSCRAFTING_CONTAINER
            = Registration.CONATINERS.register("rscrafting_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new RSCraftingContainer(windowId, world, pos, inv, inv.player);
            })));


    public static void register(){}
}
