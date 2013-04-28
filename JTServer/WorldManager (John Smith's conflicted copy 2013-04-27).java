package JTServer;

import JTClient.AttackOrder;
import JTClient.MoveOrder;
import JTClient.Order;

public class WorldManager {
	private Map m;
	
	/*Initialize anything you need*/
	public WorldManager()
	{
		m = new Map();
	}
	
	/*Process an order*/
	public void parseOrder(Order o)
	{
		if(o.getClass().isAssignableFrom(new AttackOrder().getClass()))
		{
			parseAttack((AttackOrder) o);
		}
		if(o.getClass().isAssignableFrom(new MoveOrder().getClass()))
		{
			parseMove((MoveOrder) o);
		}
	}
	
	public void parseAttack(AttackOrder o)
	{
		Character attacker = (Character) o.getUnit();
		if(isNextTo(o.getUnit().loc,o.getTarget().loc))
		{
			o.getTarget().takeDamage(attacker.attackDamage);
		}
	}
	
	public boolean isNextTo(Location l1, Location l2)
	{
		int xdif = l1.getX() - l2.getX();
		int ydif = l2.getY() - l1.getY();
		
		boolean isX = (xdif == 1 || xdif == -1);
		boolean isY = (ydif == 1 || ydif == -1);
		
		return (isX && isY);
	}
	
	public void parseMove(MoveOrder o)
	{
		Character mover = (Character) o.getUnit();
	}
	
	public boolean isInRange(Location l1, Location l2, int dist)
	{
		int xdif = l1.getX() - l2.getX();
		int ydif = l2.getY() - l1.getY();
		
		double xsqu = Math.pow(xdif, 2);
		double ysqu = Math.pow(ydif, 2);
		
		
		return (Math.pow(xsqu+ysqu, 0.5)<= dist);
	}
	
	/*Returns all Occupiers on the map, to return to the clients*/
	public Occupier[] getOccupiers()
	{
		return m.getOccupiers();
	}
	
	public boolean isGameFinished()
	{
		int ply = 0;
		for(Occupier o : m.getOccupiers())
		{
			if(o instanceof Character)
			{
				Character oc = (Character) o;
				if(ply == 0)
				{
					ply = oc.getOwner();
					
				}
				else
				{
					if(ply != oc.getOwner())
					{
						return false;
					}
				}
			}
		}
		return false;
	}
	

}
