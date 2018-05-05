package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * n-queens problem
 * backtracing
 */
public class NQueens {
    public static void main(String[] args){
        int n = 4;
        List<List<String>> res = solveNQueens(n);
        System.out.println("总结果数为："+res.size());
        res.stream().forEach(ele -> System.out.println(ele));
    }
    public static List<List<String>> solveNQueens(int n){
        List<List<String>> res = new ArrayList<List<String>>();
        //i-row; value - column
        int[] queenList = new int[n];
        placeQueen(queenList,0,n,res);
        return res;
    }

    private static void placeQueen(int[] queenList,int row, int n, List<List<String>> res){
        //if is full, generate the result
        if(row == n){
           List<String> list = new ArrayList<String>();
           for(int i = 0;i < n;i++){
               String str = "\n";
                for(int j = 0;j < n;j++){
                    if(queenList[i] != j){
                        str = str + ".";
                    }else{
                        str = str + "Q";
                    }
                }
               list.add(str);
           }
           res.add(list);
        }
        for(int col = 0; col < n; col++){
            if(isValid(queenList,row,col)){
                queenList[row] = col;
                placeQueen(queenList,row+1,n,res);
            }
        }
    }

    private static boolean isValid(int[] queenList,int row, int col){
        for(int i = 0;i < row;i++){
            int pos = queenList[i];
            if(pos == col){ // the same column
                return false;
            }
            if(i + pos == row + col){ //the right diagonal line
                return false;
            }
            if(i - pos == row - col){ // the left diagonal line
                return false;
            }
        }
        return true;
    }
}
