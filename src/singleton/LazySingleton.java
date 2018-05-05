package singleton;


/**
 * lazy singleton class.
 * unsafe
 * multi threads may cause multi instances.
 */
public class LazySingleton{
    /**
     * private constructor
     */
    private LazySingleton(){

    }

    private static LazySingleton instance = null;

    public static LazySingleton getInstance(){
        if(null == instance){
            System.out.println("create new object");
            return new LazySingleton();
        }
        System.out.println("return exist object");
        return instance;
    }
}
