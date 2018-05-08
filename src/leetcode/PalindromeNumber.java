package leetcode;

/**
 * see https://leetcode.com/problems/palindrome-number/description/
 * 思路1：将数据放入字符数组，返回字符数组是否为回文
 * 思路2：<0 直接返回false; 将数据反转，比较2个数据的大小
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int origin = x;
        int y = 0;
        while(x!=0){
            y = y * 10 + x%10;
            x = x / 10;
        }
        return y == origin;
    }
    public static boolean isPalindromeV1(int x) {
        char[] digits = new char[1000];
        int cnt = 0;
        if(x < 0){
            digits[cnt] = '-';
            cnt++;
        }
        int mod = 0;
        while(x!=0){
            mod = x%10;
            x = x / 10;
            digits[cnt] = (char)mod;
            cnt++;
        }
        int len = cnt;
        if(len <= 1){
            return true;
        }
        int i = 0;
        int j = len - 1;
        while(i <= j){
           if(digits[i] == digits[j]){
               i++;
               j--;
           }else{
               return false;
           }

        }
        return true;
    }
    public static void main(String[] args){
        int x = 11;
        boolean res = isPalindrome(x);
        System.out.println(res);
    }
}
