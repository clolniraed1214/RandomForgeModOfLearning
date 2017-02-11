package com.creamyrootbeer.randomforgemod.block;

import com.creamyrootbeer.randomforgemod.block.base.BlockBase;

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

	private static final int lightningRange = 10;
	private static final int lightningCount = 50;
	
	public TestBlock() {
		super("testblock");
		setHardness(2.0F);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setLightOpacity(1);
		this.setBlockRenderLayer(BlockRenderLayer.CUTOUT);
		this.setOpaqueCube(false);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		worldIn.setBlockToAir(pos);
		
		for (int i = 0; i < lightningCount; i++) {
			int x = (int) (Math.random()*2*lightningRange-lightningRange) + pos.getX();
			int z = (int) (Math.random()*2*lightningRange-lightningRange) + pos.getZ();
			int y = /*(int) (Math.random()*2*lightningRange-lightningRange) + pos.getY();*/worldIn.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY();
			
			worldIn.spawnEntity(new EntityLightningBolt(worldIn, x, y, z, false));
		}
		
		return true;
	}
	
	
	
}
