import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Order extends JLabel {
  
  double total;
  JLabel orderTotal;
  
  public Order(ChangedSeat[] s) {
    for (int i = 0; i < s.length; i++) {
      s[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          ChangedSeat check = (ChangedSeat)e.getSource();
          if (check.isSelected()) {
            check.setText(" ");
            total += check.getPrice();
          }
          else if (!check.isSelected()) {
            check.setText("");
            total -= check.getPrice();
          }
          setText("$ " + total);
        }
      });
    }
    
    
  }
}
