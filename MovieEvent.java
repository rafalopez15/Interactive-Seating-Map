import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;

public class MovieEvent extends Event {
	
	Seat[] seats = new Seat[50];

	public MovieEvent() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10, 5));
		for (int i = 0; i < buttons.length; i++) {
			seats[i].setPrice(10.0);
			panel.add(seats[i]);
		}
		panel.setVisible(true);
		panel.show();
	}

}