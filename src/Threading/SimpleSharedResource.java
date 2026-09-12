package Threading;

public class SimpleSharedResource {
    private int data = 0;
    private boolean hasData = false;
    public synchronized void produce(int value) throws InterruptedException{
        while (hasData){
            System.out.println("Producer waiting data not consumed yet");
            wait();
        }
        data = value;
        hasData = true;
        System.out.println("Produce: " + value);
        notify();
    }

    public synchronized void consume() throws InterruptedException{
        while (!hasData){
            System.out.println("Consumer waiting no data yet.");
            wait();
        }
        System.out.println("Consumed: " + data);
        hasData = false;
        notify();
    }
}
