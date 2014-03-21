package logic;

import objects.Invader;
import objects.PlayerShip;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class RenderManager implements Constants, CollisionMasks
{

	private static int frame = 0; // For debug & info only

	private static Image background;

	private static Image scoreBackground;
	private static Image redInvader;
	private static Image greenInvader;

	private static void drawAIShips(final Graphics g)
	{
		if (ShipManager.getInvaders() == null) return;
		for (final Invader current : ShipManager.getInvaders())
			current.draw(g);
	}

	public static void drawBackgrounds(final Graphics g)
	{
		if (!debugMode) g.drawImage(background, 0, 0, windowX, windowY, 0, 0, windowX, windowY);
		g.drawImage(scoreBackground, 0, 0, windowX, 40, 0, 0, windowX * 2, 160);
	}

	private static void drawBars(Graphics g)
	{
		PlayerShip ps = ShipManager.getPlayerShip();
		Color temp = g.getColor();
		g.setColor(org.newdawn.slick.Color.green);
		g.drawRect((float) (5 * scale), (float) (windowY - (100 * scale)), (float) ((ps.getHullStrength() / ps.getMaxHullStrength()) * (100 * scale)), (float) (25 * scale));
		g.setColor(temp);
	}

	private static void drawPlayerShips(final Graphics g)
	{
		ShipManager.getPlayerShip().draw(g);
	}

	private static void drawText(final Graphics g)
	{
		// NOTE: Each char is 8 pixels wide and 8 pixels tall
		if (debugMode) g.drawString("Frame: " + frame + "   Wave: " + ShipManager.getWave() + "  Lives: " + ShipManager.getLives() + "       DEBUG MODE", 100, 10);
		else g.drawString("Wave: " + ShipManager.getWave() + "  Lives: " + ShipManager.getLives(), 100, 10);
	}

	public static void loadResources(final Graphics g) throws SlickException
	{
		background = new Image(backgroundPath + "stars1.jpg");
		scoreBackground = new Image(miscPath + "metalbeam2.jpg");
		redInvader = new Image(shipsPath + "redinvader.png");
		redInvader = redInvader.getFlippedCopy(false, true);
		greenInvader = new Image(shipsPath + "greenInvader.png");
		greenInvader = greenInvader.getFlippedCopy(false, true);
	}

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

	public static void paused(final Graphics g)
	{
		g.drawString("PAUSED", windowX / 2, windowY / 2);
	}

}
