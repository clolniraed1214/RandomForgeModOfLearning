package com.creamyrootbeer.randomforgemod.item.base;

import com.creamyrootbeer.randomforgemod.Constants;
import com.creamyrootbeer.randomforgemod.init.ModItems;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBase extends Item {
	
	private final String BASE_NAME;
	
	public ItemBase(String name) {
		super();
		this.BASE_NAME = name;
		setRegistryName(name);
		setUnlocalizedName(getUnlocalizedName());
		
		ModItems.addItem(this);
	}
	
	public String getUnlocalizedName() {
		return String.format("item.%s:%s", Constants.MOD_ID, BASE_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	public void initTextures() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
	}
	
}
