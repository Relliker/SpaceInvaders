package logic;

import java.util.ArrayList;

import objects.Invader;

public class Waves implements Constants
{

	static ArrayList<Invader> wave1 = null;

	static ArrayList<Invader> wave2 = null;

	public static ArrayList<Invader> getWave(final int wave)
	{
		switch (wave)
		{
			case 1:
			{
				return wave1();
			}
			default:
			{
				return null;
			}
		}
	}

	public static ArrayList<Invader> wave1()
	{
		wave1 = new ArrayList<Invader>();
		final int rowSpacing = (int) ((windowY * .25) / 4);
		final int colSpacing = (int) ((windowX * .5) / 10);
		for (int col = 0; col < 10; col++) {
			for (int row = 0; row < 5; row++) {
				wave1.add(new Invader(col * colSpacing, (row * rowSpacing) + 50, 100));
			}
		}
		return wave1;
	}

	public static ArrayList<Invader> wave2()
	{
		wave2 = new ArrayList<Invader>();
		final int rowSpacing = (int) ((windowY * .25) / 4);
		final int colSpacing = (int) ((windowX * .5) / 10);
		for (int col = 0; col < 10; col++) {
			for (int row = 0; row < 5; row++) {
				wave2.add(new Invader(col * colSpacing, (row * rowSpacing) + 50, 150));
			}
		}
		return wave2;
	}

	ArrayList<Invader> wave3 = null;
	ArrayList<Invader> wave4 = null;
	ArrayList<Invader> wave5 = null;
	ArrayList<Invader> wave6 = null;
	ArrayList<Invader> wave7 = null;
	ArrayList<Invader> wave8 = null;

	ArrayList<Invader> wave9 = null;

	ArrayList<Invader> wave10 = null;
}
