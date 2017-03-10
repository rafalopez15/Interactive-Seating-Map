import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
*This class genereates the order for the seats. It counts how many seats the user
*chooses, applies a discount if conditions are met. And finally, gives the total.
*/

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
  
  /**
  *Creates the order object to display with the seats. Chceks for discounts, adds up 
  *the total of seats selected.
  *@param seats array takes the array of the selected section.
  */
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
/**
*Sets total for order
*@param t is passed to set total
*/
  public void setTotal(double t) {
    total = t;
  }

/**
*Sets temp total for order
*@param tt is passed to set temp total
*/
  public void setTempTotal(double tt) {
    tempTotal = tt;
  }

/**
*Sets discount for order
*@param d is passed to set discount
*/
  public void setDiscount(double d) {
    discount = d;
  }

/**
*returns total
*@return double total of order
*/
  public double getTotal() {
    return total;
  }

/**
*returns tempTotal
*@return double temptotal of order
*/
  public double getTempTotal() {
    return tempTotal;
  }

/**
*returns discount
*@return double discount of order
*/
  public double getDiscount() {
    return discount;
  }

}
