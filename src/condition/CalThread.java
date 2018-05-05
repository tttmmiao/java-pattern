package condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 计算线程
 */
public class CalThread extends Thread{
    private int index;
    private int val;
    private ReentrantLock lock = new ReentrantLock();
    private Condition addCondition = lock.newCondition();
    private Condition subCondition = lock.newCondition();
    public CalThread(int index,int val){
        this.index = index;
        this.val = val;
    }

    @Override
    public void run(){
        try{
            System.out.println("origin val:"+val);
            lock.lock();
            if(index % 2 == 0){
                subCondition.signal();
            }
            val = val + 1;
            addCondition.await();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
