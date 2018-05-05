package condition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * +1 -2 +1 -2
 */

public class AddSubThread extends Thread {
    private int index;
    private int count;
    private Integer val;
    private AtomicInteger res;
    static ReentrantLock lock = new ReentrantLock();
    //线程共有的 -- 很重要
    static volatile int state = 0;
    static Map<Integer,Condition> conMap = new HashMap<>();
    static{
        for(int i = 0;i < 2;i++){
            conMap.put(i,lock.newCondition());
        }
    }
    public AddSubThread(int index, int count,Integer val){
        this.index = index;
        this.count = count;
        this.val = val;
        this.res = new AtomicInteger(val);
    }

    private static char toABC(int which) {
        return (char) ('A' + which);
    }

    @Override
    public void run(){
        for(int i=0;i < count;i++){
            lock.lock();
            {
                if(state%2 != index){
                    try {
                        conMap.get(index).await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++;
                if(0 == index){
                    res.addAndGet(1);
                }else{
                    res.addAndGet(-2);
                }
                System.out.println("val:"+res);
                conMap.get((index+1)%2).signal();
            }
            lock.unlock();
        }

    }
}