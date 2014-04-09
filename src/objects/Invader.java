package objects;

import logic.Constants;
import logic.EffectsManager;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import util.Point2;
/**
 * Invader class 
 **/ 
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
	/**
	 *draws the invader ship
	 *@param g - Graphics object
	 **/ 
	public void draw(final Graphics g)
	{
		g.texture(new Rectangle(location.getX(), location.getY(), size, size), texture, true);

	}
	/**
	 * gets the health value of the invader
	 * @return amount of health of the invader
	 **/

	public int getHealth()
	{
		return health;
	}
	/**
	 * gets the size of the invader
	 * @return size of the invader
	 **/

	public int getSize()
	{
		return size;
	}
	/**
	 * gets the x coordinate of the invader
	 * @return the x coordiante
	 **/

	public int getX()
	{
		return (int) location.getX();
	}
	/**
	 * gets the y coordinate oft he invader
	 * @return the y coordinate
	 * 
	 **/

	public int getY()
	{
		return (int) location.getY();
	}
	/**
	 * moves the invader to a given x and y coordinate. More for the creating the first position
	 * @param x - x coordinate where the invader will move
	 * @param y - y coordinate where the invader will move
	 **/

	public void move(int x, int y)
	{
		location.setX(x);
		location.setY(y);
	}
	/**
	 * move the invader by adding a given value to the x and y values
	 * @param x- adds this amount to the x coordinate
	 * @param y- adds this amount to the y coordinate
	 **/
	public void moveRelative(int x, int y)
	{
		location.setX(location.getX() + x);
		location.setY(location.getY() + y);
	}
	/**
	 * sets the health of the invader 
	 * @param health- value of health will be set to
	 **/

	public void setHealth(int health)
	{
		this.health = health;
	}
	/**
	 * adds the given health to the invader
	 * @param health- amount of health added to the current health of the invader
	 **/

	public void setHealthRelative(int health)
	{
		this.health += health;
	}
	/**
	 * sets the sive of the invader to the given size
	 * @param size- size that the invader will be set to
	 **/

	public void setSize(int size)
	{
		this.size = size;
	}
	/**
	 * shoots a projectile from the invader object
	 **/

	public void shoot()
	{
		EffectsManager.addInvaderShot((int) (5 * scale), new Point2(location.getX() + (size / 2), location.getY() + size));
	}
}
