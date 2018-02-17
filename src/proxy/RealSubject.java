package proxy;

/**
 * 真实对象
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("real request");
    }
}
