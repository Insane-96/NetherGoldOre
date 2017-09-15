package net.insane96mcp.nethergoldore.init;

import java.util.Random;

import net.insane96mcp.nethergoldore.lib.Stats;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class NetherGenOres implements IWorldGenerator {

	private final WorldGenMinable worldGenMinableNether;
	
	private int blockCount = Stats.OreGeneration.blockCount;
	private int perChunk = Stats.OreGeneration.perChunk;
	private int minY = Stats.OreGeneration.minY;
	private int maxY = Stats.OreGeneration.maxY;
	
	public NetherGenOres() {
		worldGenMinableNether = new WorldGenMinable(ModBlocks.netherGoldOre.getDefaultState(), blockCount, BlockMatcher.forBlock(Blocks.NETHERRACK));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		BlockPos chunkPos = new BlockPos(chunkX * 16, 0, chunkZ * 16);

		if (world.provider.getDimension() == -1) {
			for (int i = 0; i < perChunk; i++) {
				worldGenMinableNether.generate(world, random, chunkPos.add(random.nextInt(16), random.nextInt(maxY - minY) + minY, random.nextInt(16)));
			}
		}
	}

	
}
