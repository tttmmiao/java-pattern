package condition;


import java.util.concurrent.atomic.AtomicInteger;

public class AddThread extends Thread{
    private volatile int count;
    private AtomicInteger lock;
    public AddThread(AtomicInteger lock,int count){
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run(){

            synchronized (lock){
                System.out.println("add start. val:"+lock);
                lock.addAndGet(1);
                count = count - 1;
                lock.notify();
                System.out.println("add end. val:"+lock);
            }

    }
}
