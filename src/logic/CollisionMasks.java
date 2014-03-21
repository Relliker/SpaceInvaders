package logic;

import org.newdawn.slick.geom.Polygon;

public interface CollisionMasks
{

	public Polygon playerShipCollisionMask = new Polygon(new float[] {0, 304, 0, 279, 95, 189, 117,144 , 175, 0  ,192, 0  , 249, 63 , 249, 144 , 271,  189 , 366 , 279, 366,304 });
	public Polygon redInvaderCollisionMask = new Polygon(new float[] { 61, 337, 330, 337, 390, 160, 243, 0, 147, 0, 0, 160, 61, 337 });
	public Polygon invaderShotCollisionMask = new Polygon(new float[] {});
	public Polygon playerShotCollisionMask = new Polygon(new float[] {});
}
