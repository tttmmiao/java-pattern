package algorithm;

import java.util.Scanner;
import java.util.Stack;

/**
 * maze. has only one entrance and exit.
 * o represents free.
 * 1 represents block.
 * left corner is the entrance.
 * right corner is the exit.
 * find all paths that can go.
 *
 *
 * e.g.,
 * 0 0 0 0 0
 * 1  1 0 1 1
 * 0 0 0 0 0
 * 0 0 2 0 0
 */
public class MazeDemo {
    public static void main(String[] args){

    }



}
class Position{
    int row;
    int col;
    public Position(int row,int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}

class Maze{
    // maze array
    int[][] maze;
    Stack<Position> stack;
    boolean flag[][] = null;
    private int row = 10;
    private int col = 10;

    public Maze(){
        maze = new int[10][10];
        stack = new Stack<Position>();
        flag = new boolean[10][10];
    }
    //generate maze
    public void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入迷宫的行数：");
        row = scanner.nextInt();
        System.out.println("输入迷宫的列数：");
        col = scanner.nextInt();
        System.out.println("输入"+row+"行"+col+"列的迷宫");
        int temp = 0;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                temp = scanner.nextInt();
                maze[i][j] = temp;
                flag[i][j] = false;
            }
        }
    }

    public void findPath(){
        //从左上角开始按照顺时针查询
        int i = 0;
        int j = 0;
        stack.push(new Position(i,j));
        while(!stack.empty() && !(i== row && j== col)){

        }
    }
}

