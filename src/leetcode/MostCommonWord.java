package leetcode;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * see https://leetcode.com/problems/most-common-word/description/
 */
public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        TreeMap<String,Integer> strNumMap = new TreeMap<>();
        paragraph = paragraph.replaceAll("[\\pP!?',;.]" , "");
        String[] in = paragraph.split(" ");
        String ele;
        Integer count;
        for(String tmp : in){
            ele = tmp.toLowerCase();
            count = strNumMap.get(ele);
            if(null == count){
                count = 0;
            }
            strNumMap.put(ele,count+1);
        }
        Comparator<Map.Entry<String,Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        List<Map.Entry<String, Integer>> list = new ArrayList(strNumMap.entrySet());
        Collections.sort(list,valueComparator);
        Map<String,Boolean> bannedMap = new HashMap<>();
        for(String ban:banned){
            bannedMap.put(ban,true);
        }
        for(Map.Entry<String, Integer> entry: list){
            if(null == bannedMap.get(entry.getKey())){
                return entry.getKey();
            }
        }
        return "";
    }
    public static void main(String[] args){
        String paragraph="Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[2];
        banned[0] = "hit";
        String res = mostCommonWord(paragraph,banned);
        System.out.println(res);
    }

}
