package Deadlocks.Deadlockprevention;

import java.util.HashMap;
import java.util.Map;

public class kelly {

    public static void main(String[] args) {

        // 1) Create a HashMap
        HashMap<Integer, String> stocking = new HashMap<>();


        // 2) add values
        stocking.put(10, "Banana");
        stocking.put(1000, "Banana");
        stocking.put(20, "apple");
        stocking.put(100, "apple");
        stocking.put(30, "orange");
        stocking.put(40, "grapes");
        stocking.put(50, "Pineapple");
        stocking.put(60, "Lemon");
        stocking.put(70, "Papaya");
        stocking.put(80, "Apples");


        //10
        //1000
        //20
        //100
        //30
        //40
        //50
        //60
        //70
        //80


       // 3) Access an element
//        stocking.get(10);
        // Banana
//        System.out.println(stocking);
//        System.out.println(stocking.get(10));
//        System.out.println(stocking.get(20));
//        System.out.println(stocking.get(30));
//        System.out.println(stocking.get(40));
//        System.out.println(stocking.get(50));
//        System.out.println(stocking.get(60));
//        System.out.println(stocking.get(70));
//        System.out.println(stocking.get(80));
//        System.out.println(stocking.remove(10));
//        System.out.println(stocking.get(10));
        System.out.println(stocking.size());

        // for each loop for keys
        for(Integer stock : stocking.keySet()){
            System.out.println(stock);
        }

        for(String stocker : stocking.values()){
            System.out.println(stocker);
        }
        System.out.println(stocking);
//        System.out.println(stocking);
        // banana
        // apple
        //...
          // get = read element or data or set = changing value.

        // Apples Stock: Apple is talking and said hello!




    }


}
