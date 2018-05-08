package leetcode;

/**
 * see https://leetcode.com/problems/string-to-integer-atoi/description/
 * 需要注意的细节：超过最大值和最小值的处理
 */
public class Atoi {
    public static int myAtoi(String str) {
        int res = 0;
        int len = str.length();
        if(len < 1){
            return 0;
        }
        int start = 0;
        while(start < len && str.charAt(start) == ' '){
            start++;
        }
        boolean isNegative = false;
        //判断合法性
        if(start < len && str.charAt(start) == '-'){
            isNegative = true;
            start++;
        }else if(start < len && str.charAt(start) == '+'){
            start++;
        }

        long digit = 0;
        while(start < len){
            char cur = str.charAt(start);
            if(isNumber(cur)){
                digit = digit*10 + (int)(cur-'0');
            }else{
               break;
            }
            start++;
            if(!isNegative && digit > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(isNegative && digit > Integer.MAX_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        if(isNegative){
            digit = 0 - digit;
        }
        res = (int)digit;
        return res;
    }
    static boolean isNumber(char c){
        int num = (int)(c-'0');
        if(num >= 0 && num <= 9){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        String s = "-42";
        int res = myAtoi(s);
        System.out.println(res);
    }
}
