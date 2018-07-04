package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * see https://leetcode.com/problems/sudoku-solver/description/
 * 整体思路：穷举遍历+递归回溯法
 * 关键点：
 * （1）递归的出口：行指针 >= 9
 * (2) 使用flag数组标识board对应位置是否有原始值
 * (3) 有效条件的判断
 */
public class SudokuSolver {
    public static void solveSudoku(char[][] board) {
        Map<String,Integer> rowMap = new HashMap<>(81);
        Map<String,Integer> colMap = new HashMap<>(81);
        Map<String,Integer> blockMap = new HashMap<>(81);

        //使用flag标识原本就有值
        int[][] flag = new int[9][9];
        for(int i = 0 ;i < 9; i++){
            for(int j = 0;j < 9; j++){
                char ch = board[i][j];
                if( ch != '.'){
                    String rowKey = String.valueOf(ch).concat("_").concat(String.valueOf(i));
                    String colKey = String.valueOf(ch).concat("_").concat(String.valueOf(j));
                    int blockIndex = 3*(i / 3) + j /3;
                    String blockKey = String.valueOf(ch).concat("_").concat(String.valueOf(blockIndex));
                    rowMap.put(rowKey,i);
                    colMap.put(colKey,j);
                    blockMap.put(blockKey,blockIndex);
                    flag[i][j] = 1;
                }
            }
        }

        for(int i = 0 ;i < 9; i++){
            for(int j = 0;j < 9; j++){
                char ch = board[i][j];
                if( ch == '.'){
                    place(board,i,j,rowMap,colMap,blockMap,flag);
                    break;
                }
            }
        }
    }

    public static void place(char[][] board,int i, int j, Map<String,Integer> rowMap,  Map<String,Integer> colMap, Map<String,Integer> blockMap, int[][] flag){
        if(j >= 9){
            i = i + 1;
            j = 0;
        }
        if(i == 9){
            //退出条件：所有值设置为1,不再回溯，尝试其他可能
            for(int r = 0;r < 9;r++){
                for(int c = 0; c < 9; c++ ){
                    flag[r][c] = 1;
                }
            }
            return;
        }

        if(0 == flag[i][j]){
            for(int candidate = 1; candidate <= 10; candidate++){
                if(1 == flag[i][j]){
                    break;
                }
                if(0 == flag[i][j] && board[i][j] != '.'){
              /*  System.out.println("回退前");
                print(board);*/
                    remove(board[i][j],i,j,rowMap,colMap,blockMap);
                    board[i][j] = '.';
              /*  System.out.println("回退后");
                print(board);*/
                }
                if(candidate > 9){
                    break;
                }
                char ch = (char)(candidate+48);
                if(isValid(ch,i,j,rowMap,colMap,blockMap)){
                    board[i][j] = ch;
                    place(board,i,j+1,rowMap,colMap,blockMap,flag);
                }
            }
        }else{
            place(board,i,j+1,rowMap,colMap,blockMap,flag);
        }

    }

    /**
     * 判断candidate是否可以放入
     * @param cadidate 候选数字
     * @param row
     * @param col
     * @param rowMap
     * @param colMap
     * @param blockMap
     * @return
     */
    public static boolean isValid(char cadidate, int row, int col ,Map<String,Integer> rowMap,  Map<String,Integer> colMap, Map<String,Integer> blockMap){
        String rowKey = String.valueOf(cadidate).concat("_").concat(String.valueOf(row));
        String colKey = String.valueOf(cadidate).concat("_").concat(String.valueOf(col));
        int blockIndex = 3*(row / 3) + col /3;
        String blockKey = String.valueOf(cadidate).concat("_").concat(String.valueOf(blockIndex));
        if(rowMap.containsKey(rowKey) || colMap.containsKey(colKey) || blockMap.containsKey(blockKey)){
            return false;
        }else{
            rowMap.put(rowKey,row);
            colMap.put(colKey,col);
            blockMap.put(blockKey,blockIndex);
            return true;
        }
    }

    public static void remove(char cadidate, int row, int col ,Map<String,Integer> rowMap,  Map<String,Integer> colMap, Map<String,Integer> blockMap){
        String rowKey = String.valueOf(cadidate).concat("_").concat(String.valueOf(row));
        String colKey = String.valueOf(cadidate).concat("_").concat(String.valueOf(col));
        int blockIndex = 3*(row / 3) + col /3;
        String blockKey = String.valueOf(cadidate).concat("_").concat(String.valueOf(blockIndex));
        rowMap.remove(rowKey);
        colMap.remove(colKey);
        blockMap.remove(blockKey);
    }

    public static void main(String[] args){
       /* char[][] board =
                {
                        {'3','6','9','.','5','2','4','7','8'},
                        {'8','5','.','6','7','4','9','3','1'},
                        {'7','1','4','3','.','8','2','6','5'},
                        {'6','8','3','9','2','7','1','5','4'},
                        {'5','9','7','4','1','6','8','2','.'},
                        {'.','2','1','8','3','5','6','9','7'},
                        {'1','3','8','7','6','9','.','4','2'},
                        {'2','4','.','5','8','3','7','1','9'},
                        {'9','.','5','2','4','1','3','.','6'}
                };*/
       /*char[][] board = {
               {'4','9','6','3','1','.','.','2','5'},
               {'8','5','2','4','.','.','3','1','9'},
               {'1','.','.','5','9','2','4','8','6'},
               {'9','1','4','8','2','7','.','.','3'},
               {'6','8','5','9','3','4','.','7','2'},
               {'.','3','.','6','5','1','8','.','4'},
               {'.','2','8','1','6','9','5','4','7'},
               {'7','6','1','.','.','5','.','3','8'},
               {'5','4','9','7','.','3','2','.','1'}
       };*/

       char[][] board = {
               {'.','4','.','.','.','8','7','.','6'},
               {'8','.','3','7','.','6','5','.','4'},
               {'6','.','2','3','.','.','.','9','.'},
               {'.','2','.','8','.','.','9','.','.'},
               {'1','.','9','.','.','.','2','.','7'},
               {'.','.','.','6','.','.','.','1','3'},
               {'2','9','.','.','.','7','.','.','.'},
               {'4','.','1','.','.','.','6','.','2'},
               {'.','.','8','.','.','2','.','5','.'}
       };

     /* char[][] board = {
              {'5','3','.','.','7','.','.','.','.'},
                      {'6','.','.','1','9','5','.','.','.'},
                      {'.','9','8','.','.','.','.','6','.'},
                      {'8','.','.','.','6','.','.','.','3'},
                      {'4','.','.','8','.','3','.','.','1'},
                      {'7','.','.','.','2','.','.','.','6'},
                      {'.','6','.','.','.','.','2','8','.'},
                      {'.','.','.','4','1','9','.','.','5'},
                      {'.','.','.','.','8','.','.','7','9'}
      };*/
      solveSudoku(board);
      print(board);
    }

    public static void print( char[][] board){
        for(int i = 0;i < 9;i++){
            for(int j = 0; j < 9;j++){
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
