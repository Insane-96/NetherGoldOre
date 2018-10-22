package net.insane96mcp.nethergoldore.lib;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigLib {

	public static Configuration config;
	
	public static int LoadIntProperty(String category, String key, String description, int defaultValue) {
		Property property = ConfigLib.config.get(category, key, defaultValue);
		property.setComment(description + " (default: " + defaultValue + ")");
		
		return property.getInt();
	}
	
	public static int[] LoadIntListProperty(String category, String key, String description, int[] defaultValue) {
		Property property = ConfigLib.config.get(category, key, defaultValue);
		description += " (default: [";
		for (int i = 0; i < defaultValue.length; i++) {
			description += defaultValue[i];
			if (i != defaultValue.length - 1)
				description += ", ";
		}
		description += "])";
		
		property.setComment(description);
		
		return property.getIntList();
	}
	
	public static double LoadDoubleProperty(String category, String key, String description, double defaultValue) {
		Property property = ConfigLib.config.get(category, key, defaultValue);
		property.setComment(description + " (default: " + defaultValue + ")");
		
		return property.getDouble();
	}
	
	public static float LoadFloatProperty(String category, String key, String description, float defaultValue) {
		return (float)LoadDoubleProperty(category, key, description, defaultValue);
	}
	
	public static String LoadStringProperty(String category, String key, String description, String defaultValue) {
		Property property = ConfigLib.config.get(category, key, defaultValue);
		property.setComment(description + " (default: " + defaultValue + ")");
		
		return property.getString();
	}
	
	public static String[] LoadStringListProperty(String category, String key, String description, String[] defaultValue) {
		Property property = ConfigLib.config.get(category, key, defaultValue);
		description += " (default: [";
		for (int i = 0; i < defaultValue.length; i++) {
			description += defaultValue[i];
			if (i != defaultValue.length - 1)
				description += ", ";
		}
		description += "])";
		
		return property.getStringList();
	}
	
	public static boolean LoadBoolProperty(String category, String key, String description, boolean defaultValue) {
		Property property = ConfigLib.config.get(category, key, defaultValue);
		property.setComment(description + " (default: " + defaultValue + ")");
		
		return property.getBoolean();
	}
	
	public static void SetCategoryComment(String category, String comment) {
		ConfigLib.config.setCategoryComment(category, comment);
	}
	
	/**
	 * Must be called in Mod PreInit before everything and after
	 * Config.config = new Configuration(event.getSuggestedConfigurationFile());
	 */
	public static void SyncConfig() {
		try {
			ConfigLib.config.load();
		}
		catch (Exception e) {
			
		}
	}
	/**
	 * It's recommended to be called in Mod PostInit after everything
	 */
	public static void SaveConfig() {
		if(ConfigLib.config.hasChanged()) ConfigLib.config.save();
	}
}
