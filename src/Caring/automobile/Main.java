package Caring.automobile;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle1 = new Car();
        Vehicle vehicle2 = new Bicycle();
        vehicle1.move();
        vehicle2.move();

        // array for loop
        Vehicle[] vehicles = {vehicle1, vehicle2};
        for(Vehicle vehicle: vehicles){
            vehicle.move();
        }


    }
}
