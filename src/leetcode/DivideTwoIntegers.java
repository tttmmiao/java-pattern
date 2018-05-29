package leetcode;

/**
 * see https://leetcode.com/problems/divide-two-integers/description/
 * 普通想法会存在超时问题
 * 二分思想：除数*2
 * 注意：-2147483648 1 返回-2147483648；-2147483648 -1 返回2147483647
 * 对于int会超过界限，统一转换为long处理。在返回输出结果时，做界限判断
 */
public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        //mark negative or positive
        int flag = 0;
        long divid = (long)(dividend);
        long divis = (long)(divisor);
        if(dividend < 0){
            flag = flag + 1;
            divid = 0 - divid;
        }
        if(divisor < 0){
            flag = flag - 1;
            divis = 0 - divis;
        }

        long cnt = 0;
        while(divid >= divis){
            long c = divis;
            int i = 0;
            while(c <= divid){
                divid = divid - c;
                c = c << 1;
                cnt+=1 << i;
                i++;
            }
        }
        if(0 != flag){
            cnt = 0 - cnt;
        }
        if(cnt <= Integer.MIN_VALUE){
            cnt = Integer.MIN_VALUE;
        }
        if(cnt >= Integer.MAX_VALUE){
            cnt = Integer.MAX_VALUE;
        }
        return (int)cnt;
    }

    public static int divide1(int dividend, int divisor) {
        if(1 == divisor){
            return dividend;
        }
        //mark negative or positive
        int flag = 0;
        if(dividend < 0){
            flag = flag + 1;
            if(dividend <= Integer.MIN_VALUE){
                dividend = Integer.MAX_VALUE;
            }else{
                dividend = Math.abs(dividend);
            }
        }
        if(divisor < 0){
            flag = flag - 1;
            divisor = Math.abs(divisor);
            if(divisor <= Integer.MIN_VALUE){
                divisor = Integer.MAX_VALUE;
            }else{
                divisor = Math.abs(divisor);
            }
        }
        int cnt = 0;
        while(dividend >= divisor){
            dividend = dividend - divisor;
            cnt++;
            if(cnt > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        if(0 != flag){
            cnt = 0 - cnt;
        }
        return cnt;
    }
    public static void main(String[] args){
        int divided = -2147483648;
        int divisor = -1;
        int res = divide(divided,divisor);
        System.out.println(res);
    }
}
