package logic;

import java.util.ArrayList;

import org.lwjgl.util.Point;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class EffectsManager
{

	private final static ArrayList<SpaceInvadersObject> objects = new ArrayList<SpaceInvadersObject>();

	public static void addInvaderShot(final int speed, final Point _location)
	{
		try {
			objects.add(new SpaceInvadersObject("invadershot", 0, speed, new Point(_location)));
		} catch (final SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addPlayerShot(final int speed, final Point _location)
	{
		try {
			objects.add(new SpaceInvadersObject("playershot", 180, speed, new Point(_location)));
		} catch (final SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void draw(final Graphics g)
	{
		for (final SpaceInvadersObject e : objects) {
			e.draw(g);
		}
	}

	public static void step()
	{
		for (final SpaceInvadersObject e : objects) {
			e.step();
		}
	}
}
