package net.dedstudio.world.tree;

import net.dedstudio.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator PALM_TREE =
            new SaplingGenerator("palm_tree", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.PALM_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
}
