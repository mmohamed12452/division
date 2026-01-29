package Caring;

public class Tariq {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        // 0
        // 1
        // 2
        // 3
        // 4
        System.out.println("*******************************************************************************************");
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                continue;  // Skip the iteration when i is 3
            }
            System.out.println(i);
        }
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                continue;
            }
            System.out.println(i);
        }
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        int number = 10;
        for (int i = 0; i < number; i++) {
            if (i == 4) {
                break;
            }
            System.out.println(i);
        }
    }
}
