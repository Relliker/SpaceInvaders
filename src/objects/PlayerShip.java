package objects;

import logic.Constants;
import logic.EffectsManager;

import org.lwjgl.util.Point;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class PlayerShip implements Constants
{

	private final int _hullStrength;
	private final int _shieldStrength;
	private final int _maxPower;
	private float _currentPower;
	private final float _rechargeRate;
	private final Point _location;
	private Image _image;

	public PlayerShip(final int hullStrength, final int shieldStrength, final int maxPower, final float rechargeRate, final Point location)
	{
		_hullStrength = hullStrength;
		_shieldStrength = shieldStrength;
		_maxPower = maxPower;
		_currentPower = maxPower;
		_rechargeRate = rechargeRate;
		_location = location;
		try {
			_image = new Image(resourcesPath + shipsPath + "\\greeninvader.png");
		} catch (final SlickException e) {
			System.out.print("I'm dead");
		}
	}

	public void draw(final Graphics g)
	{
		g.texture(new Rectangle(_location.getX(), _location.getY(), 64, 64), _image, true);
	}

	public int getHullStrength()
	{
		return _hullStrength;
	}

	public int getMaxPower()
	{
		return _maxPower;
	}

	public float getPower()
	{
		return _currentPower;
	}

	public float getRechargeRate()
	{
		return _rechargeRate;
	}

	public int getShieldStrength()
	{
		return _shieldStrength;
	}

	public void moveLeft()
	{
		_location.setX(_location.getX() - 1);
	}

	public void moveRight()
	{
		_location.setX(_location.getX() + 1);
	}

	public void shoot()
	{
		_currentPower -= 1;
		EffectsManager.addPlayerShot(5, _location);
	}
}
