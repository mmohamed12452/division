import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceSimulation {
    // Question 5: Racing match usian bolt

    // Thread-safe list to record the order in which runners finish
    private static final List<String> finishOrder = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        // Create 3 runner objects
        Runner r1 = new Runner("Usain Bolt", 5.0);
        Runner r2 = new Runner("Tyson Gay", 4.5);
        Runner r3 = new Runner("Yohan Blake", 4.2);

        // Create threads for each runner
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        // Start all threads simultaneously
        t1.start();
        t2.start();
        t3.start();

        try {
            // Wait for all runners to finish the race
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("The race was interrupted!");
        }

        // Announce the winner safely from the main thread
        System.out.println("\n--------------------------------");
        if (!finishOrder.isEmpty()) {
            System.out.println("WINNER: " + finishOrder.get(0) + "!");
        }
        System.out.println("--------------------------------");
    }

    // Runner class implementing Runnable
    static class Runner implements Runnable {
        private final String name;
        private final double speed; // meters per second
        private int distanceCovered = 0;
        private final int totalDistance = 100;

        public Runner(String name, double speed) {
            this.name = name;
            this.speed = speed;
        }

        @Override
        public void run() {
            System.out.printf("%s started! (Speed: %.1f m/s)%n", name, speed);

            // Calculate sleep time per meter in milliseconds
            // (1 meter / speed) * 1000 ms
            long timePerMeterMs = (long) ((1.0 / speed) * 1000);

            while (distanceCovered < totalDistance) {
                try {
                    // Simulate running 10 meters
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(timePerMeterMs);
                        distanceCovered++;
                    }

                    // Print progress every 10 meters
                    System.out.printf("%s: %dm completed%n", name, distanceCovered);

                } catch (InterruptedException e) {
                    System.out.println(name + " tripped and fell!");
                    return;
                }
            }

            // Calculate total time taken
            double totalTime = totalDistance / speed;
            System.out.printf("%s completed! Time: %.1f seconds%n", name, totalTime);

            // Add to finish order list safely
            finishOrder.add(name);
        }
    }
}