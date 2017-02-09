package com.creamyrootbeer.randomforgemod.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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
		
	}
}
