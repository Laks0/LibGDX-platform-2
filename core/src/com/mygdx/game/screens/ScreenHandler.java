package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScreenHandler {
	private static Game game;
	private static AbstractScreen current;
	
	public static void setGame(Game g) {
		game = g;
	}
	
	public static void setScreen(ScreenType type, SpriteBatch batch,Object ... params) {
		AbstractScreen screen = type.getScreen();
		screen.load(batch, params);
		game.setScreen(screen);
		if (current != null) {
			current.dispose();
		}
		current = screen;
	}
}
