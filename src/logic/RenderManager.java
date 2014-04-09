package logic;

import objects.Invader;
import objects.PlayerShip;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
/**
 * manages rendering.  
 */
public class RenderManager implements Constants, CollisionMasks
{

	private static int frame = 0; // For debug & info only

	private static Image background;

	private static Image scoreBackground;
	private static Image redInvader;
	private static Image greenInvader;
	/**
	 * draws the AI ships. Computer ships.
	 * @param g - graphics to use.
	 */
	private static void drawAIShips(final Graphics g)
	{
		if (ShipManager.getInvaders() == null) return;
		for (final Invader current : ShipManager.getInvaders())
			current.draw(g);
	}


	/**
	 * draws the backgrounds.
	 * @param g - graphics to use.
	 */
	public static void drawBackgrounds(final Graphics g)
	{
		if (!debugMode) g.drawImage(background, 0, 0, windowX, windowY, 0, 0, windowX, windowY);
		g.drawImage(scoreBackground, 0, 0, windowX, 40, 0, 0, windowX * 2, 160);
	}
	
	
	/**
	 * draws the bar for hull strength
	 * @param g - graphics to use.
	 */
	private static void drawBars(Graphics g)
	{
		PlayerShip ps = ShipManager.getPlayerShip();
		Color temp = g.getColor();
		g.setColor(org.newdawn.slick.Color.green);
		g.drawRect((float) (5 * scale), (float) (windowY - (100 * scale)), (float) ((ps.getHullStrength() / ps.getMaxHullStrength()) * (100 * scale)), (float) (25 * scale));
		g.setColor(temp);
	}
	
	/**
	 * draws the player ship
	 * @param g - graphics to use.
	 */
	private static void drawPlayerShips(final Graphics g)
	{
		ShipManager.getPlayerShip().draw(g);
	}

	/**
	 * draws the text for the top bar.
	 * @param g - graphics to use.
	 */
	private static void drawText(final Graphics g)
	{
		// NOTE: Each char is 8 pixels wide and 8 pixels tall
		if (debugMode) g.drawString("Frame: " + frame + "   Wave: " + ShipManager.getWave() + "  Lives: " + ShipManager.getLives() + "       DEBUG MODE", 100, 10);
		else g.drawString("Wave: " + ShipManager.getWave() + "  Lives: " + ShipManager.getLives(), 100, 10);
	}
		
	/**
	 * loads the images.
	 */
	public static void loadResources() throws SlickException
	{
		background = new Image(backgroundPath + "stars1.jpg");
		scoreBackground = new Image(miscPath + "metalbeam2.jpg");
		redInvader = new Image(shipsPath + "redinvader.png");
		redInvader = redInvader.getFlippedCopy(false, true);
		greenInvader = new Image(shipsPath + "greenInvader.png");
		greenInvader = greenInvader.getFlippedCopy(false, true);
	}
	
	/**
	 * Runs the next Render.
	 * @param g - graphics to use.
	 */
	public static void nextRender(final Graphics g)
	{
		g.setClip(0, 0, windowX, windowY);
		drawBackgrounds(g);
		drawText(g);
		drawBars(g);
		drawAIShips(g);
		EffectsManager.draw(g);
		drawPlayerShips(g);
		frame++;
	}
	
		
	/**
	 * Shows the word paused. used when game is paused
	 * @param g - graphics to use.
	 */
	public static void paused(final Graphics g)
	{
		g.drawString("PAUSED", windowX / 2, windowY / 2);
	}

}
