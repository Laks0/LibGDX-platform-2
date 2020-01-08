package com.mygdx.game.levels;

public class LevelHandler {
	private static Levels[] levels = new Levels[3];
	
	static {
		levels[0] = Levels.ONE;
		levels[1] = Levels.TWO;
	}
	
	public static Levels getLevel(int i) {
		return levels[i];
	}
}
