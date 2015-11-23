/*
 * David Casarrubias-Mena
 * Sinclair Fuh
 * April 12, 2015
 * COSC 130
 */

import java.awt.Color;
import java.awt.Graphics;

public class FilledRectangle extends Shape {
	public FilledRectangle(int x, int y, int width, int height, Color colour){ // constructor for class FilledRectangle
		super(x, y, width, height, colour); // inherits constructor from class Shape
	}
	
	public void draw(Graphics g){ // method that allows user to draw a filled rectangle
		g.setColor(colour); // sets the color for the  rectangle 
		g.fillRect(x, y, width, height); // draws the actual rectangle
		
	}
}
