package net.insane96mcp.nethergoldore.network;

import io.netty.buffer.ByteBuf;
import net.insane96mcp.nethergoldore.lib.Properties;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ConfigSync implements IMessage {

	int minNuggetsPerOre, maxNuggetsPerOre, minExperienceDrop, maxExperienceDrop, orePerVein, minY, maxY;
	float veinPerChunk, pigmanAggroChance, pigmanAggroRadius;
	
	@Override
	public void fromBytes(ByteBuf buf) {
		minNuggetsPerOre = buf.readInt();
		maxNuggetsPerOre = buf.readInt();
		minExperienceDrop = buf.readInt();
		maxExperienceDrop = buf.readInt();
		orePerVein = buf.readInt();
		veinPerChunk = buf.readFloat();
		minY = buf.readInt();
		maxY = buf.readInt();
		pigmanAggroChance = buf.readFloat();
		pigmanAggroRadius = buf.readFloat();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(Properties.config.drops.minNuggetsPerOre);
		buf.writeInt(Properties.config.drops.maxNuggetsPerOre);
		buf.writeInt(Properties.config.drops.minExperienceDrop);
		buf.writeInt(Properties.config.drops.maxExperienceDrop);
		buf.writeInt(Properties.config.generation.orePerVein);
		buf.writeFloat(Properties.config.generation.veinPerChunk);
		buf.writeInt(Properties.config.generation.minY);
		buf.writeInt(Properties.config.generation.maxY);
		buf.writeFloat(Properties.config.oreProperties.pigmanAggroChance);
		buf.writeFloat(Properties.config.oreProperties.pigmanAggroRadius);
	}

	public class Handler implements IMessageHandler<ConfigSync, IMessage> {

		@Override
		public IMessage onMessage(ConfigSync message, MessageContext ctx) {
			IThreadListener iThreadListener = Minecraft.getMinecraft();
			iThreadListener.addScheduledTask(new Runnable() {
				
				@Override
				public void run() {
					Properties.config.drops.minNuggetsPerOre = message.minNuggetsPerOre;
					Properties.config.drops.maxNuggetsPerOre = message.maxNuggetsPerOre;
					Properties.config.drops.minExperienceDrop = message.minExperienceDrop;
					Properties.config.drops.maxExperienceDrop = message.maxExperienceDrop;
					Properties.config.generation.orePerVein = message.orePerVein;
					Properties.config.generation.veinPerChunk = message.veinPerChunk;
					Properties.config.generation.minY = message.minY;
					Properties.config.generation.maxY = message.maxY;
					Properties.config.oreProperties.pigmanAggroChance = message.pigmanAggroChance;
					Properties.config.oreProperties.pigmanAggroRadius = message.pigmanAggroRadius;
				}
			});
			return null;
		}
		
	}
}
