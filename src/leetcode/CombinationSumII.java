package leetcode;

import java.util.*;

/**
 * see https://leetcode.com/problems/combination-sum-ii/description/
 * 与CombinationSum的区别：不可重复使用
 */
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        int len = candidates.length;
        if(target <= 0){
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        res = recurGenerate(candidates,target,0,len);
        return new ArrayList<>(res);
    }
    public static Set<List<Integer>> recurGenerate(int[] candidates, int target, int start, int end) {
        Set<List<Integer>> res = new HashSet<>();
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
                Set<List<Integer>> recur = recurGenerate(candidates,target - candidates[i],i+1,end);
                res.addAll(assembleRes(candidates[i],recur));
            }
        }
        return res;
    }

    public static Set<List<Integer>> assembleRes(int candidate, Set<List<Integer>> recur){
        Set<List<Integer>> res = new HashSet<>();
        for(List<Integer> iter : recur){
            List<Integer> subRes = new ArrayList<>();
            subRes.add(candidate);
            subRes.addAll(iter);
            res.add(subRes);
        }
        return res;
    }
    public static void main(String[] args){
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> res = combinationSum2(candidates,target);
        res.stream().forEach( list -> System.out.println(list));
    }
}
