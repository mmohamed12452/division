package Data_Structures_examples.Javasets;

import java.util.TreeSet;

public class JavaTreeSet {
    public static void main(String[] args) {
//        TreeSet<String> cars = new TreeSet<>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("BMW");  // Duplicate
//        cars.add("Mazda");
//        System.out.println(cars);
//        System.out.println(cars.contains("Mazda"));
//        System.out.println(cars.remove("Ford"));
//        System.out.println(cars.size());
//        System.out.println(cars);
//        for(String i : cars){
//            System.out.println(i);
//        }
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);
        System.out.println(numbers.contains(10));
        System.out.println(numbers.remove(10));
        System.out.println(numbers.size());
        System.out.println(numbers);
        for(int numbering : numbers){
            System.out.println(numbering);
        }
    }
}
