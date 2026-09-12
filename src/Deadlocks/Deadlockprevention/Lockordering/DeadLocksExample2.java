package Deadlocks.Deadlockprevention.Lockordering;

public class DeadLocksExample2 {
    private final Object Lock1 = new Object();
    private final Object Lock2 = new Object();

    public void method1() {
        synchronized (Lock1) {
            System.out.println("Thread " + Thread.currentThread().getName() + " acquired lock1 ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {

            }
            System.out.println("Thread " + Thread.currentThread().getName() + " waiting for lock2 ");
            synchronized (Lock2) {
                System.out.println("Thread " + Thread.currentThread().getName() + " acquired both locks ");
            }
        }
    }

    public void method2() {
        synchronized (Lock1) {
            System.out.println("Thread " + Thread.currentThread().getName() + " acquired lock1 ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {

            }
            System.out.println("Thread " + Thread.currentThread().getName() + " waiting for lock2 ");
            synchronized (Lock2) {
                System.out.println("Thread " + Thread.currentThread().getName() + " acquired both locks ");
            }
        }
    }

}
