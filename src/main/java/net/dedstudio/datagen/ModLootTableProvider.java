package net.dedstudio.datagen;

import net.dedstudio.block.ModBlocks;
import net.dedstudio.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //addDrop(ModBlocks.MARBLE_BRICKS, copperLIkeOreDrops(ModBlocks.MARBLE_BRICKS, ModItems.WITHERED_NETHER_STAR));
        addDrop(ModBlocks.CHISELED_MARBLE_BRICKS);
        addDrop(ModBlocks.MARBLE_PAVEMENT);
        addDrop(ModBlocks.MARBLE);
        addDrop(ModBlocks.MARBLE_BRICKS);

        addDrop(ModBlocks.MARBLE_STAIRS);
        addDrop(ModBlocks.MARBLE_BRICK_STAIRS);

        addDrop(ModBlocks.MARBLE_SLAB, slabDrops(ModBlocks.MARBLE_SLAB));
        addDrop(ModBlocks.MARBLE_BRICK_SLAB, slabDrops(ModBlocks.MARBLE_BRICK_SLAB));

        addDrop(ModBlocks.MARBLE_WALL);
        addDrop(ModBlocks.MARBLE_BRICK_WALL);

        addDrop(ModBlocks.MARBLE_FENCE_GATE);
        addDrop(ModBlocks.MARBLE_BRICK_FENCE_GATE);


        //addDrop(ModBlocks.MARBLE_BRICKS);

    }
    public LootTable.Builder copperLIkeOreDrops(Block drop, Item item) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider
                                        .create(1.0F, 3.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }
}
