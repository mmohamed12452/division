package Threading;

public class SimpleProducerConsumer {
    public static void main(String[] args) {
        SimpleSharedResource simpleSharedResource = new SimpleSharedResource();
        Thread producer = new Thread(()-> {
           try{
               for (int i = 1; i<= 5; i++){
                   simpleSharedResource.produce(i);
                   Thread.sleep(500);
               }
           } catch (InterruptedException e) {

           }
        });

        Thread consumer = new Thread(()->{
            try{
                for (int i = 1; i<= 5; i++){
                    simpleSharedResource.consume();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {

            }
        });
        producer.start();
        consumer.start();
    }
}
