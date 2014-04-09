package util;

import org.newdawn.slick.geom.Point;

/**
 * The default Point class was missing some methods needed
 * 
 * @author Timber
 */
public class Point2 extends org.newdawn.slick.geom.Point
{ 
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor for 2 coordinates
	 */
	public Point2(float x, float y)
	{
		super(x, y);
	}

	/**
	 * constructor for a Point
	 */
	public Point2(Point location)
	{
		super(location.getX(), location.getY());
	}

	/**
	 * Constructor for Point2 
	 */
	public Point2(Point2 location)
	{
		super(location.getX(), location.getY());
	}
	
	/**
	 * Change x position by a certain amount
	 * @param x - amount to change x position by
	 */
	public void setXRelative(float x)
	{
		this.x += x;
	}

	/**
	 * change x position by a certain amount
	 * @param y - amount to change y position by
	 */
	public void setYRelative(float y)
	{
		this.y += y;
	}
	/**
	 * move in a certain direction
	 * @param x - amount to change x position by
	 * @param y - amount to change y position by
	 */
	public void translate(float x, float y)
	{
		this.x += x;
		this.y += y;
	}
}
