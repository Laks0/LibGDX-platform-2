package com.mygdx.game.levels;

import com.badlogic.gdx.math.Vector2;

import world.GameMap;
import world.TiledGameMap;

public enum Levels {
	ONE(0, new TiledGameMap("map.tmx"), new Vector2(32, 80)),
	TWO(1, new TiledGameMap("level2.tmx"), new Vector2(32, 80)),
	THREE(2, new TiledGameMap("level3.tmx"), new Vector2(32, 80));
	
	private GameMap map;
	private Vector2 playerPosition;
	private int n;
	
	private Levels(int n, GameMap map, Vector2 playerPosition) {
		this.map = map;
		this.playerPosition = playerPosition;
		this.n = n;
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
