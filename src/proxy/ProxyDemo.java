package proxy;


import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * demo
 */
public class ProxyDemo {
    public static void main(String[] args){
        RealSubject rs = new RealSubject();
        ProxyHandler handler = new ProxyHandler(rs);
        //dynamic proxy to invoke real subject
        Subject proxySubject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                RealSubject.class.getInterfaces(),handler);
      /*  proxySubject.request();*/


       try{
           Method method = rs.getClass().getMethod("request");
           handler.invoke(proxySubject,method,null);
           //handler.invoke(rs.getClass(),method,null);
       }catch (Exception e){
           e.printStackTrace();
       }catch (Throwable e){
           e.printStackTrace();
       }

    }
}
