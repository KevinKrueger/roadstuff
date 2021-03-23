package com.kevinkrueger.roadstuff.data;

import com.kevinkrueger.roadstuff.util.ModBlocks;
import com.kevinkrueger.roadstuff.util.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.data.*;
import net.minecraft.item.ItemStack;
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
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.STELL_POLE.get())
                .key('C', ModItems.STEEL_INGOT.get())
                .patternLine("C")
                .patternLine("C")
                .patternLine("C")
                .addCriterion("steel_ingot", hasItem(ModItems.STEEL_INGOT.get()))
                .build(consumer);


        /* Smelting Recipes */
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(Items.IRON_INGOT.getItem()),ModItems.STEEL_INGOT.get(), 3f, 400 )
                .addCriterion("steel_ingot", hasItem(ModItems.STEEL_INGOT.get())).build(consumer);

    }
}
