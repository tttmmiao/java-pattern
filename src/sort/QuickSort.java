package sort;

/**
 * quick sort
 */
public class QuickSort {
    public static int getMiddle(int[] numbers,int low, int high){
        int key = numbers[low];
        while(low < high){
            while(low < high && numbers[high] >= key){
                high--;
            }
            numbers[low] = numbers[high];
            while(low < high && numbers[low] < key){
                low++;
            }
            numbers[high] = numbers[low];
        }
        numbers[low] = key;
        return low;
    }

    public static void sort(int[] numbers,int low, int high){
        if(low < high){
            int middle = getMiddle(numbers,low,high);
            System.out.println("middle:"+middle);
            sort(numbers,low,middle-1);
            sort(numbers,middle+1,high);
        }
    }



    public static void main(String[] args){
        int[] numbers = {49,38,65,97,76,13,27,49};
        sort(numbers,0,numbers.length-1);
        for(int i = 0;i < numbers.length;i++){
            System.out.println(numbers[i]);
        }
    }
}
