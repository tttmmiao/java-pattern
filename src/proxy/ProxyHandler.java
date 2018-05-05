package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * proxy handler
 */
public class ProxyHandler implements InvocationHandler {
    volatile int x;
    private Subject subject;
    public ProxyHandler(Subject subject){
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(subject,args);
    }
}
