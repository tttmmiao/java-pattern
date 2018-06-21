package leetcode;

/**
 * see https://leetcode.com/problems/search-for-a-range/description/
 */
public class SearchForARange {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int len = nums.length;
        int pos = findEqualPos(nums,target,0,len);
        if(pos >= 0){
            int start = pos;
            int end = pos;
            while(start-1 >= 0 && nums[start-1] == target){
                start = start - 1;
            }
            while(end + 1 < len && nums[end+1] == target){
                end = end + 1;
            }
            res[0] = start;
            res[1] = end;
        }
        return res;
    }

    public static int findEqualPos(int[] nums, int target, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            if(target == nums[mid]){
                return mid;
            }else if(nums[mid] > target){
                return findEqualPos(nums,target,start,mid);
            }else{
                return findEqualPos(nums,target,mid+1,end);
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {5};
        int target = 5;
        int[] res = searchRange(nums,target);
        System.out.println(res[0]+"\t"+res[1]);
    }
}
