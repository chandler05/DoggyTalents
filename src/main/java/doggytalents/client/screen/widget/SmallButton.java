package doggytalents.client.screen.widget;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import doggytalents.common.lib.Resources;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.math.MathHelper;

public class SmallButton extends Button {

    public SmallButton(int x, int y, String text, IPressable onPress) {
        super(x, y, 12, 12, text, onPress);
    }

    @Override
    public void renderButton(int mouseX, int mouseY, float partialTicks) {
       Minecraft mc = Minecraft.getInstance();
       FontRenderer font = mc.fontRenderer;
       mc.getTextureManager().bindTexture(Resources.SMALL_WIDGETS);
       RenderSystem.color4f(1.0F, 1.0F, 1.0F, this.alpha);
       int i = this.getYImage(this.isHovered());
       RenderSystem.enableBlend();
       RenderSystem.defaultBlendFunc();
       RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
       this.blit(this.x, this.y, 0, i * 12, this.width, this.height);
       this.renderBg(mc, mouseX, mouseY);
       int j = getFGColor();
       this.drawCenteredString(font, this.getMessage(), this.x + this.width / 2, this.y + (this.height - 8) / 2, j | MathHelper.ceil(this.alpha * 255.0F) << 24);
    }
}
