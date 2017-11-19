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
	public String getUnlocalizedName() {
		return "tile." + NetherGoldOre.RESOURCE_PREFIX + Names.NETHER_GOLD_ORE;
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		PigmanAggro(worldIn, pos, state, player);
		IgnitePlayer(worldIn, pos, state, player);
	}
	
	private void PigmanAggro(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		BlockPos corner1 = new BlockPos(pos.getX() - Properties.OreProperties.pigmanAggroRadius, pos.getY() - Properties.OreProperties.pigmanAggroRadius, pos.getZ() - Properties.OreProperties.pigmanAggroRadius);
		BlockPos corner2 = new BlockPos(pos.getX() + Properties.OreProperties.pigmanAggroRadius, pos.getY() + Properties.OreProperties.pigmanAggroRadius, pos.getZ() + Properties.OreProperties.pigmanAggroRadius);
		AxisAlignedBB AABBradius = new AxisAlignedBB(corner1, corner2);
		List<EntityPigZombie> pigmen = worldIn.getEntitiesWithinAABB(EntityPigZombie.class, AABBradius);
		
		for (EntityPigZombie pigman : pigmen) {
			if (worldIn.rand.nextFloat() < Properties.OreProperties.pigmanAggroChance / 100f)
				pigman.setRevengeTarget(player);
		}
	}
	
	private void IgnitePlayer(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		if (worldIn.rand.nextFloat() < Properties.OreProperties.ignitePlayerChance / 100f)
			player.setFire(Properties.OreProperties.ignitePlayerSeconds);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.GOLD_NUGGET;
	}
	
	@Override
	public int quantityDropped(Random random) {
		return Properties.OreDrops.minNuggetsPerOre + random.nextInt(Properties.OreDrops.maxNuggetsPerOre + 1 - Properties.OreDrops.minNuggetsPerOre);
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0)
        {
            int minNuggets = Properties.OreDrops.minNuggetsPerOre;
            int maxNuggets = Properties.OreDrops.maxNuggetsPerOre + (int)(Properties.OreDrops.maxNuggetsPerOre * (fortune * Properties.OreDrops.fortune_multiplier));
            
            return minNuggets + random.nextInt(maxNuggets + 1 - minNuggets);
        }
        else
        {
            return this.quantityDropped(random);
        }
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		return MathHelper.getRandomIntegerInRange(rand, Properties.OreDrops.minExperienceDrop, Properties.OreDrops.maxExperienceDrop);
	}
}
