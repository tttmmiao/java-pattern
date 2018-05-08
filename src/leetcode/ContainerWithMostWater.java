package leetcode;

/**
 * see https://leetcode.com/problems/container-with-most-water/description/
 * 初步思路：抽象为求巨型面积 = 长（两条线中最短的） * 宽（间隔） .问题：会超时
 *
 * 优化思路：以当前位置为高，求最大宽度。以i为中心，找0～i中第一个第一个比ai大的位置，找len ～ len-i中第一个比ai大的位置，计算该位置的最大面积
 *
 * 优化思路2：从两边向内收缩。2个指针指向头和尾，先计算初始值；比第一个指针高度小的值不用计算；比第二个指针高度小的值也不用计算
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        int i = 0;
        int j = len - 1;
        int lh = height[0];
        int rh = height[len-1];
        int tmp = 0;
        while(i < j){
            tmp = Math.min(lh,rh)*(j-i);
            if(maxArea < tmp){
                maxArea = tmp;
            }

            if(lh < rh){
                while(i < j && height[i] <= lh){
                    i++;
                }
                if(i < j){
                    lh = height[i];
                }
            }else{
                while(i < j && height[j] <= rh){
                    j--;
                }
                if(i < j){
                    rh = height[j];
                }
            }
        }
        return maxArea;
    }
    public static int maxAreaV1(int[] height) {
        int len = height.length;
        int[] area = new int[len];
        int maxArea = 0;
        int leftSquare = 0;
        int rightSqure = 0;
        int cur = 0;
        for(int i = 0;i < len;i++){
            cur = height[i];
            leftSquare = 0;
            rightSqure = 0;
            for(int j = len-1;j > i;j--){
                if(height[j] >= cur){
                    rightSqure = cur*(j-i);
                    break;
                }
            }
            for(int j = 0;j < i;j++){
                if(height[j] >= cur){
                    leftSquare = cur*(i-j);
                    break;
                }
            }
            area[i] = Math.max(leftSquare,rightSqure);
            if(maxArea < area[i]){
                maxArea = area[i];
            }
        }
        return maxArea;
    }
    public static void main(String[] args){
        int[] height = {89,1000,100,1000,100};
        int res = maxAreaV1(height);
        System.out.println(res);
    }
}
