package condition;



/**
 * demo
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Thread add = new AddSubThread(0,3,10);
        Thread sub = new AddSubThread(1,3,10);
        add.start();
        sub.start();

        Thread.sleep(10000);
        System.out.println("done");
    }


}
