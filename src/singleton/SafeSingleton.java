package singleton;

/**
 * safe
 * double check
 */
public class SafeSingleton {
    /**
     * private constructor
     */
    private SafeSingleton(){

    }

    private volatile static SafeSingleton instance = null;


    public static SafeSingleton getInstance(){
        if(null == instance){
            synchronized (SafeSingleton.class){
                if(null == instance){
                    System.out.println("create new object");
                    instance = new SafeSingleton();
                    return instance;
                }
            }
        }
        System.out.println("return exist object");
        return instance;
    }
}
