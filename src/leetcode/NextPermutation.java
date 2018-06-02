package leetcode;

/**
 * see https://leetcode.com/problems/next-permutation/description/
 * 思路：
 * 从后向前扫描
 * 当前位置value >= 已扫描过的最大值：位置--, 最大值 = value
 * 当前位置value < 已扫描过的最大值: size-1 ~ 当前位置中，找到第一个比当前位置值大的值，交换；交换完成后，当前位置～size-1位置的值逆序
 * 注意：当扫描的位置i < 0时，整个数组逆序输出
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int size = nums.length;
        int cur = 0;
        int maxV = -1;
        int i = size - 1;
        while(i >= 0){
            cur = nums[i];
            if(cur >= maxV){
                i--;
                maxV = cur;
            }else{
                //找到 i+1 ~ size-1之间第一个比cur大的值，交换
                int start = size - 1;
                while(start >= 0){
                    if(nums[start] > cur){
                        int temp = cur;
                        nums[i] = nums[start];
                        nums[start] = temp;
                        break;
                    }
                    start--;
                }
                //i+1～ size-1之间的值由小到大排序
                int begin = i + 1;
                int end = size - 1;
                revert(nums,begin,end);
                break;
            }
        }
        //当前数字是最大的
        if(i < 0){
            revert(nums,0,size-1);
        }
    }
    private static void revert(int[] nums, int begin, int end){
        //i+1～ size-1之间的值由小到大排序
        while(begin < end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for(int i = 0;i < nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}
