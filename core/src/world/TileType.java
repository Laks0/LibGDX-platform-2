package world;

import java.util.HashMap;

public enum TileType {
	GRASS(1, true, "Grass"),
	LAVA(2, true, "Lava"),
	SKY(3, false, "Sky"),
	CLOUD(4, false, "Cloud");
	
	public static final int TILE_SIZE = 16;
	
	private int id;
	private boolean collidable;
	private String name;
	
	TileType (int id, boolean collidable, String name) {
		this.id = id;
		this.collidable = collidable;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public boolean isCollidable() {
		return collidable;
	}

	public String getName() {
		return name;
	}
	
	private static HashMap<Integer, TileType> hash;
	
	static {
		hash = new HashMap<Integer, TileType>();
		for (TileType tileType : TileType.values()) {
			hash.put(tileType.getId(), tileType);
		}
	}
	
	public static TileType getTileById(int id) {
		return hash.get(id);
	}
}
