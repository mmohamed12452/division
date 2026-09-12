package Deadlocks.Deadlockprevention;

public class Mainer {
    public static int addNumbers(int num1, int num2){
     int multiply = num1 * num2;
     return multiply;
    }

    public static void main(String[] args) {
        int result = addNumbers(200, 100);
        System.out.println("The Multiplication is: " + result);
    }
}
