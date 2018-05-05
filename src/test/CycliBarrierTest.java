package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by tianmiao on 2018/2/9.
 */
public class CycliBarrierTest implements Runnable {
    private static List list = new ArrayList(3);
    private CyclicBarrier barrier;
    private String name = "";

    public CycliBarrierTest(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
//do xxxx;
        try {
            for (int i = 0; i < 10; i++) {
                list.add(name);
                this.barrier.await();//线程运行至此会检查是否其它线程都到齐了，没到齐就继续等待。到齐了就执行barrier的run函数体里的内容
            }
        } catch (Exception e) {

        }
    }

    public static void main(XString[] args) {
//参数3代表3个线程都达到起跑线才开始一起继续往下执行
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
//do xxxx;
                Collections.sort(list);
                for(int i=0,n=list.size();i<n;i++){
                    System.out.print(list.get(i));
                }
                list.clear();
            }
        });
        System.out.println();
        Thread t1 = new Thread(new CycliBarrierTest(barrier,"A"));
        Thread t2 = new Thread(new CycliBarrierTest(barrier,"B"));
        Thread t3 = new Thread(new CycliBarrierTest(barrier,"C"));
        t1.start();
        t2.start();
        t3.start();
    }

}