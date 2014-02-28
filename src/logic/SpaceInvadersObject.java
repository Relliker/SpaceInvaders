package logic;

import org.lwjgl.util.Point;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class SpaceInvadersObject implements Constants
{

	private String _type;
	private Image _image;
	private int _moveDirection;
	private int _speed;
	private final Point _location;

	public SpaceInvadersObject(final String type, final int moveDirection, final int speed, final int x, final int y) throws SlickException
	{
		_type = type;
		_image = new Image(resourcesPath + effectsPath + type + ".jpg");
		_image = _image.getScaledCopy(4, 16);
		_image.bind();
		_moveDirection = moveDirection;
		_speed = speed;
		_location = new Point(x, y);
	}

	public SpaceInvadersObject(final String type, final int moveDirection, final int speed, final Point point) throws SlickException
	{
		_type = type;
		_image = new Image(resourcesPath + effectsPath + type + ".jpg");
		_image = _image.getScaledCopy(4, 16);
		_image.bind();
		_moveDirection = moveDirection;
		_speed = speed;
		_location = point;
	}

	public void draw(final Graphics g)
	{
		g.texture(new Rectangle(_location.getX() + 2, _location.getY() - 14, 4, 16), _image);
	}

	public int getDirection()
	{
		return _moveDirection;
	}

	public Image getImage()
	{
		return _image;
	}

	public int getSpeed()
	{
		return _speed;
	}

	public String getType()
	{
		return _type;
	}

	public void moveRelative(final int x, final int y)
	{
		_location.translate(x, y);
	}

	public void moveRelative(final Point p)
	{
		_location.translate(p);
	}

	public void setDirection(final int direction)
	{
		_moveDirection = direction;
	}

	public void setDirectionRelative(final int direction)
	{
		_moveDirection += direction;
	}

	public void setImage(final Image i)
	{
		_image = i;
	}

	public void setLocation(final int x, final int y)
	{
		_location.setLocation(x, y);
	}

	public void setLocation(final Point p)
	{
		_location.setLocation(p);
	}

	public void setSpeed(final int speed)
	{
		_speed = speed;
	}

	public void setSpeedRelative(final int speed)
	{
		_speed += speed;
	}

	public void setType(final String type)
	{
		_type = type;
	}

	public void step()
	{
		final double angle = Math.toRadians(_moveDirection + 90);
		_location.translate((int) (_speed * Math.cos(angle)), (int) (_speed * Math.sin(angle)));
	}
}
