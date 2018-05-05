package sort;

/**
 *
 */
public class InsertSort {
    public static void sort(int[] numbers,int low, int high){
        int size = numbers.length;
        for(int i = 1;i < size;i++){
            int key = numbers[i];
            int j = i;
            for(int k = i-1;k>=0;k--){
                if(numbers[k] > key){
                    //交换
                    numbers[k+1] = numbers[k];
                    j = k;
                }else{
                    break;
                }
            }
            numbers[j] = key;
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
//




















