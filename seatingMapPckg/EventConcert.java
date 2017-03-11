package seatingMapPckg;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


/**
 * 
 * EventConcert: Concert event layout, sections, seats, sets prices
 * 
 * 
 * @author  Group 4; Amin Karabash, Andrew Duron, Alejandra Licon, Rafael Lopez
 * @version 1.0
 * @since   2017-03-10
 * 
 *
 */
public class EventConcert extends JFrame implements ActionListener {
	JLabel stageLabel = new JLabel(new ImageIcon(getClass().getResource("images/stage.png")));
	JToggleButton north = new JToggleButton("North");
	JToggleButton middle = new JToggleButton("Middle");
	JToggleButton south = new JToggleButton("South");
	//JFrame seatingDisplay = new JFrame();
	
	
	Seat [] middleSeating = new Seat[30];
	Seat [] southSeating = new Seat[30];
	Seat [] northSeating = new Seat[30];
	
	
	public static int conNx = 2;
	public static int conMx = 3;
	public static int conSx = 4;
	
	public static int conNy = 10;
	public static int conMy = 10;
	public static int conSy = 10;
	
	
	
	
	/**
	 * Constructor
	 * sets sections of the concert layout, north, middle, south, and adds them to a grid layout.
	 */
	public EventConcert(){
		stageLabel.setOpaque(true);
       		stageLabel.setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		setLayout(new GridLayout(4,1));
		setSize(500, 500); 
		
		add(stageLabel);
		add(north);
		add(middle);
		add(south);
		
		north.addActionListener(this);
		middle.addActionListener(this);
		south.addActionListener(this);
	}
			
	/* actionPerdormed, generates the seatingDisplays depending on clicked section.
	 * @param button(section) clicked
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == north){
			north.setEnabled(true);
			JFrame seatingDisplayNorth = new JFrame();
			seatingDisplayNorth = new SeatingDisplay(conNx,conNy);
			seatingDisplayNorth.setTitle(" North Section ");
		}
		
		else if(e.getSource() == middle){
			middle.setEnabled(true);
			JFrame seatingDisplayMiddle = new JFrame();
			seatingDisplayMiddle = new SeatingDisplay(conMx,conMy);
			seatingDisplayMiddle.setTitle(" Middle Section ");
			
		}
		else if (e.getSource() == south){
			south.setEnabled(true);
			JFrame seatingDisplaySouth = new JFrame();
			seatingDisplaySouth = new SeatingDisplay(conSx,conSy);
			seatingDisplaySouth.setTitle(" South Section ");
			
		}
		
	}
	
	

}

