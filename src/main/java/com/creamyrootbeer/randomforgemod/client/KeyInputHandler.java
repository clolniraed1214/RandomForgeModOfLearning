package com.creamyrootbeer.randomforgemod.client;

import com.creamyrootbeer.randomforgemod.network.NetworkHandler;
import com.creamyrootbeer.randomforgemod.network.packets.MessageExplode;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputHandler {
	
	private KeyBindings getPressedKey() {
		for (KeyBindings key : KeyBindings.values()) {
			if (key.isPressed()) {
				return key;
			}
		}
		return null;
	}
	
	@SubscribeEvent
	public void keyInputEvent(InputEvent.KeyInputEvent e) {
		KeyBindings key = getPressedKey();
		if (key != null) {
			switch (key) {
			case EXPLODE:
				NetworkHandler.sendToServer(new MessageExplode());
				break;
			default:
				break;
			}
		}
	}
}
