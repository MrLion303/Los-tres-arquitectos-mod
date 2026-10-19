package com.negativestudios.architects;

import com.negativestudios.architects.registry.ModBlockEntities;
import com.negativestudios.architects.registry.ModBlocks;
import com.negativestudios.architects.registry.ModItems;
import com.negativestudios.architects.registry.ModParticles;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ArchitectsMod.MOD_ID)
public class ArchitectsMod {
    public static final String MOD_ID = "architects";

    public ArchitectsMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModParticles.PARTICLES.register(modBus);
        ModBlocks.BLOCKS.register(modBus);
        ModItems.ITEMS.register(modBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modBus);
        modBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModItems.MOONLIGHT_BLOCK_ITEM.get());
            event.accept(ModItems.STRLIGHT_BLOCK_ITEM.get());
            event.accept(ModItems.RED_ARCHITECT_BLOCK_ITEM.get());
        }
    }
}
