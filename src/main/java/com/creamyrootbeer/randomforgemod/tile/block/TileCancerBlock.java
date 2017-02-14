package com.creamyrootbeer.randomforgemod.tile.block;

import com.creamyrootbeer.randomforgemod.init.ModContent;
import com.creamyrootbeer.randomforgemod.tile.base.TileBlockBase;
import com.creamyrootbeer.randomforgemod.tile.entity.TileEntityCancerBlock;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class TileCancerBlock extends TileBlockBase {
	
	private static final BlockPos[] BLOCK_POS_MODS = new BlockPos[] {
		new BlockPos(1, 0, 0),
		new BlockPos(0, 1, 0),
		new BlockPos(0, 0, 1),
		new BlockPos(-1, 0, 0),
		new BlockPos(0, -1, 0),
		new BlockPos(0, 0, -1),
	};
	
	public TileCancerBlock() {
		super("cancer_block", Material.WEB);
	}
	
	@Override
	public void register() {
		super.register();
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		grow(pos, worldIn); 
		return true;
	}
	
	private void grow(BlockPos pos, World worldIn) {
		for (BlockPos posMod : BLOCK_POS_MODS) {
			BlockPos newPos = pos.add(posMod);
			if (!worldIn.getBlockState(newPos).equals(Blocks.AIR.getDefaultState())) {
				if (Math.random() < 0.05) worldIn.setBlockState(newPos, ModContent.CANCER_BLOCK.getDefaultState(), 2);
			}
		}
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityCancerBlock();
	}
}
