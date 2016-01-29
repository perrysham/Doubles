package com.mygdx.doubles.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.doubles.game.util.Constants;
import com.mygdx.doubles.game.util.GameStats;

public class WorldRenderer implements Disposable {

	private static final String TAG = WorldRenderer.class.getName();

	public OrthographicCamera camera;
	public OrthographicCamera cameraGUI;

	private SpriteBatch batch;
	private WorldController worldController;

	public WorldRenderer(WorldController worldController) {

		this.worldController = worldController;
		init();
	}

	private void init() {

		batch = new SpriteBatch();
		camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH,
				Constants.VIEWPORT_HEIGHT);
		camera.position.set(0, 0, 0);
		camera.update();
		cameraGUI = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH,
				Constants.VIEWPORT_GUI_HEIGHT);
		cameraGUI.position.set(0, 0, 0);
		cameraGUI.setToOrtho(true); // flip y-axis
		cameraGUI.update();
	}

	public void resize(int width, int height) {

		camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / (float) height)
				* (float) width;
		camera.update();
		worldController.viewportWidth = camera.viewportWidth;
		worldController.width = width;
		worldController.height = height;
		cameraGUI.viewportHeight = Constants.VIEWPORT_GUI_HEIGHT;
		cameraGUI.viewportWidth = (Constants.VIEWPORT_GUI_HEIGHT / (float) height)
				* (float) width;
		cameraGUI.position.set(cameraGUI.viewportWidth / 2,
				cameraGUI.viewportHeight / 2, 0);
		cameraGUI.update();
	}

	public void render() {

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		worldController.board.render(batch);
		batch.end();

		// GUI rendering

		batch.setProjectionMatrix(cameraGUI.combined);
		batch.begin();

		if (worldController.board.gameState.PLAYING != null) {
			float x = cameraGUI.viewportWidth / 2 - 500.0f;
			float y = cameraGUI.viewportHeight / 2 - 450.0f;
			float xscore = cameraGUI.viewportWidth / 2 - 500.0f;
			float yscore = cameraGUI.viewportHeight / 2 - 350.0f;
			float x1 = cameraGUI.viewportWidth / 2 - 500.0f;
			float y1 = cameraGUI.viewportHeight / 2 - 230.0f;
			float xcount = cameraGUI.viewportWidth / 2 - 500.0f;
			float ycount = cameraGUI.viewportHeight / 2 - 130.0f;
			float x2 = cameraGUI.viewportWidth / 2 - 500.0f;
			float y2 = cameraGUI.viewportHeight / 2 ;
			float xhigh = cameraGUI.viewportWidth / 2 - 500.0f;
			float yhigh = cameraGUI.viewportHeight / 2 + 100;
			float xesc = cameraGUI.viewportWidth / 2 ;
			float yesc = cameraGUI.viewportHeight / 2 + 425;
			BitmapFont fontGameOver = Assets.instance.fonts.defaultBig;
			fontGameOver.setColor(1, 0.75f, 0.25f, 1);
			String message = "Score "; 
			String message1 = "" + worldController.board.score; 
			String message2 = "Game Count "; 
			String messagecount = "" + (GameStats.instance.gameCount ); 
			String message3 = "High Score "; 
			String messagehigh = "" + (GameStats.instance.highscore ); 
			String messageesc = "Press ESC key to restart";
																		
			fontGameOver.drawMultiLine(batch, message, x, y, 0,
					BitmapFont.HAlignment.CENTER);
			fontGameOver.drawMultiLine(batch, message1, xscore, yscore, 0,
					BitmapFont.HAlignment.CENTER);
			fontGameOver.drawMultiLine(batch, message2, x1, y1, 0,
					BitmapFont.HAlignment.CENTER);
			fontGameOver.drawMultiLine(batch, messagecount, xcount, ycount, 0,
					BitmapFont.HAlignment.CENTER);
			fontGameOver.drawMultiLine(batch, message3, x2, y2, 0,
					BitmapFont.HAlignment.CENTER);
			fontGameOver.drawMultiLine(batch, messagehigh, xhigh, yhigh, 0,
					BitmapFont.HAlignment.CENTER);
			fontGameOver.drawMultiLine(batch, messageesc, xesc, yesc, 0,
					BitmapFont.HAlignment.CENTER);
			fontGameOver.setColor(1, 1, 1, 1);
		}

		if (worldController.board.lose == true) {

			float x = cameraGUI.viewportWidth / 2;
			float y = cameraGUI.viewportHeight / 2;
			BitmapFont fontGameOver = Assets.instance.fonts.defaultBig;
			fontGameOver.setColor(1, 0.75f, 0.25f, 1);
			String message = "Game Over"; // if game is lost set game over
											

			fontGameOver.drawMultiLine(batch, message, x, y, 0,
					BitmapFont.HAlignment.CENTER);
			fontGameOver.setColor(1, 1, 1, 1);
			
			//GameStats.instance.lose();
		}

		if (worldController.board.win == true) {

			float x = cameraGUI.viewportWidth / 2;
			float y = cameraGUI.viewportHeight / 2;
			BitmapFont fontGameOver = Assets.instance.fonts.defaultBig;
			fontGameOver.setColor(1, 0.75f, 0.25f, 1);
			String message = "You Won !!!"; // if game is won set win
											

			fontGameOver.drawMultiLine(batch, message, x, y, 0,
					BitmapFont.HAlignment.CENTER);
			fontGameOver.setColor(1, 1, 1, 1);
			GameStats.instance.win();
		}

		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
