package com.mygdx.game.screens;

public enum ScreenType {
	GAME(new GameScreen());
	
	private AbstractScreen screen;

	private ScreenType(AbstractScreen screen) {
		this.screen = screen;
	}

	public AbstractScreen getScreen() {
		return screen;
	}
}
