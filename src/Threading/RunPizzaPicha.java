package Threading;

public class RunPizzaPicha {
    public static void main(String[] args) {
        PizzaPicha pizzaPicha = new PizzaPicha();
        Thread cheif = new Thread(()-> {
            try {
                for (int i = 1; i<= 15; i++){
                    pizzaPicha.makePizza();
                    Thread.sleep(200);
                }
                System.out.println("Cheif finished work for the day.");
            }catch (InterruptedException e){
                System.out.println("Cheif went interrupted.");
            }
        });
        Thread waiter = new Thread(()->
        {
            try {
                for(int i = 1; i<=10; i++){
                    pizzaPicha.takePizza();
                    Thread.sleep(1000);
                }
                System.out.println("Waiter finished serving all customers");
            }catch (InterruptedException e){
                System.out.println("Waiter was interrupted");
            }
        });
        System.out.println("Pizza kitchen open");
        cheif.start();
        waiter.start();
        try{
            cheif.join();
            waiter.join();
        }catch (InterruptedException e){
            System.out.println("Main Thread interrupted.");
        }
        System.out.println("Kitchen is closed.");

    }
}
