package net.insane96mcp.nethergoldore.proxies;

import net.insane96mcp.nethergoldore.init.ModBlocks;
import net.insane96mcp.nethergoldore.lib.Reflection;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void PreInit(FMLPreInitializationEvent event) {
		ModBlocks.Init();
		Reflection.Init();
	}
	
	public void Init(FMLInitializationEvent event) {
		ModBlocks.PostInit();
	}
	
	public void PostInit(FMLPostInitializationEvent event) {

	}
}
