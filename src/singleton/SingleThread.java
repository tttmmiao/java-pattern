package singleton;

/**
 * thread
 */
public class SingleThread implements Runnable{
    private String threadName;
    SingleThread(String threadName){
        this.threadName = threadName;
    }
    @Override
    public void run() {
        SafeSingleton singleton  = SafeSingleton.getInstance();
        System.out.println(threadName+":"+singleton);
    }
}
