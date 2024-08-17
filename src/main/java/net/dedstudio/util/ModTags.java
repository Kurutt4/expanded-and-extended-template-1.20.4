package net.dedstudio.util;

import net.dedstudio.ExpandedAndExtended;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> ALL_MARBLE_VARIANTS =
                createTag("all_marble_variants");

        public static final TagKey<Block> ORES  =
                createTag("ores");




        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(ExpandedAndExtended.MOD_ID, name));
        }
    }

    public static class Items {




        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(ExpandedAndExtended.MOD_ID, name));
        }
    }
}
