package logic;

import java.util.ArrayList;

import org.lwjgl.util.Point;

public class EffectsManager
{

	private final static ArrayList<SpaceInvadersObject> objects = new ArrayList<SpaceInvadersObject>();

	public static void addInvaderShot(final int speed, final Point _location)
	{
		objects.add(new SpaceInvadersObject("invadershot", 180, speed, _location));
	}

	public static void addPlayerShot(final int speed, final Point _location)
	{
		objects.add(new SpaceInvadersObject("playershot", 0, speed, _location));
	}

	public static void step()
	{
		for (final SpaceInvadersObject e : objects) {
			e.step();
		}
	}
}
