package JTServer;

public abstract class Character extends Occupier {

	public int health;
	public int speed;
	public int attackDamage;
	
	public int owner;
	public Character(Location loc, int owner) {
		super(loc);
		this.owner = owner;
	}

	
	
	public void takeDamage(int damage) {
		health -= damage;
		if(health <= 0)
		{
			this.graphicID = -1;
		}
	}
	
	public void setLocation(Location loc)
	{
		this.loc = loc;
	}
	
	public int getOwner()
	{
		return owner;
	}

}
