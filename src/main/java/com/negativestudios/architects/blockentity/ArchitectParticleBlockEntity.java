package com.negativestudios.architects.blockentity;

import com.negativestudios.architects.block.ArchitectParticleBlock;
import com.negativestudios.architects.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ArchitectParticleBlockEntity extends BlockEntity {
    private int ticks;

    public ArchitectParticleBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ARCHITECT_PARTICLE.get(), pos, state);
    }

    public static void clientTick(Level level, BlockPos pos, BlockState state, ArchitectParticleBlockEntity blockEntity) {
        if (!level.isClientSide || !(state.getBlock() instanceof ArchitectParticleBlock block)) return;
        blockEntity.ticks++;
        RandomSource random = level.getRandom();
        int count = block.getParticleType().getOverrideLimiter() ? 2 : 1;
        if (blockEntity.ticks % 2 != 0 && random.nextFloat() > 0.35F) return;

        for (int i = 0; i < count; i++) {
            double angle = random.nextDouble() * Math.PI * 2.0D;
            double radius = 0.22D + random.nextDouble() * 0.38D;
            double x = pos.getX() + 0.5D + Math.cos(angle) * radius;
            double y = pos.getY() + 0.15D + random.nextDouble() * 0.85D;
            double z = pos.getZ() + 0.5D + Math.sin(angle) * radius;
            double dx = (random.nextDouble() - 0.5D) * 0.012D;
            double dy = 0.008D + random.nextDouble() * 0.018D;
            double dz = (random.nextDouble() - 0.5D) * 0.012D;
            level.addParticle(block.getParticleType(), x, y, z, dx, dy, dz);
        }
    }
}
