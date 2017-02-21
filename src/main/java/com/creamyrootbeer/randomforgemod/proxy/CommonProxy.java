package com.creamyrootbeer.randomforgemod.proxy;

import com.creamyrootbeer.randomforgemod.init.ModRegistry;
import com.creamyrootbeer.randomforgemod.network.NetworkHandler;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		ModRegistry.registerContent();
	}

	@Override
	public void init(FMLInitializationEvent e) {
		ModRegistry.registerRecipes();
		NetworkHandler.init();
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {

	}

}
