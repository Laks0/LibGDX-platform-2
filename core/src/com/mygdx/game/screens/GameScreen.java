package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entities.Player;

import world.GameMap;
import world.TiledGameMap;

public class GameScreen extends AbstractScreen {
	private int level;
	
	private Player player;
	private GameMap map;
	private OrthographicCamera camera;
	
	public void load(SpriteBatch batch, Object ... params) {
		super.load(batch);
		level = (int) params[0];
	}

	@Override
	public void show() {
		System.out.println("Showing game at level " + level);
		player = new Player(100, 500, level, batch);
		
		map = new TiledGameMap("map.tmx");
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
	}

	@Override
	public void render(float delta) {
		player.update(delta, map);
		
		map.render(camera);
		
		batch.begin();
		player.render();
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		player.dispose();
		System.out.println("Game disposed");
	}
	
}
