package com.kevinkrueger.roadstuff.crafting;

import com.kevinkrueger.roadstuff.RoadStuff;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import java.util.Optional;

import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class RecipeTypes {

    public static final IRecipeType<ITableRecipe> TABLE = new IRecipeType<ITableRecipe>() {
        @Override
        public <C extends IInventory> Optional<ITableRecipe> matches(IRecipe<C> recipe, World world, C inv) {
            return recipe.matches(inv, world) ? Optional.of((ITableRecipe) recipe) : Optional.empty();
        }
    };

    static {
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(RoadStuff.MOD_ID, "table"), TABLE);
    }
}