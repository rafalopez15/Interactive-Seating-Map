import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class SeatingDisplay extends JFrame implements ActionListener  {

	
	
	public SeatingDisplay(int x, int y){
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel centerPanel = new JPanel(new GridLayout(x, y));
		JToggleButton[][] grid = new JToggleButton[x][y];
	
		int nsx = EventGame.nsx;
		int y1 = EventGame.y1;
		int y2 = EventGame.y2;
		int ewx = EventGame.ewx;
		int ewy = EventGame.ewy;
		
		Dimension upperD = EventGame.upperD;
		Dimension northSouthD = EventGame.northSouthD;
		Dimension eastWestD = EventGame.eastWestD;
		
		
		
		if(x == nsx && y == y2){
			this.setSize(upperD);
		}
		if(x == nsx && y == y1){
			this.setSize(northSouthD);
		}
		else if(x == ewx && y == ewy){
			this.setSize(eastWestD);
		}
		
		Font font = new Font("MS Gothic", Font.BOLD, 10);
		for (int i = 0; i < x; i++){
			for (int j = 0; j < y; j++) {
				grid[i][j] = new JToggleButton(" ");
				grid[i][j].setFont(font);
				grid[i][j].addActionListener(this);
				centerPanel.add(grid[i][j]);
			}
		}
		add(centerPanel, BorderLayout.CENTER);
		//seatingDisplay.setSize(new Dimension(500,500));
		setVisible(true);
		setLayout(null);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
