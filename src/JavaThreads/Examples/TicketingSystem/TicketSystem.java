package JavaThreads.Examples.TicketingSystem;

public class TicketSystem {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        Thread customer1 = new Thread(()->bookingSystem.bookTicket(" Mohamed ", 5));
        Thread customer2 = new Thread(()->bookingSystem.bookTicket(" Jane ", 6));
        Thread customer3 = new Thread(()->bookingSystem.bookTicket(" Bryson ", 8));
        customer1.start();
        customer2.start();
        customer3.start();

    }
}
