package net.insane96mcp.nethergoldore.lib;

import net.insane96mcp.nethergoldore.Config;

public class Stats {
	public static class OreGeneration{
		public static int blockCount = Config.LoadIntProperty("ore_generation", "block_per_vein", "Number of blocks generated per vein (not exact)", 22);
		public static int perChunk = Config.LoadIntProperty("ore_generation", "vein_per_chunk", "Number of veins that have to try to spawn per chunk", 1);
		public static int minY = Config.LoadIntProperty("ore_generation", "min_Y", "The minimum height (Y) to try to generate Veins", 0);
		public static int maxY = Config.LoadIntProperty("ore_generation", "max_Y", "The maximum height (Y) to try to generate Veins", 128);
	}
	
	public static int minNuggetsPerOre = Config.LoadIntProperty("ore_drops", "min_nuggets_per_ore", "Minumum nuggets drop from the Ore (without fortune)", 4);
	public static int maxNuggetsPerOre = Config.LoadIntProperty("ore_drops", "max_nuggets_per_ore", "Maximum nuggets drop from the Ore (without fortune)\nWith fortune max_nuggets_per_ore is increased with what follows: (max_nuggets_per_ore * (fortune level * fortune_multiplier))\nThat means that with Fortune III you can get up to 4 times more max nuggets (if fortune_multiplier is 1.0)\n", 6);
	public static float fortune_multiplier = Config.LoadFloatProperty("ore_drops", "fortune_multiplier", "How much fortune will affect nugget drops (check max_nugget_per_ore)", 0.5f);
	
	public static int minExperienceDrop = Config.LoadIntProperty("ore_drops", "min_exp_drop", "Minumum amount of experience drop from the Ore (without silktouch)", 0);
	public static int maxExperienceDrop = Config.LoadIntProperty("ore_drops", "max_exp_drop", "Minumum amount of experience drop from the Ore (without silktouch)", 2);
	
	public static int pigmanAggroChance = Config.LoadIntProperty("pigman_aggro", "pigman_aggro_chance", "Chance for zombie pigman to get aggroed when a nether gold ore is mined. Set to 0 to disable", 10);
	public static int pigmanAggroRadius = Config.LoadIntProperty("pigman_aggro", "pigman_aggro_radius", "Radius (from block) for zombie pigman to get aggroed when a nether gold ore is mined\nThe radius has to be intended as a cube and not a sphere", 16);
	
	public static int ignitePlayerChance = Config.LoadIntProperty("ignite_player", "ignite_player_chance", "Chance for the ore to set on fire the player. Set to 0 to disable", 0);
	public static int ignitePlayerSeconds = Config.LoadIntProperty("ignite_player", "ignite_player_seconds", "Seconds that the player will be set on fire", 0);
}
