package JTClient;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JApplet;
import javax.swing.JButton;

import JTServer.Location;
import JTServer.Occupier;
import JTServer.Tree;

public class TestApplet extends JApplet
{
	  public void init() {
		    //WindowUtilities.setNativeLookAndFeel();
		    Container content = getContentPane();
		    content.setBackground(Color.white);
		    content.setLayout(new FlowLayout()); 
		    content.add(new JButton("Button 1"));
		    content.add(new JButton("Button 2"));
		    content.add(new JButton("Button 3"));
		  }
	  
	  public Occupier[] getOccupiers()
	  {
		  Occupier[] output = new Occupier[10];
		  for(int i = 0; i < 10; i++)
			  output[i] = new Tree(new Location(i,i));
		  return output;
	  }

}
