package com.creamyrootbeer.randomforgemod.tile.entity;

import com.creamyrootbeer.randomforgemod.Constants;
import com.creamyrootbeer.randomforgemod.init.ModContent;
import com.creamyrootbeer.randomforgemod.tile.base.TileEntityBase;

import net.minecraft.init.Blocks;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityCancerBlock extends TileEntityBase implements ITickable {

	private static final BlockPos[] BLOCK_POS_MODS = new BlockPos[] {
		new BlockPos(1, 0, 0),
		new BlockPos(0, 1, 0),
		new BlockPos(0, 0, 1),
		new BlockPos(-1, 0, 0),
		new BlockPos(0, -1, 0),
		new BlockPos(0, 0, -1),
	};
	
	public TileEntityCancerBlock() {
		super(Constants.Names.TileEntities.CANCER_BLOCK);
	}

	@Override
	public void update() {
		grow(this.pos, this.world);
	}
	
	public void grow(BlockPos pos, World worldIn) {
		for (BlockPos posMod : BLOCK_POS_MODS) {
			BlockPos newPos = pos.add(posMod);
			if (!worldIn.getBlockState(newPos).equals(Blocks.AIR.getDefaultState()) && 
					!worldIn.getBlockState(newPos).equals(ModContent.CANCER_BLOCK.getDefaultState())) {
				if (Math.random() < 0.005) worldIn.setBlockState(newPos, ModContent.CANCER_BLOCK.getDefaultState(), 2);
			}
		}
	}
	
}
