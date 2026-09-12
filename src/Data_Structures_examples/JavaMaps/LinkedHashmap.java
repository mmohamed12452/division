package Data_Structures_examples.JavaMaps;

import java.util.LinkedHashMap;

public class LinkedHashmap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> fruits = new LinkedHashMap<>();
        fruits.put("Apple", 1);
        fruits.put("Henry", 2);
        fruits.put("Bob", 3);
        System.out.println(fruits);
        System.out.println(fruits.get("Apple"));
        System.out.println(fruits);
        System.out.println(fruits);
        System.out.println(fruits.size());
        fruits.remove("Henry");
        System.out.println(fruits);
        fruits.clear();
        System.out.println(fruits);
        System.out.println(fruits);
        for(String keys : fruits.keySet()){
            System.out.println(keys);
        } // keys
          for(Integer i : fruits.values()){
              System.out.println(i);
          } // values
        // {apple = 1, Henry = 2, bob = 3}
    }
}
