package net.insane96mcp.nethergoldore.block;

import java.util.List;
import java.util.Random;

import net.insane96mcp.nethergoldore.NetherGoldOre;
import net.insane96mcp.nethergoldore.lib.Names;
import net.insane96mcp.nethergoldore.lib.Stats;
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

	private int minNuggetsPerOre = Stats.minNuggetsPerOre;
	private int maxNuggetsPerOre = Stats.maxNuggetsPerOre;
	private float fortune_multiplier = Stats.fortune_multiplier;
	
	private int minExperienceDrop = Stats.minExperienceDrop;
	private int maxExperienceDrop = Stats.maxExperienceDrop;

	private int pigmanAggroRadius = Stats.pigmanAggroRadius;
	private int pigmanAggroChance = Stats.pigmanAggroChance;
	
	private int ignitePlayerChance = Stats.ignitePlayerChance;
	private int ignitePlayerSeconds = Stats.ignitePlayerSeconds;
	
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
		if (worldIn.rand.nextInt(100) >= pigmanAggroChance)
			return;
		
		BlockPos pos1 = new BlockPos(pos.getX() - pigmanAggroRadius, pos.getY() - pigmanAggroRadius, pos.getZ() - pigmanAggroRadius);
		BlockPos pos2 = new BlockPos(pos.getX() + pigmanAggroRadius, pos.getY() + pigmanAggroRadius, pos.getZ() + pigmanAggroRadius);
		AxisAlignedBB radius = new AxisAlignedBB(pos1, pos2);
		List<EntityPigZombie> pigmen = worldIn.getEntitiesWithinAABB(EntityPigZombie.class, radius);
		
		for (EntityPigZombie pigman : pigmen) {
			pigman.setRevengeTarget(player);
		}
	}
	
	private void IgnitePlayer(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		if (worldIn.rand.nextInt(100) >= ignitePlayerChance)
			return;
		
		player.setFire(ignitePlayerSeconds);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.GOLD_NUGGET;
	}
	
	@Override
	public int quantityDropped(Random random) {
		return minNuggetsPerOre + random.nextInt(maxNuggetsPerOre + 1 - minNuggetsPerOre);
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0)
        {
            int minNuggets = minNuggetsPerOre;
            int maxNuggets = maxNuggetsPerOre + (int)(maxNuggetsPerOre * (fortune * fortune_multiplier));
            
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
		return MathHelper.getInt(rand, minExperienceDrop, maxExperienceDrop);
	}
}
