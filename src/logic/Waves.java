package logic;

import java.util.ArrayList;

import objects.Invader;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import util.Point2;

public class Waves implements Constants
{

	static double xScale = 1; // 1 means each invader is 32x32
	static double yScale = 1;
	static int currentWave = 1;

	public static ArrayList<Invader> getNextWave()
	{
		currentWave++;
		return makeWave(15, 5, 300 * (currentWave - 1));
	}

	private static ArrayList<Invader> makeWave(int numCols, int numRows, int health)
	{
		Image texture = null;
		try {
			texture = new Image(shipsPath + "redinvader.png").getFlippedCopy(false, true);
		} catch (SlickException e) {
		}
		int topBuffer = (int) ((windowY / 15) * scale);
		int size = (int) ((windowX / 30) * scale);
		int spacing = (int) ((size / 5) * scale);
		ArrayList<Invader> wave = new ArrayList<Invader>(numCols * numRows);
		for (int row = 0; row < numRows; row++)
			for (int col = 0; col < numCols; col++)
				wave.add(new Invader(new Point2((col * size) + (col * spacing), (row * size) + (row * spacing) + topBuffer), size, health, texture));

		return wave;
	}
}
