package com.kevinkrueger.roadstuff.proxy;

import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.screens.RSCraftingTableScreen;
import com.kevinkrueger.roadstuff.util.ModContainers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RoadStuff.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy implements IProxy{
    @Override
    public void init()
    {
        // Screen Init
        ScreenManager.registerFactory(ModContainers.RSCRAFTINGTABLE_CONTAINER.get(), RSCraftingTableScreen::new);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }
}
