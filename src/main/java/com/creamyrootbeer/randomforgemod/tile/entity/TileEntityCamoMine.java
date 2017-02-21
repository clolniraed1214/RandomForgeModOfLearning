package com.creamyrootbeer.randomforgemod.tile.entity;

import java.util.List;

import com.creamyrootbeer.randomforgemod.Constants;
import com.creamyrootbeer.randomforgemod.tile.base.TileEntityBase;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class TileEntityCamoMine extends TileEntityBase implements ITickable {

	private int timer = 60;

	public TileEntityCamoMine() {
		super(Constants.Names.TileEntities.CAMO_MINE);
	}

	@Override
	public void update() {
		if (timer == 0) {
			BlockPos pos1 = this.pos.add(-2, -2, -2);
			BlockPos pos2 = this.pos.add(3, 3, 3);
			List<EntityPlayer> entities = this.world.getEntitiesWithinAABB(EntityPlayer.class,
					new AxisAlignedBB(pos1, pos2));
			if (entities.size() > 0) {
				if (!this.world.isRemote) {
					this.world.setBlockState(this.pos, Blocks.AIR.getDefaultState());
					this.world.createExplosion(null, this.pos.getX(), this.pos.getY(), this.pos.getZ(), 8.0F, true);
				}
			}
		} else {
			this.timer--;
		}
	}

}
