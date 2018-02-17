package notify;


public class Notifier implements Runnable{
    private Message msg;
    private String name;
    public Notifier(Message m, String name){
        this.msg = m;
        this.name = name;
    }
    @Override
    public void run() {
        synchronized (msg){
            msg.notify();
        }
    }
}
