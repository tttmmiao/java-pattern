package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * see https://leetcode.com/problems/combination-sum/description/
 * 思路：
 * 先排序，递归处理
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if(target <= 0){
            return res;
        }
        Arrays.sort(candidates);
        res = recurGenerate(candidates,target,0,len);
        return res;
    }

    public static List<List<Integer>> recurGenerate(int[] candidates, int target, int start,int end) {
        List<List<Integer>> res = new ArrayList<>();
        if(target <= 0){
            return res;
        }
        for(int i = start;i < end;i++){
            List<Integer> subRes = new ArrayList<>();
            if(target < candidates[i]){
                break;
            }else if(target == candidates[i]){
                subRes.add(candidates[i]);
                res.add(subRes);
                break;
            }else{
                List<List<Integer>> recur = recurGenerate(candidates,target - candidates[i],i,end);
                res.addAll(assembleRes(candidates[i],recur));
            }
        }
        return res;
    }

    public static List<List<Integer>> assembleRes(int candidate, List<List<Integer>> recur){
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> iter : recur){
            List<Integer> subRes = new ArrayList<>();
            subRes.add(candidate);
            subRes.addAll(iter);
            res.add(subRes);
        }
        return res;
    }


    public static void main(String[] args){
        int[] candidates = {8,7,4,3};
        int target = 11;
        List<List<Integer>> res = combinationSum(candidates,target);
        res.stream().forEach( list -> System.out.println(list));
    }
}
