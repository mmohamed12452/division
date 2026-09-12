package Data_Structures_examples.Javasets;

import java.util.HashSet;

public class JavaHashSet {
    public static void main(String[] args) {
        HashSet<String> cars = new HashSet<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");
        cars.add("BMW"); // Duplicate
        cars.add("Mazda");
        System.out.println(cars.size());
        System.out.println(cars);
        for(String i : cars){
            System.out.println(i);
        }
    }
}
