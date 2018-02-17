package notify;


public class Waiter implements Runnable {
    private Message msg;
    private String name;
    public Waiter(Message m,String name){
        this.msg = m;
        this.name = name;
    }
    @Override
    public void run() {
        synchronized (msg){
            System.out.println(name +" waiting...");
            try {
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name +" processed msg:"+ msg.getMsg());
        }
    }
}
