package com.creamyrootbeer.randomforgemod.tile.entity;

import java.util.ArrayList;

import com.creamyrootbeer.randomforgemod.Constants;
import com.creamyrootbeer.randomforgemod.init.ModContent;
import com.creamyrootbeer.randomforgemod.tile.base.TileEntityBase;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityCancerBlock extends TileEntityBase implements ITickable {
	
	private static final ArrayList<IBlockState> IRREPLACABLES = new ArrayList<IBlockState>() {
		private static final long serialVersionUID = 1L;
		{
			this.add(Blocks.AIR.getDefaultState());
			this.add(ModContent.CANCER_BLOCK.getDefaultState());
		}
	};
	private static final double INFECTION_CHANCE = 0.0025;
	private static final BlockPos[] BLOCK_POS_MODS = new BlockPos[] {
		new BlockPos(1, 0, 0),
		new BlockPos(0, 1, 0),
		new BlockPos(0, 0, 1),
		new BlockPos(-1, 0, 0),
		new BlockPos(0, -1, 0),
		new BlockPos(0, 0, -1),
	};
	
	private int ticks = 4;
	
	public TileEntityCancerBlock() {
		super(Constants.Names.TileEntities.CANCER_BLOCK);
	}

	@Override
	public void update() {
		if (ticks == 0) {
			grow(this.pos, this.world);
			ticks = 4;
		} else {
			ticks--;
		}
	}
	
	public void grow(BlockPos pos, World worldIn) {
		for (BlockPos posMod : BLOCK_POS_MODS) {
			BlockPos newPos = pos.add(posMod);
			if (isReplacable(world.getBlockState(newPos))) {
				if (Math.random() < INFECTION_CHANCE) worldIn.setBlockState(newPos, ModContent.CANCER_BLOCK.getDefaultState(), 2);
			}
		}
	}
	
	private static boolean isReplacable(IBlockState testState) {
		boolean isReplacable = true;
		for (IBlockState state : IRREPLACABLES) {
			if (testState.equals(state)) {
				isReplacable = false;
				break;
			}
		}
		
		return isReplacable;
	}
}
