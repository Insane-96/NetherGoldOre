package net.insane96mcp.nethergoldore;

import net.insane96mcp.nethergoldore.init.ModBlocks;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void PreInit(FMLPreInitializationEvent event) {
		Config.config = new Configuration(event.getSuggestedConfigurationFile());
		Config.SyncConfig();

		ModBlocks.Init();
	}
	
	public void Init(FMLInitializationEvent event) {
		ModBlocks.PostInit();
	}
	
	public void PostInit(FMLPostInitializationEvent event) {
		if(Config.config.hasChanged()) Config.SaveConfig();
	}
}
