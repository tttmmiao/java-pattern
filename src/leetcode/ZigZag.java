package leetcode;

/**
 * see https://leetcode.com/problems/zigzag-conversion/description/
 * 问题特点：找规律
 * 第一行和最后一行的间隔为 2*(numRows-1)
 * 中间行的间隔是周期性的，第i行的间隔分别为 2*（numRow - 1 -i), 2*i
 *
 * 注意特殊情况： 分成1行 和 字符串长度 < numRows的清醒
 */
public class ZigZag {
    public static String convert(String s, int numRows) {
        int len = s.length();
        StringBuffer res = new StringBuffer();
        if(len <= numRows || 1 == numRows){
            return s;
        }
        int delta = 0;
        int i = 0;
        int count = 0;
        for(int row = 0; row < numRows;row++){
            count = 1;
            i = row;
            delta = row;
            //最后一行和第一行的间隔相同
            if(i == numRows - 1){
                delta = 0;
            }
            while(i < len){
                res.append(s.charAt(i));
                if(delta == 0 || count % 2 != 0){
                    i = i + 2*(numRows - delta - 1);
                }else{
                    i = i + 2*(delta);
                }
                count++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args){
        String s = "A";
        int numRows = 1;
        String res = convert(s,numRows);
        System.out.println(res);
    }
}
