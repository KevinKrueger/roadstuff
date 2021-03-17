package com.kevinkrueger.roadstuff.util;

import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.block.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.Properties;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks
{
    // Defaults
    private static final Material MATERIAL_DEFAULT = Material.IRON;
    private static final SoundType SOUND_DEFAULT = SoundType.METAL;
    private static final float HARDNESS_DEFAULT = 3f;
    private static final float RESISTANCE_DEFAULT = 10f;

    // Registration
    public static final RegistryObject<Block> METAL_POLE = register("metall_stange",
            () -> new MetalPole(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT, RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> CROSSWALKSIGN = register("crosswalksign",
            () -> new BaseRectangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> DELINEATORSIGN = register("delineatorsign",
            () -> new DelineatorSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT ).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> PASSAGE_FORBIDDEN_SIGN = register("passageforbiddensign",
            () -> new BaseRoundSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> STOP_SIGN = register("stopsign",
            () -> new BaseOctagonSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> PARK_SIGN = register("parksign",
            () -> new BaseRectangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> ONEWAY_SIGN = register("onewaysign",
            ()  -> new BaseRectangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> GIVEWAY_SIGN = register("givewaysign",
            () -> new BaseInvertedTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> GUIDE_CONE = register("guidecone",
            () -> new GuideCone(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> STREET_LIGHT = register("streetlight",
            () -> new StreetLight(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)
                    .setLightLevel(new ToIntFunction<BlockState>() {
                        @Override
                        public int applyAsInt(BlockState value) {
                            return 15;
                        }
                    })));

    public static final RegistryObject<Block> CRASH_PROTECTION_BOLLARD = register("crashprotectionbollard",
            () -> new CrashProtectionBollard(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> DOUBLECURVE_LEFTSIGN = register("doublecurve_leftsign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> WARNING_TRIANGLE = register("warningtriangle",
            () -> new WarningTriangle(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)
                    .setLightLevel(new ToIntFunction<BlockState>() {
                        @Override
                        public int applyAsInt(BlockState value) {
                            return 5;
                        }
                    })));

    public static final RegistryObject<Block> WARNBARQUE = register("warnbarque",
            () -> new Warnbarque(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)
                    .setLightLevel(new ToIntFunction<BlockState>() {
                        @Override
                        public int applyAsInt(BlockState value) {
                            return 12;
                        }
                    })));


    public static void register() { }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(RoadStuff.ROAD_STUFF_TAB)));
        return toReturn;
    }
}
