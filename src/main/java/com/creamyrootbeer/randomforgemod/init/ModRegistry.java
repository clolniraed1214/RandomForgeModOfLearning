package com.creamyrootbeer.randomforgemod.init;

import com.creamyrootbeer.randomforgemod.block.base.BlockBase;
import com.creamyrootbeer.randomforgemod.item.base.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRegistry {
	public static void registerContent() {
		registerItems();
		registerBlocks();
	}
	
	private static void registerItems() {
		for (Item item : ModItems.getItems()) { 
			GameRegistry.register(item);
		}
	}
	
	private static void registerBlocks() {
		for (Block block : ModBlocks.getBlocks()) {
			GameRegistry.register(block);
			GameRegistry.register(new ItemBlock(block).setRegistryName(block.getUnlocalizedName()));
		}
	}
	
	public static void registerRenders() {
		for (BlockBase block : ModBlocks.getBlocks()) {
			block.initModels();
		}
		for (ItemBase item : ModItems.getItems()) {
			item.initTextures();
		}
	}

	public static void registerRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.TEST_BLOCK, 4), "OOO","OGO","OOO",'O',new ItemStack(Blocks.OBSIDIAN,1),'G',new ItemStack(Blocks.GLASS,1));
	}
}
