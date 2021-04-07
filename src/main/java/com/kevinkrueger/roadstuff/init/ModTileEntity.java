package com.kevinkrueger.roadstuff.init;

import com.kevinkrueger.roadstuff.tileentity.RSCraftingTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModTileEntity {


    public static final RegistryObject<TileEntityType<RSCraftingTileEntity>> RSCRAFTINGTABLE_ENTITY_TPYE =
           Registration.TILE_ENTITY_TYPE.register("rscraftingtable_tileentity",
                    () -> TileEntityType.Builder.create(RSCraftingTileEntity::new, ModBlocks.RSCRAFTINGTABLE.get()).build(null));


    public static void register(){}
}
