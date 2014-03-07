package logic;

import java.util.ArrayList;

import objects.Invader;
import objects.PlayerShip;
import util.Point2;

public class ShipManager implements Constants
{

	protected static int wave = 1;

	protected static int lives = startLives;
	private static PlayerShip player = new PlayerShip(1000, 500, 5, new Point2((windowX / 2) - (int) (64 * scale), windowY - (int) (128 * scale)), (int) (5 * scale));
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

	public static PlayerShip getPlayerShip()
	{
		return player;
	}

	public static int getWave()
	{
		return wave;
	}

	private static void nextWave()
	{
		setNextWave(3, 10, 100);
	}

	private static void setNextWave(final int numRows, final int numCols, final int health)
	{
		currentWave = Waves.getNextWave();
	}

	public static void step()
	{
		if (currentWave == null) nextWave();
		stepInvaders();
	}

	private static void stepInvaders()
	{
		for (final Invader current : currentWave)
			if ((current.getX() + (windowX / 30)) > windowX) {
				movingRight = false;
				stepDown = true;
			} else if (current.getX() < 0) {
				movingRight = true;
				stepDown = true;
			}

		for (final Invader current : currentWave) {
			if (movingRight) current.moveRelative(3, 0);
			else current.moveRelative(-3, 0);
			if (stepDown) current.moveRelative(0, 15);
			if (Math.random() < .0005) current.shoot();
		}
		stepDown = false;
	}
}
