package leetcode;

/**
 * see https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * 找出异常：
 * l < cur < mid : [l,mid-1]
 * mid < cur < r : [mid+1,r]
 * cur > mid && mid < l : [l,mid-1]
 * cur < mid && mid > r : [mid+1,r]
 * 其他：
 * cur > mid : [mid +1, r]
 * cur < mid: [l, mid - 1]
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int res = -1;
        int len = nums.length;
        res = searchPos(nums,0,len-1, target);
        return res;
    }

    public static int searchPos(int[] nums,int start, int end, int target){
        int res = -1;
        if(start <= end){
            int mid = (start+end)/2;
            int startV = nums[start];
            int medianV = nums[mid];
            int endV = nums[end];
            if(target == medianV){
                return mid;
            }else if(target  < medianV && target >= startV){
                return searchPos(nums,start,mid-1,target);
            }else if(target  > medianV && target <= endV){
                return searchPos(nums,mid+1,end,target);
            }else if(target  > medianV && medianV <= startV){
                return searchPos(nums,start,mid-1,target);
            }else if(target < medianV && medianV > endV){
                return searchPos(nums,mid+1,end,target);
            }else if(target  > medianV ){
                return searchPos(nums,mid+1,end,target);
            }else if(target < medianV ){
                return searchPos(nums,start,mid-1,target);
            }else{
                return -1;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {8,9,2,3,4};
        int target = 9;
        int res = search(nums,target);
        System.out.println(res);
    }
}
