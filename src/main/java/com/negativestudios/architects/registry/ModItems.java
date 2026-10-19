package com.negativestudios.architects.registry;

import com.negativestudios.architects.ArchitectsMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ArchitectsMod.MOD_ID);

    public static final RegistryObject<Item> MOONLIGHT_BLOCK_ITEM = ITEMS.register("moonlight_block",
            () -> new BlockItem(ModBlocks.MOONLIGHT_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRLIGHT_BLOCK_ITEM = ITEMS.register("strlight_block",
            () -> new BlockItem(ModBlocks.STRLIGHT_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> RED_ARCHITECT_BLOCK_ITEM = ITEMS.register("red_architect_block",
            () -> new BlockItem(ModBlocks.RED_ARCHITECT_BLOCK.get(), new Item.Properties()));

    private ModItems() {}
}
