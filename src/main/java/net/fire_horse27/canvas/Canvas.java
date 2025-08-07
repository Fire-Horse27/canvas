package net.fire_horse27.canvas;

import net.fabricmc.api.ModInitializer;
import net.fire_horse27.canvas.block.ModBlocks;
import net.fire_horse27.canvas.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Canvas implements ModInitializer {
	public static final String MOD_ID = "template";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

		LOGGER.info("Hello Fabric world!");
	}
}