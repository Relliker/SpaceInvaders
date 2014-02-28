package objects;

import logic.Constants;
import logic.EffectsManager;
import logic.LogicManager;

import org.lwjgl.util.Point;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class PlayerShip implements Constants
{

	private int _cooldownRate = 1;
	private int _heat = 0;
	private final int _speed;
	private int _gunDamage = 100;
	private int _gunStreams = 1;
	private final int _hullStrength;
	private final int _shieldStrength;
	private final int _maxShieldPower;
	private float _currentEnergy;
	private final float _rechargeRate;
	private final Point _location;
	private Image _image;

	public PlayerShip(final int hullStrength, final int shieldStrength, final int maxPower, final float rechargeRate, final Point location, final int speed)
	{
		_speed = speed;
		_hullStrength = hullStrength;
		_shieldStrength = shieldStrength;
		_maxShieldPower = maxPower;
		_currentEnergy = maxPower;
		_rechargeRate = rechargeRate;
		_location = location;
		try {
			_image = new Image(resourcesPath + shipsPath + "\\greeninvader.png");
		} catch (final SlickException e) {
			System.out.print("Playership image load error");
		}
	}

	public void draw(final Graphics g)
	{
		g.texture(new Rectangle(_location.getX(), _location.getY(), 64, 64), _image, true);
	}

	public int getCooldown()
	{
		return _cooldownRate;
	}

	public int getGunDamage()
	{
		return _gunDamage;
	}

	public int getGunStreams()
	{
		return _gunStreams;
	}

	public int getHullStrength()
	{
		return _hullStrength;
	}

	public int getMaxPower()
	{
		return _maxShieldPower;
	}

	public float getPower()
	{
		return _currentEnergy;
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
		_location.setX(_location.getX() - _speed);
	}

	public void moveRight()
	{
		_location.setX(_location.getX() + _speed);
	}

	public void setCooldown(final int cooldown)
	{
		_cooldownRate = cooldown;
	}

	public void setGunDamage(final int damage)
	{
		_gunDamage = damage;
	}

	public void setGunDamageRelative(final int damage)
	{
		_gunDamage += damage;
	}

	public void setGunStreams(final int numStreams)
	{
		_gunStreams = numStreams;
	}

	public void shoot()
	{
		if ((_currentEnergy > 0) && (_heat < 10)) {
			_currentEnergy -= 1;
			_heat += 50;
			final Point shotLocation = new Point(_location);
			shotLocation.setLocation(shotLocation.getX() + 28, shotLocation.getY() + 8);
			EffectsManager.addPlayerShot(5, shotLocation);
		}
	}

	public void step(final GameContainer gc)
	{
		if (!LogicManager.isGamePaused()) {
			_currentEnergy += _rechargeRate;
			if (_heat > _cooldownRate)
				_heat -= _cooldownRate;
			else _heat = 0;
			final Input in = gc.getInput();
			if (in.isKeyDown(Input.KEY_LEFT)) moveLeft();
			if (in.isKeyDown(Input.KEY_RIGHT)) moveRight();
			if (in.isKeyDown(Input.KEY_SPACE)) shoot();
		}
	}
}
