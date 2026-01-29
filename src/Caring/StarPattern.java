package Caring;

public class StarPattern {
    public static void main(String[] args) {

        int rows = 7; // Total number of rows in the pattern

        // Outer loop controls the number of rows
        for (int i = rows; i >= 1; i--) {
            // Inner loop controls how many stars to print on each row
            for (int j = 1; j <= i; j++) {
                System.out.print("*"); // print a star without moving to the next line
            }

            // Move to the next line after printing stars in one row
            System.out.println();
        }
    }



}



// *******
// ******
// *****
// ****
// ***
// **
// *

// *******
// ******
// *****
// ****
// ***
// **
// *

// *******
// ******
// *****
// ***
// **
// *






