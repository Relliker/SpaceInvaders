package objects;

import logic.Constants;
import logic.EffectsManager;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import util.Point2;

public class Invader implements Constants
{

	protected int size;
	protected Point2 location;
	protected int health;
	protected Image texture;

	public Invader(Point2 location, int size, int health, Image texture)
	{
		this.size = size;
		this.location = location;
		this.health = health;
		this.texture = texture;
	}

	public void draw(final Graphics g)
	{
		g.texture(new Rectangle(location.getX(), location.getY(), size, size), texture, true);

	}

	public int getHealth()
	{
		return health;
	}

	public int getSize()
	{
		return size;
	}

	public int getX()
	{
		return (int) location.getX();
	}

	public int getY()
	{
		return (int) location.getY();
	}

	public void move(int x, int y)
	{
		location.setX(x);
		location.setY(y);
	}

	public void moveRelative(int x, int y)
	{
		location.setX(location.getX() + x);
		location.setY(location.getY() + y);
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public void setHealthRelative(int health)
	{
		this.health += health;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public void shoot()
	{
		EffectsManager.addInvaderShot((int) (5 * scale), new Point2(location.getX() + (size / 2), location.getY() + size));
	}
}
