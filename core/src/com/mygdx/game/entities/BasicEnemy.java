package com.mygdx.game.entities;

import com.badlogic.gdx.math.Vector2;

import world.GameMap;

public class BasicEnemy extends Enemy {
	public BasicEnemy(Vector2 pos) {
		super(pos, 300f, 200f, "basicEnemy.png");
	}
	
	public void update(float dt, GameMap map) {
		super.update(dt, map);
	}
}
