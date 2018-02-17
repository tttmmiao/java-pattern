package asyn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 *
 */
public class Demo {
    public static void main(String[] args){
        int threadCnt = 4;
        StringBuffer stringBuffer = new StringBuffer();

        CountDownLatch countDownLatch = new CountDownLatch(threadCnt);
        CyclicBarrier barrier = new CyclicBarrier(threadCnt+1);
        Thread[] tasks = new Thread[threadCnt];
        for(int i = 0;i < threadCnt;i++){
            tasks[i] = new Thread(new Task(i,barrier,stringBuffer,countDownLatch));
        }

        for(int i = 0;i < threadCnt;i++){
            System.out.println(i + "\tstart");
            tasks[i].run();
        }
        try {
            barrier.await();
            barrier.reset();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }



        /*for(int i = 0;i < printTimes;i++){
            Stream.of(tasks).forEach(Task::run);
        }*/
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done");
        System.out.println("result:" +stringBuffer);
    }
}
