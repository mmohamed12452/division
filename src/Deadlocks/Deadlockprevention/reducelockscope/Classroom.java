package Deadlocks.Deadlockprevention.reducelockscope;

public class Classroom {
    // This is the shared resource both threads will fight over
    private int pageNumber = 1;

    public void writeInNotebook(String studentName){
        // STEP 1: Outside the lock scope.
        // Both students can "think" at the exact same time.
        System.out.println(studentName + " is thinking about what to write...");
        try {
            Thread.sleep(500); // Simulating time spent thinking
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // STEP 2: Inside the lock scope.
        // Only ONE student can hold the lock on 'this' classroom at a time.
        synchronized (this){
            System.out.println(">>> LOCK ACQUIRED BY: " + studentName);
            System.out.println(studentName + " wrote on page: " + pageNumber);
            pageNumber++;
            System.out.println("<<< LOCK RELEASED BY: " + studentName);
            System.out.println("------------------------------------");
        }
        // End of lock scope
    }

    public static void main(String[] args)
    {
        Classroom sharedClassroom = new Classroom();

        // Create Student A (Thread 1)
        Thread studentA = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                sharedClassroom.writeInNotebook("Alice");
            }
        });

        // Create Student B (Thread 2)
        Thread studentB = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                sharedClassroom.writeInNotebook("Chris Brown");
            }
        });

        // Start both threads
        studentA.start();
        studentB.start();
    }
}
