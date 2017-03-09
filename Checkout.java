import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Checkout extends JFrame {
    JPanel order = new JPanel();
    JLabel display = new JLabel();
    double total;
    double tempTotal;
    double discount;

    public Checkout(Order o) {
        setSize(500, 500);
        total = o.getTotal();
        tempTotal = o.getTempTotal();
        discount = o.getDiscount();
        display.setText("<html>" + tempTotal + "<br>" + discount + "<br>" + total + "</html>");
        order.add(display);
        add(order);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
