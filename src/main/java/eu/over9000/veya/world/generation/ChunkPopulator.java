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
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import eu.over9000.veya.util.Location;
import eu.over9000.veya.world.BlockType;
import eu.over9000.veya.world.World;
import eu.over9000.veya.world.generation.populators.*;
import eu.over9000.veya.world.storage.ChunkRequestLevel;

/**
 * Created by Jan on 22.06.2015.
 */
public class ChunkPopulator {

	private static final List<IPopulator> populators = new ArrayList<>();

	static {
		populators.add(new OrePopulator());
		populators.add(new SandPopulator());
		populators.add(new GravelPopulator());
		populators.add(new TreePopulator());
	}

	public static void populateChunkStack(final World world, final Random random, final int chunkX, final int chunkZ) {
		for (final IPopulator populator : populators) {
			populator.populateChunkStack(world, random, chunkX, chunkZ);
		}
	}

	public static void setBlockWithChance(final World world, final int x, final int y, final int z, final BlockType block, final Random random, final float chance) {
		if (random.nextFloat() < chance) {
			world.setBlockAtIfAir(x, y, z, block, ChunkRequestLevel.GENERATOR, true);
		}
	}

	public static void fillLine(final World world, final int fromX, final int fromY, final int fromZ, final int toX, final int toY, final int toZ, final BlockType block) {
		final int side_a = toX - fromX;
		final int side_b = toY - fromY;
		final int side_c = toZ - fromZ;

		final double length = Math.sqrt((side_a * side_a) + (side_b * side_b) + (side_c * side_c));
		final double mod = 1 / length;
		double i = 0;

		int pos_x;
		int pos_y;
		int pos_z;

		while (i <= 1) {
			pos_x = (int) Math.floor(fromX + i * (toX - fromX));
			pos_y = (int) Math.floor(fromY + i * (toY - fromY));
			pos_z = (int) Math.floor(fromZ + i * (toZ - fromZ));


			world.setBlockAt(pos_x, pos_y, pos_z, block, ChunkRequestLevel.GENERATOR, true);

			i = i + (mod);
		}
	}

	public static void placeRndSphere(final World world, final Random random, final int centerX, final int centerY, final int centerZ, final int radius, final BlockType block, final Predicate<BlockType> condition) {
		final float rndOffset = random.nextFloat() * 0.25f;

		final Location crownCenter = new Location(0, 0, 0);
		final List<Location> locations = new ArrayList<>();
		for (int x = -radius; x <= radius; x++) {
			for (int y = -radius; y <= radius; y++) {
				for (int z = -radius; z <= radius; z++) {
					if (x * x + y * y + z * z < radius * radius) {
						locations.add(new Location(x, y, z, crownCenter));
					}
				}
			}
		}
		Collections.sort(locations);

		for (int i = 0; i < locations.size(); i++) {
			final Location location = locations.get(i);

			final float percent = (float) i / (float) locations.size();

			final BlockType current = world.getBlockAt(centerX + location.x, centerY + location.y, centerZ + location.z);
			if (condition.test(current)) {
				if (percent < 0.5f + rndOffset) {
					world.setBlockAt(centerX + location.x, centerY + location.y, centerZ + location.z, block, ChunkRequestLevel.GENERATOR, true);
				} else if (random.nextBoolean()) {
					world.setBlockAt(centerX + location.x, centerY + location.y, centerZ + location.z, block, ChunkRequestLevel.GENERATOR, true);
				}
			}
		}
	}
}
