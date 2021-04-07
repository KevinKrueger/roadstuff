package com.kevinkrueger.roadstuff.network;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public interface Message<T extends Message> {
    Dist getExecutingSide();

    default void executeServerSide(Context context) {
    }

    default void executeClientSide(Context context) {
    }

    T fromBytes(PacketBuffer var1);

    void toBytes(PacketBuffer var1);
}

