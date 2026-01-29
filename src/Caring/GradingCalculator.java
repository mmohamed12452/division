package Caring;

import java.util.Scanner;

public class GradingCalculator {
    public static void main(String[] args) {

        // first we have to create a scanner object to read user input.
        Scanner scanner = new Scanner(System.in);

        // we will prompt the user for our scores
        System.out.println("Enter your score: ");

        int score = scanner.nextInt();

        // here we will determine the grades based on my sticky notes

        if(score >= 80){
            System.out.println("Grade: A");
        } else if (score >=70) {
            System.out.println("Grade: B");
        } else if (score>=60) {
            System.out.println("Grade: C");
        } else if (score >=50) {
            System.out.println("Grade: D");
        } else if (score >= 40) {
            System.out.println("Grade: D-");
        }else {
            System.out.println("Grade: Fail");
        }

        // here we will close the scanner object to avoid any data leakage or data from being loss
        scanner.close();
    }
}
