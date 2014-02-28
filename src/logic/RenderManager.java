package logic;

import objects.Invader;
import objects.PlayerShip;

import org.lwjgl.util.Point;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class RenderManager implements Constants, CollisionMasks
{

	private static int frame = 0; // For debug & info only

	private static Image background;

	private static Image scoreBackground;
	private static Image redInvader;
	private static Image greenInvader;
	private static PlayerShip player = new PlayerShip(100, 100, 100, 5, new Point(windowX / 2, windowY - 100), 5);

	private static void drawAIShips(final Graphics g)
	{
		if (ShipManager.getInvaders() == null) return;
		for (final Invader current : ShipManager.getInvaders())
			g.texture(new Rectangle(current.getX(), current.getY(), 64, 64), redInvader, true);
	}

	public static void drawBackgrounds(final Graphics g)
	{
		g.drawImage(background, 0, 0, windowX, windowY, 0, 0, windowX, windowY);
		g.drawImage(scoreBackground, 0, 0, windowX, 40, 0, 0, windowX * 2, 160);
	}

	private static void drawPlayerShips(final Graphics g)
	{
		player.draw(g);
	}

	private static void drawText(final Graphics g)
	{
		// NOTE: Each char is 8 pixels wide and 8 pixels tall
		if (debugMode)
			g.drawString("Frame: " + frame + "   Wave: " + ShipManager.getWave() + "  Lives: " + ShipManager.getLives(), 100, 10);
		else g.drawString("Wave: " + ShipManager.getWave() + "  Lives: " + ShipManager.getLives(), 100, 10);
	}

	public static void loadResources(final Graphics g) throws SlickException
	{
		background = new Image(resourcesPath + backgroundPath + "stars1.jpg");
		scoreBackground = new Image(resourcesPath + miscPath + "metalbeam2.jpg");
		redInvader = new Image(resourcesPath + shipsPath + "redinvader.png");
		redInvader = redInvader.getFlippedCopy(false, true);
		greenInvader = new Image(resourcesPath + shipsPath + "greenInvader.png");
		greenInvader = greenInvader.getFlippedCopy(false, true);
	}

	public static void nextRender(final Graphics g)
	{
		g.setClip(0, 0, windowX, windowY);
		drawBackgrounds(g);
		drawText(g);
		drawAIShips(g);
		drawPlayerShips(g);
		EffectsManager.draw(g);
		frame++;
	}

	public static void paused(final Graphics g)
	{
		g.drawString("PAUSED", windowX / 2, windowY / 2);
	}

	public static void update(final GameContainer gc)
	{
		player.step(gc);
	}
}
