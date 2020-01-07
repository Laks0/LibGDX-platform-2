package world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class TiledGameMap extends GameMap {
	
	TiledMap tiledMap;
	OrthogonalTiledMapRenderer mapRenderer;
	
	public TiledGameMap(String map) {
		tiledMap = new TmxMapLoader().load(map);
		mapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
	}

	@Override
	public void render(OrthographicCamera camera) {
		mapRenderer.setView(camera);
		mapRenderer.render();
	}

	@Override
	public void update(float dt) {
		

	}

	@Override
	public void dispose() {
		tiledMap.dispose();
	}

	@Override
	public TileType getTileByCoordinate(int layer, int x, int y) {
		Cell cell = ((TiledMapTileLayer) tiledMap.getLayers().get(layer)).getCell(x, y);

		if (cell == null) return null;
		
		TiledMapTile tile = cell.getTile();
		
		if (tile == null) return null;

		TileType tType = TileType.getTileById(tile.getId());
		return tType;
	}

	@Override
	public int getWidth() {
		
		return 0;
	}

	@Override
	public int getHeight() {
		
		return 0;
	}

	@Override
	public int getLayers() {
		
		return 0;
	}

}
