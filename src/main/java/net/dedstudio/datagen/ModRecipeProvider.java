package net.dedstudio.datagen;

import net.dedstudio.block.ModBlocks;
import net.dedstudio.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {

    //adiciona um bloco/item a uma lista que o resultado do bloco é offerSmelting
    private static final List<ItemConvertible> MARBLE_SMELTABLES = List.of(ModItems.WITHERED_NETHER_STAR,
            ModBlocks.MARBLE_BRICKS); //, ModBlocks/ModItems.NOVO BLOCO/ITEM




    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, MARBLE_SMELTABLES, RecipeCategory.MISC, ModItems.WITHERED_NETHER_STAR,
                0.7f, 200, "marble");

        //offerBlasting();


        //CTRL + ESQUERDO EM offerReversibleCompactingRecipes
        // PARA MOSTRAR TODOS OS TIPOS DE RECEITAS DO MINECRAFT

        //offerReversibleCompactingRecipes gera uma receita que 9 withering nether star cria 1 marble bricks
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.WITHERED_NETHER_STAR, RecipeCategory.DECORATIONS,
                ModBlocks.MARBLE_BRICKS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WITHERED_NETHER_STAR,1)
                .pattern(" S ")
                .pattern("SAS")
                .pattern(" S ")
                .input('S', ModItems.ASCENT_CORE)
                .input('A', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.ASCENT_CORE), conditionsFromItem(ModItems.ASCENT_CORE));

        offerShapelessRecipe(exporter, ModItems.TINY_COAL, Items.COAL, "tiny_coal_from_coal", 8);
        offerShapelessRecipe(exporter, ModItems.TINY_COAL, Items.CHARCOAL, "tiny_coal_from_coal", 8);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.COAL,1)
                .pattern("SSS")
                .pattern("S S")
                .pattern("SSS")
                .input('S', ModItems.TINY_COAL);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CHARCOAL,1)
                .pattern("SSS")
                .pattern("SAS")
                .pattern("SSS")
                .input('S', ModItems.TINY_COAL)
                .input('A', Items.STICK);



    }
}



