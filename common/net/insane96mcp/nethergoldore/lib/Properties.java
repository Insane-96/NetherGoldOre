package net.insane96mcp.nethergoldore.lib;

import net.insane96mcp.nethergoldore.NetherGoldOre;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

@Config(modid = NetherGoldOre.MOD_ID, name = "NetherGoldOre", category = "")
public class Properties {

	@Name("Config")
	public static final ConfigOptions config = new ConfigOptions();
	
	public static class ConfigOptions {
		
		public Drops drops = new Drops();
		
		public static class Drops {
			@Comment("Minumum nuggets drop from the Ore")
			public int minNuggetsPerOre = 4;
			@Comment("Maximum nuggets drop from the Ore (without fortune). Every Level of fortune increases this value by 1")
			public int maxNuggetsPerOre = 6;
			
			@Comment("Minumum amount of experience drop from the Ore")
			public int minExperienceDrop = 0;
			@Comment("Maximum amount of experience drop from the Ore")
			public int maxExperienceDrop = 2;
		}
		
		@Name("properties")
		public OreProperties oreProperties = new OreProperties();
		
		public static class OreProperties {
			@Comment("Chance for zombie pigman to get aggroed when a nether gold ore is mined. Set to 0 to disable")
			public float pigmanAggroChance = 5f;
			@Comment("Radius (from ore mined) for zombie pigman to get aggroed when a nether gold ore is mined\\nThe radius has to be intended as a cube and not a sphere")
			public float pigmanAggroRadius = 24f;
		}
		
		public Generation generation = new Generation();
		
		public static class Generation {
			@Comment("Number of blocks generated per vein (not exact)")
			public int orePerVein = 22;
			@Comment("Number of veins that have to try to spawn per chunk, values below 1 will be chance per chunk to spawn. (By default there's 80% chance for a vein to spawn per chunk)")
			public float veinPerChunk = 0.8f;
			@Comment("The minimum height (Y) to try to generate Veins")
			public int minY = 0;
			@Comment("The maximum height (Y) to try to generate Veins")
			public int maxY = 128;
		}
	}

	@Mod.EventBusSubscriber(modid = NetherGoldOre.MOD_ID)
	private static class EventHandler{
	    public static void onConfigChangedEvent(OnConfigChangedEvent event)
	    {
	        if (event.getModID().equals(NetherGoldOre.MOD_ID))
	        {
	            ConfigManager.sync(NetherGoldOre.MOD_ID, Type.INSTANCE);
	        }
	    }
	    
	    public static void onPlayerLoggedIn(PlayerLoggedInEvent event) {
	    	if (event.player.world.isRemote)
	    		return;
	    	
	    	
	    }
	}
}
