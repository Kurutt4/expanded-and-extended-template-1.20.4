package net.dedstudio.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AquaticFinsInvTick extends ArmorItem {

    public AquaticFinsInvTick(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            if (player.isTouchingWater()) {
                // Verifica se o jogador está usando a bota personalizada
                ItemStack equippedBoots = player.getEquippedStack(Type.BOOTS.getEquipmentSlot());
                if (equippedBoots.getItem() instanceof AquaticFinsInvTick) {
                    // Aplica o aumento de velocidade apenas se o jogador está nadando
                    if (player.isSwimming()) {
                        // Obtém a velocidade atual do jogador
                        Vec3d currentVelocity = player.getVelocity();

                        // Define o multiplicador de velocidade
                        double speedMultiplier = 1.5; // Ajuste este valor conforme necessário

                        // Calcula a nova velocidade horizontal
                        Vec3d newVelocity = new Vec3d(
                                currentVelocity.x * speedMultiplier,
                                currentVelocity.y, // Mantém a velocidade vertical inalterada
                                currentVelocity.z * speedMultiplier
                        );

                        // Define a nova velocidade
                        player.setVelocity(newVelocity);
                    }
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
