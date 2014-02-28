package logic;

import java.util.ArrayList;

import objects.Invader;

public class ShipManager implements Constants
{

	protected static int wave = 1;

	protected static int lives = startLives;

	protected static ArrayList<Invader> currentWave;
	protected static boolean movingRight;
	protected static boolean stepDown;

	public static ArrayList<Invader> getInvaders()
	{
		return currentWave;
	}

	public static int getLives()
	{
		return lives;
	}

	public static int getWave()
	{
		return wave;
	}

	private static void nextWave()
	{
		setNextWave(3, 10, 100);
	}

	private static void setNextWave(final int numRows, final int numCols, final int health) // FOR TESTING ONLY!!!!!
	{
		currentWave = Waves.getWave(wave);
	}

	public static void step()
	{
		if (currentWave == null) {
			nextWave();
		}
		stepInvaders();
	}

	private static void stepInvaders()
	{
		for (final Invader current : currentWave) {
			if ((current.getX() + 64) > windowX) {
				movingRight = false;
				stepDown = true;
			} else if (current.getX() < 0) {
				movingRight = true;
				stepDown = true;
			}
		}
		for (final Invader current : currentWave) {
			if (movingRight) {
				current.moveRelative(3, 0);
			} else {
				current.moveRelative(-3, 0);
			}
			if (stepDown) {
				current.moveRelative(0, 15);
			}
		}
		stepDown = false;
	}
}
