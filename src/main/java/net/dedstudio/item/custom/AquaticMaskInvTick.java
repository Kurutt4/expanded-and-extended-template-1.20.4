package net.dedstudio.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class AquaticMaskInvTick extends ArmorItem {

    private static final float MINING_SPEED_BOOST = 1.5f; // Fator de aumento da velocidade de mineração
    private static final int OXYGEN_BOOST_AMOUNT = 2; // Quantidade de oxigênio a ser adicionada por tick

    public AquaticMaskInvTick(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            if (player.isTouchingWater()) {
                // Verifica se o capacete está equipado
                if (isHelmetEquipped(player)) {
                    increaseOxygen(player);

                    boostMiningSpeed(player);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean isHelmetEquipped(PlayerEntity player) {
        ItemStack helmetStack = player.getInventory().getArmorStack(3); // Slot do capacete
        return helmetStack.getItem() == this;
    }

    private void increaseOxygen(PlayerEntity player) {
        int currentOxygen = player.getAir();
        if (currentOxygen < 300) { // Verifica se o oxigênio é menor que o máximo (300)
            player.setAir(Math.min(currentOxygen + OXYGEN_BOOST_AMOUNT, 300)); // Aumenta o oxigênio até o máximo de 300
        }
    }

    private void boostMiningSpeed(PlayerEntity player) {
        // Verifica se o jogador está embaixo d'água e usando o capacete
        if (player.isTouchingWater() && isHelmetEquipped(player)) {
            // Aumenta a velocidade de mineração do jogador
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20, 1, false, false, false));
        }
    }
}
