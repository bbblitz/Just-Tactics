package JTServer;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

	
	public void listenSocket(){
		  ServerSocket server = null;
		try{
		    server = new ServerSocket(4321); 
		  } catch (IOException e) {
		    System.out.println("Could not listen on port 4321");
		    System.exit(-1);
		  }

		  Socket client = null;
		try{
		    client = server.accept();
		  } catch (IOException e) {
		    System.out.println("Accept failed: 4321");
		    System.exit(-1);
		  }

		BufferedReader in = null;
		PrintWriter out = null;
		  try{
		  in = new BufferedReader(new InputStreamReader(
		                           client.getInputStream()));
		   out = new PrintWriter(client.getOutputStream(), 
		                         true);
		  } catch (IOException e) {
		    System.out.println("Read failed");
		    System.exit(-1);
		  }

		    while(true){
		      try{
		        Object line = in.readLine();
		//Send data back to client
		        out.println(line);
		      } catch (IOException e) {
		        System.out.println("Read failed");
		        System.exit(-1);
		      }
		    }
	}
}
