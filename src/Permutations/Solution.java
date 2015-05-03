package Permutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by haha on 2015/4/26.
 */
public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : num){
            if(map.containsKey(n)){
                map.replace(n, map.get(n) + 1);
            }else{
                map.put(n, 1);
            }
        }

        solver(result, new ArrayList<Integer>(), map);

        return result;
    }

    private void solver(List<List<Integer>> result, List<Integer> cur, HashMap<Integer, Integer> map){
        if(map.isEmpty()){
            result.add(cur);
        }else{
            for(int k : map.keySet()){
                int cnt = map.get(k);
                HashMap<Integer, Integer> m = new HashMap<Integer, Integer>(map);
                if(cnt == 1){
                    m.remove(k);
                }else{
                    m.replace(k, cnt - 1);
                }
                List<Integer> c = new ArrayList<Integer>(cur);
                c.add(k);
                solver(result, c, m);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.permute(new int[]{1,1,1});
    }
}
