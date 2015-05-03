package CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by haha on 2015/4/26.
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        HashSet<List<Integer>> result = new HashSet<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        solver(result, cur, num, target, 0);
        return new ArrayList<List<Integer>>(result);
    }

    private void solver(HashSet<List<Integer>> result, List<Integer> cur, int[] num, int target, int idx){
        if(target > 0){
            for(int i = idx; i < num.length; ++i){
                int nt = target - num[i];
                if(nt >= 0){
                    List<Integer> ncur = new ArrayList<Integer>(cur);
                    ncur.add(num[i]);
                    solver(result, ncur, num, nt, i + 1);
                }else{
                    break;
                }
            }
        }else if(target == 0){
            result.add(cur);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}
