package Deadlocks.Deadlockprevention;

// the class Car blueprint
public class Cars {


    // No argument constructor
    public Cars() {
//        this.color = "blue";
    }

    // parameterized constructor
    public Cars(String color, String model, int year) {
//        this.color = color;
//        this.model = model;
//        this.year = year;
    }

    public static void main(String[] args) {
        Cars myCars = new Cars("Red", "BMW",2004); // initialized object.
//        System.out.println(myCars.color);
//        System.out.println(myCars.model);
//        System.out.println(myCars.year);
    }
}
