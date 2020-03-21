package com.mygdx.game.entities;

import com.badlogic.gdx.math.Vector2;

import world.GameMap;

public class BasicEnemy extends Enemy {
	private int direction;
	
	public BasicEnemy(Vector2 pos) {
		super(pos, 500f, 100f, "basicEnemy.png");
		
		direction = 1;
	}
	
	public void update(Player player, float dt, GameMap map) {
		super.update(player, dt, map);
		
		moveX(direction, dt);
		
		if (isCollidingX(pos.add(vel.x * dt, 0), direction, map)) {
			direction *= -1;
		}
		
		if (collidesWith(player)) {
			if (player.isGrounded()) {
				player.die();
			} else {
				player.jump(2f);
				setDead(true);
			}
		}
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
}
