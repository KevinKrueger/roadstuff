package com.kevinkrueger.roadstuff.data;

import com.kevinkrueger.roadstuff.util.ModBlocks;
import com.kevinkrueger.roadstuff.util.ModItems;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

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
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.STEEL_POLE.get())
                .key('C', ModItems.STEEL_INGOT.get())
                .patternLine("C")
                .patternLine("C")
                .patternLine("C")
                .addCriterion("steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
                .build(consumer);


        ShapedRecipeBuilder.shapedRecipe(ModBlocks.BARRIER.get())
                .key('T', ModItems.BARRIER_TAPE.get())
                .key('P', ModBlocks.STEEL_POLE.get())
                .patternLine("PTP")
                .addCriterion("barriertape", hasItem(ModItems.BARRIER_TAPE.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.CARDBOARDTUBE.get())
                .key('P', Items.PAPER.getItem())
                .patternLine("PPP")
                .patternLine("P P")
                .patternLine("PPP")
                .addCriterion("paper", hasItem(Items.PAPER.getItem()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.BARRIER_TAPE.get())
                .key('C', ModItems.CARDBOARDTUBE.get())
                .key('W', Items.WHITE_DYE.getItem())
                .key('R', Items.RED_DYE.getItem())
                .patternLine("WRR")
                .patternLine("RCR")
                .patternLine("RRW")
                .addCriterion("cardboardtube" ,hasItem(ModItems.CARDBOARDTUBE.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.GUIDE_CONE.get())
                .key('O', Items.ORANGE_DYE.getItem())
                .key('W', Items.WHITE_DYE.getItem())
                .patternLine(" O ")
                .patternLine("WWW")
                .patternLine("OOO")
                .addCriterion("orange_dye", hasItem(Items.ORANGE_DYE.getItem()))
                .addCriterion("white_dye", hasItem(Items.WHITE_DYE.getItem()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CRASH_PROTECTION_BOLLARD.get())
                .key('O', Items.ORANGE_DYE.getItem())
                .key('W', Items.WHITE_DYE.getItem())
                .patternLine("O")
                .patternLine("W")
                .patternLine("O")
                .addCriterion("orange_dye", hasItem(Items.ORANGE_DYE.getItem()))
                .addCriterion("white_dye", hasItem(Items.WHITE_DYE.getItem()))
                .build(consumer);


        /* Smelting Recipes */
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(Items.IRON_INGOT.getItem()),ModItems.STEEL_INGOT.get(), 3f, 400 )
                .addCriterion("steel_ingot", hasItem(ModItems.STEEL_INGOT.get())).build(consumer);
    }
}
