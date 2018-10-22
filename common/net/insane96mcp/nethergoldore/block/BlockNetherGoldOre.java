package net.insane96mcp.nethergoldore.block;

import java.util.List;
import java.util.Random;

import net.insane96mcp.nethergoldore.NetherGoldOre;
import net.insane96mcp.nethergoldore.lib.Names;
import net.insane96mcp.nethergoldore.lib.Properties;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockNetherGoldOre extends BlockOre{
	public BlockNetherGoldOre() {
		
	}
	
	@Override
	public String getTranslationKey() {
		return "tile." + NetherGoldOre.RESOURCE_PREFIX + Names.NETHER_GOLD_ORE;
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		this.PigmanAggro(worldIn, pos, state, player);
	}
	
	private void PigmanAggro(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		float radius = Properties.serverConfig.oreProperties.pigmanAggroRadius;
		
		BlockPos corner1 = new BlockPos(pos.getX() - radius, pos.getY() - radius, pos.getZ() - radius);
		BlockPos corner2 = new BlockPos(pos.getX() + radius, pos.getY() + radius, pos.getZ() + radius);
		AxisAlignedBB AABBradius = new AxisAlignedBB(corner1, corner2);
		List<EntityPigZombie> pigmen = worldIn.getEntitiesWithinAABB(EntityPigZombie.class, AABBradius);
		
		for (EntityPigZombie pigman : pigmen) {
			if (worldIn.rand.nextFloat() < Properties.serverConfig.oreProperties.pigmanAggroChance / 100f)
				pigman.setRevengeTarget(player);
		}
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.GOLD_NUGGET;
	}
	
	@Override
	public int quantityDropped(Random random) {
		return MathHelper.getInt(random, Properties.serverConfig.drops.minNuggetsPerOre, Properties.serverConfig.drops.maxNuggetsPerOre);
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0)
        {
            int minNuggets = Properties.serverConfig.drops.minNuggetsPerOre;
            int maxNuggets = Properties.serverConfig.drops.maxNuggetsPerOre + fortune;
            
            return MathHelper.getInt(random, minNuggets, maxNuggets);
        }
        else
        {
            return this.quantityDropped(random);
        }
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		return MathHelper.getInt(rand, Properties.serverConfig.drops.minExperienceDrop, Properties.serverConfig.drops.maxExperienceDrop);
	}
}
