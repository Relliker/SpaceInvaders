package logic;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public interface Constants
{

	public final boolean debugMode = true;
	public final boolean showFPS = true;

	public final GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public final boolean fullscreen = true;
	public final int windowX = gd.getDisplayMode().getWidth();
	public final int windowY = gd.getDisplayMode().getHeight();
	public final int targetFPS = gd.getDisplayMode().getRefreshRate(); // Locks the refresh rate to the default screen
	public final int maxFrameTime = 100;
	public final int minFrameTime = 15;
	public final int multisample = 16;
	public final boolean vsync = true;
	public final boolean smoothDeltas = true;
	public final boolean antiAliasing = true;

	public final String resourcesPath = "Resources\\";
	public final String backgroundPath = resourcesPath + "backgrounds\\";
	public final String shipsPath = resourcesPath + "ships\\";
	public final String miscPath = resourcesPath + "misc\\";
	public final String effectsPath = resourcesPath + "effects\\";
	public final String celestialsPath = resourcesPath + "celestial_objects\\";

	public final boolean grabMouse = true;
	public final boolean music = true;
	public final boolean sound = true;

	public final String gameTitle = "Space Invaders - v0.1";

	public final int startLives = 3;
	public final double scale = windowX / 1000;

}
