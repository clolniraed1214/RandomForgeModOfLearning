package com.creamyrootbeer.randomforgemod.item.base;

import com.creamyrootbeer.randomforgemod.Constants;
import com.creamyrootbeer.randomforgemod.init.BaseContent;
import com.creamyrootbeer.randomforgemod.init.ModContent;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ItemFoodBase extends ItemFood implements BaseContent<Item> {

	private final String BASE_NAME;

	public ItemFoodBase(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.BASE_NAME = name;
		setRegistryName(name);
		setUnlocalizedName(name);

		ModContent.addContent(this);
	}

	public String getUnlocalizedName() {
		return String.format("item.%s:%s", Constants.MOD_ID, BASE_NAME);
	}

	@SideOnly(Side.CLIENT)
	public void initAssets() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
	}

	@Override
	public void register() {
		GameRegistry.register(this);
	}

}
