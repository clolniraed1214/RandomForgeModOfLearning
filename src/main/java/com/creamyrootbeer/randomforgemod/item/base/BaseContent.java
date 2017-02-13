package com.creamyrootbeer.randomforgemod.item.base;

import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;

public interface BaseContent<T> extends IForgeRegistryEntry<T> {
	
	public abstract String getUnlocalizedName();
	public abstract void initAssets();
	public abstract void register();
	
}
