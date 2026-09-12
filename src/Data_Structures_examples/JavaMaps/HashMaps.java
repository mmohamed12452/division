package Data_Structures_examples.JavaMaps;

import java.util.HashMap;

public class HashMaps {
    public static void main(String[] args) {
        HashMap<String, String> cars = new HashMap<String,String>();
        cars.put("Nissan", "Honda");
        cars.put("Toyota", "Corolla");
        cars.put("Range", "velar");
        cars.put("BMW", "i8");
        cars.put("Spider", "Miles");
        cars.put("Wraith", "Stars");
        cars.get("Spider");
        cars.remove("Toyota");
        System.out.println(cars.size());
        System.out.println(cars.get("Spider"));
        System.out.println(cars.remove("Toyota"));
        System.out.println(cars);
        for(String i : cars.keySet()){
            System.out.print(i);
        }
    }
}
