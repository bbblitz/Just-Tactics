package JTServer;

public class Tree extends Occupier {

	public Tree(Location loc) {
		super(loc);
		this.graphicID = 2;
	}
	
	public void takeDamage(int damage) 
	{
		this.graphicID = -1;
	}

}
