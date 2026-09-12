package Deadlocks.Deadlockprevention.trylock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample
{
    private final Lock Lock1 = new ReentrantLock();
    private final Lock Lock2 = new ReentrantLock();
    public void method1() {

        while(true){
            try {
                if (Lock1.tryLock()){
                    try {
                        if (Lock2.tryLock()){
                            try{
                                System.out.println("Method 1 succeeded");
                                return;
                            }
                            finally {
                                Lock2.unlock();
                            }
                        }
                    }finally {
                        Lock1.unlock();
                    }
                }
                Thread.sleep(100);
            } catch (InterruptedException exception) {

            }
        }
    }

    public static void main(String[] args) {
        DeadLockExample deadLockExample = new DeadLockExample();
        Thread t1 = new Thread(()->deadLockExample.method1(),"Thread 1");
        t1.start();
    }
}
