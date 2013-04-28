package JTServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import JTClient.Order;

public class Player {
	
	public Socket connectionToClient;
	public Occupier[] units;
	public OutputStream out;
	public PrintWriter writer;
	public BufferedReader reader;
	public InputStream in;
	public String address;
	
	public Player(Socket s) throws IOException
	{
		/**get all the informaton we need when the player is made*/
		connectionToClient = s;
		in = connectionToClient.getInputStream();
		out = connectionToClient.getOutputStream();
		address = connectionToClient.getInetAddress().toString();
		writer = new PrintWriter(out,true);
		reader = new BufferedReader(new InputStreamReader(in));
		

		int data = -2;
		/**Read stuff as soon as the socket is made*/
		try
		{
			data = reader.read();
			System.out.println("outputed :" + data);
			writer.print(data);
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("Got data from " + address);
	}
	
	public Socket getSocket()
	{
		return connectionToClient;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	private String getNewMessage()
	{
		String output = "";
		int newnum = -1;
		
		do
		{
			try 
			{
				newnum = reader.read();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			if(newnum != -1)
			{
				output += newnum;
			}
		}
		while(newnum != -1);
		return output;
	}

}
