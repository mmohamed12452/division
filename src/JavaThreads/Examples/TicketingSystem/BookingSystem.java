package JavaThreads.Examples.TicketingSystem;

public class BookingSystem
{
    private int avaliableSeats = 10;
    public synchronized boolean bookTicket(String customerName, int seats) {
        System.out.println(customerName + "Trying to book" + seats + "seats");
        if (avaliableSeats >= seats){
            System.out.println("Avaliable seats: " + avaliableSeats);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {

            }
            avaliableSeats -= seats;
            System.out.println(customerName + "Booked, remaining: " + avaliableSeats);
            return true;
        }
        else {
            System.out.println(customerName + "Failed! only " + avaliableSeats + "Seats left.");
            return false;
        }
    }



    public int getAvaliableSeats() {
        return avaliableSeats;
    }

}

