package com.negativestudios.architects.registry;

import com.negativestudios.architects.ArchitectsMod;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModParticles {
    public static final DeferredRegister<net.minecraft.core.particles.ParticleType<?>> PARTICLES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ArchitectsMod.MOD_ID);

    // Pide al motor que estas partículas ignoren el limitador normal.
    public static final RegistryObject<SimpleParticleType> MOONLIGHT =
            PARTICLES.register("moonlight", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> STRLIGHT =
            PARTICLES.register("strlight", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> RED_ARCHITECT =
            PARTICLES.register("red_architect", () -> new SimpleParticleType(true));

    private ModParticles() {}
}
