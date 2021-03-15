package com.kevinkrueger.roadstuff;

import java.util.function.Consumer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class EntityUtils {
    public EntityUtils() {
    }

    public static void forEachPlayerAround(ServerWorld world, BlockPos pos, double radius, Consumer<ServerPlayerEntity> playerEntityConsumer) {
        world.getPlayers((player) -> {
            return player.getDistanceSq((double)pos.getX(), (double)pos.getY(), (double)pos.getZ()) <= radius * radius;
        }).forEach(playerEntityConsumer);
    }
}

