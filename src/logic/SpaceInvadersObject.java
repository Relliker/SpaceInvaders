package logic;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;

import util.Point2;

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

	public void draw(final Graphics g)
	{
		g.texture(new Rectangle(location.getX(), location.getY(), (int) (4 * scale), (int) (16 * scale)), image, true);
	}

	public int getDirection()
	{
		return moveDirection;
	}

	public Polygon getCollisionMask()
	{
		return collisionMask;
	}

	public Image getImage()
	{
		return image;
	}

	public Point2 getLocation()
	{
		return location;
	}

	public int getSpeed()
	{
		return speed;
	}

	public String getType()
	{
		return type;
	}

	public void moveRelative(final int x, final int y)
	{

	}

	public void setDirection(final int direction)
	{
		moveDirection = direction;
	}

	public void setDirectionRelative(final int direction)
	{
		moveDirection += direction;
	}

	public void setImage(final Image i)
	{
		image = i;
	}

	public void setLocation(final int x, final int y)
	{
		location.setLocation(x, y);
	}

	public void setLocation(final Point2 location)
	{
		this.location = location;

	}

	public void setSpeed(final int speed)
	{
		this.speed = speed;
	}

	public void setSpeedRelative(final int speed)
	{
		this.speed += speed;
	}

	public void setType(final String type)
	{
		this.type = type;
	}

	public void step()
	{
		final double angle = Math.toRadians(moveDirection + 90);
		location.translate((int) (speed * Math.cos(angle)), (int) (speed * Math.sin(angle)));
	}
}
