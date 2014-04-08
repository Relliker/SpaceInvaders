package logic;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import util.Point2;
/**
 * objects - Game objects
 */
public class EffectsManager implements Constants, CollisionMasks
{

	private final static ArrayList<SpaceInvadersObject> objects = new ArrayList<SpaceInvadersObject>();
	/**
	 * adds an invader bullet object
	 * @param speed - speed to give invade shot
	 * @param point - point to create object at
	 */
	public static void addInvaderShot(final int speed, final Point2 point)
	{
		try {
			objects.add(new SpaceInvadersObject("invadershot", invaderShotCollisionMask, 0, speed, new Point2(point)));
		} catch (final SlickException e) {
			e.printStackTrace();
		}
	}
	/**
	 * adds a player bullet object
	 * @param speed - speed shot will travel at 
	 * @param angle - angle shot will be going in. This will be used to create different shot types.
	 * @param location - position to create player shot
	 */
	public static void addPlayerShot(final int speed, final int angle, final Point2 location)
	{
		try {
			objects.add(new SpaceInvadersObject("playershot", playerShotCollisionMask, angle - 180, speed, new Point2(location)));
		} catch (final SlickException e) {
			e.printStackTrace();
		}
	}
	/**
	 * draws all objects in objects
	 */
	public static void draw(final Graphics g)
	{
		for (final SpaceInvadersObject e : objects)
			e.draw(g);
	}
	/**
	 * returns if a point is a valid location to be drawn on the screen
	 * @return - if point is on screen or not
	 */
	private static boolean isOnScreen(Point2 location)
	{
		int buffer = 100;
		if ((location.getX() < -buffer) || (location.getX() > (windowX + buffer))) return false;
		if ((location.getY() < -buffer) || (location.getY() > (windowY + buffer))) return false;
		return true;
	}
	/**
	 * removes any object that goes off the screen
	 */ 
	public static void step()
	{
		for (int current = 0; current < objects.size(); current++)
			if (!isOnScreen(objects.get(current).getLocation())) {objects.remove(current);current--;}
			else objects.get(current).step();
			
	}
}
