package net.dedstudio.item;

import net.dedstudio.ExpandedAndExtended;
import net.dedstudio.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup AQUATIC_METHODS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ExpandedAndExtended.MOD_ID, "ascent_core"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.expandedex.aquatic_methods_tab"))
                    .icon(() -> new ItemStack(ModItems.ASCENT_CORE)).entries((displayContext, entries) -> {

                        entries.add(ModItems.AQUATIC_FINS);
                        entries.add(ModItems.AQUATIC_MASK);

                    }).build());

    public static final ItemGroup EQUIPMENT_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ExpandedAndExtended.MOD_ID, "fire_core"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.expandedex.equipment_tab"))
                    .icon(() -> new ItemStack(Items.NETHERITE_CHESTPLATE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.FIRE_HELMET);
                        entries.add(ModItems.FIRE_CHESTPLATE);
                        entries.add(ModItems.FIRE_LEGGINGS);
                        entries.add(ModItems.FIRE_BOOTS);

                        entries.add(ModItems.OBSIDIUM_HELMET);
                        entries.add(ModItems.OBSIDIUM_CHESTPLATE);
                        entries.add(ModItems.OBSIDIUM_LEGGINGS);
                        entries.add(ModItems.OBSIDIUM_BOOTS);


                    }).build());


    public static final ItemGroup BUILDING_BLOCKS_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ExpandedAndExtended.MOD_ID, "marble"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.expandedex.building_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.MARBLE_BRICKS)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.MARBLE);
                        entries.add(ModBlocks.MARBLE_BRICKS);
                        entries.add(ModBlocks.CHISELED_MARBLE_BRICKS);
                        entries.add(ModBlocks.MARBLE_PAVEMENT);

                        entries.add(ModBlocks.MARBLE_STAIRS);
                        entries.add(ModBlocks.MARBLE_BRICK_STAIRS);

                        entries.add(ModBlocks.MARBLE_SLAB);
                        entries.add(ModBlocks.MARBLE_BRICK_SLAB);

                        entries.add(ModBlocks.MARBLE_WALL);
                        entries.add(ModBlocks.MARBLE_BRICK_WALL);

                        entries.add(ModBlocks.MARBLE_FENCE_GATE);
                        entries.add(ModBlocks.MARBLE_BRICK_FENCE_GATE);

                        entries.add(ModBlocks.PALM_LOG);
                        entries.add(ModBlocks.PALM_WOOD);
                        entries.add(ModBlocks.STRIPPED_PALM_LOG);
                        entries.add(ModBlocks.STRIPPED_PALM_WOOD);
                        entries.add(ModBlocks.PALM_PLANKS);
                        entries.add(ModBlocks.PALM_LEAVES);

                    }).build());

    public static final ItemGroup MISC_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ExpandedAndExtended.MOD_ID, "withered_nether_star"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.expandedex.misc_tab"))
                    .icon(() -> new ItemStack(ModItems.WITHERED_NETHER_STAR)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ASCENT_CORE);
                        entries.add(ModItems.FIRE_CORE);
                        entries.add(ModItems.OBSIDIUM_CORE);
                        entries.add(ModItems.WITHERED_NETHER_STAR);
                        entries.add(ModItems.SANDWICH);
                        entries.add(ModItems.TINY_COAL);
                        entries.add(ModBlocks.PALM_TREE_SAPLING);


                    }).build());



    public static void registerItemGroups() {
        ExpandedAndExtended.LOGGER.info("Registering Item Groups for " + ExpandedAndExtended.MOD_ID);
    }
}
