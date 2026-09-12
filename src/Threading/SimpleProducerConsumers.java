package Threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimpleProducerConsumers {
    public static void main(String[] args) {
        // A shared queue with a capacity of 3 items
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>(3);

        // Producer Thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Producing: " + i);
                    sharedQueue.put(i); // Blocks if the queue is full
                    Thread.sleep(500);  // Simulating time to produce
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    // Blocks if the queue is empty
                    int item = sharedQueue.take();
                    System.out.println("Consumed: " + item);

                    // Exit condition for this demo
                    if (item == 5) break;
                    Thread.sleep(100); // Simulating time to consume (slower)
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();
        consumer.start();
    }
}
