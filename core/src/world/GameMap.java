package world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public abstract class GameMap {
	
	public abstract void render(OrthographicCamera camera);
	public abstract void update(float dt);
	public abstract void dispose();

	public TileType getTileByPosition(int layer, float x, float y) {
		Vector2 gridPos = getGridPosition(x, y);
		return getTileByCoordinate(layer, (int) gridPos.x, (int) gridPos.y);
	}
	
	public Vector2 getGridPosition(float x, float y) {
		return new Vector2((float) Math.floor(x/TileType.TILE_SIZE), (float) Math.floor(y/TileType.TILE_SIZE));
	}
	
	public abstract TileType getTileByCoordinate(int layer, int x, int y);
	
	public abstract int getWidth();
	public abstract int getHeight();
	public abstract int getLayers();
}
