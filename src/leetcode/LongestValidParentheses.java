package leetcode;

import java.util.Stack;

/**
 * see https://leetcode.com/problems/longest-valid-parentheses/description/
 * 整体思路：栈
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int len = s.length();
        int i = 0;
        Stack<Integer> posStack = new Stack();
        int res = 0;
        int start = 0;
        String sub = "";
        while(i < len){
            sub = s.substring(i,i+1);
            if(sub.equals("(")){
                posStack.push(i);
            }else if(sub.equals(")") ){
                if(posStack.empty()){
                    start = i + 1;
                }else{
                    posStack.pop();
                    res = posStack.empty()?Math.max(res,i-start+1):Math.max(res,i - posStack.peek());
                }
            }
            i++;
        }
        return res;
    }
    public static void main(String[] args){
        String s = "(()(()())(";
        int res = longestValidParentheses(s);
        System.out.println(res);
    }
}
