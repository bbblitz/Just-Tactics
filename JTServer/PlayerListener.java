package JTServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class PlayerListener implements Runnable{
	public static WorldManager wm;
	private Socket sock;
	private InputStream stream;
	@Override
	public void run() {
		try {
			stream = sock.getInputStream();
		} catch (IOException e) {
			System.out.println("Failed to get input stream for " + sock.getInetAddress().toString());
			e.printStackTrace();
		}
		
		
	}
	public void setSocket(Socket s)
	{
		sock = s;
	}

}
