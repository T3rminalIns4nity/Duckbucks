package code.ins4nity.too.many.packages.duckbucks.client;

import code.ins4nity.too.many.packages.duckbucks.Duckbucks;
import code.ins4nity.too.many.packages.duckbucks.items.wallet.WalletMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class WalletContainerScreen extends AbstractContainerScreen<WalletMenu> implements MenuAccess<WalletMenu> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Duckbucks.MOD_ID, "textures/gui/walletgui.png");

    public WalletContainerScreen(WalletMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.imageWidth = 256;
        this.imageHeight = 256;
        this.inventoryLabelX = this.imageWidth - 209;
        this.inventoryLabelY = this.imageHeight - 139;
        this.titleLabelX = this.imageWidth - 173;
        this.titleLabelY = this.imageHeight - 205;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(TEXTURE, x, y, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
