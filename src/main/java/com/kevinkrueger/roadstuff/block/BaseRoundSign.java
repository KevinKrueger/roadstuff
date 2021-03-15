package com.kevinkrueger.roadstuff.block;

import com.kevinkrueger.roadstuff.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class BaseRoundSign extends BlockBase {
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 0, 9, 9, 12, 10),
            Block.makeCuboidShape(0.25, 6, 7, 0.5, 10, 9),
            Block.makeCuboidShape(15.5, 6, 7, 15.75, 10, 9),
            Block.makeCuboidShape(0.5, 5.25, 7, 0.75, 10.75, 9),
            Block.makeCuboidShape(15.25, 5.25, 7, 15.5, 10.75, 9),
            Block.makeCuboidShape(0.75, 4.75, 7, 1, 11.25, 9),
            Block.makeCuboidShape(15, 4.75, 7, 15.25, 11.25, 9),
            Block.makeCuboidShape(1, 4.25, 7, 1.25, 11.75, 9),
            Block.makeCuboidShape(14.75, 4.25, 7, 15, 11.75, 9),
            Block.makeCuboidShape(1.25, 3.75, 7, 1.5, 12.25, 9),
            Block.makeCuboidShape(14.5, 3.75, 7, 14.75, 12.25, 9),
            Block.makeCuboidShape(1.5, 3.5, 7, 1.75, 12.5, 9),
            Block.makeCuboidShape(14.25, 3.5, 7, 14.5, 12.5, 9),
            Block.makeCuboidShape(1.75, 3, 7, 2, 13, 9),
            Block.makeCuboidShape(14, 3, 7, 14.25, 13, 9),
            Block.makeCuboidShape(2, 2.75, 7, 2.25, 13.25, 9),
            Block.makeCuboidShape(13.75, 2.75, 7, 14, 13.25, 9),
            Block.makeCuboidShape(2.25, 2.5, 7, 2.5, 13.5, 9),
            Block.makeCuboidShape(13.5, 2.5, 7, 13.75, 13.5, 9),
            Block.makeCuboidShape(2.5, 2.25, 7, 2.75, 13.75, 9),
            Block.makeCuboidShape(13.25, 2.25, 7, 13.5, 13.75, 9),
            Block.makeCuboidShape(2.75, 2, 7, 3, 14, 9),
            Block.makeCuboidShape(13, 2, 7, 13.25, 14, 9),
            Block.makeCuboidShape(3, 1.75, 7, 3.5, 14.25, 9),
            Block.makeCuboidShape(12.5, 1.75, 7, 13, 14.25, 9),
            Block.makeCuboidShape(3.5, 1.5, 7, 3.75, 14.5, 9),
            Block.makeCuboidShape(12.25, 1.5, 7, 12.5, 14.5, 9),
            Block.makeCuboidShape(3.75, 1.25, 7, 4.25, 14.75, 9),
            Block.makeCuboidShape(11.75, 1.25, 7, 12.25, 14.75, 9),
            Block.makeCuboidShape(4.25, 1, 7, 4.75, 15, 9),
            Block.makeCuboidShape(11.25, 1, 7, 11.75, 15, 9),
            Block.makeCuboidShape(4.75, 0.75, 7, 5.25, 15.25, 9),
            Block.makeCuboidShape(10.75, 0.75, 7, 11.25, 15.25, 9),
            Block.makeCuboidShape(5.25, 0.5, 7, 6, 15.5, 9),
            Block.makeCuboidShape(10, 0.5, 7, 10.75, 15.5, 9),
            Block.makeCuboidShape(6, 0.25, 7, 7.75, 15.75, 9),
            Block.makeCuboidShape(8.25, 0.25, 7, 10, 15.75, 9),
            Block.makeCuboidShape(7.75, 0.25, 7, 8.25, 16, 9),
            Block.makeCuboidShape(15.75, 7.75, 7, 16, 8.25, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(9.163461538461538, 0, 7.240384615384615, 10.163461538461538, 12, 9.240384615384615),
            Block.makeCuboidShape(7.163461538461538, 6, 15.740384615384615, 9.163461538461538, 10, 15.990384615384615),
            Block.makeCuboidShape(7.163461538461538, 6, 0.490384615384615, 9.163461538461538, 10, 0.740384615384615),
            Block.makeCuboidShape(7.163461538461538, 5.25, 15.490384615384615, 9.163461538461538, 10.75, 15.740384615384615),
            Block.makeCuboidShape(7.163461538461538, 5.25, 0.740384615384615, 9.163461538461538, 10.75, 0.990384615384615),
            Block.makeCuboidShape(7.163461538461538, 4.75, 15.240384615384615, 9.163461538461538, 11.25, 15.490384615384615),
            Block.makeCuboidShape(7.163461538461538, 4.75, 0.990384615384615, 9.163461538461538, 11.25, 1.240384615384615),
            Block.makeCuboidShape(7.163461538461538, 4.25, 14.990384615384615, 9.163461538461538, 11.75, 15.240384615384615),
            Block.makeCuboidShape(7.163461538461538, 4.25, 1.240384615384615, 9.163461538461538, 11.75, 1.490384615384615),
            Block.makeCuboidShape(7.163461538461538, 3.75, 14.740384615384615, 9.163461538461538, 12.25, 14.990384615384615),
            Block.makeCuboidShape(7.163461538461538, 3.75, 1.490384615384615, 9.163461538461538, 12.25, 1.740384615384615),
            Block.makeCuboidShape(7.163461538461538, 3.5, 14.490384615384615, 9.163461538461538, 12.5, 14.740384615384615),
            Block.makeCuboidShape(7.163461538461538, 3.5, 1.740384615384615, 9.163461538461538, 12.5, 1.990384615384615),
            Block.makeCuboidShape(7.163461538461538, 3, 14.240384615384615, 9.163461538461538, 13, 14.490384615384615),
            Block.makeCuboidShape(7.163461538461538, 3, 1.990384615384615, 9.163461538461538, 13, 2.240384615384615),
            Block.makeCuboidShape(7.163461538461538, 2.75, 13.990384615384615, 9.163461538461538, 13.25, 14.240384615384615),
            Block.makeCuboidShape(7.163461538461538, 2.75, 2.240384615384615, 9.163461538461538, 13.25, 2.490384615384615),
            Block.makeCuboidShape(7.163461538461538, 2.5, 13.740384615384615, 9.163461538461538, 13.5, 13.990384615384615),
            Block.makeCuboidShape(7.163461538461538, 2.5, 2.490384615384615, 9.163461538461538, 13.5, 2.740384615384615),
            Block.makeCuboidShape(7.163461538461538, 2.25, 13.490384615384615, 9.163461538461538, 13.75, 13.740384615384615),
            Block.makeCuboidShape(7.163461538461538, 2.25, 2.740384615384615, 9.163461538461538, 13.75, 2.990384615384615),
            Block.makeCuboidShape(7.163461538461538, 2, 13.240384615384615, 9.163461538461538, 14, 13.490384615384615),
            Block.makeCuboidShape(7.163461538461538, 2, 2.990384615384615, 9.163461538461538, 14, 3.240384615384615),
            Block.makeCuboidShape(7.163461538461538, 1.75, 12.740384615384615, 9.163461538461538, 14.25, 13.240384615384615),
            Block.makeCuboidShape(7.163461538461538, 1.75, 3.240384615384615, 9.163461538461538, 14.25, 3.740384615384615),
            Block.makeCuboidShape(7.163461538461538, 1.5, 12.490384615384615, 9.163461538461538, 14.5, 12.740384615384615),
            Block.makeCuboidShape(7.163461538461538, 1.5, 3.740384615384615, 9.163461538461538, 14.5, 3.990384615384615),
            Block.makeCuboidShape(7.163461538461538, 1.25, 11.990384615384615, 9.163461538461538, 14.75, 12.490384615384615),
            Block.makeCuboidShape(7.163461538461538, 1.25, 3.990384615384615, 9.163461538461538, 14.75, 4.490384615384615),
            Block.makeCuboidShape(7.163461538461538, 1, 11.490384615384615, 9.163461538461538, 15, 11.990384615384615),
            Block.makeCuboidShape(7.163461538461538, 1, 4.490384615384615, 9.163461538461538, 15, 4.990384615384615),
            Block.makeCuboidShape(7.163461538461538, 0.75, 10.990384615384615, 9.163461538461538, 15.25, 11.490384615384615),
            Block.makeCuboidShape(7.163461538461538, 0.75, 4.990384615384615, 9.163461538461538, 15.25, 5.490384615384615),
            Block.makeCuboidShape(7.163461538461538, 0.5, 10.240384615384615, 9.163461538461538, 15.5, 10.990384615384615),
            Block.makeCuboidShape(7.163461538461538, 0.5, 5.490384615384615, 9.163461538461538, 15.5, 6.240384615384615),
            Block.makeCuboidShape(7.163461538461538, 0.25, 8.490384615384615, 9.163461538461538, 15.75, 10.240384615384615),
            Block.makeCuboidShape(7.163461538461538, 0.25, 6.240384615384615, 9.163461538461538, 15.75, 7.990384615384615),
            Block.makeCuboidShape(7.163461538461538, 0.25, 7.990384615384615, 9.163461538461538, 16, 8.490384615384615),
            Block.makeCuboidShape(7.163461538461538, 7.75, 0.24038461538461497, 9.163461538461538, 8.25, 0.490384615384615)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_O = Stream.of(
            Block.makeCuboidShape(6.240384615384615, 0, 6.836538461538462, 7.240384615384615, 12, 8.836538461538462),
            Block.makeCuboidShape(7.240384615384615, 6, 0.08653846153846168, 9.240384615384615, 10, 0.3365384615384617),
            Block.makeCuboidShape(7.240384615384615, 6, 15.336538461538462, 9.240384615384615, 10, 15.586538461538462),
            Block.makeCuboidShape(7.240384615384615, 5.25, 0.3365384615384617, 9.240384615384615, 10.75, 0.5865384615384617),
            Block.makeCuboidShape(7.240384615384615, 5.25, 15.086538461538462, 9.240384615384615, 10.75, 15.336538461538462),
            Block.makeCuboidShape(7.240384615384615, 4.75, 0.5865384615384617, 9.240384615384615, 11.25, 0.8365384615384617),
            Block.makeCuboidShape(7.240384615384615, 4.75, 14.836538461538462, 9.240384615384615, 11.25, 15.086538461538462),
            Block.makeCuboidShape(7.240384615384615, 4.25, 0.8365384615384617, 9.240384615384615, 11.75, 1.0865384615384617),
            Block.makeCuboidShape(7.240384615384615, 4.25, 14.586538461538462, 9.240384615384615, 11.75, 14.836538461538462),
            Block.makeCuboidShape(7.240384615384615, 3.75, 1.0865384615384617, 9.240384615384615, 12.25, 1.3365384615384617),
            Block.makeCuboidShape(7.240384615384615, 3.75, 14.336538461538462, 9.240384615384615, 12.25, 14.586538461538462),
            Block.makeCuboidShape(7.240384615384615, 3.5, 1.3365384615384617, 9.240384615384615, 12.5, 1.5865384615384617),
            Block.makeCuboidShape(7.240384615384615, 3.5, 14.086538461538462, 9.240384615384615, 12.5, 14.336538461538462),
            Block.makeCuboidShape(7.240384615384615, 3, 1.5865384615384617, 9.240384615384615, 13, 1.8365384615384617),
            Block.makeCuboidShape(7.240384615384615, 3, 13.836538461538462, 9.240384615384615, 13, 14.086538461538462),
            Block.makeCuboidShape(7.240384615384615, 2.75, 1.8365384615384617, 9.240384615384615, 13.25, 2.0865384615384617),
            Block.makeCuboidShape(7.240384615384615, 2.75, 13.586538461538462, 9.240384615384615, 13.25, 13.836538461538462),
            Block.makeCuboidShape(7.240384615384615, 2.5, 2.0865384615384617, 9.240384615384615, 13.5, 2.3365384615384617),
            Block.makeCuboidShape(7.240384615384615, 2.5, 13.336538461538462, 9.240384615384615, 13.5, 13.586538461538462),
            Block.makeCuboidShape(7.240384615384615, 2.25, 2.3365384615384617, 9.240384615384615, 13.75, 2.5865384615384617),
            Block.makeCuboidShape(7.240384615384615, 2.25, 13.086538461538462, 9.240384615384615, 13.75, 13.336538461538462),
            Block.makeCuboidShape(7.240384615384615, 2, 2.5865384615384617, 9.240384615384615, 14, 2.8365384615384617),
            Block.makeCuboidShape(7.240384615384615, 2, 12.836538461538462, 9.240384615384615, 14, 13.086538461538462),
            Block.makeCuboidShape(7.240384615384615, 1.75, 2.8365384615384617, 9.240384615384615, 14.25, 3.3365384615384617),
            Block.makeCuboidShape(7.240384615384615, 1.75, 12.336538461538462, 9.240384615384615, 14.25, 12.836538461538462),
            Block.makeCuboidShape(7.240384615384615, 1.5, 3.3365384615384617, 9.240384615384615, 14.5, 3.5865384615384617),
            Block.makeCuboidShape(7.240384615384615, 1.5, 12.086538461538462, 9.240384615384615, 14.5, 12.336538461538462),
            Block.makeCuboidShape(7.240384615384615, 1.25, 3.5865384615384617, 9.240384615384615, 14.75, 4.086538461538462),
            Block.makeCuboidShape(7.240384615384615, 1.25, 11.586538461538462, 9.240384615384615, 14.75, 12.086538461538462),
            Block.makeCuboidShape(7.240384615384615, 1, 4.086538461538462, 9.240384615384615, 15, 4.586538461538462),
            Block.makeCuboidShape(7.240384615384615, 1, 11.086538461538462, 9.240384615384615, 15, 11.586538461538462),
            Block.makeCuboidShape(7.240384615384615, 0.75, 4.586538461538462, 9.240384615384615, 15.25, 5.086538461538462),
            Block.makeCuboidShape(7.240384615384615, 0.75, 10.586538461538462, 9.240384615384615, 15.25, 11.086538461538462),
            Block.makeCuboidShape(7.240384615384615, 0.5, 5.086538461538462, 9.240384615384615, 15.5, 5.836538461538462),
            Block.makeCuboidShape(7.240384615384615, 0.5, 9.836538461538462, 9.240384615384615, 15.5, 10.586538461538462),
            Block.makeCuboidShape(7.240384615384615, 0.25, 5.836538461538462, 9.240384615384615, 15.75, 7.586538461538462),
            Block.makeCuboidShape(7.240384615384615, 0.25, 8.086538461538462, 9.240384615384615, 15.75, 9.836538461538462),
            Block.makeCuboidShape(7.240384615384615, 0.25, 7.586538461538462, 9.240384615384615, 16, 8.086538461538462),
            Block.makeCuboidShape(7.240384615384615, 7.75, 15.586538461538462, 9.240384615384615, 8.25, 15.836538461538462)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7.403846153846153, 0, 6.076923076923077, 9.403846153846153, 12, 7.076923076923077),
            Block.makeCuboidShape(15.903846153846153, 6, 7.076923076923077, 16.153846153846153, 10, 9.076923076923077),
            Block.makeCuboidShape(0.6538461538461533, 6, 7.076923076923077, 0.9038461538461533, 10, 9.076923076923077),
            Block.makeCuboidShape(15.653846153846153, 5.25, 7.076923076923077, 15.903846153846153, 10.75, 9.076923076923077),
            Block.makeCuboidShape(0.9038461538461533, 5.25, 7.076923076923077, 1.1538461538461533, 10.75, 9.076923076923077),
            Block.makeCuboidShape(15.403846153846153, 4.75, 7.076923076923077, 15.653846153846153, 11.25, 9.076923076923077),
            Block.makeCuboidShape(1.1538461538461533, 4.75, 7.076923076923077, 1.4038461538461533, 11.25, 9.076923076923077),
            Block.makeCuboidShape(15.153846153846153, 4.25, 7.076923076923077, 15.403846153846153, 11.75, 9.076923076923077),
            Block.makeCuboidShape(1.4038461538461533, 4.25, 7.076923076923077, 1.6538461538461533, 11.75, 9.076923076923077),
            Block.makeCuboidShape(14.903846153846153, 3.75, 7.076923076923077, 15.153846153846153, 12.25, 9.076923076923077),
            Block.makeCuboidShape(1.6538461538461533, 3.75, 7.076923076923077, 1.9038461538461533, 12.25, 9.076923076923077),
            Block.makeCuboidShape(14.653846153846153, 3.5, 7.076923076923077, 14.903846153846153, 12.5, 9.076923076923077),
            Block.makeCuboidShape(1.9038461538461533, 3.5, 7.076923076923077, 2.1538461538461533, 12.5, 9.076923076923077),
            Block.makeCuboidShape(14.403846153846153, 3, 7.076923076923077, 14.653846153846153, 13, 9.076923076923077),
            Block.makeCuboidShape(2.1538461538461533, 3, 7.076923076923077, 2.4038461538461533, 13, 9.076923076923077),
            Block.makeCuboidShape(14.153846153846153, 2.75, 7.076923076923077, 14.403846153846153, 13.25, 9.076923076923077),
            Block.makeCuboidShape(2.4038461538461533, 2.75, 7.076923076923077, 2.6538461538461533, 13.25, 9.076923076923077),
            Block.makeCuboidShape(13.903846153846153, 2.5, 7.076923076923077, 14.153846153846153, 13.5, 9.076923076923077),
            Block.makeCuboidShape(2.6538461538461533, 2.5, 7.076923076923077, 2.9038461538461533, 13.5, 9.076923076923077),
            Block.makeCuboidShape(13.653846153846153, 2.25, 7.076923076923077, 13.903846153846153, 13.75, 9.076923076923077),
            Block.makeCuboidShape(2.9038461538461533, 2.25, 7.076923076923077, 3.1538461538461533, 13.75, 9.076923076923077),
            Block.makeCuboidShape(13.403846153846153, 2, 7.076923076923077, 13.653846153846153, 14, 9.076923076923077),
            Block.makeCuboidShape(3.1538461538461533, 2, 7.076923076923077, 3.4038461538461533, 14, 9.076923076923077),
            Block.makeCuboidShape(12.903846153846153, 1.75, 7.076923076923077, 13.403846153846153, 14.25, 9.076923076923077),
            Block.makeCuboidShape(3.4038461538461533, 1.75, 7.076923076923077, 3.9038461538461533, 14.25, 9.076923076923077),
            Block.makeCuboidShape(12.653846153846153, 1.5, 7.076923076923077, 12.903846153846153, 14.5, 9.076923076923077),
            Block.makeCuboidShape(3.9038461538461533, 1.5, 7.076923076923077, 4.153846153846153, 14.5, 9.076923076923077),
            Block.makeCuboidShape(12.153846153846153, 1.25, 7.076923076923077, 12.653846153846153, 14.75, 9.076923076923077),
            Block.makeCuboidShape(4.153846153846153, 1.25, 7.076923076923077, 4.653846153846153, 14.75, 9.076923076923077),
            Block.makeCuboidShape(11.653846153846153, 1, 7.076923076923077, 12.153846153846153, 15, 9.076923076923077),
            Block.makeCuboidShape(4.653846153846153, 1, 7.076923076923077, 5.153846153846153, 15, 9.076923076923077),
            Block.makeCuboidShape(11.153846153846153, 0.75, 7.076923076923077, 11.653846153846153, 15.25, 9.076923076923077),
            Block.makeCuboidShape(5.153846153846153, 0.75, 7.076923076923077, 5.653846153846153, 15.25, 9.076923076923077),
            Block.makeCuboidShape(10.403846153846153, 0.5, 7.076923076923077, 11.153846153846153, 15.5, 9.076923076923077),
            Block.makeCuboidShape(5.653846153846153, 0.5, 7.076923076923077, 6.403846153846153, 15.5, 9.076923076923077),
            Block.makeCuboidShape(8.653846153846153, 0.25, 7.076923076923077, 10.403846153846153, 15.75, 9.076923076923077),
            Block.makeCuboidShape(6.403846153846153, 0.25, 7.076923076923077, 8.153846153846153, 15.75, 9.076923076923077),
            Block.makeCuboidShape(8.153846153846153, 0.25, 7.076923076923077, 8.653846153846153, 16, 9.076923076923077),
            Block.makeCuboidShape(0.4038461538461533, 7.75, 7.076923076923077, 0.6538461538461533, 8.25, 9.076923076923077)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public BaseRoundSign(Properties properties) {
        super(properties);
    }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING))
        {
            case NORTH:
                return SHAPE_N;
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

    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation rot)
    {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn)
    {
        return state.rotate(mirrorIn.toRotation((state.get(FACING))));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }

}
