package com.creamyrootbeer.randomforgemod.init;

import java.util.ArrayList;

import com.creamyrootbeer.randomforgemod.block.TestBlock;
import com.creamyrootbeer.randomforgemod.item.TestItem;
import com.creamyrootbeer.randomforgemod.item.food.TestFood;
import com.creamyrootbeer.randomforgemod.tile.block.TileCamoMine;
import com.creamyrootbeer.randomforgemod.tile.block.TileCancerBlock;
import com.creamyrootbeer.randomforgemod.tile.entity.TileEntityCamoMine;


@SuppressWarnings("rawtypes")
public class ModContent {
	
	private static final ArrayList<BaseContent> MOD_CONTENT = new ArrayList<BaseContent>();

	// THE BLOCKS
	public static final TestBlock TEST_BLOCK = new TestBlock();
	public static final TileCamoMine CAMO_MINE = new TileCamoMine();
	public static final TileCancerBlock CANCER_BLOCK = new TileCancerBlock();
		
	// THE ITEMS
	public static final TestItem TEST_ITEM = new TestItem();
	public static final TestFood TEST_FOOD = new TestFood();
	
	// THE TILE ENTITIES
	public static final TileEntityCamoMine CAMO_MINE_TE = new TileEntityCamoMine();
	
	public static void addContent(BaseContent object) {
		MOD_CONTENT.add(object);
	}
	
	public static ArrayList<BaseContent> getContent() {
		return MOD_CONTENT;
	}
	
}
