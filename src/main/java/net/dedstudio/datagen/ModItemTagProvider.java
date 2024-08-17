package net.dedstudio.datagen;

import net.dedstudio.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.FIRE_HELMET,ModItems.FIRE_CHESTPLATE,
                        ModItems.FIRE_LEGGINGS, ModItems.FIRE_BOOTS)

                .add(ModItems.OBSIDIUM_HELMET, ModItems.OBSIDIUM_CHESTPLATE,
                        ModItems.OBSIDIUM_LEGGINGS, ModItems.OBSIDIUM_BOOTS);

    }
}
