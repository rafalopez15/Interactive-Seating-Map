import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import javax.swing.border.*;

public class Seat extends JToggleButton {

 private double price;

 public Seat() {
 }

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