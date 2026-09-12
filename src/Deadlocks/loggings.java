package Deadlocks;

import java.util.ArrayList;

public class loggings {
    public static void main(String[] args) {
        ArrayList<Integer> cars = new ArrayList<>();
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Berry");
        fruits.add("grapes");
        fruits.add("dates");
        fruits.add("cabbage");
// enhanced loops
        for (String fruit : fruits){
            System.out.println(fruit);
        }

        // add values
        cars.add(0);
        cars.add(1);
        cars.add(2);
        cars.add(3); // 4
        cars.set(3,4);
        cars.add(4); // 4
        cars.add(5);
        cars.set(5,5);
        cars.add(6);
        cars.add(7);
        cars.add(8);
        cars.add(9);
        cars.add(10);
        cars.add(11);
        cars.add(12);
        cars.add(14);
        cars.add(16);
        cars.add(20);
        cars.add(24);
        cars.add(40);
        cars.add(43);
        cars.add(48);
        cars.add(50);


        // [0,1,2,4,4,5,6,7,8,9,10,11]

        //
//        for (int i = 0; i<=cars.size(); i++){
//            System.out.println(cars.get(i));
//        }

//        for (int i = 0; i<=cars.size(); i++){
//            System.out.println(cars.get(i));
//        }



        //[1,2,3,4,5,6,8,9,10,11]
//        System.out.println(cars.size());
//        System.out.println(cars);


        // output of arraylist: 10;
        // arraylist out of boundsExeception arraylist 11

        // [0,1,2,3,4,5,6,7,8,9,10,11]
        //  0
    }
}
