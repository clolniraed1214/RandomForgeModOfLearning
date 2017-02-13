package com.creamyrootbeer.randomforgemod.block.base;

import com.creamyrootbeer.randomforgemod.Constants;
import com.creamyrootbeer.randomforgemod.init.ModContent;
import com.creamyrootbeer.randomforgemod.item.base.BaseContent;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBase extends Block implements BaseContent<Block> {
	
	private final String BASE_NAME;
	private BlockRenderLayer blockRender = BlockRenderLayer.SOLID;
	private boolean opaque = true;
	
	public BlockBase(String name) {
		this(name, Material.ROCK);
	}
	
	public BlockBase(String name, Material material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        BASE_NAME = name;
        
        ModContent.addContent(this);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s:%s", Constants.MOD_ID, BASE_NAME);
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void initAssets() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName().toString()));
	}

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return blockRender;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state) {
    	return opaque;
    }
    
    public void setBlockRenderLayer(BlockRenderLayer layer) {
    	this.blockRender = layer;
    }
    
    public void setOpaqueCube(boolean opaque) {
    	this.opaque = opaque;
    }
    
    public Item getItem() {
    	return Item.getItemFromBlock(this);
    }
	
	@Override
	public void register() {
		GameRegistry.register(this);
		GameRegistry.register(getItem());
	}
	
}