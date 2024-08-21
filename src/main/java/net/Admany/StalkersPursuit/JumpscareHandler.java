package net.Admany.StalkersPursuit;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = StalkersPursuit.MODID, value = Dist.CLIENT)
public class JumpscareHandler {

    private static final ResourceLocation[] JUMPSCARE_IMAGES = {
            new ResourceLocation(StalkersPursuit.MODID, "textures/gui/jumpscare1.png"),
            new ResourceLocation(StalkersPursuit.MODID, "textures/gui/jumpscare2.png"),
            new ResourceLocation(StalkersPursuit.MODID, "textures/gui/jumpscare3.png")
    };

    private static final SoundEvent[] JUMPSCARE_SOUNDS = {
            new SoundEvent(new ResourceLocation(StalkersPursuit.MODID, "jumpscare_sound1")),
            new SoundEvent(new ResourceLocation(StalkersPursuit.MODID, "jumpscare_sound2")),
            new SoundEvent(new ResourceLocation(StalkersPursuit.MODID, "jumpscare_sound3"))
    };

    private static final Random RANDOM = new Random();

    @OnlyIn(Dist.CLIENT)
    public static void triggerJumpscare(Player player) {
        int imageIndex = RANDOM.nextInt(JUMPSCARE_IMAGES.length);
        int soundIndex = RANDOM.nextInt(JUMPSCARE_SOUNDS.length);

        Minecraft.getInstance().execute(() -> {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(JUMPSCARE_SOUNDS[soundIndex], 1.0F));
            Minecraft.getInstance().setScreen(new JumpscareScreen(JUMPSCARE_IMAGES[imageIndex]));
        });
    }

    @OnlyIn(Dist.CLIENT)
    public static class JumpscareScreen extends Screen {
        private final ResourceLocation jumpscareImage;

        protected JumpscareScreen(ResourceLocation jumpscareImage) {
            super(Component.literal(""));
            this.jumpscareImage = jumpscareImage;
        }

        @Override
        public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
            super.render(poseStack, mouseX, mouseY, partialTicks);
            // Render the randomly selected image over the screen
            Minecraft.getInstance().getTextureManager().bindForSetup(jumpscareImage);
            blit(poseStack, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        }

        @Override
        public boolean isPauseScreen() {
            return false;
        }
    }
}
