
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class EventConcert extends JFrame implements ActionListener {
	JLabel stageLabel = new JLabel(new ImageIcon(getClass().getResource("/images/stage.png")));
	JToggleButton north1 = new JToggleButton("North");
	JToggleButton middle = new JToggleButton("Middle");
	JToggleButton south = new JToggleButton("South");
	//JFrame seatingDisplay = new JFrame();
	
	
	Seat [] middleSeating = new Seat[30];
	Seat [] southSeating = new Seat[30];
	Seat [] northSeating = new Seat[30];
	
	
	public static int ewx = 10;
	public static int ewy = 3;
	
	
	public EventConcert(){
		stageLabel.setOpaque(true);
       		stageLabel.setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		setLayout(new GridLayout(4,1));
		setSize(500, 500); 
		
		add(stageLabel);
		add(north1);
		add(middle);
		add(south);
		
		north1.addActionListener(this);
		middle.addActionListener(this);
		south.addActionListener(this);
	}
			
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == north1){
			north1.setEnabled(true);
			JFrame seatingDisplayNorth = new JFrame();
			seatingDisplayNorth = new SeatingDisplay(ewx,ewy);
			seatingDisplayNorth.setLayout(new BorderLayout());
			JPanel orderUNorth = new JPanel();
			seatingDisplayNorth.add(getNSeating(ewx,ewy), BorderLayout.CENTER);
			seatingDisplayNorth.add(orderUNorth, BorderLayout.EAST);
			orderUNorth.setLayout(new BorderLayout());
		    orderUNorth.add(new Order(northSeating), BorderLayout.NORTH);	
		}
		
		else if(e.getSource() == middle){
			middle.setEnabled(true);
			JFrame seatingDisplayMiddle = new JFrame();
			seatingDisplayMiddle = new SeatingDisplay(ewx,ewy);
			seatingDisplayMiddle.setLayout(new BorderLayout());
			JPanel orderMiddle = new JPanel();
			seatingDisplayMiddle.add(getNSeating(ewx,ewy), BorderLayout.CENTER);
			seatingDisplayMiddle.add(orderMiddle, BorderLayout.EAST);
			orderMiddle.setLayout(new BorderLayout());
		    orderMiddle.add(new Order(northSeating), BorderLayout.NORTH);
		}
		else if (e.getSource() == south){
			south.setEnabled(true);
			JFrame seatingDisplaySouth = new JFrame();
			seatingDisplaySouth = new SeatingDisplay(ewx,ewy);
			seatingDisplaySouth.setLayout(new BorderLayout());
			JPanel orderSouth = new JPanel();
			seatingDisplaySouth.add(getNSeating(ewx,ewy), BorderLayout.CENTER);
			seatingDisplaySouth.add(orderSouth, BorderLayout.EAST);
			orderSouth.setLayout(new BorderLayout());
		    orderSouth.add(new Order(northSeating), BorderLayout.NORTH);
		}
		
	}
	
	public JComponent getNSeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < northSeating.length; i++) {
	      northSeating[i] = new Seat();
	      northSeating[i].setPrice(20.0);
	      northSeating[i].setText("");
	      gridSeats.add(northSeating[i]);
	    }
	    return gridSeats;
	  }

	
	public JComponent getMSeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < middleSeating.length; i++) {
	      middleSeating[i] = new Seat();
	      middleSeating[i].setPrice(15.0);
	      middleSeating[i].setText("");
	      gridSeats.add(middleSeating[i]);
	    }
	    return gridSeats;
	  }
	
	public JComponent getSSeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < southSeating.length; i++) {
	      southSeating[i] = new Seat();
	      southSeating[i].setPrice(10.0);
	      southSeating[i].setText("");
	      gridSeats.add(southSeating[i]);
	    }
	    return gridSeats;
	  }

	
	public static void main (String [] args){
		new EventConcert().setVisible(true);
		
	}
	
	

}

