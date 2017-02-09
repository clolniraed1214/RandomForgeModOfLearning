package com.creamyrootbeer.randomforgemod.block.base;

import com.creamyrootbeer.randomforgemod.Constants;
import com.creamyrootbeer.randomforgemod.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBase extends Block {
	
	private final String NAME;
	
	public BlockBase(String name) {
		this(name, Material.ROCK);
	}
	
	public BlockBase(String name, Material material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        NAME = name;
        
        ModBlocks.addBlock(this);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s:%s", Constants.MOD_ID, NAME);
    }
	
	@SideOnly(Side.CLIENT)
	public void initModels() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName().toString()));
	}
	
}
