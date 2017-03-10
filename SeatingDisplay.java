import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


/** 
* This class implements the UI for selecting sectioned seats for both 
* game and concert event type.
* 
* 
*
* @author  Amin Karabash
* @version 1.0
* @since   2017-03-10 
*  
*/

public class SeatingDisplay extends JFrame implements ActionListener  {

	// seating arrays for Game event
	public  Seat [] northSouthSeating = new Seat[10];
	public  Seat [] upperNorthSouthSeating = new Seat[15];
	public  Seat [] eastWestSeating = new Seat[20];
	
	// seating arrays for concert event
	public  Seat [] concertNSeating = new Seat[20];
	public  Seat [] concertMSeating = new Seat[30];
	public  Seat [] concertSSeating = new Seat[40];
	
	
	// sizes for seating display frame based on event type
	private  Dimension upperD = new Dimension(1220,260);
	private  Dimension northSouthD = new Dimension(900,260);
	private  Dimension eastWestD = new Dimension(500,700);
	private  Dimension concertD = new Dimension(800,500);
	
	JButton done = new JButton("Checkout");
	public Order newOrder = new Order();
	
	// panels that will hold seating gird of seating display for game event 
	public JComponent centralPanel = new JPanel();
	public JComponent centralPanel1 = new JPanel();
	public JComponent centralPanel2 = new JPanel();
	
	
	// panels that will hold seating gird of seating display for concert event
	public JComponent centralPanel3 = new JPanel();
	public JComponent centralPanel4 = new JPanel();
	public JComponent centralPanel5 = new JPanel();
	
	
	/** 
	 * This constructor create the interactive interface of the seating display. 
	 * The UI consists of 3 panels: 
	 * 1) A panel that contains the seating grid; 
	 * 2) a panel that contains the order tracker, as represented by a 3x3 grid;
	 * 3) A button to proceed to checkout window 
	 *  
	 *  @param x is row dimension of the seating grid
	 *  @param y is column dimension of the seating grid
	 */
	
