package Caring;

public class InvertedPyramid {
    public static void main(String[] args) {
        int n = 5;
         // number of rows

        for (int i = 0; i < n; i++) { // outer loop for rows

            // print spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

             // print stars
            for (int j = 0; j <= 2 * (n - i) - 1; j++) {
                System.out.print("*");
            }

            // move to next line
            System.out.println();

        }
    }

    //*********
    // *******
    //  *****
    //   ***
    //   **

    //**********
    // ********
    //  ******
    //   ****
    //    **


    //**********
    // ********
    //  ******
    //   ****
    //    **



}
