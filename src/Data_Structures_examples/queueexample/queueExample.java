package Data_Structures_examples.queueexample;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class queueExample {
    public static void main(String[] args) {
        Queue<String> myqueue = new LinkedList<>();
        System.out.println("**********  Basic QUEUE OPERATION *************");
        System.out.println("********** Adding elements to Queue ***********");
        myqueue.add("john");
        myqueue.add("henry");
        myqueue.add("gus");
        System.out.println("Current Queue Elements : " + myqueue);
        System.out.println("The size of the myqueue element is: " + myqueue.size());


        System.out.println("The first element in the Queue is: " + myqueue.peek());
        System.out.println("All elements in the Queue after peek is: " + myqueue);

        System.out.println("*********** Removing elements from a Queue *********  ");
        System.out.println(myqueue.remove());
        System.out.println("Remaining elements in our queque: " + myqueue);

        System.out.println("************ Check Queue status ***********");
        System.out.println("Is the queue empty: " + myqueue.isEmpty());

    }
}
