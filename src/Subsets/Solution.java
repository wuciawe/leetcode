package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by haha on 2015/4/30.
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        res.add(l);
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; ++i){
            List<Integer> r = new ArrayList<Integer>();
            r.add(nums[i]);
            res.add(r);
            if(i + 1 < nums.length){
                solver(res, nums, i + 1, r);
            }
        }
        return res;
    }

    private void solver(List<List<Integer>> result, int[] nums, int idx, List<Integer> cur){
        for(int i = idx; i < nums.length; ++i){
            List<Integer> l = new ArrayList<Integer>(cur);
            l.add(nums[i]);
            result.add(l);
            if(i + 1 < nums.length){
                solver(result, nums, i + 1, l);
            }
        }
    }
}
