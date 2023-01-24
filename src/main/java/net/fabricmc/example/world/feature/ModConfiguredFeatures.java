package net.fabricmc.example.world.feature;

import net.fabricmc.example.TreeExample;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.function.BiConsumer;

public class ModConfiguredFeatures {
    public static final RegistryKey<PlacedFeature> EXAMPLE_TREE_PLACED =
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(TreeExample.MOD_ID, "example_placed_tree"));

    public static final RegistryKey<ConfiguredFeature<?,?>> EXAMPLE_TREE =
            RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(TreeExample.MOD_ID, "example_tree"));


    public static void registerConfiguredFeatures() {
        TreeExample.LOGGER.debug("Registering ModConfiguredFeatures for " + TreeExample.MOD_ID);
        BiomeModifications.create(new Identifier(TreeExample.MOD_ID, "features"))

                .add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInOverworld(), myTreeModifier(EXAMPLE_TREE_PLACED))
        ;
    }

    private static BiConsumer<BiomeSelectionContext, BiomeModificationContext> myTreeModifier(RegistryKey<PlacedFeature> TreePlacedFeatureKey) {
        return (biomeSelectionContext, biomeModificationContext) ->
                biomeModificationContext.getGenerationSettings()
                        .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TreePlacedFeatureKey);
    }
}