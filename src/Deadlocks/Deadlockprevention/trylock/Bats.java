package Deadlocks.Deadlockprevention.trylock;

public class Bats {

    String animal;
    int count;

    public Bats(String animal, int count) {
        this.animal = animal;
        this.count = count;
    }

    public void messagePrinter()
    {
        System.out.println("I have: " + count + " " + animal);
        // I have: 100 Rabbit
    }
    public static void main(String[] args) {
        Bats bats = new Bats("Rabbit", 100);
        bats.messagePrinter();
    }
}
