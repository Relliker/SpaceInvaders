package logic;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;

import util.Point2;
/**
 * Space Invaders object 
 * 
 **/
public class SpaceInvadersObject implements Constants
{

	private String type;
	private Image image;
	private int moveDirection;
	private int speed;
	private Point2 location;
	private Polygon collisionMask;

	public SpaceInvadersObject(final String type, Polygon collisionMask, final int moveDirection, final int speed, final Point2 point) throws SlickException
	{
		this.type = type;
		image = new Image(effectsPath + type + ".png");
		this.moveDirection = moveDirection;
		this.speed = speed;
		this.collisionMask = collisionMask;
		location = point;
	}
	/**
	 * draws the space invaders object to the screen
	 * @param g - Graphics object 
	 **/
	public void draw(final Graphics g)
	{
		g.texture(new Rectangle(location.getX(), location.getY(), (int) (4 * scale), (int) (16 * scale)), image, true);
	}
	/**
	 * gets the Direction of the space invader
	 * @return the direction of the space invader
	 **/
	public int getDirection()
	{
		return moveDirection;
	}
	/**
	 * gets the collision mask of the space invader
	 * @return polygon object of the spaace invader
	 **/
	public Polygon getCollisionMask()
	{
		return collisionMask;
	}
	/**
	 * gets the image of the spcae invader
	 * @return Image object of the space invader
	 **/

	public Image getImage()
	{
		return image;
	}
	/**
	 * gets the location of the space invader
	 * @return the point2 object of the space invaeder
	 **/

	public Point2 getLocation()
	{
		return location;
	}
	/**
	 * gets the speed of the space invader
	 * @return the speed of the space invader
	 **/

	public int getSpeed()
	{
		return speed;
	}
	/**
	 * gets the type of the space invader
	 * @return the string type of the invader
	 **/

	public String getType()
	{
		return type;
	}

	public void moveRelative(final int x, final int y)
	{

	}
	/**
	 * sets the direction of the space invader
	 * @param given direction
	 **/
	public void setDirection(final int direction)
	{
		moveDirection = direction;
	}
	/**
	 * sets the direction of the space invader relative to its original direction
	 * @param direction - direction added to the current direction
	 **/

	public void setDirectionRelative(final int direction)
	{
		moveDirection += direction;
	}
	/**
	 * sets the image of the space invader
	 * @param i - Image object of the space inavder
	 **/

	public void setImage(final Image i)
	{
		image = i;
	}
	/**
	 * sets the location of the space invader
	 * @param x - sets the x coordinate of the space invader
	 * @param y - sets the y coordinate of the space invader
	 **/

	public void setLocation(final int x, final int y)
	{
		location.setLocation(x, y);
	}
	/**
	 * sets the location of the space invader with the point2 object
	 * @param location- point 2 object of the location wanted to set
	 **/

	public void setLocation(final Point2 location)
	{
		this.location = location;

	}
	/**
	 * sets the speed of the space invader
	 * @param speed - speed value of the space invader wanted to be set
	 **/

	public void setSpeed(final int speed)
	{
		this.speed = speed;
	}
	/**
	 * adds the specific amount of speed given to the space invaders object
	 * @param speed - speed added to current speed
	 **/

	public void setSpeedRelative(final int speed)
	{
		this.speed += speed;
	}
	/**
	 * sets the type by a given string
	 * @param type - string of the given type
	 **/

	public void setType(final String type)
	{
		this.type = type;
	}
	/**
	 * makes the space invader use logic and move
	 **/

	public void step()
	{
		final double angle = Math.toRadians(moveDirection + 90);
		location.translate((int) (speed * Math.cos(angle)), (int) (speed * Math.sin(angle)));
	}
}
