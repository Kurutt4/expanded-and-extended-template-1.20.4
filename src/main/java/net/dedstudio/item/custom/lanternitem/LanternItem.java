package net.dedstudio.item.custom.lanternitem;

import foundry.veil.Veil;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.chunk.light.LightSourceView;

import java.util.List;

public class LanternItem extends Item {

    private LightSourceView lanternLight;

    public LanternItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if (!world.isClient()) {
            if (lanternLight == null) {
                // Acende a lanterna e cria o efeito de luz
                activateLanternEffect(world, player);
            } else {
                // Desliga a lanterna
                deactivateLanternEffect(world);
            }
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, stack);
    }

    private void activateLanternEffect(World world, PlayerEntity player) {
        Vec3d playerPos = player.getPos();
        Vec3d lookDirection = player.getRotationVec(1.0F);

        // Cria a fonte de luz usando Quasar e Veil
        lanternLight = Quasar.create(world, Context.POINT)
                .setPosition(playerPos)
                .setDirection(lookDirection)
                .setRange(15.0F) // Alcance do cone de luz
                .setIntensity(1.0F) // Intensidade da luz
                .setColor(0xFFFFFF) // Cor da luz (branca)
                .attachTo(player); // A luz segue o jogador

        Veil.registerLightSource(lanternLight);
    }

    private void deactivateLanternEffect(World world) {
        if (lanternLight != null) {
            Veil.(lanternLight);
            lanternLight = null;
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.of("A lanterna ilumina o caminho!"));
    }
}
