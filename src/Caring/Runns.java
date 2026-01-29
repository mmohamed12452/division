package Caring;

import java.util.ArrayList;

public class Runns {
    public static void main(String[] args) {
//        ArrayList<String> cars = new ArrayList<String>();
//        cars.add("Alis");
//        cars.add("John");
//        cars.add("Tiller");
//        cars.add("Bryson");
//        cars.get(0);
//        System.out.println(cars.get(0));

//

//        if(100<99){
//            System.out.println("Hello how is the going");
//        }
//        else {
//            System.out.println("100 is greater than 99 the statement is error");
//        }
//
//        int weather = 3;
//        if(weather == 10){
//            System.out.println("tariq is not good");
//        } else if (weather >= 3) {
//            System.out.println("James is not a good person");
//        }
//        else {
//            System.out.println("This statement is correct the weather is sunny");
//        }
//
//        try {
//            int[] numbers = {1,2,4,5,6,7,10,12,13,14,15,20};
//            System.out.println(numbers[10000]);
//            int results = 10/0;
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Array index does not exist.");
//        }
//        catch (ArithmeticException e){
//            System.out.println("cannot divide by zero");
//        }
//        catch (Exception e)
//        {
//            System.out.println("something else");
//        }

        try {
            int result = 10 / 0;
            int[] numbering = {1, 2, 4, 5, 6, 710, 100, 200, 545, 900};
            System.out.println(numbering[4000000]);
        }
        catch (ArithmeticException  | ArrayIndexOutOfBoundsException exception) {
            System.out.println("the math error here is not correct check make sure the index is corresponding to the list of array");
        }

//        try {
//            int[] mycar = {1,2,3,4,5,6};
//            System.out.println(mycar[100]);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Array is 100 is not in bound.");
//        }
    }
}
