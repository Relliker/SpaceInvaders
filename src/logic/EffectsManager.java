package logic;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import util.Point2;

public class EffectsManager implements Constants
{

	private final static ArrayList<SpaceInvadersObject> objects = new ArrayList<SpaceInvadersObject>();

	public static void addInvaderShot(final int speed, final Point2 point)
	{
		try {
			objects.add(new SpaceInvadersObject("invadershot", 0, speed, new Point2(point)));
		} catch (final SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addPlayerShot(final int speed, final int angle, final Point2 location)
	{
		try {
			objects.add(new SpaceInvadersObject("playershot", angle - 180, speed, new Point2(location)));
		} catch (final SlickException e) {
			e.printStackTrace();
		}
	}

	public static void draw(final Graphics g)
	{
		for (final SpaceInvadersObject e : objects)
			e.draw(g);
	}

	private static boolean isOnScreen(Point2 location)
	{
		int buffer = 100;
		if ((location.getX() < -buffer) || (location.getX() > (windowX + buffer))) return false;
		if ((location.getY() < -buffer) || (location.getY() > (windowY + buffer))) return false;
		return true;
	}

	public static void step()
	{
		for (int current = 0; current < objects.size(); current++)
			if (!isOnScreen(objects.get(current).getLocation())) objects.remove(current);
			else objects.get(current).step();
	}
}
