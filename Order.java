import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Order extends JLabel {
  
  double total;
  double tempTotal;
  double bulk;
  int noTickets;
  JLabel orderTotal;
  
  public Order(Seat[] s) {
    for (int i = 0; i < s.length; i++) {
      s[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          Seat check = (Seat)e.getSource();
          if (check.isSelected()) {
            noTickets++;
            tempTotal += check.getPrice();
          }
          else if (!check.isSelected()) {
            noTickets--;
            tempTotal -= check.getPrice();
          }
          if (noTickets > 4) {
            bulk = tempTotal * .3;
            total = tempTotal - bulk;
            setText("$ " + total);
          }
          else {
            setText("$ " + tempTotal);
          }
        }
      });
    }
    
    
  }
}
