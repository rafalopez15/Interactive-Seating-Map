package seatingMapPckg;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
* Gets the order information, displays it on a checkout panel when the
* user finishes selecting seats.
*
* @author  Group 4
* @version 1.0
* @since   2017-03-10 
*  
*/

public class Checkout extends JFrame {
    JPanel order = new JPanel();
    JLabel words = new JLabel();
    JLabel numbers = new JLabel();
    Border blackline = BorderFactory.createLineBorder(Color.black);
    TitledBorder receipt;
    double total;
    double tempTotal;
    double discount;

/**
sets all the panel sizes, modifies the labels to display all order infomration
@param o is all the information for the order.
*/
    public Checkout(Order o) {
        receipt = BorderFactory.createTitledBorder(blackline, "Receipt");
        order.setBorder(receipt);
        setLayout(new FlowLayout());
        setMinimumSize(new Dimension(200, 100));
        total = o.getTotal();
        tempTotal = o.getTempTotal();
        discount = o.getDiscount();
        words.setText("<html><div style='text-align: right;'>SUB TOTAL:<br>DISCOUNT:<br>----------<br>TOTAL:</div></html>");
        numbers.setText("<html><div style='text-align: center;'>" + tempTotal + "<br>&nbsp;" + discount + "<br>----------<br>" + total + "</div></html>");
        order.add(words);
        order.add(numbers);
        add(order);
        setVisible(true);
        setResizable(false);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
