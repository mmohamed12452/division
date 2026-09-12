package Threading;

public class ChatUp {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        Thread sender = new Thread(() ->
        {
            String[] mymessages = {"henry", "bob", "John", "Abdi Bashir", "Abdul Bashir"};
            try {
                for (String mymessage : mymessages) {
                    messageQueue.send(mymessage);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {

            }
        });
        Thread reciever = new Thread(() ->
        {
            try {
                for (int i = 0; i <= 5; i++) {
                    messageQueue.receive();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {

            }
        });

        sender.start();
        reciever.start();
    }
}