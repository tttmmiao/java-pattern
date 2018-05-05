package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * see https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * 思路：针对String s中的每个字符，构建长度为len的String数组，里边存放当前位置的最长子串
 * 当当前字符在上一个最长子串中时，该位置的最长字串为 上一个最长字串出现该字符的结尾处+字符本身
 * 当当前字符不在上一个最长子串中时，该位置的最长字串为上一个最长字串+该字符
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len < 1){
            return 0;
        }
        List<String> subString = new ArrayList<>(len);
        subString.add(s.substring(0,1));
        String formerSub = "";
        for(int i = 1;i < len;i++){
            formerSub = subString.get(i-1);
            String cur = s.substring(i,i+1);
            if(formerSub.contains(s.subSequence(i,i+1))){
                String[] partation = formerSub.split(cur);
                if(partation.length > 1){
                    subString.add(partation[partation.length-1] + cur);
                }else{
                    subString.add(cur);
                }

            }else{
                subString.add(formerSub+cur);
            }
        }
        int maxLen = 0;
        for(String sub : subString){
            if(sub.length() > maxLen){
                maxLen = sub.length();
            }
        }
        return maxLen;
    }
    public static void main(String[] args){
        String s = "pwwkew";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
