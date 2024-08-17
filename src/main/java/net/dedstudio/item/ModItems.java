package net.dedstudio.item;

import net.dedstudio.ExpandedAndExtended;
import net.dedstudio.item.custom.AquaticFinsInvTick;
import net.dedstudio.item.custom.AquaticMaskInvTick;
import net.dedstudio.item.custom.lanternitem.LanternItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ASCENT_CORE = registerItem("ascent_core", new Item(new FabricItemSettings()));
    public static final Item FIRE_CORE = registerItem("fire_core", new Item(new FabricItemSettings()));
    public static final Item OBSIDIUM_CORE = registerItem("obsidium_core", new Item(new FabricItemSettings()));
    public static final Item WITHERED_NETHER_STAR = registerItem("withered_nether_star", new Item(new FabricItemSettings()));

    public static final Item LANTERN_ITEM = new LanternItem(new FabricItemSettings());
    public static final Item SANDWICH = registerItem("sandwich", new Item(new FabricItemSettings().food(ModFoodComponents.SANDWICH)));

    public static final Item TINY_COAL = registerItem("tiny_coal", new Item(new FabricItemSettings()));




    public static final Item FIRE_HELMET = registerItem("fire_helmet",
            new ArmorItem(ModArmorMaterials.FIRE_ARMOR, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item FIRE_CHESTPLATE= registerItem("fire_chestplate",
            new ArmorItem(ModArmorMaterials.FIRE_ARMOR, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item FIRE_LEGGINGS = registerItem("fire_leggings",
            new ArmorItem(ModArmorMaterials.FIRE_ARMOR, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item FIRE_BOOTS = registerItem("fire_boots",
            new ArmorItem(ModArmorMaterials.FIRE_ARMOR, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item OBSIDIUM_HELMET = registerItem("obsidium_helmet",
            new ArmorItem(ModArmorMaterials.OBSIDIUM_ARMOR, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item OBSIDIUM_CHESTPLATE = registerItem("obsidium_chestplate",
            new ArmorItem(ModArmorMaterials.OBSIDIUM_ARMOR, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item OBSIDIUM_LEGGINGS = registerItem("obsidium_leggings",
            new ArmorItem(ModArmorMaterials.OBSIDIUM_ARMOR, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item OBSIDIUM_BOOTS = registerItem("obsidium_boots",
            new ArmorItem(ModArmorMaterials.OBSIDIUM_ARMOR, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item AQUATIC_FINS = registerItem("aquatic_fins",
            new AquaticFinsInvTick(ModArmorMaterials.AQUATIC_EQUIPMENT, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item AQUATIC_MASK = registerItem("aquatic_mask",
            new AquaticMaskInvTick(ModArmorMaterials.AQUATIC_EQUIPMENT, ArmorItem.Type.HELMET, new FabricItemSettings()));




    private static void  addItemToIngredientTabItemGroup(FabricItemGroupEntries entries) {

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ExpandedAndExtended.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ExpandedAndExtended.LOGGER.info("Registering Mod Items for" + ExpandedAndExtended.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientTabItemGroup);
    }
}
