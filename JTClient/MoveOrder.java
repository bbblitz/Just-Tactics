package JTClient;

import JTServer.Location;
import JTServer.Occupier;
import JTServer.Player;

public class MoveOrder extends Order {

	Location loc;
	
	public MoveOrder()
	{
		loc = new Location(10,10);
	}
	
	/**Gets the unit to carry out the move order
	 * @return */
	public Occupier getUnit() {
		return null;
	}

	/**Sets the unit to carry out the move order
	 * @return */
	public void setUnit(Occupier o) {

	}
	
	/**Gets the location the unit should move to*/
	public Location getLocation(){
		return this.loc;
	}
	
	/**Sets the location the unit should move to*/
	public void setLocation(Location l){
		
	}

	public Player getOwner() {
		return null;
	}

}
