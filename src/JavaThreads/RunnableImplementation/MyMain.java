package JavaThreads.RunnableImplementation;

public class MyMain {
    public static void main(String[] args) {
        Thread runnableThread = new Thread(new MyRunnable());
        runnableThread.start(); // creates the actual thread to runs the thread.
    }
}