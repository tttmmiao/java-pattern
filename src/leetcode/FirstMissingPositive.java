package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * see https://leetcode.com/problems/first-missing-positive/description/
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Map<Integer,Boolean> numberMap = new HashMap<>(len);
        for(int i = 0;i < len; i++){
            numberMap.put(nums[i],true);
        }

        int res = Integer.MAX_VALUE;
        int key = 0;
        for(int i = 0;i < len; i++){
            key = nums[i];
           if(key -1 > 0 && !numberMap.containsKey(key-1)){
                if(res > key - 1){
                    res = key - 1;
                }
           }
           if(key + 1 > 0 && !numberMap.containsKey(key+1)){
                if(res > key + 1){
                    res = key + 1;
                }
           }
        }
        if(!numberMap.containsKey(1) && res > 1){
            res = 1;
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {1,2,0};
        int res = firstMissingPositive(nums);
        System.out.println(res);
    }
}
