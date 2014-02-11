package logic;

public class LogicManager
{

	private final static boolean isPaused = false;

	public static boolean isGamePaused()
	{
		return isPaused;
	}

	public static void update()
	{
		InvaderManager.step();
		EffectsManager.step();
		RenderManager.update();

	}
}
