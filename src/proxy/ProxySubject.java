package proxy;

/**
 * proxy class
 */
public class ProxySubject implements Subject {
    private Subject subject;
    public ProxySubject(Subject subject){
        this.subject = subject;
    }
    @Override
    public void request() {
        subject.request();
    }
}
