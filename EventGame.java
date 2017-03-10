import javax.swing.*;
import java.awt.event.*;
import java.awt.*;




public class EventGame extends JFrame implements ActionListener {
	
	
	private String statusBar = " Please Select Section ";
	private JButton court = new JButton (statusBar);

	
	public static int northCtr = 0;
	public static int upperNorthCtr = 0;
	public static int southhCtr = 0;
	public static int upperSouthCtr = 0;
	public static int westCtr = 0;
	public static int eastCtr = 0;
	
	Seat [] northSeating = new Seat[5];
	Seat [] southSeating = new Seat[5];
	Seat [] upperNorthSeating = new Seat[10];
	Seat [] upperSouthSeating = new Seat[10];
	Seat [] eastSeating = new Seat[30];
	Seat [] westSeating = new Seat[30];

	
	
	JPanel centerPanel = new JPanel();
	
	
	JToggleButton north1 = new JToggleButton("North");
	JToggleButton north2 = new JToggleButton("Upper North");
	JToggleButton south1 = new JToggleButton("South");
	JToggleButton south2 = new JToggleButton("Upper South");
	JToggleButton west = new JToggleButton("West");
	JToggleButton east = new JToggleButton("East");
	
	
	public static int nsx = 1;
	public static int y1 = 5;
	public static int y2 = 15;
	public static int ewx = 10;
	public static int ewy = 3;
	

	
	public EventGame() {
		
		
		
		setTitle("Game Event Seating");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setSize(550,300);

		court.setBorderPainted(false);
		court.setFocusPainted(false);
		court.setContentAreaFilled(false);
		court.setIcon(new ImageIcon(getClass().getResource("images/bball.png")));
		court.setDisabledIcon(new ImageIcon(getClass().getResource("images/bball.png")));

		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(north1, BorderLayout.NORTH);
		centerPanel.add(court, BorderLayout.CENTER);
		Font font = new Font("MS Gothic", Font.BOLD, 26);
		court.setFont(font);
		court.setEnabled(false);
		
		centerPanel.add(south1, BorderLayout.SOUTH);
		
		
		north1.setForeground(Color.BLACK);
		
		
		
		setLayout(new BorderLayout());
		add(north2, BorderLayout.NORTH);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		add(south2, BorderLayout.SOUTH);
	

		north1.addActionListener(this);
		north2.addActionListener(this);
		south1.addActionListener(this);
		south2.addActionListener(this);
		east.addActionListener(this);
		west.addActionListener(this);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == north2 ){
			
			JFrame seatingDisplayUNorth = new JFrame();
			seatingDisplayUNorth = new SeatingDisplay(nsx,y2);
			seatingDisplayUNorth.setLayout(new BorderLayout());
			JPanel orderUNorth = new JPanel();
			seatingDisplayUNorth.add(getUpperNSeating(nsx,y2), BorderLayout.CENTER);
			seatingDisplayUNorth.add(orderUNorth, BorderLayout.EAST);
			orderUNorth.setLayout(new BorderLayout());
		    orderUNorth.add(new Order(upperNorthSeating), BorderLayout.NORTH);	
		    //seatingDisplayUNorth.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    north2.setEnabled(true);
			
		}
		else if (e.getSource() == south2){
			south2.setEnabled(true);
			JFrame seatingDisplayUSouth = new JFrame();
			JPanel orderUSouth = new JPanel();
			seatingDisplayUSouth = new SeatingDisplay(nsx,y2);
			seatingDisplayUSouth.setLayout(new BorderLayout());
			seatingDisplayUSouth.add(getUpperSSeating(nsx,y2), BorderLayout.CENTER);
			seatingDisplayUSouth.add(orderUSouth, BorderLayout.EAST);
			orderUSouth.setLayout(new BorderLayout());
		    orderUSouth.add(new Order(upperSouthSeating), BorderLayout.NORTH);	
		}
		
		else if(e.getSource() == north1){
			north1.setEnabled(true);
			JFrame seatingDisplayNorth = new JFrame();
			JPanel orderNorth = new JPanel();
			seatingDisplayNorth = new SeatingDisplay(nsx, y1);
			seatingDisplayNorth.setLayout(new BorderLayout());
			seatingDisplayNorth.add(getNSeating(nsx,y1), BorderLayout.CENTER);
			seatingDisplayNorth.add(orderNorth, BorderLayout.EAST);
			orderNorth.setLayout(new BorderLayout());
		    orderNorth.add(new Order(northSeating), BorderLayout.NORTH);
		}
		
