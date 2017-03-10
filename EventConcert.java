
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


/**
 * @author Group 4
 * Last Updated: 3/10/2017
 * EventConcert: Concert event layout, sections, seats, sets prices
 *
 */
public class EventConcert extends JFrame implements ActionListener {
	JLabel stageLabel = new JLabel(new ImageIcon(getClass().getResource("/images/stage.png")));
	JToggleButton north = new JToggleButton("North");
	JToggleButton middle = new JToggleButton("Middle");
	JToggleButton south = new JToggleButton("South");
	//JFrame seatingDisplay = new JFrame();
	
	
	Seat [] middleSeating = new Seat[30];
	Seat [] southSeating = new Seat[30];
	Seat [] northSeating = new Seat[30];
	
	
	public static int conx = 10;
	public static int conNy = 2;
	public static int conMy = 3;
	public static int conSy = 4;
	
	
	
	
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
			seatingDisplayNorth = new SeatingDisplay(conx,conNy);
			seatingDisplayNorth.setTitle(" North Section ");
		}
		
		else if(e.getSource() == middle){
			middle.setEnabled(true);
			JFrame seatingDisplayMiddle = new JFrame();
			seatingDisplayMiddle = new SeatingDisplay(conx,conMy);
			seatingDisplayMiddle.setTitle(" Middle Section ");
			
		}
		else if (e.getSource() == south){
			south.setEnabled(true);
			JFrame seatingDisplaySouth = new JFrame();
			seatingDisplaySouth = new SeatingDisplay(conx,conSy);
			seatingDisplaySouth.setTitle(" South Section ");
			
		}
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main (String [] args){
		new EventConcert().setVisible(true);
		
	}
	
	

}

