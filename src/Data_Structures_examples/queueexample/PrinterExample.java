package Data_Structures_examples.queueexample;

public class PrinterExample {
    public static void main(String[] args) {
        PrinterQueue printer = new PrinterQueue();


        printer.addJob(new PrintJob("java assignment.pdf1", 1,"Mohamed"));
        printer.addJob(new PrintJob("German assignment.pdf2", 2,"Bryson Tiller"));
        printer.addJob(new PrintJob("Stacks assignment.pdf3", 3,"Pnb Rock"));
        printer.addJob(new PrintJob("Queue assignment.pdf4", 4,"Chris Breezy"));


        printer.processNextJob();
        printer.processNextJob();


        printer.addJob(new PrintJob("Spanish homework 1", 5, "Tyler Watts"));
        printer.addJob(new PrintJob("French homework 2", 6, "Pop Smoke"));
        printer.addJob(new PrintJob("Zulu homework 3", 7, "Kehlani"));

        printer.processNextJob();
        printer.processNextJob();


        printer.processNextJob();
        printer.processNextJob();
        printer.processNextJob();



    }
}
