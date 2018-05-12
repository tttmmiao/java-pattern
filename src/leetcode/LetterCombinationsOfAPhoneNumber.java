package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * see https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * 数字i对应的字母位置为（i-2）*3 ~ (i-1)*3-1  注意7，8，9位置对应的字母
 */
public class LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int len = digits.length();
        if(len < 1){
            return res;
        }
        Map<Integer, String> digitMap = new HashMap<>();
        int digit = 0;
        String s1 = "";
        digit = digits.charAt(0) - '0';
        String tmp1 = numberToString(digit);
        for(int i = 0;i < tmp1.length();i++){
            res.add(tmp1.substring(i,i+1));
        }
        digitMap.put(digit,tmp1);
        for(int i = 1;i < len;i++){
            digit = digits.charAt(i) - '0';
            s1 = digitMap.get(digit);
            if(null == s1){
                s1 = numberToString(digit);
                digitMap.put(digit,s1);
            }
            res = combineString(res,s1);
        }
        return res;
    }
     public static String numberToString(int num){
        if(num < 2 || num >= 10){
            return "";
        }
        int lowLimit = 0;
        int upLimit = 3;
        if(7 == num || 9 == num){
            upLimit = 4;
        }
        if(num ==8 || num == 9){
            lowLimit = 1;
        }
        StringBuilder res = new StringBuilder();
        for(int i = lowLimit;i < lowLimit + upLimit;i++){
            res.append((char)('a'+(num-2)*3+i));
        }
        return res.toString();
    }
    public static List<String> combineString(List<String> s1,String s2){
        List<String> res = new ArrayList<>();
        for(String subStr : s1){
            for(int j = 0;j < s2.length();j++){
                StringBuilder tmp = new StringBuilder(subStr);
                tmp.append(s2.charAt(j));
                res.add(tmp.toString());
            }
        }
        return res;
    }
    public static void main(String[] args){
        String digits = "9";
        List<String> res = letterCombinations(digits);
        System.out.println(res);
    }
}
