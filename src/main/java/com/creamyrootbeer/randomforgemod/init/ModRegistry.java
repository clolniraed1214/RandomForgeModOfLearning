package com.creamyrootbeer.randomforgemod.init;

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
		GameRegistry.addShapedRecipe(new ItemStack(ModContent.TEST_BLOCK, 4), "OOO","OGO","OOO",'O',new ItemStack(Blocks.OBSIDIAN),'G', new ItemStack(Blocks.GLASS));
		GameRegistry.addShapedRecipe(new ItemStack(ModContent.TEST_FOOD), "GSG","SGS","GSG",'G',new ItemStack(Blocks.DIRT, 2), 'S', new ItemStack(Blocks.SAND));
		GameRegistry.addShapelessRecipe(new ItemStack(ModContent.CANCER_BLOCK, 2), new ItemStack(Blocks.DIRT, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModContent.CANCER_BLOCK, 4), new ItemStack(ModContent.CANCER_BLOCK, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(ModContent.CANCER_BLOCK, 8), new ItemStack(ModContent.CANCER_BLOCK, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(ModContent.CANCER_BLOCK, 32), new ItemStack(ModContent.CANCER_BLOCK, 8));
	}
}
