package com.negativestudios.architects.client;

import com.negativestudios.architects.ArchitectsMod;
import com.negativestudios.architects.registry.ModParticles;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ArchitectsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {
    private ClientModEvents() {}

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.MOONLIGHT.get(),
                sprites -> new ArchitectParticle.Provider(sprites, ArchitectParticle.Kind.MOONLIGHT));
        event.registerSpriteSet(ModParticles.STRLIGHT.get(),
                sprites -> new ArchitectParticle.Provider(sprites, ArchitectParticle.Kind.STRLIGHT));
        event.registerSpriteSet(ModParticles.RED_ARCHITECT.get(),
                sprites -> new ArchitectParticle.Provider(sprites, ArchitectParticle.Kind.RED_ARCHITECT));
    }
}
