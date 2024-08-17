package net.dedstudio.block;

import net.dedstudio.ExpandedAndExtended;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block MARBLE = registerBlock("marble",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block MARBLE_BRICKS = registerBlock("marble_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block CHISELED_MARBLE_BRICKS = registerBlock("chiseled_marble_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block MARBLE_PAVEMENT = registerBlock("marble_pavement",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));

    public static final Block MARBLE_STAIRS = registerBlock("marble_stairs",
            new StairsBlock(ModBlocks.MARBLE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block MARBLE_BRICK_STAIRS = registerBlock("marble_brick_stairs",
            new StairsBlock(ModBlocks.MARBLE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));

    public static final Block MARBLE_SLAB = registerBlock("marble_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block MARBLE_BRICK_SLAB = registerBlock("marble_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));

    public static final Block MARBLE_WALL = registerBlock("marble_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block MARBLE_BRICK_WALL = registerBlock("marble_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));

    public static final Block MARBLE_FENCE_GATE = registerBlock("marble_fence_gate",
            new FenceGateBlock(WoodType.OAK, FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block MARBLE_BRICK_FENCE_GATE = registerBlock("marble_brick_fence_gate",
            new FenceGateBlock(WoodType.OAK, FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));







    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ExpandedAndExtended.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ExpandedAndExtended.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
            ExpandedAndExtended.LOGGER.info("Registering Mod Blocks for" + ExpandedAndExtended.MOD_ID);
        }
}

