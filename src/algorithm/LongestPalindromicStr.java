package algorithm;

/**
 * 最长回文子序列
 */
public class LongestPalindromicStr {
    public static void main(String[] args){
        String str = "abccab";
        int value = findLongestPalindromic(str);
        System.out.println(value);
    }

    public static int findLongestPalindromic(String str){
        int size = str.length();
        int[][] dp = new int[size][size];
        for(int i = size-1;i >=0 ;i--){
            dp[i][i] = 1;
            for(int j = i+1; j < size; j++){
                if(str.charAt(i) == str.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;

                }else{
                    dp[i][j] = dp[i+1][j] >= dp[i][j-1] ? dp[i+1][j] : dp[i][j-1];
                }
            }
        }

        for(int i = 0;i < size;i++){
            for(int j = 0;j < size;j++){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[0][size-1];
    }
}
