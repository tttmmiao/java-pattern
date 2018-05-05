package test;

/**
 * the postion of the target str. else return -1
 */
public class StrPos {
    public static void main(String[] args){
        String str = "www.taobao.com";
        String target = "cox";
        int pos = find(str,target,0);
        System.out.println(pos);
    }
    public static int find(String str, String target,int start){
        if(start >= str.length()){
            return -1;
        }
        int size = target.length();
        if(start + size-1 >= str.length()){
            return -1;
        }
        String subStr = str.substring(start,start+size);
        if(subStr.equals(target)){
            return start;
        }else{
            return find(str, target, start+1);
        }
    }
}
