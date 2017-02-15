package com.creamyrootbeer.randomforgemod.tile.base;

import com.creamyrootbeer.randomforgemod.Constants;
import com.creamyrootbeer.randomforgemod.init.BaseContent;
import com.creamyrootbeer.randomforgemod.init.ModContent;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class TileBlockBase extends BlockContainer implements ITileEntityProvider, BaseContent<Block> {
	
	public final String BASE_NAME;
	private BlockRenderLayer blockRender = BlockRenderLayer.SOLID;
	private boolean opaque = true;
	
	protected TileBlockBase(String name) {
		this(name, Material.ROCK);
	}
	
	protected TileBlockBase(String name, Material material) {
		super(Material.ROCK);
        setRegistryName(Constants.MOD_ID + ":" + name);
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
	
	@Override
	public void register() {
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), this.getRegistryName());
	}

	@Override
	public abstract TileEntity createNewTileEntity(World worldIn, int meta);

}
