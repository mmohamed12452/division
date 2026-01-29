package Caring;

import java.util.Scanner;

public class FanController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("The temperature should read the room temperature");
        int temperature = scanner.nextInt();

        if (temperature < 22)
        {
            System.out.println("fan speed = 1");
        }
        else if(temperature > 22 && temperature > 28){
            System.out.println("night time fan speed = 2");
        } else if (temperature < 38) {
            System.out.println("night time fan speed 3");

        } else if (temperature <=45){
            System.out.println("night time fan speed = 4");
        }
        else {
            System.out.println("fan speed = 5");
        }

    }
}
