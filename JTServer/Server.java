package JTServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {

	/**Bytes to use for communication between server and client
	 * 
	 * 
	 * 0 - server ping - client checks to make sure server is still responding
	 * 1 - client ping - server checks to make sure client is still responding
	 * 
	 * 2 - client order - precedes an order generated by the client, going to the server
	 * 3 - request occupiers - sent from client to server to request occupiers
	 * 
	 * 4 - give occupiers - sent from server to client, precedes occupiers
	 * 
	 * 5 - give state - sent from client to server, server will respond with state(int)
	 */
	private static GameManager gm = new GameManager();
	private static ServerSocket server = null;
	
	public static void main(String[] args) throws IOException {
		gm.setState(GameManager.GAME_INITIALIZEING);
		try 
		{
			server = new ServerSocket(81);
			gm.setState(GameManager.GAME_WAITING1);
		} 
		catch (IOException e) 
		{
			gm.setState(GameManager.GAME_FAILED);
			e.printStackTrace();
		}
		/*Wait till there are 4 players ready*/
		while(gm.getState() < 2)//GameManager.GAME_SETUP)
		{
			Socket attempt = server.accept();
			/*Check to see if the player is already connected*/
			System.out.println("A player has attempted to connect");
			if(!gm.hasConnection(attempt))
			{
				gm.playerJoin(attempt);
				gm.setState(gm.getState()+1); /*Add one to the state*/
			}
			else
			{
				attempt.close();
			}
		}
		System.out.println("Enough players have connected, setting up game manager");
		gm.setup();
	}
}
