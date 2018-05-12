package leetcode;

import java.util.Arrays;

/**
 * see https://leetcode.com/problems/3sum-closest/description/
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int len = nums.length;
        if(len < 3){
            int i = 0;
            while(i < len){
                res = res + nums[i];
            }
            return res;
        }
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;
        for(int i = 0;i < len;i++){
            int goal = target - nums[i];
            int j = i + 1;
            int k = len - 1;
            while(j < k){
                int diff = nums[j] + nums[k] - goal;
                if(Math.abs(diff) < delta){
                    res = nums[i] + nums[j] + nums[k];
                    delta = Math.abs(diff);
                }
                if(diff == 0){
                    return target;
                }else if(diff < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {1,2,4,8,16,32,64,128};
        int target = 82;
        int res = threeSumClosest(nums,target);
        System.out.println(res);
    }
}
