package com.creamyrootbeer.randomforgemod;

import com.creamyrootbeer.randomforgemod.proxy.IProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Constants.MOD_ID, version=Constants.VERSION, name=Constants.NAME)
public class ForgeMod {
	
	@Mod.Instance
	public static ForgeMod instance;
	
	@SidedProxy(clientSide=(Constants.PACKAGE + ".proxy.ClientProxy"), serverSide=(Constants.PACKAGE + ".proxy.ServerProxy"))
	public static IProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
	
}
