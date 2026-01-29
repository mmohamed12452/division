package Caring;

abstract class Scarfs {
    public abstract void myScarfs();
    public abstract void animalSound();

    public void Sleep(){
        System.out.println("The going is well in kenya! the weather is rainy showers");
    }

    public static void main(String[] args) {
        Jog myJog = new Jog();
        myJog.myScarfs();
        myJog.animalSound();
        myJog.Sleep();
    }
}
