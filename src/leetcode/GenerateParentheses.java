package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * see https://leetcode.com/problems/generate-parentheses/description/
 * 思路：
 * （1）每遇到一个左括号，在左括号后加一个完整的括号；在前面加一个括号。注意去重
 * (2)递归
 * 分析正确的形式是 左括号数 == 右括号数
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n,n,"",res);
        return res;
    }

    /**
     * left为剩余的左括号数，right为剩余的右括号数
     * @param left
     * @param right
     * @param out
     * @param res
     */
    public static void helper(int left, int right, String out, List<String> res) {
        if(left < 0 || right < 0 || left > right){
            return;
        }
        if(left == 0 && right == 0){
            res.add(out);
            return;
        }
        helper(left-1,right,out+"(",res);
        helper(left,right-1,out+")",res);
    }

    public static List<String> generateParenthesisV1(int n) {
        Set<String> res = new HashSet<>();
        if(0 == n){
            return new ArrayList<>(res);
        }
        if(1 == n){
            res.add("()");
            return new ArrayList<>(res);
        }
        List<String> tmp= combineResult(generateParenthesisV1(n-1));
        res.addAll(tmp);
        return new ArrayList<>(res);
    }
    public static List<String> combineResult(List<String> list){
        char left = '(';
        char right = ')';
        Set<String> res = new HashSet<>();
        for(int i = 0;i < list.size();i++){
            String str = list.get(i);
            for(int j = 0;j < str.length();j++){
                if(str.charAt(j) == left){
                    StringBuilder addStr = new StringBuilder(str.substring(0,j+1));
                    addStr.append(left).append(right).append(str.substring(j+1,str.length()));
                    res.add(addStr.toString());
                }
            }
            res.add("()"+str);
        }
        return new ArrayList<>(res);
    }
    public static void main(String[] args){
        int n = 3;
        List<String> res = generateParenthesis(n);
        System.out.println(res);
    }
}
