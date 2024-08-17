package net.dedstudio.datagen;

import net.dedstudio.block.ModBlocks;
import net.dedstudio.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool marblePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MARBLE);
        BlockStateModelGenerator.BlockTexturePool marbleBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MARBLE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_MARBLE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MARBLE_PAVEMENT);


        marblePool.stairs(ModBlocks.MARBLE_STAIRS);
        marblePool.slab(ModBlocks.MARBLE_SLAB);
        marblePool.wall(ModBlocks.MARBLE_WALL);
        marblePool.fenceGate(ModBlocks.MARBLE_FENCE_GATE);

        marbleBrickPool.stairs(ModBlocks.MARBLE_BRICK_STAIRS);
        marbleBrickPool.slab(ModBlocks.MARBLE_BRICK_SLAB);
        marbleBrickPool.wall(ModBlocks.MARBLE_BRICK_WALL);
        marbleBrickPool.fenceGate(ModBlocks.MARBLE_BRICK_FENCE_GATE);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ASCENT_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIUM_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WITHERED_NETHER_STAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SANDWICH, Models.GENERATED);
        itemModelGenerator.register(ModItems.TINY_COAL, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FIRE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FIRE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FIRE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FIRE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OBSIDIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OBSIDIUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OBSIDIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OBSIDIUM_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AQUATIC_FINS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AQUATIC_MASK));
    }

}
