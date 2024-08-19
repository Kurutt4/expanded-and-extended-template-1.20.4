package net.dedstudio.item.custom;

import net.dedstudio.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AquaticFinsInvTick extends ArmorItem {

    private static final double SWIM_SPEED_MULTIPLIER = 0.3;

    public AquaticFinsInvTick(ModArmorMaterials material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (world.isClient || !(entity instanceof PlayerEntity)) {
            return;
        }

        PlayerEntity player = (PlayerEntity) entity;

        // Verifica se a bota está equipada no slot de pés e se o jogador está nadando
        if (player.getEquippedStack(EquipmentSlot.FEET) == stack && player.isSubmergedInWater() && player.isSwimming()) {
            applyAquaticFinsEffect(player);
        }
    }

    private void applyAquaticFinsEffect(PlayerEntity player) {
        Vec3d velocity = player.getVelocity();
        Vec3d direction = getHorizontalDirection(player);

        // Calcula a nova velocidade horizontal com o multiplicador aplicado
        Vec3d boostedVelocity = direction.multiply(SWIM_SPEED_MULTIPLIER).add(new Vec3d(0, velocity.y, 0));

        // Atualiza a velocidade do jogador, mantendo a componente Y original
        player.setVelocity(boostedVelocity);

        player.velocityModified = true;
    }

    private Vec3d getHorizontalDirection(PlayerEntity player) {
        Vec3d lookDirection = player.getRotationVector();
        lookDirection = lookDirection.normalize(); // Normaliza o vetor para garantir uma direção unitária

        // Remove a componente Y da direção para obter apenas a direção horizontal
        return new Vec3d(lookDirection.x, 0, lookDirection.z).normalize();
    }
}
