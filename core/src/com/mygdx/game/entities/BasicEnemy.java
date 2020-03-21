package com.mygdx.game.entities;

import com.badlogic.gdx.math.Vector2;

import world.GameMap;

public class BasicEnemy extends Enemy {
	private int direction;
	
	public BasicEnemy(Vector2 pos) {
		super(pos, 500f, 200f, "basicEnemy.png");
		
		direction = 1;
	}
	
	public void update(Player player, float dt, GameMap map) {
		super.update(player, dt, map);
		
		moveX(direction, dt);
		
		if (isCollidingX(new Vector2(pos.x + vel.x * dt, pos.y), direction, map)) {
			direction *= -1;
		}
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
}
