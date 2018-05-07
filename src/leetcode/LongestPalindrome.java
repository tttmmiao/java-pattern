package leetcode;

/**
 * see https://leetcode.com/problems/longest-palindromic-substring/description/
 * 思路 f(i,j)为回文字符串，则f(i+1,j-1)为回文字符串
 * 否则最长回文字符串存在于 f[i+1,j]或者 f[i,j-1]中
 * 找出最大值第一次出现的位置
 *
 * todo：是否有更优的方案
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        String res = "";
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int left = 0;
        int right = 0;
        int[][] array = new int[len + 1][len + 1];
        boolean[][] isPalind = new boolean[len + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            array[i][i] = 1;
            isPalind[i][i] = true;
        }

        for (int i = len; i > 0; i--) {
            for (int j = i + 1; j <= len; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && (j - i < 2 || isPalind[i + 1][j - 1])) {
                    array[i][j] = array[i + 1][j - 1] + 2;
                    isPalind[i][j] = true;
                } else {
                    array[i][j] = Math.max(array[i + 1][j], array[i][j - 1]);
                }
            }
        }
        //find max值第一次出现的位置
        int max = 0;
        for (int i = len; i > 0; i--) {
            for (int j = i; j <= len; j++) {
                if(max < array[i][j]){
                    max = array[i][j];
                    left = i - 1;
                    right = j - 1;
                }
            }
        }
        res = s.substring(left,right+1);
        return res;
    }

    public static void main(String[] args){
        String s = "abccba";
        String res = longestPalindrome(s);
        System.out.println(res);
    }
}
