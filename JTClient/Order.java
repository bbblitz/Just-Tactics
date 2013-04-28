package JTClient;

import java.io.Serializable;

import JTServer.Occupier;
import JTServer.Player;

public abstract class Order implements Serializable
{
	public abstract Occupier getUnit();
	public abstract void setUnit(Occupier o);
	public abstract Player getOwner();
}
