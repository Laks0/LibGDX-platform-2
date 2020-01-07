package com.mygdx.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractScreen implements Screen {
	protected SpriteBatch batch;
	
	public void load(SpriteBatch batch, Object ... params) {
		this.batch = batch;
	};
}
