package Caring.automobile;

public class Car extends Vehicle{
    public Car(String red, String bmw, int year) {
        super();
    }

    @Override
    public void move() {
        System.out.println("The car is remotely driving on road.");
    }
}
