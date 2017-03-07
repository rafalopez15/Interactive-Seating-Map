import javax.swing.JToggleButton;

public class ChangedSeat extends JToggleButton {
 
 private double price;
 
 public ChangedSeat() {
 }
 
 public ChangedSeat(double price) {
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