package com.kevinkrueger.roadstuff.base;

import com.kevinkrueger.roadstuff.network.ILogger;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

/**
 *  Simplyfied ItemGroup
 */
public class BasicTab extends ItemGroup implements ILogger
{
    private Supplier<ItemStack> blockOrItem = null;

    /**
    * @param modID Your MOD_ID
    * @param blockOrItem A Block or an Item of your choice to create the Tab-Icon
    **/
    public BasicTab(final String modID, final Supplier<ItemStack> blockOrItem)
    {
        super(modID);
        try
        {
            this.blockOrItem = blockOrItem;
            LOGGER.log(this.getClass(), modID + "(BasicTab) Initialized");
        }
        catch (Exception exception)
        {
              LOGGER.error(this.getClass(), "Initialize " +  getGroupName(), exception);
        }
    }

    @Nonnull
    @Override
    public ItemStack createIcon() {
        return blockOrItem.get();
    }
}
