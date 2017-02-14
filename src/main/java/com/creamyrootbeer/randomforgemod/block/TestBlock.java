package com.creamyrootbeer.randomforgemod.block;

import com.creamyrootbeer.randomforgemod.block.base.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestBlock extends BlockBase {

	private static final int lightningRange = 50;
	private static final int lightningCount = 100;

	public TestBlock() {
		super("testblock");
		this.setHardness(2.0F);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setLightOpacity(1);
		this.setBlockRenderLayer(BlockRenderLayer.CUTOUT);
		this.setOpaqueCube(false);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		this.lightningExplode(worldIn, pos, true);
		return true;
	}
	
	@Override
	public void observedNeighborChange(IBlockState observerState, World world, BlockPos observerPos, Block changedBlock,
			BlockPos changedBlockPos) {
		if (world.isBlockPowered(observerPos)) {
			this.lightningExplode(world, observerPos, true);
		}
	}

	public void lightningExplode(World world, BlockPos pos, boolean destroy) {
		if (destroy) {
			world.setBlockToAir(pos);
		}
		
		for (int i = 0; i < lightningCount; i++) {
			int x = (int) (Math.random() * 2 * lightningRange - lightningRange) + pos.getX();
			int z = (int) (Math.random() * 2 * lightningRange - lightningRange) + pos.getZ();
			int y = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY();

			world.spawnEntity(new EntityLightningBolt(world, x, y, z, false));
		}
	}

}