		else if (e.getSource() == south1){
			south1.setEnabled(true);
			JFrame seatingDisplaySouth = new JFrame();
			JPanel orderSouth = new JPanel();
			seatingDisplaySouth = new SeatingDisplay(nsx, y1);
			seatingDisplaySouth.setLayout(new BorderLayout());
			seatingDisplaySouth.add(getSSeating(nsx,y1), BorderLayout.CENTER);
			seatingDisplaySouth.add(orderSouth, BorderLayout.EAST);
			orderSouth.setLayout(new BorderLayout());
		    orderSouth.add(new Order(southSeating), BorderLayout.NORTH);			
		}
		
		else if( e.getSource() == east){
			east.setEnabled(true);
			JFrame seatingDisplayEast = new JFrame();
			JPanel orderEast = new JPanel();
			seatingDisplayEast = new SeatingDisplay(ewx, ewy);
			seatingDisplayEast.setLayout(new BorderLayout());
			seatingDisplayEast.add(getESeating(ewx,ewy), BorderLayout.CENTER);
			seatingDisplayEast.add(orderEast, BorderLayout.EAST);
			orderEast.setLayout(new BorderLayout());
			Order eSeating = new Order(eastSeating);
		    orderEast.add(eSeating, BorderLayout.NORTH);
		}
		
		else if( e.getSource() == west){
			JFrame seatingDisplayWest = new JFrame();
			JPanel orderWest = new JPanel();
			seatingDisplayWest = new SeatingDisplay(ewx, ewy);
			seatingDisplayWest.setLayout(new BorderLayout());
			seatingDisplayWest.add(getWSeating(ewx,ewy), BorderLayout.CENTER);
			seatingDisplayWest.add(orderWest, BorderLayout.EAST);
			orderWest.setLayout(new BorderLayout());
			Order wSeating = new Order(westSeating);
		    orderWest.add(wSeating, BorderLayout.NORTH);
		    west.setEnabled(true);
		}
	}
	
	
	public JComponent getNSeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < northSeating.length; i++) {
	      northSeating[i] = new Seat();
	      northSeating[i].setPrice(15.0);
	      northSeating[i].setText("");
	      gridSeats.add(northSeating[i]);
	    }
	    return gridSeats;
	  }
	
	public JComponent getSSeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < southSeating.length; i++) {
	      southSeating[i] = new Seat();
	      southSeating[i].setPrice(15.0);
	      southSeating[i].setText("");
	      gridSeats.add(southSeating[i]);
	    }
	    return gridSeats;
	  }
	
	
	public JComponent getUpperSSeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < upperSouthSeating.length; i++) {
	      upperSouthSeating[i] = new Seat();
	      upperSouthSeating[i].setPrice(10.0);
	      upperSouthSeating[i].setText("");
	      gridSeats.add(upperSouthSeating[i]);
	    }
	    return gridSeats;
	  }
	
	
	public JComponent getUpperNSeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < upperNorthSeating.length; i++) {
	      upperNorthSeating[i] = new Seat();
	      upperNorthSeating[i].setPrice(10.0);
	      upperNorthSeating[i].setText("");
	      gridSeats.add(upperNorthSeating[i]);
	    }
	    return gridSeats;
	  }
	
	public JComponent getESeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < eastSeating.length; i++) {
	      eastSeating[i] = new Seat();
	      eastSeating[i].setPrice(12.5);
	      eastSeating[i].setText("");
	      gridSeats.add(eastSeating[i]);
	    }
	    return gridSeats;
	  }
	
	public JComponent getWSeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < westSeating.length; i++) {
	      westSeating[i] = new Seat();
	      westSeating[i].setPrice(12.5);
	      westSeating[i].setText("");
	      gridSeats.add(westSeating[i]);
	    }
	    return gridSeats;
	  }
	
	
	
	public static void main (String [] args) {
		new EventGame().setVisible(true);
		
	}
	
	

}
	
	