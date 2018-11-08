package net.insane96mcp.nethergoldore.lib;

import net.insane96mcp.nethergoldore.NetherGoldOre;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.Config.RangeInt;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = NetherGoldOre.MOD_ID, name = "NetherGoldOre", category = "")
public class Properties {

	@Name("Config")
	public static final ConfigOptions config = new ConfigOptions();
	
	public static class ConfigOptions {
		
		public Drops drops = new Drops();
		
		public static class Drops {
			@Name("Minimum Nuggets Per Ore")
			@Comment("Minumum nuggets drop from the Ore")
			@RangeInt(min = 0)
			public int minNuggetsPerOre = 4;
			@Name("Maximum Nuggets Per Ore")
			@Comment("Maximum nuggets drop from the Ore (without fortune). Every Level of fortune increases this value by 1")
			@RangeInt(min = 0)
			public int maxNuggetsPerOre = 6;

			@Name("Minimum Experience Per Ore")
			@Comment("Minumum amount of experience drop from the Ore")
			@RangeInt(min = 0)
			public int minExperienceDrop = 0;
			@Name("Maximum Experience Per Ore")
			@Comment("Maximum amount of experience drop from the Ore")
			@RangeInt(min = 0)
			public int maxExperienceDrop = 2;
		}
		
		@Name("ore properties")
		public OreProperties oreProperties = new OreProperties();
		
		public static class OreProperties {
			@Name("Pigman Aggro Chance")
			@Comment("Chance for zombie pigman to get aggroed when a nether gold ore is mined. Set to 0 to disable")
			@RangeDouble(min = 0f, max = 100f)
			public float pigmanAggroChance = 5f;
			@Name("Pigman See Chance")
			@Comment("Chance (1 in x) for zombie pigman to get aggroed when a nether gold ore is mined and the pigman see the player.s")
			@RangeInt(min = 1)
			public int pigmanSeeChance = 4;
			@Name("Pigman Aggro Radius")
			@Comment("Radius (from ore mined) for zombie pigman to get aggroed when a nether gold ore is mined\nThe radius has to be intended as a cube and not a sphere")
			@RangeDouble(min = 0f, max = Float.MAX_VALUE)
			public float pigmanAggroRadius = 24f;
		}
		
		@Name("ore generation")
		public Generation generation = new Generation();
		
		public static class Generation {
			@Name("Ore Per Vein")
			@Comment("Number of blocks generated per vein (not exact)")
			@RangeInt(min = 0)
			public int orePerVein = 22;
			@Name("Vein Per Chunk")
			@Comment("Number of veins that have to try to spawn per chunk, values below 1 will be chance per chunk to spawn. (By default there's 80% chance for a vein to spawn per chunk)")
			@RangeDouble(min = 0f, max = Float.MAX_VALUE)
			public float veinPerChunk = 0.8f;
			@Name("Min Y")
			@Comment("The minimum height (Y) to try to generate Veins")
			@RangeInt(min = 0, max = 128)
			public int minY = 0;
			@Name("Max Y")
			@Comment("The maximum height (Y) to try to generate Veins")
			@RangeInt(min = 0, max = 128)
			public int maxY = 128;
		}
	}

	@Mod.EventBusSubscriber(modid = NetherGoldOre.MOD_ID)
	private static class EventHandler{
		@SubscribeEvent
	    public static void onConfigChangedEvent(OnConfigChangedEvent event)
	    {
	        if (event.getModID().equals(NetherGoldOre.MOD_ID))
	        {
	            ConfigManager.sync(NetherGoldOre.MOD_ID, Type.INSTANCE);
	        }
	    }
	}
}
