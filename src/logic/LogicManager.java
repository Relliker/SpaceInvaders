package logic;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class LogicManager
{

	private static boolean isPaused = false;

	public static boolean isGamePaused()
	{
		return isPaused;
	}

	public static void update(final GameContainer gc)
	{
		final Input in = gc.getInput();
		if (in.isKeyPressed(Input.KEY_P)) isPaused = !isPaused;
		if (!isPaused) {
			ShipManager.step();
			EffectsManager.step();
			RenderManager.update(gc);
		} else RenderManager.paused(gc.getGraphics());

	}
}
