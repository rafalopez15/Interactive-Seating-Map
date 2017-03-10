import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class SeatingDisplay extends JFrame implements ActionListener  {

	public  Seat [] northSouthSeating = new Seat[5];
	public  Seat [] upperNorthSouthSeating = new Seat[10];
	public  Seat [] eastWestSeating = new Seat[30];
	
	
	private  Dimension upperD = new Dimension(1000,300);
	private  Dimension northSouthD = new Dimension(900,250);
	private  Dimension eastWestD = new Dimension(700,500);
	
	
	JButton done = new JButton("Checkout");
	public Order newOrder = new Order();
	public JComponent centralPanel = new JPanel();
	public JComponent centralPanel1 = new JPanel();
	public JComponent centralPanel2 = new JPanel();
	
	
	
	
	public SeatingDisplay(int x, int y){
		
		setTitle("Section");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		
		
		add(center);
		

		JPanel order = new JPanel();
		center.add(order, BorderLayout.EAST);
	    
		if(x == EventGame.nsx && y == EventGame.y2){
			centralPanel = getUpperNSSeating(EventGame.nsx,EventGame.y2);
			this.setSize(upperD);
			newOrder = new Order(upperNorthSouthSeating);
			center.add(centralPanel, BorderLayout.CENTER);
			center.add(order, BorderLayout.EAST);
			order.add(newOrder);
		    done.addActionListener(this);
		    order.add(done);
			JFrame checkout = new JFrame();
		}
		if(x == EventGame.nsx && y == EventGame.y1){
			centralPanel1 = getNSSeating(EventGame.nsx,EventGame.y1);
			this.setSize(northSouthD);
			newOrder = new Order(northSouthSeating);
			center.add(centralPanel1, BorderLayout.CENTER);
			center.add(order, BorderLayout.EAST);
			order.add(newOrder);
		    done.addActionListener(this);
		    order.add(done);
			JFrame checkout = new JFrame();
		}
		else if(x == EventGame.ewx && y == EventGame.ewy){
			centralPanel2 = getEWSeating(EventGame.ewx,EventGame.ewy);
			this.setSize(eastWestD);
			newOrder = new Order(eastWestSeating);
			center.add(centralPanel2, BorderLayout.CENTER);
			center.add(order, BorderLayout.EAST);
			order.add(newOrder);
		    done.addActionListener(this);
		    order.add(done);
			JFrame checkout = new JFrame();
		}
		
		setVisible(true);
		setLayout(null);
	}
	
	
	public JComponent getUpperNSSeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < upperNorthSouthSeating.length; i++) {
	      upperNorthSouthSeating[i] = new Seat();
	      upperNorthSouthSeating[i].setPrice(10.0);
	      upperNorthSouthSeating[i].setText("");
	      gridSeats.add(upperNorthSouthSeating[i]);
	    }
	    return gridSeats;
	 }
	
	
	public JComponent getNSSeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < northSouthSeating.length; i++) {
	    	northSouthSeating[i] = new Seat();
	    	northSouthSeating[i].setPrice(15.0);
	    	northSouthSeating[i].setText("");
	      gridSeats.add(northSouthSeating[i]);
	    }
	    return gridSeats;
	  }
	
	
	public JComponent getEWSeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < eastWestSeating.length; i++) {
	      eastWestSeating[i] = new Seat();
	      eastWestSeating[i].setPrice(12.5);
	      eastWestSeating[i].setText("");
	      gridSeats.add(eastWestSeating[i]);
	    }
	    return gridSeats;
	  }
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == done) {
		      Checkout test = new Checkout(newOrder);
		      test.setVisible(true);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	

}
