package Deadlocks.Deadlockprevention;

public class Running{
    public static void main(String[] args) {
        int[] numbers = {12, 34, 23, 23, 1, 3, 22, 40};

        System.out.println("Numbers that appear only once: ");
        for (int i = 0; i < numbers.length; i++) {
            int count = 0;

            // Count how many times numbers[i] appears in the whole array
            for(int j = 0; j< numbers.length; j++){
                if (numbers[i] == numbers[j]) {
                    count++;
                }
            }

            // If it appears exactly once, it is unique
            if(count == 1){
                System.out.println(numbers[i] + " ");
            }
        }
    }
}
