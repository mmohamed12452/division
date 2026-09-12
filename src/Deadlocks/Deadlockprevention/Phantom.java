package Deadlocks.Deadlockprevention;

import java.util.Arrays;

public class Phantom {
    public static void main(String[] args) {
//        String name = "john";
//        System.out.println(name);
//
//        int car; // declare variable
//        int cars = 10; // assigning variable with value.
//
//        float output = 10.00f;
//        System.out.println(output);
//
//        // myvariable and myVariable and MYVARIABLE
//        char myLetter = 'D';
//        System.out.println(myLetter);
//
//        boolean myboolean = true;
//        System.out.println(myboolean);
//
//        double mydouble = 10.0d;
//        System.out.println(mydouble);
//        byte mybyte = 30;
//        System.out.println(mybyte);

        // As long as the loop is true it will keep executing, but the moment it becomes false it terminates or exits.

//        for(int i = 0; i <=5; i++){
//            System.out.println("iteration: " + i);
//        }

        // Iteration: 0
        // Iteration: 1
        // Iteration: 2
        // Iteration: 3
        // Iteration: 4
        // Iteration: 5

//        int count = 7;
//        while(count <= 6){
//            System.out.println("Count is: " + count);
//            count++;
//        }

        // Count is: 0
        // Count is: 1
        // Count is: 2
        // Count is: 3
        // Count is: 4
        // Count is: 5
        // Count is: 6

//        int number = 7;
//        do {
//            System.out.println("This will be print at least once.");
//        }while (number < 5);

        //  This will be print at least once


        // For each loop
//
//        int[] numbering = {1,2,3,4,5,6};
//        for (int num: numbering){
//            System.out.println(num);
//        }

        // num is a single item in the array we are going through.

        // Break Statement

//      for(int i = 1; i<=10; i++)
//      {
//          if (i == 5){
//              break; // exit the loop immediately when i is 5
//          }
//          System.out.println(i);
//      }
//      System.out.println("Loop finished!");

        // 1
        // 2
        // 3
        // 4
        // Loop finished!
//
//        for (int i = 1; i<= 5; i++)
//        {
//            if (i == 3){
//                continue; // skips the rest of the loop body for i = 3
//            }
//            System.out.println(i);

            // 1
            // 2
            // 4
            // 5
        // }

        // Array Length Property
//        int[] numbers = {10,20,30,50};
//        System.out.println("Array size: " + numbers.length);

        // array Copy
//        int[] original = {1,2,3};
//        int[] referenceCopy = original; // both variables now are point to the exact same array.
//        referenceCopy[1] = 99;
//        System.out.println(original[1]);

        // array copy of
//       int[] original = {1,2,3};
//       int[] trueCopy = Arrays.copyOf(original,original.length);
//       trueCopy[0] = 20;
//
//        System.out.println(original[0]); // output: 1 is remained untouched
//




//        short populate = 32000;
//        System.out.println(populate);
//
//        Long worldpopulations = 8000000000L;
//        System.out.println(worldpopulations);

        // Widening casting - byte -> short -> int -> long
         // 1. Start with a byte (8-bit signed integer)
//         byte  myByte = 32;
//        System.out.println("byte value: " + myByte);
//
//        // 2. byte automatically widens to short (16-bit signed integer)
//        short myShort = myByte;
//        System.out.println("widened to short: " + myShort);
//
//        // 3.short automatically widens to int (32-bit signed integer)
//        int myInt = myShort;
//        System.out.println("Widened to long: " + myInt);
//
//        // 4. int automatically widens to long (64-bit signed integer)
//        long myLong = myInt;
//        System.out.println("Widened to long: " + myLong);
//
//        // 5. long automatically widens to float (32-bit floating point)
//        // Note: Even though long is 64-bit and float is 32-bit, float can represent
//
//        float myFloat = myLong;
//        System.out.println("widened to float: " + myFloat);
//
//        // 6. float automatically widens to double (64-bit floating point)
//        double myDouble = myFloat;
//        System.out.println("widened to double: " + myDouble);

        // byte - range: -128 to 127

        //short - range: -32,768 to 32,767

        // int - range: 2 billion to 2 billion

        // long - range: massive integer space

        // float  wider range due to exponential notation.

        // double - the largest primitive type


        //-------------------------------------

        // Narrow casting

        // 1. Start with a double (64-bit floating point)
//        double myDoubles = 125.75;
//        System.out.println("Original double " + myDoubles);
//
//        // 2. double to float (Requires explicit cast)
//        float myFloats = (float) myDoubles;
//        System.out.println("Narrowed to float: " + myFloats);
//
//        // 3. float to long (Fractional part .75 is completely truncated/chopped off)
//        long myLongs = (long) myFloat;
//        System.out.println("Narrowed to long: " + myLongs);
//
//        // 4. Long to int
//        int myInts = (int) myLongs;
//        System.out.println("Narrowed to int: " + myInts);
//
//        // 5. int to short
//        short myShorts = (short) myInts;
//        System.out.println("Narrowed to short: " + myShorts);
//
//        // 6. short to byte (125 fits inside a byte's range of -128 to 127)
//        byte myBytes = (byte) myShorts;
//        System.out.println("Narrowed to byte: " + myBytes);

//        final int age = 10;
//        final double ages = 10.00;
//
//        System.out.println();

//        for (int i = 1; i<=10; i++){
//            System.out.println("Iterates: " + i);
//        }
    }
}
