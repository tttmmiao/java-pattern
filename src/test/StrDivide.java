package test;

/**
 * string divide
 */
public class StrDivide {
    public static void main(String[] args){
        String s = "08217835980";
        int len = s.length();
        int[] sum = new int[len];
        sum[0] = s.charAt(0) - '0';
        for(int i = 1; i < s.length();i++){
            sum[i] = s.charAt(i) - '0' + sum[i-1] ;
        }
        boolean flag = false;
        int[] p = {1,3,5};
        while(true){
            //第4段
            int s4 = sum[s.length()-1] - sum[p[2]];
            //第3段
            int s3 = sum[p[2]-1] - sum[p[1]];
            //第二段
            int s2 = sum[p[1]-1] - sum[p[0]];
            // 第一段
            int s1 = sum[p[0]-1];
            if(s4 > s3 && p[2] < s.length()){
                p[2]++;
                continue;
            }
            if(p[2] == s.length() -1){
                flag = false;
                break;
            }
            if(s3 > s2 && p[1] < s.length()){
                p[1]++;
                continue;
            }
            if(s2 > s1 && p[0] < s.length()){
                p[0]++;
                continue;
            }
            if(s1 == s2 && s2 ==s3 && s3 == s4){
                System.out.println("total:"+s1+"\tp[0]:"+p[0]+"\tp[1]:"+p[1]+"\tp[2]:"+p[2]);
                flag = true;
                break;
            }
        }
        System.out.println(flag?"YES":"NO");
    }

}
