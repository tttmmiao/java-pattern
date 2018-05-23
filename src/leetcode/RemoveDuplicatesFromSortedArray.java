package leetcode;

/**
 * see https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * 思路:
 *  cnt 表示遍历的数字的个数 cnt < len
 *  i从第0个位置开始遍历
 *  lastJ为第一个和i位置值不相等的位置j，初始值为i+1
 *  当nums[i] == nums[j]时，j++,cnt++
 *  第一个不相等的值放在i+1位置，lastJ = j+1;
 *  继续遍历
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int res = 0;
        int len = nums.length;
        //处理的个数
        int cnt = 0;
        int i = 0;
        int lastJ = i+1;
        while(cnt < len){
            int j = lastJ;
            while(j < len && nums[i] == nums[j]){
                j++;
                cnt++;
            }
            if(j < len && j - i > 1){
                lastJ = j+1;
                nums[i+1] = nums[j];
                i++;
            }else{
                i++;
                lastJ++;
            }
            cnt++;
            res++;
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int res = removeDuplicates(nums);
        System.out.println(res);
        for(int i = 0;i < res;i++){
            System.out.println(nums[i]);
        }
    }
}

