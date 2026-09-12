package Deadlocks.Deadlockprevention.trylock.Lion;

public class Cars {
    // Attributes
    private String brand;
    private int year;

    // Constructor to initialize objects attrbutes
    public Cars(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
   // method defining object behavior
    public void displayInfo(){
        System.out.println("Car Brand: " + brand + ", Year: " + year);
    }
}
