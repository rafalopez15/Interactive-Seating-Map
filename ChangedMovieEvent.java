import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChangedMovieEvent extends JPanel implements ActionListener {
  
  ChangedSeat[] seats = new ChangedSeat[50];
  JPanel order = new JPanel();
  JLabel orderTotal = new JLabel();
  double total = 0.0;
  Dimension size = new Dimension(500, 500);
  
  public ChangedMovieEvent() {
    JLayeredPane centerPanel = new JLayeredPane();
    centerPanel.setPreferredSize(size);
    centerPanel.setLayout(new BorderLayout());
    centerPanel.add(getSeats(), BorderLayout.CENTER);
    centerPanel.add(order, BorderLayout.SOUTH);
    order.add(new JLabel("Total : "));
    order.add(orderTotal);
    
    add(centerPanel);
    
  }
  
  public JComponent getSeats() {
    
    JPanel gridSeats = new JPanel();
    gridSeats.setLayout(new GridLayout(10, 5));
    for (int i = 0; i < seats.length; i++) {
      seats[i] = new ChangedSeat();
      seats[i].setPrice(10.0);
      seats[i].setText("");
      seats[i].addActionListener(this);
      gridSeats.add(seats[i]);
    }
    
    return gridSeats;
  }
  
  public void actionPerformed(ActionEvent e) {
    
    ChangedSeat check = (ChangedSeat)e.getSource();
    String cmd = check.getActionCommand();
    if (cmd.equals("")) {
      check.setText(" ");
      total += check.getPrice();
    }
    else if (cmd.equals(" ")) {
      check.setText("");
      total -= check.getPrice();
    }
    orderTotal.setText("$ " + total);
  }
  
  
  
  
}
