package objects;

public class GreenInvader extends Invader
{

	protected static int health = 200;

	GreenInvader(final int _xLocation, final int _yLocation)
	{
		super(_xLocation, _yLocation, health);
	}
}
