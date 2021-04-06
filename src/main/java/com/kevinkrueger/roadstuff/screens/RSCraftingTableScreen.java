package com.kevinkrueger.roadstuff.screens;

import com.kevinkrueger.roadstuff.RoadStuff;
import com.kevinkrueger.roadstuff.container.RSCraftingContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RSCraftingTableScreen extends ContainerScreen<RSCraftingContainer> {

    private final ResourceLocation GUI = new ResourceLocation(RoadStuff.MOD_ID, "textures/gui/rscraftingtable.png");

    public RSCraftingTableScreen(RSCraftingContainer container, PlayerInventory inv, ITextComponent name)
    {
        super(container, inv, name);
        xSize = 176;
        ySize = 204;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    /*@Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
        this.font.func_243248_b(matrixStack, this.playerInventory.getDisplayName(), (float) this.playerInventoryTitleX,
                (float) this.playerInventoryTitleY, 4210752);
    }*/

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
        font.drawString(matrixStack, I18n.format("container.crafting"), 28, 6, 4210752);
        font.drawString(matrixStack, I18n.format("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y)
    {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        /*int i = this.guiLeft;
        int j = this.guiTop;
        //this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);*/

        x = (this.width - this.xSize) / 2;
        y = (this.height - this.ySize) / 2;
        this.blit(matrixStack, x, y, 0, 0, this.xSize, this.ySize);
    }
}
