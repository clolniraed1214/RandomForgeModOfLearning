package com.creamyrootbeer.randomforgemod.proxy;

import com.creamyrootbeer.randomforgemod.block.base.BlockBase;
import com.creamyrootbeer.randomforgemod.init.ModBlocks;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		for (BlockBase block : ModBlocks.getBlocks()) {
			block.initModels();
		}
	}

	@Override
	public void init(FMLInitializationEvent e) {
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
	
	
}
