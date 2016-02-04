package com.mygdx.doubles.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
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
	private int lastX;
	private int lastY;

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

	private Vector2 lastTouch = new Vector2();

	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		lastTouch.set(screenX, screenY);
		return true;
	}

	public boolean touchDragged(int screenX, int screenY, int pointer) {
		Vector2 newTouch = new Vector2(screenX, screenY);
		// delta will now hold the difference between the last and the current touch positions
		// delta.x > 0 means the touch moved to the right, delta.x < 0 means a move to the left


		Vector2 delta = newTouch.cpy().sub(lastTouch);
		lastTouch = newTouch;

		if (delta.x > 0){
			System.out.println("sucess right");
			board.down();
		}

		if (delta.x < 0){
			System.out.println("sucess left");
			board.up();
		}

		if (delta.y < 0){
			System.out.println("sucess down");
			board.left();
		}

		if (delta.y > 0){
			System.out.println("sucess up");
			board.right();
		}

		return false;
	}

	public boolean touchUp (int x, int y, int pointer, int button) {
		return false;
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
