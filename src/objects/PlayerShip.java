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
/**
 * playership class
 * heat - cooldown limit
 * 
 **/

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
	/**
 	* draws the new player ship
 	* @param g - graphics object
 	**/ 
	public void draw(final Graphics g)
	{
		g.texture(new Rectangle(location.getX(), location.getY(), size, size), image, true);
	}
	/**
	 * @return get cooldown- returns the cooldown 
	 
	 **/
	public float getCooldown()
	{
		return cooldownRate;
	}
	/**
	 *@return get gun Damage- returns the gun damgae 
	 
	 **/

	public int getGunDamage()
	{
		return gunDamage;
	}
	/**
	 *@return get Gun streams- return gun stream 
	 **/

	public int getGunStreams()
	{
		return gunStreams;
	}
	/**
	 *get hull strength- returns the hull strength 
	 
	 **/

	public int getHullStrength()
	{
		return hullStrength;
	}
	/**
	 *@return get Location- returns the point2 location object 
	 
	 **/

	public Point2 getLocation()
	{
		return location;
	}
	/**
	 *@return get max hull strength- returns the max hull strength
	 
	 **/

	public int getMaxHullStrength()
	{
		return maxHullStrength;
	}
	/**
	 *@return max power of player ship 
	 **/
	public int getMaxPower()
	{
		return maxShieldStrength;
	}
	/**
	 *@return current power of ship 
	 **/
	public float getPower()
	{
		return currentEnergy;
	}
	/**
	 * @return recharge rate of shields
	 **/

	public float getRechargeRate()
	{
		return shieldRegenRate;
	}
	/**
	 * @return current shield strength
	 **/

	public int getShieldStrength()
	{
		return shieldStrength;
	}
	/**
	 * moves player shift left
	 **/

	public void moveLeft()
	{
		if (location.getX() > speed) location.setX(location.getX() - speed);
	}
	/**
	 * moves player ship right
	 **/
	public void moveRight()
	{
		if (location.getX() < ((windowX - speed) - size)) location.setX(location.getX() + speed);
	}
	/**
	 * sets coolodown of player ship
	 * @param cooldown - value of cooldown
	 **/
	public void setCooldown(final int cooldown)
	{
		cooldownRate = cooldown;
	}
	/**
	 * sets the gun damage of player ship
	 * @param damage - value of damage of shot
	 **/

	public void setGunDamage(final int damage)
	{
		gunDamage = damage;
	}
	/**
	 * adds gun damage value
	 * @param damage - value of damage added to gunDamage
	 **/
	public void setGunDamageRelative(final int damage)
	{
		gunDamage += damage;
	}
	/**
	 * sets the number of gunstreams 
	 * @param numStreams - number of gunstreams
	 **/

	public void setGunStreams(final int numStreams)
	{
		gunStreams = numStreams;
	}
	/**
	 * shoots a bullet from the playership
	 **/
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
	/**
	 * step method 
	 * @param gc - Gamecontainer object
	 **/
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
