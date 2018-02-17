package asyn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * task
 */
public class Task implements Runnable{
    private CyclicBarrier barrier;
    private String identity;
    private int index;
    private final char character = 65;
    private StringBuffer stringBuffer;
    private CountDownLatch latch;

    public Task(int index, CyclicBarrier barrier, StringBuffer stringBuffer, CountDownLatch latch){
        this.index = index;
        this.identity = String.valueOf((char)(this.character+index));
        this.stringBuffer = stringBuffer;
        this.barrier = barrier;
        this.latch = latch;
    }
    @Override
    public void run() {
        stringBuffer = stringBuffer.append(this.identity);
        System.out.println(index+" " + stringBuffer +"\t finished");
        try {
            barrier.await();
            System.out.println(index+" wait is over.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}
