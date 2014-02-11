package objects;
public class Invader
{

	protected int xLocation;
	protected int yLocation;
	protected int health;

	public Invader(final int _xLocation, final int _yLocation, final int _health)
	{
		xLocation = _xLocation;
		yLocation = _yLocation;
		health = _health;
	}

	public int getHealth()
	{
		return health;
	}

	public int getX()
	{
		return xLocation;
	}

	public int getY()
	{
		return yLocation;
	}

	public void move(final int _xLocation, final int _yLocation)
	{
		xLocation = _xLocation;
		yLocation = _yLocation;
	}

	public void moveRelative(final int _xLocation, final int _yLocation)
	{
		xLocation += _xLocation;
		yLocation += _yLocation;
	}

	public void setHealth(final int _health)
	{
		health = _health;
	}

	public void setHealthRelative(final int _health)
	{
		health += _health;
	}
}
