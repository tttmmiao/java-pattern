package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * see https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int len = nums.length;
        Map<Integer,Integer> numMap = new HashMap<>(len);
        for(int i = 0;i< len;i++){
            int tmp = target - nums[i];
            if(numMap.containsKey(tmp)){
                res[0] = i;
                res[1] = numMap.get(tmp);
                return res;
            }else{
                numMap.put(nums[i],i);
            }
        }
        return res;
    }
    public static void main(String[] args){
        TwoSum demo = new TwoSum();
        int[] nums = {15,12,7,2};
        int target = 9;
        int[] res = demo.twoSum(nums,target);
        System.out.println(res[0]+"\t"+res[1]);
    }
}
