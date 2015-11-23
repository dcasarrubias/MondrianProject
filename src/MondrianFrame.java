/*
 * David Casarrubias-Mena
 * Sinclair Fuh
 * April 12, 2015
 * COSC 130
 */

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MondrianFrame extends JFrame{
		private static long serialVersionUID;
		 public MondrianPanel panel; // creates instance of class MondrianPanel
		
		public MondrianFrame(){  // constructor for MondrianFrame
			MondrianPanel panel = new MondrianPanel(); // creates object of MondrianPanel
			JButton south = new JButton(new MondrianPanelAction(panel));  // creates new object of Button
			
			add(panel, BorderLayout.CENTER);  // adds panel to center of border layout
			add(south, BorderLayout.SOUTH);  // adds the button to the south on the screen
			
			setSize(600, 600);  //sets window size
			setVisible(true); // allows screen to be visible to user
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows user to close screen
			panel.redraw(); // calls method redraw from class MondrianPanel. 
			
		}
	
		
		
	}
	

