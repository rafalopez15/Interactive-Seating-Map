import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChangedMovieEvent extends JPanel {
  
  ChangedSeat[] seats = new ChangedSeat[50];
  JButton back = new JButton();
  JPanel order = new JPanel();
  JLabel orderTotal = new JLabel();
  double total = 0.0;
  Dimension size = new Dimension(500, 500);
  
  public ChangedMovieEvent() {
    back.setPreferredSize(new Dimension(100, 50));
    back.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
          setVisible(false);
        }
      }
    });
    JPanel centerPanel = new JPanel();
    centerPanel.setPreferredSize(size);
    centerPanel.setLayout(new BorderLayout());
    centerPanel.add(getSeats(), BorderLayout.CENTER);
    centerPanel.add(order, BorderLayout.SOUTH);
    add(back);
    order.add(new JLabel("Total: "));
    order.add(new Order(seats));
    
    add(centerPanel);
  }
  
  public JComponent getSeats() {
    JPanel gridSeats = new JPanel();
    gridSeats.setLayout(new GridLayout(10, 5));
    for (int i = 0; i < seats.length; i++) {
      seats[i] = new ChangedSeat();
      seats[i].setPrice(10.0);
      seats[i].setText("");
      gridSeats.add(seats[i]);
    }
    return gridSeats;
  }
  
}
