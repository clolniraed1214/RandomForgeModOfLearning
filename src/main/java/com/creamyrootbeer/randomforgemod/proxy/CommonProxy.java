package com.creamyrootbeer.randomforgemod.proxy;

import com.creamyrootbeer.randomforgemod.init.ModRegistry;

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
		System.out.print("Just registered the recipes.");
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub

	}

}
