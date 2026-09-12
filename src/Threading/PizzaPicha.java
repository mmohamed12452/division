package Threading;

public class PizzaPicha
{
    private int pizzaonCounter = 0;
    private final int MAX_CAPACITY = 5;

    public synchronized void makePizza()throws InterruptedException{
        while(pizzaonCounter == MAX_CAPACITY){
            System.out.println("Counter full cheif is waiting");
            wait();
        }
        pizzaonCounter++;
        System.out.println("Chef made a pizza! Total on counter: " + pizzaonCounter);
        notify();
    }

    public synchronized void takePizza() throws InterruptedException{
        while (pizzaonCounter == 0){
            System.out.println("Counter empty waiter waiting");
            wait();
        }
        pizzaonCounter--;
        System.out.println("Waiter took a pizza! Remaining: " + pizzaonCounter);
        notify();
    }
}
