package com.creamyrootbeer.randomforgemod.init;

import java.util.ArrayList;

import net.minecraft.item.Item;

public class ModItems {
	
	private static ArrayList<Item> items = new ArrayList<Item>();
	
	public static void addItem(Item item) {
		items.add(item);
	}
	
	public static ArrayList<Item> getItems() {
		return items;
	}
	
}
