package Deadlocks.Deadlockprevention.trylock.Lion;

class Lion extends Animal {
    // hidden attributes
    private String lions;
    private int lionage;

    public Lion(String animals, int age) {
        super(animals, age);
    }

    public String getlions() {
        return lions;
    }

    public void setKinglions(String lions) {
        this.lions = lions;
    }

    public int getLionage() {
        return lionage;
    }

    public void setLionage(int lionage) {
        this.lionage = lionage;
    }

    public static void main(String[] args) {
   Animal animal = new Animal("cats", 10);
   System.out.println(animal.getAge());
   System.out.println(animal.getAnimals());


    }
}
