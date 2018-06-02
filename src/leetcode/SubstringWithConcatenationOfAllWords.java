package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * see https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 * 2018-06-01 第一版思路：扫描s一次。借助hashMap数据结构，统计每个字符串出现次数
 */
public class SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int len = s.length();
        Map<String,String> wordsMap = new HashMap<>();
        //key: word, value: 出现次数
        Map<String,Integer> cntMap = new HashMap<>();

        for(String word : words){
            wordsMap.put(word.substring(0,1),word);
            if(null == cntMap.get(word)){
                cntMap.put(word,1);
            }else{
                cntMap.put(word,cntMap.get(word) + 1);
            }
        }
        if(words.length < 1){
            return res;
        }
        int i = 0;
        int eachSkip = words[0].length();
        int skip = words.length * eachSkip;
        String sub;
        while(i<= len-skip){
            sub = s.substring(i,i+skip);
            if(isValid(sub,eachSkip,cntMap)){
                res.add(i);
            }
            i++;
        }
        return res;
    }
    private static boolean isValid(String str,int eachSkip,Map<String,Integer> cntMap){
        HashMap<String,Integer> com = new HashMap<>();
        int i = 0;
        String sub;
        while(i <= str.length() - eachSkip){
            sub = str.substring(i,i+eachSkip);
            Integer val = com.get(sub);
            if(null == val){
                com.put(sub,1);
            }else{
                com.put(sub,val+1);
            }
            i = i + eachSkip;
        }
        if(com.equals(cntMap)){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        String s= "aaaaaaaa";
        String[] words = {"aa","aa","aa"};
        List<Integer> res = findSubstring(s,words);
        System.out.println(res);
    }
}
