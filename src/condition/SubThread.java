package condition;


import java.util.concurrent.atomic.AtomicInteger;

public class SubThread extends Thread{
    private int count;
    private AtomicInteger lock;
    public SubThread(AtomicInteger lock,int count)
    {
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run(){
     {
            synchronized (lock){
                System.out.println("sub start. count:"+lock);
                lock.addAndGet(-2);
                count = count - 1;
                System.out.println("sub waiting. count:"+lock);
                try {
                    lock.wait();
                    System.out.println("sub end. count:"+lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}