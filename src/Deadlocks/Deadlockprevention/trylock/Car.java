// Specifies the package path where this Java file resides in the project structure
package Deadlocks.Deadlockprevention.trylock;

// Define the Car class, which acts as a blueprint for creating individual car objects.
public class Car {

    // Member variable (field) to store the car's unique registration/license plate number.
    private String registrationNumber;

    // Member variable (field) to store the make and model of the car (e.g., "Toyota Corolla").
    private String model;

    // Member variable (field) to store the daily rental price of the car.
    private double rentalPricePerDay;

    // Member variable (field) to keep track of availability: 'true' if available, 'false' if rented out.
    private boolean isAvailable;

    // Constructor: This special method is called when creating a new Car object to initialize its values.
    public Car(String registrationNumber, String model, double rentalPricePerDay) {
        // Assign the passed registration number argument to the car's instance variable.
        this.registrationNumber = registrationNumber;

        // Assign the passed model argument to the car's instance variable.
        this.model = model;

        // Assign the passed rental price argument to the car's instance variable.
        this.rentalPricePerDay = rentalPricePerDay;

        // By default, every newly created car starts off as available for rent (true).
        this.isAvailable = true;
    }

    // Method to handle renting out the car.
    public void rentCar() {
        // First, check if the car is currently available.
        if (isAvailable) {
            // If it is available, change its state to 'false' to indicate it is now rented.
            isAvailable = false;
            // Print a confirmation message indicating successful rental.
            System.out.println("Success: You have successfully rented the " + model + " (" + registrationNumber + ").");
        } else {
            // Edge Case Handling: If 'isAvailable' is already false, block the rental and print an error message.
            System.out.println("Error: The " + model + " (" + registrationNumber + ") is already rented and not available!");
        }
    }

    // Method to handle returning a previously rented car.
    public void returnCar() {
        // Check if the car is currently marked as rented out (isAvailable is false).
        if (!isAvailable) {
            // Change the state back to 'true', making the car available for future customers.
            isAvailable = true;
            // Print a confirmation message indicating successful return.
            System.out.println("Success: The " + model + " (" + registrationNumber + ") has been returned.");
        } else {
            // Edge Case Handling: If 'isAvailable' is already true, inform the user that it wasn't rented out.
            System.out.println("Notice: The " + model + " (" + registrationNumber + ") was not currently rented out.");
        }
    }

    // Getter method to retrieve the car's registration number.
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    // Getter method to retrieve the car's model.
    public String getModel() {
        return model;
    }

    // Getter method to retrieve the daily rental price.
    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    // Getter method to check whether the car is currently available.
    public boolean isAvailable() {
        return isAvailable;
    }

    // Main method: The entry point of the Java program where we test our Car implementation.
    public static void main(String[] args) {
        // Instantiate a new Car object representing a Honda Civic with daily rate $45.00.
        Car myCar = new Car("ABC-123", "Honda Civic", 45.00);

        System.out.println("--- Scenario 1: First customer tries to rent the car ---");
        // Attempt 1: Car is available, so this successfully changes its state to rented (isAvailable = false).
        myCar.rentCar();

        System.out.println("\n--- Scenario 2: Second customer tries to rent the SAME car ---");
        // Attempt 2 (Challenge Case): Car is already rented, so the program guards against double-renting and prints an error.
        myCar.rentCar();

        System.out.println("\n--- Scenario 3: Customer returns the car ---");
        // Return car: State flips back to available (isAvailable = true).
        myCar.returnCar();

        System.out.println("\n--- Scenario 4: Another customer tries to rent the returned car ---");
        // Attempt 3: Now that the car was returned, it can be rented out again successfully.
        myCar.rentCar();
    }
}
