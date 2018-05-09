package leetcode;

/**
 * see  https://leetcode.com/problems/longest-common-prefix/description/
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len < 1){
            return "";
        }
        if(len < 2){
            return strs[0];
        }
        String common = commonPrefix(strs[0],strs[1]);
        for(int i = 2; i< len;i++){
            common = commonPrefix(common,strs[i]);
            if(common.length() == 0){
                break;
            }
        }
        return common;
    }
    public static String commonPrefix(String x, String y){
        StringBuilder res = new StringBuilder();
        int len = Math.min(x.length(),y.length());
        int i = 0;
        while(i < len){
            if(x.charAt(i) == y.charAt(i)){
                res.append(x.charAt(i));
                i++;
            }else{
                break;
            }
        }
        return res.toString();
    }
    public static void main(String[] args){
        String[] strs = {"dog"};
        String res = longestCommonPrefix(strs);
        System.out.println(res);
    }
}
