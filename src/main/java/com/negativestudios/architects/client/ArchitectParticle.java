package com.negativestudios.architects.client;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;

public class ArchitectParticle extends TextureSheetParticle {
    private final SpriteSet sprites;
    private final Kind kind;
    private final float initialSize;

    private ArchitectParticle(ClientLevel level, double x, double y, double z,
                              double xSpeed, double ySpeed, double zSpeed, SpriteSet sprites, Kind kind) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        this.sprites = sprites;
        this.kind = kind;
        this.friction = 0.94F;
        this.gravity = 0.0F;
        this.hasPhysics = false;
        this.lifetime = switch (kind) {
            case MOONLIGHT -> 28 + this.random.nextInt(10);
            case STRLIGHT -> 22 + this.random.nextInt(9);
            case RED_ARCHITECT -> 30 + this.random.nextInt(12);
        };
        this.initialSize = switch (kind) {
            case MOONLIGHT -> 0.16F + this.random.nextFloat() * 0.12F;
            case STRLIGHT -> 0.13F + this.random.nextFloat() * 0.10F;
            case RED_ARCHITECT -> 0.17F + this.random.nextFloat() * 0.13F;
        };
        this.quadSize = initialSize;
        switch (kind) {
            case MOONLIGHT -> this.setColor(0.36F, 0.82F, 1.0F);
            case STRLIGHT -> this.setColor(1.0F, 0.82F, 0.30F);
            case RED_ARCHITECT -> this.setColor(1.0F, 0.25F, 0.28F);
        }
        this.alpha = 0.0F;
        this.setSpriteFromAge(sprites);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.isAlive()) return;

        float progress = (float) this.age / (float) this.lifetime;
        float fadeIn = Math.min(1.0F, progress * 7.0F);
        float fadeOut = Math.min(1.0F, (1.0F - progress) * 5.0F);
        this.alpha = Math.min(fadeIn, fadeOut);
        this.quadSize = initialSize * (0.78F + 0.35F * (float) Math.sin(progress * Math.PI));

        if (kind == Kind.MOONLIGHT) {
            this.xd *= 0.97D; this.yd += 0.0008D; this.zd *= 0.97D;
        } else if (kind == Kind.STRLIGHT) {
            this.xd *= 0.95D; this.yd += 0.0003D; this.zd *= 0.95D;
        } else {
            this.xd += (this.random.nextDouble() - 0.5D) * 0.003D;
            this.yd += (this.random.nextDouble() - 0.5D) * 0.002D;
            this.zd += (this.random.nextDouble() - 0.5D) * 0.003D;
        }
        this.setSpriteFromAge(sprites);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public int getLightColor(float partialTick) {
        return 240;
    }

    public enum Kind { MOONLIGHT, STRLIGHT, RED_ARCHITECT }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        private final Kind kind;
        public Provider(SpriteSet sprites, Kind kind) { this.sprites = sprites; this.kind = kind; }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z,
                                      double xSpeed, double ySpeed, double zSpeed) {
            return new ArchitectParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, sprites, kind);
        }
    }
}
