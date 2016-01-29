package com.mygdx.doubles.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.mygdx.doubles.game.Board;

public class GameStats {

	public static final String TAG = GameStats.class.getName();

	public static final GameStats instance = new GameStats();
	private static Preferences prefs;


	public int gameCount;
	public int highscore;

	private GameStats() {
		prefs = Gdx.app.getPreferences(Constants.STATS);

	}
	
	/*
	 * load prefs
	 */
	public void load() {

		gameCount = prefs.getInteger("gameCount", 0);
		highscore = getHighScore();
		//prefs.clear();
	}

	/*
	 * save prefs
	 */
	public void save() {

		prefs.putInteger("gameCount", gameCount);
		prefs.flush();

	}

	/*
	 * if you win
	 */
	public void win() {

		gameCount = gameCount + 1;
		System.out.println("highscore is " + highscore );
		save();
	}

	/*
	 * if you lose
	 */
	public void lose() {

		gameCount = gameCount + 1;
		System.out.println("highscore is " + highscore );
		save();
	}
	
	/*
	 * set score
	 */
	public static void setHighScore(int val) {
        prefs.putInteger("highscore", val);
        prefs.flush();
    }

	/*
	 * retrieve score
	 */
    public static int getHighScore() {
        return prefs.getInteger("highscore");
    }

}
