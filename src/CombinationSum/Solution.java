package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by haha on 2015/4/26.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> result = new HashSet<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        solver(result, cur, candidates, target, 0);
        return new ArrayList<List<Integer>>(result);
    }

    private void solver(HashSet<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int idx){
        for(int i = idx; i < candidates.length; ++i){
            int nt = target - candidates[i];
            if(nt > 0){
                List<Integer> ncur = new ArrayList<Integer>(cur);
                ncur.add(candidates[i]);
                solver(result, ncur, candidates, nt, i);
            }else if(nt == 0){
                List<Integer> ncur = new ArrayList<Integer>(cur);
                ncur.add(candidates[i]);
                result.add(ncur);
            }else{
                return;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.combinationSum(new int[]{1}, 2);
    }
}
