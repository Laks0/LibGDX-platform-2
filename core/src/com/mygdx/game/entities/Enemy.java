package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import world.GameMap;

public abstract class Enemy extends Entity {
	protected Texture sprite;
	
	public Enemy(Vector2 pos, float acceleration, float maxVel, String s) {
		super(pos, 32, 32, acceleration, maxVel);
		sprite = new Texture(s);
	}
	
	public void update(Player player, float dt, GameMap map) {
		super.update(dt, map);
		
		if (collidesWith(player)) {
			player.die();
		}
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(sprite, pos.x, pos.y);
	}
	
	public void render() {}

	public Texture getSprite() {
		return sprite;
	}
}
