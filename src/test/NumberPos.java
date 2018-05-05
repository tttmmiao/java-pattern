package test;

/**
 * the position of the number in the ordered array
 */
public class NumberPos {
    public static void main(String[] args){
        int[] arr = {1,3,5,6};
        int target = 4;
        int pos = find(arr,target,0, arr.length-1);
        System.out.println(pos);
    }

    public static int find(int[] arr,int target, int low, int high){
        if(arr[high] < target){
            return high+1;
        }
        if(arr[low] > target){
            return low;
        }
        int mid = (low + high) /2;
        if(low == high){
            return low;
        }
        if(arr[mid] == target){
            return mid;
        }
        if(target < arr[mid]){
            return find(arr, target,low, mid);
        }else{
            return find(arr, target, mid + 1, high);
        }
    }
}
