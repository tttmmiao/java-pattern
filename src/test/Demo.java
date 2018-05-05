package test;

/**
 * demo
 */
public class Demo {
    public static void main(String[] args){
        String s1 = "11";
        String s2 = new String("11");
        s2.intern();
        System.out.println(s1 == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
