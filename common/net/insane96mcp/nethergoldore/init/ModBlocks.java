package net.insane96mcp.nethergoldore.init;

import java.util.ArrayList;

import net.insane96mcp.nethergoldore.NetherGoldOre;
import net.insane96mcp.nethergoldore.block.BlockNetherGoldOre;
import net.insane96mcp.nethergoldore.lib.Strings.Names;
import net.insane96mcp.nethergoldore.worldgen.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static BlockNetherGoldOre netherGoldOre;
	
	public static ArrayList<Block> BLOCKS = new ArrayList<Block>();
	
	public static void Init() {
		ResourceLocation location = new ResourceLocation(NetherGoldOre.MOD_ID, Names.NETHER_GOLD_ORE);
		netherGoldOre = new BlockNetherGoldOre();
		netherGoldOre.setRegistryName(location);
		netherGoldOre.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		netherGoldOre.setHardness(3.0f);
		netherGoldOre.setResistance(5f);
		netherGoldOre.setHarvestLevel("pickaxe", 2);
		BLOCKS.add(netherGoldOre);
		
		GameRegistry.registerWorldGenerator(new OreGeneration(), 100);
	}
	
	public static void PostInit() {

		GameRegistry.addSmelting(new ItemStack(netherGoldOre, 1), new ItemStack(Items.GOLD_NUGGET), 1.0f);
	}
}
