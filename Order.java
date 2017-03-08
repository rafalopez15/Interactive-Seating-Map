import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Order extends JLabel {
  
  double total;
  double tempTotal;
  double bulk;
  int noTickets;
  
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
            setText("<html>&nbsp;&nbsp;&nbsp;" + tempTotal + "<br>-&nbsp;&nbsp;<font color=red>" + bulk + "</font><br>----------<br>$&nbsp;" + total + "</html>");
          }
          else {
            setText("<html>&nbsp;&nbsp;&nbsp;" + tempTotal + "<br>  <br>----------<br>$&nbsp;" + tempTotal + "</html>");
          }
        }
      });
    }
    
    
  }
}
