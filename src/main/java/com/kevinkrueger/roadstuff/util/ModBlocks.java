package com.kevinkrueger.roadstuff.util;

import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.block.base.*;
import com.kevinkrueger.roadstuff.block.individual.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import org.lwjgl.system.CallbackI;

import java.sql.ResultSet;
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
    public static final RegistryObject<Block> STEELPOLE_SIGNS = register("steelpole_signs",
            () -> new SteelPoleSigns(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT, RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> STEELPOLE_LIGHTS =register("steelpole_lights",
            () -> new SteelPoleLights(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT, RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> CROSSWALK_SIGN = register("crosswalksign",
            () -> new BaseRectangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> DELINEATORSIGN = register("delineatorsign",
            () -> new DelineatorSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT ).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> PASSAGE_FORBIDDEN_SIGN = register("passageforbiddensign",
            () -> new BaseRoundSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> DRIVINGDIRECTON_LEFTSIGN = register("drivingdirection_leftsign",
            () -> new BaseRoundSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> DRIVINGDIRECTION_RIGHTSIGN = register("drivingdirection_rightsign",
            () -> new BaseRoundSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> BUSSTOPSIGN = register("busstopsign",
            () -> new BaseRoundSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> STOPBAN_SIGN = register("stopban_sign",
            () -> new BaseRoundSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> PROHIBITIONOFALLTPYES_SIGN = register("prohibitionofalltypessign",
            () -> new BaseRoundSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> RESTRICTEDSTOP_SIGN = register("restrictedstopsign",
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

    public static final RegistryObject<Block> NOTHROUGHROAD_SIGN = register("nothroughroad_sign",
            ()  -> new BaseRectangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> TUNNEL_SIGN = register("tunnel_sign",
            ()  -> new BaseRectangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> TUNNEL_END_SIGN = register("tunnel_end_sign",
            ()  -> new BaseRectangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> GASSTATION_SIGN = register("gasstation_sign",
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
                    .setLightLevel(value -> 15)));

    public static final RegistryObject<Block> DOUBLE_STREET_LIGHT = register("doublestreetlight",
            () -> new DoubleStreetLight(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)
                    .setLightLevel(value -> 15)));

    public static final RegistryObject<Block> CRASH_PROTECTION_BOLLARD = register("crashprotectionbollard",
            () -> new CrashProtectionBollard(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> DOUBLECURVE_LEFTSIGN = register("doublecurve_leftsign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> DOUBLECURVE_RIGHTSIGN = register("doublecurve_rightsign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> RIGHTCURVE_SIGN = register("rightcurvesign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> LEFTCURVE_SIGN = register("leftcurvesign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> TWOWAYTRAFFIC_SIGN = register("twowaytrafficsign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> ONESIDEDLANENARROWING_SIGN_RIGHT = register("onesidedlanenarrowingsign_right",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> ONESIDEDLANENARROWING_SIGN_LEFT = register("onesidedlanenarrowingsign_left",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT, RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> TWOSIDEDLANENARROWING_SIGN = register("twosidedlanenarrowingsign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> GROUNDHUMP_SIGN = register("groundhump_sign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> SHORE_SIGN = register("shore_sign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> RIDERS_SIGN = register("riders_sign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> AIRPLANES_SIGN = register("airplanes_sign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> TRAFFICLIGHTS_SIGN = register("trafficlights_sign",
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

    public static final RegistryObject<Block> BARRIER = register("barrier",
            () -> new Barrier(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> ATTENTION_SIGN = register("attention_sign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> ATTENTION_CROSSWALKSIGN = register("attention_crosswalksign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> ONETIME_RIGHTOFWAY_SIGN = register("onetime_rightofway_sign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> CROSSINGSIGN = register("crossingsign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> CONSTRUCTIONSITE_SIGN = register("constructionsitesign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> TRAFFICCIRCLE_SIGN = register("trafficcirclesign",
            () -> new BaseTriangleSign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<Block> RIGHTOFWAY_SIGN = register("rightofwaysign",
            () -> new RightOfWaySign(AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    // For init
    public static void register() { }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(RoadStuff.ROAD_STUFF_TAB)));
        return toReturn;
    }
}
