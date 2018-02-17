package strategy;

/**
 * offline pay
 */
public class OfflineStrategy implements IBillingStrategy {
    @Override
    public boolean pay() {
        System.out.println("choosing offline pay");
        return false;
    }
}
