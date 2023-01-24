package net.fabricmc.example.item;

import net.fabricmc.example.TreeExample;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup GROUP_NAME = FabricItemGroup.builder(new Identifier(TreeExample.MOD_ID, "item_group"))
            .icon(() -> new ItemStack(Items.COAL))
            .build();
}

