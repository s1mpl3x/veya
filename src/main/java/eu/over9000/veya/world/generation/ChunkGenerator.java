/*
 * Veya
 * Copyright (C) 2015 s1mpl3x
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package eu.over9000.veya.world.generation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import eu.over9000.veya.world.BlockType;
import eu.over9000.veya.world.Chunk;
import eu.over9000.veya.world.World;
import eu.over9000.veya.world.generation.noise.SimplexNoise;
import eu.over9000.veya.world.storage.ChunkStack;

public class ChunkGenerator {

	public static final int SEALEVEL = 64;

	public static ChunkStack genChunksAt(final World world, final Random random, final int chunkX, final int chunkZ) {

		final BlockType[][][] rawChunkStack = new BlockType[Chunk.CHUNK_SIZE][Chunk.CHUNK_SIZE][World.MAX_WORLD_HEIGHT];

		//System.out.println("GENERATOR CALLED FOR " + chunkX + "," + chunkZ);

		for (int x = 0; x < Chunk.CHUNK_SIZE; x++) {
			for (int z = 0; z < Chunk.CHUNK_SIZE; z++) {
				final List<Integer> topBlocks = new ArrayList<>();
				boolean createPre = false;

				final int bedrock_height = 1 + random.nextInt(3);
				for (int y = 0; y < bedrock_height; y++) {
					rawChunkStack[x][z][y] = BlockType.BEDROCK;
				}

				for (int y = bedrock_height; y < World.MAX_WORLD_HEIGHT; y++) {

					if (genElevation(x + chunkX * Chunk.CHUNK_SIZE, y, z + chunkZ * Chunk.CHUNK_SIZE)) {
						rawChunkStack[x][z][y] = BlockType.STONE;
						createPre = true;
					} else {
						if (y <= ChunkGenerator.SEALEVEL) {
							rawChunkStack[x][z][y] = BlockType.WATER;
						}
						if (createPre) {

							topBlocks.add(y - 1);

						}
						createPre = false;
					}
				}

				for (final Integer top : topBlocks) {
					fillTopWithDirtAndGrass(random, rawChunkStack, x, z, top);
				}

			}
		}

		return buildChunks(world, chunkX, chunkZ, rawChunkStack);
	}

	private static ChunkStack buildChunks(final World world, final int chunkX, final int chunkZ, final BlockType[][][] rawChunkStack) {
		final ChunkStack chunks = new ChunkStack(world, chunkX, chunkZ);

		for (int chunkY = 0; chunkY < World.MAX_WORLD_HEIGHT_IN_CHUNKS; chunkY++) {
			final BlockType[] chunk_data = new BlockType[Chunk.DATA_LENGTH];
			boolean empty = true;
			for (int x = 0; x < Chunk.CHUNK_SIZE; x++) {
				for (int z = 0; z < Chunk.CHUNK_SIZE; z++) {
					final int baseY = chunkY * Chunk.CHUNK_SIZE;
					for (int y = 0; y < Chunk.CHUNK_SIZE; y++) {
						final BlockType type = rawChunkStack[x][z][baseY + y];
						if (type != null) {
							empty = false;
							chunk_data[Chunk.toIndex(x, y, z)] = type;
						}
					}
				}
			}
			final Chunk chunk = new Chunk(world, chunkX, chunkY, chunkZ, chunk_data);
			if (!empty) {
				chunks.setChunkAt(chunkY, chunk);
			}

		}
		return chunks;
	}

	private static void fillTopWithDirtAndGrass(final Random random, final BlockType[][][] rawChunkStack, final int x, final int z, final int top) {
		if (top >= ChunkGenerator.SEALEVEL) {
			rawChunkStack[x][z][top] = BlockType.GRASS;
		} else {
			rawChunkStack[x][z][top] = BlockType.DIRT;
		}

		final int dirtHeight = 3 + random.nextInt(3);
		final int dirtLimit = top - dirtHeight;
		for (int y = top; y > dirtLimit; y--) {
			if (rawChunkStack[x][z][y] != null) {
				if (rawChunkStack[x][z][y] == BlockType.STONE) {
					rawChunkStack[x][z][y] = BlockType.DIRT;
				}
			}
		}
	}

	private static boolean genElevation(final int x, final int y, final int z) {
		if (y < 50) {
			return true;
		}

		final float max_world_dim_size = 250F;

		final float base = fbm((float) x / max_world_dim_size, (float) y / 255F, (float) z / max_world_dim_size, 6, 2, 0.5F);

		float factor = 100 * 0.25F;

		final float density;
		factor += 0.75 * 75F;
		density = Math.abs(base * factor);
		return density - y + 55F > 0F;

	}

	private static float fbm(final float x, final float y, final float z, final int octaves, final float lacunarity, final float gain) {
		// for each pixel, get the value
		float total = 0.0F;
		float frequency = 1.0F;
		float amplitude = gain;

		for (int i = 0; i < octaves; i++) {
			total += SimplexNoise.noise(x * frequency, y * frequency, z * frequency) * amplitude;
			frequency *= lacunarity;
			amplitude *= gain;
		}
		return total;
	}
}
