package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 *
 */
public class Task implements Runnable{
    private final CyclicBarrier barrier;
    private int index;
    private CountDownLatch latch;
    public Task(int index, CyclicBarrier barrier,CountDownLatch latch){
        this.index = index;
        this.barrier = barrier;
        this.latch = latch;
    }
    @Override
    public void run() {
        latch.countDown();
        System.out.println(index+" task is finished, waiting for others.");
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(index+" wait is over.");
    }
}
