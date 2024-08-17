package net.dedstudio.item.custom.lanternitem;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LanternEffect {

    private static final int PARTICLE_COUNT = 100;
    private static final double RADIUS = 5.0;

    public static void createLightEffect(World world, PlayerEntity player) {
        if (world.isClient) {
            MinecraftClient client = MinecraftClient.getInstance();
            BlockPos playerPos = player.getBlockPos();

            // Cria partículas ao redor do jogador
            for (int i = 0; i < PARTICLE_COUNT; i++) {
                double angle = Math.random() * Math.PI * 2;
                double distance = Math.random() * RADIUS;
                double x = playerPos.getX() + Math.cos(angle) * distance;
                double z = playerPos.getZ() + Math.sin(angle) * distance;
                double y = playerPos.getY() + Math.random() * 2 - 1;

                client.particleManager.addParticle(ParticleTypes.GLOW, x, y, z, 0, 0, 0);
            }
        }
    }
}
