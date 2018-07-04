package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * see https://leetcode.com/problems/valid-sudoku/description/
 */
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        int row = board.length;
        if(row != 9){
            return false;
        }
        //key: 数字+所在行 value: 所在行
        Map<String,Integer> rowMap = new HashMap<>(10);
        //key：数字+所在列 value: 所在列
        Map<String,Integer> colMap = new HashMap<>(10);
        //key：数字+所在块 value: 所在块
        Map<String,Integer> blockMap = new HashMap<>(10);

        for(int i = 0;i < row;i++){
            int col = board[i].length;
            if(col != 9){
                return false;
            }

            for(int j = 0;j < col;j++){
                char ch = board[i][j];
                if(ch == '.'){
                    continue;
                }
                if(!isValid(ch)){
                    return false;
                }
                Integer key = ch - '0';
                int blockPos = 3*(i/3)+j/3;
                String rowKey = key.toString()+i;
                String colKey = key.toString()+j;
                String blockKey = key.toString() + blockPos;
                if(rowMap.containsKey(rowKey)
                        || colMap.containsKey(colKey)
                        || blockMap.containsKey(blockKey)){
                    //System.out.println("row:"+i+"\tcol:"+j+"\tkey:"+key);
                    return false;
                }
                rowMap.put(rowKey,i);
                colMap.put(colKey,j);
                blockMap.put(blockKey,blockPos);
            }
        }
        return true;
    }

    public static boolean isValid(char ch){
        if(ch < '1' || ch > '9'){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        char[][] board =
                {
                        {'.','1','.','5','2','.','.','.','.'},
                        {'.','.','.','.','.','6','4','3','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'5','.','.','.','.','.','9','.','.'},
                        {'.','.','.','.','.','.','.','5','.'},
                        {'.','.','.','5','.','.','.','.','.'},
                        {'9','.','.','.','.','3','.','.','.'},
                        {'.','.','6','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.','.'}
                };
        boolean res = isValidSudoku(board);
        System.out.println(res);
    }
}
