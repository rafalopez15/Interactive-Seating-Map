import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Event extends JFrame implements ActionListener{
  
  //private JButton startButton = new JButton("Start");
  private JButton backButton = new JButton("Back");
  private JButton[][] grid = new JButton[1][3];
  private JLabel statusBar = new JLabel("");
  JPanel centerPanel = new JPanel(new GridLayout(1, 3));
  JPanel newContent = new MovieEvent();
  private boolean isSoldOut = false;
  public static final int eventOne = 0;
  public static final int eventTwo = 1;
  public static final int eventThree = 2;
  private int maxSeats = 100;
  private int human = 0;
  
  private String chars = "X"; 
  
  
  public Event(){
    
    setTitle("Events");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true);

    Font font = new Font("MS Gothic", Font.BOLD, 40);
    for (int i = 0; i < 1; i++){
      for (int j = 0; j < 3; j++) {
        grid[i][j] = new JButton(" ");
        grid[i][j].setFont(font);
        grid[i][j].addActionListener(this);
        centerPanel.add(grid[i][j]);
      }
    }
    
    //startButton.addActionListener(this);
    start();
    backButton.addActionListener(this);
    backButton.setVisible(false);
    JPanel northPanel = new JPanel();
    northPanel.add(statusBar);
    
    JPanel southPanel = new JPanel();
    //southPanel.add(startButton);
    southPanel.add(backButton);

    //setStatus("Click Start to view events");
    //setGridEnabled(false);
    
    add(northPanel, "North");
    add(centerPanel, "Center");
    add(southPanel, "South");
    
    
    
    setSize(1000, 900);
    
    setLocationRelativeTo(null);
    
  }
  
  private void setStatus(String s) {
    statusBar.setText(s);
  }
  
  public void setGridEnabled(boolean enabled) {
    for (int i = 0; i < 1; i++)
      for (int j = 0; j < 3; j++) {
      grid[i][j].setEnabled(enabled);
      if (enabled){
        grid[0][0].setText(" Movie ");
        grid[0][1].setText(" Game ");
        grid[0][2].setText(" Concert ");
      }
    }
  }
  
  private void clickOne(int i, int j) {
    if (i == 0 && j == 0) {
      add(newContent, BorderLayout.CENTER);
      newContent.setVisible(true);
      centerPanel.setVisible(false);
      //pack();
    }
    
    backButton.setVisible(true);
    
  }
  
  
  private void start() {
    setStatus("Please select event type");
    newContent.setVisible(false);
    centerPanel.setVisible(true);
    setGridEnabled(true);
    //isPlay = true;
  }
  
  
  public void actionPerformed(ActionEvent event) {
    // checks to see if play button was pressed
    /*if (event.getSource() == startButton) {
      start();
      
      //checks to see if reset button was pressed
    }*/
    if (event.getSource() == backButton) {
      start();
      backButton.setVisible(false);
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