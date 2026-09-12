package Deadlocks.Deadlockprevention;

import Caring.BankAccount;

// Encapsulated class
class JoggingTracker
{
    // private data: hidden from the outside world
    private double totalKilometers;

    // public getter: allows outside classes to view the progress
    public double getTotalKilometers(){
        return totalKilometers;
    }
    // public method(setter-like): updates the data with built-in validation
    public void jog(double kilometers){
        if (kilometers > 0){
            totalKilometers += kilometers;  // totalkilometers + totalkilometers = kilometers
            System.out.println("Awesome! You just jogged " + kilometers + "km.");
        }else {
            System.out.println("Invalid distance. You can't jog backward or stand still!");
        }
    }

    public static void main(String[] args) {
      // Create a new tracker object
        JoggingTracker myTracker = new JoggingTracker();

        // 1) try to jog a valid distance
        myTracker.jog(5.2);
        System.out.println("Total distance today: " + myTracker.getTotalKilometers() + "km\n");

        // 2. Try to pass an invalid distance (Validation prevents it)
        myTracker.jog(-1000.0);
        System.out.println("Total distance today: " + myTracker.getTotalKilometers() + " km\n");
    }
}
