package strategy;

/**
 * online pay
 */
public class OnlineStrategy implements IBillingStrategy {
    @Override
    public boolean pay() {
        System.out.println("choosing online pay");
        return false;
    }
}
