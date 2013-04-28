package JTServer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Map {
	
	private boolean isScanned = false;
	LinkedList<Occupier> occupiers = new LinkedList<Occupier>();
	
	public void addUnit(Occupier o)
	{
		isScanned = false;
		occupiers.add(o);
	}
	public Occupier[] getOccupiers()
	{
		if(!isScanned)
		{
			scanOccupiers();
		}
		return  (Occupier[]) occupiers.toArray();
	}
	private void scanOccupiers()
	{
		Iterator i = occupiers.iterator();
		while(i.hasNext())
		{
			Occupier o = (Occupier) i.next();
			if(o.graphicID == -1)
			{
				i.remove();
			}
		}
		isScanned = true;
	}
	
	public String toString()
	{
		String output = "";
		
		for(Occupier o : getOccupiers)
		{
			output += String.format("(%2d,%2d)\t%2d\n",o.loc.getX(),o.loc.getY(),o.graphicID);
		}
		
		return output;
	}

}
