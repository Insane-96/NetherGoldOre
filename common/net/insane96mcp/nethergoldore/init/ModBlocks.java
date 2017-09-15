package net.insane96mcp.nethergoldore.init;

import net.insane96mcp.nethergoldore.NetherGoldOre;
import net.insane96mcp.nethergoldore.block.BlockNetherGoldOre;
import net.insane96mcp.nethergoldore.lib.Names;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
	
	public static BlockNetherGoldOre netherGoldOre;
	public static void Init() {
		ResourceLocation location = new ResourceLocation(NetherGoldOre.MOD_ID, Names.NETHER_GOLD_ORE);
		netherGoldOre = new BlockNetherGoldOre();
		netherGoldOre.setRegistryName(location);
		netherGoldOre.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		netherGoldOre.setHardness(3.0f);
		netherGoldOre.setResistance(5f);
		netherGoldOre.setHarvestLevel("pickaxe", 2);
		GameRegistry.register(netherGoldOre);
		GameRegistry.register(new ItemBlock(netherGoldOre), location);
		
		GameRegistry.registerWorldGenerator(new NetherGenOres(), 0);
	}
	
	public static void PostInit() {

		GameRegistry.addSmelting(new ItemStack(netherGoldOre, 1), new ItemStack(Items.GOLD_NUGGET), 1.0f);
	}
	
	@SideOnly(Side.CLIENT)
	public static void InitClient(ItemModelMesher mesher) {
		Item item = Item.getItemFromBlock(netherGoldOre);
		ModelResourceLocation model = new ModelResourceLocation(NetherGoldOre.RESOURCE_PREFIX + Names.NETHER_GOLD_ORE);
		ModelLoader.registerItemVariants(item, model);
		mesher.register(item, 0, model);
	}
}
