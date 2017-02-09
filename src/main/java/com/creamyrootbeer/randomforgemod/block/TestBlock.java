package com.creamyrootbeer.randomforgemod.block;

import com.creamyrootbeer.randomforgemod.block.base.BlockBase;

import net.minecraft.creativetab.CreativeTabs;

public class TestBlock extends BlockBase {
	
	public TestBlock() {
		super("testblock");
		setHardness(2.0F);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
}
