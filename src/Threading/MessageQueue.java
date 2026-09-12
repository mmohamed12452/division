package Threading;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {
    private Queue<String> messages = new LinkedList<>();
    private final int MAX_SIZE = 5;

    public synchronized void send(String message) throws InterruptedException{
        while (messages.size() == MAX_SIZE){
            System.out.println("Queue full, sender is waiting");
            wait();
        }
        messages.add(message);
        System.out.println("SENT: " + message + "|Queue size: " + messages.size());
        notifyAll();
    }

    public synchronized String receive() throws InterruptedException{
        while (messages.isEmpty()){
            System.out.println("Queue empty, receiver waiting");
            wait();
        }
        String message = messages.poll();
        System.out.println("Received: " + message + "|Queue size: " + messages.size());
        notify();
        return message;
    }


}
