package Caring;

public class BusSeatResveration {
    public static void main(String[] args) {
        // array to store seat numbers(1 to 20)
        int totalSeats = 20;
        int[] takenSeats = {3, 5, 11, 17};

        for (int seat = 1; seat <= totalSeats; seat++)
        {
            // Check if the seat is in the takenSeats array
            boolean isTaken = false;
            for (int takenSeat : takenSeats) {
                if (seat == takenSeat) {
                    isTaken = true;
                    break;
                }
            }
            if (isTaken) {
                System.out.println(seat + " [x] ");
            } else {
                System.out.println(seat + "[  ] ");
            }
        }

        //[]
        //[]
        //[x]
        //[]
        //[x]
        //[]
        //[]
        //[]
        //[]
        //[]
        //[x]
        //[]
        //[]
        //[]
        //[]
        //[]
        //[x]
        //[]
        //[]
        //[]
    }
}
