package net.Admany.StalkersPursuit;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.resources.ResourceLocation;

public class ModSounds {

    // Deferred Register for sounds
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, StalkersPursuit.MODID);

    // Register sound events
    public static final RegistryObject<SoundEvent> JUMPSCARE_SOUND_1 = SOUNDS.register("jumpscare_sound1", () -> new SoundEvent(new ResourceLocation(StalkersPursuit.MODID, "jumpscare_sound1")));
    public static final RegistryObject<SoundEvent> JUMPSCARE_SOUND_2 = SOUNDS.register("jumpscare_sound2", () -> new SoundEvent(new ResourceLocation(StalkersPursuit.MODID, "jumpscare_sound2")));
    public static final RegistryObject<SoundEvent> JUMPSCARE_SOUND_3 = SOUNDS.register("jumpscare_sound3", () -> new SoundEvent(new ResourceLocation(StalkersPursuit.MODID, "jumpscare_sound3")));
}
