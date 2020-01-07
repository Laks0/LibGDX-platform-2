package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import world.GameMap;

public class Player extends Entity {
	
	private Texture sprite;

	public Player(float x, float y) {
		super(new Vector2(x, y), 14, 30, 650, 300);
		
		sprite = new Texture("player.png");
	}

	public void update(float dt, GameMap map) {
		// Jump
		if (grounded && Gdx.input.isKeyPressed(Keys.SPACE)) {
			jump();
		} else if (!grounded && vel.y > 0 && Gdx.input.isKeyPressed(Keys.SPACE)) {
			jump(1.9f*dt);
		}
		
		if (Gdx.input.isKeyPressed(Keys.A)) {
			moveX(-1, dt);
		}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			moveX(1, dt);
		}
		
		super.update(dt, map);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(sprite, pos.x, pos.y);
	}
	
	public void dispose() {
		sprite.dispose();
	}

}
