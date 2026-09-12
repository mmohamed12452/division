package Deadlocks.Deadlockprevention.trylock.Lion;

public class Phone {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        iphone.charge();
        iphone.charge(20);
        iphone.charge(30,50);
        iphone.cameraFeature();
        iphone = new Seventeen();
        iphone.cameraFeature();
        iphone = new Eighteen();
        iphone.cameraFeature();


        // Wireless Charging
        // Charging phone with 20w fast charger
        // Charging phone with 30v and 50a power adaptor


    }
}
