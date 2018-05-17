package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * see https://leetcode.com/problems/valid-parentheses/description/
 * 基本想法：
 * 使用栈
 */
public class ValidParenthese {
    public static boolean isValid(String s) {
        HashMap<String,String> charMap = new HashMap<>();
        charMap.put("(",")");
        charMap.put("{","}");
        charMap.put("[","]");
        Stack<String> matchStack = new Stack<>();
        int len = s.length();
        String subStr = "";
        String cur = "";
        for(int i = 0;i < len;i++){
            subStr = s.substring(i,i+1);
            if(charMap.containsKey(subStr)){
                matchStack.push(subStr);
            }else{
                if(matchStack.empty()){
                    return false;
                }
                cur = matchStack.pop();
                if(!charMap.get(cur).equals(subStr)){
                    return false;
                }
            }
        }
        if(matchStack.empty()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        String s = "]";
        boolean res = isValid(s);
        System.out.println(res);
    }
}
