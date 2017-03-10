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
  Border blackline = BorderFactory.createLineBorder(Color.black);
  TitledBorder summary;

  public Order() {
  }
  
  public Order(Seat[] s) {
    summary = BorderFactory.createTitledBorder(blackline, "Order");
    setBorder(summary);
    setLayout(new BorderLayout(5, 2));
    setPreferredSize(new Dimension(100, 200));
    setVisible(true);
    add(totDisplay, BorderLayout.EAST);
    add(vipBox, BorderLayout.SOUTH);
    vipBox.setVisible(true);
    totDisplay.setText("<html><div style='text-align: center;'>&nbsp;&nbsp;" + tempTotal + "<br>  <br>----------<br>$&nbsp;" + tempTotal + "</div></html>");
    for (int i = 0; i < s.length; i++) {
      s[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          Seat check = (Seat)e.getSource();
          if (check.isSelected()) {
            noTickets++;
            tempTotal += check.getPrice();
            setTotal(tempTotal);
          }
          else if (!check.isSelected()) {
            noTickets--;
            tempTotal -= check.getPrice();
            setTotal(tempTotal);
          }
          if (noTickets > 5 && !vipBox.isSelected()) {
            discount = tempTotal * .1;
            total = tempTotal - discount;
            setTotal(total);
            setTempTotal(tempTotal);
            setDiscount(discount);
            totDisplay.setText("<html><div style='text-align: center;'>&nbsp;&nbsp;" + tempTotal + "<br>-&nbsp;&nbsp;<font color=red>" + discount + "</font><br>----------<br>$&nbsp;" + total + "</div></html>");
          }
          else if (vipBox.isSelected()) {
            discount = tempTotal * .2;
            total = tempTotal - discount;
            setTotal(total);
            setTempTotal(tempTotal);
            setDiscount(discount);
            totDisplay.setText("<html><div style='text-align: center;'>&nbsp;&nbsp;" + tempTotal + "<br>-&nbsp;&nbsp;<font color=red>" + discount + "</font><br>----------<br>$&nbsp;" + total + "</div></html>");
          }
          else {
            setTotal(total);
            totDisplay.setText("<html><div style='text-align: center;'>&nbsp;&nbsp;" + tempTotal + "<br>  <br>----------<br>$&nbsp;" + tempTotal + "</div></html>");
          }
        }
      });
    }
  }

  public void setTotal(double t) {
    total = t;
  }

  public void setTempTotal(double tt) {
    tempTotal = tt;
  }

  public void setDiscount(double d) {
    discount = d;
  }

  public double getTotal() {
    return total;
  }

  public double getTempTotal() {
    return tempTotal;
  }

  public double getDiscount() {
    return discount;
  }

}
