/*
 * David Casarrubias-Mena
 * Sinclair Fuh
 * April 12, 2015
 * COSC 130
 */

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class MondrianPanelAction extends AbstractAction{
	private static String name;  // variable name
	
	private static long serialVersionUID;
	
	static {
		name = "Redraw"; // sets name to draw
	}
	
	private MondrianPanel panel; // creates instance of class MondrianPanel
	
	public MondrianPanelAction(MondrianPanel panel){ // constructor for MondrianPanelAction class
		this.panel = panel;  // sets this.panel variable created from class MondrianPanel to panel 
		putValue(NAME,name);
	}
	
	public void actionPerformed(ActionEvent e){
		panel.redraw();  // calls redraw method from class MondrianPanel
	}
	
}
