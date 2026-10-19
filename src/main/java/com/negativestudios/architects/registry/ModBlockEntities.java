package com.negativestudios.architects.registry;

import com.negativestudios.architects.ArchitectsMod;
import com.negativestudios.architects.blockentity.ArchitectParticleBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ArchitectsMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<ArchitectParticleBlockEntity>> ARCHITECT_PARTICLE =
            BLOCK_ENTITIES.register("architect_particle",
                    () -> BlockEntityType.Builder.of(ArchitectParticleBlockEntity::new,
                            ModBlocks.MOONLIGHT_BLOCK.get(),
                            ModBlocks.STRLIGHT_BLOCK.get(),
                            ModBlocks.RED_ARCHITECT_BLOCK.get()).build(null));

    private ModBlockEntities() {}
}
