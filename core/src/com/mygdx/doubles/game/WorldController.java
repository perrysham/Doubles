package com.mygdx.doubles.game;

import com.mygdx.doubles.game.Board;
//import com.mygdx.doubles.game.HumanPlayer;
import com.mygdx.doubles.game.WorldController;
import com.mygdx.doubles.game.util.GameStats;
import com.mygdx.doubles.screens.GameScreen;
import com.mygdx.doubles.screens.MenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;

public class WorldController extends InputAdapter {

	private static final String TAG = WorldController.class.getName();
	public float viewportWidth;
	public int width, height;
	float timeLeftGameOverDelay;
	boolean needTile;
	private Game game;

	public Board board;

	public WorldController(Game game) {
		this.game = game;
		init();
	}

	private void init() {
		Gdx.input.setInputProcessor(this);
		board = new Board();
		board.start();

		timeLeftGameOverDelay = 2;
	}

	public void update(float deltaTime) {
		if (board.gameState == Board.GameState.PLAYING) {

			if (!board.canMove()) {
				board.lose = true;
			}

			if (board.score > GameStats.instance.getHighScore()) {
				GameStats.setHighScore(board.score);
			}
		}
	}

	private void backToMenu() {
		// switch to menu screen
		// game.setScreen(new MenuScreen(game));
		game.setScreen(new GameScreen(game));
	}

	@Override
	public boolean keyUp(int keycode) {

		if (keycode == Keys.ESCAPE || keycode == Keys.BACK) {
			GameStats.instance.lose();
			backToMenu();
		}
		if (keycode == Keys.LEFT) {

			board.up();
		}
		if (keycode == Keys.RIGHT) {

			board.down();
		}
		if (keycode == Keys.UP) {

			board.right();
		}
		if (keycode == Keys.DOWN) {

			board.left();
		}
		return false;
	}
}
