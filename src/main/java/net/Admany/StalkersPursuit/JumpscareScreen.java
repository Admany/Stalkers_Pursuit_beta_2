package net.Admany.StalkersPursuit;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class JumpscareScreen extends Screen {

    private final ResourceLocation image;

    protected JumpscareScreen(ResourceLocation image) {
        super(Component.literal(""));  // Display no title
        this.image = image;
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        super.render(poseStack, mouseX, mouseY, partialTicks);
        RenderSystem.setShaderTexture(0, image);
        blit(poseStack, 0, 0, this.width, this.height, 0, 0, this.width, this.height, this.width, this.height);
    }

    @Override
    public boolean isPauseScreen() {
        return false;  // Prevent the game from pausing when the jumpscare is displayed
    }
}