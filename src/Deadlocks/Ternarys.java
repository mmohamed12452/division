package Deadlocks;

public class Ternarys {
    public static void main(String[] args) {
        System.out.println("Counting to 5 and checking parity:");

        // For Loop: Start at 1, goes up to 5
        for(int i = 1; i<= 5; i++){

            // 2. the ternary operator
            // if(i % 2 == 0) is true, result is "Even." Otherwise, it's "Odd".
            String type = (i % 2 == 0) ? "Even" : "Odd";

            System.out.println("Number " + i + " is " + type);
        }

        // 3. While Loop: A different way to repeat
        int count = 3;
        System.out.println("\nBlast off countdown:");
        while(count > 0){
            System.out.println(count + "...");
            count--; // important: decrease count or the loop never ends.
        }
        System.out.println("Liftoff!");
    }
}