	public SeatingDisplay(int x, int y){
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		add(center);
		

		JPanel order = new JPanel();
		center.add(order, BorderLayout.EAST);
	    
		// based on dimensions, create seating display 
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
		
		else if( x == EventConcert.conNx && y == EventConcert.conNy){
			centralPanel3 = getConcertNSeating(EventConcert.conNx, EventConcert.conNy);
			this.setSize(concertD);
			newOrder = new Order(concertNSeating);
			center.add(centralPanel3, BorderLayout.CENTER);
			center.add(order, BorderLayout.EAST);
			order.add(newOrder);
		    done.addActionListener(this);
		    order.add(done);
			JFrame checkout = new JFrame();
		}
		
		else if( x == EventConcert.conMx && y == EventConcert.conMy){
			centralPanel3 = getConcertMSeating(EventConcert.conMx, EventConcert.conMy);
			this.setSize(concertD);
			newOrder = new Order(concertMSeating);
			center.add(centralPanel3, BorderLayout.CENTER);
			center.add(order, BorderLayout.EAST);
			order.add(newOrder);
		    done.addActionListener(this);
		    order.add(done);
			JFrame checkout = new JFrame();
		}
		
		else if( x == EventConcert.conSx && y == EventConcert.conSy){
			centralPanel3 = getConcertSSeating(EventConcert.conSx, EventConcert.conSy);
			this.setSize(concertD);
			newOrder = new Order(concertSSeating);
			center.add(centralPanel3, BorderLayout.CENTER);
			center.add(order, BorderLayout.EAST);
			order.add(newOrder);
		    done.addActionListener(this);
		    order.add(done);
			JFrame checkout = new JFrame();
		}
		
		setVisible(true);
	}
	
	
	/** 
	 * This method creates the seating grid panel that will go 
	 * into the center panel.
	 * 
	 *  @param x is row dimension of the seating grid
	 *  @param y is column dimension of the seating grid
	 */
	public JComponent getUpperNSSeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < upperNorthSouthSeating.length; i++) {
	      upperNorthSouthSeating[i] = new Seat();
	      upperNorthSouthSeating[i].setPrice(10.0);
	      upperNorthSouthSeating[i].setText("");
	      upperNorthSouthSeating[i].setText(Integer.toString(((i)+1)));
	      gridSeats.add(upperNorthSouthSeating[i]);
	    }
	    return gridSeats;
	 }
	
	/** 
	 * This method creates the seating grid panel that will go 
	 * into the center panel.
	 * 
	 *  @param x is row dimension of the seating grid
	 *  @param y is column dimension of the seating grid
	 */
	
	public JComponent getNSSeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < northSouthSeating.length; i++) {
	    	northSouthSeating[i] = new Seat();
	    	northSouthSeating[i].setPrice(15.0);
	    	northSouthSeating[i].setText("");
	    	northSouthSeating[i].setText(Integer.toString(((i)+1)));
	      gridSeats.add(northSouthSeating[i]);
	    }
	    return gridSeats;
	  }
	
	/** 
	 * This method creates the seating grid panel that will go 
	 * into the center panel.
	 * 
	 *  @param x is row dimension of the seating grid
	 *  @param y is column dimension of the seating grid
	 */
	
	public JComponent getEWSeating( int x, int y) {
	    JPanel gridSeats = new JPanel();
	    gridSeats.setLayout(new GridLayout(x, y));
	    for (int i = 0; i < eastWestSeating.length; i++) {
	      eastWestSeating[i] = new Seat();
	      eastWestSeating[i].setPrice(12.5);
	      eastWestSeating[i].setText("");
	      eastWestSeating[i].setText(Integer.toString(((i)+1)));
	      gridSeats.add(eastWestSeating[i]);
	    }
	    return gridSeats;
	  }
	
	
	/** 
	 * This method creates the seating grid panel that will go 
	 * into the center panel.
	 * 
	 *  @param x is row dimension of the seating grid
	 *  @param y is column dimension of the seating grid
	 */
	public JComponent getConcertNSeating(int x, int y){
		 JPanel gridSeats = new JPanel();
		    gridSeats.setLayout(new GridLayout(x, y));
		    for (int i = 0; i < concertNSeating.length; i++) {
		     concertNSeating[i] = new Seat();
		      concertNSeating[i].setPrice(30);
		      concertNSeating[i].setText("");
		      concertNSeating[i].setText(Integer.toString(((i)+1)));
		      gridSeats.add(concertNSeating[i]);
		    }
		    return gridSeats;
	}
	
	/** 
	 * This method creates the seating grid panel that will go 
	 * into the center panel.
	 * 
	 *  @param x is row dimension of the seating grid
	 *  @param y is column dimension of the seating grid
	 */
	
	public JComponent getConcertMSeating(int x, int y){
		 JPanel gridSeats = new JPanel();
		    gridSeats.setLayout(new GridLayout(x, y));
		    for (int i = 0; i < concertMSeating.length; i++) {
		     concertMSeating[i] = new Seat();
		      concertMSeating[i].setPrice(20);
		      concertMSeating[i].setText("");
		      concertMSeating[i].setText(Integer.toString(((i)+1)));
		      gridSeats.add(concertMSeating[i]);
		    }
		    return gridSeats;
	}
	
	/** 
	 * This method creates the seating grid panel that will go 
	 * into the center panel.
	 * 
	 *  @param x is row dimension of the seating grid
	 *  @param y is column dimension of the seating grid
	 */
	public JComponent getConcertSSeating(int x, int y){
		 JPanel gridSeats = new JPanel();
		    gridSeats.setLayout(new GridLayout(x, y));
		    for (int i = 0; i < concertSSeating.length; i++) {
		     concertSSeating[i] = new Seat();
		      concertSSeating[i].setPrice(10);
		      concertSSeating[i].setText("");
		      concertSSeating[i].setText(Integer.toString(((i)+1)));
		      gridSeats.add(concertSSeating[i]);
		    }
		    return gridSeats;
	}
	
	/** 
	 * This method creates the seating grid panel that will go 
	 * into the center panel.
	 * 
	 *  @param e is an action event to of clicking one of the buttons
	 */
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == done) {
		      Checkout test = new Checkout(newOrder);
		      test.setVisible(true);
		}
	}
	
	

	
	

}
