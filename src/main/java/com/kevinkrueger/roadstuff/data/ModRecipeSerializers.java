package com.kevinkrueger.roadstuff.data;

import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.crafting.ShapedTableRecipe;
import com.kevinkrueger.roadstuff.crafting.ShapelessTableRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public final class ModRecipeSerializers {
    public static final IRecipeSerializer<ShapedTableRecipe> SHAPED_TABLE = new ShapedTableRecipe.Serializer();
    public static final IRecipeSerializer<ShapelessTableRecipe> SHAPELESS_TABLE = new ShapelessTableRecipe.Serializer();

    @SubscribeEvent
    public void onRegisterSerializers(RegistryEvent.Register<IRecipeSerializer<?>> event) {
        IForgeRegistry<IRecipeSerializer<?>> registry = event.getRegistry();

        registry.register(SHAPED_TABLE.setRegistryName(new ResourceLocation(RoadStuff.MOD_ID, "shaped_table")));
        registry.register(SHAPELESS_TABLE.setRegistryName(new ResourceLocation(RoadStuff.MOD_ID, "shapeless_table")));

        //CraftingHelper.register(UltimateSingularityRecipeCondition.Serializer.INSTANCE);
    }
}
