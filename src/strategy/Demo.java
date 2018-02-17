package strategy;

/**
 * demo
 */
public class Demo {
    public static void main(String[] args){
        Context context = new Context();
        context.setStrategy(new OnlineStrategy());
        context.pay();
    }
}
