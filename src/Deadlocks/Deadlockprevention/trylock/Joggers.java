package Deadlocks.Deadlockprevention.trylock;

public class Joggers {
    // The attributes or variables
    String model = "Barry Allen";
    int speed = 100;

    // Method (Behavior or action that the method is doing)
     void drive(){
         System.out.println("The " + model + " is driving at " + speed + "km/h");
     }

    public static void main(String[] args) {
         // we created a object that calls the variables.
        Joggers myjoggers = new Joggers();
        System.out.println("Car model: " + myjoggers.model); // the variables are being accessed.
        System.out.println("Car speed: " + myjoggers.speed);

        // Car model: Barry Allen
        // Car speed: 100
    }
}
