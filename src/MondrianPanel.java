/*
 * David Casarrubias-Mena
 * Sinclair Fuh
 * April 12, 2015
 * COSC 130
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel; // imports JPanel

public class MondrianPanel extends JPanel {
	private static long serialVersionUID;
	
	private static int colours;  // variable for color
	private static int split_chance;  
	private static int minimum_width; // instance variable that allows user to set minimum width later
	private static int minimum_height; // instance variable allows user to set minimum height later
	private static int line_width;  // variable for the width of the line
	private static double smallest_ratio; // variable that will set smallest ratio later
	private static  Random oracle;	 // creates Random generator called oracle
	
	private List<Shape> elements; // creates list that is able to store elements
	
	public MondrianPanel(){ // constructor for MondrianPanel
		oracle = new Random();  // creates random number generator 
		elements=new ArrayList<Shape>(); // creates new object of elements

	}
	
	static{ // method to initialize all private static variables creates earlier
		colours = 4;  // sets number of colors to choose from to 4
		minimum_width = 60;   // sets minimum width to 60
		minimum_height = 60; // sets minimum height to 60
		smallest_ratio = 1.0/4.0; // sets smallest ratio to 1:4
		split_chance = 4;  // sets split chance to 4
		line_width = 5;  // sets width of line to 5
	}
	
	
	public void fillSpace(int x, int y, int width, int height){
		Color colour; // variable for color
		int r; // variable that will be used for switch statement

		r = oracle.nextInt(colours); // generates random number of the number of colors set by user
		
	 switch (r) { // switch statement that selects color randomly from generator above
		
		case 0:colour = Color.YELLOW; // option 1 generates yellos
		break;
			
		case 1: colour = Color.BLUE;  // option 2 generates blue color
			break;
			
		case 2:  colour = Color.RED;  // option 3 generates red color
			break;
		
		default : colour = Color.WHITE;  // option 4 generates white color
		
		}
		elements.add(new FilledRectangle(x, y, width, height, colour)); // adds elements 
	}
	
	public void drawBroadLine(boolean vertical, int x, int y, int distance){ // method that draws boradLine
		if (vertical){  // if random lands on vertical it will split vertically and perform the following actions
			elements.add(new FilledRectangle(x - line_width/2, y, line_width, distance, Color.black));
		
		}
		else{ // if random lands on horizontal it will split horizontally and perform this action
			elements.add(new FilledRectangle(x, y - line_width/2, distance, line_width, Color.black));
		}	
		
	}
	
	private int pickSplitPoint(int total, int minimum){
		Random oracle = new Random(); // creates random so it can be used by user
		int num = oracle.nextInt(total); //  // generates random number selected from total
		
			while(total - num < minimum * smallest_ratio || num < minimum * smallest_ratio){ // while total - num is less than minimum generate another number from total
				num = oracle.nextInt(total);
			}
			return num; // return num
	}
	
	private void split(int x, int y, int width, int height){ // method that splits
		int num_1; // variable
		int location_of_split; // variable for location of split
		num_1 = oracle.nextInt(split_chance); // generate random number selected from split chance
		
		if(num_1 == 1){ // if number generated is 1
			fillSpace(x,y,width,height);
		}

		else if (width < minimum_width){
			fillSpace(x,y,width,height);
		}
		
		else if (height < minimum_height){
			fillSpace(x,y,width,height);

		}
		else if(oracle.nextBoolean()){
			location_of_split= pickSplitPoint(width,minimum_width);
			split(x,y,location_of_split,height);
			split(x + location_of_split,y,width - location_of_split,height);
			drawBroadLine(true,x + location_of_split,y, height);
		}
		else{
			location_of_split = pickSplitPoint(height, minimum_height);
			split(x,y,width, location_of_split);
			split(x,y+location_of_split,width,height-location_of_split);
			drawBroadLine(false,x, y + location_of_split, width);
		}
			
}
public void redraw() { // method that redraws
	elements = new ArrayList<Shape>();  // creates new elements instance
	split(0,0,getWidth(),getHeight()); 
	repaint();  // repaints method is called
}
		
	public void paintComponent(Graphics g){ // method to draw
		super.paintComponent(g); // allows user to draw
		for(Shape element: elements){ // enhanced for loop 
			element.draw(g);

		}
	}
	
	
}
