package Data_Structures_examples.JavaMaps;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> people = new HashMap<String, Integer>();
        people.put("Henry", 10);
        people.put("steve", 14);
        people.put("Bryson", 12);
        people.put("John", 15);
        people.put("Bob", 16);
        people.put("Jenny", 17);
        for(String i : people.keySet()){
            System.out.println("key: " + i + "value: " + people.get(i));
        }
        System.out.println(people);

    }
}
