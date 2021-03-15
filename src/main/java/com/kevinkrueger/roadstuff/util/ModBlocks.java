package com.kevinkrueger.roadstuff.util;

import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.block.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    // Defaults
    private static final Material MATERIAL_DEFAULT = Material.IRON;
    private static final SoundType SOUND_DEFAULT = SoundType.METAL;

    // Registration
    public static final RegistryObject<Block> METAL_POLE = register("metall_stange",
            () -> new MetalPole(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(3f, 10f).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> CROSSWALKSIGN = register("crosswalksign",
            () -> new BaseRectangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(3f, 10f).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> DELINEATORSIGN = register("delineatorsign",
            () -> new DelineatorSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(3f, 10f).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> PASSAGE_FORBIDDEN_SIGN = register("passageforbiddensign",
            () -> new BaseRoundSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(3f, 10f).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> STOP_SIGN = register("stopsign",
            () -> new BaseOctagonSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(3f, 10f).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> PARK_SIGN = register("q",
            () -> new BaseRectangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(3f, 10f).sound(SOUND_DEFAULT)));

    public static void register() { }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(RoadStuff.ROAD_STUFF_TAB)));
        return toReturn;
    }
}
