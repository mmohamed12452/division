package JavaThreads.ThreadImplementation;

public class Main {
    public static void main(String[] args) {
     MyThread thread = new MyThread();
     MyThread thread1 = new MyThread();
     MyThread thread2 = new MyThread();
     MyThread thread3 = new MyThread();
     thread.start();
     thread1.start();
     thread2.start();
     thread3.start();
    }
}
