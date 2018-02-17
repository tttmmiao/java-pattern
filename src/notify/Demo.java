package notify;


public class Demo {
    public static void main(String[] args){
        Message msg = new Message("happy new year.");
        Waiter waiter = new Waiter(msg,"ttt");
        Thread wThread = new Thread(waiter);

        Notifier notifier = new Notifier(msg,"sss");
        Thread nThread = new Thread(notifier);

        wThread.start();
        nThread.start();
        System.out.println("done");
    }
}
