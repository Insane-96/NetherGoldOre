package net.insane96mcp.nethergoldore.proxies;

import net.insane96mcp.nethergoldore.NetherGoldOre;
import net.insane96mcp.nethergoldore.init.ModBlocks;
import net.insane96mcp.nethergoldore.lib.Properties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void PreInit(FMLPreInitializationEvent event) {
		//ConfigLib.config = new Configuration(event.getSuggestedConfigurationFile());
		//ConfigLib.SyncConfig();

		ModBlocks.Init();
		
		MinecraftForge.EVENT_BUS.register(Properties.class);
	}
	
	public void Init(FMLInitializationEvent event) {
		ModBlocks.PostInit();
		
		ConfigManager.sync(NetherGoldOre.MOD_ID, Type.INSTANCE);
	}
	
	public void PostInit(FMLPostInitializationEvent event) {
		//if(ConfigLib.config.hasChanged()) ConfigLib.SaveConfig();
	}
}
