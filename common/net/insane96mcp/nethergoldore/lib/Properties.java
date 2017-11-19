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
			pigmanAggroChance = Config.LoadFloatProperty("ore_properties", "pigman_aggro_chance", "Chance for zombie pigman to get aggroed when a nether gold ore is mined. Set to 0 to disable", 10.0f);
			pigmanAggroRadius = Config.LoadFloatProperty("ore_properties", "pigman_aggro_radius", "Radius (from ore mined) for zombie pigman to get aggroed when a nether gold ore is mined\nThe radius has to be intended as a cube and not a sphere", 16f);
			
			ignitePlayerChance = Config.LoadFloatProperty("ore_properties", "ignite_player_chance", "Chance for the ore to set on fire the player. Set to 0 to disable", 0f);
			ignitePlayerSeconds = Config.LoadIntProperty("ore_properties", "ignite_player_seconds", "Seconds that the player will be set on fire", 0);
		}
	}
	
	public static class OreDrops{
		public static int minNuggetsPerOre;
		public static int maxNuggetsPerOre;
		public static float fortune_multiplier;
		
		public static int minExperienceDrop;
		public static int maxExperienceDrop;
		
		
		public static void Init() {
			minNuggetsPerOre = Config.LoadIntProperty("ore_drops", "nuggets_per_ore_min", "Minumum nuggets drop from the Ore (without fortune)", 4);
			maxNuggetsPerOre = Config.LoadIntProperty("ore_drops", "nuggets_per_ore_max", "Maximum nuggets drop from the Ore (without fortune)\nWith fortune max_nuggets_per_ore is increased with what formula: (max_nuggets_per_ore * (\"fortune level\" * fortune_multiplier))\nThat means that with Fortune III you can get up to 4 times more max nuggets (if fortune_multiplier is 1.0)\n", 6);
			fortune_multiplier = Config.LoadFloatProperty("ore_drops", "fortune_multiplier", "How much fortune will affect nugget drops (check max_nugget_per_ore)", 0.5f);
			
			minExperienceDrop = Config.LoadIntProperty("ore_drops", "exp_drop_min", "Minumum amount of experience drop from the Ore", 0);
			maxExperienceDrop = Config.LoadIntProperty("ore_drops", "exp_drop_max", "Maximum amount of experience drop from the Ore", 2);
		}
	}
	
	public static class OreGeneration{
		public static int blockCount;
		public static int perChunk;
		public static int minY;
		public static int maxY;
	
		public static void Init() {
			blockCount = Config.LoadIntProperty("ore_generation", "block_per_vein", "Number of blocks generated per vein (not exact)", 22);
			perChunk = Config.LoadIntProperty("ore_generation", "vein_per_chunk", "Number of veins that have to try to spawn per chunk", 1);
			minY = Config.LoadIntProperty("ore_generation", "min_Y", "The minimum height (Y) to try to generate Veins", 0);
			maxY = Config.LoadIntProperty("ore_generation", "max_Y", "The maximum height (Y) to try to generate Veins", 128);
		}
	}
}
