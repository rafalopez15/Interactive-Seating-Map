import javax.swing.*;
import java.awt.event.*;
import java.awt.*;




public class EventGame extends JFrame implements ActionListener {
	
	
	private String statusBar = " Please Select Section ";
	private JButton court = new JButton (statusBar);
	
	
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
		Font font = new Font("MS Gothic", Font.BOLD, 26);
		court.setFont(font);
		court.setEnabled(false);

		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(north1, BorderLayout.NORTH);
		centerPanel.add(court, BorderLayout.CENTER);
		centerPanel.add(south1, BorderLayout.SOUTH);
		
	
		
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
			JFrame seatingDisplayUNorth = new SeatingDisplay(nsx,y2);
		    north2.setEnabled(true);
		}
		else if (e.getSource() == south2){
			south2.setEnabled(true);
			JFrame seatingDisplayUSorth = new SeatingDisplay(nsx,y2);
		}
		else if(e.getSource() == north1){
			north1.setEnabled(true);
			JFrame seatingDisplayNorth = new SeatingDisplay(nsx, y1);
		}
		else if (e.getSource() == south1){
			south1.setEnabled(true);
			JFrame seatingDisplaySouth = new SeatingDisplay(nsx, y1);		
		}
		else if( e.getSource() == east){
			east.setEnabled(true);
			JFrame seatingDisplayEast = new SeatingDisplay(ewx, ewy);
		}
		else if( e.getSource() == west){
			west.setEnabled(true);
			JFrame seatingDisplayWest = new SeatingDisplay(ewx,ewy);
		}
	}
	
	
	public static void main (String [] args) {
		new EventGame().setVisible(true);
		
	}
	
	

}
	
	