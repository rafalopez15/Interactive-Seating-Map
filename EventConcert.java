
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;




public class EventConcert extends JFrame implements ActionListener {
	JLabel stageLabel = new JLabel("This is a label", SwingConstants.CENTER);
	JToggleButton north1 = new JToggleButton("North");
	JToggleButton middle = new JToggleButton("Middle");
	JToggleButton south = new JToggleButton("South");
	JFrame seatingDisplay = new JFrame();
	
	public static int nsx = 1;
	public static int y1 = 5;
	public static int y2 = 15;
	public static int ewx = 10;
	public static int ewy = 3;
	
	public static Dimension upperD = new Dimension(500,150);
	public static Dimension northSouthD = new Dimension(300,150);
	public static Dimension eastWestD = new Dimension(400,500);
	
	public EventConcert(){
		 
		setLayout(new GridLayout(4,1));
		setSize(500, 500); 
		north1.addActionListener(this);
		add(stageLabel);
		add(north1);
		add(middle);
		add(south);
		
		north1.addActionListener(this);
		middle.addActionListener(this);
		south.addActionListener(this);
		
		
	}

	public void setEnabled(boolean enabled) {
		north1.setEnabled(enabled);
		middle.setEnabled(enabled);
		south.setEnabled(enabled);

			  
		
	 }
	  
			
	public void actionPerformed(ActionEvent e) {
		seatingDisplay = new SeatingDisplay(nsx,y2);
		
	}


	
	public static void main (String [] args){
		new EventConcert().setVisible(true);
		
	}
	
	

}

