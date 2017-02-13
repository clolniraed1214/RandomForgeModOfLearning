package com.creamyrootbeer.randomforgemod.init;

import com.creamyrootbeer.randomforgemod.item.base.BaseContent;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

@SuppressWarnings("rawtypes")
public class ModRegistry {
	public static void registerContent() {
		for (BaseContent object : ModContent.getContent()) { 
			object.register();
		}
	}
	
	public static void registerRenders() {
		for (BaseContent object : ModContent.getContent()) {
			object.initAssets();
		}
	}

	public static void registerRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(ModContent.TEST_BLOCK.getItem(), 4), "OOO","OGO","OOO",'O',new ItemStack(Blocks.OBSIDIAN),'G', new ItemStack(Blocks.GLASS));
	}
}
