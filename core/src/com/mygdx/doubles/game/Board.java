package com.mygdx.doubles.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.mygdx.doubles.game.Tile;
import com.mygdx.doubles.game.Assets.Asset;
import com.mygdx.doubles.game.util.Constants;
import com.mygdx.doubles.game.util.GameStats;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Board {

	public static final String TAG = Board.class.getName();

	public static enum GameState {
		PLAYING, LOST
	}

	public GameState gameState;
	public GameStats gamestats;
	public boolean win = false;
	public boolean lose = false;
	public int score;
	private Tile[] tiles;

	public Board() {
		init();
	}

	private void init() {
		start();
	}

	/*
	 * render the grid for the game using single asset for each of the tiles
	 */
	public void render(SpriteBatch batch) {

		for (int row = 0; row < 4; row++)
			for (int col = 0; col < 4; col++) {

				TextureRegion region0 = Assets.instance.zero.region;
				TextureRegion region2 = Assets.instance.two.region;
				TextureRegion region4 = Assets.instance.four.region;
				TextureRegion region8 = Assets.instance.eight.region;
				TextureRegion region16 = Assets.instance.sixteen.region;
				TextureRegion region32 = Assets.instance.thirtytwo.region;
				TextureRegion region64 = Assets.instance.sixtyfour.region;
				TextureRegion region128 = Assets.instance.hundredtwentyeight.region;
				TextureRegion region256 = Assets.instance.twohundredfiftysix.region;
				TextureRegion region512 = Assets.instance.fivehundredtwelve.region;
				TextureRegion region1024 = Assets.instance.thousandtwentyfour.region;
				TextureRegion region2048 = Assets.instance.twothousandfortyeight.region;

				Tile p = tileAt(row, col);

				if (p.value == 0) {

					batch.draw(region0.getTexture(), col * 1.4f - 1.9f,
							row * 1.4f - 2.3f, 0, 0, 1, 1, 1, 1, 0,
							region0.getRegionX(), region0.getRegionY(),
							region0.getRegionWidth(),
							region0.getRegionHeight(), false, false);

				} else if (p.value == 2) {

					batch.draw(region2.getTexture(), col * 1.4f - 1.9f,
							row * 1.4f - 2.3f, 0, 0, 1, 1, 1, 1, 0,
							region2.getRegionX(), region2.getRegionY(),
							region2.getRegionWidth(),
							region2.getRegionHeight(), false, false);
				}

				else if (p.value == 4) {

					batch.draw(region4.getTexture(), col * 1.4f - 1.9f,
							row * 1.4f - 2.3f, 0, 0, 1, 1, 1, 1, 0,
							region4.getRegionX(), region4.getRegionY(),
							region4.getRegionWidth(),
							region4.getRegionHeight(), false, false);
				}

				else if (p.value == 8) {

					batch.draw(region8.getTexture(), col * 1.4f - 1.9f,
							row * 1.4f - 2.3f, 0, 0, 1, 1, 1, 1, 0,
							region8.getRegionX(), region8.getRegionY(),
							region8.getRegionWidth(),
							region8.getRegionHeight(), false, false);
				}

				else if (p.value == 16) {

					batch.draw(region16.getTexture(), col * 1.4f - 1.9f,
							row * 1.4f - 2.3f, 0, 0, 1, 1, 1, 1, 0,
							region16.getRegionX(), region16.getRegionY(),
							region16.getRegionWidth(),
							region16.getRegionHeight(), false, false);
				}

				else if (p.value == 32) {

					batch.draw(region32.getTexture(), col * 1.4f - 1.9f,
							row * 1.4f - 2.3f, 0, 0, 1, 1, 1, 1, 0,
							region32.getRegionX(), region32.getRegionY(),
							region32.getRegionWidth(),
							region32.getRegionHeight(), false, false);
				}

				else if (p.value == 64) {

					batch.draw(region64.getTexture(), col * 1.4f - 1.9f,
							row * 1.4f - 2.3f, 0, 0, 1, 1, 1, 1, 0,
							region64.getRegionX(), region64.getRegionY(),
							region64.getRegionWidth(),
							region64.getRegionHeight(), false, false);
				}

				else if (p.value == 128) {

					batch.draw(region128.getTexture(), col * 1.4f - 1.9f,
							row * 1.4f - 2.3f, 0, 0, 1, 1, 1, 1, 0,
							region128.getRegionX(), region128.getRegionY(),
							region128.getRegionWidth(),
							region128.getRegionHeight(), false, false);
				}

				else if (p.value == 256) {

					batch.draw(region256.getTexture(), col * 1.4f - 1.9f,
							row * 1.4f - 2.3f, 0, 0, 1, 1, 1, 1, 0,
							region256.getRegionX(), region256.getRegionY(),
							region256.getRegionWidth(),
							region256.getRegionHeight(), false, false);
				}

				else if (p.value == 512) {

					batch.draw(region512.getTexture(), col * 1.4f - 1.9f,
							row * 1.4f - 2.3f, 0, 0, 1, 1, 1, 1, 0,
							region512.getRegionX(), region512.getRegionY(),
							region512.getRegionWidth(),
							region512.getRegionHeight(), false, false);
				}

				else if (p.value == 1024) {

					batch.draw(region1024.getTexture(), col * 1.4f - 1.9f,
							row * 1.4f - 2.3f, 0, 0, 1, 1, 1, 1, 0,
							region1024.getRegionX(), region1024.getRegionY(),
							region1024.getRegionWidth(),
							region1024.getRegionHeight(), false, false);
				}

				else if (p.value == 2048) {

					batch.draw(region2048.getTexture(), col * 1.4f - 1.9f,
							row * 1.4f - 2.3f, 0, 0, 1, 1, 1, 1, 0,
							region2048.getRegionX(), region2048.getRegionY(),
							region2048.getRegionWidth(),
							region2048.getRegionHeight(), false, false);
				}
			}
	}

	public void start() {

		score = 0;
		win = false;
		lose = false;
		tiles = new Tile[4 * 4];

		for (int i = 0; i < tiles.length; i++) {

			tiles[i] = new Tile();
		}

		GameStats.instance.load();
		addTile();
		addTile();
		gameState = GameState.PLAYING;
		System.out.println(GameStats.instance.gameCount);
	}

	/*
	 * print to console for testing purposes
	 */
	public void printGrid() {

		for (Tile t : tiles) {

			System.out.printf("%4d \n", t.value);
		}
	}

	/*
	 * move the tiles to the left
	 */
	public void left() {

		boolean needAddTile = false;

		for (int i = 0; i < 4; i++) {

			// move
			Tile[] line = getLine(i);
			Tile[] merged = mergeLine(moveLine(line));
			setLine(i, merged);
			if (!needAddTile && !compare(line, merged)) {

				needAddTile = true;
			}
		}

		if (needAddTile) {

			addTile();
		}

	}

	/*
	 * call rotate method for left movement in order for right
	 */
	public void right() {

		tiles = rotate(180);
		left();
		tiles = rotate(180);
	}

	/*
	 * call rotate method for left movement in order for up
	 */
	public void up() {

		tiles = rotate(270);
		left();
		tiles = rotate(90);
	}

	/*
	 * call rotate method for left movement in order for down
	 */
	public void down() {

		tiles = rotate(90);
		left();
		tiles = rotate(270);
	}

	/*
	 * take in the position of each of the tiles and rotate the board depending
	 * on what way the player inputs into the game taking angle into account
	 */
	private Tile[] rotate(int angle) {

		Tile[] newTiles = new Tile[4 * 4];
		int offsetX = 3, offsetY = 3;

		if (angle == 90) {

			offsetY = 0;
		} else if (angle == 270) {

			offsetX = 0;
		}

		double rad = Math.toRadians(angle);
		int cos = (int) Math.cos(rad);
		int sin = (int) Math.sin(rad);

		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {

				int newX = (x * cos) - (y * sin) + offsetX;
				int newY = (x * sin) + (y * cos) + offsetY;
				newTiles[(newX) + (newY) * 4] = tileAt(x, y);
			}
		}
		return newTiles;
	}

	private Tile tileAt(int x, int y) {

		return tiles[x + y * 4];
	}

	/*
	 * put tile at a random position in the board called after every move
	 */
	private void addTile() {

		List<Tile> list = availableSpace();
		if (!availableSpace().isEmpty()) {
			int index = (int) (Math.random() * list.size()) % list.size();
			Tile emptyTime = list.get(index);
			emptyTime.value = Math.random() < 0.9 ? 2 : 4;
		}
	}

	/*
	 * checks how many available tiles arae in the game
	 */
	private List<Tile> availableSpace() {

		final List<Tile> list = new ArrayList<Tile>(16);
		for (Tile t : tiles) {
			if (t.isEmpty()) {
				list.add(t);
			}
		}
		return list;
	}

	/*
	 * check if all the game tiles are full
	 */
	private boolean isFull() {

		return availableSpace().size() == 0;
	}

	/*
	 * to check if player can make a move depending on what is around them
	 */
	boolean canMove() {

		if (!isFull()) {

			return true;
		}

		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {

				Tile t = tileAt(x, y);

				if ((x < 3 && t.value == tileAt(x + 1, y).value)
						|| ((y < 3) && t.value == tileAt(x, y + 1).value)) {

					return true;
				}
			}
		}
		return false;
	}

	/*
	 * compare each of the tiles either above or below the given position
	 */
	private boolean compare(Tile[] line1, Tile[] line2) {

		if (line1 == line2) {

			return true;
		} else if (line1.length != line2.length) {

			return false;
		}

		for (int i = 0; i < line1.length; i++) {
			if (line1[i].value != line2[i].value) {

				return false;
			}
		}
		return true;
	}

	/*
	 * move the line either up or down depending on the position
	 */
	private Tile[] moveLine(Tile[] oldLine) {

		LinkedList<Tile> l = new LinkedList<Tile>();

		for (int i = 0; i < 4; i++) {
			if (!oldLine[i].isEmpty())

				l.addLast(oldLine[i]);
		}
		if (l.size() == 0) {

			return oldLine;
		} else {

			Tile[] newLine = new Tile[4];
			ensureSize(l, 4);

			for (int i = 0; i < 4; i++) {

				newLine[i] = l.removeFirst();
			}
			return newLine;
		}
	}

	/*
	 * check whether or not the 2 values are the same on the grid once a
	 * movement has been made if so combine the tiles
	 */
	private Tile[] mergeLine(Tile[] oldLine) {

		LinkedList<Tile> list = new LinkedList<Tile>();

		for (int i = 0; i < 4 && !oldLine[i].isEmpty(); i++) {

			int num = oldLine[i].value;

			if (i < 3 && oldLine[i].value == oldLine[i + 1].value) {

				num *= 2;
				score += num;
				int ourTarget = 2048;

				if (num == ourTarget) {

					win = true;
				}
				i++;
			}
			list.add(new Tile(num));
		}

		if (list.size() == 0) {

			return oldLine;
		} else {

			ensureSize(list, 4);
			return list.toArray(new Tile[4]);
		}
	}

	/*
	 * check size of tiles
	 */
	private static void ensureSize(java.util.List<Tile> l, int s) {

		while (l.size() != s) {

			l.add(new Tile());
		}
	}

	/*
	 * get the line for tiles
	 */
	private Tile[] getLine(int index) {

		Tile[] result = new Tile[4];

		for (int i = 0; i < 4; i++) {

			result[i] = tileAt(i, index);
		}
		return result;
	}

	/*
	 * set the line as a copy taking into acocunt the previous array
	 */
	private void setLine(int index, Tile[] re) {

		System.arraycopy(re, 0, tiles, index * 4, 4);
	}
}
