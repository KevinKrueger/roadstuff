package com.kevinkrueger.roadstuff.data;

import com.kevinkrueger.roadstuff.crafting.ShapedRecipe;
import com.kevinkrueger.roadstuff.init.ModBlocks;
import com.kevinkrueger.roadstuff.init.ModItems;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.event.world.SaplingGrowTreeEvent;

import java.util.Objects;
import java.util.function.Consumer;

public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipesProvider(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        /* Crafting Recipes */

        //Steel Pole for Signs (-> Steel Ingot)
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.STEELPOLE_SIGNS.get())
                .key('I', ModItems.STEEL_INGOT.get())
                .patternLine("I")
                .patternLine("I")
                .patternLine("I")
                .addCriterion(Objects.requireNonNull(ModItems.STEEL_INGOT.get().getRegistryName()).toString(), hasItem(ModItems.STEEL_INGOT.get()))
                .build(consumer);

        //Steel Pole for Lights (-> Steel Pole for Signs)
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.STEELPOLE_LIGHTS.get())
                .key('S', ModBlocks.STEELPOLE_SIGNS.get())
                .patternLine(" S ")
                .addCriterion(Objects.requireNonNull(ModBlocks.STEELPOLE_SIGNS.get().getRegistryName()).toString(), hasItem(ModItems.STEEL_INGOT.get()))
                .build(consumer);

        //Barrier (-> Barrier Tape, Steel Pole)
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.BARRIER.get())
                .key('T', ModItems.BARRIER_TAPE.get())
                .key('P', ModBlocks.STEELPOLE_SIGNS.get())
                .patternLine("PTP")
                .addCriterion(Objects.requireNonNull(ModItems.BARRIER_TAPE.get().getRegistryName()).toString(), hasItem(ModItems.BARRIER_TAPE.get()))
                .build(consumer);

        //Cardboardtube (-> Paper)
        ShapedRecipeBuilder.shapedRecipe(ModItems.CARDBOARDTUBE.get())
                .key('P', Items.PAPER.getItem())
                .patternLine("PPP")
                .patternLine("P P")
                .patternLine("PPP")
                .addCriterion(Objects.requireNonNull(Items.PAPER.getItem().getRegistryName()).toString(), hasItem(Items.PAPER.getItem()))
                .build(consumer);

        //Barrier Tape (-> Cardboardtube, White Dye, Red Dye)
        ShapedRecipeBuilder.shapedRecipe(ModItems.BARRIER_TAPE.get())
                .key('C', ModItems.CARDBOARDTUBE.get())
                .key('W', Items.WHITE_DYE.getItem())
                .key('R', Items.RED_DYE.getItem())
                .patternLine("WRR")
                .patternLine("RCR")
                .patternLine("RRW")
                .addCriterion(Objects.requireNonNull(ModItems.CARDBOARDTUBE.get().getRegistryName()).toString(), hasItem(ModItems.CARDBOARDTUBE.get()))
                .build(consumer);

        //Guide Cone (Orange Dye, White Dye, Steel Plate, Steel Ingot)
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.GUIDE_CONE.get())
                .key('O', Items.ORANGE_DYE.getItem())
                .key('W', Items.WHITE_DYE.getItem())
                .key('P', ModItems.STEEL_PLATE.get())
                .key('S', ModItems.STEEL_INGOT.get())
                .patternLine(" O ")
                .patternLine("WSW")
                .patternLine("OPO")
                .addCriterion(Objects.requireNonNull(Items.ORANGE_DYE.getItem().getRegistryName()).toString(), hasItem(Items.ORANGE_DYE.getItem()))
                .addCriterion(Objects.requireNonNull(Items.WHITE_DYE.getItem().getRegistryName()).toString(), hasItem(Items.WHITE_DYE.getItem()))
                .addCriterion(Objects.requireNonNull(ModItems.STEEL_PLATE.get().getRegistryName()).toString(), hasItem(ModItems.STEEL_PLATE.get()))
                .addCriterion(Objects.requireNonNull(ModItems.STEEL_INGOT.get().getRegistryName()).toString(), hasItem(ModItems.STEEL_INGOT.get()))
                .build(consumer);

        //Crash Protection Bollard (-> Orange Dye, White Dye, Steel Plate, Steel Pole)
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CRASH_PROTECTION_BOLLARD.get())
                .key('O', Items.ORANGE_DYE.getItem())
                .key('W', Items.WHITE_DYE.getItem())
                .key('P', ModItems.STEEL_PLATE.get())
                .key('S', ModBlocks.STEELPOLE_SIGNS.get())
                .patternLine("OSO")
                .patternLine("WSW")
                .patternLine("OPO")
                .addCriterion(Objects.requireNonNull(Items.ORANGE_DYE.getItem().getRegistryName()).toString(), hasItem(Items.ORANGE_DYE.getItem()))
                .addCriterion(Objects.requireNonNull(Items.WHITE_DYE.getItem().getRegistryName()).toString(), hasItem(Items.WHITE_DYE.getItem()))
                .addCriterion(Objects.requireNonNull(ModItems.STEEL_PLATE.get().getRegistryName()).toString(), hasItem(ModItems.STEEL_PLATE.get()))
                .addCriterion(Objects.requireNonNull(ModBlocks.STEELPOLE_SIGNS.get().getRegistryName()).toString(), hasItem(ModBlocks.STEELPOLE_SIGNS.get()))
                .build(consumer);

        //Steel Plate (-> Steel Ingot)
        ShapedRecipeBuilder.shapedRecipe(ModItems.STEEL_PLATE.get())
                .key('S', ModItems.STEEL_INGOT.get())
                .patternLine("SSS")
                .addCriterion(Objects.requireNonNull(ModItems.STEEL_INGOT.get().getRegistryName()).toString(), hasItem(ModItems.STEEL_INGOT.get()))
                .build(consumer);

        // Light Bulb (-> Glass Pane, Redstone Torch, Iron Ingot)
        ShapedRecipeBuilder.shapedRecipe(ModItems.LIGHTBULB.get(), 2)
                .key('P', Items.GLASS_PANE.getItem())
                .key('T', Items.REDSTONE_TORCH.getItem())
                .key('I', Items.IRON_INGOT.getItem())
                .patternLine("PPP")
                .patternLine("PTP")
                .patternLine(" I ")
                .addCriterion(Objects.requireNonNull(Items.REDSTONE_TORCH.getItem().getRegistryName()).toString(), hasItem(Items.REDSTONE_TORCH.getItem()))
                .build(consumer);

        //Street Light (-> Steel Ingot, Light Bulb)
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.STREET_LIGHT.get())
                .key('S', ModItems.STEEL_INGOT.get())
                .key('L', ModItems.LIGHTBULB.get())
                .patternLine("SSS")
                .patternLine("SLS")
                .patternLine("  S")
                .addCriterion(Objects.requireNonNull(Items.REDSTONE_TORCH.getItem().getRegistryName()).toString(), hasItem(Items.REDSTONE_TORCH.getItem()))
                .build(consumer);

        //Double Street Light (-> Street Light)
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.DOUBLE_STREET_LIGHT.get())
                .key('S', ModBlocks.STREET_LIGHT.get().asItem())
                .patternLine("SS")
                .addCriterion(Objects.requireNonNull(Items.REDSTONE_TORCH.getItem().getRegistryName()).toString(), hasItem(Items.REDSTONE_TORCH.getItem()))
                .build(consumer);



        /* Smelting Recipes */

        //Steel Ingot (-> Iron Ingot)
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(Items.IRON_INGOT.getItem()),ModItems.STEEL_INGOT.get(), 3f, 400 )
                .addCriterion(Objects.requireNonNull(ModItems.STEEL_INGOT.get().getRegistryName()).toString(), hasItem(ModItems.STEEL_INGOT.get())).build(consumer);
    }
}
