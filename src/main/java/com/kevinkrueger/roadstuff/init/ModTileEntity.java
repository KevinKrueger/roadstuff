package com.kevinkrueger.roadstuff.init;

import com.kevinkrueger.roadstuff.network.ILogger;
import com.kevinkrueger.roadstuff.tileentity.RSCraftingTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModTileEntity implements ILogger {


    public static final RegistryObject<TileEntityType<RSCraftingTileEntity>> RSCRAFTINGTABLE_ENTITY_TPYE =
           register("rscraftingtable_tileentity", () -> TileEntityType.Builder.create(RSCraftingTileEntity::new, ModBlocks.RSCRAFTINGTABLE.get()).build(null));


    public static void register(){}

    private static <T extends TileEntityType<?>> RegistryObject<T> register(String name, Supplier<? extends TileEntityType> sup)
    {
        RegistryObject<? extends TileEntityType> toReturn = null;

        try
        {
            toReturn = Registration.TILE_ENTITY_TYPE.register(name, sup);
            LOGGER.log(ModTileEntity.class, "Register(TileEntityType): " + name);
        }catch (Exception exception)
        {
            LOGGER.error(ModTileEntity.class, "", exception);
        }

        return (RegistryObject<T>) toReturn;
    }
}
