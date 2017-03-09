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

	
	JFrame seatingDisplay = new JFrame();
	JPanel centerPanel = new JPanel();
	JPanel order = new JPanel();
	
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
	

	
	public EventGame() throws IOException{
		
		
		
		setTitle("Game Event Seating");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setSize(550,300);
		
		//Image img = ImageIO.read(getClass().getResource());
		//court.setIcon(new ImageIcon(img));
		//court.setContentAreaFilled(false);
		
		
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
		if(e.getSource() == north2 || e.getSource() == south2){
			seatingDisplay = new SeatingDisplay(nsx,y2);
			seatingDisplay.setLayout(new BorderLayout());
			seatingDisplay.add(getUpperNsSeating(nsx,y2), BorderLayout.CENTER);
			seatingDisplay.add(order, BorderLayout.EAST);
			order.setLayout(new BorderLayout());
		    order.add(new Order(upperNorthSeating), BorderLayout.NORTH);		
			
		}
		
		else if(e.getSource() == north1 || e.getSource() == south1){
			seatingDisplay = new SeatingDisplay(nsx, y1);
			seatingDisplay.setLayout(new BorderLayout());
			seatingDisplay.add(getNsSeating(nsx,y1), BorderLayout.CENTER);
			seatingDisplay.add(order, BorderLayout.EAST);
			order.setLayout(new BorderLayout());
		    order.add(new Order(northSeating), BorderLayout.NORTH);			
		}
		
		
		else if( e.getSource() == east || e.getSource() == west){
			seatingDisplay = new SeatingDisplay(ewx, ewy);
			seatingDisplay.setLayout(new BorderLayout());
			seatingDisplay.add(getEwSeating(ewx,ewy), BorderLayout.CENTER);
			seatingDisplay.add(order, BorderLayout.EAST);
			order.setLayout(new BorderLayout());
			Order eSeating = new Order(eastSeating);
		    order.add(eSeating, BorderLayout.NORTH);
		}
	}
	
	
	public JComponent getNsSeating( int x, int y) {
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
	
	
	public JComponent getUpperNsSeating( int x, int y) {
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
	
	
	public JComponent getEwSeating( int x, int y) {
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
	
	
	
	public static void main (String [] args) throws IOException{
		new EventGame().setVisible(true);
		
	}
	
	

}
	
	