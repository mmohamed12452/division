package Deadlocks.Deadlockprevention.trylock.Lion;

public class Animal {

    // hidden attribute
    private String animals;
    private int age;
    public String cats;

    public Animal(String animals, int age) {
        this.animals = animals;
        this.age = age;
    }

    // getting the animal
    public String getAnimals() {
        return animals;
    }
   // reading the animal variable name.
    public void setAnimals(String animals) {
        this.animals = animals;
    }
    // getting the animals age.
    public int getAge() {
        return age;
    }

    // updating the animals age
    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Animal myanimal = new Animal("Henry", 10);
        System.out.println("Animal Name: "  + myanimal.animals);
        System.out.println("Animal Age: " + myanimal.age);

    }

    // output:
    // Animals Name: Henry
    // Animals Age: 9
}
