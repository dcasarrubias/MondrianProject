/*
 * David Casarrubias-Mena
 * Sinclair Fuh
 * April 12, 2015
 * COSC 130
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public abstract class Shape {
	
	protected Color colour; // creates variable colour
	protected int height; // creates protected variable for height
	protected int width; // creates protected variable for width
	protected int x;  // creates protected variable for x
	protected int y;  // creates protected varibale for y
	
	
	public Shape(int x, int y, int width, int height, Color colour) { // constructor for shape
		this.x = x; // sets protected x variable equal to x
		this.y = y; // sets protected y variable equal to y
		this.width = width;  // sets protected width variable equal to width
		this.height = height; // sets protected height variable equal to height
		this.colour = colour; //sets protected colour variable equal to colour
	}
	public abstract void draw(Graphics g);
}
