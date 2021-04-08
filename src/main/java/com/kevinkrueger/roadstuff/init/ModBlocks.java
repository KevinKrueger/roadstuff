package com.kevinkrueger.roadstuff.init;

import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.base.BlockBase;
import com.kevinkrueger.roadstuff.block.base.*;
import com.kevinkrueger.roadstuff.block.individual.*;
import com.kevinkrueger.roadstuff.network.ILogger;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks implements ILogger
{
    // Defaults
    private static final Material MATERIAL_DEFAULT = Material.IRON;
    private static final SoundType SOUND_DEFAULT = SoundType.METAL;
    private static final float HARDNESS_DEFAULT = 3f;
    private static final float RESISTANCE_DEFAULT = 10f;

    // Registration
    public static final RegistryObject<BlockBase> STEELPOLE_SIGNS = register(
            () -> new SteelPoleSigns("steelpole_signs",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT, RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> STEELPOLE_LIGHTS =register(
            () -> new SteelPoleLights("steelpole_lights",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT, RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> CROSSWALK_SIGN = register(
            () -> new BaseRectangleSign("crosswalksign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> DELINEATORSIGN = register(
            () -> new DelineatorSign("delineatorsign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT ).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> PASSAGE_FORBIDDEN_SIGN = register(
            () -> new BaseRoundSign("passageforbiddensign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> DRIVINGDIRECTON_LEFTSIGN = register(
            () -> new BaseRoundSign("drivingdirection_leftsign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> DRIVINGDIRECTION_RIGHTSIGN = register(
            () -> new BaseRoundSign("drivingdirection_rightsign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> BUSSTOPSIGN = register(
            () -> new BaseRoundSign("busstopsign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> STOPBAN_SIGN = register(
            () -> new BaseRoundSign("stopban_sign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> PROHIBITIONOFALLTPYES_SIGN = register(
            () -> new BaseRoundSign("prohibitionofalltypessign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> RESTRICTEDSTOP_SIGN = register(
            () -> new BaseRoundSign("restrictedstopsign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> STOP_SIGN = register(
            () -> new BaseOctagonSign("stopsign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> PARK_SIGN = register(
            () -> new BaseRectangleSign("parksign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> ONEWAY_SIGN = register(
            ()  -> new BaseRectangleSign("onewaysign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> NOTHROUGHROAD_SIGN = register(
            ()  -> new BaseRectangleSign("nothroughroad_sign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> TUNNEL_SIGN = register(
            ()  -> new BaseRectangleSign("tunnel_sign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> TUNNEL_END_SIGN = register(
            ()  -> new BaseRectangleSign("tunnel_end_sign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> GASSTATION_SIGN = register(
            ()  -> new BaseRectangleSign("gasstation_sign", AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> GIVEWAY_SIGN =
            register(() -> new BaseInvertedTriangleSign("givewaysign", AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> GUIDE_CONE = register(
            () -> new GuideCone("guidecone",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> STREET_LIGHT = register(
            () -> new StreetLight("streetlight",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)
                    .setLightLevel(value -> 15))
                    .setToolTipp( "Use: '"+ "Steel Pole For Lights" +"'", TextFormatting.RED));

    public static final RegistryObject<BlockBase> DOUBLE_STREET_LIGHT = register(
            () -> new DoubleStreetLight("doublestreetlight",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)
                    .setLightLevel(value -> 15))
                    .setToolTipp( "Use: '"+ "Steel Pole For Lights" +"'", TextFormatting.RED));

    public static final RegistryObject<BlockBase> CRASH_PROTECTION_BOLLARD = register(
            () -> new CrashProtectionBollard("crashprotectionbollard",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> DOUBLECURVE_LEFTSIGN = register(
            () -> new BaseTriangleSign("doublecurve_leftsign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> DOUBLECURVE_RIGHTSIGN = register(
            () -> new BaseTriangleSign("doublecurve_rightsign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> RIGHTCURVE_SIGN = register(
            () -> new BaseTriangleSign("rightcurvesign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> LEFTCURVE_SIGN = register(
            () -> new BaseTriangleSign("leftcurvesign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> TWOWAYTRAFFIC_SIGN = register(
            () -> new BaseTriangleSign("twowaytrafficsign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> ONESIDEDLANENARROWING_SIGN_RIGHT = register(
            () -> new BaseTriangleSign("onesidedlanenarrowingsign_right",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> ONESIDEDLANENARROWING_SIGN_LEFT = register(
            () -> new BaseTriangleSign("onesidedlanenarrowingsign_left",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT, RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> TWOSIDEDLANENARROWING_SIGN = register(
            () -> new BaseTriangleSign("twosidedlanenarrowingsign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> GROUNDHUMP_SIGN = register(
            () -> new BaseTriangleSign("groundhump_sign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> SHORE_SIGN = register(
            () -> new BaseTriangleSign("shore_sign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> RIDERS_SIGN = register(
            () -> new BaseTriangleSign("riders_sign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> AIRPLANES_SIGN = register(
            () -> new BaseTriangleSign("airplanes_sign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> TRAFFICLIGHTS_SIGN = register(
            () -> new BaseTriangleSign("trafficlights_sign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> WARNING_TRIANGLE = register(
            () -> new WarningTriangle("warningtriangle",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)
                    .setLightLevel(value -> 5)));

    public static final RegistryObject<BlockBase> WARNBARQUE = register(
            () -> new Warnbarque("warnbarque",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)
                    .setLightLevel(value -> 12)));

    public static final RegistryObject<BlockBase> BARRIER = register(
            () -> new Barrier("barrier",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> ATTENTION_SIGN = register(
            () -> new BaseTriangleSign("attention_sign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> ATTENTION_CROSSWALKSIGN = register(
            () -> new BaseTriangleSign("attention_crosswalksign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> ONETIME_RIGHTOFWAY_SIGN = register(
            () -> new BaseTriangleSign("onetime_rightofway_sign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> CROSSINGSIGN = register(
            () -> new BaseTriangleSign("crossingsign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> CONSTRUCTIONSITE_SIGN = register(
            () -> new BaseTriangleSign("constructionsitesign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> TRAFFICCIRCLE_SIGN = register(
            () -> new BaseTriangleSign("trafficcirclesign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> RIGHTOFWAY_SIGN = register(
            () -> new RightOfWaySign("rightofwaysign",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> STREETLIGHT_STONESLAB = register(
            () -> new BasePoleSlab("streetlight_stoneslab",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> STREETLIGHT_COBBLESTONESLAB = register(
            () -> new BasePoleSlab("streetlight_cobblestoneslab",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));

    public static final RegistryObject<BlockBase> RSCRAFTINGTABLE = register(
            () -> new RSCraftingTable("rscraftingtable",AbstractBlock.Properties.create(MATERIAL_DEFAULT)
                    .hardnessAndResistance(HARDNESS_DEFAULT,RESISTANCE_DEFAULT).sound(SOUND_DEFAULT)));


    // For init
    public static void register() { }

    private static <T extends BlockBase> RegistryObject<T> register(Supplier<T> block)
    {
        RegistryObject<T> toReturn = null;
        String name = block.get().RegistryName;
        try
        {

            toReturn = Registration.BLOCKS.register(name, block);
            RegistryObject<T> finalToReturn = toReturn;
            Registration.ITEMS.register(name, () -> new BlockItem(finalToReturn.get(),
                    new Item.Properties().group(RoadStuff.ROAD_STUFF_TAB)));



            LOGGER.log(ModBlocks.class, "Register(Block): "+name);
        }
        catch (Exception exception)
        {
            LOGGER.error(ModBlocks.class, "Register(Block): "+name, exception);
        }

        return toReturn;
    }
}
