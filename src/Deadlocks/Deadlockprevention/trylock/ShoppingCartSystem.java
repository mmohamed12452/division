// Specifies the package path where this Java file resides in the project structure
package Deadlocks.Deadlockprevention.trylock;

import java.util.ArrayList;
import java.util.List;

// Main class containing the entire program logic for the shopping cart system
public class ShoppingCartSystem
{
    // Represents an individual product item that a customer wants to buy
    static class Product {
        // Holds the descriptive text name of the product item
        private String name;

        // Holds the cost of a single unit of this product in dollars
        private double price;

        // Holds the number of units of this product being purchased
        private int quantity;

        // Constructor method that initializes a new Product object with specific values
        public Product(String name, double price, int quantity) {
            // Assigns the input parameter name to the internal instance variable name
            this.name = name;

            // Assigns the input parameter price to the internal instance variable price
            this.price = price;

            // Assigns the input parameter quantity to the internal instance variable quantity
            this.quantity = quantity;
        }

        // Getter method that retrieves and returns the stored name of the product
        public String getName() {
            // Returns the text stored in the name variable to the caller
            return name;
        }

        // Getter method that retrieves and returns the single unit price of the product
        public double getPrice() {
            // Returns the decimal value stored in the price variable to the caller
            return price;
        }

        // Getter method that retrieves and returns the quantity count of the product
        public int getQuantity() {
            // Returns the integer value stored in the quantity variable to the caller
            return quantity;
        }

        // Calculates the total financial cost for this specific item line
        public double calculateLineTotal() {
            // Multiplies the single unit price by the quantity to yield the total item cost
            return price * quantity;
        }
    }

    // Represents the container that manages a collection of products for a customer
    static class ShoppingCart {
        // Internal list data structure that dynamically stores multiple Product objects
        private List<Product> products;

        // Constructor method that sets up a brand new empty shopping cart instance
        public ShoppingCart() {
            // Instantiates an empty ArrayList to hold Product objects in memory
            this.products = new ArrayList<>();
        }

        // Method that adds a newly created Product instance into the cart list
        public void addProduct(Product product) {
            // Appends the provided Product object onto the internal products list
            this.products.add(product);
        }

        // Method that iterates through all items in the cart to compute the grand total cost
        public double calculateGrandTotal() {
            // Declares and initializes an accumulator variable to zero for summing prices
            double total = 0.0;

            // Executes a standard for-each loop over every Product object inside the list
            for (Product product : products) {
                // Invokes line total calculation for current product and adds result to running total
                total = total + product.calculateLineTotal();
            }
            // Returns the final aggregated grand total amount back to the calling method
            return total;
        }

        // Method that prints out a complete, structured receipt listing all items and total cost
        public void printReceipt() {
            // Outputs a top decorative border line for receipt formatting
            System.out.println("====== SHOPPING CART RECEIPT ======");

            // Executes a loop to process and display details for each individual item in cart
            for (Product product : products) {
                // Constructs and prints line item detailing name, quantity, unit price, and line total
                System.out.println(product.getQuantity() + "x " + product.getName() + " @ $" + product.getPrice() + " each = $" + product.calculateLineTotal());
            }

            // Outputs a middle visual separator line
            System.out.println("-----------------------------------");

            // Prints the computed grand total cost formatted clearly at the bottom of receipt
            System.out.println("GRAND TOTAL TO PAY: $" + calculateGrandTotal());

            // Outputs a bottom decorative border line to mark receipt completion
            System.out.println("===================================");
        }
    }

    // The primary entry point method where program execution begins
    public static void main(String[] args) {
        // Instantiates a new ShoppingCart object instance named myCart
        ShoppingCart myCart = new ShoppingCart();

        // Instantiates a first Product representing 2 laptops priced at $999.99 each
        Product item1 = new Product("MacBook Laptop", 999.99, 2);

        // Instantiates a second Product representing 3 wireless mice priced at $25.50 each
        Product item2 = new Product("Wireless Mouse", 25.50, 3);

        // Instantiates a third Product representing 1 mechanical keyboard priced at $75.00
        Product item3 = new Product("Mechanical Keyboard", 75.00, 1);

        // Adds the laptop product item into the shopping cart instance
        myCart.addProduct(item1);

        // Adds the wireless mouse product item into the shopping cart instance
        myCart.addProduct(item2);

        // Adds the mechanical keyboard product item into the shopping cart instance
        myCart.addProduct(item3);

        // Shopping cart grand total of all the 3 items put together.
        myCart.calculateGrandTotal();

        // Calls receipt printing method which calculates totals and displays formatted output
        myCart.printReceipt();
    }
}
