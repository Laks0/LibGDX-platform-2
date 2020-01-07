package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import world.GameMap;
import world.TileType;

public abstract class Entity {
	
	protected Vector2 pos;
	protected Vector2 vel;
	protected float acceleration;
	protected float maxSpeed;
	protected float maxJumpSpeed;
	protected int width;
	protected int height;
	protected float gravity;
	protected boolean grounded;
	protected float dir = 0;
	
	public Entity(Vector2 pos, int width, int height, float acceleration, float maxSpeed) {
		this.pos = pos;
		this.vel = new Vector2(0, 0);
		this.acceleration = acceleration;
		this.maxSpeed = maxSpeed;
		this.width = width;
		this.height = height;
		this.gravity = 650; 
		this.grounded = false;
		this.maxJumpSpeed = 200;
	}
	
	public void update(float dt, GameMap map) {
		// Apply gravity
		if (!grounded) {
			vel.y -= gravity * dt;
		} 
		
		applyVelocity(dt, map);
		
		dir = 0;
	}
	
	public void moveX(float dir, float dt) {
		vel.x += dir * acceleration * dt;
		if (dir != 0) this.dir = dir;
	}
	
	protected void applyVelocity(float dt, GameMap map) {
		vel.x = MathUtils.clamp(vel.x, -maxSpeed, maxSpeed);
		vel.y = MathUtils.clamp(vel.y, -maxSpeed, maxJumpSpeed);
		
		// Slow down
		if (dir == 0) {
			vel.x = MathUtils.lerp(vel.x, 0, .1f);
		}
		
		int yDir = (int) Math.signum(vel.y);
		
		// Horizontal collisions
		float xDir = Math.signum(vel.x);
		if (xDir != 0) {
			if (isCollidingX(new Vector2(pos.x + vel.x * dt, pos.y), (int) xDir, map)) {
				float newX = pos.x + vel.x * dt;
				while(isCollidingX(new Vector2(newX, pos.y), (int) xDir, map)) {
					newX -= xDir;
				}
				pos.x = newX;
				vel.x = 0;
			}
		}
		
		// Vertical collisions
		if (grounded && !isCollidingY(new Vector2(pos.x, pos.y - 1), -1, map)) {
			grounded = false;
		}
		
		if (isCollidingY(new Vector2(pos.x, pos.y + vel.y * dt), (int) yDir, map)) {
			grounded = yDir == -1;
			float newY = pos.y + vel.y * dt;
			while (isCollidingY(new Vector2(pos.x, newY), yDir, map)) {
				newY -= yDir;
			}
			pos.y = newY;
			vel.y = 0;
		}
		
		pos.x += vel.x * dt;
		pos.y += vel.y * dt;
	}
	
	protected boolean isCollidingY(Vector2 newPos, int dir, GameMap map) {
		boolean col = false;
		
		float checkY = newPos.y;
		if (dir == 1) {
			checkY = newPos.y + height;
		}
		
		Vector2 gridPos1 = map.getGridPosition(newPos.x, checkY);
		Vector2 gridPos2 = map.getGridPosition(newPos.x + width , checkY);
		
		// Check the corners' positions in grid
		int f = (int) Math.min(gridPos1.x, gridPos2.x);
		int t = (int) Math.max(gridPos1.x, gridPos2.x);
		
		// Go from corner to corner looking for collisions
		for (int i = f; i <= t; i++) {
			TileType tile = map.getTileByCoordinate(1, i, (int) gridPos1.y);
			if (tile != null) {
				col = col || tile.isCollidable();
			}
		}
		
		return col;
	}
	
	protected boolean isCollidingX(Vector2 newPos, int dir, GameMap map) {
		boolean col = false;
		
		float checkX = newPos.x;
		if (dir == 1) {
			checkX += width;
		}
		
		Vector2 gridPos1 = map.getGridPosition(checkX, newPos.y);
		Vector2 gridPos2 = map.getGridPosition(checkX, newPos.y + height);
		
		int f = (int) Math.min(gridPos1.y, gridPos2.y);
		int t = (int) Math.max(gridPos1.y, gridPos2.y);
		
		for (int i = f; i <= t; i++) {
			TileType tile = map.getTileByCoordinate(1, (int) gridPos1.x, i);
			if (tile != null) {
				col = col || tile.isCollidable();
			}
		}
		
		return col;
	}
	
	public void jump(float amount) {
		vel.y += maxJumpSpeed * amount;
		grounded = false;
	}
	
	public void jump() {
		vel.y += maxJumpSpeed;
		grounded = false;
	}
	
	public abstract void render();
	
	/* GETTERS AND SETTERS */
		
	public Vector2 getPos() {
		return pos;
	}

	public void setPos(Vector2 pos) {
		this.pos = pos;
	}

	public float getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(float acceleration) {
		this.acceleration = acceleration;
	}

	public float getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Vector2 getVel() {
		return vel;
	}

	public float getGravity() {
		return gravity;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public boolean isGrounded() {
		return grounded;
	}
}
