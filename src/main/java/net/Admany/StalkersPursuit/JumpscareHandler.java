package net.Admany.StalkersPursuit;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Import statement for JumpscareScreen
import net.Admany.StalkersPursuit.JumpscareScreen;

import java.util.Random;

public class JumpscareHandler {

    private static final ResourceLocation[] JUMPSCARE_IMAGES = new ResourceLocation[] {
            new ResourceLocation(StalkersPursuit.MODID, "textures/gui/jumpscare1.png"),
            new ResourceLocation(StalkersPursuit.MODID, "textures/gui/jumpscare2.png"),
            new ResourceLocation(StalkersPursuit.MODID, "textures/gui/jumpscare3.png")
    };

    private static final SoundEvent[] JUMPSCARE_SOUNDS = new SoundEvent[] {
            ModSounds.JUMPSCARE_SOUND_1.get(),
            ModSounds.JUMPSCARE_SOUND_2.get(),
            ModSounds.JUMPSCARE_SOUND_3.get()
    };

    @OnlyIn(Dist.CLIENT)
    public static void triggerJumpscare(Player player) {
        if (player.level.isClientSide()) {
            Random random = new Random();

            // Select a random image and sound
            ResourceLocation image = JUMPSCARE_IMAGES[random.nextInt(JUMPSCARE_IMAGES.length)];
            SoundEvent sound = JUMPSCARE_SOUNDS[random.nextInt(JUMPSCARE_SOUNDS.length)];

            // Play sound and display image
            Minecraft.getInstance().level.playSound(player, player.blockPosition(), sound, SoundSource.PLAYERS, 1.0f, 1.0f);
            Minecraft.getInstance().setScreen(new JumpscareScreen(image));
        }
    }
}
