package sort;




/**
 * bubble sort
 */
public class BubbleSort {

    public static void sort(int[] numbers){
        int len = numbers.length;
        for(int i = 0;i < len-1;i++){
            for(int j = 0;j < len - i - 1;j++){
               if(numbers[j] > numbers[j+1]){
                   int tmp = numbers[j];
                   numbers[j] = numbers[j+1];
                   numbers[j+1] = tmp;
               }
            }
        }
    }

    public static void main(String[] args){
        int[] numbers = {49,38,65,97,76,13,27,49};
        sort(numbers);
        for(int i = 0;i < numbers.length;i++){
            System.out.println(numbers[i]);
        }
    }
}
