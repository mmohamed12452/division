public class LibraryFeeCalculator {
    public static void main(String[] args) {
        int[] lateDays = {3, 7, 12, 0, 5};
        int totalFine = 0;

        for(int days : lateDays)
        {
            if(days <= 5){
                totalFine += days * 20; // Multiply days * 20 and adds to totalfine.
            } else if (days <= 10) {
                totalFine += days * 50; //
            }
            else {
                totalFine += days * 100;
            }
        }
        System.out.println("Total fine: " + totalFine + " USD");
    }
}
