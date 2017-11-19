package net.insane96mcp.nethergoldore;

import java.util.ArrayList;
import java.util.Random;

import net.insane96mcp.nethergoldore.proxies.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = NetherGoldOre.MOD_ID, name = NetherGoldOre.MOD_NAME, version = NetherGoldOre.VERSION, acceptedMinecraftVersions = NetherGoldOre.MINECRAFT_VERSIONS)
public class NetherGoldOre {
	
	public static final String MOD_ID = "nethergoldore";
	public static final String MOD_NAME = "Nether Gold Ore";
	public static final String VERSION = "1.1.0";
	public static final String RESOURCE_PREFIX = MOD_ID.toLowerCase() + ":";
	public static final String MINECRAFT_VERSIONS = "[1.10, 1.10.2]";

	public static Random random = new Random();
	
	@Instance(MOD_ID)
	public static NetherGoldOre instance;
	
	@SidedProxy(clientSide = "net.insane96mcp.nethergoldore.proxies.ClientProxy", serverSide = "net.insane96mcp.nethergoldore.proxies.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		proxy.PreInit(event);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.Init(event);
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event) {
		proxy.PostInit(event);
	}
}
