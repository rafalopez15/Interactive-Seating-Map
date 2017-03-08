import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class MovieEvent extends JPanel {
 
 Seat[] seats = new Seat[50];
  JButton back = new JButton("Back");
  JPanel order = new JPanel();
  JLabel orderTotal = new JLabel();
  double total = 0.0;
  Dimension size = new Dimension(500, 500);
  
  public MovieEvent() {
    back.setPreferredSize(new Dimension(75, 50));
    back.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
          setVisible(false);
        }
      }
    });
    TitledBorder titled = new TitledBorder("Order Summary");
    JPanel centerPanel = new JPanel();
    centerPanel.setPreferredSize(size);
    order.setPreferredSize(new Dimension(200, 500));
    centerPanel.setLayout(new BorderLayout());
    centerPanel.add(getSeats(), BorderLayout.CENTER);
    centerPanel.add(order, BorderLayout.EAST);
    //order.add(back);
    order.setBorder(titled);
    order.add(new Order(seats));
    
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
