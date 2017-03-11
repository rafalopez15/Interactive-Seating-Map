package seatingMapPckg;


import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import javax.swing.border.*;

/**
*This class is a custom JToggle button that we used as our seating display.
*Creates a button that can have a price property to check the price of that specific seat
*
*
* @author  Group 4
* @version 1.0
* @since   2017-03-10 
*  
*/

public class Seat extends JToggleButton {

 private double price;

 public Seat() {
 }
/**
* Seat object with a parameter to set price.
*@param price to set price of seat.
*/
 public Seat(double price) {
  this.setText("Seat Button");
  this.price = price;
 }

/**
* Sets the price of seat.
*@param price only parameter to setPrice method
*/
 public void setPrice(double price) {
  this.price = price;
 }

/**
* Gets the price of a seat
*@return double which is the price.
*/
 public double getPrice() {
  return this.price;
 }

}