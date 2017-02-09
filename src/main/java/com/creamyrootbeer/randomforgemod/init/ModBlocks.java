package com.creamyrootbeer.randomforgemod.init;

import java.util.ArrayList;

import com.creamyrootbeer.randomforgemod.block.TestBlock;
import com.creamyrootbeer.randomforgemod.block.base.BlockBase;

public class ModBlocks {
	private static final ArrayList<BlockBase> MOD_BLOCKS = new ArrayList<BlockBase>();
	
	public static final BlockBase testBlock = new TestBlock();
	
	public static void addBlock(BlockBase block) {		
		MOD_BLOCKS.add(block);
	}
	
	public static ArrayList<BlockBase> getBlocks() {
		return MOD_BLOCKS;
	}
}
