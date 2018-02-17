package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;


public class Demo {
    public static void main(String[] args){
        int taskNum = 2;
        final CountDownLatch latch = new CountDownLatch(taskNum);
        CyclicBarrier barrier = new CyclicBarrier(taskNum+1);
        Thread[] tasks = new Thread[taskNum];
        for(int i = 0;i < taskNum;i++){
           tasks[i] = new Thread(new Task(i,barrier,latch));
        }
        for(int i = 0;i < taskNum;i++){
           tasks[i].start();
        }
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }
}
