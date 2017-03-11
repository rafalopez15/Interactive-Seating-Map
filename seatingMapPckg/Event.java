package seatingMapPckg;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;

/** 
* This class implements the UI for selecting an event  
* 
*
* @author  Group 4
* @version 1.0
* @since   2017-03-10 
*  
*/

public class Event extends JFrame implements ActionListener{


  private JButton[][] grid = new JButton[1][3];
  private JLabel statusBar = new JLabel("");
  private JPanel centerPanel = new JPanel(new GridLayout(1, 3));
  private JFrame newContent = new MovieEvent();
  private JFrame gameContent = new EventGame();
  private JFrame concertContent = new EventConcert();
  
  
  
  /** 
	 * This constructor create the interactive interface for selecting an event. 
	 * The UI consists of two panels, a JLabel, and  grid with 3 buttons, 
	 * each representing a specific event type.
	 * 
	 * 
	 */
  public Event(){
    
    setTitle("Events");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setResizable(false);
    setSize(1280, 700);
    setMinimumSize(new Dimension(1280, 700));
    Font font = new Font("MS Gothic", Font.BOLD, 40);
    for (int i = 0; i < 1; i++){
      for (int j = 0; j < 3; j++) {
        grid[i][j] = new JButton(" ");
        grid[i][j].setContentAreaFilled(false);
        grid[i][j].setBorderPainted(false);
        grid[i][j].setFocusPainted(false);
        grid[i][j].setFont(font);
        grid[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
        grid[i][j].setLayout(new FlowLayout());
        grid[i][j].addActionListener(this);
        centerPanel.add(grid[i][j]);
      }
    }
    
    start();
    JPanel northPanel = new JPanel();
    northPanel.add(statusBar);
   
    

    add(northPanel, "North");
    add(centerPanel, "Center");
    

    setLocationRelativeTo(null);
  }

  
  /** 
	 * This method sets the text in the status bar 
	 * @param s This is the status message of the game  
	 */
  
  private void setStatus(String s) {
    statusBar.setText(s);
  }

  /** 
	 * This enables the buttons of the grid 
	 * 
	 * @param enabled This is for the UI to determine if a button on the grid
	 * has been enabled.
	 */
  
  public void setGridEnabled(boolean enabled) {
    for (int i = 0; i < 1; i++)
      for (int j = 0; j < 3; j++) {
      grid[i][j].setEnabled(enabled);
      if (enabled) {
        grid[0][0].setIcon((new ImageIcon(getClass().getResource("images/movie.png"))));
        grid[0][1].setIcon(new ImageIcon(getClass().getResource("images/game.png")));
        grid[0][2].setIcon(new ImageIcon(getClass().getResource("images/concert.png")));
      }
    }
  }
  
  
  /** 
	 * This method opens up new frame with the event type 
	 * 
	 * @param i is the row of the event grid
	 * @param j is the column of the event grid
	 */
  
  private void clickOne(int i, int j) {
    if (i == 0 && j == 0) {
    	newContent.setVisible(true);
    	newContent.setLocationRelativeTo(null);
    	newContent.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    else if ( i == 0 && j == 1){
    	gameContent.setVisible(true);
    	gameContent.setLocationRelativeTo(this);
    	gameContent.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    else if (i == 0 && j == 2){
    	concertContent.setVisible(true);
    	concertContent.setLocationRelativeTo(this);
    	concertContent.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
  }
  
  
  
  /** 
	 * This method starts up the UI by setting the center panel
	 * to visible and enabling the grid
	 * 
	 */
  private void start() {
    setStatus("Select an Event:");
    newContent.setVisible(false);
    gameContent.setVisible(false);
    concertContent.setVisible(false);
    centerPanel.setVisible(true);
    setGridEnabled(true);
  }
  
  
  /** 
	 * This method processes the action events of clicking an event button from grid.
	 * 
	 * @param event This is the action of clicking on one of the buttons
	 */
  public void actionPerformed(ActionEvent event) {

      for (int i = 0; i < 1; i++) {
        for (int j = 0; j < 3; j++) {
          if (event.getSource() == grid[i][j]) {
            clickOne(i, j);
          }
        }
      }
    
  }
  
  public static void main (String [] args){
    new Event().setVisible(true);
  }

}