import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Checkout extends JFrame {
    JPanel order = new JPanel();
    JLabel words = new JLabel();
    JLabel numbers = new JLabel();
    Border blackline = BorderFactory.createLineBorder(Color.black);
    TitledBorder receipt;
    double total;
    double tempTotal;
    double discount;

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
