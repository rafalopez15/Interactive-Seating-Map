
public class Seat extends JButton{
	
	private double price;
	
	public Seat(double price) {
		this.setText("Seat Button");
		this.price = price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}
}