// Specifies the package path where this Java file resides in the project structure
package Deadlocks.Deadlockprevention.trylock;

// Imports the ArrayList class, a resizable array implementation from java.util
import Deadlocks.Deadlockprevention.trylock.Lion.Bane;

import java.util.ArrayList;

// Imports the List interface, which defines the standard list behavior in Java
import java.util.List;

// Defines the public class 'Pizza', which acts as a blueprint for creating Pizza objects
public class Pizza {
    // Private instance variable to store the pizza's size ("Small", "Medium", "Large")
    private String size;

    // Private instance variable to hold the list of topping names added to this pizza
    private List<String> toppings;

    // Constructor method that initializes a new Pizza instance with a given size
    public Pizza(String size) {
        // Assigns the incoming 'size' parameter to the object's 'size' instance variable
        this.size = size;
        // Initializes the 'toppings' variable as a new, empty ArrayList of Strings
        this.toppings = new ArrayList<>();
    }

    // Public method to append a new topping to the pizza's topping list
    public void addTopping(String topping) {
        // Adds the specified topping string to the 'toppings' list
        this.toppings.add(topping);
    }

    // Public method to calculate and return the total cost of the pizza
    public double calculatePrice() {
        // Local variable initialized to hold the base cost depending on the size
        double basePrice = 0.0;

        // Evaluates the lowercased size string to make matching case-insensitive
        switch (this.size.toLowerCase()) {
            // If size is "small", set base price to $8.00
            case "small":
                basePrice = 8.00;
                break; // Exits the switch block

            // If size is "medium", set base price to $10.00
            case "medium":
                basePrice = 10.00;
                break; // Exits the switch block

            // If size is "large", set base price to $12.00
            case "large":
                basePrice = 12.00;
                break; // Exits the switch block

            // Fallback case if an invalid or unrecognized size is provided
            default:
                basePrice = 8.00; // Defaults to the small pizza price
        }

        // Multiplies the number of items in 'toppings' by $1.50 per topping
        double toppingsCost = this.toppings.size() * 1.50;

        // Returns the sum of base price and toppings cost as a double
        return basePrice + toppingsCost;
    }

    // Public method that constructs and returns a formatted summary string of the order
    public String getDescription() {
        // Builds a detailed description string using a ternary operator for toppings formatting
        return size + " Pizza with " +
                // If toppings list is empty, display "no toppings", otherwise join toppings with commas
                (toppings.isEmpty() ? "no toppings" : String.join(", ", toppings)) +
                // Formats the total calculated price to exactly 2 decimal places (e.g., $13.00)
                " | Total: $" + String.format("%.2f", calculatePrice());
    }

    // Entry point of the Java program where code execution begins
    public static void main(String[] args) {
        // Instantiates a new Pizza object named 'order' with a size of "Medium"
        Pizza order = new Pizza("Medium");

        Bane banes = new Bane();

        // Invokes addTopping to add "Pepperoni" to the 'order' object
        order.addTopping("Pepperoni");

        // Invokes addTopping to add "Mushrooms" to the 'order' object
        order.addTopping("Mushrooms");

        // Invokes addTopping to add "Green peppers" to the 'order' object
        order.addTopping("Green Peppers");

        // Invokes addTopping to add "Chicken" to the 'order' object
        order.addTopping("Chicken");

        // Invokes addTopping to add "Habanero peppers" to the 'order' object
        order.addTopping("Habanero peppers");


        // Prints the order summary description string to the system console
        System.out.println(order.getDescription());
        // Expected Console Output: Medium Pizza with Pepperoni | Total: $13.00

        // Expect Console Output: Medium Pizza with Mushrooms, Green Peppers, Chicken, Habenero peppers | 17.50
    }
}