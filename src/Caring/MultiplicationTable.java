package Caring;

public class MultiplicationTable {
    static void printMultiplicationTable(int number){
        // we will use for loop from 1 to 10
        for(int i = 1; i <= 10000; i++){
            int result = number * i;
            System.out.println(number + " x " + i + " = " + result);
        }
    }
    public static void main(String[] args) {
        int number = 7;
        printMultiplicationTable(number);
    }
    // 7 * 1 = 7
    // 7 * 2 = 14
    // 7 * 3 = 21
    // 7 * 4 = 28
    // 7 * 5 = 35
    // 7 * 6 = 42
    // 7 * 7 = 49
    // 7 * 8 = 56
    // 7 * 9 = 63
    // 7 * 10 = 70
}
