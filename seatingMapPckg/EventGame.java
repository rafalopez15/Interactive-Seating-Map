package seatingMapPckg;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/** 
* This class implements the UI for selecting a seat section for both 
* game and concert event type.
* 
* 
* @author  Group 4; Amin Karabash, Andrew Duron, Alejandra Licon, Rafael Lopez
* @version 1.0
* @since   2017-03-10 
*  
*/



public class EventGame extends JFrame implements ActionListener {
	
	
	
	private JButton court = new JButton ();
	private JPanel centerPanel = new JPanel();
	
	// different buttons for the different seating sections 
	private JToggleButton north1 = new JToggleButton("North");
	private JToggleButton north2 = new JToggleButton("Upper North");
	private JToggleButton south1 = new JToggleButton("South");
	private JToggleButton south2 = new JToggleButton("Upper South");
	private JToggleButton west = new JToggleButton("West");
	private JToggleButton east = new JToggleButton("East");
	
	
	// dimensions for seating layout depending on section selection
	public static int nsx = 1;
	public static int y1 = 10;
	public static int y2 = 15;
	public static int ewx = 5;
	public static int ewy = 4;
	

	
	/** 
	 * This constructor create the interactive interface of the Game event. 
	 * The UI consists of 7 panels with 6 active buttons, each representing a section, and 
	 * a center button that is disabled with image of basketball court. 
	 * 
	 * 
	 */
	
	public EventGame() {
		
		
		setTitle("Game Event Seating");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setSize(670,350);

		court.setBorderPainted(false);
		court.setFocusPainted(false);
		court.setContentAreaFilled(false);
		ImageIcon img = new ImageIcon(getClass().getResource("images/bballCourt.jpeg"));
		court.setIcon(img);
		court.setDisabledIcon(img);
		Font font = new Font("MS Gothic", Font.BOLD, 26);
		court.setFont(font);
		court.setEnabled(false);

		
		//inner border layout 
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(north1, BorderLayout.NORTH);
		centerPanel.add(court, BorderLayout.CENTER);
		centerPanel.add(south1, BorderLayout.SOUTH);
		
		
		//outer border layout
		setLayout(new BorderLayout());
		add(north2, BorderLayout.NORTH);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		add(south2, BorderLayout.SOUTH);
	

		// actionListeners for buttons  
		north1.addActionListener(this);
		north2.addActionListener(this);
		south1.addActionListener(this);
		south2.addActionListener(this);
		east.addActionListener(this);
		west.addActionListener(this);
		
	}
	
	/** 
	 * This method processes the action events of clicking a section button.
	 * 
	 * @param e This is the action of clicking on one of the buttons
	 */
	
	public void actionPerformed(ActionEvent e) {
		// depending on which button is pressed,
		// open up new window with seating display
		if(e.getSource() == north2 ){
			JFrame seatingDisplayUNorth = new SeatingDisplay(nsx,y2);
			seatingDisplayUNorth.setTitle(" Nosebleeds (NORTH) ");
		}
		else if (e.getSource() == south2){
			south2.setEnabled(true);
			JFrame seatingDisplayUSouth = new SeatingDisplay(nsx,y2);
			seatingDisplayUSouth.setTitle(" Nosebleeds (SOUTH) ");
		}
		else if(e.getSource() == north1){
			north1.setEnabled(true);
			JFrame seatingDisplayNorth = new SeatingDisplay(nsx, y1);
			seatingDisplayNorth.setTitle(" Court Side (NORTH) ");
		}
		else if (e.getSource() == south1){
			south1.setEnabled(true);
			JFrame seatingDisplaySouth = new SeatingDisplay(nsx, y1);
			seatingDisplaySouth.setTitle(" Court Side (SOUTH) ");
		}
		else if( e.getSource() == east){
			east.setEnabled(true);
			JFrame seatingDisplayEast = new SeatingDisplay(ewx, ewy);
			seatingDisplayEast.setTitle(" Behind the Basket (EAST) ");
		}
		else if( e.getSource() == west){
			west.setEnabled(true);
			JFrame seatingDisplayWest = new SeatingDisplay(ewx,ewy);
			seatingDisplayWest.setTitle(" Behind the Basket (WEST) ");
		}
	}
	
	
	//public static void main (String [] args) {
	//	new EventGame().setVisible(true);
		
	//}
	
	

}
	
	