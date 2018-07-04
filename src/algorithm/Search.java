package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * a grid like
 * grid
 * [
 *  "ABCCE",
 *  "DEFTX",
 *  "ZEFGY"
 * ]
 *
 * 上下左右查找，给定字符串能够按照顺序从grid中找出一条路径
 *
 * 给定字符串
 * "ABCCTG" - 返回true
 * "ABFF" - false
 * "ADEB" - true
 */
public class Search {

    public static void main(String[] args){
        Grid g = new Grid();
        boolean result = search(g,0,0,0);
        System.out.println(result);
    }

    public static boolean search(Grid g, int i, int j, int index){
        if(index == g.target.length()){
            //寻找完成，返回
            return true;
        }
        //从左上角开始查找
        Pos newPos;
        for(int dir = -1; dir < 4; dir++){
            newPos = isValid(g,i,j,dir,index);
            if(newPos.row != -1 && newPos.col != -1){
                //查找下一个
                boolean res = search(g,newPos.row,newPos.col,index+1);
                if(res){
                    return res;
                }
            }
        }
        return false;
    }


    public static Pos isValid(Grid g, int i, int j,int dir, int index){
        int row = i;
        int col = j;
        switch(dir){
            case -1:{ //cur
                break;
            }
            case 0:{ //up
                row = row - 1;
                break;
            }case 1:{ //right
                col = col + 1;
                break;
            }case 2:{ //down
                row = row + 1;
                break;
            }case 3:{ //left
                col = col - 1;
                break;
            }
        }
        if(row >= 0 && row < g.row && col >= 0 && col <= g.col
                && g.flag[row][col] == 0 && g.grid.get(row).charAt(col) == g.target.charAt(index)){
            g.flag[row][col] = 1;
            return new Pos(row,col);
        }
        return new Pos(-1,-1);
    }
}
class Grid{
    int row;
    int col;
    List<String> grid;
    int[][] flag;
    String target;
    public Grid(){
        init();
    }

    public void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入行数：");
        row = scanner.nextInt();
        grid = new ArrayList<>(row);
        System.out.println("输入列数：");
        col = scanner.nextInt();
        flag = new int[row][col];

        System.out.println("输入"+row+"行"+col+"列的grid");
        String temp = "";
        for(int i = 0;i < row;i++){
            temp = scanner.next();
            if(temp.length() != col){
                System.out.println("输入列有误");
                System.exit(0);
            }
            grid.add(temp);
        }

        System.out.println("输入目标字符串：");
        target = scanner.next();
    }
}
class Pos{
    int row;
    int col;
    public Pos(int row, int col){
        this.row = row;
        this.col = col;
    }
}
