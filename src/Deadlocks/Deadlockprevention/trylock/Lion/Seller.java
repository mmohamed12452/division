package Deadlocks.Deadlockprevention.trylock.Lion;

public class Seller {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Vehicle person1 = new Person();
        Vehicle bank1 = new Barber();
        vehicle.purchasingPrice();
        person1.purchasingPrice();
        bank1.purchasingPrice();
    }
}
