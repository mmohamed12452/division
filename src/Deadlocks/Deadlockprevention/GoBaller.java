package Deadlocks.Deadlockprevention;

import java.util.Arrays;

public class GoBaller {
    public static void main(String[] args)
    {

        // First way of creating an array fixed size.
//        int[] numbers = new int[6];

//        int[] cars = {1,2,3,4,5,6,7};
//        System.out.println(cars[2]);
        // Second way of creating an array.
//        String[] cars = {"Car", "Ben", "Ford", "Mazda"};
//        cars[1] = "Henry";
//        cars[2] = "John";
//        System.out.println(cars.length);
        // {Car, Henry, John, Mazda}
        // 4

        // for  loop
//        int[] numbers = {10,20,30,40,50,60,70,80,90,100,200,300,400,500,600,700};
//
//        for (int i = 0; i < numbers.length; i++){
//            System.out.println("Element at position " + i + ": " + numbers[i]);
//        }
//
//        String[] fruits = {"Apple", "Cherry", "Grapes", "berrys"};
//
//        for (String fruit : fruits){
//            System.out.println(fruit);
//        }

//        int[][] matric =
//                {
//                        {1, 2, 3}, // array 0
//                        {4, 5, 6},  // array 1
//                        {7, 8, 9},  // array 2
//                        {10, 11, 12}, // array 3
//                        {13, 14, 15}, // array 4
//                        {16, 17, 18}, // array 5
//                        {19, 20, 21} // array 6
//                };
        // access the number 5
//        System.out.println(matric[4][1]);
//        System.out.println(matric[4][0]);
//        System.out.println(matric[3][2]);
//        System.out.println(matric[1][0]);
//        System.out.println(matric[6][2]);
//        System.out.println(matric[5][2]);

        // changed the value of the multidimensional array
//        matric[1][1] = 10;
//        System.out.println(matric[1][1]);

        // the multidimensional length
//        System.out.println("Rows: " + matric.length);
//        System.out.println("Cols in row 1: " + matric[1].{length);
//        System.out.println("Cols in row 2: " + matric[2].length);
//        System.out.println("Cols in row 3: " + matric[3].length);
//        System.out.println("Cols in row 4: " + matric[4].length);
//        System.out.println("Cols in row 5: " + matric[5].length);
//        System.out.println("Cols in row 6: " + matric[6].length);

//        int[][] matrix =
//                {
//                        {1,2,3}, // array 1
//                        {4,5,6}, // array 2
//                        {7,8,9}  // array 3
//                };
//
//
//        for (int i = 0; i< matrix.length; i++)
//        {
//            for (int j = 0; j < matrix[i].length; j++)
//                System.out.println(matrix[i][j] + " ");
//        }
//        System.out.println();
//
//        }

        // for each nested loop - for each loop is loop within a loop and it is the cleanest and most readable way to iterate through mutidimensional arrays.


        // Declared 2D dimensional array named grid.
        int[][] grid = {
                // 2D array with 3 rows and 3 columns
                {10,20,30},
                {40, 50, 60},
                {70, 80, 90}

        };

        // Starting our an enhanced for loop over the outer array grid
        for(int[] row : grid){
            // grid contains  1D integer array, the data type of our values is must int
            // The first row is {10,20,30} and assigns it to the local variable row. It will repeat this block until every row inside grid has been processed.

            // Since row is an array of individual integers(int[]), the variable number holds a single int at a time.
            for (int number : row){
                // print ln prints the items or values and moves the cursor to the next line.
                System.out.println(number + " ");
                // " " is contatination  is attached to space out the numbers and makes the numbers appear next line.
            }
            System.out.println();
        }
        // it goes here and prints nothing.
    }

    // 10 20 30
    // 40 50 60
    // 70 80 90

        // 1
        // 2
        // 3
        // 4
        // 5
        // 6
        // 7
        // 8
        // 9


    }
