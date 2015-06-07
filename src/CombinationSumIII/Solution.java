package CombinationSumIII;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haha on 2015/6/7.
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for(int i = 1; i < 10; ++i){
            solver(1, k, i, 0, n, new LinkedList<Integer>(), result);
        }
        return result;
    }

    void solver(int ck, int k, int cur, int sum, int n, List<Integer> cres, List<List<Integer>> result){
        if(ck < k){
            sum += cur;
            if(sum < n){
                cres = new LinkedList<Integer>(cres);
                cres.add(cur);
                for(int i = cur + 1; i < 10; ++i){
                    solver(ck + 1, k, i, sum, n, cres, result);
                }
            }
        }else if(ck == k){
            if(sum + cur == n){
                cres = new LinkedList<Integer>(cres);
                cres.add(cur);
                result.add(cres);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.combinationSum3(2, 6);
    }
}
