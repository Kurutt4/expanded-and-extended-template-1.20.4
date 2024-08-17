package net.dedstudio.item.custom;

import com.google.common.collect.ImmutableMap;
import net.dedstudio.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    // Mapeia materiais de armadura para listas de efeitos
    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MATERIAL_TO_EFFECTS_MAP = ImmutableMap.<ArmorMaterial, List<StatusEffectInstance>>builder()
            .put(ModArmorMaterials.OBSIDIUM_ARMOR, List.of(
                    new StatusEffectInstance(StatusEffects.RESISTANCE, 400, 2, false, false, true),
                    new StatusEffectInstance(StatusEffects.SLOWNESS, 400, 1, false, false, true)
            ))
            .put(ModArmorMaterials.FIRE_ARMOR, List.of(
                    new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 2, false, false, true),
                    new StatusEffectInstance(StatusEffects.GLOWING, 400, 1, false, false, true)
            ))
            .build();

    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player && hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECTS_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                for (StatusEffectInstance effectInstance : mapStatusEffects) {
                    addStatusEffectForMaterial(player, effectInstance);
                }
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, StatusEffectInstance effectInstance) {
        if (!player.hasStatusEffect(effectInstance.getEffectType())) {
            player.addStatusEffect(new StatusEffectInstance(effectInstance));
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        return player.getInventory().getArmorStack(0).getItem() instanceof ArmorItem boots
                && player.getInventory().getArmorStack(1).getItem() instanceof ArmorItem leggings
                && player.getInventory().getArmorStack(2).getItem() instanceof ArmorItem breastplate
                && player.getInventory().getArmorStack(3).getItem() instanceof ArmorItem helmet
                && ((ArmorItem) boots).getMaterial() == material
                && ((ArmorItem) leggings).getMaterial() == material
                && ((ArmorItem) breastplate).getMaterial() == material
                && ((ArmorItem) helmet).getMaterial() == material;
    }
}
