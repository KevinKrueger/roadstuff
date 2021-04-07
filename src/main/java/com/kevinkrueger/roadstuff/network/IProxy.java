package com.kevinkrueger.roadstuff.network;

import net.minecraft.world.World;

public interface IProxy
{
    void init();
    World getClientWorld();
}
