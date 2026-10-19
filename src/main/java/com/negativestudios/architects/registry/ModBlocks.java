package com.negativestudios.architects.registry;

import com.negativestudios.architects.ArchitectsMod;
import com.negativestudios.architects.block.ArchitectParticleBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ArchitectsMod.MOD_ID);

    public static final RegistryObject<Block> MOONLIGHT_BLOCK = BLOCKS.register("moonlight_block",
            () -> new ArchitectParticleBlock(ModParticles.MOONLIGHT,
                    BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.AMETHYST).noOcclusion().lightLevel(state -> 15)));
    public static final RegistryObject<Block> STRLIGHT_BLOCK = BLOCKS.register("strlight_block",
            () -> new ArchitectParticleBlock(ModParticles.STRLIGHT,
                    BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.AMETHYST).noOcclusion().lightLevel(state -> 15)));
    public static final RegistryObject<Block> RED_ARCHITECT_BLOCK = BLOCKS.register("red_architect_block",
            () -> new ArchitectParticleBlock(ModParticles.RED_ARCHITECT,
                    BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.AMETHYST).noOcclusion().lightLevel(state -> 15)));

    private ModBlocks() {}
}
