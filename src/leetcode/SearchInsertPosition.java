package leetcode;

/**
 * see https://leetcode.com/problems/search-insert-position/description/
 * 思路：
 * 对问题分类
 * = mid
 * < mid
 * > mid
 * < start start-1
 * > end end+1
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int res = 0;
        int len = nums.length;
        int pos = findPos(nums,target,0,len);
        if(pos < 0){
            res = 0;
        }else if(pos > len){
            res = len;
        }else{
            res = pos;
        }
        return res;
    }
    public static int findPos(int[] nums, int target, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            int mVal = nums[mid];
            if(target == mVal){
                return mid;
            }else if(target < mVal){
                return findPos(nums,target,start,mid);
            }else if(target > mVal){
                return findPos(nums,target,mid+1,end);
            }else if(target < nums[start]){
                return start-1;
            }else if(target > nums[end]){
                return end + 1;
            }
        }
        return start;
    }
    public static void main(String[] args){
        int[] nums = {1,3};
        int target = 2;
        int res = searchInsert(nums,target);
        System.out.println(res);
    }
}
