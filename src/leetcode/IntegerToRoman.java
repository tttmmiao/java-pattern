package leetcode;

/**
 * see https://leetcode.com/problems/integer-to-roman/description/
 * 想把y拆成n*x,考虑y不断减x
 */
public class IntegerToRoman {
    public static String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer res = new StringBuffer();
        int i = 0;
        while(num != 0){
            while(num >= values[i]){
                res.append(romans[i]);
                num = num - values[i];
            }
            i++;
        }
        return res.toString();
    }
    public static void main(String[] args){
        int num = 1994;
        String res = intToRoman(num);
        System.out.println(res);
    }
}
