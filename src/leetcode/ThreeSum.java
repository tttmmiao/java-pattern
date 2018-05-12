package leetcode;

import java.util.*;

/**
 * see https://leetcode.com/problems/3sum/description/
 * 三个指针
 * 找到剪枝条件
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len < 3){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0;i < len;i++){
            if(nums[i] > 0 ){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = 0 - nums[i];
            int j = i + 1, k = len - 1;
            while(j < k ){
                if(nums[j] + nums[k] == target){
                    List<Integer> triple = new ArrayList<>();
                    triple.add(nums[i]);
                    triple.add(nums[j]);
                    triple.add(nums[k]);
                    res.add(triple);
                    j++;
                    k--;
                    if(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                    while(j < k && nums[k] == nums[k+1]){
                        k--;
                    }
                }else if(nums[j] + nums[k] < target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }
}
