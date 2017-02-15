package com.creamyrootbeer.randomforgemod.tile.block;

import com.creamyrootbeer.randomforgemod.Constants;
import com.creamyrootbeer.randomforgemod.tile.base.TileBlockBase;
import com.creamyrootbeer.randomforgemod.tile.entity.TileEntityCamoMine;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileCamoMine extends TileBlockBase {

	public TileCamoMine() {
		super(Constants.Names.TileEntities.CAMO_MINE);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityCamoMine();
	}

}
