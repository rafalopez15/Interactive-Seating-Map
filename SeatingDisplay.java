import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class SeatingDisplay extends JFrame implements ActionListener  {

	
	
	Seat [] northSeating = new Seat[5];
	Seat [] upperNorthSeating = new Seat[10];
	Seat [] eastSeating = new Seat[30];
	
	
	
	public static Dimension upperD = new Dimension(600,150);
	public static Dimension northSouthD = new Dimension(400,150);
	public static Dimension eastWestD = new Dimension(400,500);
	
	
	JPanel order = new JPanel();
	
	
	
	public SeatingDisplay(int x, int y){
		
		setTitle("Section");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setLayout(new BorderLayout());
		
	
		
		if(x == EventGame.nsx && y == EventGame.y2){
			this.setSize(upperD);
		}
		if(x == EventGame.nsx && y == EventGame.y1){
			this.setSize(northSouthD);
		}
		else if(x == EventGame.ewx && y == EventGame.ewy){
			this.setSize(eastWestD);
		}
		
		
		setVisible(true);
		setLayout(null);
		
		
		
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
