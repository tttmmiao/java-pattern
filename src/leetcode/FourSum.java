package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * see https://leetcode.com/problems/4sum/description/
 *
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0;
        int j = 0;
        int sum2 = 0;
        int s1,e1;
        for(i = 0;i < len;i++){
            if(i >= 1 && nums[i] == nums[i-1]){
                continue;
            }
            j = len - 1;
            while(j > i){
                sum2 = target - nums[i] - nums[j];
                s1 = i + 1;
                e1 = j - 1;
                if(nums[i] > 0 && sum2 < 0){
                    break;
                }
                while(s1 < len && s1 < e1){
                    if(nums[s1] + nums[e1] == sum2){
                        List<Integer> triple = new ArrayList<>();
                        triple.add(nums[i]);
                        triple.add(nums[s1]);
                        triple.add(nums[e1]);
                        triple.add(nums[j]);
                        res.add(triple);
                        s1++;
                        e1--;
                        while(s1 > 1 && s1 < len && nums[s1] == nums[s1-1]){
                            s1++;
                        }
                        while(e1 > 0 && e1 < len-2 && nums[e1] == nums[e1+1]){
                            e1--;
                        }
                    }else if(nums[s1] + nums[e1] < sum2){
                        s1++;
                    }else{
                        e1--;
                    }
                }
                j--;
                while(j>0 && j < len-1 && nums[j] == nums[j+1]){
                    j--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums1 = {-1,2,2,-5,0,-1,4};
        int target = 3;
        List<List<Integer>> res = fourSum(nums1,target);
        System.out.println(res);
    }
}
