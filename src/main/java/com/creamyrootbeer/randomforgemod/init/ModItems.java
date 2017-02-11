package com.creamyrootbeer.randomforgemod.init;

import java.util.ArrayList;

import com.creamyrootbeer.randomforgemod.item.TestItem;
import com.creamyrootbeer.randomforgemod.item.base.ItemBase;

public class ModItems {
	
	private static final ArrayList<ItemBase> MOD_ITEMS = new ArrayList<ItemBase	>();
	
	public static final TestItem TEST_ITEM = new TestItem();
	
	public static void addItem(ItemBase item) {
		MOD_ITEMS.add(item);
	}
	
	public static ArrayList<ItemBase> getItems() {
		return MOD_ITEMS;
	}
	
}
