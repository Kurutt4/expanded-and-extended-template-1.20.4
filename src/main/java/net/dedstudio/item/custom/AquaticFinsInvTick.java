package net.dedstudio.item.custom;

import net.dedstudio.item.ModArmorMaterials;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class AquaticFinsInvTick extends ArmorItem implements ModInitializer {

    private static final double SWIM_SPEED_MULTIPLIER = 1.2; // Ajuste o valor conforme necessário

    public AquaticFinsInvTick(ModArmorMaterials material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void onInitialize() {
        // Registra o evento para aplicar o efeito de nado a cada tick do servidor
        ServerTickEvents.END_SERVER_TICK.register(this::onServerTick);
    }

    private void onServerTick(MinecraftServer server) {
        for (World world : server.getWorlds()) {
            if (world.isClient) {
                continue; // Apenas execute no servidor
            }
            for (PlayerEntity player : world.getPlayers()) {
                applyAquaticFinsEffect(player);
            }
        }
    }

    private void applyAquaticFinsEffect(PlayerEntity player) {
        ItemStack boots = player.getInventory().armor.get(0); // Slot das botas

        if (boots.getItem() instanceof AquaticFinsInvTick && player.isSubmergedInWater()) {
            Vec3d velocity = player.getVelocity();

            // Adiciona um log para verificar se o efeito está sendo tentado aplicar
            System.out.println("Applying swim speed boost to player: " + player.getName().getString());

            // Multiplica a velocidade atual para dar o boost
            Vec3d boostedVelocity = velocity.multiply(SWIM_SPEED_MULTIPLIER);

            // Aplica a nova velocidade ao jogador
            player.setVelocity(boostedVelocity);
            player.velocityModified = true; // Força a atualização da velocidade no cliente

            // Log para verificar a nova velocidade
            System.out.println("New Velocity: " + boostedVelocity.toString());
        } else {
            System.out.println("Player " + player.getName().getString() + " is not wearing Aquatic Fins or is not submerged in water.");
        }
    }
}
