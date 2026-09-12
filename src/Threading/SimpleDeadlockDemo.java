package Threading;

public class SimpleDeadlockDemo {
    // The two resources/locks our threads will fight over
    private static final Object LockA = new Object();
    private static final Object LockB = new Object();

    public static void main(String[] args)
    {
        Thread thread1 = new Thread(() -> {
            synchronized (LockA) {
                System.out.println("Thread 1: Holding Lock A...");

                try {
                    // Sleep to ensure Thread 2 has time to grab Lock B
                    Thread.sleep(50);
                } catch (InterruptedException e) {}

                System.out.println("Thread 1: Waiting for Lock B...");
                synchronized (LockB) {
                    System.out.println("Thread 1: Acquired Lock B!");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (LockB) {
                System.out.println("Thread 2: Holding Lock B...");

                try {
                    // Sleep to ensure Thread 2 has time to grab Lock B
                    Thread.sleep(50);
                } catch (InterruptedException e) {}

                System.out.println("Thread 2: Waiting for Lock B...");
                synchronized (LockB) {
                    System.out.println("Thread 2: Acquired Lock B!");
                }
            }
        });

        thread1.start();
        thread2.start();



    }
}
