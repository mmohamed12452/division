package JavaThreads.RaceCondition;

public class RaceConditionDemo {
    public static void main(String[] args) {
        int correctResults = 0;
        int raceConditionResults = 0;

        System.out.println("Running race condition test 20 times...\n");

        for (int test = 1; test <= 20; test++) {
            BankAccount account = new BankAccount();
            account.setBalance(1000);

            Thread t1 = new Thread(() -> account.withdraw(200, "T1"));
            Thread t2 = new Thread(() -> account.withdraw(300, "T2"));

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {}

            int finalBalance = account.getBalance();

            if (finalBalance == 500) {
                correctResults++;
                System.out.println("Test " + test + ": Balance = " + finalBalance + " CORRECT");
            } else {
                raceConditionResults++;
                System.out.println("Test " + test + ": Balance = " + finalBalance + "RACE CONDITION!");
            }
        }

        System.out.println("\n=== STATISTICS ===");
        System.out.println(" Correct results: " + correctResults + "/20");
        System.out.println(" Race condition results: " + raceConditionResults + "/20");
        System.out.println("Race condition occurred " + (raceConditionResults * 5) + "% of the time");
    }
}
