package singleton;

/**
 * demo
 */
public class Demo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new SingleThread("t1"));
        Thread t2 = new Thread(new SingleThread("t2"));
        t1.start();
        t2.start();
    }



}
