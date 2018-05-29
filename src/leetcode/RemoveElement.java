package leetcode;

import java.util.Arrays;

/**
 * see https://leetcode.com/problems/remove-element/description/
 * 思路：先排序
 * 找到相等数字的gap, 挪位置
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = len;
        for(int i = 0;i < len;i++){
            int j = i;
            while(j < len && val == nums[j]){
                j++;
            }
            if(j != i){
                while(j < len){
                    nums[i] = nums[j];
                    j++;
                    i++;
                }
                res = len - (j-i);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {3};
        int res = removeElement(nums,3);
        System.out.println(res);
        for(int i = 0;i < res;i++){
            System.out.println(nums[i]);
        }
    }
}
