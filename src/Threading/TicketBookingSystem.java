package Threading;

import java.util.LinkedList;
import java.util.Queue;

public class TicketBookingSystem {
    private static class BookingQueue {
        private final Queue<String> queue = new LinkedList<>();
        private final int CAPACITY = 10;

        // Thread-safe method for Booking Agent to add our bookings
        public synchronized void addBooking(String ticket) throws InterruptedException {
            // while the queue is full, the agent must wait
            while (queue.size() == CAPACITY) {
                System.out.println("[Queue FULL] "   + Thread.currentThread().getName() + " is waiting...");
                wait();
            }

            queue.add(ticket);
            System.out.println(Thread.currentThread().getName() + " added: " + ticket + " | Size: " + queue.size());
            // Notify the confirmation system that new booking is available
            notifyAll();
        }

        // Thread safe method for Confirmation System to process bookings
        public synchronized String processBooking() throws InterruptedException {
            while (queue.isEmpty()) {
                System.out.println("[Queue EMPTY] Confirmation system is waiting for bookings...");
                wait();
            }

            String ticket = queue.poll();
            System.out.println("Confirmation System processed: " + ticket + " | Size: " + queue.size());

            // Notify waiting booking agents that space has cleared up
            notifyAll();
            return ticket;
        }
    }

    public static void main(String[] args) {
        BookingQueue bookingQueue = new BookingQueue();
        int totalPeople = 100;

        // 1. Consumer: Confirmation System Thread
        Thread confirmationSystem = new Thread(() -> {
            try {
                for (int i = 0; i < totalPeople; i++) {
                    bookingQueue.processBooking();
                    // Simulate processing time
                    Thread.sleep(150);
                }
                System.out.println("=== All 100 bookings successfully processed! ===");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Confirmation-System");

        confirmationSystem.start();

        // 2. Producers: 100 Booking Agents (Each trying to book one ticket concurrently)
        for (int i = 1; i <= totalPeople; i++) {
            final String ticketName = "Ticket #" + i;
            new Thread(() ->
            {
                try {
                    // Simulate slight variance in arrival times
                    Thread.sleep((int) (Math.random() * 50));
                    bookingQueue.addBooking(ticketName);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Agent: " + i).start();
        }
    }
}

