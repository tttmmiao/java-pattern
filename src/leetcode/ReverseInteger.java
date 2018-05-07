package leetcode;

/**
 * see https://leetcode.com/problems/reverse-integer/description/
 * 注意点：大数据溢出
 */
public class ReverseInteger {
    public static int reverse(int x) {
        long res = 0;
        long mod = 0;
        long num = (long)x;
        while(num!=0){
            mod = num%10;
            num = num/10;
            res = res * 10 + mod;
            if(res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE){
                res = 0;
                break;
            }
        }
        return (int)res;
    }
    public static void main(String[] args){
        int x = -123;
        int res = reverse(x);
        System.out.println(res);
    }
}
