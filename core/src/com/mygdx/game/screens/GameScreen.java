package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entities.Enemy;
import com.mygdx.game.entities.Player;
import com.mygdx.game.levels.LevelHandler;
import com.mygdx.game.levels.Levels;

import world.GameMap;

public class GameScreen extends AbstractScreen {
	private Levels level;
	private Player player;
	private GameMap map;
	private OrthographicCamera camera;
	private boolean toMenu = false;
	
	private Enemy[] enemies;
	
	public void load(SpriteBatch batch, Object ... params) {
		super.load(batch);
		int l = (int) params[0];
		if (l >= LevelHandler.getLenght()) {
			System.out.println("Go to menu");
			toMenu = true;
		} else {
			level = LevelHandler.getLevel(l);
		}
	}

	@Override
	public void show() {
		player = new Player(level.getPlayerPosition().x, level.getPlayerPosition().y, level.getN(), batch);
		
		map = level.getMap();
		
		if (level.hasEnemies()) {
			enemies = level.getEnemies();
		}
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
	}

	@Override
	public void render(float delta) {
		if (toMenu) {
			toMenu = false;
			ScreenHandler.setScreen(ScreenType.MAIN_MENU, batch);
			return;
		}
		player.update(delta, map);
		
		for (Enemy e : enemies) {
			if (!e.isDead())
				e.update(player, delta, map);
		}
		
		map.render(camera);
		
		batch.begin();
		player.render();
		
		for (Enemy e : enemies) {
			if (!e.isDead())
				e.render(batch);
		}
		
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
