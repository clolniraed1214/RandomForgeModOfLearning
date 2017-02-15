package com.creamyrootbeer.randomforgemod.tile.block;

import com.creamyrootbeer.randomforgemod.Constants;
import com.creamyrootbeer.randomforgemod.tile.base.TileBlockBase;
import com.creamyrootbeer.randomforgemod.tile.entity.TileEntityCancerBlock;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class TileCancerBlock extends TileBlockBase {
	
	public TileCancerBlock() {
		super(Constants.Names.TileEntities.CANCER_BLOCK, Material.WEB);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	@Override
	public void register() {
		super.register();
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityCancerBlock();
	}
}
