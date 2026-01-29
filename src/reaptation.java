import java.util.Scanner;

public class reaptation {
    public static void main(String[] args) {
        // for loops example
//        for(int i = 10; i<20; i++){
//            System.out.println(i);
//        }

        // for each example
//        int[] arrayOfNumbers = {2,4,6,8,10,12,24,30,35,40,45};
//        for(int x : arrayOfNumbers){
//            System.out.println(x);
//        }

//        Scanner sc = new Scanner(System.in);
//        int sum = 0;
//        int n;
//
//        System.out.println("Enter numbers to sum(enter 0 to stop):");
//        while (true) {
//            System.out.println("Enter number: ");
//            n = sc.nextInt();
//
//            if (n == 0) {
//                break;
//            }
//
//            sum += n;
//        }
//        System.out.println("Sum: " + sum);
//        sc.close();

        Scanner sc = new Scanner(System.in);
        int secretNumber = 7;
        int guess;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Try to guess the secret number between 1 and 10.");

        // the loop will always run at least once

        do {
            System.out.println("Enter your guess: ");
            guess = sc.nextInt();
            if (guess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Correct! You guessed the number!");
            }
        }while (guess != secretNumber);
        sc.close();
    }
}
