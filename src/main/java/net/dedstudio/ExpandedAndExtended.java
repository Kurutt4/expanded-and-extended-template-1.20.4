package net.dedstudio;

import net.dedstudio.block.ModBlocks;
import net.dedstudio.item.ModItemGroups;
import net.dedstudio.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpandedAndExtended implements ModInitializer {
	public static final String MOD_ID = "expandedex";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();

		//REGISTER FUEL ITEMS
		FuelRegistry.INSTANCE.add(ModItems.TINY_COAL, 200);

		LOGGER.info("Hello Fabric world!");



	}
}