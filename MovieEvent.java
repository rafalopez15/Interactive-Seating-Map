import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class MovieEvent extends JFrame {

  Seat[] seats = new Seat[50];
  JPanel order = new JPanel();
  JLabel orderTotal = new JLabel();
  double total = 0.0;
  Dimension size = new Dimension(550, 600);

  public MovieEvent() {
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    JPanel screen = new JPanel();
    setSize(500, 500);
    setLayout(new BorderLayout());
    Border blackline = BorderFactory.createLineBorder(Color.black);
    TitledBorder movie = BorderFactory.createTitledBorder(blackline);
    screen.add(new JLabel("Screen"));
    screen.setBorder(movie);
    screen.setPreferredSize(new Dimension(200, 50));
    order.setPreferredSize(new Dimension(100, 300));
    setLayout(new BorderLayout());
    add(getSeats(), BorderLayout.CENTER);
    add(order, BorderLayout.EAST);
    add(screen, BorderLayout.NORTH);
    order.add(new Order(seats));


  }

  public JComponent getSeats() {
    JPanel gridSeats = new JPanel();
    gridSeats.setSize(250, 400);
    gridSeats.setLayout(new GridLayout(10, 5));
    for (int i = 0; i < seats.length; i++) {
      seats[i] = new Seat();
      seats[i].setPrice(10.0);
      seats[i].setText(Integer.toString((i+1)));
      gridSeats.add(seats[i]);
    }
    return gridSeats;
  }

}
