package com.mygdx.game.levels;

import com.badlogic.gdx.math.Vector2;

import world.GameMap;
import world.TiledGameMap;

import com.mygdx.game.entities.*;

public enum Levels {
	ONE(0, new TiledGameMap("map.tmx"), new Vector2(32, 80)),
	TWO(1, new TiledGameMap("level2.tmx"), new Vector2(32, 80)),
	THREE(2, new TiledGameMap("level3.tmx"), new Vector2(32, 80)),
	FOUR(3, new TiledGameMap("level4.tmx"), new Vector2(32, 600), new Enemy[]{
			new BasicEnemy(new Vector2(200, 200)),
			new BasicEnemy(new Vector2(300,300))
	});
	
	private GameMap map;
	private Vector2 playerPosition;
	private int n;
	
	private Enemy[] enemies;
	
	private Levels(int n, GameMap map, Vector2 playerPosition, Object ... params) {
		this.map = map;
		this.playerPosition = playerPosition;
		this.n = n;
		
		if (params.length > 0) {
			this.enemies = (Enemy[]) params;
		}
	}
	
	public boolean hasEnemies() {
		return enemies.length > 0;
	}
	
	public Enemy[] getEnemies() {
		return enemies.clone();
	}
	
	public GameMap getMap() {
		return map;
	}

	public Vector2 getPlayerPosition() {
		return playerPosition;
	}

	public int getN() {
		return n;
	}
	
}
