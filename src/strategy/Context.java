package strategy;

/**
 * context
 */
public class Context {
    private IBillingStrategy billingStrategy;
    public Context(){

    }

    public void setStrategy(IBillingStrategy billingStrategy){
        this.billingStrategy = billingStrategy;
    }
    public void pay(){
        billingStrategy.pay();
    }
}
