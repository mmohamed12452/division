package Deadlocks.Deadlockprevention.trylock;

public class DeadLockDemo {
    public static void main(String[] args) {
        DeadLockExample deadLockExample = new DeadLockExample();
        Thread t1 = new Thread(()->deadLockExample.method1(),"Thread 1");
        t1.start();
    }
}
