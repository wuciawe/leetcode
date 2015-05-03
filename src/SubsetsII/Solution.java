package SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by haha on 2015/4/30.
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        HashSet<List<Integer>> res = new HashSet<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        res.add(l);
        if(num.length != 0){
            for(int i = 0; i < num.length; ++i){
                l = new ArrayList<Integer>(l);
                l.add(num[i]);
                res.add(l);
                solver(res, l, num, i + 1);
            }
        }
        solver(res, new ArrayList<Integer>(), num, 0);
        return new ArrayList<List<Integer>>(res);
    }

    private void solver(HashSet<List<Integer>> result, List<Integer> cur, int[] num, int idx){
        if(idx != num.length){
            for(int i = idx; i < num.length; ++i){
                List<Integer> l = new ArrayList<Integer>(cur);
                l.add(num[i]);
                result.add(l);
                solver(result, l, num, i + 1);
            }
        }
    }
}
