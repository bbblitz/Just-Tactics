package JTServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class GameManager 
{
	
	public static final int GAME_INITIALIZEING = 0;
	
	public static final int GAME_WAITING1 = 1;
	public static final int GAME_WAITING2 = 2;
	public static final int GAME_WAITING3 = 3;
	public static final int GAME_WAITING4 = 4;
	
	public static final int GAME_SETUP = 5;
	public static final int GAME_RUNNING = 6;
	public static final int GAME_CLEANUP = 7;
	
	public static final int GAME_FAILED = -1;

	public Player[] players = new Player[4];
	private int state = 0;
	public static WorldManager wm;
	
	/*The states that the server can be in:
	 * 0 - Initializeing
	 * 1-4 - Waiting for players
	 * 5 - Pre-game setup
	 * 6 - Game running
	 * 7 - Game finished, cleaning up.
	 */
	public int getState()
	{
		return state;
	}
	public void setState(int t)
	{
		state = t;
	}
	
	/**Add a new player to the players array*/
	public void playerJoin(Socket s)
	{
		int x = 0;
		while(x < 4)
		{
			if(players[x] == null)
			{
				try {
					players[x] = new Player(s);
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Failed to add player");
				}
				break;
			}
			else
			{
				x++;
			}
		}
	}
	
	/*Check to see if this player is already connected*/
	public boolean hasConnection(Socket s)
	{
		InetAddress other = s.getInetAddress();
		for(Player ply : players)
		{
			if(ply != null)
			{
				InetAddress cur = ply.getSocket().getInetAddress();
				if(cur.equals(other))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public void startGame()
	{
		while(this.state == GameManager.GAME_RUNNING || this.state == GameManager.GAME_CLEANUP)
		{
			
		}
	}
	
	public void setup()
	{
		wm = new WorldManager();
	}
}
