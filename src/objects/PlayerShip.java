package objects;

import logic.Constants;
import logic.EffectsManager;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import util.Point2;

public class PlayerShip implements Constants
{

	private float cooldownRate = 1.5f;
	private float heat = 0;
	private int size = (int) (64 * scale);
	private int speed;
	private int gunDamage = 100;
	private int gunStreams = 1;
	private int hullStrength;
	private int maxHullStrength;
	private int shieldStrength;
	private int maxShieldStrength;
	private float currentEnergy;
	private float shieldRegenRate;
	private Point2 location;
	private Image image;

	public PlayerShip(final int hullStrength, final int shieldStrength, final float rechargeRate, final Point2 location, final int speed)
	{
		this.speed = speed;
		this.hullStrength = hullStrength;
		maxHullStrength = hullStrength;
		this.shieldStrength = shieldStrength;
		maxShieldStrength = shieldStrength;
		shieldRegenRate = rechargeRate;
		this.location = location;
		try {
			image = new Image(shipsPath + "\\greeninvader.png");
		} catch (final SlickException e) {
			System.out.print("Playership image load error");
		}
	}

	public void draw(final Graphics g)
	{
		g.texture(new Rectangle(location.getX(), location.getY(), size, size), image, true);
	}

	public float getCooldown()
	{
		return cooldownRate;
	}

	public int getGunDamage()
	{
		return gunDamage;
	}

	public int getGunStreams()
	{
		return gunStreams;
	}

	public int getHullStrength()
	{
		return hullStrength;
	}

	public Point2 getLocation()
	{
		return location;
	}

	public int getMaxHullStrength()
	{
		return maxHullStrength;
	}

	public int getMaxPower()
	{
		return maxShieldStrength;
	}

	public float getPower()
	{
		return currentEnergy;
	}

	public float getRechargeRate()
	{
		return shieldRegenRate;
	}

	public int getShieldStrength()
	{
		return shieldStrength;
	}

	public void moveLeft()
	{
		if (location.getX() > speed) location.setX(location.getX() - speed);
	}

	public void moveRight()
	{
		if (location.getX() < ((windowX - speed) - size)) location.setX(location.getX() + speed);
	}

	public void setCooldown(final int cooldown)
	{
		cooldownRate = cooldown;
	}

	public void setGunDamage(final int damage)
	{
		gunDamage = damage;
	}

	public void setGunDamageRelative(final int damage)
	{
		gunDamage += damage;
	}

	public void setGunStreams(final int numStreams)
	{
		gunStreams = numStreams;
	}

	public void shoot()
	{
		if ((currentEnergy > 0) && (heat < 10)) {
			currentEnergy -= 1;
			heat += 50;
			final Point2 shotLocation = new Point2(location);
			shotLocation.setLocation(shotLocation.getX() + (int) (30 * scale), shotLocation.getY() + (int) (4 * scale));
			EffectsManager.addPlayerShot((int) (5 * scale), 0, shotLocation);
		}
	}

	public void step(final GameContainer gc)
	{
		currentEnergy += shieldRegenRate;
		if (heat > cooldownRate) heat -= cooldownRate;
		else heat = 0;
		final Input in = gc.getInput();
		if (in.isKeyDown(Input.KEY_LEFT)) moveLeft();
		if (in.isKeyDown(Input.KEY_RIGHT)) moveRight();
		if (in.isKeyDown(Input.KEY_SPACE)) shoot();
	}
}
