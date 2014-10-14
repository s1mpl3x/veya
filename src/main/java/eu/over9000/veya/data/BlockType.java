package eu.over9000.veya.data;

public enum BlockType {
	
	STONE(3), DIRT(0), GRASS(0, 1, 2), TEST(5, 4, 6, 7, 8, 9), WOOD(10, 10, 11), WATER(12), LEAVES(13), SAND(14), IRON_ORE(15);
	
	private final int textureIDBottom;
	private final int textureIDTop;
	private final int textureIDNorth;
	private final int textureIDEast;
	private final int textureIDSouth;
	private final int textureIDWest;
	
	private BlockType(final int textureIDAll) {
		this.textureIDBottom = textureIDAll;
		this.textureIDTop = textureIDAll;
		this.textureIDNorth = textureIDAll;
		this.textureIDEast = textureIDAll;
		this.textureIDSouth = textureIDAll;
		this.textureIDWest = textureIDAll;
	}
	
	private BlockType(final int textureIDBottom, final int textureIDTop, final int textureIDAll) {
		this.textureIDBottom = textureIDBottom;
		this.textureIDTop = textureIDTop;
		this.textureIDNorth = textureIDAll;
		this.textureIDEast = textureIDAll;
		this.textureIDSouth = textureIDAll;
		this.textureIDWest = textureIDAll;
	}
	
	private BlockType(final int textureIDBottom, final int textureIDTop, final int textureIDNorth, final int textureIDEast, final int textureIDSouth, final int textureIDWest) {
		this.textureIDBottom = textureIDBottom;
		this.textureIDTop = textureIDTop;
		this.textureIDNorth = textureIDNorth;
		this.textureIDEast = textureIDEast;
		this.textureIDSouth = textureIDSouth;
		this.textureIDWest = textureIDWest;
	}
	
	public static int[] getTextureLookupArray() {
		final int[] table = new int[6 * BlockType.values().length];
		
		for (int i = 0; i < BlockType.values().length; i++) {
			final BlockType type = BlockType.values()[i];
			table[i * 6 + 0] = type.textureIDBottom;
			table[i * 6 + 1] = type.textureIDTop;
			table[i * 6 + 2] = type.textureIDNorth;
			table[i * 6 + 3] = type.textureIDEast;
			table[i * 6 + 4] = type.textureIDSouth;
			table[i * 6 + 5] = type.textureIDWest;
		}
		return table;
	}
	
}