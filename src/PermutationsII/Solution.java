package PermutationsII;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;

import java.util.*;

/**
 * Created by jwhu on 4/16/15.
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0) return result;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        solve(result, new ArrayList<Integer>(), map);
        return result;
    }

    private static void solve(List<List<Integer>> result, List<Integer> cur, Map<Integer, Integer> map){
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int cInt = e.getKey();
            int remain = e.getValue() - 1;
            List<Integer> cl = new ArrayList<Integer>(cur);
            cl.add(cInt);
            if(remain == 0 && map.size() == 1){
                result.add(cl);
            }else{
                Map<Integer, Integer> cm = new HashMap<Integer, Integer>(map);
                if(remain == 0) cm.remove(cInt);
                else cm.put(cInt, remain);
                solve(result, cl, cm);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1};
        sol.permuteUnique(arr);
    }
}
