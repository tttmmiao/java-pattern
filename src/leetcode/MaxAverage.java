package leetcode;

/**
 * see https://leetcode.com/problems/maximum-average-subarray-i/description/
 */
public class MaxAverage {
    public static double findMaxAverage(int[] nums, int k) {
        double avg = 0;
        int len = nums.length;
        int sum[] = new int[len];
        sum[0] = nums[0];
        for(int i = 1;i < len;i++){
            sum[i] = sum[i-1] + nums[i];
        }
        int maxSum = sum[k-1];
        for(int i = k;i<len;i++){
            int tmp = sum[i] - sum[i-k];
            if(tmp > maxSum){
                maxSum = tmp;
            }
        }
        avg = ((double)(maxSum))/k;
        return avg;
    }

    public static void main(String[] args){
        int[] nums = {1,12,-5,-6,50,3};
        int k = 1;
        double res = findMaxAverage(nums,k);
        System.out.println(res);
    }
}
