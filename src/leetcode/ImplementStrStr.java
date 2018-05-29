package leetcode;

/**
 * see https://leetcode.com/problems/implement-strstr/description/
 *
 */
public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        int len = haystack.length();
        int matchLen = needle.length();
        if(0 == matchLen){
            return 0;
        }
        String subStr = "";
        int res = -1;
        for(int i = 0;i <= len-matchLen;i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                subStr = haystack.substring(i,i+matchLen);
                if(subStr.equals(needle)){
                    res = i;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        String haystack = "hello";
        String needle = "o";
        int res = strStr(haystack,needle);
        System.out.println(res);
    }
}
