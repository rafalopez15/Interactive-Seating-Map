import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;


public class Event extends JFrame implements ActionListener{

  private JButton backButton = new JButton("Back");
  private JButton[][] grid = new JButton[1][3];
  private JLabel statusBar = new JLabel("");
  JPanel centerPanel = new JPanel(new GridLayout(1, 3));
  JFrame newContent = new MovieEvent();
  JFrame gameContent = new EventGame();
  JFrame concertContent = new EventConcert();
  
  
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
    backButton.addActionListener(this);
    backButton.setVisible(false);

    JPanel northPanel = new JPanel();
    northPanel.add(statusBar);
    JPanel southPanel = new JPanel();
    southPanel.add(backButton);

    add(northPanel, "North");
    add(centerPanel, "Center");
    add(southPanel, "South");

    setLocationRelativeTo(null);
  }

  private void setStatus(String s) {
    statusBar.setText(s);
  }

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
  
  private void clickOne(int i, int j) {
    if (i == 0 && j == 0) {
      //add(newContent);
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
  
  
  private void start() {
    setStatus("Events");
    newContent.setVisible(false);
    centerPanel.setVisible(true);
    setGridEnabled(true);
  }
  
  
  public void actionPerformed(ActionEvent event) {
    // checks to see if play button was pressed
    //checks to see if reset button was pressed

    if (event.getSource() == backButton) {
      start();
      pack();
    }
    
    // checks to see which space on the game board was pressed and whose turn it is 
    else {
      for (int i = 0; i < 1; i++) {
        for (int j = 0; j < 3; j++) {
          if (event.getSource() == grid[i][j]) {
            clickOne(i, j);
          }
        }
      }
    }
    
    
  }
  
  public static void main (String [] args){
    new Event().setVisible(true);
  }

}