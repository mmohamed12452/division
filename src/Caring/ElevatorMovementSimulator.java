package Caring;

import java.util.Scanner;

public class ElevatorMovementSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentFloor = 0;  // Starting on floor 0
        String command = "";

        // Loop to process commands until "STOP" is entered
        while (true)
        {
            System.out.print("Enter command (UP, DOWN, STOP): ");
            command = scanner.nextLine().toUpperCase();

            if (command.equals("STOP"))
            {
                break;  // Exit the loop if user enters STOP
            }

            switch (command) {
                case "UP":
                    if (currentFloor < 10) {
                        currentFloor++;  // Move up one floor
                    } else {
                        System.out.println("Can't go higher than floor 10.");
                    }
                    break;

                case "DOWN":
                    if (currentFloor > 0) {
                        currentFloor--;  // Move down one floor
                    } else {
                        System.out.println("Can't go below floor 0.");
                    }
                    break;

                default:
                    System.out.println("Invalid command. Please enter UP, DOWN, or STOP.");
            }
        }

        // Output the final floor
        System.out.println("The elevator is now on floor: " + currentFloor);

        scanner.close();
    }

    // UP
    // UP
    // UP
    // UP
    // UP
    // UP
    // UP
    // UP
    // UP
    // Up
    // DOWN
    // can't go below floor 0


}
