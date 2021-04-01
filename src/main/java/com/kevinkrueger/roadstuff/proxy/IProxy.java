package com.kevinkrueger.roadstuff.proxy;

import net.minecraft.world.World;

public interface IProxy
{
    void init();
    World getClientWorld();
}
