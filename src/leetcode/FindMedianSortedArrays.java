package leetcode;

/**
 * see https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * 思路：
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m+n;
        double mid = 0.0;
        if(total % 2 == 1){ //奇数,第total/2+1个位置的值
            mid = findMidian(nums1,0, m-1, nums2, 0, n-1, total/2+1);
        }else{ //偶数个 第total/2 + total/2+1个位置的值的平均数
            mid = (double)(findMidian(nums1,0, m-1, nums2, 0, n-1, total/2)
                    + findMidian(nums1,0, m-1, nums2, 0, n-1, total/2+1))/2;
        }
        return mid;
    }

    public static double findMidian(int[] A, int start1, int end1, int[] B, int start2, int end2, int index){
        int m = end1 - start1 + 1;
        int n = end2 - start2 + 1;
        if(m > n){
            return findMidian(B, start2, end2, A, start1, end1, index);
        }
        if(index == 1){
            return Math.min(A[start1],B[start2]);
        }
        if(m == 0){
            return B[start2 + index - 1];
        }
        int pos1 = Math.min(index/2, m);
        int pos2 = index - pos1;
        if(A[start1+pos1-1]==B[start2+pos2-1]){
            return A[start1+pos1-1];
        } else if(A[start1+pos1-1]<B[start2+pos2-1]){
            return findMidian(A,start1+pos1,end1,B,start2,start2+pos2-1,index-pos1);
        } else {
            return findMidian(A, start1, start1 + pos1 - 1, B,start2 + pos2, end2, index - pos2);
        }
    }

    public static void main(String[] args){
        int[] nums1 = {1, 2};
        int[] nums2 = {1,2};
        double median = findMedianSortedArrays(nums1,nums2);
        System.out.println(median);
    }
}
