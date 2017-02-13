package com.creamyrootbeer.randomforgemod.item;

import com.creamyrootbeer.randomforgemod.item.base.ItemBase;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class TestItem extends ItemBase {
	
	public TestItem() {
		super("test_item");
		this.setCreativeTab(CreativeTabs.MISC);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.setHealth(0.0F);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
