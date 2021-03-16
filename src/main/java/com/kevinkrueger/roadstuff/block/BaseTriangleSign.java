package com.kevinkrueger.roadstuff.block;

import com.kevinkrueger.roadstuff.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class BaseTriangleSign extends BlockBase {


    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 0, 9, 9, 12, 10),
            Block.makeCuboidShape(0.25, 0.5, 7, 0.5, 1.5, 9),
            Block.makeCuboidShape(15.5, 0.5, 7, 15.75, 1.5, 9),
            Block.makeCuboidShape(0.5, 0.25, 7, 0.75, 2, 9),
            Block.makeCuboidShape(15.25, 0.25, 7, 15.5, 2, 9),
            Block.makeCuboidShape(0.75, 0.25, 7, 1, 2.5, 9),
            Block.makeCuboidShape(15, 0.25, 7, 15.25, 2.5, 9),
            Block.makeCuboidShape(1, 0.25, 7, 1.25, 3, 9),
            Block.makeCuboidShape(14.75, 0.25, 7, 15, 3, 9),
            Block.makeCuboidShape(1.25, 0.25, 7, 1.5, 3.5, 9),
            Block.makeCuboidShape(14.5, 0.25, 7, 14.75, 3.5, 9),
            Block.makeCuboidShape(1.5, 0.25, 7, 1.75, 4, 9),
            Block.makeCuboidShape(14.25, 0.25, 7, 14.5, 4, 9),
            Block.makeCuboidShape(1.75, 0.25, 7, 2, 4.5, 9),
            Block.makeCuboidShape(14, 0.25, 7, 14.25, 4.5, 9),
            Block.makeCuboidShape(2, 0.25, 7, 2.25, 5, 9),
            Block.makeCuboidShape(13.75, 0.25, 7, 14, 5, 9),
            Block.makeCuboidShape(2.25, 0.25, 7, 2.5, 5.5, 9),
            Block.makeCuboidShape(13.5, 0.25, 7, 13.75, 5.5, 9),
            Block.makeCuboidShape(2.5, 0.25, 7, 2.75, 6, 9),
            Block.makeCuboidShape(13.25, 0.25, 7, 13.5, 6, 9),
            Block.makeCuboidShape(2.75, 0.25, 7, 3, 6.5, 9),
            Block.makeCuboidShape(13, 0.25, 7, 13.25, 6.5, 9),
            Block.makeCuboidShape(3, 0.25, 7, 3.25, 7, 9),
            Block.makeCuboidShape(12.75, 0.25, 7, 13, 7, 9),
            Block.makeCuboidShape(3.25, 0.25, 7, 3.5, 7.5, 9),
            Block.makeCuboidShape(12.5, 0.25, 7, 12.75, 7.5, 9),
            Block.makeCuboidShape(3.5, 0.25, 7, 3.75, 8, 9),
            Block.makeCuboidShape(12.25, 0.25, 7, 12.5, 8, 9),
            Block.makeCuboidShape(3.75, 0.25, 7, 4, 8.5, 9),
            Block.makeCuboidShape(12, 0.25, 7, 12.25, 8.5, 9),
            Block.makeCuboidShape(4, 0.25, 7, 4.25, 9, 9),
            Block.makeCuboidShape(11.75, 0.25, 7, 12, 9, 9),
            Block.makeCuboidShape(4.25, 0.25, 7, 4.5, 9.5, 9),
            Block.makeCuboidShape(11.5, 0.25, 7, 11.75, 9.5, 9),
            Block.makeCuboidShape(4.5, 0.25, 7, 4.75, 10, 9),
            Block.makeCuboidShape(11.25, 0.25, 7, 11.5, 10, 9),
            Block.makeCuboidShape(4.75, 0.25, 7, 5, 10.5, 9),
            Block.makeCuboidShape(11, 0.25, 7, 11.25, 10.5, 9),
            Block.makeCuboidShape(5, 0.25, 7, 5.25, 11, 9),
            Block.makeCuboidShape(10.75, 0.25, 7, 11, 11, 9),
            Block.makeCuboidShape(5.25, 0.25, 7, 5.5, 11.5, 9),
            Block.makeCuboidShape(10.5, 0.25, 7, 10.75, 11.5, 9),
            Block.makeCuboidShape(5.5, 0.25, 7, 5.75, 12, 9),
            Block.makeCuboidShape(10.25, 0.25, 7, 10.5, 12, 9),
            Block.makeCuboidShape(5.75, 0.25, 7, 6, 12.5, 9),
            Block.makeCuboidShape(10, 0.25, 7, 10.25, 12.5, 9),
            Block.makeCuboidShape(6, 0.25, 7, 6.25, 12.75, 9),
            Block.makeCuboidShape(9.75, 0.25, 7, 10, 13, 9),
            Block.makeCuboidShape(6.25, 0.25, 7, 6.5, 13.25, 9),
            Block.makeCuboidShape(9.5, 0.25, 7, 9.75, 13.5, 9),
            Block.makeCuboidShape(6.5, 0.25, 7, 6.75, 13.75, 9),
            Block.makeCuboidShape(9.25, 0.25, 7, 9.5, 14, 9),
            Block.makeCuboidShape(6.75, 0.25, 7, 7, 14.25, 9),
            Block.makeCuboidShape(9, 0.25, 7, 9.25, 14.5, 9),
            Block.makeCuboidShape(7, 0.25, 7, 7.25, 14.75, 9),
            Block.makeCuboidShape(8.75, 0.25, 7, 9, 14.75, 9),
            Block.makeCuboidShape(7.25, 0.25, 7, 7.5, 15.25, 9),
            Block.makeCuboidShape(8.5, 0.25, 7, 8.75, 15.25, 9),
            Block.makeCuboidShape(7.5, 0.25, 7, 8.5, 15.75, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(8.975, 0, 7.025, 9.975, 12, 9.025),
            Block.makeCuboidShape(6.975, 0.5, 15.525, 8.975, 1.5, 15.775),
            Block.makeCuboidShape(6.975, 0.5, 0.27500000000000036, 8.975, 1.5, 0.5250000000000004),
            Block.makeCuboidShape(6.975, 0.25, 15.275, 8.975, 2, 15.525),
            Block.makeCuboidShape(6.975, 0.25, 0.5250000000000004, 8.975, 2, 0.7750000000000004),
            Block.makeCuboidShape(6.975, 0.25, 15.025, 8.975, 2.5, 15.275),
            Block.makeCuboidShape(6.975, 0.25, 0.7750000000000004, 8.975, 2.5, 1.0250000000000004),
            Block.makeCuboidShape(6.975, 0.25, 14.775, 8.975, 3, 15.025),
            Block.makeCuboidShape(6.975, 0.25, 1.0250000000000004, 8.975, 3, 1.2750000000000004),
            Block.makeCuboidShape(6.975, 0.25, 14.525, 8.975, 3.5, 14.775),
            Block.makeCuboidShape(6.975, 0.25, 1.2750000000000004, 8.975, 3.5, 1.5250000000000004),
            Block.makeCuboidShape(6.975, 0.25, 14.275, 8.975, 4, 14.525),
            Block.makeCuboidShape(6.975, 0.25, 1.5250000000000004, 8.975, 4, 1.7750000000000004),
            Block.makeCuboidShape(6.975, 0.25, 14.025, 8.975, 4.5, 14.275),
            Block.makeCuboidShape(6.975, 0.25, 1.7750000000000004, 8.975, 4.5, 2.0250000000000004),
            Block.makeCuboidShape(6.975, 0.25, 13.775, 8.975, 5, 14.025),
            Block.makeCuboidShape(6.975, 0.25, 2.0250000000000004, 8.975, 5, 2.2750000000000004),
            Block.makeCuboidShape(6.975, 0.25, 13.525, 8.975, 5.5, 13.775),
            Block.makeCuboidShape(6.975, 0.25, 2.2750000000000004, 8.975, 5.5, 2.5250000000000004),
            Block.makeCuboidShape(6.975, 0.25, 13.275, 8.975, 6, 13.525),
            Block.makeCuboidShape(6.975, 0.25, 2.5250000000000004, 8.975, 6, 2.7750000000000004),
            Block.makeCuboidShape(6.975, 0.25, 13.025, 8.975, 6.5, 13.275),
            Block.makeCuboidShape(6.975, 0.25, 2.7750000000000004, 8.975, 6.5, 3.0250000000000004),
            Block.makeCuboidShape(6.975, 0.25, 12.775, 8.975, 7, 13.025),
            Block.makeCuboidShape(6.975, 0.25, 3.0250000000000004, 8.975, 7, 3.2750000000000004),
            Block.makeCuboidShape(6.975, 0.25, 12.525, 8.975, 7.5, 12.775),
            Block.makeCuboidShape(6.975, 0.25, 3.2750000000000004, 8.975, 7.5, 3.5250000000000004),
            Block.makeCuboidShape(6.975, 0.25, 12.275, 8.975, 8, 12.525),
            Block.makeCuboidShape(6.975, 0.25, 3.5250000000000004, 8.975, 8, 3.7750000000000004),
            Block.makeCuboidShape(6.975, 0.25, 12.025, 8.975, 8.5, 12.275),
            Block.makeCuboidShape(6.975, 0.25, 3.7750000000000004, 8.975, 8.5, 4.025),
            Block.makeCuboidShape(6.975, 0.25, 11.775, 8.975, 9, 12.025),
            Block.makeCuboidShape(6.975, 0.25, 4.025, 8.975, 9, 4.275),
            Block.makeCuboidShape(6.975, 0.25, 11.525, 8.975, 9.5, 11.775),
            Block.makeCuboidShape(6.975, 0.25, 4.275, 8.975, 9.5, 4.525),
            Block.makeCuboidShape(6.975, 0.25, 11.275, 8.975, 10, 11.525),
            Block.makeCuboidShape(6.975, 0.25, 4.525, 8.975, 10, 4.775),
            Block.makeCuboidShape(6.975, 0.25, 11.025, 8.975, 10.5, 11.275),
            Block.makeCuboidShape(6.975, 0.25, 4.775, 8.975, 10.5, 5.025),
            Block.makeCuboidShape(6.975, 0.25, 10.775, 8.975, 11, 11.025),
            Block.makeCuboidShape(6.975, 0.25, 5.025, 8.975, 11, 5.275),
            Block.makeCuboidShape(6.975, 0.25, 10.525, 8.975, 11.5, 10.775),
            Block.makeCuboidShape(6.975, 0.25, 5.275, 8.975, 11.5, 5.525),
            Block.makeCuboidShape(6.975, 0.25, 10.275, 8.975, 12, 10.525),
            Block.makeCuboidShape(6.975, 0.25, 5.525, 8.975, 12, 5.775),
            Block.makeCuboidShape(6.975, 0.25, 10.025, 8.975, 12.5, 10.275),
            Block.makeCuboidShape(6.975, 0.25, 5.775, 8.975, 12.5, 6.025),
            Block.makeCuboidShape(6.975, 0.25, 9.775, 8.975, 12.75, 10.025),
            Block.makeCuboidShape(6.975, 0.25, 6.025, 8.975, 13, 6.275),
            Block.makeCuboidShape(6.975, 0.25, 9.525, 8.975, 13.25, 9.775),
            Block.makeCuboidShape(6.975, 0.25, 6.275, 8.975, 13.5, 6.525),
            Block.makeCuboidShape(6.975, 0.25, 9.275, 8.975, 13.75, 9.525),
            Block.makeCuboidShape(6.975, 0.25, 6.525, 8.975, 14, 6.775),
            Block.makeCuboidShape(6.975, 0.25, 9.025, 8.975, 14.25, 9.275),
            Block.makeCuboidShape(6.975, 0.25, 6.775, 8.975, 14.5, 7.025),
            Block.makeCuboidShape(6.975, 0.25, 8.775, 8.975, 14.75, 9.025),
            Block.makeCuboidShape(6.975, 0.25, 7.025, 8.975, 14.75, 7.275),
            Block.makeCuboidShape(6.975, 0.25, 8.525, 8.975, 15.25, 8.775),
            Block.makeCuboidShape(6.975, 0.25, 7.275, 8.975, 15.25, 7.525),
            Block.makeCuboidShape(6.975, 0.25, 7.525, 8.975, 15.75, 8.525)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_O = Stream.of(
            Block.makeCuboidShape(6.025, 0, 7.025, 7.025, 12, 9.025),
            Block.makeCuboidShape(7.025, 0.5, 0.27500000000000036, 9.025, 1.5, 0.5250000000000004),
            Block.makeCuboidShape(7.025, 0.5, 15.525, 9.025, 1.5, 15.775),
            Block.makeCuboidShape(7.025, 0.25, 0.5250000000000004, 9.025, 2, 0.7750000000000004),
            Block.makeCuboidShape(7.025, 0.25, 15.275, 9.025, 2, 15.525),
            Block.makeCuboidShape(7.025, 0.25, 0.7750000000000004, 9.025, 2.5, 1.0250000000000004),
            Block.makeCuboidShape(7.025, 0.25, 15.025, 9.025, 2.5, 15.275),
            Block.makeCuboidShape(7.025, 0.25, 1.0250000000000004, 9.025, 3, 1.2750000000000004),
            Block.makeCuboidShape(7.025, 0.25, 14.775, 9.025, 3, 15.025),
            Block.makeCuboidShape(7.025, 0.25, 1.2750000000000004, 9.025, 3.5, 1.5250000000000004),
            Block.makeCuboidShape(7.025, 0.25, 14.525, 9.025, 3.5, 14.775),
            Block.makeCuboidShape(7.025, 0.25, 1.5250000000000004, 9.025, 4, 1.7750000000000004),
            Block.makeCuboidShape(7.025, 0.25, 14.275, 9.025, 4, 14.525),
            Block.makeCuboidShape(7.025, 0.25, 1.7750000000000004, 9.025, 4.5, 2.0250000000000004),
            Block.makeCuboidShape(7.025, 0.25, 14.025, 9.025, 4.5, 14.275),
            Block.makeCuboidShape(7.025, 0.25, 2.0250000000000004, 9.025, 5, 2.2750000000000004),
            Block.makeCuboidShape(7.025, 0.25, 13.775, 9.025, 5, 14.025),
            Block.makeCuboidShape(7.025, 0.25, 2.2750000000000004, 9.025, 5.5, 2.5250000000000004),
            Block.makeCuboidShape(7.025, 0.25, 13.525, 9.025, 5.5, 13.775),
            Block.makeCuboidShape(7.025, 0.25, 2.5250000000000004, 9.025, 6, 2.7750000000000004),
            Block.makeCuboidShape(7.025, 0.25, 13.275, 9.025, 6, 13.525),
            Block.makeCuboidShape(7.025, 0.25, 2.7750000000000004, 9.025, 6.5, 3.0250000000000004),
            Block.makeCuboidShape(7.025, 0.25, 13.025, 9.025, 6.5, 13.275),
            Block.makeCuboidShape(7.025, 0.25, 3.0250000000000004, 9.025, 7, 3.2750000000000004),
            Block.makeCuboidShape(7.025, 0.25, 12.775, 9.025, 7, 13.025),
            Block.makeCuboidShape(7.025, 0.25, 3.2750000000000004, 9.025, 7.5, 3.5250000000000004),
            Block.makeCuboidShape(7.025, 0.25, 12.525, 9.025, 7.5, 12.775),
            Block.makeCuboidShape(7.025, 0.25, 3.5250000000000004, 9.025, 8, 3.7750000000000004),
            Block.makeCuboidShape(7.025, 0.25, 12.275, 9.025, 8, 12.525),
            Block.makeCuboidShape(7.025, 0.25, 3.7750000000000004, 9.025, 8.5, 4.025),
            Block.makeCuboidShape(7.025, 0.25, 12.025, 9.025, 8.5, 12.275),
            Block.makeCuboidShape(7.025, 0.25, 4.025, 9.025, 9, 4.275),
            Block.makeCuboidShape(7.025, 0.25, 11.775, 9.025, 9, 12.025),
            Block.makeCuboidShape(7.025, 0.25, 4.275, 9.025, 9.5, 4.525),
            Block.makeCuboidShape(7.025, 0.25, 11.525, 9.025, 9.5, 11.775),
            Block.makeCuboidShape(7.025, 0.25, 4.525, 9.025, 10, 4.775),
            Block.makeCuboidShape(7.025, 0.25, 11.275, 9.025, 10, 11.525),
            Block.makeCuboidShape(7.025, 0.25, 4.775, 9.025, 10.5, 5.025),
            Block.makeCuboidShape(7.025, 0.25, 11.025, 9.025, 10.5, 11.275),
            Block.makeCuboidShape(7.025, 0.25, 5.025, 9.025, 11, 5.275),
            Block.makeCuboidShape(7.025, 0.25, 10.775, 9.025, 11, 11.025),
            Block.makeCuboidShape(7.025, 0.25, 5.275, 9.025, 11.5, 5.525),
            Block.makeCuboidShape(7.025, 0.25, 10.525, 9.025, 11.5, 10.775),
            Block.makeCuboidShape(7.025, 0.25, 5.525, 9.025, 12, 5.775),
            Block.makeCuboidShape(7.025, 0.25, 10.275, 9.025, 12, 10.525),
            Block.makeCuboidShape(7.025, 0.25, 5.775, 9.025, 12.5, 6.025),
            Block.makeCuboidShape(7.025, 0.25, 10.025, 9.025, 12.5, 10.275),
            Block.makeCuboidShape(7.025, 0.25, 6.025, 9.025, 12.75, 6.275),
            Block.makeCuboidShape(7.025, 0.25, 9.775, 9.025, 13, 10.025),
            Block.makeCuboidShape(7.025, 0.25, 6.275, 9.025, 13.25, 6.525),
            Block.makeCuboidShape(7.025, 0.25, 9.525, 9.025, 13.5, 9.775),
            Block.makeCuboidShape(7.025, 0.25, 6.525, 9.025, 13.75, 6.775),
            Block.makeCuboidShape(7.025, 0.25, 9.275, 9.025, 14, 9.525),
            Block.makeCuboidShape(7.025, 0.25, 6.775, 9.025, 14.25, 7.025),
            Block.makeCuboidShape(7.025, 0.25, 9.025, 9.025, 14.5, 9.275),
            Block.makeCuboidShape(7.025, 0.25, 7.025, 9.025, 14.75, 7.275),
            Block.makeCuboidShape(7.025, 0.25, 8.775, 9.025, 14.75, 9.025),
            Block.makeCuboidShape(7.025, 0.25, 7.275, 9.025, 15.25, 7.525),
            Block.makeCuboidShape(7.025, 0.25, 8.525, 9.025, 15.25, 8.775),
            Block.makeCuboidShape(7.025, 0.25, 7.525, 9.025, 15.75, 8.525)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7, 0, 6.050000000000001, 9, 12, 7.050000000000001),
            Block.makeCuboidShape(15.5, 0.5, 7.050000000000001, 15.75, 1.5, 9.05),
            Block.makeCuboidShape(0.25, 0.5, 7.050000000000001, 0.5, 1.5, 9.05),
            Block.makeCuboidShape(15.25, 0.25, 7.050000000000001, 15.5, 2, 9.05),
            Block.makeCuboidShape(0.5, 0.25, 7.050000000000001, 0.75, 2, 9.05),
            Block.makeCuboidShape(15, 0.25, 7.050000000000001, 15.25, 2.5, 9.05),
            Block.makeCuboidShape(0.75, 0.25, 7.050000000000001, 1, 2.5, 9.05),
            Block.makeCuboidShape(14.75, 0.25, 7.050000000000001, 15, 3, 9.05),
            Block.makeCuboidShape(1, 0.25, 7.050000000000001, 1.25, 3, 9.05),
            Block.makeCuboidShape(14.5, 0.25, 7.050000000000001, 14.75, 3.5, 9.05),
            Block.makeCuboidShape(1.25, 0.25, 7.050000000000001, 1.5, 3.5, 9.05),
            Block.makeCuboidShape(14.25, 0.25, 7.050000000000001, 14.5, 4, 9.05),
            Block.makeCuboidShape(1.5, 0.25, 7.050000000000001, 1.75, 4, 9.05),
            Block.makeCuboidShape(14, 0.25, 7.050000000000001, 14.25, 4.5, 9.05),
            Block.makeCuboidShape(1.75, 0.25, 7.050000000000001, 2, 4.5, 9.05),
            Block.makeCuboidShape(13.75, 0.25, 7.050000000000001, 14, 5, 9.05),
            Block.makeCuboidShape(2, 0.25, 7.050000000000001, 2.25, 5, 9.05),
            Block.makeCuboidShape(13.5, 0.25, 7.050000000000001, 13.75, 5.5, 9.05),
            Block.makeCuboidShape(2.25, 0.25, 7.050000000000001, 2.5, 5.5, 9.05),
            Block.makeCuboidShape(13.25, 0.25, 7.050000000000001, 13.5, 6, 9.05),
            Block.makeCuboidShape(2.5, 0.25, 7.050000000000001, 2.75, 6, 9.05),
            Block.makeCuboidShape(13, 0.25, 7.050000000000001, 13.25, 6.5, 9.05),
            Block.makeCuboidShape(2.75, 0.25, 7.050000000000001, 3, 6.5, 9.05),
            Block.makeCuboidShape(12.75, 0.25, 7.050000000000001, 13, 7, 9.05),
            Block.makeCuboidShape(3, 0.25, 7.050000000000001, 3.25, 7, 9.05),
            Block.makeCuboidShape(12.5, 0.25, 7.050000000000001, 12.75, 7.5, 9.05),
            Block.makeCuboidShape(3.25, 0.25, 7.050000000000001, 3.5, 7.5, 9.05),
            Block.makeCuboidShape(12.25, 0.25, 7.050000000000001, 12.5, 8, 9.05),
            Block.makeCuboidShape(3.5, 0.25, 7.050000000000001, 3.75, 8, 9.05),
            Block.makeCuboidShape(12, 0.25, 7.050000000000001, 12.25, 8.5, 9.05),
            Block.makeCuboidShape(3.75, 0.25, 7.050000000000001, 4, 8.5, 9.05),
            Block.makeCuboidShape(11.75, 0.25, 7.050000000000001, 12, 9, 9.05),
            Block.makeCuboidShape(4, 0.25, 7.050000000000001, 4.25, 9, 9.05),
            Block.makeCuboidShape(11.5, 0.25, 7.050000000000001, 11.75, 9.5, 9.05),
            Block.makeCuboidShape(4.25, 0.25, 7.050000000000001, 4.5, 9.5, 9.05),
            Block.makeCuboidShape(11.25, 0.25, 7.050000000000001, 11.5, 10, 9.05),
            Block.makeCuboidShape(4.5, 0.25, 7.050000000000001, 4.75, 10, 9.05),
            Block.makeCuboidShape(11, 0.25, 7.050000000000001, 11.25, 10.5, 9.05),
            Block.makeCuboidShape(4.75, 0.25, 7.050000000000001, 5, 10.5, 9.05),
            Block.makeCuboidShape(10.75, 0.25, 7.050000000000001, 11, 11, 9.05),
            Block.makeCuboidShape(5, 0.25, 7.050000000000001, 5.25, 11, 9.05),
            Block.makeCuboidShape(10.5, 0.25, 7.050000000000001, 10.75, 11.5, 9.05),
            Block.makeCuboidShape(5.25, 0.25, 7.050000000000001, 5.5, 11.5, 9.05),
            Block.makeCuboidShape(10.25, 0.25, 7.050000000000001, 10.5, 12, 9.05),
            Block.makeCuboidShape(5.5, 0.25, 7.050000000000001, 5.75, 12, 9.05),
            Block.makeCuboidShape(10, 0.25, 7.050000000000001, 10.25, 12.5, 9.05),
            Block.makeCuboidShape(5.75, 0.25, 7.050000000000001, 6, 12.5, 9.05),
            Block.makeCuboidShape(9.75, 0.25, 7.050000000000001, 10, 12.75, 9.05),
            Block.makeCuboidShape(6, 0.25, 7.050000000000001, 6.25, 13, 9.05),
            Block.makeCuboidShape(9.5, 0.25, 7.050000000000001, 9.75, 13.25, 9.05),
            Block.makeCuboidShape(6.25, 0.25, 7.050000000000001, 6.5, 13.5, 9.05),
            Block.makeCuboidShape(9.25, 0.25, 7.050000000000001, 9.5, 13.75, 9.05),
            Block.makeCuboidShape(6.5, 0.25, 7.050000000000001, 6.75, 14, 9.05),
            Block.makeCuboidShape(9, 0.25, 7.050000000000001, 9.25, 14.25, 9.05),
            Block.makeCuboidShape(6.75, 0.25, 7.050000000000001, 7, 14.5, 9.05),
            Block.makeCuboidShape(8.75, 0.25, 7.050000000000001, 9, 14.75, 9.05),
            Block.makeCuboidShape(7, 0.25, 7.050000000000001, 7.25, 14.75, 9.05),
            Block.makeCuboidShape(8.5, 0.25, 7.050000000000001, 8.75, 15.25, 9.05),
            Block.makeCuboidShape(7.25, 0.25, 7.050000000000001, 7.5, 15.25, 9.05),
            Block.makeCuboidShape(7.5, 0.25, 7.050000000000001, 8.5, 15.75, 9.05)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();


    public BaseTriangleSign(Properties properties)
    {
        super(properties);
    }


    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        switch (state.get(FACING))
        {
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_O;
            default:
                return SHAPE_N;
        }
    }

}

