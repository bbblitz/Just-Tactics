package JTServer;

import java.io.Serializable;

public abstract class Occupier implements Serializable {
	/**
	 * 
	 */
	public Occupier(Location loc)
	{
		this.loc = loc;
	}
	/*Graphics ID's:
	 * -1 - Remove from map
	 * 0 - Error ID, appears as black & yellow striped block, should never appear in-game
	 * 1 - Rock
	 * 2 - Tree
	 * 3 - River
	 * 4 - Unit 1
	 * 5 - Unit 2
	 * 6 - Unit 3
	 */
	public int graphicID = 0;
	
	public Location loc = null;
	
	/*What should happen when the unit takes damage*/
	public abstract void takeDamage(int damage);
	

}
