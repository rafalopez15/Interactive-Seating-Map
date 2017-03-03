import javax.swing.*;
import java.awt.event.*;
import java.awt.*;




public class EventGame extends JFrame {
	
	private String statusBar = " Game Event Seating Layout ";
	
	public EventGame(){
		
		setTitle("Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		JPanel centerPanel = new JPanel();
		
		
        //centerPanel.setMaximumSize(centerPanel.getPreferredSize()); 
        //centerPanel.setMinimumSize(centerPanel.getPreferredSize());
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(new Button ("North"), BorderLayout.NORTH);
		centerPanel.add(new Button (statusBar), BorderLayout.CENTER);
		centerPanel.add(new Button ("South"), BorderLayout.SOUTH);
		//centerPanel.add(new Button ("East"), BorderLayout.EAST);
		//centerPanel.add(new Button ("West"), BorderLayout.WEST);
		
		centerPanel.setPreferredSize(new Dimension(50, 50));
		
		
		
		
		setLayout(new BorderLayout());
		add(new Button ("North"), BorderLayout.NORTH);
		add(new Button ("East"), BorderLayout.EAST);
		add(new Button ("West"), BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		add(new Button ("South"), BorderLayout.SOUTH);
		
		
		
		setSize(400, 400);
		
	}
	
	public static void main (String [] args){
		new EventGame().setVisible(true);
	}
	

}
