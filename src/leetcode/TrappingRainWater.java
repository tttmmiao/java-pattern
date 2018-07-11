package leetcode;

/**
 * see https://leetcode.com/problems/trapping-rain-water/description/
 * 思路：
 * //从左 -> 右找 第一个 >= 位置pos的位置r, 计算rightTrap
 * 从右 -> 左找，第一个 > 位置r的位置l，计算leftTrap
 * 结果为res = max(rightTrap, leftTrap)
 *
 * 其他：使用stack
 */
public class TrappingRainWater {
    public static int trap(int[] height) {
        int res = 0;
        int len = height.length;
        if(len < 1){
            return res;
        }
        int[] maxVal = new int[len];
        int i = 0;
        int former = 0;
        while(i < len-1){
            int rightTrap = 0;

            int j = i + 1;
            //j: 第一个 > height[i]的位置
            while(j < len && height[i] > height[j]){
                j++;
            }
            if(j < len && j - i > 1){
                rightTrap = height[i] * (j - i - 1);
                for(int gap = i+1;gap < j;gap++){
                    rightTrap = rightTrap - height[gap];
                }
                towardLeft(height,i,j,rightTrap,maxVal);
                i = j;
                former = j;
            }else{
                i++;
                towardLeft(height,former,i,rightTrap,maxVal);
            }
        }


        i = 0;
        while(i < len){
            res = res + maxVal[i];
            i++;
        }
       return  res;
    }

    public static void towardLeft(int[] height,int start, int end,int cur,int[] maxVal){
        if(end > height.length - 1){
            return;
        }
        //以end为坐标，计算leftTrap的值
        int leftTrap = 0;
        int key = height[end];
        int k = end - 1;
        while(k >= 0 && height[k] < key){
            k--;
        }
        if(k >= 0 && end - k > 1){
            leftTrap = key * (end - k - 1);
            for(int gap = k+1;gap < end;gap++){
                leftTrap = leftTrap - height[gap];
            }
        }

        int val = 0;
        if(cur >= leftTrap){
            val = cur;
        }else{
            start = k;
            val = leftTrap;
        }
        if(val > maxVal[end]){
            for(int temp = start + 1; temp < end && end < height.length; temp++){
                maxVal[temp] = 0;
            }
            maxVal[end] = val;
        }
    }

    public static void main(String[] args){
        //int[] height = {4,2,0,3,2,5}; //9
        //int[] height = {4,2,3}; //1
        //int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};  //6
        int[] height ={6,8,5,0,0,6,5}; //13
        //int[] height = {0,7,1,4,6}; //7
        //int[] height = {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}; //83
        //int[] height = {9,6,8,8,5,6,3}; //3
        int res = trap(height);
        System.out.println(res);
    }
}
