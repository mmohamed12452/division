package Deadlocks.Deadlockprevention.Lockordering;

public class DeadExampleDemo2 {
    public static void main(String[] args) {
        DeadLockExample deadLockExample = new DeadLockExample();
        Thread t1 = new Thread(()->deadLockExample.method1(),"Thread 1");
        Thread t2 = new Thread(()-> deadLockExample.method2(), "Thread 2");
        t1.start();
        t2.start();
    }
}
