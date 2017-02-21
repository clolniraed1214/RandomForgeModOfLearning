package com.creamyrootbeer.randomforgemod.client;

import org.lwjgl.input.Keyboard;

import com.creamyrootbeer.randomforgemod.Constants;

import net.minecraft.client.settings.KeyBinding;

public enum KeyBindings {
	
	EXPLODE("explode", Keyboard.KEY_G);
	
	private final KeyBinding keybinding;
	
	private KeyBindings(String keyName, int defaultKeyCode) {
		keybinding = new KeyBinding("key." + Constants.MOD_ID + "." + keyName, defaultKeyCode, "key.categories." + Constants.MOD_ID);
	}
	
	public KeyBinding getKeyBind() {
		return keybinding;
	}
	
	public boolean isPressed() {
		return keybinding.isPressed();
	}
	
}
