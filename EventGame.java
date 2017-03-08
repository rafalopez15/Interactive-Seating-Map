import javax.swing.*;
import java.awt.event.*;
import java.awt.*;




public class EventGame extends JFrame implements ActionListener {
	
	private String statusBar = " Game Event Seating Layout ";
	
	JFrame seatingDisplay = new JFrame();
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
	
	public static Dimension upperD = new Dimension(500,150);
	public static Dimension northSouthD = new Dimension(300,150);
	public static Dimension eastWestD = new Dimension(400,500);
	
	
	public EventGame(){
		
		setTitle("Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(north1, BorderLayout.NORTH);
		centerPanel.add(new Button (statusBar), BorderLayout.CENTER);
		centerPanel.add(south1, BorderLayout.SOUTH);
		
		
		
		//centerPanel.add(new Button ("East"), BorderLayout.EAST);
		//centerPanel.add(new Button ("West"), BorderLayout.WEST);
		
		//centerPanel.setPreferredSize(new Dimension(50, 50));
		
		
		setLayout(new BorderLayout());
		add(north2, BorderLayout.NORTH);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		add(south2, BorderLayout.SOUTH);
		
		
		setSize(500, 500);
		
		
		north1.addActionListener(this);
		north2.addActionListener(this);
		south1.addActionListener(this);
		south2.addActionListener(this);
		east.addActionListener(this);
		west.addActionListener(this);
		
		
		
		
	}
	
	public void setEnabled(boolean enabled) {
	  
		
		north1.setEnabled(enabled);
		north2.setEnabled(enabled);
		south1.setEnabled(enabled);
		south2.setEnabled(enabled);
		west.setEnabled(enabled);
		east.setEnabled(enabled);
	  
		
	 }
	  
		  
	
	
	/*
	public JFrame seatingGrid(int x, int y){
		
		
		seatingDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		seatingDisplay.setLayout(new BorderLayout());
		
		JPanel seats = new JPanel(new GridLayout(x,y));
		if(x == nsx && y == y1){
			seatingDisplay.setSize(upperD);
		}
		else if(x == nsx && y == y2){
			seatingDisplay.setSize(northSouthD);
		}
		else if(x == ewx && y == ewy){
			seatingDisplay.setSize(new Dimension(400,400));
		}
		
		JToggleButton[][] grid = new JToggleButton[x][y];
		Font font = new Font("MS Gothic", Font.BOLD, 10);
		for (int i = 0; i < x; i++){
			for (int j = 0; j < y; j++) {
				grid[i][j] = new JToggleButton(" ");
				grid[i][j].setFont(font);
				grid[i][j].addActionListener(this);
				seats.add(grid[i][j]);
			}
		}
		seatingDisplay.add(seats, BorderLayout.CENTER);
		//seatingDisplay.setSize(new Dimension(500,500));
		seatingDisplay.setVisible(true);
		seatingDisplay.setLayout(null);
		
		
		
		return seatingDisplay;
		
		
	}
	*/
	
	public void actionPerformed(ActionEvent e) {
		//JToggleButton check =  (JToggleButton) e.getSource();
		if(e.getSource() == north2 || e.getSource() == south2){
			seatingDisplay = new SeatingDisplay(nsx,y2);
			//seatingDisplay.setPreferredSize(upperD);
		}
		
		else if(e.getSource() == north1 || e.getSource() == south1){
			seatingDisplay = new SeatingDisplay(nsx, y1);
			//seatingDisplay.setPreferredSize(northSouthD);
		}
		
		
		else if( e.getSource() == east || e.getSource() == west){
			seatingDisplay = new SeatingDisplay(ewx, ewy);
			//seatingDisplay.setPreferredSize(new Dimension(600,600));
			
		}
	}


	
	public static void main (String [] args){
		new EventGame().setVisible(true);
		
	}
	
	

}
