package net.insane96mcp.nethergoldore.lib;

public class Properties {
	public static void Init() {
		OreProperties.Init();
		OreDrops.Init();
		OreGeneration.Init();
	}
	
	public static class OreProperties{
		public static float pigmanAggroChance;
		public static float pigmanAggroRadius;
		
		public static float ignitePlayerChance;
		public static int ignitePlayerSeconds;
		
		public static void Init() {
			pigmanAggroChance = Config.LoadFloatProperty("ore_properties", "pigman_aggro_chance", "Chance for zombie pigman to get aggroed when a nether gold ore is mined. Set to 0 to disable", 5.0f);
			pigmanAggroRadius = Config.LoadFloatProperty("ore_properties", "pigman_aggro_radius", "Radius (from ore mined) for zombie pigman to get aggroed when a nether gold ore is mined\nThe radius has to be intended as a cube and not a sphere", 24f);
			
			ignitePlayerChance = Config.LoadFloatProperty("ore_properties", "ignite_player_chance", "Chance for the ore to set on fire the player. Set to 0 to disable", 0f);
			ignitePlayerSeconds = Config.LoadIntProperty("ore_properties", "ignite_player_seconds", "Seconds that the player will be set on fire", 0);
		}
	}
	
	public static class OreDrops{
		public static int minNuggetsPerOre;
		public static int maxNuggetsPerOre;
		
		public static int minExperienceDrop;
		public static int maxExperienceDrop;
		
		
		public static void Init() {
			minNuggetsPerOre = Config.LoadIntProperty("ore_drops", "nuggets_per_ore_min", "Minumum nuggets drop from the Ore (without fortune). Every Level of fortune increases this value by 1", 4);
			maxNuggetsPerOre = Config.LoadIntProperty("ore_drops", "nuggets_per_ore_max", "Maximum nuggets drop from the Ore (without fortune). Every Level of fortune increases this value by 1", 6);
			
			minExperienceDrop = Config.LoadIntProperty("ore_drops", "exp_drop_min", "Minumum amount of experience drop from the Ore", 0);
			maxExperienceDrop = Config.LoadIntProperty("ore_drops", "exp_drop_max", "Maximum amount of experience drop from the Ore", 2);
		}
	}
	
	public static class OreGeneration{
		public static int blockCount;
		public static float perChunk;
		public static int minY;
		public static int maxY;
	
		public static void Init() {
			blockCount = Config.LoadIntProperty("ore_generation", "block_per_vein", "Number of blocks generated per vein (not exact)", 22);
			perChunk = Config.LoadFloatProperty("ore_generation", "vein_per_chunk", "Number of veins that have to try to spawn per chunk, values below 1 will be chance per chunk to spawn. (By default there's 80% chance for a vein to spawn per chunk)", 0.8f);
			minY = Config.LoadIntProperty("ore_generation", "min_Y", "The minimum height (Y) to try to generate Veins", 0);
			maxY = Config.LoadIntProperty("ore_generation", "max_Y", "The maximum height (Y) to try to generate Veins", 128);
		}
	}
}
