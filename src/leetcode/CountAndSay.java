package leetcode;

/**
 * https://leetcode.com/problems/count-and-say/description/
 * 问题拆解：连续且相同的字符次数 +该字符
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        String origin = "1";
        for(int i = 1;i < n;i++){
            origin = recurGenerate(origin);
        }
        return origin;
    }

    public static String recurGenerate(String s){
        int len = s.length();
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < len;i++){
            char key = s.charAt(i);
            int cnt = 1;
            for(int j = i+1; j < len;j++){
                if(s.charAt(j) == key){
                    cnt++;
                }else{
                    i = j - 1;
                    break;
                }
                if(j == len - 1){
                    i = j;
                }
            }
            res.append(cnt).append(key);
        }
        return res.toString();
    }
    public static void main(String[] args){
        int n = 6;
        String res = countAndSay(n);
        System.out.println(res);
    }
}
