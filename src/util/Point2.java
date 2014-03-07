package util;

import org.newdawn.slick.geom.Point;

/**
 * The default Point class was missing some methods I needed
 * 
 * @author Timber
 */
public class Point2 extends org.newdawn.slick.geom.Point
{

	private static final long serialVersionUID = 1L;

	public Point2(float x, float y)
	{
		super(x, y);
	}

	public Point2(Point location)
	{
		super(location.getX(), location.getY());
	}

	public Point2(Point2 location)
	{
		super(location.getX(), location.getY());
	}

	public void setXRelative(float x)
	{
		this.x += x;
	}

	public void setYRelative(float y)
	{
		this.y += y;
	}

	public void translate(float x, float y)
	{
		this.x += x;
		this.y += y;
	}
}
