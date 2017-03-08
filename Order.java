import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Order extends JLabel {
  
  double total;
  double tempTotal;
  double discount;
  int noTickets;
  JCheckBox vipBox = new JCheckBox("VIP", false);
  JLabel totDisplay = new JLabel();
  
  public Order(Seat[] s) {
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension(100, 100));
    vipBox.setVisible(true);
    add(totDisplay, BorderLayout.NORTH);
    add(vipBox, BorderLayout.CENTER);
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
          if (noTickets > 4 && !vipBox.isSelected()) {
            discount = tempTotal * .1;
            total = tempTotal - discount;
            totDisplay.setText("<html><div style='text-align: center;'>&nbsp;&nbsp;" + tempTotal + "<br>-&nbsp;&nbsp;<font color=red>" + discount + "</font><br>----------<br>$&nbsp;" + total + "</div></html>");
          }
          else if (vipBox.isSelected()) {
            discount = tempTotal * .2;
            total = tempTotal - discount;
            totDisplay.setText("<html><div style='text-align: center;'>&nbsp;&nbsp;" + tempTotal + "<br>-&nbsp;&nbsp;<font color=red>" + discount + "</font><br>----------<br>$&nbsp;" + total + "</div></html>");
          }
          else {
            totDisplay.setText("<html><div style='text-align: center;'>&nbsp;&nbsp;" + tempTotal + "<br>  <br>----------<br>$&nbsp;" + tempTotal + "</div></html>");
          }
        }
      });
    }
  }
}
