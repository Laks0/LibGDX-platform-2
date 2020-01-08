package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.ScreenHandler;
import com.mygdx.game.screens.ScreenType;

public class Test extends Game implements ApplicationListener {
	SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		ScreenHandler.setGame(this);
		ScreenHandler.setScreen(ScreenType.GAME, batch, 0);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
	}
}
