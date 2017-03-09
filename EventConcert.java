

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
	
public class EventConcert extends JFrame implements ActionListener{

	private String statusBar = " Please Select Section ";
	private JButton court = new JButton (statusBar);
	
	Seat [] eastSeating = new Seat[30];
	Seat [] westSeating = new Seat[30];
	Seat [] middleSeating = new Seat[30];
	
	private JButton[][] grid = new JButton[3][1];

	public EventConcert(){
		
		for (int i = 0; i < 3; i++){
		      for (int j = 0; j < 1; j++) {
		        grid[i][j] = new JButton(" ");
		      }
		}
		
	}
	
	
	public JComponent getEastSeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < eastSeating.length; i++) {
	      eastSeating[i] = new Seat();
	      eastSeating[i].setPrice(15.0);
	      eastSeating[i].setText("");
	      gridSeats.add(eastSeating[i]);
	    }
	    return gridSeats;
	  }
}
