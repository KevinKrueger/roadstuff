package com.kevinkrueger.roadstuff.base;

import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

import java.util.HashMap;
import java.util.Map;

public class CalculateShape
{
    public Map<Direction, VoxelShape> SHAPES = null;

    public CalculateShape()
    {
        SHAPES = new HashMap<>();
    }

     private void calculateShapes(Direction to, VoxelShape shape)
     {
        try
        {
            VoxelShape[] buffer = new VoxelShape[] { shape, VoxelShapes.empty() };

            int times = (to.getHorizontalIndex() - Direction.NORTH.getHorizontalIndex() + 4) % 4;
            for (int i = 0; i < times; i++) {
                buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.or(buffer[1],
                        VoxelShapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
                buffer[0] = buffer[1];
                buffer[1] = VoxelShapes.empty();
            }
            SHAPES.put(to, buffer[0]);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void runCalculation(VoxelShape shape) {
        for (Direction direction : Direction.values()) {
            calculateShapes(direction, shape);
        }
    }
}
