package Combinations;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/4/30.
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n == 0 || k == 0 || k > n){
            res.add(null);
        }else{
            for(int i = 1; i <= n - k + 1; ++i){
                List<Integer> l = new ArrayList<Integer>();
                l.add(i);
                if(k > 1) solver(n, k - 1, i + 1, res, l);
                else res.add(l);
            }
        }
        return res;
    }

    private void solver(int n, int k, int idx, List<List<Integer>> res, List<Integer> cur){
        for(int i = idx; i <= n - k + 1; ++i){
            List<Integer> l = new ArrayList<Integer>(cur);
            l.add(i);
            if(k > 1) solver(n, k - 1, i + 1, res, l);
            else res.add(l);
        }
    }
}
