package logic;

import org.newdawn.slick.geom.Polygon;

public interface CollisionMasks
{

	public Polygon playerShipCollisionMask = new Polygon(new float[] {});
	public Polygon redInvaderCollisionMask = new Polygon(new float[] { 61, 337, 330, 337, 390, 160, 243, 0, 147, 0, 0, 160, 61, 337 });
}
