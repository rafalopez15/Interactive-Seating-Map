import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class MovieEvent extends JPanel {
 
 Seat[] seats = new Seat[50];
  JPanel order = new JPanel();
  JLabel orderTotal = new JLabel();
  double total = 0.0;
  Dimension size = new Dimension(600, 700);
  
  public MovieEvent() {
    JPanel centerPanel = new JPanel();
    centerPanel.setPreferredSize(size);
    order.setPreferredSize(new Dimension(100, 500));
    centerPanel.setLayout(new BorderLayout());
    centerPanel.add(getSeats(), BorderLayout.CENTER);
    centerPanel.add(order, BorderLayout.EAST);
    order.setLayout(new BorderLayout());
    order.add(new Order(seats), BorderLayout.EAST);
    
    add(centerPanel);
  }
  
  public JComponent getSeats() {
    JPanel gridSeats = new JPanel();
    gridSeats.setLayout(new GridLayout(10, 5));
    for (int i = 0; i < seats.length; i++) {
      seats[i] = new Seat();
      seats[i].setPrice(10.0);
      seats[i].setText("");
      gridSeats.add(seats[i]);
    }
    return gridSeats;
  }
  
}
