package logic;

import java.util.ArrayList;

import objects.Invader;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import util.Point2;

/**
 * manages Invader waves.
 */
public class Waves implements Constants
{

	static double xScale = 1; // 1 means each invader is 32x32
	static double yScale = 1;
	static int currentWave = 1;
	static ArrayList<Point2> wave1Diamond;
	static ArrayList<Point2> wave2Circle;
	static ArrayList<Point2> wave3Star;
	static ArrayList<Point2> wave4Random;
	static ArrayList<Point2> wave5Square;
	static ArrayList<ArrayList<Point2>> waves;
	
	public Waves(){
		for(int i=0; i< 10; i++) for(int j=0; j< 10; j++)wave5Square.add(new Point2(i,j); //square

		for(int i=0; i<10; i+=9) for(int j=0;j<10;j++)wave2Circle.add(new Point2(i,j); //sides of circle
		
		for(int i=1; i<9; i++){
			for(int j=0; j<9; j+=9){
				wave2Circle.add(new Point2(i,j)); //top and bottom of circle
				wave4Random.add(new Point2(i,j)); //top and bottom of shape
			}
		} 
		
		for(int i=0; i<10; i+=9){
			wave4Random.add(new Point2(i,i)); 
			wave4Random.add(new Point2(i, 10-1)); 
			wave3Star.add(new Point2(i,i)); 
			wave3Star.add(new Point2(i, 10-1)); 
		}
		
		
		
		waves={wave1Diamond, wave2Circle, wave3Star, wave4Random, wave5Square};
	}
	/**
	 * inc waves
	 * @return - new wave
	 */
	public static ArrayList<Invader> getNextWave()
	{
		currentWave++;
		return makeWave(15, 5, 300 * (currentWave - 1));
	}

	/**
	 * makes a wave
	 * @return - new wave
	 */
	private static ArrayList<Invader> makeWave(int numCols, int numRows, int health)
	{
		Image texture = null;
		try {
			texture = new Image(shipsPath + "redinvader.png").getFlippedCopy(false, true);
		} catch (SlickException e) {
		}
		int topBuffer = (int) ((windowY / 15) * scale);
		int size = (int) ((windowX / 30) * scale);
		int spacing = (int) ((size / 5) * scale);
		ArrayList<Invader> wave = new ArrayList<Invader>(numCols * numRows);
		for (int row = 0; row < numRows; row++)
			for (int col = 0; col < numCols; col++)
				wave.add(new Invader(new Point2((col * size) + (col * spacing), (row * size) + (row * spacing) + topBuffer), size, health, texture));

		return wave;
	}
	
}
