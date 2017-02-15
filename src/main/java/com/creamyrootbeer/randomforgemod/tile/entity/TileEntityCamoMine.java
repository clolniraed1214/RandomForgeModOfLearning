package com.creamyrootbeer.randomforgemod.tile.entity;

import com.creamyrootbeer.randomforgemod.Constants;
import com.creamyrootbeer.randomforgemod.tile.base.TileEntityBase;

import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileEntityCamoMine extends TileEntityBase implements ITickable {
	
	private int timer = 60;
	
	public TileEntityCamoMine() {
		super(Constants.Names.TileEntities.CAMO_MINE);
	}

	@Override
	public void update() {
		timer--;
		if (timer == 0 && !getWorld().isRemote) {
			BlockPos pos = this.getPos();
			getWorld().createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 3.0F, true);
		}
	}

}
