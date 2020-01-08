package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entities.Player;
import com.mygdx.game.levels.LevelHandler;
import com.mygdx.game.levels.Levels;

import world.GameMap;

public class GameScreen extends AbstractScreen {
	private Levels level;
	private Player player;
	private GameMap map;
	private OrthographicCamera camera;
	
	public void load(SpriteBatch batch, Object ... params) {
		super.load(batch);
		level = LevelHandler.getLevel((int) params[0]);
	}

	@Override
	public void show() {
		player = new Player(level.getPlayerPosition().x, level.getPlayerPosition().y, level.getN(), batch);
		
		map = level.getMap();
		
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
		//player.dispose();
		//map.dispose();
	}
	
}
