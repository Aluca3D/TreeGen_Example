package net.fabricmc.example.block;


import net.fabricmc.example.TreeExample;
import net.fabricmc.example.item.ModItemGroup;
import net.fabricmc.example.world.feature.tree.ExampleSaplingGenerator;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block EXAMPLE_LOG = registerBlock("example_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)), ModItemGroup.GROUP_NAME);
    public static final Block EXAMPLE_LEAVES = registerBlock("example_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)), ModItemGroup.GROUP_NAME);
    public static final Block EXAMPLE_SAPLING = registerBlock("example_sapling",
            new SaplingBlock(new ExampleSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)), ModItemGroup.GROUP_NAME);



    public static void registerModBlocks() {
        TreeExample.LOGGER.debug("Register ModBlocks for " + TreeExample.MOD_ID);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        BlockItem myBlock = Registry.register(Registries.ITEM, new Identifier(TreeExample.MOD_ID, name), new BlockItem(block, new Item.Settings()));
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(myBlock));
        return myBlock;
    }

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registries.BLOCK, new Identifier(TreeExample.MOD_ID, name), block);
    }
}
