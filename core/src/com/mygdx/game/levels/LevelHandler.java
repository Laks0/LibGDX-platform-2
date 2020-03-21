package com.mygdx.game.levels;

public class LevelHandler {
	private static Levels[] levels = new Levels[4];
	
	static {
		levels[0] = Levels.ONE;
		levels[1] = Levels.TWO;
		levels[2] = Levels.THREE;
		levels[3] = Levels.FOUR;
	}
	
	public static Levels getLevel(int i) {
		return levels[i];
	}
	
	public static int getLenght() {
		return levels.length;
	}
}
