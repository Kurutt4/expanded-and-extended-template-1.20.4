package net.dedstudio.datagen;

import net.dedstudio.block.ModBlocks;
import net.dedstudio.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                 .forceAddTag(ModTags.Blocks.ALL_MARBLE_VARIANTS);


        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.MARBLE_FENCE_GATE)
                .add(ModBlocks.MARBLE_BRICK_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.MARBLE_WALL)
                .add(ModBlocks.MARBLE_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.MARBLE_STAIRS)
                .add(ModBlocks.MARBLE_BRICK_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.MARBLE_SLAB)
                .add(ModBlocks.MARBLE_BRICK_SLAB);



        getOrCreateTagBuilder(ModTags.Blocks.ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .add(Blocks.ANCIENT_DEBRIS);


        getOrCreateTagBuilder(ModTags.Blocks.ALL_MARBLE_VARIANTS)
                .add(ModBlocks.MARBLE)
                .add(ModBlocks.MARBLE_STAIRS)
                .add(ModBlocks.MARBLE_SLAB)
                .add(ModBlocks.MARBLE_WALL)
                .add(ModBlocks.MARBLE_FENCE_GATE)
                .add(ModBlocks.MARBLE_BRICKS)
                .add(ModBlocks.MARBLE_BRICK_STAIRS)
                .add(ModBlocks.MARBLE_BRICK_SLAB)
                .add(ModBlocks.MARBLE_BRICK_WALL)
                .add(ModBlocks.MARBLE_BRICK_FENCE_GATE)
                .add(ModBlocks.CHISELED_MARBLE_BRICKS)
                .add(ModBlocks.MARBLE_PAVEMENT);






        //getOrCreateTagBuilder(ModTags.Blocks.ALL_MARBLE_VARIANTS)
        //        .add(ModBlocks.)




        // getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "need_tool_level_4")))
                //.add(ModBlocks.MARBLE_BRICKS);

    }
}
