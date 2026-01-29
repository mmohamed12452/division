package Data_Structures_examples.queueexample;

import java.util.LinkedList;
import java.util.Queue;

public class PrinterQueue {
    private Queue<PrintJob> printQueue;
    private int jobsProcessed;

    public PrinterQueue() {
        printQueue = new LinkedList<>();
        jobsProcessed = 0;
    }

    public void addJob(PrintJob job){
        printQueue.add(job);
        System.out.println("added to printqueue: " + job);
        displayQueueStatus();
    }
    public void processNextJob(){
       if(printQueue.isEmpty()){
           System.out.println("no job in queue to process");
           return;
       }
       PrintJob job = printQueue.remove();
       jobsProcessed++;


        System.out.println("**************** JOBS PROCESSED *********************");
        System.out.println("Processing : " + job);
        simulatePrinting(job.getPages());
        System.out.println("job completed");
        displayQueueStatus();
    }
    public void simulatePrinting(int pages){
     try{
         System.out.println("printing");
         for(int i = 0; i< pages; i++){
             Thread.sleep(200);
             System.out.print("*");
         }
         System.out.println();
     }
     catch (InterruptedException e){
         e.printStackTrace();
        }
    }
    public void displayQueueStatus(){
        System.out.println(" ******************* PRINTER_QUEUE_STATUS : ****************************" );
        System.out.println("jobs in queue " + printQueue.size());
        System.out.println("Total Jobs processed are: " + jobsProcessed);

        if (!printQueue.isEmpty() ){
            System.out.println("The next job to process is: " + printQueue.peek());
        }

        System.out.println("all jobs in queue are completed");
        int position = 1;
        for (PrintJob job : printQueue){
            System.out.println(position++ + ". " + job);
        }
        System.out.println();
    }
}
