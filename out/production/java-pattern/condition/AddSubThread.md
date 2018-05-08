```java
// using wait/notify
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
    static AtomicInteger lock = new AtomicInteger(0);
    //线程共有的 -- 很重要
    static volatile int state = 0;
    public AddSubThread(int index, int count,Integer val){
        this.index = index;
        this.count = count;
        this.val = val;
        lock = new AtomicInteger(val);
    }

    private static char toABC(int which) {
        return (char) ('A' + which);
    }

    @Override
    public void run(){
        for(int i=0;i < count;i++){
            synchronized (lock){
                if(state%2 != index){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++;
                if(0 == index){
                    lock.addAndGet(1);
                }else{
                    lock.addAndGet(-2);
                }
                System.out.println("val:"+lock);
                lock.notifyAll();
            }
        }

    }
}
```