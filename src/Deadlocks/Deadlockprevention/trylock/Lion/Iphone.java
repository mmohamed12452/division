package Deadlocks.Deadlockprevention.trylock.Lion;

public class Iphone {

    void charge(){
        System.out.println("Wireless Charging");
    }
    void charge(int watts){
        System.out.println("Charging phone with " + watts + "w fast charger");
    }
    void charge(int volt, int amps){
        System.out.println("Charging phone with: " + volt + "v and " + amps + "a power adaptor");
    }

    void cameraFeature(){
        System.out.println("A normal camera");
    }
}
