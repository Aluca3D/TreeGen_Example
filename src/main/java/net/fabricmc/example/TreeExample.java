package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.block.ModBlocks;
import net.fabricmc.example.world.feature.ModConfiguredFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreeExample implements ModInitializer {
	public static final String MOD_ID = "treeexample";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModBlocks.registerModBlocks();
	}
}
