package com.creamyrootbeer.randomforgemod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
// TODO Figure out what is wrong here...
public abstract class MessageBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, REQ> {

	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub

	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub

	}

	@Override
	public REQ onMessage(REQ message, MessageContext ctx) {
		if (ctx.side == Side.SERVER) {
			handleServerSide(message, ctx.getServerHandler().playerEntity);
		} else {
			handleClientSide(message, null);
		}
		return null;
	}

	public abstract void handleClientSide(REQ message, EntityPlayer player);

	public abstract void handleServerSide(REQ message, EntityPlayer player);

}
