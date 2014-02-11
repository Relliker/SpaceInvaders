package objects;

public class RedInvader extends Invader
{

	protected static int health = 100;

	RedInvader(final int _xLocation, final int _yLocation)
	{
		super(_xLocation, _yLocation, health);
	}

}
